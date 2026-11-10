package com.morrisons.sma.step_definitions.database;

import com.google.inject.Inject;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.morrisons.common.utility.ApplicationContext;
import com.morrisons.common.utility.DatabaseHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class DataBaseStepDefs_New {

    private final Logger log = Logger.getLogger(DataBaseStepDefs_New.class);
    //private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
    private final ApplicationContext applicationContext;
    private HashMap<String, String> dbDetails;

    @Inject
    public DataBaseStepDefs_New(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @When("I connect to the {string} database and fire a select query to get a single column as {string} with query as {string}")
    public void iConnectToTheDatabaseAndFireASelectQueryToGetASingleColumnAsWithQueryAs(String dataBaseName, String columnName, String query) throws SQLException, InterruptedException, ClassNotFoundException {
        List<String> dataList = new ArrayList<>();

        getDatabaseDetails(dataBaseName);
        dataList = DatabaseHelper.createDataListForAListOfRows(dbDetails.get("databaseHostname"),
                dbDetails.get("databaseUsername"),
                dbDetails.get("databasePassword"),
                query,
                columnName);
        applicationContext.applicationDetailsMap.put("Multiple Row Single Column Data List", dataList);
    }

    @When("I connect to the {string} database and fire a select query to get a single row with query as {string}, for the following columns")
    public void iConnectToTheDatabaseAndFireASelectQueryToGetASingleRowWithQueryAsForTheFollowingColumns(String dataBaseName, String query, List<String> colunmList) throws SQLException, InterruptedException, ClassNotFoundException {
        log.info("Database Name : " + dataBaseName);
        log.info("Store ID : " + System.getProperty("storeID"));
        List<String> dataList = new ArrayList<>();
        getDatabaseDetails(dataBaseName);
        dataList = DatabaseHelper.createDataListForAListOfColumns(dbDetails.get("databaseHostname"),
                dbDetails.get("databaseUsername"),
                dbDetails.get("databasePassword"),
                query,
                colunmList);
        applicationContext.applicationDetailsMap.put("Single Row Multiple Column Data List", dataList);
    }

    @When("I connect to the {string} database and fire a select query to get multiple rows with query as {string}, for the following columns")
    public void iConnectToTheDatabaseAndFireASelectQueryToGetMultipleRowsWithQueryAsForTheFollowingColumns(String dataBaseName, String query, List<String> colunmList) throws SQLException, InterruptedException, ClassNotFoundException {
        log.info("Database Name : " + dataBaseName);
        List<ArrayList<String>> dataListOfLists = new ArrayList<ArrayList<String>>();
        getDatabaseDetails(dataBaseName);
        dataListOfLists = DatabaseHelper.createMulipleColumnDataListForMultipleRowsInDB(dbDetails.get("databaseHostname"),
                dbDetails.get("databaseUsername"),
                dbDetails.get("databasePassword"),
                query,
                colunmList);
        applicationContext.applicationDetailsMap.put("Multiple Row Multiple Column Data List", dataListOfLists);
    }

    @When("I connect to {string} database and fire a delete query as {string}")
    public void iConnectToDatabaseAndFireADeleteQueryAs(String dataBaseName, String query) throws SQLException, InterruptedException, ClassNotFoundException {
        log.info("Database Name : " + dataBaseName);
        getDatabaseDetails(dataBaseName);
        DatabaseHelper.deleteQuery(dbDetails.get("databaseHostname"),
                dbDetails.get("databaseUsername"),
                dbDetails.get("databasePassword"),
                query);
    }


    private void getDatabaseDetails(String dataBaseName) {
        switch (dataBaseName) {
            case "Product":
                getProductDBDetails();
                break;
            case "Space":
                getSpaceDBDetails();
                break;
            case "Stock V2":
                getStockV2DBDetails();
                break;
            case "Waste Validation":
                getWasteValidationDBDetails();
                break;
            case "cleanAndRotate":
                getCleanAndRotateDBDetails();
                break;
            case "Test":
                getTestDBDetails();
                break;
            default:
                log.error("No Such Database : " + dataBaseName);
                Assert.fail("No Such Database : " + dataBaseName);
        }
    }

    private void getProductDBDetails() {
        dbDetails = new HashMap<>();
        dbDetails.put("databaseHostname", applicationContext.applicationConfig.getProductDatabase().databaseHostname);
        dbDetails.put("databaseUsername", applicationContext.applicationConfig.getProductDatabase().databaseUsername);
        dbDetails.put("databasePassword", applicationContext.applicationConfig.getProductDatabase().databasePassword);
    }

    private void getSpaceDBDetails() {
        dbDetails = new HashMap<>();
        dbDetails.put("databaseHostname", applicationContext.applicationConfig.getSpaceDatabase().databaseHostname);
        dbDetails.put("databaseUsername", applicationContext.applicationConfig.getSpaceDatabase().databaseUsername);
        dbDetails.put("databasePassword", applicationContext.applicationConfig.getSpaceDatabase().databasePassword);
    }

    private void getStockV2DBDetails() {
        dbDetails = new HashMap<>();
        dbDetails.put("databaseHostname", applicationContext.applicationConfig.getStockV2Databse().databaseHostname);
        dbDetails.put("databaseUsername", applicationContext.applicationConfig.getStockV2Databse().databaseUsername);
        dbDetails.put("databasePassword", applicationContext.applicationConfig.getStockV2Databse().databasePassword);
    }

    private void getWasteValidationDBDetails() {
        dbDetails = new HashMap<>();
        dbDetails.put("databaseHostname", applicationContext.applicationConfig.getWasteValidationDatabseDatabse().databaseHostname);
        dbDetails.put("databaseUsername", applicationContext.applicationConfig.getWasteValidationDatabseDatabse().databaseUsername);
        dbDetails.put("databasePassword", applicationContext.applicationConfig.getWasteValidationDatabseDatabse().databasePassword);
    }

    private void getCleanAndRotateDBDetails() {
        dbDetails = new HashMap<>();
        dbDetails.put("databaseHostname", applicationContext.applicationConfig.getCleanAndRotateDatabse().databaseHostname);
        dbDetails.put("databaseUsername", applicationContext.applicationConfig.getCleanAndRotateDatabse().databaseUsername);
        dbDetails.put("databasePassword", applicationContext.applicationConfig.getCleanAndRotateDatabse().databasePassword);
    }

    private void getTestDBDetails() {
        dbDetails = new HashMap<>();
        dbDetails.put("databaseHostname", applicationContext.applicationConfig.getTestDatabase().databaseHostname);
        dbDetails.put("databaseUsername", applicationContext.applicationConfig.getTestDatabase().databaseUsername);
        dbDetails.put("databasePassword", applicationContext.applicationConfig.getTestDatabase().databasePassword);
    }

    @When("I connect to Remote Database")
    public void iConnectToRemoteDatabase() throws JSchException, SQLException, IOException {
        String jumpServerUsername = "extmasz1";
        String jumpServerHost = "10.244.39.83";
        String jumpServerPassword = "2Bchanged";

        String databaseUsername = "extmasz1";
        String databaseHost = "54.76.172.25";
        String databasePassword = "2Bchanged";


        JSch jsch = new JSch();
        jsch.addIdentity("~/.ssh/id_rsa");
        log.info("Connecting to Bation Server @ : " + jumpServerHost);
        Session jumpboxSession = getSession(jsch, jumpServerUsername, jumpServerHost, jumpServerPassword, 22);
        log.info("Connected to Bation Server @ : " + jumpServerHost);

        int serverSshPort = jumpboxSession.setPortForwardingL(0, databaseHost, 22);
        log.info("Connecting to Database Server @ : " + databaseHost);
        Session serverSession = getSession(jsch, databaseUsername, "127.0.0.1", databasePassword, serverSshPort);
        log.info("Connected to Database Server @ : " + databaseHost);
        int postgresPort = serverSession.setPortForwardingL(0, "rds-euw1-sit-supplychain-pgr-wv-rds-001.cv6olwlqhgqy.eu-west-1.rds.amazonaws.com", 5432);

        /*ChannelExec channel = null;

        channel = (ChannelExec) serverSession.openChannel("exec");
        channel.setCommand("psql --host=rds-euw1-sit-supplychain-pgr-wv-rds-001.cv6olwlqhgqy.eu-west-1.rds.amazonaws.com --port=5432 --username=wvsit001_owner --password --dbname=wvsit001;wvsit001_owner999");
        channel.setInputStream(null);
        ((ChannelExec) channel).setErrStream(System.err);

        InputStream in = channel.getInputStream();
        channel.connect();

        byte[] tmp = new byte[1024];
        while (true) {
            while (in.available() > 0) {
                int i = in.read(tmp, 0, 1024);
                if (i < 0) break;
                System.out.print(new String(tmp, 0, i));
            }
            if (channel.isClosed()) {
                System.out.println("exit-status: " + channel.getExitStatus());
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (Exception ee) {
            }
        }*/


        String url = "jdbc:postgresql://rds-euw1-sit-supplychain-pgr-wv-rds-001.cv6olwlqhgqy.eu-west-1.rds.amazonaws.com:" + postgresPort + "/wvsit001";

        Connection con = DriverManager.getConnection(url, "wvsit001_owner", "wvsit001_owner999");
        Statement stm = con.createStatement();
        List<String> dataList = new ArrayList<String>();
        try {
            ResultSet rst;
            log.info("Executing Query : " + "Select * From autoflex");
            rst = stm.executeQuery("query");
            log.info("Query execution successful");
            while (rst.next()) {
                dataList.add(rst.getString("tablecolumnname"));
            }
        } finally {
            //closeConnection(con, stm);
            log.info("Closing Statement");
            stm.close();
            log.info("Closing Connection");
            con.close();
        }
        //channel.disconnect();
        jumpboxSession.disconnect();
        log.info("Dataset : " + dataList);
    }

    private Session getSession(JSch jsch, String serverUsername, String serverHost, String serverPassword, int port) throws JSchException {
        Session jumpboxSession = jsch.getSession(serverUsername, serverHost, port);
        jumpboxSession.setPassword(serverPassword);

        Properties config = new Properties();
        config.put("trust", "true");
        config.put("StrictHostKeyChecking", "no");
        config.put("HashKnownHosts", "yes");

        jumpboxSession.setConfig(config);
        log.info("Establishing Connection to : " + serverHost);
        jumpboxSession.connect();
        log.info("Connected to : " + serverHost);
        return jumpboxSession;
    }

    @When("I connect to {string} database and fire a update query as {string}")
    public void iConnectToDatabaseAndFireAUpdateQueryAs(String dataBaseName, String query) throws SQLException, InterruptedException, ClassNotFoundException {
        log.info("Database Name : " + dataBaseName);
        getDatabaseDetails(dataBaseName);
        DatabaseHelper.updateQuery(dbDetails.get("databaseHostname"),
                dbDetails.get("databaseUsername"),
                dbDetails.get("databasePassword"),
                query);
    }

    @And("I delete the data from {string} database and create fresh data")
    public void iDeleteTheDataFromCleanAndRotateDatabase(String dataBaseName) throws SQLException {
        log.info("Database Name : " + dataBaseName);
        getDatabaseDetails(dataBaseName);
        DatabaseHelper.DeleteandUpdateQueryforCandR(dbDetails.get("databaseHostname"),
                dbDetails.get("databaseUsername"),
                dbDetails.get("databasePassword"));
    }

}
