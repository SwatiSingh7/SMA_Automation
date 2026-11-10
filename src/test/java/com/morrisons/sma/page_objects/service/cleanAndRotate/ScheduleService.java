package com.morrisons.sma.page_objects.service.cleanAndRotate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.morrisons.sma.pojo.service.cleanAndRotate.getSchedule.ScheduleResponse;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.util.List;

public class ScheduleService {

    private final Logger log = Logger.getLogger(ScheduleService.class);
    public static final String JSON_NODE_NAME_FOR_SCHEDULES = "schedules";

    public List<ScheduleResponse> getScheduleResponse(String jsonResponseString) {
        JSONObject responseJSONObject = new JSONObject(jsonResponseString);
        String scheduleResponse = responseJSONObject.get(JSON_NODE_NAME_FOR_SCHEDULES).toString();
        Gson gson = new Gson();
        log.info("Deserializing JSON");
        List<ScheduleResponse> scheduleResp = gson.fromJson(scheduleResponse, new TypeToken<List<ScheduleResponse>>() {
        }.getType());
        log.info("JSON Deserialized");
        return scheduleResp;
    }
}

