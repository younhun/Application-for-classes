package entityFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import valueObject.ScoreInfo;

public class Score {
	private Vector<ScoreInfo> scorelist;

	public Score() {
		scorelist = getList();
		// 파일을 입력한다.
		FileWriter fw = null;// 입력한 택스트 내용을 fw에 저장
		BufferedWriter bw = null;// fw에 저장한것을 쓴다.
		// 이 두개는 거의 같이 쓴다고 보면된다.

		try {
			fw = new FileWriter("score.txt");
			bw = new BufferedWriter(fw);

			for (int i = 0; i < scorelist.size(); i++) {
				bw.write(scorelist.get(i).getNumber() + " " + scorelist.get(i).getName() + " "
						+ scorelist.get(i).getScore());
				// departmentlist 에있는 아이디와 이름 저장
				bw.newLine();
			}
			System.out.println("강좌 파일 작성 완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();// 닫기 bw=>fw 순으로 닫아야한다.
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();// 닫기 bw=>fw 순으로 닫아야한다.
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
	}

	public Vector<ScoreInfo> getList() {
		Vector<ScoreInfo> scorelist = new Vector<ScoreInfo>();
		scorelist.add(new ScoreInfo("1", "oop1", "A+"));
		scorelist.add(new ScoreInfo("2", "oop2", "A+"));
		scorelist.add(new ScoreInfo("3", "mechanic1", "A"));
		scorelist.add(new ScoreInfo("4", "mechanic2", "A"));
		scorelist.add(new ScoreInfo("5", "chemistry1", "B"));
		scorelist.add(new ScoreInfo("6", "chemistry2", "B"));
		scorelist.add(new ScoreInfo("7", "design1", "B+"));
		scorelist.add(new ScoreInfo("8", "design2", "B+"));
		scorelist.add(new ScoreInfo("9", "english1", "C"));
		scorelist.add(new ScoreInfo("10", "english2", "C"));

		return scorelist;
	}

	public void putList(Vector<ScoreInfo> scorelist) {

	}

	public Vector<ScoreInfo> readScoreFile() {
		// Control 에서 불러 쓰인다.
		// 위에서 입력한 파일을 불러 쓰기위한 함수
		Vector<ScoreInfo> scoreFile = new Vector<ScoreInfo>();// 파일에서 읽은 데이터 저장
																// 백터

		FileReader fr = null;
		BufferedReader br = null;

		String data;
		try {
			fr = new FileReader("score.txt");
			br = new BufferedReader(fr);

			String[] temp; // temp String 배열 만듦
			while ((data = br.readLine()) != null) {// 데이터 한줄 끝까지 읽는다.
				temp = data.split(" ");// temp라는 배열에 " " 라는 기준으로 나눠서 String를 저장.
				scoreFile.add(new ScoreInfo(temp[0], temp[1], temp[2]));
				// ID는 int 형태이기때문에 String 형태인 temp 에 저장하기위해 선언

			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 열었던 순서 반대로 닫아야 한다.
			if (br != null) {
				try {
					br.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
		return scoreFile;
	}

}
