package com.morrisons.sma.pojo.service.MarkdownPOJO;

import java.util.List;

import com.morrisons.sma.pojo.service.PricePrompPOJO.PrintedMarkdownEvents;
import com.morrisons.sma.pojo.service.PricePrompPOJO.Product;


public class MarkdownVO
{
    private Product product;

    private List<Markdown_MarkdownPercentage> markdownPercentages;

    private String firstMarkdownWindow;
    
    private List<PrintedMarkdownEvents> printedMarkdownEvents;

    private String markdownType;

    private String location;

    private UnprintedMarkdownEvent unprintedMarkdownEvent;

    private MarkdownCap markdownCap;
    
    private String isRestrictedDepartment;

  
    
    
    
    public Product getProduct ()
    {
        return product;
    }

    public void setProduct (Product product)
    {
        this.product = product;
    }

    public List<Markdown_MarkdownPercentage> getMarkdownPercentages ()
    {
        return markdownPercentages;
    }

    public void setMarkdownPercentages (List<Markdown_MarkdownPercentage> markdownPercentages)
    {
        this.markdownPercentages = markdownPercentages;
    }

    public List<PrintedMarkdownEvents> getPrintedMarkdownEvents ()
    {
        return printedMarkdownEvents;
    }

    public void setPrintedMarkdownEvents (List<PrintedMarkdownEvents> printedMarkdownEvents)
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

    
    
    public String getIsRestrictedDepartment() {
		return isRestrictedDepartment;
	}

	public void setIsRestrictedDepartment(String isRestrictedDepartment) {
		this.isRestrictedDepartment = isRestrictedDepartment;
	}

	
	
	
	public String getFirstMarkdownWindow() {
		return firstMarkdownWindow;
	}

	public void setFirstMarkdownWindow(String firstMarkdownWindow) {
		this.firstMarkdownWindow = firstMarkdownWindow;
	}

	@Override
	public String toString() {
		return "MarkdownVO [product=" + product + ", markdownPercentages=" + markdownPercentages
				+ ", firstMarkdownWindow=" + firstMarkdownWindow + ", printedMarkdownEvents=" + printedMarkdownEvents
				+ ", markdownType=" + markdownType + ", location=" + location + ", unprintedMarkdownEvent="
				+ unprintedMarkdownEvent + ", markdownCap=" + markdownCap + ", isRestrictedDepartment="
				+ isRestrictedDepartment + "]";
	}

	
	
}