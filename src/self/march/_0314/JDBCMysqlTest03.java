package self.march._0314;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCMysqlTest03 {

	static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String URL = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	static final String DB_ID = "ssafy";
	static final String DB_PWD = "ssafy";
	
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet res = null;
		
		// 1. Driver loading
		try {
			Class.forName(DRIVER);
			// 2. Connection
			conn = DriverManager.getConnection(URL, DB_ID, DB_PWD);
			// 3. Statement Create
			st = conn.createStatement();
			String sql = "";
			// 4. SQL Execute
			boolean exe = st.execute("insert into emp (empno, ename, sal)"
					+ "values(100, '홍길동', 10000)"); // select 아닌 다른 쿼리문일때
			
			res = st.executeQuery("select * from emp");
			// 5. Result
			while(res.next()) {
				System.out.println(res.getString("empno") + " : " + res.getString("ename"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(res!=null)res.close();
				if(st!=null)st.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
