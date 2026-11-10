package com.morrisons.sma.page_objects.service.countOptimisation;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.morrisons.sma.pojo.service.countOptimization.getStorewalkUAT.Storewalk;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.util.List;

public class StoreWalkServiceResponseDeserialization {

    private final Logger log = Logger.getLogger(StoreWalkServiceResponseDeserialization.class);
    public static final String JSON_NODE_NAME_FOR_STOREWALKS = "storewalks";
    public List<Storewalk> getWalkidResponse(String jsonResponseString) {
        JSONObject responseJSONObject = new JSONObject(jsonResponseString);
        String getWalkResponse = responseJSONObject.get(JSON_NODE_NAME_FOR_STOREWALKS).toString();
        //log.info("before serialization-----------------"+getWalkResponse);
        Gson gson = new Gson();
        log.info("Deserializing JSON");
        List<Storewalk> walkidResp = gson.fromJson(getWalkResponse, new TypeToken<List<Storewalk>>() {
        }.getType());
        log.info("JSON Deserialized");
       // log.info("walkidResp-----------------"+walkidResp);

        return walkidResp;
    }
}
