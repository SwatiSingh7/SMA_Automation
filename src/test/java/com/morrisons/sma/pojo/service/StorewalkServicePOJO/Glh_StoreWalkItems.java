package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class Glh_StoreWalkItems
{
    private String storenumber;

    private String walktype;

	@JsonProperty("items")
	private List<Glh_Items> items = new ArrayList<>();
   

    private String walkid;

    public String getStorenumber ()
    {
        return storenumber;
    }

    public void setStorenumber (String storenumber)
    {
        this.storenumber = storenumber;
    }

    public String getWalktype ()
    {
        return walktype;
    }

    public void setWalktype (String walktype)
    {
        this.walktype = walktype;
    }

  

    public String getWalkid ()
    {
        return walkid;
    }

    public void setWalkid (String walkid)
    {
        this.walkid = walkid;
    }

	public List<Glh_Items> getItems() {
		return items;
	}

	public void setItems(List<Glh_Items> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "StoreWalkItems [storenumber=" + storenumber + ", walktype=" + walktype + ", items=" + items
				+ ", walkid=" + walkid + "]";
	}

	
   
}