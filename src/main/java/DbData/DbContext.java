package DbData;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbContext {

    public static Connection connection;

    private DbContext() {
    }

    public static Connection getDbConnection() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = ("jdbc:sqlserver://localhost;database=MVT2021;integratedSecurity=true;");
            Connection connection = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
        return connection;
    }



}

