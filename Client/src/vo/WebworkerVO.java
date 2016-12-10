package vo;

import po.Authority;

public class WebworkerVO {
	private long ID;
	private String webworkerName;
	private String webworkerPhone;//电话
	private Authority authority;//权限
	//constructor
	public WebworkerVO(){
		
	}
	
	public WebworkerVO(long iD, String webworkerName, String webworkerPhone, Authority authority) {
		super();
		ID = iD;
		this.webworkerName = webworkerName;
		this.webworkerPhone = webworkerPhone;
		this.authority = authority;
	}

	public String getWebworkerPhone() {
		return webworkerPhone;
	}

	public void setWebworkerPhone(String webworkerPhone) {
		this.webworkerPhone = webworkerPhone;
	}

	public long getID() {
		return ID;
	}
	public void setID(long ID) {
		this.ID = ID;
	}
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

}
