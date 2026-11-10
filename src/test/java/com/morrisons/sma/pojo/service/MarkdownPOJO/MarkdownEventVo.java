package com.morrisons.sma.pojo.service.MarkdownPOJO;


public class MarkdownEventVo
{
    private String product;

    private String[] markdownPercentages;

    private String[] printedMarkdownEvents;

    private String markdownType;

    private String location;

    private UnprintedMarkdownEvent unprintedMarkdownEvent;

    private MarkdownCap markdownCap;

    public String getProduct ()
    {
        return product;
    }

    public void setProduct (String product)
    {
        this.product = product;
    }

    public String[] getMarkdownPercentages ()
    {
        return markdownPercentages;
    }

    public void setMarkdownPercentages (String[] markdownPercentages)
    {
        this.markdownPercentages = markdownPercentages;
    }

    public String[] getPrintedMarkdownEvents ()
    {
        return printedMarkdownEvents;
    }

    public void setPrintedMarkdownEvents (String[] printedMarkdownEvents)
    {
        this.printedMarkdownEvents = printedMarkdownEvents;
    }

    public String getMarkdownType ()
    {
        return markdownType;
    }

    public void setMarkdownType (String markdownType)
    {
        this.markdownType = markdownType;
    }

    public String getLocation ()
    {
        return location;
    }

    public void setLocation (String location)
    {
        this.location = location;
    }

    public UnprintedMarkdownEvent getUnprintedMarkdownEvent ()
    {
        return unprintedMarkdownEvent;
    }

    public void setUnprintedMarkdownEvent (UnprintedMarkdownEvent unprintedMarkdownEvent)
    {
        this.unprintedMarkdownEvent = unprintedMarkdownEvent;
    }

    public MarkdownCap getMarkdownCap ()
    {
        return markdownCap;
    }

    public void setMarkdownCap (MarkdownCap markdownCap)
    {
        this.markdownCap = markdownCap;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [product = "+product+", markdownPercentages = "+markdownPercentages+", printedMarkdownEvents = "+printedMarkdownEvents+", markdownType = "+markdownType+", location = "+location+", unprintedMarkdownEvent = "+unprintedMarkdownEvent+", markdownCap = "+markdownCap+"]";
    }
}