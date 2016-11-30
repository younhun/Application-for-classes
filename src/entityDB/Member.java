package entityDB;

import java.sql.ResultSet;
import valueObject.UserInfo;

public class Member {
	Database database = Database.getInstance();

	private UserInfo userInfo = new UserInfo();

	public boolean assertUserID(String id) throws Exception {
		database.connect();
		@SuppressWarnings("unused")
		String sql = " select * from login ";
		ResultSet rs = database.select("login", "id =" + id);

		if (rs.next()) {
			userInfo.setId(rs.getString("id"));
			userInfo.setPassword(rs.getString("password"));
			database.disconnect();
			return true;
		} else {
			database.disconnect();
			return false;
		}
	}

	public String getPassword(String id) {
		return this.userInfo.getPassword();
	}
}
