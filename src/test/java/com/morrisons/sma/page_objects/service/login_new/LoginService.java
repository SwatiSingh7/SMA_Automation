package com.morrisons.sma.page_objects.service.login_new;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.morrisons.sma.pojo.service.getLogin.LoginResponse;
import org.apache.log4j.Logger;
import org.json.JSONObject;

public class LoginService {
    private final Logger log = Logger.getLogger(LoginService.class);
    public String accessToken;

    public LoginResponse getLoginResponse(String jsonResponseString) {
        JSONObject responseJSONObject = new JSONObject(jsonResponseString);
        String loginResponse = responseJSONObject.toString();
        Gson gson = new Gson();
        log.info("Deserializing JSON");
        LoginResponse loginResp = gson.fromJson(loginResponse, new TypeToken<LoginResponse>() {
        }.getType());
        log.info("JSON Deserialized");
        return loginResp;
    }
}
