package ch06.verify;

public class MemberService {
	boolean login(String id, String password) {
		Member mb = new Member(id, password);
		if(id.equals("hong") && password.equals("12345")) {
			return true;
		}
		return false;
	}
	void logout(String id) {
		System.out.println(id + " 님이 로그아웃 되었습니다");
	}
}
