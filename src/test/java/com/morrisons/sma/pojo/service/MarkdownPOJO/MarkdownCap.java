package com.morrisons.sma.pojo.service.MarkdownPOJO;

public class MarkdownCap
{
    private String capTime;

    private String percentageCap;

    public String getCapTime ()
    {
        return capTime;
    }

    public void setCapTime (String capTime)
    {
        this.capTime = capTime;
    }

    public String getPercentageCap ()
    {
        return percentageCap;
    }

    public void setPercentageCap (String percentageCap)
    {
        this.percentageCap = percentageCap;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [capTime = "+capTime+", percentageCap = "+percentageCap+"]";
    }
}