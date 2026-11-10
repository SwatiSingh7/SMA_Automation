package com.morrisons.common.PageFactory;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;

import com.morrisons.common.helper.CommonHelperMethods;
import lombok.val;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class InitClass {

    public static WebElement createObject(WebDriver dr,String sObjName, String sLocatorName, String sPageName) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        WebElement oEle = null;
        Class cls = Class.forName(sPageName);
        Object oo = cls.newInstance();
        Field field = cls.getDeclaredField(sObjName);
        if(field.getType().toString().equals("class java.lang.String")) {
            String ss = field.get(oo).toString();
            oEle = CommonHelperMethods.createDynamicObj7(dr, oEle, ss, sLocatorName);
        }
        else{
             Object a = Class.class.cast(field.getType());
             Object v = field.get(oo);
             oEle = (WebElement) v;
        }
        return oEle;
    }

    //=============================================
    public static WebElement createObject(WebDriver dr,String sObjName,String sPageName) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        WebElement oEle = null;
        Class cls = Class.forName(sPageName);
        Object oo = cls.newInstance();
        Field field = cls.getDeclaredField(sObjName);
        if(field.getType().toString().equals("class java.lang.String")) {
            String ss = field.get(oo).toString();
            oEle = CommonHelperMethods.createDynamicObj7(dr, oEle, ss);
        }
        else{
            Object a = Class.class.cast(field.getType());
            Object v = field.get(oo);
            oEle = (WebElement) v;
        }
        return oEle;
    }
    //==================================================
    public static List<WebElement> createMultipleObjects(WebDriver dr, String sObjName, String sLocatorName, String sPageName) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        WebElement oEle = null;
        List<WebElement> oEle1 = null;
        Class cls = Class.forName(sPageName);
        Object oo = cls.newInstance();
        Field field = cls.getDeclaredField(sObjName);
        Field[] fields = cls.getDeclaredFields();
        if(field.getType().toString().equals("class java.lang.String")){
            String ss = field.get(oo).toString();
            oEle1 = CommonHelperMethods.createDynamicListObj7(dr,ss, sLocatorName);
        }
        else{
            Object a = Class.class.cast(field.getType());
            Object v = field.get(oo);
            oEle = (WebElement) v;
            oEle1 = CommonHelperMethods.createDynamicListObj(dr,oEle,sLocatorName);
        }
        return oEle1;
    }
    //====================================================
    public static List<WebElement> createMultipleObjects(WebDriver dr, String sObjName, String sPageName) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        List<WebElement> oEle = null;
        List<WebElement> oEle1 = null;
        Class cls = Class.forName(sPageName);
        Object oo = cls.newInstance();
        Field field = cls.getDeclaredField(sObjName);
        Field[] fields = cls.getDeclaredFields();
        if(field.getType().toString().equals("class java.lang.String")){
            String ss = field.get(oo).toString();
            oEle = CommonHelperMethods.createDynamicListObj7(dr,ss);
        }
        else{
            Object a = Class.class.cast(field.getType());
            Object v = field.get(oo);
            oEle = (List<WebElement>) v;
//            oEle1 = CommonHelperMethods.createDynamicListObj(dr,oEle);
        }
        return oEle;
    }
    //======================================================
}
