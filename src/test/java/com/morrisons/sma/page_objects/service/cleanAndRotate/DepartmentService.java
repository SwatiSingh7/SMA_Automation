package com.morrisons.sma.page_objects.service.cleanAndRotate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.morrisons.sma.pojo.service.cleanAndRotate.getDepartments.DepartmentResponse;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.util.List;

public class DepartmentService {

    private final Logger log = Logger.getLogger(DepartmentService.class);
    public static final String JSON_NODE_NAME_FOR_DEPARTMENTS = "departments";
    public List<DepartmentResponse> getDepartmentResponse(String jsonResponseString) {
        JSONObject responseJSONObject = new JSONObject(jsonResponseString);
        String departmentResponse = responseJSONObject.get(JSON_NODE_NAME_FOR_DEPARTMENTS).toString();
        Gson gson = new Gson();
        log.info("Deserializing JSON");
        List<DepartmentResponse> departmentResp = gson.fromJson(departmentResponse, new TypeToken<List<DepartmentResponse>>() {
        }.getType());
        log.info("JSON Deserialized");
        return departmentResp;
    }
}
