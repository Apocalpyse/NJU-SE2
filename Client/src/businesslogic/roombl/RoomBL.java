package businesslogic.roombl;

import businesslogicservice.roombusinesslogicservice.RoomBusinessLogicService;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.roomdataservice.RoomDataService;
import po.HotelPO;
import po.RoomPO;
import vo.RoomVO;

public class RoomBL implements RoomBusinessLogicService{

	RoomDataService rds=new RoomDataService() {
        @Override
        public RoomPO find(long id) {
            return null;
        }

        @Override
        public boolean insert(RoomPO po) {
            return false;
        }

        @Override
        public boolean delete(long id) {
            return false;
        }

        @Override
        public boolean update(RoomPO po) {
            return false;
        }

	
    };

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
