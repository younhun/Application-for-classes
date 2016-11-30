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
		// ������ �Է��Ѵ�.
		FileWriter fw = null;// �Է��� �ý�Ʈ ������ fw�� ����
		BufferedWriter bw = null;// fw�� �����Ѱ��� ����.
		// �� �ΰ��� ���� ���� ���ٰ� ����ȴ�.

		try {
			fw = new FileWriter("score.txt");
			bw = new BufferedWriter(fw);

			for (int i = 0; i < scorelist.size(); i++) {
				bw.write(scorelist.get(i).getNumber() + " " + scorelist.get(i).getName() + " "
						+ scorelist.get(i).getScore());
				// departmentlist ���ִ� ���̵�� �̸� ����
				bw.newLine();
			}
			System.out.println("���� ���� �ۼ� �Ϸ�");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();// �ݱ� bw=>fw ������ �ݾƾ��Ѵ�.
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();// �ݱ� bw=>fw ������ �ݾƾ��Ѵ�.
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
		// Control ���� �ҷ� ���δ�.
		// ������ �Է��� ������ �ҷ� �������� �Լ�
		Vector<ScoreInfo> scoreFile = new Vector<ScoreInfo>();// ���Ͽ��� ���� ������ ����
																// ����

		FileReader fr = null;
		BufferedReader br = null;

		String data;
		try {
			fr = new FileReader("score.txt");
			br = new BufferedReader(fr);

			String[] temp; // temp String �迭 ����
			while ((data = br.readLine()) != null) {// ������ ���� ������ �д´�.
				temp = data.split(" ");// temp��� �迭�� " " ��� �������� ������ String�� ����.
				scoreFile.add(new ScoreInfo(temp[0], temp[1], temp[2]));
				// ID�� int �����̱⶧���� String ������ temp �� �����ϱ����� ����

			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// ������ ���� �ݴ�� �ݾƾ� �Ѵ�.
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
