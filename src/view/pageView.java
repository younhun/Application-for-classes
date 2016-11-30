package view;

import java.util.Scanner;

public class pageView {

	public void showPage() {
		Scanner scanner = new Scanner(System.in);
		int num;
		System.out.println("원하는 페이지를 선택하시오");
		System.out.println("1. 성적조회");
		System.out.println("2. 과제제출");
		while (true) {
			num = scanner.nextInt();
			if (num == 1) {
				ScoreView scoreview = new ScoreView();
				scoreview.showScore(scanner);
				;
				System.out.println("원하는 페이지를 선택하시오");
				System.out.println("1. 성적조회");
				System.out.println("2. 과제제출");
				System.out.println("종료하려면 0 을 누르시오.");
			} else if (num == 2) {
				HWView homeworkview = new HWView();
				homeworkview.showHw(scanner);
				System.out.println("원하는 페이지를 선택하시오");
				System.out.println("1. 성적조회");
				System.out.println("2. 과제제출");
				System.out.println("종료하려면 0 을 누르시오.");
			} else if (num == 0) {
				break;
			} else {
				System.out.println("===잘못된 선택입니다.===");
			}

		}

	}
}