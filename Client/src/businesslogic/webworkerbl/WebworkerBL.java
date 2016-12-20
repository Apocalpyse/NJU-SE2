package businesslogic.webworkerbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


import businesslogicservice.webworkerbusinesslogicservice.WebworkerBusinessLogicService;
import dataservice.webworkerdataservice.WebworkerDataService;
import dataservice.webworkerdataservice.WebworkerFactory;
import po.WebworkerPO;
import vo.WebworkerVO;

public class WebworkerBL implements WebworkerBusinessLogicService {
	private WebworkerDataService wds ;

	public WebworkerBL() throws RemoteException{
		try {
			WebworkerFactory webworkerFactory=(WebworkerFactory) Naming.lookup("rmi://127.0.0.1:1234/webworkerFactory");
			this.wds=webworkerFactory.createWebworkerDataService();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public WebworkerVO getWebworker(long id) throws RemoteException {
		WebworkerPO po= this.wds.find(id);
		return new WebworkerVO(po.getID(),po.getWebworkerName(),po.getWebworkerPhone(),po.getAuthority());
	}

	public boolean creatWebworker(WebworkerVO vo) throws RemoteException {
		return this.wds.insert(new WebworkerPO(vo.getID(),vo.getWebworkerName(),vo.getWebworkerPhone(),vo.getAuthority()));
	}

	public boolean changeWebworker(WebworkerVO vo) throws RemoteException {
		return this.wds.update(new WebworkerPO(vo.getID(),vo.getWebworkerName(),vo.getWebworkerPhone(),vo.getAuthority()));
	}

	public long findMaxId() throws RemoteException {
		return this.wds.findMaxId();
	}
}
