package control;

import valueObject.UserInfo;
import entityDB.Member;

public class AuthenticationManager {
	public enum EAutheticationState {
		idNotExist, invalidPassword, authenticated
	};

	private Member member;

	public AuthenticationManager() {
		this.member = new entityDB.Member();
	}

	public EAutheticationState authenticate(UserInfo userInfo) throws Exception {
		if (!this.member.assertUserID(userInfo.getId())) {
			return EAutheticationState.idNotExist;
		}
		String password = this.member.getPassword(userInfo.getId());
		if (!password.equals(userInfo.getPassword()))
			return EAutheticationState.invalidPassword;
		return EAutheticationState.authenticated;
	}
}