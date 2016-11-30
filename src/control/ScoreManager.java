package control;

import java.util.Vector;
import entityFile.Score;
import valueObject.ScoreInfo;

public class ScoreManager {
	private Score score;

	public ScoreManager() {
		score = new Score();
	}

	public Vector<ScoreInfo> getList() {
		Vector<ScoreInfo> scorelist = score.readScoreFile();
		return scorelist;
	}
}