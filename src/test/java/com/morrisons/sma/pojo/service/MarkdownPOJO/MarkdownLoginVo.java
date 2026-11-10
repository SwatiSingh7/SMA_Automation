package com.morrisons.sma.pojo.service.MarkdownPOJO;

public class MarkdownLoginVo
{
    private String tokenType;

    private String accessToken;

    private String forename;

    private String userId;

    private String locationId;

    private String surname;

    private String roleCode;

    private String passwordDaysRemaining;

    public String getTokenType ()
    {
        return tokenType;
    }

    public void setTokenType (String tokenType)
    {
        this.tokenType = tokenType;
    }

    public String getAccessToken ()
    {
        return accessToken;
    }

    public void setAccessToken (String accessToken)
    {
        this.accessToken = accessToken;
    }

    public String getForename ()
    {
        return forename;
    }

    public void setForename (String forename)
    {
        this.forename = forename;
    }

    public String getUserId ()
    {
        return userId;
    }

    public void setUserId (String userId)
    {
        this.userId = userId;
    }

    public String getLocationId ()
    {
        return locationId;
    }

    public void setLocationId (String locationId)
    {
        this.locationId = locationId;
    }

    public String getSurname ()
    {
        return surname;
    }

    public void setSurname (String surname)
    {
        this.surname = surname;
    }

    public String getRoleCode ()
    {
        return roleCode;
    }

    public void setRoleCode (String roleCode)
    {
        this.roleCode = roleCode;
    }

    public String getPasswordDaysRemaining ()
    {
        return passwordDaysRemaining;
    }

    public void setPasswordDaysRemaining (String passwordDaysRemaining)
    {
        this.passwordDaysRemaining = passwordDaysRemaining;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [tokenType = "+tokenType+", accessToken = "+accessToken+", forename = "+forename+", userId = "+userId+", locationId = "+locationId+", surname = "+surname+", roleCode = "+roleCode+", passwordDaysRemaining = "+passwordDaysRemaining+"]";
    }
}