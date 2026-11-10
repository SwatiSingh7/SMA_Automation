package com.morrisons.sma.page_objects.service.price;

import com.google.gson.Gson;

import com.morrisons.common.utility.ApplicationContext;
import com.morrisons.common.utility.WebServicesUtilities;
import com.morrisons.sma.pojo.service.PriceResponse;
//import com.morrisons.sma.pojo.service.PromptedCount_NewService.PriceResponse;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.util.Iterator;



public class PriceService {

    private final Logger log = Logger.getLogger(PriceService.class);
    public static final String JSON_NODE_NAME_FOR_PRICE= "price";

    public PriceResponse getPriceResponse(String jsonResponseString) {
        JSONObject responseJSONObject = new JSONObject(jsonResponseString);
        String priceItems = responseJSONObject.get(JSON_NODE_NAME_FOR_PRICE).toString();
//        Iterator iTeKeyset = responseJSONObject.keySet().iterator();
//        while (iTeKeyset.hasNext()) {
//            String sKey = iTeKeyset.next().toString();
//            System.out.println(sKey);
//            System.out.println(responseJSONObject.get(sKey));
//        }

        log.info("items-----------------"+priceItems);

        Gson gson = new Gson();
        log.info("Deserializing JSON==================================");
        PriceResponse priceResponseList = gson.fromJson(priceItems,PriceResponse.class);
        log.info("JSON Deserialized");
        return priceResponseList;
    }


}
