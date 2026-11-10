package com.morrisons.sma.pojo.service.getLogin;

import lombok.Value;

@Value
public class LoginResponse {
    private String userId;
    private String forename;
    private String surname;
    private String roleCode;
    private Object locationId;
    private Integer passwordDaysRemaining;
    private String accessToken;
    private String tokenType;
}
