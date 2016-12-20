package businesslogic.webworkerbl;

import java.rmi.RemoteException;

import vo.WebworkerVO;

public class WebworkerController {
	WebworkerBL bl;

	public WebworkerController()throws RemoteException {
		bl = new WebworkerBL();
	}

	public WebworkerVO getWebworker(long id) throws RemoteException {
		return bl.getWebworker(id);
	}

	public boolean creatWebworker(WebworkerVO vo) throws RemoteException {
		return bl.creatWebworker(vo);
	}

	public boolean changeWebworker(WebworkerVO vo) throws RemoteException {
		return bl.changeWebworker(vo);
	}
	public long findMaxId() throws RemoteException {
		return bl.findMaxId();
	}
}
