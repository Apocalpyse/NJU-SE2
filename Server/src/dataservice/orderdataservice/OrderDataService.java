package dataservice.orderdataservice;

import po.OrderPO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface OrderDataService {
     OrderPO find(long id);
     boolean insert(OrderPO po);
     boolean delete(long id);
     boolean update(OrderPO po);
}
