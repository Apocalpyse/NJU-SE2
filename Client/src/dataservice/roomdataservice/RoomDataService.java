package dataservice.roomdataservice;

import po.RoomPO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface RoomDataService {
    public RoomPO find(long id);
    public void insert(RoomPO po);
    public void delete(long id);
    public void update(RoomPO po);
}
