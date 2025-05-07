package br.com.rocket.testefreshdesk.modules.user.db;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class UserDatabase {
    private static Connection connection;

    public static void conect(){
        try {
            if (connection == null) {
                String url = "jdbc:postgresql://localhost:5432/postgres";
                Properties props = new Properties();
                props.setProperty("user", "postgres");
                props.setProperty("password", "root");
                connection = DriverManager.getConnection(url, props);
                System.out.println("Connection established");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
