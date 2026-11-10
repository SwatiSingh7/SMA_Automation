package com.morrisons.common.utility;

import org.apache.log4j.Logger;

import org.apache.log4j.Logger;
import org.testng.Assert;

import java.sql.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author rahul.khetal and Swati.Sinha
 * <p>
 * 22-Feb-2022
 */
public class DatabaseHelper {

    public static Object updateQueryforC;
    private static Logger log = Logger.getLogger(DatabaseHelper.class);

    /*
     * Delete row from table
     */
    public static void deleteQuery(String hostautomationdb, String userNameautomationdb, String passwordautomationdb, String query) throws InterruptedException, SQLException, ClassNotFoundException {
        Thread.sleep(2000);
        Connection con = createDBConnection(hostautomationdb, userNameautomationdb, passwordautomationdb);
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement(query);
            log.info("Executing Query : " + query);
            stm.executeUpdate();
            log.info("Query execution successful");
        } finally {
            closeConnection(con, stm);
        }
    }

    /*
     * Updates a Table
     */
    public static void updateQuery(String hostautomationdb, String userNameautomationdb, String passwordautomationdb, String query) throws InterruptedException, SQLException, ClassNotFoundException {
        Thread.sleep(2000);
        Connection con = createDBConnection(hostautomationdb, userNameautomationdb, passwordautomationdb);
        Statement stm = con.createStatement();
        try {
            log.info("Executing Query : " + query);
            stm.executeUpdate(query);
            log.info("Query execution successful");
        } finally {
            closeConnection(con, stm);
        }
    }


    /*
     * Returns a list of value for the database rows for the specified column (Multiple Rows & Single Column)
     */
    public static List<String> createDataListForAListOfRows(String hostautomationdb, String userNameautomationdb, String passwordautomationdb, String query, String tablecolumnname) throws InterruptedException, SQLException, ClassNotFoundException {
        List<String> dataList = new ArrayList<String>();
        Thread.sleep(2000);
        Connection con = createDBConnection(hostautomationdb, userNameautomationdb, passwordautomationdb);
        Statement stm = con.createStatement();
        try {
            ResultSet rst;
            log.info("Executing Query : " + query);
            rst = stm.executeQuery(query);
            log.info("Query execution successful");
            while (rst.next()) {
                dataList.add(rst.getString(tablecolumnname));
            }
        } finally {
            closeConnection(con, stm);
        }
        log.info("Dataset : " + dataList);
        return dataList;
    }

    /*
     * Returns a List of value for the database columns specified in the List (Single Row & Multiple Columns)
     */
    public static List<String> createDataListForAListOfColumns(String hostautomationdb, String userNameautomationdb, String passwordautomationdb, String query, List<String> tablecolumnnames) throws InterruptedException, SQLException, ClassNotFoundException {
        List<String> dataList = new ArrayList<String>();
        Thread.sleep(2000);
        Connection con = createDBConnection(hostautomationdb, userNameautomationdb, passwordautomationdb);
        Statement stm = con.createStatement();
        try {
            ResultSet rst;
            log.info("Executing Query : " + query);
            rst = stm.executeQuery(query);
            log.info("Query execution successful");
            while (rst.next()) {
                for (String eachString : tablecolumnnames) {
                    dataList.add(rst.getString(eachString));
                }
            }
        } finally {
            closeConnection(con, stm);
        }
        log.info("Dataset : " + dataList);
        return dataList;
    }

    /*
     * Returns a List of value for the database columns specified in the List (Multiple Rows & Multiple Columns)
     */
    public static List<ArrayList<String>> createMulipleColumnDataListForMultipleRowsInDB(String hostautomationdb, String userNameautomationdb, String passwordautomationdb, String query, List<String> tablecolumnnames) throws InterruptedException, SQLException, ClassNotFoundException {
        List<ArrayList<String>> dataListMultipleRow = new ArrayList<ArrayList<String>>();
        Thread.sleep(2000);

        Connection con = createDBConnection(hostautomationdb, userNameautomationdb, passwordautomationdb);
        log.info("Database connection successful");
        Statement stm = con.createStatement();

        try {
            ResultSet rst;
            log.info("Executing Query : " + query);
            rst = stm.executeQuery(query);
            log.info("Query execution successful");
            while (rst.next()) {
                ArrayList<String> dataListSingleRow = new ArrayList<String>();
                for (String eachString : tablecolumnnames) {
                    dataListSingleRow.add(rst.getString(eachString));
                }
                dataListMultipleRow.add(dataListSingleRow);
            }
        } finally {
            closeConnection(con, stm);
        }
        log.info("Dataset : " + dataListMultipleRow);
        return dataListMultipleRow;
    }

    private static Connection createDBConnection(String hostautomationdb, String userNameautomationdb, String passwordautomationdb) throws SQLException, ClassNotFoundException {
        Connection connection = null;
//        Class.forName("com.mysql.jdbc.Driver");
        try {
            log.info("Connecting to database : " + hostautomationdb);
            connection = DriverManager.getConnection(hostautomationdb, userNameautomationdb, passwordautomationdb);
            log.info("Database connection successful");
        } catch (Exception e) {
            log.error("There was a problem while establish a connection : " + e);
            Assert.fail("There was a problem while establish a connection : " + e);
        }

        return connection;
    }


    private static void closeConnection(Connection con, Statement stm) throws SQLException {
        log.info("Closing Statement");
        stm.close();
        log.info("Closing Connection");
        con.close();
    }

    public static void DeleteandUpdateQueryforCandR(String databaseHostname, String databaseUsername, String databasePassword) throws SQLException {
        String dbUrl;
        Connection con;
        Statement stmt;
        ResultSet res;
        boolean res1;
        ResultSetMetaData rm;
        String GlobalValToVerify;
        int iGlobalCtr = 0;
        LocalDate currentDate = LocalDate.now();
        dbUrl = "jdbc:postgresql://rds-euw1-sit-pg-logistics-cleanrotate-001-v00.ca107skwgezh.eu-west-1.rds.amazonaws.com:5432/clrosit001"; // TE1.GBL.UBS.NET
        con = DriverManager.getConnection(dbUrl, "clrosit001_owner", "clrosit001_owner999");
        System.out.println("Connection succes");
        // Class.forName("com.mysql.jdbc.Driver");
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        Statement stmt1 = con.createStatement();
        //'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
        Calendar calendar = Calendar.getInstance();
        int weekNumber = calendar.get(Calendar.WEEK_OF_YEAR);
        LocalDate start = currentDate;
        while (start.getDayOfWeek() != DayOfWeek.MONDAY) {
            start = start.minusDays(1);
        }
        System.out.println("Start of the Week = " + start);

        LocalDate Prevstart = currentDate.minusDays(7);
        while (Prevstart.getDayOfWeek() != DayOfWeek.MONDAY) {
            Prevstart = Prevstart.minusDays(1);
        }
        System.out.println("Start of the Week = " + Prevstart);

        LocalDate Nextstart = currentDate.plusDays(7);
        while (Nextstart.getDayOfWeek() != DayOfWeek.MONDAY) {
            Nextstart = Nextstart.minusDays(1);
        }
        System.out.println("Start of the Week = " + Nextstart);

        LocalDate SecondNextstart = Nextstart.plusDays(7);
        while (SecondNextstart.getDayOfWeek() != DayOfWeek.MONDAY) {
            SecondNextstart = SecondNextstart.minusDays(1);
        }
        System.out.println("Start of the Week = " + SecondNextstart);

        LocalDate Futurestart = SecondNextstart.plusDays(7);
        while (Futurestart.getDayOfWeek() != DayOfWeek.MONDAY) {
            Futurestart = Futurestart.minusDays(1);
        }
        System.out.println("Start of the Week = " + Futurestart);

        LocalDate end = currentDate;
        while (end.getDayOfWeek() != DayOfWeek.SUNDAY) {
            end = end.plusDays(1);
        }
        System.out.println("End of the Week = " + end);
        //''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
        int PrevweekNumber = weekNumber-1;
        int NextweekNumber = weekNumber+1;
        int SecontNextweekNumber = weekNumber+2;
        int FutureweekNumber = weekNumber+3;
        int currentYear = currentDate.getYear();
        LocalDate FutureMonth = currentDate.plusMonths(3);

        res = stmt
                .executeQuery("select * from department_product_check where dept_check_id in (select dept_check_id from department_check where dept_config_id in (select dept_config_id from department_config where category = 'Ambient' and year_check = '" + currentYear +"' and week_check between " + PrevweekNumber + " and " + FutureweekNumber +"))");
        rm = res.getMetaData();
        res.last();
        int rc =  res.getRow();
        if(rc>0) {
            res1 = stmt1
                    .execute("delete from department_product_check where dept_check_id in (select dept_check_id from department_check where dept_config_id in (select dept_config_id from department_config where category = 'Ambient' and year_check = '" + currentYear +"' and week_check between " + PrevweekNumber + " and " + FutureweekNumber +"))");
//		    rm = res1.getMetaData();
//		   while (res1.next())
            //
//			{
//			   res1.deleteRow();
//			}
        }
        else {
            System.out.println("There are no data in the table");
        }

        res = stmt
                .executeQuery("select * from department_check where dept_config_id in (select dept_config_id from department_config where category = 'Ambient' and year_check = '" + currentYear + "' and week_check between " + PrevweekNumber + " and " + FutureweekNumber +")");
        rm = res.getMetaData();
        res.last();
        int rc1 =  res.getRow();
        if(rc1>0) {
            res1 = stmt1
                    .execute("delete from department_check where dept_config_id in (select dept_config_id from department_config where category = 'Ambient' and year_check = '" + currentYear + "' and week_check between " + PrevweekNumber + " and " + FutureweekNumber +")");
        }
        else {
            System.out.println("There are no data in the table");
        }
        res = stmt
                .executeQuery("select * from department_config where category = 'Ambient' and year_check = '" + currentYear + "' and week_check between " + PrevweekNumber + " and " + FutureweekNumber + " order by date_check desc limit 100");
        rm = res.getMetaData();
        res.last();
        int rc2 =  res.getRow();
        if(rc2>0) {
            res1 = stmt1
                    .execute("delete from department_config where category = 'Ambient' and year_check = '" + currentYear + "' and week_check between " + PrevweekNumber + " and " + FutureweekNumber);

        }
        else {
            System.out.println("There are no data in the table");
        }


        // select * from department_check where dept_config_id = '3057942';
        //select * from department_product_check where dept_check_id = '112514';
        String sql5 = "INSERT INTO public.department_config\r\n"
                + "(dept_id, dept_name, store_dept_name, week_check, year_check, date_check, next_check, is_enabled, category, shelf_life, store_id, signoff_status, signoff_updated_by_id, signoff_updated_by_name, signoff_updated_on, is_critical, is_range, aisle, daily_code_check_type_id, hierarchy_key, is_promotion, is_warehouse)\r\n"
                + "VALUES\r\n"
                + "(22, 'Crisps and Snacks', 'Crisps and Snacks'," + PrevweekNumber + ", " + currentYear + ", '" + Prevstart + "', '" + FutureMonth + "', true, 'Ambient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),\r\n"
                + "(34,'Canned Fruit','Canned Fruit'," +  PrevweekNumber + ", " + currentYear + ", '" + Prevstart + "', '" + FutureMonth + "', true, 'Ambient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),\r\n"
                + "(22, 'Crisps and Snacks', 'Crisps and Snacks'," + weekNumber + ", " + currentYear +", '" + start + "', '" + FutureMonth + "', true, 'Ambient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),\r\n"
                + "(34, 'Canned Fruit', 'Canned Fruit'," + weekNumber + ", " + currentYear +", '" + start + "', '" + FutureMonth + "', true, 'Ambient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),\r\n"
                + "(34, 'Canned Fruit', 'Canned Fruit'," + NextweekNumber + ", " + currentYear + ", '" + Nextstart + "', '" + FutureMonth + "', true, 'Ambient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),\r\n"
                + "(22, 'Crisps and Snacks', 'Crisps and Snacks'," + SecontNextweekNumber + ", " + currentYear +", '" + SecondNextstart + "', '" + FutureMonth + "', true, 'Ambient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),\r\n"
                + "(22, 'Crisps and Snacks', 'Crisps and Snacks'," + FutureweekNumber + ", " + currentYear + ", '" + Futurestart + "', '" + FutureMonth + "', true, 'Ambient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);";

        int res6 = stmt
                .executeUpdate(sql5);

    }
    public static void DeleteandUpdateQueryforFCC(String databaseHostname, String databaseUsername, String databasePassword) throws SQLException {

    }

}
