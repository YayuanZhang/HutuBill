package util;

import java.util.Hashtable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class DBUtil
{
    static String ip;
    static int port;
    static String database;
    static String database_mysql;
    static String encoding;
    static String loginName;
    static String password;
    public static String hsqldbfile;
    
    static {
        DBUtil.ip = "127.0.0.1";
        DBUtil.port = 3306;
        DBUtil.database = "hutubill"; 
        DBUtil.database_mysql = "mysql";
        DBUtil.encoding = "UTF-8";
        DBUtil.loginName = "root";
        DBUtil.password = "123456";
        DBUtil.hsqldbfile = String.format(DBUtil.ip +":%d",DBUtil.port);
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection() throws SQLException {
        String url = String.format("jdbc:mysql://" + DBUtil.hsqldbfile +"/"+DBUtil.database
        		                     +"?characterEncoding="+DBUtil.encoding+"&useSSL=true");
        System.out.println(url);
        return DriverManager.getConnection(url, DBUtil.loginName, DBUtil.password);
    }
    
    public static void main(String[] args) throws SQLException {
       try(Connection c1 = getConnection();
           Connection c2 = getConnection();
           PreparedStatement ps = c2.prepareStatement("select 1 from category");){}
                
    }
}
