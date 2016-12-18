package dataservice.roomdataservice;

import po.RoomPO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface RoomDataService {
     RoomPO find(long id);
     boolean insert(RoomPO po);
     boolean delete(long id);
     boolean update(RoomPO po);
}
