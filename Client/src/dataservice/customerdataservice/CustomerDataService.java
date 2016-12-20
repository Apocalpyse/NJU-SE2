package dataservice.customerdataservice;

import po.CustomerPO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface CustomerDataService {
     CustomerPO find(long id);
     boolean insert(CustomerPO po);
     boolean delete(long id);
     boolean update(CustomerPO po);
     long findMaxId();
}
