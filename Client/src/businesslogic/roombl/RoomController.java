package businesslogic.roombl;

import java.rmi.RemoteException;

import dataservice.roomdataservice.RoomDataService;
import po.RoomPO;
import vo.RoomVO;

public class RoomController {
	RoomBL rbl;
	public RoomController()throws RemoteException{
		rbl=new RoomBL();
	}
	public RoomVO getRoom(long id)throws RemoteException{
		return rbl.getRoom(id);
	}
	public boolean changeRoom(RoomVO rv)throws RemoteException{
		return rbl.changeRoom(rv);
	}
}
