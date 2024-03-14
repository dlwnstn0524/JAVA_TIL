package self.march._0314;

import java.util.List;

public class EmpTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmpDAO dao = new EmpDAO();
		
		List<Emp> list = dao.selectEmpList();
		System.out.println(list);
		
//		dao.insertEmp(new Emp("200", "고길동", null, null, null, 0, 0, "10"));
//		dao.updateEmp(new Emp("200", "스톱길동", null, null, null, 0, 0, "10"));
//		dao.deleteEmp("200");
//		list = dao.selectEmpList();
//		System.out.println(list);
		
		Emp e = dao.selectEmpOne("7934");
		System.out.println(e);
	}

}
