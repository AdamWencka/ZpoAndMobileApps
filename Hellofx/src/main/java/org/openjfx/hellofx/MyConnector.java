/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.hellofx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Biedras
 */
public class MyConnector {

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private String connString = null;

    /*
    Constructor of class, setting connection if possible for given parameters
    String @host - host on which is database
    int @port - port to connect to
    String @db - name of database
    String @user - username
    String @password - password (if no password, pass empty string)
     */
    public MyConnector(String host, int port, String db, String user, String password) {
        connString = "jdbc:mysql://" + host + ":" + port + "/" + db;

        try {
            conn = DriverManager.getConnection(connString, user, password);
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    
//Executing given @statement
    void executeStatement(String statement) {
        try {
            stmt.execute(statement);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

//Return ResltSet from executing given @statement
    ResultSet getResultSet(String statement) {
        rs = null;
        try {
            executeStatement(statement);
            rs = stmt.getResultSet();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return rs;
    }

}
