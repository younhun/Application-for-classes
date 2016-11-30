package view;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

import control.DepartmentManager;
import valueObject.DepartmentInfo;

public class DepartmentView {

	private DepartmentManager departmentManager;
	private Vector<DepartmentInfo> departmentList;

	public DepartmentView() {
		this.departmentManager = new DepartmentManager();
	}

	public void showDepartmentList() throws Exception { // �а���� ���â
		this.departmentList = departmentManager.getList();
		for (int i = 0; i < departmentList.size(); i++) {
			System.out.print(departmentList.get(i).getId());
			System.out.print(", ");
			System.out.println(departmentList.get(i).getName());
		}

	}

	public String getDepartmentID(Scanner sc) {
		String id = null;
		try {
			System.out.println("�а����̵� �Է��ϼ���: ");
			id = sc.next();
		} catch (InputMismatchException e) {
			// e.printStackTrace();
			System.out.println("�а����̵� Ʋ�Ƚ��ϴ�");
		}
		return id;
	}

}
