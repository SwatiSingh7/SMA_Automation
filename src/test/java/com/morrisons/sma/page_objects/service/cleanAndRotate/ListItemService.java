package com.morrisons.sma.page_objects.service.cleanAndRotate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.morrisons.sma.pojo.service.cleanAndRotate.getListItems.ItemDetails;
import com.morrisons.sma.pojo.service.cleanAndRotate.getListItems.ItemlistResponse;
import com.morrisons.sma.pojo.service.cleanAndRotate.getSchedule.ScheduleResponse;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.util.List;

public class ListItemService {
    private final Logger log = Logger.getLogger(ListItemService.class);
    public static final String JSON_NODE_NAME_FOR_ITEMS = "itemList";

    public List<ItemDetails> getItemList(String jsonResponseString) {
        JSONObject responseJSONObject = new JSONObject(jsonResponseString);
        String items = responseJSONObject.get(JSON_NODE_NAME_FOR_ITEMS).toString();
        Gson gson = new Gson();
        log.info("Deserializing JSON");
        List<ItemDetails> itemList = gson.fromJson(items, new TypeToken<List<ItemDetails>>() {
        }.getType());
        log.info("JSON Deserialized");
        return itemList;
    }
}
