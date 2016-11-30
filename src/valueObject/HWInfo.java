package valueObject;

public class HWInfo {
	private String Number;
	private String Name;

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public HWInfo(String Number, String Name) {
		this.Number = Number;
		this.Name = Name;
	}

}
