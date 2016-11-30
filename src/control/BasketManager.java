package control;

import java.util.Vector;
import valueObject.LectureInfo;
import entityFile.Lecture;

public class BasketManager {
	private Lecture lecture;

	public Vector<LectureInfo> getLectureList(String departmentID) throws Exception {
		Vector<LectureInfo> lecturelist = lecture.getList(departmentID);
		return lecturelist;
	}

	public Vector<LectureInfo> LectureListView(Vector<LectureInfo> myLectureList) {
		System.out.println();
		System.out.println("내 강의 목록입니다.");
		System.out.println("강좌번호   / 학과번호  /  강좌명 ");
		for (int i = 0; i < myLectureList.size(); i++) {
			System.out.println(myLectureList.get(i).getId() + " / " + myLectureList.get(i).getDepartmentID() + " / "
					+ myLectureList.get(i).getName());
		}

		return myLectureList;
	}

}
