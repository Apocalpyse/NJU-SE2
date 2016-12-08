package dataservice.orderdataservice;

import po.OrderPO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface OrderDataService {
    public OrderPO find(long id);
    public void insert(OrderPO po);
    public void delete(long id);
    public void update(OrderPO po);
}
