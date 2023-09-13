package vn.edu.iuh.fit.repositories;

import java.sql.Connection;
import java.sql.SQLException;

public class LogRepository {
    private Connection connection;

    public LogRepository() {
//      connection = ConnectDB.getInstance().getConnection();
    }
    public void log(String message) {
        System.out.println(message);
    }

}