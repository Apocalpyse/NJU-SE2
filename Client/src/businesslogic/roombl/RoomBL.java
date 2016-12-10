package businesslogic.roombl;

import businesslogicservice.roombusinesslogicservice.RoomBusinessLogicService;
import dataservice.roomdataservice.RoomDataService;
import dataservice.roomdataservice.RoomDataServiceSqlImpl;
import po.RoomPO;
import vo.RoomVO;

public class RoomBL implements RoomBusinessLogicService{

	RoomDataServiceSqlImpl roomDataService;

	public RoomVO getRoom(long roomStyle){
		RoomVO rv=new RoomVO();
		RoomPO rp;
		rp=this.roomDataService.find(roomStyle);
		rv.setRoomType(rp.getRoomType());
		rv.setRoomTotalNumber(rp.getRoomTotalNumber());
		rv.setRoomAccessNumber(rp.getRoomAccessNumber());
		rv.setRoomPrice(rp.getRoomPrice()); 
		
		return rv;
	}
	public boolean changeRoom(RoomVO rv){
		boolean result=false;
		RoomPO rp2;
		rp2=this.roomDataService.find(rv.getRoomID());
		
		rp2.setRoomType(rv.getRoomType());
		rp2.setRoomTotalNumber(rv.getRoomTotalNumber());
		rp2.setRoomAccessNumber(rv.getRoomAccessNumber());
		rp2.setRoomPrice(rv.getRoomPrice());
		result=true;
		return result;
	}
}
