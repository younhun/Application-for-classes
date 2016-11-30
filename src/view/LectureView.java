package view;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;


import control.LectureManager;
import entityFile.Basket;
import valueObject.LectureInfo;
import valueObject.UserInfo;

public class LectureView {

	private LectureManager lectureManager;
	private Basket myLecture;

	public LectureView() {
		this.lectureManager = new LectureManager();
		this.myLecture = new Basket();
	}

	public void showLectureList(String departmentID) throws Exception {
		Vector<LectureInfo> lectureList = this.lectureManager.getList(departmentID);
		System.out.println("���¹�ȣ / �а���ȣ / �����̸�");
		for (int i = 0; i < lectureList.size(); i++) {
			if (lectureList.get(i).getDepartmentID().equals(departmentID)) {
				System.out.println(lectureList.get(i).getId());
				System.out.println(",    ");
				System.out.println(lectureList.get(i).getDepartmentID());
				System.out.println(",    ");
				System.out.println(lectureList.get(i).getName());
				
			}

		}
	}

	

	public Vector<LectureInfo> getLectureID(Scanner sc, UserInfo userInfo) throws Exception {
		// ���Ͻ�ų �ٱ���
		String departmentID = null;
		Vector<LectureInfo> MyLectureList = new Vector<LectureInfo>();
		Vector<LectureInfo> LectureList = this.lectureManager.getList(departmentID);
		// �а� ���¸���Ʈ ���
		System.out.println("������ ���¾��̵� �Է��ϼ���: ");
		String lectureID = null;
		boolean moreInput = true;
		while (moreInput) {
			lectureID = sc.next();
			try {

				for (int i = 0; i < LectureList.size(); i++) {
					if (LectureList.get(i).getId().equals(lectureID)) {
						MyLectureList.add(new LectureInfo(LectureList.get(i).getId(),
								LectureList.get(i).getDepartmentID(), LectureList.get(i).getName()));

						System.out.println("���¹�ȣ " + lectureID + "�� �����ϴ�.");
					}
				}
				// ��±��
			} catch (InputMismatchException e) {
				// e.printStackTrace();
				moreInput = false;
			}

			if (moreInput == false) {
				System.out.println("�߸� �ԷµǾ����ϴ�.");
			}
			System.out.print("��� �Է� �Ϸ���  1�� �����ð� �ƴϸ�  0�Է��ϼ���.");
			int select = sc.nextInt();
			if (select == 0) {
				break;
			} else if (select == 1) {
				System.out.println("������û�� ���¹�ȣ�� �Է��Ͻÿ�");
			}
		}
		myLecture.setMyLectureFile(MyLectureList);
		return LectureList;
	}
}
