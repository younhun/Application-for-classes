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
		System.out.println("�� ���� ���");

		studentmanager.LectureListView(MyLecture.getMyLectureFile());// ���Ͽ��� ������
																		// �����
																		// �ҷ���
		myLectureList = MyLecture.getMyLectureFile();

		Vector<ScoreInfo> scoreList = this.scoremanager.getList();

		System.out.println();
		System.out.println("���ϴ� ���¹�ȣ�� �Է��Ͻÿ�");
		boolean checker = false;
		while (true) {
			checker = false;
			String id = sc.next();
			for (int i = 0; i < myLectureList.size(); i++) {
				for (int j = 0; j < scoreList.size(); j++) {
					if (myLectureList.get(i).getId().equals(scoreList.get(j).getNumber())
							&& scoreList.get(j).getNumber().equals(id)) {

						System.out.println("�ش簭���� ���� �Դϴ�.");

						System.out.println(scoreList.get(j).getNumber() + " " + scoreList.get(j).getName() + " "
								+ scoreList.get(j).getScore());
						checker = true;
					}
				}

			}
			if (checker == false) {
				System.out.println("�߸��ԷµǾ����ϴ�.");
			}
			System.out.println("��� ��ȸ�Ϸ��� 1�� �����ÿ� �Ϸ��Ͽ����� 0 ���� �����ÿ�");
			int select = sc.nextInt();
			if (select == 0) {
				break;
			} else if (select == 1) {
				System.out.println("���ϴ� ���¹�ȣ�� �Է��Ͻÿ�. ");
			}
		}
	}

}
