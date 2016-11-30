package view;

import java.util.Scanner;
import java.util.Vector;

import control.BasketManager;
import entityFile.Basket;
import entityFile.HW;
import valueObject.HWInfo;

public class HWView {
	private BasketManager studentManager;
	private Basket MyLecture;
	private Vector<HWInfo> myHWList;
	private HW myHW;

	public HWView() {
		studentManager = new BasketManager();
		this.MyLecture = new Basket();
		this.myHW = new HW();
		myHW.setMyHWList();

	}

	public void showHw(Scanner sc) {

		studentManager.LectureListView(MyLecture.getMyLectureFile());// 파일에서 내강의
																		// 목록을
																		// 불러옴
		MyLecture.getMyLectureFile();
		this.myHWList = myHW.readMyHWFile();

		boolean checker = false;
		System.out.println("===과제제출===  ");
		System.out.println("===과제리스트===  ");
		for (int i = 0; i < myHWList.size(); i++) {
			System.out.println(myHWList.get(i).getNumber() + "  " + myHWList.get(i).getName());
		}
		System.out.println();
		System.out.println("제출할 과제 과목의 강좌번호를 입력하세요: ");

		while (true) {
			String id = sc.next();
			checker = false;
			for (int i = 0; i < myHWList.size(); i++) {
				if (myHWList.get(i).getNumber().equals(id)) {
					System.out.println("과제제출완료");
					checker = true;
				}

			}
			if (checker == false) {
				System.out.println("해당강좌가 없습니다.");
			}

			System.out.println("과제제출을 계속하려면 1번  완료하였으면 0 번을 누르시오.");
			int select = sc.nextInt();
			if (select == 0) {
				break;
			} else if (select == 1) {
				System.out.println("제출할 과제 과목의 강좌번호를 입력하세요: ");
			}
		}
	}
}
