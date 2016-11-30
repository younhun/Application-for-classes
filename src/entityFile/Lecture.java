package entityFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
import valueObject.LectureInfo;

public class Lecture {
	private Vector<LectureInfo> lectureList;

	public Vector<LectureInfo> getList(String departmentID) throws FileNotFoundException {
		lectureList = new Vector<LectureInfo>();

		File file = new File("lecture");
		Scanner filereader = new Scanner(file);
		while (filereader.hasNext()) {
			LectureInfo lectureInfo = new LectureInfo(null, null, null);
			lectureInfo.setId(filereader.next());
			lectureInfo.setName(filereader.next());
			lectureInfo.setDepartmentID(filereader.next());
			if (lectureInfo.getDepartmentID().equals(departmentID)) {
				this.lectureList.add(lectureInfo);
			}
		}
		filereader.close();
		return lectureList;
	}

	public void putList(Vector<LectureInfo> lectureList) {
	}

}
