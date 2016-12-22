package businesslogic.roombl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogicservice.roombusinesslogicservice.RoomBusinessLogicService;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.roomdataservice.RoomDataService;
import dataservice.roomdataservice.RoomFactory;
import po.HotelPO;
import po.RoomPO;
import vo.RoomVO;

public class RoomBL implements RoomBusinessLogicService{

	private RoomDataService rds;

    public RoomBL()throws RemoteException {
        try{
            RoomFactory roomFactory=(RoomFactory) Naming.lookup("rmi://127.0.0.1:1234/roomFactory");
            this.rds=roomFactory.createRoomDataService();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

	public RoomVO getRoom(long roomStyle)throws RemoteException{
		RoomPO rpo=this.rds.find(roomStyle);
		return new RoomVO(rpo.getRoomID(),rpo.getRoomType(),rpo.getRoomTotalNumber(),rpo.getRoomAccessNumber(),
				rpo.getRoomPrice());
	}
	public boolean changeRoom(RoomVO rv)throws RemoteException{
		RoomPO rpo=this.rds.find(rv.getRoomID());
		return rds.update(new RoomPO(rv.getRoomID(),rv.getRoomType(),rv.getRoomTotalNumber(),
				rv.getRoomAccessNumber(),rv.getRoomPrice()));
	}
}
