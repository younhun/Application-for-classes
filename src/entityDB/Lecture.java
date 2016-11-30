package entityDB;

import java.sql.ResultSet;
import java.util.Vector;

import valueObject.LectureInfo;

public class Lecture {
	private Database database = Database.getInstance();
	private Vector<LectureInfo> lectureList;
	private LectureInfo lectureinfo;

	public Vector<LectureInfo> getList(String departmentID) throws Exception {

		lectureList = new Vector<LectureInfo>();

		database.connect();
		@SuppressWarnings("unused")
		String sql = " select * from lecture ";
		ResultSet rs = database.select("lecture");
		while (rs.next()) {

			lectureinfo = new LectureInfo(null, null, null);
			lectureinfo.setId(rs.getString("id"));
			lectureinfo.setDepartmentID(rs.getString("departmentID"));
			lectureinfo.setName(rs.getString("name"));

			lectureList.add(lectureinfo);
		}
		database.disconnect();
		return lectureList;
	}

	public void putList(Vector<LectureInfo> lectureList) {
	}
}
