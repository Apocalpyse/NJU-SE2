package businesslogic.roombl;

import dataservice.roomdataservice.RoomDataService;
import po.RoomPO;
import vo.RoomVO;

public class RoomController {
	RoomBL rbl;
	public RoomController(){
		rbl=new RoomBL();
	}
	public RoomVO getRoom(long id){
		return rbl.getRoom(id);
	}
	public boolean changeRoom(RoomVO rv){
		return rbl.changeRoom(rv);
	}
}
