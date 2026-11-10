package com.morrisons.sma.page_objects.service.internalAudit;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.morrisons.sma.pojo.service.internalAudit.getOrder.ItemResponse;
import com.morrisons.sma.pojo.service.internalAudit.getOrder.Lines;
import com.morrisons.sma.pojo.service.internalAudit.getOrder.OrderDetails;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.util.List;

public class OrderService {
    private final Logger log = Logger.getLogger(OrderService.class);
    public static final String JSON_NODE_NAME_FOR_ORDERS = "orders";
    public List<OrderDetails> getItemResponse(String jsonResponseString) {
        JSONObject responseJSONObject = new JSONObject(jsonResponseString);
        String itemResponse = responseJSONObject.get(JSON_NODE_NAME_FOR_ORDERS).toString();
        Gson gson = new Gson();
        log.info("Deserializing JSON");
        List<OrderDetails> ItemResponse = gson.fromJson(itemResponse, new TypeToken<List<OrderDetails>>() {
        }.getType());
        log.info("JSON Deserialized");
        return ItemResponse;
    }
}
