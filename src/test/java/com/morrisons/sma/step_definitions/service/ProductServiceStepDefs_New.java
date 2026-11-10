package com.morrisons.sma.step_definitions.service;

import com.google.inject.Inject;
import com.morrisons.common.utility.ApplicationContext;
import com.morrisons.common.utility.WebServicesUtilities;
import com.morrisons.sma.page_objects.service.internalAudit.SingleProductService;
import com.morrisons.sma.page_objects.service.product.ProductService;
import com.morrisons.sma.pojo.service.product.ItemListItem;
import com.morrisons.sma.pojo.service.product.PacksItem;
import io.cucumber.java.en.Given;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class ProductServiceStepDefs_New {

    public static final String PRODUCT_SERVICE_BASE_URL = "https://sit-api.morrisons.com/product/v1";

    private static final Logger log = Logger.getLogger(ProductServiceStepDefs_New.class);
    private final ApplicationContext applicationContext;
    public static String accessToken = "QUd5UVpGVUdEMUNwWTAyOGVHR2FGV2FNcmQ0VkJqVmY6Vzl5Z1lmR0FwaWptUTdBbQ==";
    public String itemId = null;
    public static int packQuantity;

    @Inject
    public ProductServiceStepDefs_New(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Given("I get the product details")
    public void iGetTheProductDetails() throws IOException, InterruptedException {
        log.info("Getting Response for " + PRODUCT_SERVICE_BASE_URL + "/items/");
        String jsonResponseString = WebServicesUtilities.retryGETRequest(PRODUCT_SERVICE_BASE_URL, "/items/", "apikey", "AGyQZFUGD1CpY028eGGaFWaMrd4VBjVf");
/*        Response response = RestAssured.given().
                header("Authorization", "Basic QUd5UVpGVUdEMUNwWTAyOGVHR2FGV2FNcmQ0VkJqVmY6Vzl5Z1lmR0FwaWptUTdBbQ==").
                queryParam("apikey", "AGyQZFUGD1CpY028eGGaFWaMrd4VBjVf").
                get(PRODUCT_SERVICE_BASE_URL + "/items/").
                then().extract().response();*/
/*        log.info("Successful");
        String jsonResponseString = response.getBody().jsonPath().prettify();
        log.info("Response : " + jsonResponseString);*/
        List<ItemListItem> productList = new ProductService().getItemListItems(jsonResponseString);
        log.info("No. Of Items : " + productList.size());
        for (ItemListItem product :
                productList) {
            if (product.getGtins().size() != 0)
                log.info("Barcode Type : " + product.getGtins().get(0).getType());
            log.info("Division Name : " + product.getCommercialHierarchy().getDivisionName());
            log.info("Standard Unit Of Measurement : " + product.getStandardUnitOfMeasure());
            log.info("Quantity : " + product.getPacks().get(0).getPackQuantity());
        }
    }

    public  void iGetTheSingleProductDetails(String prodMin) throws IOException, InterruptedException {
        String itemId = prodMin;

        log.info("Getting Response for " + PRODUCT_SERVICE_BASE_URL + "/items/" + itemId);
        String jsonResponseString = WebServicesUtilities.retryGETRequest(PRODUCT_SERVICE_BASE_URL, "/items/" + itemId, "apikey", "AGyQZFUGD1CpY028eGGaFWaMrd4VBjVf", "Authorization", "Basic " + accessToken);

        List<PacksItem> singleProductList = new SingleProductService().getSingleItemList(jsonResponseString);
        for (PacksItem product :
                singleProductList) {
            packQuantity = product.getPackQuantity();
            log.info("Pack Quantity --------------------: " + packQuantity);
        }
    }


/*    private List<ItemListItem> getItemListItems(String jsonResponseString) {
        JSONObject responseJSONObject = new JSONObject(jsonResponseString);
        String items = responseJSONObject.get(JSON_NODE_NAME_FOR_ITEMS).toString();
        Gson gson = new Gson();
        log.info("Deserializing JSON");
        List<ItemListItem> productList = gson.fromJson(items, new TypeToken<List<ItemListItem>>() {
        }.getType());
        log.info("JSON Deserialized");
        return productList;
    }*/

}
