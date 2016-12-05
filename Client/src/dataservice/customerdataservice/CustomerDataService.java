package dataservice.customerdataservice;

import po.CustomerPO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface CustomerDataService {
    public CustomerPO find(long id);
    public void insert(CustomerPO po);
    public void delete(long id);
    public void updata(CustomerPO po);
    public void init();
    public void finish();
}
