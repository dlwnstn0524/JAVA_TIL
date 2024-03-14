package self.march._0314;

import java.util.List;

public interface DAO {
	public void insertEmp(Emp e);
	public void updateEmp(Emp e);
	public void deleteEmp(String empno);
	public List<Emp> selectEmpList();
	public Emp selectEmpOne(String empno);
}
