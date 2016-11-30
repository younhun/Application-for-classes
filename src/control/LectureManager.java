package control;

import java.util.Vector;

import entityDB.Lecture;
import valueObject.LectureInfo;

public class LectureManager {// Lecture �� ������ �ʿ��Ѱ͸� �����Ѵ�.
	private Lecture lecture;

	public LectureManager() {
		this.lecture = new entityDB.Lecture();
	}

	public Vector<LectureInfo> getList(String departmentID) throws Exception {
		Vector<LectureInfo> lecturelist = lecture.getList(departmentID);
		return lecturelist;
	}

	public Vector<LectureInfo> getList() throws Exception {
		Vector<LectureInfo> lecturelist = lecture.getList(null);
		return lecturelist;
	}

}
