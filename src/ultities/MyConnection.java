/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultities;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author hieu1
 */
public class MyConnection {

    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String url = "jdbc:sqlserver://localhost:1433;databaseName=MotorcycleManagement;user=sa;password=123456";

    public static Connection makeConnection() throws Exception {
        Class.forName(driver);
        return DriverManager.getConnection(url);
    }
}
