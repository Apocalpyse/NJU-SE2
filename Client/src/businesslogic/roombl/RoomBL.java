package businesslogic.roombl;

import businesslogicservice.roombusinesslogicservice.RoomBusinessLogicService;
import dataservice.roomdataservice.RoomDataService;
import po.RoomPO;
import vo.RoomVO;

public class RoomBL implements RoomBusinessLogicService{
	public RoomVO getRoom(String roomStyle){
		RoomDataService roomDataService=new RoomDataService();
		RoomVO rv=new RoomVO();
		RoomPO rp;
		rp=roomDataService.find(roomStyle);
		rv.setRoomType(rp.getRoomType());
		rv.setRoomTotalNumber(rp.getRoomTotalNumber());
		rv.setRoomAccessNumber(rp.getRoomAccessNumber());
		rv.setRoomPrice(rp.getRoomPrice()); 
		
		return rv;
	}
	public boolean changeRoom(RoomVO rv){
		boolean result=false;
		RoomDataService roomDataService2=new RoomDataService();
		RoomPO rp2;
		rp2=roomDataService2.find(rv.getRoomType());
		
		rp2.setRoomType(rv.getRoomType());
		rp2.setRoomTotalNumber(rv.getRoomTotalNumber());
		rp2.setRoomAccessNumber(rv.getRoomAccessNumber());
		rp2.setRoomPrice(rv.getRoomPrice());
		result=true;
		return result;
	}
}
