package businesslogic.roombl;

import businesslogicservice.roombusinesslogicservice.RoomBusinessLogicService;
import dataservice.roomdataservice.RoomDataService;
import dataservice.roomdataservice.RoomFactory;
import po.RoomPO;
import vo.RoomVO;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RoomBL implements RoomBusinessLogicService{

	private RoomDataService rds;

    public RoomBL() throws RemoteException{
        try {
            RoomFactory roomFactory=(RoomFactory) Naming.lookup("rmi://127.0.0.1:1234/roomFactory");
            this.rds=roomFactory.createRoomDataService();
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

	public RoomVO getRoom(long roomStyle){
		RoomPO rpo=this.rds.find(roomStyle);
		return new RoomVO(rpo.getRoomID(),rpo.getRoomType(),rpo.getRoomTotalNumber(),rpo.getRoomAccessNumber(),
				rpo.getRoomPrice());
	}
	public boolean changeRoom(RoomVO rv){
		RoomPO rpo=this.rds.find(rv.getRoomID());
		return rds.update(new RoomPO(rv.getRoomID(),rv.getRoomType(),rv.getRoomTotalNumber(),
				rv.getRoomAccessNumber(),rv.getRoomPrice()));
	}
}
