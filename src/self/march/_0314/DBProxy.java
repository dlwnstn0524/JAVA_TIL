package self.march._0314;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBProxy {
	
	public static Connection getConnection() throws SQLException {
		final  String DRIVER = "com.mysql.cj.jdbc.Driver";
	    final  String URL = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	    final  String DB_ID = "ssafy";
	    final  String DB_PWD = "ssafy";
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, DB_ID, DB_PWD);
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SQLException();
		} catch (SQLException ee){
			throw new SQLException();
		}
	}
	
}
