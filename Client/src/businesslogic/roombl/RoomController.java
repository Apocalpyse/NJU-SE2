package businesslogic.roombl;

import dataservice.roomdataservice.RoomDataService;
import po.RoomPO;
import vo.RoomVO;

public class RoomController {
	RoomBL rbl;
	public RoomController(){
		rbl=new RoomBL();
	}
	public RoomVO getRoom(String roomStyle){
		return rbl.getRoom(roomStyle);
	}
	public boolean changeRoom(RoomVO rv){
		return rbl.changeRoom(rv);
	}
}
