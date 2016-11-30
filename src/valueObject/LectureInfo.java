package valueObject;

public class LectureInfo {
	private String id;
	private String departmentID;
	private String name;

	public LectureInfo(String id, String departmentID, String name) {
		this.id = id;
		this.departmentID = departmentID;
		this.name = name;
	}

	public LectureInfo(){
		this.id = id;
		this.name = name;
	}
	public String getDepartmentID() {
		return departmentID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

}
