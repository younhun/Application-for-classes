package entityFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import valueObject.LectureInfo;

public class Basket {
	public void setMyLectureFile(Vector<LectureInfo> myLectureList) {
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter("myLecture.txt");
			bw = new BufferedWriter(fw);

			for (int i = 0; i < myLectureList.size(); i++) {
				bw.write(myLectureList.get(i).getId() + " " + myLectureList.get(i).getDepartmentID() + " "
						+ myLectureList.get(i).getName());
				bw.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
	}

	public Vector<LectureInfo> getMyLectureFile() {
		// 파일을 읽어서 객체로 반환
		Vector<LectureInfo> myLectureList = new Vector<LectureInfo>();

		FileReader fr = null;
		BufferedReader br = null;
		String data;
		try {
			fr = new FileReader("myLecture.txt");
			br = new BufferedReader(fr);
			String[] temp;

			while ((data = br.readLine()) != null) {
				temp = data.split(" ");
				myLectureList.add(new LectureInfo(temp[0], temp[1], temp[2]));
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 열었던 순서 반대로 닫아줘야함.
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

		return myLectureList;
	}

}
