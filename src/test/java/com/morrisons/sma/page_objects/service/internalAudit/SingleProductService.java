package com.morrisons.sma.page_objects.service.internalAudit;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.morrisons.sma.pojo.service.product.ItemListItem;
import com.morrisons.sma.pojo.service.product.PacksItem;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.util.List;

public class SingleProductService {
    private final Logger log = Logger.getLogger(SingleProductService.class);
    public static final String JSON_NODE_NAME_FOR_SINGLE_ITEM = "packs";

    public List<PacksItem> getSingleItemList(String jsonResponseString) {
        JSONObject responseJSONObject = new JSONObject(jsonResponseString);
        String items = responseJSONObject.get(JSON_NODE_NAME_FOR_SINGLE_ITEM).toString();
        log.info("items---------------------------------------"+items);
        Gson gson = new Gson();
        log.info("Deserializing JSON");
        List<PacksItem> productList = gson.fromJson(items, new TypeToken<List<PacksItem>>() {
        }.getType());
        log.info("JSON Deserialized");
        return productList;
    }
}
