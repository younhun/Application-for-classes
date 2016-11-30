package entityFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import valueObject.UserInfo;

public class Member {
	private UserInfo userInfo = new UserInfo();

	public boolean assertUserID(String id) throws FileNotFoundException {
		File file = new File("member");
		Scanner scanner = new Scanner(file);
		while (scanner.hasNext()) {
			this.userInfo.setId(scanner.next());
			this.userInfo.setPassword(scanner.next());
			if (this.userInfo.getId().equals(id)) {
				scanner.close();
				return true;
			}
		}
		scanner.close();
		return false;
	}

	public String getPassword(String id) {
		return this.userInfo.getPassword();
	}
}
