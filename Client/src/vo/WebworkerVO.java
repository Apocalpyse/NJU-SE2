package vo;

import po.Authority;

public class WebworkerVO {
	private long ID;
	private String webworkerName;
	private Authority authority;//权限
	private String password;
	
	public long getID() {
		return ID;
	}
	public void setID(long ID) {
		this.ID = ID;
	}//need to think;
	public String getWebworkerName() {
		return webworkerName;
	}
	public void setWebworkerName(String webworkerName) {
		this.webworkerName = webworkerName;
	}
	public Authority getAuthority() {
		return authority;
	}
	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
