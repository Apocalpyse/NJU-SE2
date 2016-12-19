package businesslogic.webworkerbl;

import java.rmi.RemoteException;


import businesslogicservice.webworkerbusinesslogicservice.WebworkerBusinessLogicService;
import dataservice.webworkerdataservice.WebworkerDataService;
import po.WebworkerPO;
import vo.WebworkerVO;

public class WebworkerBL implements WebworkerBusinessLogicService {
	WebworkerDataService wds = new WebworkerDataService() {
		@Override
		public WebworkerPO find(long id) {
			return null;
		}

		@Override

		public boolean insert(WebworkerPO po) {
			return false;
		}

		@Override
		public boolean delete(long id) {
			return false;
		}

		@Override
		public boolean update(WebworkerPO po) {
			return false;
		}

		@Override
		public long findMaxId() {
			return 0;
		}

	};

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
