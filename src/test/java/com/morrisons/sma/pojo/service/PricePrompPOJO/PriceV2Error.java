package com.morrisons.sma.pojo.service.PricePrompPOJO;

public class PriceV2Error
{
    private String errorMessage;

    private String errorMoreInfo;

    private String errorCode;

    private String httpResponseCode;

    public String getErrorMessage ()
    {
        return errorMessage;
    }

    public void setErrorMessage (String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    public String getErrorMoreInfo ()
    {
        return errorMoreInfo;
    }

    public void setErrorMoreInfo (String errorMoreInfo)
    {
        this.errorMoreInfo = errorMoreInfo;
    }

    public String getErrorCode ()
    {
        return errorCode;
    }

    public void setErrorCode (String errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getHttpResponseCode ()
    {
        return httpResponseCode;
    }

    public void setHttpResponseCode (String httpResponseCode)
    {
        this.httpResponseCode = httpResponseCode;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [errorMessage = "+errorMessage+", errorMoreInfo = "+errorMoreInfo+", errorCode = "+errorCode+", httpResponseCode = "+httpResponseCode+"]";
    }
}
	