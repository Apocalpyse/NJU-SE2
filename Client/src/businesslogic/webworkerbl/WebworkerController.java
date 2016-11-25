package businesslogic.webworkerbl;

import vo.WebworkerVO;

public class WebworkerController {
	WebworkerBL bl;

	public WebworkerController() {
		bl = new WebworkerBL();
	}

	public WebworkerVO getWebworker(long id) {
		return bl.getWebworker(id);
	}
	public boolean creatWebworker(WebworkerVO vo) {
		return bl.creatWebworker(vo);
	}
	public boolean changeWebworker(WebworkerVO vo) {
		return bl.changeWebworker(vo);
	}
}
