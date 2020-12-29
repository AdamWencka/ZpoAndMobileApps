/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.zpo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Adam
 */
public class MyConn {

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private String connString = null;

    public MyConn(String host, int port, String db, String user, String password) {
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

    void executeStatement(String statement) {
        try {
            stmt.execute(statement);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

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
