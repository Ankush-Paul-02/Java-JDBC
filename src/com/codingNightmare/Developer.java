package com.codingNightmare;

import java.sql.*;

public class Developer {
    public void createTable() {
        try {
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String username = "System";
            String password = "root";
            String query = "CREATE table Developer(id number, name varchar2(255), skill varchar2(255), primary key (id))";

            //? Driver load
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //? Connection establish
            Connection connection = DriverManager.getConnection(url, username, password);
            //? Statement
            Statement statement = connection.createStatement();
            //? execute Query
            statement.execute(query);
            //? connection close
            System.out.println("Table created successfully...");
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createData() {
        try {
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String username = "System";
            String password = "root";
            String query = "INSERT into DEVELOPER (ID, NAME, SKILL) VALUES (?, ?, ?)";

            //? Driver load
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //? Connection establish
            Connection connection = DriverManager.getConnection(url, username, password);

            //? Statement
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "Sidhant");
            preparedStatement.setString(3, "C++");

            //? execute Query
            preparedStatement.execute();

            //? connection close
            System.out.println("Data inserted successfully...");
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readData() {
        try {
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String username = "System";
            String password = "root";
            String query = "SELECT * from DEVELOPER";

            //? Driver load
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //? Connection establish
            Connection connection = DriverManager.getConnection(url, username, password);

            //? Statement
            Statement statement = connection.createStatement();

            //? execute Query
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1));
                System.out.println("Name: " + resultSet.getString(2));
                System.out.println("Skill: " + resultSet.getString(3));
                System.out.println("---------------------------------");
            }

            //? connection close
            System.out.println("Data read successfully...");
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateData() {
        try {
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String username = "System";
            String password = "root";
            String query = "update DEVELOPER set SKILL = ? where ID = ?";

            // Driver load
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connection establish
            Connection connection = DriverManager.getConnection(url, username, password);

            // PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "Java");
            preparedStatement.setInt(2, 1);

            // Execute Query
            int rowsAffected = preparedStatement.executeUpdate();

            // Connection close
            connection.close();

            if (rowsAffected > 0) {
                System.out.println("Data updated successfully...");
            } else {
                System.out.println("No rows updated.");
            }
        } catch (Exception e) {
            System.err.println("An error occurred: ");
            e.printStackTrace();
        }
    }

    public void deleteData() {
        try {
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String username = "System";
            String password = "root";
            String query = "DELETE from DEVELOPER where ID = ?";

            // Driver load
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connection establish
            Connection connection = DriverManager.getConnection(url, username, password);

            // PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 2);


            // Execute Query
            int rowsAffected = preparedStatement.executeUpdate();

            // Connection close
            System.out.println("Data deleted successfully...");
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
