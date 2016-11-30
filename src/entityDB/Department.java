package entityDB;

import java.sql.ResultSet;

import java.util.Vector;
import valueObject.DepartmentInfo;

public class Department {
	private Database database = Database.getInstance();
	private Vector<DepartmentInfo> departmentlist;

	public Department() {
	}

	public Vector<DepartmentInfo> getList() throws Exception {
		departmentlist = new Vector<DepartmentInfo>();

		database.connect();
		@SuppressWarnings("unused")
		String sql = " select * from department ";
		ResultSet rs = database.select("department");
		while (rs.next()) {
			DepartmentInfo departmentinfo = new DepartmentInfo();

			departmentinfo.setId(rs.getString("id"));
			departmentinfo.setName(rs.getString("name"));
			departmentlist.add(departmentinfo);
		}
		database.disconnect();
		return departmentlist;
	}

}
