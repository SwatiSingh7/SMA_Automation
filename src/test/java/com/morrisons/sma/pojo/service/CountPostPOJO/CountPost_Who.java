package com.morrisons.sma.pojo.service.CountPostPOJO;

public class CountPost_Who
{
    private String empId;

    private String username;

    public String getEmpId ()
    {
        return empId;
    }

    public void setEmpId (String empId)
    {
        this.empId = empId;
    }

    public String getUsername ()
    {
        return username;
    }

    public void setUsername (String username)
    {
        this.username = username;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [empId = "+empId+", username = "+username+"]";
    }
}
