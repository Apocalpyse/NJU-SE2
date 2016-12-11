package dataservice.orderdataservice;

import po.OrderPO;

/**
 * Created by 常德隆 on 2016/12/5.
 */
public interface OrderDataServiceSqlImpl extends OrderDataService{
    @Override
    void delete(long id);

    @Override
    void insert(OrderPO po);

    @Override
    OrderPO find(long id);

    @Override
    void update(OrderPO po);
}
