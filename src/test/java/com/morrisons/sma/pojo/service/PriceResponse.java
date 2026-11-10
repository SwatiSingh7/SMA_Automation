package com.morrisons.sma.pojo.service;
import com.morrisons.sma.pojo.service.SalesOrderServicePOJO.SalesOrder_ForecastItem;
import com.morrisons.sma.pojo.service.SalesOrderServicePOJO.SalesOrder_Metadata;
import lombok.Value;

import java.util.List;

@Value
public class PriceResponse {
    private Integer locationId;
    private String mIN;
    private Double regularPrice;
    private String effectiveDate;
    private Integer priceChangeId;
    private Integer transactionId;

    public Integer getLocationId() {
        return locationId;
    }

    public String getEffectiveDate() {return effectiveDate;
    }


    public double getRegularPrice() {return regularPrice;
    }


    @Override
    public String toString() {
        return "PriceResponse [locationId=" + locationId + ", effectiveDate=" + effectiveDate
                + ", regularPrice=" + regularPrice + "]";
    }

}
