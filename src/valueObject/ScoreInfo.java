package valueObject;

public class ScoreInfo {

	private String Number;
	private String Name;
	private String Score;

	public ScoreInfo() {
	}

	public ScoreInfo(String Number, String Name, String Score) {
		this.Number = Number;
		this.Name = Name;
		this.Score = Score;
	}

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

	public String getScore() {
		return Score;
	}

	public void setScore(String score) {
		Score = score;
	}

}