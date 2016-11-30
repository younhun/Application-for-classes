package control;

import java.util.Vector;
import valueObject.DepartmentInfo;
import entityDB.Department;

public class DepartmentManager {
	private Department department;

	public DepartmentManager() {
		this.department = new entityDB.Department();
	}

	public Vector<DepartmentInfo> getList() throws Exception {
		Vector<DepartmentInfo> departmentlist = this.department.getList();
		return departmentlist;
	}
}
