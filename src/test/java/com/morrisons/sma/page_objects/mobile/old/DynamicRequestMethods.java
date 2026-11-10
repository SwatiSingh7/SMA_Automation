package com.morrisons.sma.page_objects.mobile.old;

import com.morrisons.common.utility.ApplicationContext;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.NoSuchSessionException;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class DynamicRequestMethods {

    private static Object value;
    static String sSubrespKey = "", sItemKey = "";
    static String[] arrsRespKey = new String[0];
    static String[] arrsRespKey1 = new String[0];;
    public static org.json.simple.JSONObject UpdateRequestbody(String sReqData, Object objectJSON) {
        Object oObj = objectJSON;
        String sKey;
        String[] NoOfData = sReqData.split(",");
        JSONObject jsonObject = null;
        Object obj = null;
        for (int iCtr = 0; iCtr < NoOfData.length; iCtr++) {
            String[] arrData = NoOfData[iCtr].split("=");
            String sData = arrData[0];
            String sDataVal = arrData[1];
            if (sDataVal.equalsIgnoreCase("getFromResponse")) {
                sDataVal = ApplicationContext.oKeyField.get(sData);
            }
            if (sDataVal.equalsIgnoreCase("GetLocation")) {
                sDataVal = ApplicationContext.STORE_ID;
            }
            if (sDataVal.equalsIgnoreCase("getUnique7Digit")) {
                int min = 1000000;
                int max = 9999999;
                int UnqId = (int) (Math.random() * (max - min + 1) + min);
                sDataVal = String.valueOf(UnqId);
            }
            if (sDataVal.equalsIgnoreCase("getUnique8Digit")) {
                int min = 10000000;
                int max = 99999999;
                int UnqId = (int) (Math.random() * (max - min + 1) + min);
                sDataVal = String.valueOf(UnqId);
            }
            if (sDataVal.equalsIgnoreCase("getCurrentDate")) {
                DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
                String time = formatter.format(new Date());
                System.out.println(time);
                DateFormat formatter1 = new SimpleDateFormat("hh:mm:sss");
                String time1 = formatter1.format(new Date());
                System.out.println(time1);
                LocalDate currentDate = LocalDate.now();
                System.out.println(currentDate);
                LocalDateTime currentDate1 = LocalDateTime.now();
                System.out.println(currentDate1);
                if(sData.equalsIgnoreCase("orderedDate")){
                sDataVal = String.valueOf(currentDate + " " + time1);
            }
                else{
                    sDataVal = String.valueOf(currentDate + " " + time);
                }
            }

            if (sDataVal.contains("runtimedate")) {
                if(sDataVal.contains("runtimedate")){
                    LocalDateTime currentDate = LocalDateTime.now();
                    LocalDateTime dd;
                    String[] sParam = new String[]{};
                    String sParamVal;
                    if(sDataVal.contains("-")){
                        sParam = sDataVal.split("-");
                        sParamVal = sParam[1];
                        sDataVal = sParam[0];
                        dd = currentDate.minusDays(Long.parseLong(sParamVal));
                    }
                    if(sDataVal.contains("+")){
                        sParam = sDataVal.split("[+]");
                        sParamVal = sParam[1];
                        sDataVal = sParam[0];
                        dd = currentDate.plusDays(Long.parseLong(sParamVal));
                    }
                    else {
                        dd = currentDate;
                    }
                    sDataVal = dd.toString() + "Z";
                }
            }
            obj = objectJSON;
            traverse(objectJSON, sData, sDataVal);
        }
        return (JSONObject) obj;
    }
    public static JSONObject createDynamicRequest(String sReqData, JSONObject objectJSON) {
        String[] NoOfData = sReqData.split(",");
        JSONObject jsonObject = null;
        for (int iCtr = 0; iCtr < NoOfData.length; iCtr++) {
            String[] arrData = NoOfData[iCtr].split("=");
            String sData = arrData[0];
            String sDataVal = arrData[1];
            if(sDataVal.equalsIgnoreCase("getFromResponse")){
                sDataVal = ApplicationContext.oKeyField.get(sData);
            }
            if (sDataVal.equalsIgnoreCase("GetLocation")) {
                sDataVal = ApplicationContext.STORE_ID;
            }
            if(sDataVal.equalsIgnoreCase("getUnique7Digit")){
                int min = 1000000;
                int max = 9999999;
                int UnqId = (int) (Math.random()*(max-min+1)+min);
                sDataVal = String.valueOf(UnqId);
            }
            if(sDataVal.equalsIgnoreCase("getUnique8Digit")){
                int min = 10000000;
                int max = 99999999;
                int UnqId = (int) (Math.random()*(max-min+1)+min);
                sDataVal = String.valueOf(UnqId);
            }
            if(sDataVal.equalsIgnoreCase("getCurrentDate")){
                DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
                String time = formatter.format(new Date());
                System.out.println(time);
                LocalDate currentDate = LocalDate.now();
                LocalDateTime currentDate1 = LocalDateTime.now();
                System.out.println(currentDate1);
                sDataVal = String.valueOf(currentDate1+"Z");
            }
            Object obj = objectJSON;
            JSONArray arrjsonObject1;
            jsonObject = objectJSON;
            //System.out.println(jsonObject);
            JSONObject jsonObject1 = null;
            int iSize = jsonObject.entrySet().size();
            String newxmlInput = null, sChildKey;
            //System.out.println(iSize);
            Object oObj;
            Iterator iTeKeysetChld;
            Iterator iTeKeyset = jsonObject.keySet().iterator();
            String sKey;
            int FieldIndxCtr;
            Integer Field_Indx1;
            Integer iFieldIndxCtr = null;
            HashMap oRequestField = new LinkedHashMap();
            int j = 0, sTot = jsonObject.keySet().size();

                try {
                    while (iTeKeyset.hasNext()) {
                        sKey = iTeKeyset.next().toString();
                        //System.out.println(sKey);
                        oObj = jsonObject.get(sKey);
                        if (sKey.equalsIgnoreCase(sData)) {
                            jsonObject.put(sKey, sDataVal);
                            oRequestField.put(sKey, sDataVal);
                        }
                        if (oObj instanceof JSONObject) {
                            jsonObject1 = (JSONObject) jsonObject.get(sKey);
                            oRequestField.put(sKey, jsonObject1);
                            iTeKeysetChld = jsonObject1.keySet().iterator();
                            while (iTeKeysetChld.hasNext()) {
                                sChildKey = iTeKeysetChld.next().toString();
                                //System.out.println(sChildKey);
                                //System.out.println(jsonObject1.get(sChildKey));
                                if (null != jsonObject1) {
                                    if (jsonObject1.keySet().toString().toLowerCase().contains(sData.toLowerCase())) {
                                        String sKeyStr = null;
                                        Iterator itt = jsonObject1.keySet().iterator();
                                        while (itt.hasNext()) {
                                            sKeyStr = itt.next().toString();
                                            if (sKeyStr.equalsIgnoreCase(sData)) {
                                                break;
                                            }
                                        }
                                        //newxmlInput = xmlInput.toString().replaceAll((String) jsonObject1.get(sReqKeyData), sreqData);

                                        jsonObject1.put(sKeyStr, sDataVal);
                                        //===================================================
                                        jsonObject.put(sChildKey, jsonObject1.get(sChildKey));
                                        oRequestField.put(sChildKey, jsonObject1.get(sChildKey));
                                    }
                                }
                            }
                        } else if (oObj instanceof JSONArray) {
                            JSONArray arrjsonObject2 = new JSONArray();
                            arrjsonObject1 = (JSONArray) jsonObject.get(sKey);
                            for (int i = 0; i < arrjsonObject1.size(); i++) {
                                //System.out.println(arrjsonObject1.get(i));
                                //=====================================================
                                JSONObject JSO = null;
                                if (arrjsonObject1.toString().contains(sData)) {
                                    JSO = null;
                                    for (int w = 0; w < arrjsonObject1.size(); w++) {
                                        JSO = (JSONObject) arrjsonObject1.get(w);
                                        if (JSO.toString().contains(sData)) {
                                            String sKeyStr = null, sItemStr = null;
                                            Iterator itt = JSO.keySet().iterator();
                                            sKeyStr = itt.next().toString();
                                            traverse(JSO,sData, sDataVal);

                                        }
                                    }
                                    arrjsonObject2.add(JSO);         //====================================================
                                    jsonObject.put(sKey, arrjsonObject2);
                                    oRequestField.put(sKey, arrjsonObject1.get(i));
                                }
                            }
                        } else {
                            //System.out.println(sKey);
                            //System.out.println(jsonObject.get(sKey));
                            oRequestField.put(sKey, jsonObject.get(sKey));
                        }
                    }
                } catch (Exception e) {
System.out.println(e);
                }
                j++;

            Set<String> ss = oRequestField.keySet();
            Iterator iKey = ss.iterator();
            Set<String> ii = oRequestField.entrySet();
            Iterator iItem = ii.iterator();
            for (int k = 0; k < oRequestField.size(); k++) {
                System.out.println(iKey.next());
                System.out.println(iItem.next());
            }
        }
        return jsonObject;
    }

    private static int traverse(Object oJSO, String sData, String sDataVal) {
            String sKey;
            if(oJSO instanceof Map.Entry){
                Map.Entry JSO1 = (Map.Entry) oJSO;
                if (JSO1.toString().contains(sData) ) {
                    if (JSO1.toString().contains(sData)) {
                        sKey = (String) JSO1.getKey();
                         Object oJsonObj = JSO1.getValue();
                        traverse(oJsonObj,sData,sDataVal);
                    }
                }
            }
            else if(oJSO instanceof JSONArray){
                JSONArray JSO1 = (JSONArray) oJSO;
                for(int i=0;i<JSO1.size();i++){
                    if(JSO1.get(i).toString().contains(sData)) {
                        Object oJsonArrayObj = JSO1.get(i);
                        traverse(oJsonArrayObj, sData, sDataVal);
                    }
                }
            }
            else if(oJSO instanceof JSONObject){
                JSONObject JSO1 = (JSONObject) oJSO;
                Iterator itt2 = JSO1.keySet().iterator();
                Iterator itt3 = JSO1.entrySet().iterator();
                while (itt2.hasNext()) {
                    Object oItem = itt3.next();
                    sKey = itt2.next().toString();
                    if(sKey.toString().equalsIgnoreCase(sData) ||oItem.toString().contains(sData)) {
                        Object oJSONObject = oItem;
                        if(sKey.toString().equalsIgnoreCase(sData)){
                            JSO1.put(sKey, sDataVal);
                            return 0;
                        }
                        else {
                            traverse(oJSONObject, sData, sDataVal);
                        }
                    }
                }

            }
            return 0;
    }

    public static LinkedHashMap<String, String> getResponseData(String jsonGETResponseString, ArrayList arrRespKey) throws ParseException {
        ArrayList<String> arrList = new ArrayList<String>();
        HashMap oRequestField = null;
        LinkedHashMap oRF = new LinkedHashMap();
        for (int iCtr = 0; iCtr < arrRespKey.size(); iCtr++) {
            String sRespKey = arrRespKey.get(iCtr).toString();
            try {
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(jsonGETResponseString);
                JSONObject jsonObject = (JSONObject) obj;
                //========================================================
                JSONArray arrjsonObject1;
                //System.out.println(jsonObject);
                JSONObject jsonObject1 = null;
                int iSize = jsonObject.entrySet().size();
                String newxmlInput = null, sChildKey;
                //System.out.println(iSize);
                Object oObj;
                Iterator iTeKeysetChld;
                Iterator iTeKeyset = jsonObject.keySet().iterator();
                String sKey;
                int FieldIndxCtr;
                Integer Field_Indx1;
                Integer iFieldIndxCtr = null;
                oRequestField = new LinkedHashMap();
                int j = 0, sTot = jsonObject.keySet().size();
                try {
                    while (iTeKeyset.hasNext()) {
                        sKey = iTeKeyset.next().toString();
                        //System.out.println(sKey);
                        oObj = jsonObject.get(sKey);
                        if (sKey.equalsIgnoreCase(sRespKey)) {
                            oRequestField.put(sKey, oObj);

                        }
                        if (oObj instanceof JSONObject) {
                            jsonObject1 = (JSONObject) jsonObject.get(sKey);
                            oRequestField.put(sKey, jsonObject1);
                            iTeKeysetChld = jsonObject1.keySet().iterator();
                            while (iTeKeysetChld.hasNext()) {
                                sChildKey = iTeKeysetChld.next().toString();
                                //System.out.println(sChildKey);
                                //System.out.println(jsonObject1.get(sChildKey));
                                if (null != jsonObject1) {
                                    if (jsonObject1.keySet().toString().toLowerCase().contains(sRespKey.toLowerCase())) {
                                        String sKeyStr = null;
                                        Iterator itt = jsonObject1.keySet().iterator();
                                        while (itt.hasNext()) {
                                            sKeyStr = itt.next().toString();
                                            if (sKeyStr.equalsIgnoreCase(sRespKey)) {
                                                break;
                                            }
                                        }
                                        //newxmlInput = xmlInput.toString().replaceAll((String) jsonObject1.get(sReqKeyData), sreqData);
                                        //===================================================
                                        jsonObject.put(sChildKey, jsonObject1.get(sChildKey));
                                        oRequestField.put(sChildKey, jsonObject1.get(sChildKey));
                                    }
                                }
                            }
                        } else if (oObj instanceof JSONArray) {
                            JSONArray arrjsonObject2 = new JSONArray();
                            arrjsonObject1 = (JSONArray) jsonObject.get(sKey);
                            for (int i = 0; i < arrjsonObject1.size(); i++) {
                                //System.out.println(arrjsonObject1.get(i));
                                //=====================================================
                                JSONObject JSO = null;
                                Object JSO1 = new JSONObject();
                                if (arrjsonObject1.toString().contains(sRespKey)) {
                                    JSO = null;
                                    for (int w = 0; w < arrjsonObject1.size(); w++) {
                                        JSO = (JSONObject) arrjsonObject1.get(w);
                                        if (JSO.toString().contains(sRespKey)) {
                                            String sKeyStr = null, sItemStr = null;
                                            Iterator itt = JSO.keySet().iterator();
                                            Iterator itt1 = JSO.entrySet().iterator();
                                            while (itt.hasNext()) {
                                                sKeyStr = itt.next().toString();
                                                oRequestField = getValTraverse(JSO, sRespKey, sKeyStr, oRequestField);
                                            }
                                        }
                                    }
                                    arrjsonObject2.add(JSO);         //====================================================
                                    jsonObject.put(sKey, arrjsonObject2);
                                    oRequestField.put(sKey, arrjsonObject1.get(i));
                                }
                            }
                        } else {
                            //System.out.println(sKey);
                            //System.out.println(jsonObject.get(sKey));
                            oRequestField.put(sKey, jsonObject.get(sKey));
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                j++;

                Set<String> ss = oRequestField.keySet();
                Iterator iKey = ss.iterator();
                Set<String> ii = oRequestField.entrySet();
                Iterator iItem = ii.iterator();
                for (int k = 0; k < oRequestField.size(); k++) {
                    System.out.println(iKey.next());
                    System.out.println(iItem.next());
                }
                try {
                    arrList.add(oRequestField.get(sRespKey).toString());
                    oRF.put(sRespKey, oRequestField.get(sRespKey).toString());
                } catch (Exception ne) {
                    arrList.add("No such field found " + sRespKey);
                    oRF.put(sRespKey, "No such element");
                }
            }
            catch(Exception e){
                oRF.put(sRespKey, jsonGETResponseString);
         }
      }

        return oRF;
    }
    //=============================================================
    public static ArrayList<String> CaptureResponseData(String jsonGETResponseString, ArrayList arrRespKey) throws ParseException {
        HashMap oRequestField = new LinkedHashMap();
        ArrayList<String> arrList = new ArrayList<String>();
        for (int iCtr = 0; iCtr < arrRespKey.size(); iCtr++) {
            String sRespKey = arrRespKey.get(iCtr).toString();
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(jsonGETResponseString);
            JSONObject JSO = (JSONObject) obj;
            String sKeyStr = null;
            oRequestField = getValTraverse(JSO, sRespKey, sKeyStr, oRequestField);

            Set<String> ss = oRequestField.keySet();
            Iterator iKey = ss.iterator();
            Set<String> ii = oRequestField.entrySet();
            Iterator iItem = ii.iterator();
            for (int k = 0; k < oRequestField.size(); k++) {
                String SKy = iKey.next().toString();
                System.out.println(SKy);
                System.out.println(iItem.next());
                ApplicationContext.oKeyField.put(sRespKey, oRequestField.get(SKy).toString());
            }
            if(sRespKey.contains("--")){
                String[] arrParentRespKey = sRespKey.split("--");
                sRespKey = arrParentRespKey[1];
            }

                arrList.add(oRequestField.get(sRespKey).toString());

        }
        return arrList;
    }
    //==================================================================
    private static HashMap getValTraverse(Object oJSO, String sData, Object sKey, HashMap oRequestField) {
    boolean sFound = false,sFoundParent = false;
        if(sData.contains("--")) {
            arrsRespKey = sData.split("--");
            sData = arrsRespKey[0];
            sSubrespKey = arrsRespKey[1];
        }
        if(oJSO instanceof Map.Entry){
            Map.Entry JSO1 = (Map.Entry) oJSO;
            if (JSO1.toString().contains(sData) ) {
                if (JSO1.toString().contains(sData)) {
                    sKey = JSO1.getKey();
                    if(sSubrespKey!="" && sKey.toString().equalsIgnoreCase(arrsRespKey[0])){
                        sData = sSubrespKey;
                        sFoundParent = true;
                    }
                    Object oJsonObj = JSO1.getValue();
                    getValTraverse(oJsonObj,sData,sKey, oRequestField);
                }
            }
        }
        else if(oJSO instanceof JSONArray){
            JSONArray JSO1 = (JSONArray) oJSO;
            for(int i=0;i<JSO1.size();i++){
                if(JSO1.get(i).toString().contains(sData)) {
                    Object oJsonArrayObj = JSO1.get(i);
                    if(sSubrespKey!="" && sKey.toString().equalsIgnoreCase(arrsRespKey[0])){
                        sData = sSubrespKey;
                        sFoundParent = true;
                    }
                    getValTraverse(oJsonArrayObj, sData, sKey, oRequestField);
                }
            }
        }
        else if(oJSO instanceof JSONObject){
            JSONObject JSO1 = (JSONObject) oJSO;
            Iterator itt2 = JSO1.keySet().iterator();
            Iterator itt3 = JSO1.entrySet().iterator();
            while (itt2.hasNext()) {
                Object oItem = itt3.next();
                sKey = itt2.next();
                if(sKey.toString().equalsIgnoreCase(sData) ||oItem.toString().contains(sData)) {
                    Object oJSONObject = oItem;
                    if(sKey.toString().equalsIgnoreCase(sData) && oItem instanceof String){
                        oRequestField.put(sKey, oItem.toString());
                        sFound = true;
                        return oRequestField;
                    }
                    else {
                        if(sSubrespKey!="" && sKey.toString().equalsIgnoreCase(arrsRespKey[0])){
                            sData = sSubrespKey;
                            sFoundParent = true;
                        }
                        getValTraverse(oJSONObject, sData, sKey, oRequestField);
                    }
                }
                if(sFound == true || sFoundParent == true){
                    break;
                }
            }

        }
        else{
            oRequestField.put(sKey, oJSO.toString());
            return oRequestField;
        }
        sSubrespKey = "";
        arrsRespKey = new String[0];
        return oRequestField;
    }

    public static ArrayList<String> MapFields(String sField) {
        String[] NoOfData = sField.split(",");
        ArrayList<String> arrList = new ArrayList<String>();
        for (int iCtr = 0; iCtr < NoOfData.length; iCtr++) {
            switch (NoOfData[iCtr]){
                case "packId":
                    arrList.add("packNumber");
                    break;
                case "packNumber":
                    arrList.add("packId");
                    break;
                default : arrList.add(NoOfData[iCtr]);
            }
        }
        return arrList;
    }

    public static void ValidateRespose(LinkedHashMap<String, String> oExpectedResp, LinkedHashMap<String, String> oActualResp) {
        Set<String> arrExpRespKey = oExpectedResp.keySet();
        Iterator ite = arrExpRespKey.iterator();
        while(ite.hasNext()){
            try {
                String sExpRespKey = ite.next().toString();
                String sExpRespVal = oExpectedResp.get(sExpRespKey);
                String sActRespVal = oActualResp.get(sExpRespKey);
                System.out.println("Expected data for field- " + sExpRespKey + " is " + sExpRespVal);
                System.out.println("Actual data for field- " + sExpRespKey + " is " + sActRespVal);
                Assert.assertEquals(sActRespVal,sExpRespVal, "Value mismatch " + sExpRespVal + " " + sActRespVal);
            }
            catch(Exception e){

            }
        }
    }

    public static ArrayList<String> CaptureRespDataBasedOnItemKey(String jsonGETResponseString, ArrayList arrRespKey) throws ParseException {
        {
            HashMap oRequestField = new LinkedHashMap();
            ArrayList<String> arrList = new ArrayList<String>();
            for (int iCtr = 0; iCtr < arrRespKey.size(); iCtr++) {
                String sRespKey = arrRespKey.get(iCtr).toString();
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(jsonGETResponseString);
                JSONObject JSO = (JSONObject) obj;
                String sKeyStr = null;
                oRequestField = getValTraverse1(JSO, sRespKey, sKeyStr, oRequestField);

                Set<String> ss = oRequestField.keySet();
                Iterator iKey = ss.iterator();
                Set<String> ii = oRequestField.entrySet();
                Iterator iItem = ii.iterator();
                for (int k = 0; k < oRequestField.size(); k++) {
                    String SKy = iKey.next().toString();
                    System.out.println(SKy);
                    System.out.println(iItem.next());
                    ApplicationContext.oKeyField.put(sRespKey, oRequestField.get(SKy).toString());
                }
                if(sRespKey.contains("--")){
                    String[] arrParentRespKey = sRespKey.split("--");
                    sRespKey = arrParentRespKey[1];
                }

                arrList.add(oRequestField.get(sRespKey).toString());

            }
            return arrList;
        }
    }

    public void VarifyRequestFields(String responseDetails) {
        String[] arrrResp = responseDetails.split(",");
        for(int i=0;i<arrrResp.length;i++) {
            String[] arrRespDetails = arrrResp[i].split(":");
            String sRespField = arrRespDetails[0];
            String sRespVal = arrRespDetails[1];
        }
    }

    //=========================================

    private static HashMap getValTraverse1(Object oJSO, String sData, Object sKey, HashMap oRequestField) {
        boolean sFound = false,sFoundParent = false;
        if(sData.contains("--")) {
            arrsRespKey = sData.split("--");
            sData = arrsRespKey[0];
            if(sData.contains("=")){
                arrsRespKey1 = sData.split("=");
                sData = arrsRespKey1[0];
                sItemKey = arrsRespKey1[1];
            }
            else{
                sData = arrsRespKey[0];
            }
            sSubrespKey = arrsRespKey[1];

        }
        if(oJSO instanceof Map.Entry){
            Map.Entry JSO1 = (Map.Entry) oJSO;
            if (JSO1.toString().contains(sData) ) {
                if (JSO1.toString().contains(sData)) {
                    sKey = JSO1.getKey();
                    if(sSubrespKey!="" && sKey.toString().equalsIgnoreCase(arrsRespKey[0])){
                        sData = sSubrespKey;
                        sFoundParent = true;
                    }
                    else if(arrsRespKey1.length!=0 && JSO1.toString().contains(sItemKey)){
                        sData = sSubrespKey;
                    }
                    Object oJsonObj = JSO1.getValue();
                    getValTraverse1(oJsonObj,sData,sKey, oRequestField);
                }
            }
        }
        else if(oJSO instanceof JSONArray){
            JSONArray JSO1 = (JSONArray) oJSO;
            Object oJsonArrayObj = null;
            for(int i=1;i<JSO1.size();i++){
                if(JSO1.get(i).toString().contains(sData)) {
                    oJsonArrayObj = JSO1.get(i);
                    if(sSubrespKey!="" && sKey.toString().equalsIgnoreCase(arrsRespKey[0])){
                        sData = sSubrespKey;
                        sFoundParent = true;
                    }
                    if(arrsRespKey1.length!=0 && JSO1.get(i).toString().contains(sItemKey)){
                        sData = sSubrespKey;
                        oJsonArrayObj = JSO1.get(i);
                        break;
                    }

                }
            }
            getValTraverse1(oJsonArrayObj, sData, sKey, oRequestField);
        }
        else if(oJSO instanceof JSONObject){
            JSONObject JSO1 = (JSONObject) oJSO;
            Iterator itt2 = JSO1.keySet().iterator();
            Iterator itt3 = JSO1.entrySet().iterator();
            while (itt2.hasNext()) {
                Object oItem = itt3.next();
                sKey = itt2.next();
                if(sKey.toString().equalsIgnoreCase(sData) ||oItem.toString().contains(sData)) {
                    Object oJSONObject = oItem;
                    if(sKey.toString().equalsIgnoreCase(sData) && oItem instanceof String){
                        oRequestField.put(sKey, oItem.toString());
                        sFound = true;
                        return oRequestField;
                    }
                    else if(arrsRespKey1.length!=0 && oItem.toString().contains(sItemKey)){
                        sData = (String) sKey;
                        getValTraverse1(oJSONObject, sData, sKey, oRequestField);
                    }
                    else {
                        if(sSubrespKey!="" && sKey.toString().equalsIgnoreCase(arrsRespKey[0])){
                            sData = sSubrespKey;
                            sFoundParent = true;
                        }
                        getValTraverse1(oJSONObject, sData, sKey, oRequestField);
                    }
                }
                if(sFound == true || sFoundParent == true){
                    break;
                }
            }

        }
        else{
            oRequestField.put(sKey, oJSO.toString());
            return oRequestField;
        }
        sSubrespKey = "";
        arrsRespKey = new String[0];
        return oRequestField;
    }
    //==========================================

}

