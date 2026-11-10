package com.morrisons.sma.pojo.service.PricePrompPOJO;

public class PrintedMarkdownEvents
{
    private String id;

    private String categoryId;

    private String markedDownPrice;

    private String percentageMarkdown;

    private String markdownCreatedDate;

    private String quantity;

    private String departmentId;

    private String markdownBarcode;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getCategoryId ()
    {
        return categoryId;
    }

    public void setCategoryId (String categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getMarkedDownPrice ()
    {
        return markedDownPrice;
    }

    public void setMarkedDownPrice (String markedDownPrice)
    {
        this.markedDownPrice = markedDownPrice;
    }

    public String getPercentageMarkdown ()
    {
        return percentageMarkdown;
    }

    public void setPercentageMarkdown (String percentageMarkdown)
    {
        this.percentageMarkdown = percentageMarkdown;
    }

    public String getMarkdownCreatedDate ()
    {
        return markdownCreatedDate;
    }

    public void setMarkdownCreatedDate (String markdownCreatedDate)
    {
        this.markdownCreatedDate = markdownCreatedDate;
    }

    public String getQuantity ()
    {
        return quantity;
    }

    public void setQuantity (String quantity)
    {
        this.quantity = quantity;
    }

    public String getDepartmentId ()
    {
        return departmentId;
    }

    public void setDepartmentId (String departmentId)
    {
        this.departmentId = departmentId;
    }

    public String getMarkdownBarcode ()
    {
        return markdownBarcode;
    }

    public void setMarkdownBarcode (String markdownBarcode)
    {
        this.markdownBarcode = markdownBarcode;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", categoryId = "+categoryId+", markedDownPrice = "+markedDownPrice+", percentageMarkdown = "+percentageMarkdown+", markdownCreatedDate = "+markdownCreatedDate+", quantity = "+quantity+", departmentId = "+departmentId+", markdownBarcode = "+markdownBarcode+"]";
    }
}
