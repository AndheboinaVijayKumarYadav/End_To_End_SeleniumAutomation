package com.vijay.testing.utils;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DataBaseHelp {

    private static final String URL = "jdbc:mysql://localhost:3306/openshop";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Empty string instead of null

    public Map<String, String> getCustomerData() {

        Map<String, String> data = new HashMap<>();
        String sql = "SELECT * FROM oc_customer LIMIT 1";

        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            if (resultSet.next()) {
                data.put("firstname", resultSet.getString("firstname"));
                data.put("lastname", resultSet.getString("lastname"));
                data.put("email", resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

}