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
		System.out.println("강좌번호 / 학과번호 / 강좌이름");
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
		// 리턴시킬 바구니
		String departmentID = null;
		Vector<LectureInfo> MyLectureList = new Vector<LectureInfo>();
		Vector<LectureInfo> LectureList = this.lectureManager.getList(departmentID);
		// 학과 강좌리스트 출력
		System.out.println("수강할 강좌아이디를 입력하세요: ");
		String lectureID = null;
		boolean moreInput = true;
		while (moreInput) {
			lectureID = sc.next();
			try {

				for (int i = 0; i < LectureList.size(); i++) {
					if (LectureList.get(i).getId().equals(lectureID)) {
						MyLectureList.add(new LectureInfo(LectureList.get(i).getId(),
								LectureList.get(i).getDepartmentID(), LectureList.get(i).getName()));

						System.out.println("강좌번호 " + lectureID + "가 담겼습니다.");
					}
				}
				// 담는기능
			} catch (InputMismatchException e) {
				// e.printStackTrace();
				moreInput = false;
			}

			if (moreInput == false) {
				System.out.println("잘못 입력되었습니다.");
			}
			System.out.print("계속 입력 하려면  1를 누르시고 아니면  0입력하세요.");
			int select = sc.nextInt();
			if (select == 0) {
				break;
			} else if (select == 1) {
				System.out.println("수강신청할 강좌번호를 입력하시오");
			}
		}
		myLecture.setMyLectureFile(MyLectureList);
		return LectureList;
	}
}
