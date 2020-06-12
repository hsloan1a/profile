package com.test.profile;


import java.sql.*;

public class ModelCreator {
    private String h2UserName = "sa";

    private String h2Password = "";

    private String jdbcDriver = "org.h2.Driver";

    private String dbUrl = "jdbc:h2:~/test";

    public ModelCreator() {
    }

    public void deleteAllTables(){
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(jdbcDriver);

            conn = DriverManager.getConnection(dbUrl,h2UserName,h2Password);

            stmt = conn.createStatement();
            String sql =  "DROP ALL OBJECTS";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if(stmt!=null) stmt.close();
                if(conn!=null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

    }

    public String showAllTables(){
        Connection conn = null;
        Statement stmt = null;
        String returnString = "";
        try {
            Class.forName(jdbcDriver);

            conn = DriverManager.getConnection(dbUrl,h2UserName,h2Password);

            stmt = conn.createStatement();
            String sql =  "SHOW TABLES;";
            ResultSet resultSet = stmt.executeQuery(sql);
            returnString = "Table(s) found: ";
            while(resultSet.next()) {
                returnString += resultSet.getString(1) + ";";
            }
            stmt.close();
            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if(stmt!=null) stmt.close();
                if(conn!=null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        return returnString;

    }

    public boolean createTable(String tableName){
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(jdbcDriver);

            conn = DriverManager.getConnection(dbUrl,h2UserName,h2Password);

            stmt = conn.createStatement();
            String sql =  "CREATE TABLE " + tableName +
                    " (id INTEGER not NULL)";
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if(stmt!=null) stmt.close();
                if(conn!=null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return true;

    }
}
