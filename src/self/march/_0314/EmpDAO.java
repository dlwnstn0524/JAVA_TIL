package self.march._0314;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO implements DAO {

	@Override
	public void insertEmp(Emp e) {
		// TODO Auto-generated method stub
		try(Connection conn = DBProxy.getConnection()){
			
			String sql = "insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?) ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, e.getEmpNo());
			pstmt.setString(2, e.geteName());
			pstmt.setString(3, e.getJob());
			pstmt.setString(4, e.getMgr());
			pstmt.setString(5, e.getHireDate());
			pstmt.setInt(6, e.getSal());
			pstmt.setInt(7, e.getComm());
			pstmt.setString(8, e.getDeptno());
			
			// Insert, Update, Delete 등은 executeUpdate() 메소드를 사용한다.
			pstmt.executeUpdate();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void updateEmp(Emp e) {
		try(Connection conn = DBProxy.getConnection()){
			
			String sql = "update emp set ename=?, job=?, mgr=?, hiredate=?, sal=?, comm=?, deptno=? where empno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, e.geteName());
			pstmt.setString(2, e.getJob());
			pstmt.setString(3, e.getMgr());
			pstmt.setString(4, e.getHireDate());
			pstmt.setInt(5, e.getSal());
			pstmt.setInt(6, e.getComm());
			pstmt.setString(7, e.getDeptno());
			pstmt.setString(8, e.getEmpNo());
			
			// Insert, Update, Delete 등은 executeUpdate() 메소드를 사용한다.
			pstmt.executeUpdate();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void deleteEmp(String empno) {
		// TODO Auto-generated method stub
		try(Connection conn = DBProxy.getConnection()){
			
			String sql = "delete from emp where empno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empno);
			
			// Insert, Update, Delete 등은 executeUpdate() 메소드를 사용한다.
			pstmt.executeUpdate();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public List<Emp> selectEmpList() {
		// TODO Auto-generated method stub
		try(Connection conn = DBProxy.getConnection()){
			String sql = "select * from emp";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			List<Emp> list = new ArrayList<>();
			
			while(rs.next()) {
				Emp em = new Emp(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getString(8));
				list.add(em);
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Emp selectEmpOne(String empno) {
		try(Connection conn = DBProxy.getConnection()){
			String sql = "select * from emp where empno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empno);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			Emp em = new Emp(
					rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getInt(6),
					rs.getInt(7),
					rs.getString(8));
			return em;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
