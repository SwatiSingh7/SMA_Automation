package com.morrisons.sma.page_objects.mobile.old;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlServerConnectivity {

public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
// TODO Auto-generated method stub
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
Connection connection = DriverManager.getConnection( "jdbc:sqlserver://10.4.56.127\\FrontOff:1433",
                       "PI_AUTO_TEST","WtvbZLFnvhQd34vQ");

System.out.println("connect is sucueessful");

Statement statement   = connection.createStatement();
ResultSet result = statement.executeQuery("SELECT * FROM FrontOff.dbo.SEGMENTS");

}

}
