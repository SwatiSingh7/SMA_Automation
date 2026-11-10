package com.morrisons.sma.step_definitions.service.cleanAndRotate;

import com.google.inject.Inject;
import com.morrisons.common.utility.ApplicationContext;
import com.morrisons.common.utility.WebServicesUtilities;
import com.morrisons.sma.page_objects.mobile.cleanAndRotate.DepartmentDetails;
import com.morrisons.sma.page_objects.service.StorewalkServicePage;
import com.morrisons.sma.page_objects.service.cleanAndRotate.ListItemService;
import com.morrisons.sma.pojo.service.cleanAndRotate.getListItems.ItemDetails;
import com.morrisons.sma.step_definitions.service.Login.LoginStepDef;
import io.cucumber.java.en.Given;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class ItemServiceStepDef {

    public static final String ListItem_SERVICE_BASE_URL = "https://sit-api.morrisons.com/cleanrotate/v1/";
    private final Logger log = Logger.getLogger(ItemServiceStepDef.class);
    private final ApplicationContext applicationContext;
    public static String actionName = null, itemDescription = null, itemNumber, actionPerformed, departmentNumber;
    public static int quantity = 0;

    @Inject
    public ItemServiceStepDef(ApplicationContext applicationContext) {

        this.applicationContext = applicationContext;
    }

    @Given("I get the item details through API")
    public void iGetTheItemDetails() throws Throwable {
        log.info("Getting Response for " + ListItem_SERVICE_BASE_URL + "/locations/" + ApplicationContext.STORE_ID + "/departments/");
//        String accessToken = LoginStepDef.accessToken;
        StorewalkServicePage oStrWalkser = new StorewalkServicePage();
        String accessToken = oStrWalkser.getGeneratedAccessTokenAppLogin();
        log.info("accessToken-----------------" + accessToken);
        String deptCheckID = DepartmentServiceStepDef.departmentCheckId;
        log.info("Department check Id : " + deptCheckID);
        String jsonResponseString = WebServicesUtilities.retryGETRequestWithHeader(ListItem_SERVICE_BASE_URL, "locations/" + ApplicationContext.STORE_ID + "/departments/" + deptCheckID + "/items", "apikey", "ZwQGsEN0f65kORZ8EVQlJWA2bGNbHls0", "Authorization", "Bearer " + accessToken);

        List<ItemDetails> itemList = new ListItemService().getItemList(jsonResponseString);

        log.info("No. Of Items : " + itemList.size());
        log.info("DepartmentDetails.productMinvalue)---------" + DepartmentDetails.productMinvalue);

        for (int index = 0; index <= itemList.size() - 1; index++) {
            if (itemList.get(index).getItemNumber().equalsIgnoreCase(DepartmentDetails.productMinvalue)) {
                itemNumber = itemList.get(index).getItemNumber();
                log.info("Item Number :" + itemNumber);

                itemDescription = itemList.get(index).getItemDescription();
                log.info("Item Description :" + itemDescription);

                quantity = itemList.get(0).getQuantity();
                log.info("Quantity : " + quantity);

                actionName = itemList.get(0).getActionName();
                log.info("Action Name : " + actionName);

                departmentNumber = itemList.get(0).getDepartmentName();
                log.info("Department Number : " + departmentNumber);

                actionPerformed = itemList.get(0).getActionPerformed();
                log.info("Action Performed :" + actionPerformed);
            }
        }
    }
}