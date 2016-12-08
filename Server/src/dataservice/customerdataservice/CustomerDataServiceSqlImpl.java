package dataservice.customerdataservice;

import po.CustomerPO;

/**
 * Created by 常德隆 on 2016/12/5.
 */
public interface CustomerDataServiceSqlImpl extends CustomerDataService {
    @Override
    CustomerPO find(long id);

    @Override
    void delete(long id);

    @Override
    void insert(CustomerPO po);

    @Override
    void update(CustomerPO po);
}
