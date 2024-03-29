package atosWebProjectRPretto.mySQL;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



public class MySQLR {
    
    public Connection conn;
    public Statement stmt;
    public ResultSet rs;

    public boolean connect(String address, String port, String dataBaseName, String user, String password) throws ClassNotFoundException {
        boolean status = false; 
        Class.forName("com.mysql.jdbc.Driver");
        try {
        	
            conn = DriverManager.getConnection("jdbc:mysql://"+ address + ":" + port +"/"+ dataBaseName + "?user=" + user + "&password=" + password + "&useTimezone=true&serverTimezone=UTC"); 
            status = true;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return status;
    }
  
    public int executeUpdate(String query) {     
        int status = 0;
        try {
            stmt = conn.createStatement();           
            status = stmt.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return status;
    }
    

    public ResultSet executeQuery(String query) {
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return rs;   
    }
    
    
}
