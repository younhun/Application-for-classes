package view;

import java.util.Scanner;

public class pageView {

	public void showPage() {
		Scanner scanner = new Scanner(System.in);
		int num;
		System.out.println("���ϴ� �������� �����Ͻÿ�");
		System.out.println("1. ������ȸ");
		System.out.println("2. ��������");
		while (true) {
			num = scanner.nextInt();
			if (num == 1) {
				ScoreView scoreview = new ScoreView();
				scoreview.showScore(scanner);
				;
				System.out.println("���ϴ� �������� �����Ͻÿ�");
				System.out.println("1. ������ȸ");
				System.out.println("2. ��������");
				System.out.println("�����Ϸ��� 0 �� �����ÿ�.");
			} else if (num == 2) {
				HWView homeworkview = new HWView();
				homeworkview.showHw(scanner);
				System.out.println("���ϴ� �������� �����Ͻÿ�");
				System.out.println("1. ������ȸ");
				System.out.println("2. ��������");
				System.out.println("�����Ϸ��� 0 �� �����ÿ�.");
			} else if (num == 0) {
				break;
			} else {
				System.out.println("===�߸��� �����Դϴ�.===");
			}

		}

	}
}