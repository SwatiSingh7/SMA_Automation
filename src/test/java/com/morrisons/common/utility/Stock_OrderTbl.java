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

public class Stock_OrderTbl {
    static String dbUrl;
    static Connection con;
    static Statement stmt;
    static ResultSet res;
    static ResultSetMetaData rm;
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        dbUrl = "jdbc:postgresql://retail-stockorder-np-v00.ca107skwgezh.eu-west-1.rds.amazonaws.com:5432/api_stockorder_v1_db_sit"; // TE1.GBL.UBS.NET
        con = DriverManager.getConnection(dbUrl, "api_stockorder_v1_owner_sit", "api_stockorder_v1_owner_sit999");
        System.out.println("Connection succes");
// Class.forName("com.mysql.jdbc.Driver");
        stmt = con.createStatement();
        res = stmt
                .executeQuery("select * from stock_position where store_id = '8' and item_number in (107514491,100162509,101533092,110440154,109154185,107742952,107572771)");
        System.out.println(res.getMetaData().getColumnCount() + " stmt succes");
        rm = res.getMetaData();
        int col_Count1 = rm.getColumnCount();
        if (col_Count1 > 0) {
            System.out.println("All items mentioned in SOH file got inserted into stock_position table");
        } else {
            System.out.println("All items mentioned in SOH file didn't get inserted into stock_position table");
        }
    }
}
