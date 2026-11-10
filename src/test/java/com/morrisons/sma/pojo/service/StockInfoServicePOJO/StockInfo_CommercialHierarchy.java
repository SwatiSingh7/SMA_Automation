package com.morrisons.sma.pojo.service.StockInfoServicePOJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class StockInfo_CommercialHierarchy {
	@JsonIgnoreProperties(ignoreUnknown=true)
	private String division;
	@JsonIgnoreProperties(ignoreUnknown=true)
    private String departmentName;
	@JsonIgnoreProperties(ignoreUnknown=true)
    private String groupName;
	@JsonIgnoreProperties(ignoreUnknown=true)
    private String divisionName;
	@JsonIgnoreProperties(ignoreUnknown=true)
    private String subclass;

    private String class_;

    private String className;

    private String subclassName;

    private String department;

    private String group;

    public String getDivision ()
    {
        return division;
    }

    public void setDivision (String division)
    {
        this.division = division;
    }

    public String getDepartmentName ()
    {
        return departmentName;
    }

    public void setDepartmentName (String departmentName)
    {
        this.departmentName = departmentName;
    }

    public String getGroupName ()
    {
        return groupName;
    }

    public void setGroupName (String groupName)
    {
        this.groupName = groupName;
    }

    public String getDivisionName ()
    {
        return divisionName;
    }

    public void setDivisionName (String divisionName)
    {
        this.divisionName = divisionName;
    }

    public String getSubclass ()
    {
        return subclass;
    }

    public void setSubclass (String subclass)
    {
        this.subclass = subclass;
    }

    public String getClass_ ()
    {
        return class_;
    }

    public void setClass_ (String class_)
    {
        this.class_ = class_;
    }

    public String getClassName ()
    {
        return className;
    }

    public void setClassName (String className)
    {
        this.className = className;
    }

    public String getSubclassName ()
    {
        return subclassName;
    }

    public void setSubclassName (String subclassName)
    {
        this.subclassName = subclassName;
    }

    public String getDepartment ()
    {
        return department;
    }

    public void setDepartment (String department)
    {
        this.department = department;
    }

    public String getGroup ()
    {
        return group;
    }

    public void setGroup (String group)
    {
        this.group = group;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [division = "+division+", departmentName = "+departmentName+", groupName = "+groupName+", divisionName = "+divisionName+", subclass = "+subclass+", class_ = "+class_+", className = "+className+", subclassName = "+subclassName+", department = "+department+", group = "+group+"]";
    }
	
	
}
