/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AliekhandroDelRio
 */
public class MysqlDataBase implements IDBModel {

    private Connection mySqlConnection;
    private Statement mysqlStatement;
    private static MysqlDataBase instance = null;

    private MysqlDataBase() {
    }

    public static MysqlDataBase getInstance() {
        if (instance == null) {
            instance = new MysqlDataBase();
        }
        return instance;
    }

    public Executable select(String query) {
        try {
            Properties prop = new Properties();
            prop.setProperty("user", "root");
            prop.setProperty("password", "");
            prop.put("useUnicode", "false");
            prop.put("characterEncoding", "UTF-8");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            mySqlConnection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/pdd", prop);
            ResultSet rs = mySqlConnection.createStatement().executeQuery(query);
            return new Exec(rs);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        } 
    }

    public Executable insert(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Executable update(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Executable remove(String quety) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
