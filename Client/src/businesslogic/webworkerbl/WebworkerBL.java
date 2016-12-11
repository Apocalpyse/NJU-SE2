package businesslogic.webworkerbl;

import java.rmi.RemoteException;

import businesslogicservice.webworkerbusinesslogicservice.WebworkerBusinessLogicService;
import dataservice.webworkerdataservice.WebworkerDataService;
import dataservice.webworkerdataservice.WebworkerDataServiceSqlImpl;
import po.WebworkerPO;
import vo.WebworkerVO;

public class WebworkerBL implements WebworkerBusinessLogicService {
	WebworkerDataServiceSqlImpl wds;
	static long countWeb = 80000;

	public WebworkerVO getWebworker(long id) throws RemoteException {
		WebworkerVO vo = new WebworkerVO();
		WebworkerPO po;
		po = this.wds.find(id);
		vo.setAuthority(po.getAuthority());
		vo.setID(po.getID());
		vo.setWebworkerName(po.getWebworkerName());
		vo.setWebworkerPhone(po.getWebworkerPhone());
		return vo;
	}

	public boolean creatWebworker(WebworkerVO vo) throws RemoteException {
		WebworkerPO po = new WebworkerPO();
		po.setAuthority(vo.getAuthority());
		po.setID(vo.getID());
		po.setWebworkerName(vo.getWebworkerName());
		po.setWebworkerPhone(vo.getWebworkerPhone());
		this.wds.insert(po);
		return true;
	}

	public boolean changeWebworker(WebworkerVO vo) throws RemoteException {
		WebworkerPO po = new WebworkerPO();
		po.setAuthority(vo.getAuthority());
		po.setID(vo.getID());
		po.setWebworkerName(vo.getWebworkerName());
		po.setWebworkerPhone(vo.getWebworkerPhone());
		this.wds.update(po);
		return true;
	}
}
