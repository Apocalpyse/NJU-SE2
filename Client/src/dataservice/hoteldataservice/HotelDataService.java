package dataservice.hoteldataservice;


import po.HotelPO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface HotelDataService {
    public HotelPO find(long id);
    public void insert(HotelPO po);
    public void delete(long id);
    public void update(HotelPO po);
}
