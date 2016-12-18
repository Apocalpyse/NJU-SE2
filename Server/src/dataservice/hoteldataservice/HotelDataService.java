package dataservice.hoteldataservice;


import po.HotelPO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface HotelDataService {
     HotelPO find(long id);
     boolean insert(HotelPO po);
     boolean delete(long id);
     boolean update(HotelPO po);
}
