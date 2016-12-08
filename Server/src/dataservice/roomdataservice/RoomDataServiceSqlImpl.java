package dataservice.roomdataservice;

import po.RoomPO;

/**
 * Created by 常德隆 on 2016/12/5.
 */
public interface RoomDataServiceSqlImpl extends RoomDataService {
    @Override
    void delete(long id);

    @Override
    void insert(RoomPO po);

    @Override
    RoomPO find(long id);

    @Override
    void update(RoomPO po);
}
