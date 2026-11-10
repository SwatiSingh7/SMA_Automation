package com.morrisons.sma.page_objects.service.product;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.morrisons.sma.pojo.service.product.ItemListItem;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.util.List;

public class ProductService {

    private final Logger log = Logger.getLogger(ProductService.class);
    public static final String JSON_NODE_NAME_FOR_ITEMS = "itemList";

        public List<ItemListItem> getItemListItems(String jsonResponseString) {
        JSONObject responseJSONObject = new JSONObject(jsonResponseString);
        String items = responseJSONObject.get(JSON_NODE_NAME_FOR_ITEMS).toString();
        Gson gson = new Gson();
        log.info("Deserializing JSON");
        List<ItemListItem> productList = gson.fromJson(items, new TypeToken<List<ItemListItem>>() {
        }.getType());
        log.info("JSON Deserialized");
        return productList;
    }
}
