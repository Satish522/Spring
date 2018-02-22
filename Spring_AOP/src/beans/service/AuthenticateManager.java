package beans.service;

import beans.bo.UserInfo;

public class AuthenticateManager {

	private static ThreadLocal<UserInfo> threadLocal=new ThreadLocal<UserInfo>();
	
	public void login(String userName,String password) {
		threadLocal.set(new UserInfo(userName, password));
	}
	
	public void logout() {
		threadLocal.set(null);
	}
	
	public boolean isAuthenticate() {
		boolean flag=false;
		UserInfo user=threadLocal.get();
		if(user!=null) {
			if(user.getUserName().equals("satish") && user.getPassword().equals("satish#123")) {
				flag=true;
			}
		}
		return flag;
	}
}
