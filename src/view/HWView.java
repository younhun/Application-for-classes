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

		studentManager.LectureListView(MyLecture.getMyLectureFile());// ���Ͽ��� ������
																		// �����
																		// �ҷ���
		MyLecture.getMyLectureFile();
		this.myHWList = myHW.readMyHWFile();

		boolean checker = false;
		System.out.println("===��������===  ");
		System.out.println("===��������Ʈ===  ");
		for (int i = 0; i < myHWList.size(); i++) {
			System.out.println(myHWList.get(i).getNumber() + "  " + myHWList.get(i).getName());
		}
		System.out.println();
		System.out.println("������ ���� ������ ���¹�ȣ�� �Է��ϼ���: ");

		while (true) {
			String id = sc.next();
			checker = false;
			for (int i = 0; i < myHWList.size(); i++) {
				if (myHWList.get(i).getNumber().equals(id)) {
					System.out.println("��������Ϸ�");
					checker = true;
				}

			}
			if (checker == false) {
				System.out.println("�ش簭�°� �����ϴ�.");
			}

			System.out.println("���������� ����Ϸ��� 1��  �Ϸ��Ͽ����� 0 ���� �����ÿ�.");
			int select = sc.nextInt();
			if (select == 0) {
				break;
			} else if (select == 1) {
				System.out.println("������ ���� ������ ���¹�ȣ�� �Է��ϼ���: ");
			}
		}
	}
}
