package view;

import java.util.Scanner;
import java.util.Vector;

import control.ScoreManager;
import entityFile.Basket;
import control.BasketManager;
import valueObject.LectureInfo;
import valueObject.ScoreInfo;

public class ScoreView {

	private BasketManager studentmanager;
	private ScoreManager scoremanager;
	private Basket MyLecture;
	private Vector<LectureInfo> myLectureList;

	public ScoreView() {
		this.studentmanager = new BasketManager();
		this.scoremanager = new ScoreManager();
		this.MyLecture = new Basket();

	}

	public void showScore(Scanner sc) {
		System.out.println("내 강의 목록");

		studentmanager.LectureListView(MyLecture.getMyLectureFile());// 파일에서 내강의
																		// 목록을
																		// 불러옴
		myLectureList = MyLecture.getMyLectureFile();

		Vector<ScoreInfo> scoreList = this.scoremanager.getList();

		System.out.println();
		System.out.println("원하는 강좌번호를 입력하시오");
		boolean checker = false;
		while (true) {
			checker = false;
			String id = sc.next();
			for (int i = 0; i < myLectureList.size(); i++) {
				for (int j = 0; j < scoreList.size(); j++) {
					if (myLectureList.get(i).getId().equals(scoreList.get(j).getNumber())
							&& scoreList.get(j).getNumber().equals(id)) {

						System.out.println("해당강좌의 성적 입니다.");

						System.out.println(scoreList.get(j).getNumber() + " " + scoreList.get(j).getName() + " "
								+ scoreList.get(j).getScore());
						checker = true;
					}
				}

			}
			if (checker == false) {
				System.out.println("잘못입력되었습니다.");
			}
			System.out.println("계속 조회하려면 1을 누르시오 완료하였으면 0 번을 누르시오");
			int select = sc.nextInt();
			if (select == 0) {
				break;
			} else if (select == 1) {
				System.out.println("원하는 강좌번호를 입력하시오. ");
			}
		}
	}

}
