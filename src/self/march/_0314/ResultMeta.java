package self.march._0314;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultMeta {
    
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
    private final static String DB_ID = "ssafy";
    private final static String DB_PWD = "ssafy";

    public static void main(String[] args){
//        1. Driver Loading
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            Class.forName(DRIVER);
        
    //        2. Connection
            conn = DriverManager.getConnection(URL, DB_ID , DB_PWD);
    
    //        3. Database meta data call
            statement  = conn.createStatement();
            rs = statement.executeQuery("select * from emp");
            ResultSetMetaData metaData = rs.getMetaData();
            System.out.println(metaData.getColumnCount());
            
            while(rs.next()) {
            	for (int i = 1; i < metaData.getColumnCount(); i++) {
					System.out.print(rs.getString(i) + " : ");
				}
            	System.out.println();
            }
            
    //        4. SQLExecute
            
    //        5. Result

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs != null) {
                    rs.close();    
                }
                if(statement  != null) {
                    statement.close();
                }
                if(conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        

    }

}