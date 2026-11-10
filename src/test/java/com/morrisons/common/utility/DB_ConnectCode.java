package com.morrisons.common.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class DB_ConnectCode {
    /*public static void main(String args[]) throws SQLException,
    ClassNotFoundException, InterruptedException, AWTException,
    IOException {*/
    static String dbUrl;
    static Connection con;
    static Statement stmt;
    static ResultSet res;
    static ResultSetMetaData rm;
    static String GlobalValToVerify;
    static int iGlobalCtr = 0;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
// String dbUrl =
// "jdbc:oracle://zeusdbaasf2bddor.swissbank.com:1521/ZEUSEU4_EU_A.WORLD";
        HashMap<String,HashMap> oRMS_DB_Data = new LinkedHashMap<String,HashMap>();
        HashMap oChildRMS_DB_Data = new LinkedHashMap();
        HashMap<String,HashMap> oStrWalk_DB_Data = new LinkedHashMap<String,HashMap>();
        HashMap oChildStrWalk_DB_Data = new LinkedHashMap();
        HashMap<String,HashMap> oWalkItem_DB_Data = new LinkedHashMap<String,HashMap>();
        HashMap oChildWalkItem_DB_Data = new LinkedHashMap();
        Class.forName("oracle.jdbc.driver.OracleDriver");
        dbUrl = "jdbc:oracle:thin:@tgret13x.unix.morrisons.net:1521:MOMSIT3A"; // TE1.GBL.UBS.NET
        con = DriverManager.getConnection(dbUrl, "XXWMM_INT_RETAIL", "K4fYHPDm4zxwypCc");
        System.out.println("Connection succes");
// Class.forName("com.mysql.jdbc.Driver");
        stmt = con.createStatement();
        res = stmt
                .executeQuery("select * from XXWMM_MOR_STKADJ_INBOUND where LOCATION in (318) and item in ('110202041','100910335','112158195')");
        System.out.println(res.getMetaData().getColumnCount() + " stmt succes");
        rm = res.getMetaData();
        int col_Count1 = rm.getColumnCount();
        while (res.next())   {

// System.out.print(res.getString("GLOBAL_CREL_ID"));
// //.getString("dummy")
            for (int a = 1; a < col_Count1 + 1; a++) {
                System.out.print("\t" + "column name: " + rm.getColumnLabel(a) + " Column values: " + res.getString(a) + "\n");
                oChildRMS_DB_Data.put(rm.getColumnLabel(a), res.getString(a));
            }
            oRMS_DB_Data.put(res.getString("item").toString(),oChildRMS_DB_Data);
// if(i>3){
            // break;
// }
            System.out.println("\n");

        }
        System.out.println("RS succes");

        //===========================================================
        Class.forName("oracle.jdbc.driver.OracleDriver");
        dbUrl = "jdbc:postgresql://storewalk01-uat-v00.ca107skwgezh.eu-west-1.rds.amazonaws.com:5432/stwkuat001"; // TE1.GBL.UBS.NET
        con = DriverManager.getConnection(dbUrl, "stwkuat001_owner", "stwkuat001_owner999");
        System.out.println("Connection succes");
// Class.forName("com.mysql.jdbc.Driver");
        stmt = con.createStatement();
        LocalDate currentDate = LocalDate.now();
        String squery = "select * from storewalk s join walkitem w on w.walk_id = s.walk_id where s.walk_id in(select walk_id\n" +
                "from storewalk s where s.store_number=318 and s.created_on > '" + currentDate + " 23:08:17.553979+00'\n" +
                "and s.walk_type = 'GapsHighsLows'and product_min in ('110202041','112158195'))";
        res = stmt
                .executeQuery("select * from storewalk s join walkitem w on w.walk_id = s.walk_id where s.walk_id in(select walk_id\n" +
                        "from storewalk s where s.store_number=1 and s.created_on > '2023-07-26 23:08:17.553979+00'\n" +
                        "and s.walk_type = 'GapsHighsLows'and product_min in ('110202041','112158195'))");
        System.out.println(res.getMetaData().getColumnCount() + " stmt succes");
        rm = res.getMetaData();
        int col_Count2 = rm.getColumnCount();
        while (res.next()) {
            // System.out.print(res.getString("GLOBAL_CREL_ID"));
            //.getString("dummy")
            for (int a = 1; a < col_Count2 + 1; a++) {
                System.out.print("\t" + "column name: " + rm.getColumnLabel(a) + " Column values: " + res.getString(a) + "\n");
                oChildStrWalk_DB_Data.put(rm.getColumnLabel(a), res.getString(a));
            }
            oStrWalk_DB_Data.put(res.getString("product_min").toString(),oChildStrWalk_DB_Data);
        }
//===============================================================
        // Class.forName("com.mysql.jdbc.Driver");
        stmt = con.createStatement();
        res = stmt
                .executeQuery("select * from walkitem where product_min in ('110202041','100910335','112158195')");
        System.out.println(res.getMetaData().getColumnCount() + " stmt succes");
        rm = res.getMetaData();
        int col_Count3 = rm.getColumnCount();
        while (res.next()) {

// System.out.print(res.getString("GLOBAL_CREL_ID"));
// //.getString("dummy")
            for (int b = 1; b < col_Count3 + 1; b++) {
                System.out.print("\t" + "column name: " + rm.getColumnLabel(b) + " Column values: " + res.getString(b) + "\n");
                oChildStrWalk_DB_Data.put(rm.getColumnLabel(b), res.getString(b));
            }
            oStrWalk_DB_Data.put(res.getString("product_min").toString(),oChildStrWalk_DB_Data);
        }
//===========================================================================
        Set oParentStrWalk_DB_Key = oStrWalk_DB_Data.keySet();
        Set oParentStrWalk_DB_Val = oStrWalk_DB_Data.entrySet();
        Set oParentRMS_DB_Key = oRMS_DB_Data.keySet();
        Set oParentRMS_DB_Val = oRMS_DB_Data.entrySet();
        Iterator ParentStrWalkIte = oParentStrWalk_DB_Key.iterator();
        Iterator ParentRMSIte = oParentRMS_DB_Key.iterator();
        //======================================
        String ParentStrWalkKey = null;
        String sParentRMSKey = null;
        String sParentRMSVal = null, sParentStrWalkVal = null;
        int iPctr=0;
        while(ParentRMSIte.hasNext()) {
            ParentStrWalkKey = ParentStrWalkIte.next().toString();
            oChildStrWalk_DB_Data = oStrWalk_DB_Data.get(ParentStrWalkKey);
            Set oStrWalk_DB_Key = oChildStrWalk_DB_Data.keySet();
            Set oStrWalk_DB_Val = oChildStrWalk_DB_Data.entrySet();
            oChildRMS_DB_Data = oRMS_DB_Data.get(ParentStrWalkKey);
            Set oRMS_DB_Key = oChildRMS_DB_Data.keySet();
            Set oRMS_DB_Val = oChildRMS_DB_Data.entrySet();
            Iterator StrWalkIte = oStrWalk_DB_Key.iterator();
            Iterator RMSIte = oRMS_DB_Key.iterator();
            sParentRMSKey = RMSIte.next().toString();
            ParentStrWalkKey = StrWalkIte.next().toString();
            //==================================================
            String sRMSVal = null, sStrWalkVal = null;
            while (RMSIte.hasNext()) {
                String StrWalkKey = null;
                String sRMSKey = null;
                try {
                    sRMSKey = RMSIte.next().toString();
                    StrWalkKey = StrWalkIte.next().toString();
                    sRMSVal = oChildRMS_DB_Data.get(sRMSKey).toString();
                    StrWalkKey = getFieldMap(sRMSKey, oStrWalk_DB_Data);
                    sStrWalkVal = oChildStrWalk_DB_Data.get(StrWalkKey).toString();
                    if (sRMSVal.equalsIgnoreCase(sStrWalkVal)) {
                        System.out.println("The expected data " + sStrWalkVal + "matches with actual " + sRMSVal + "\n");
                    } else {
                        System.out.println("The expected data " + sStrWalkVal + "doesn't match with actual " + sRMSVal + "\n");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println("The expected field " + StrWalkKey + " doesn't match with actual " + sRMSKey + "\n");
                System.out.println("The expected data " + sStrWalkVal + " doesn't match with actual " + sRMSVal + "\n");
            }
        }
        System.out.println("\n");

        System.out.println("RS succes");
    }

    private static String getFieldMap (String sRMSKey, HashMap oStrWalk_db_data){
        switch (sRMSKey) {
            case "LOCATION":
                sRMSKey = "store_number";
                break;
            case "ITEM":
                sRMSKey = "product_min";
                break;
            case "STKADJ_SOURCE":
                sRMSKey = "always storewalk";
                break;
            case "COUNTED_UOM":
                sRMSKey = "uom";
                break;
            case "PACK_NO":
                sRMSKey = "packs";
                break;
            case "COUNTED_QTY":
                sRMSKey = "SumOfCaptures";
                break;
            case "COUNT_TYPE":
                sRMSKey = "count_type";
                break;
            case "Default":
                sRMSKey = "No Match";
                break;
        }
        return sRMSKey;
    }
    //==========================================================================
}

