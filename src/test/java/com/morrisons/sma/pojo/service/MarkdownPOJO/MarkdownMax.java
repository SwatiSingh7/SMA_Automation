package com.morrisons.sma.pojo.service.MarkdownPOJO;

public class MarkdownMax
{
    private String errorMessage;

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
        return "ClassPojo [errorMessage = "+errorMessage+", errorCode = "+errorCode+", httpResponseCode = "+httpResponseCode+"]";
    }
}
