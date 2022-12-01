package shop.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	private final String serverName = "DUCTHINHPC";
	private final String dbName = "Shop2H2T";
	private final String portNumber = "1433";
	private final String instance = "";
	private final String userID = "sa";
	private final String password = "chetzoitao11";

	public Connection getConnection() throws Exception {
		/*
		 * String url = "jdbc:sqlserver://" + serverName + ":" + portNumber +
		 * "\\" + instance + ";databaseName=" + dbName; if (instance == null ||
		 * instance.trim().isEmpty()) url = "jdbc:sqlserver://" + serverName + ":" +
		 * portNumber + ";databaseName=" + dbName;
		 * Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); return
		 * DriverManager.getConnection(url, userID, password);
		 */
		
		/*
		 * String dbDriver = "com.mysql.cj.jdbc.Driver"; String dbURL =
		 * "jdbc:mysql:// localhost:3306/"; String dbName = "shop2h2t"; String
		 * dbUsername = "sa"; String dbPassword = "chetzoitao11";
		 */
        
        String dbDriver = "com.mysql.cj.jdbc.Driver";
        String dbURL = "jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/";
        String dbName = "heroku_1f18e357922ed0b";
        String dbUsername = "b71838fafce352";
        String dbPassword = "e79fa92a";
  
        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL + dbName,
                                                     dbUsername, 
                                                     dbPassword);
        return con;
	}
	
	public static void main(String[] args) throws Exception {
		DbConnection conn = new DbConnection();
		System.out.println(conn.getConnection());
	}
}
