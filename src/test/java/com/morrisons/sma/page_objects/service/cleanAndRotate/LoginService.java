package com.morrisons.sma.page_objects.service.cleanAndRotate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.morrisons.sma.page_objects.service.product.ProductService;
import com.morrisons.sma.pojo.service.cleanAndRotate.getSchedule.ScheduleResponse;
import com.morrisons.sma.pojo.service.cleanAndRotate.login.LoginResponse;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.util.List;

public class LoginService {
    private final Logger log = Logger.getLogger(ProductService.class);
    public static final String JSON_NODE_NAME_FOR_ITEMS = "loginList";

    public List<LoginResponse> getLoginList(String jsonResponseString) {
        JSONObject responseJSONObject = new JSONObject(jsonResponseString);
        String items = responseJSONObject.get(JSON_NODE_NAME_FOR_ITEMS).toString();
        Gson gson = new Gson();
        log.info("Deserializing JSON");
        List<LoginResponse> scheduleList = gson.fromJson(items, new TypeToken<List<LoginResponse>>() {
        }.getType());
        log.info("JSON Deserialized");
        return scheduleList;
    }
}
