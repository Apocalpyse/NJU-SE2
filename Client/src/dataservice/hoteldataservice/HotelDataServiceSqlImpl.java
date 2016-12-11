package dataservice.hoteldataservice;

import po.HotelPO;

/**
 * Created by 常德隆 on 2016/12/5.
 */
public interface HotelDataServiceSqlImpl extends HotelDataService{
    @Override
    void update(HotelPO po);

    @Override
    void insert(HotelPO po);

    @Override
    HotelPO find(long id);

    @Override
    void delete(long id);
}
