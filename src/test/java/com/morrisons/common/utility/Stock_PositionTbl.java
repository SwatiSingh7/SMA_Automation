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

public class Stock_PositionTbl {
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
        HashMap<String, HashMap> oRMS_DB_Data = new LinkedHashMap<String, HashMap>();
        HashMap oChildRMS_DB_Data = new LinkedHashMap();
        HashMap<String, HashMap> oStrWalk_DB_Data = new LinkedHashMap<String, HashMap>();
        HashMap oChildStrWalk_DB_Data = new LinkedHashMap();
        HashMap<String, HashMap> oWalkItem_DB_Data = new LinkedHashMap<String, HashMap>();
        HashMap oChildWalkItem_DB_Data = new LinkedHashMap();
        Class.forName("oracle.jdbc.driver.OracleDriver");
        dbUrl = "jdbc:postgresql://rds-euw1-sit-supplychain-aupgcluster-stockv2reader-001-01.ca107skwgezh.eu-west-1.rds.amazonaws.com:5432/stkrsit001"; // TE1.GBL.UBS.NET
        con = DriverManager.getConnection(dbUrl, "stkrsit001_owner", "stkrsit001_owner999");
        System.out.println("Connection succes");
// Class.forName("com.mysql.jdbc.Driver");
        stmt = con.createStatement();
        res = stmt
                .executeQuery("select * from stock_position where store_id = '8' and item_number in (107514491,100162509,101533092,110440154,109154185,107742952,107572771)");
        System.out.println(res.getMetaData().getColumnCount() + " stmt succes");
        rm = res.getMetaData();
        int col_Count1 = rm.getColumnCount();
        if(col_Count1 > 0){
            System.out.println("All items mentioned in SOH file got inserted into stock_position table");
        }
        else{
            System.out.println("All items mentioned in SOH file didn't get inserted into stock_position table");
        }
        while (res.next()) {

// System.out.print(res.getString("GLOBAL_CREL_ID"));
// //.getString("dummy")
            for (int a = 1; a < col_Count1 + 1; a++) {
                System.out.print("\t" + "column name: " + rm.getColumnLabel(a) + " Column values: " + res.getString(a) + "\n");
                oChildRMS_DB_Data.put(rm.getColumnLabel(a), res.getString(a));
            }
            //oRMS_DB_Data.put(res.getString("item").toString(), oChildRMS_DB_Data);
// if(i>3){
            // break;
// }
            System.out.println("\n");

        }
        System.out.println("RS succes");

        //===========================================================
    }
}
