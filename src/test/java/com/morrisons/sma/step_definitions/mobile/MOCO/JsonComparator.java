package com.morrisons.sma.step_definitions.mobile.MOCO;

import com.morrisons.sma.step_definitions.service.old.opticFocalStrategies;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class JsonComparator implements Comparator<Object> {
    public String KEY_NAME,jsonGETResponseString,sFilter1,sFilter1Val,sFilter2,sFilter2Val;

    public JsonComparator(String jsonGETResponseString, String filter1, String filter2) {
        org.json.JSONObject responseJSONObject = new org.json.JSONObject(opticFocalStrategies.jsonGETResponseString);
        String[] arrParam = filter1.split("=");
        this.sFilter1= arrParam[0];
        this.sFilter1Val = arrParam[1];
        arrParam = filter2.split("=");
        this.sFilter2= arrParam[0];
        this.sFilter2Val = arrParam[1];
        JSONArray jy = (JSONArray) responseJSONObject.get("orders");
        JSONArray sortedJsonArray = new JSONArray();
        this.KEY_NAME = sFilter1Val;
    }

    @Override
    public int compare(Object a, Object b) {
        JSONObject oJS1 = (JSONObject) a;
        JSONObject oJS2 = (JSONObject) b;
        Object oObj = oJS1.get(KEY_NAME);
        if (oObj instanceof Integer) {
            int str1 = 0;
            int str2 = 0, k;
            String str3 = null;
            String str4 = null;
//                String str1 = new String();
//                String str2 = new String();


            try {
                str1 = (int) oJS1.get(KEY_NAME);
                str2 = (int) oJS2.get(KEY_NAME);
                str3 = (String) oJS1.get("departmentName");
                str4 = (String) oJS2.get("departmentName");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (sFilter2Val.equalsIgnoreCase("asc")) {
                k = Integer.valueOf(str1).compareTo(Integer.valueOf(str2));
                if (k == 0)
                    return str3.compareTo(str4);
                else
                    return k;
            } else if (sFilter2Val.equalsIgnoreCase("desc")) {
                k = Integer.valueOf(str2).compareTo(Integer.valueOf(str1));
                if (k == 0)
                    return str4.compareTo(str3);
                else
                    return k;
            }
        } else if (oObj instanceof String) {
            String str1 = new String();
            String str2 = new String();
//                String str1 = new String();
//                String str2 = new String();
            try {
                str1 = (String) oJS1.get(KEY_NAME);
                str2 = (String) oJS2.get(KEY_NAME);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (sFilter1Val.toLowerCase().contains("date")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz");
                LocalDateTime dateTime1 = LocalDateTime.parse(str1, formatter);
                LocalDateTime dateTime2 = LocalDateTime.parse(str2, formatter);
                if (sFilter2Val.equalsIgnoreCase("asc")) {
                    return dateTime1.compareTo(dateTime2);
                } else if (sFilter2Val.equalsIgnoreCase("desc")) {
                    return dateTime2.compareTo(dateTime1);
                }
            } else {
                if (sFilter2Val.equalsIgnoreCase("asc")) {
                    return str1.compareTo(str2);
                } else if (sFilter2Val.equalsIgnoreCase("desc")) {
                    return str2.compareTo(str2);
                }
            }

        }
        return 0;
    }
}
