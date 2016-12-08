package po;

public class WebworkerPO {
		private long ID;
		private String webworkerName;
		private Authority authority;//权限
		//constructor
		public WebworkerPO(){
			
		}
		public WebworkerPO(long iD, String webworkerName, Authority authority) {
			super();
			ID = iD;
			this.webworkerName = webworkerName;
			this.authority = authority;
		}
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
		
}
