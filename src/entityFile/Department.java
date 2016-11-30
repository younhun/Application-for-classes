package entityFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
import valueObject.DepartmentInfo;

public class Department {

	private Vector<DepartmentInfo> departmentlist;

	public Department() {
	}

	public Vector<DepartmentInfo> getList() throws FileNotFoundException {
		departmentlist = new Vector<DepartmentInfo>();

		File file = new File("department");
		Scanner filereader = new Scanner(file);
		while (filereader.hasNext()) {
			DepartmentInfo departementInfo = new DepartmentInfo();
			departementInfo.setId(filereader.next());
			departementInfo.setName(filereader.next());
			departmentlist.add(departementInfo);
		}
		filereader.close();
		return departmentlist;
	}
}
