/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *This class manages all connections and queries to the database.
 */
public class DatabaseController {
    public static final String MySQLDriver= "com.mysql.jdbc.Driver";
    public static final String MySQLURL = "jdbc:mysql://localhost:3306/school?user=root&password=";
    public static final String MySQLURL_2 = "jdbc:mysql://localhost:3306/school?";
    
    protected Statement statement;
    protected Connection connection;
    protected PreparedStatement preparedStatement;
    public DatabaseController() throws ClassNotFoundException, SQLException{
                Class.forName(MySQLDriver);
		connection = DriverManager.getConnection(MySQLURL);
		statement = connection.createStatement();
		statement.setQueryTimeout(30); 
    }
    public DatabaseController(String FirstParameter, String SecondParameter) throws ClassNotFoundException, SQLException{
                Class.forName(MySQLDriver);
		connection = DriverManager.getConnection(MySQLURL_2+"user="+FirstParameter+"&password="+SecondParameter);
                statement = connection.createStatement();
		statement.setQueryTimeout(30); 
    }
    public ResultSet executeQuery(String query) throws SQLException {
		return statement.executeQuery(query);
    }
    public int executeUpdate(String query) throws SQLException {
		return statement.executeUpdate(query);
    }
    public void close() throws SQLException {
		if (connection != null) {
			statement.close();
			connection.close();
		}
    }  
}
