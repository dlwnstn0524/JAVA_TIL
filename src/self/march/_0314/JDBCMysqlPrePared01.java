package self.march._0314;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCMysqlPrePared01 {

	static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String URL = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	static final String DB_ID = "ssafy";
	static final String DB_PWD = "ssafy";
	
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet res = null;
		
		try {
			// 1. Driver loading
			Class.forName(DRIVER);

			// 2. Connection
			conn = DriverManager.getConnection(URL, DB_ID, DB_PWD);
			
			// 3. Statement Create
			String sql = "select * from emp where deptno = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 30);
			
			// 4. SQL Execute
			res = pstmt.executeQuery();
			
			// 5. Result
			while(res.next()) {
				System.out.println(res.getString("empno") + " : " + res.getString("ename") + " : " + res.getInt("deptno"));
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
