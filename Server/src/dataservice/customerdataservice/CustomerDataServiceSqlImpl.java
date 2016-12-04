package dataservice.customerdataservice;

import data.customerdata.CustomerData;
import po.CustomerPO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public class CustomerDataServiceSqlImpl implements CustomerDataService{
    @Override
    public CustomerPO find(long id) {
        CustomerData cd=new CustomerData();

        return null;
    }

    @Override
    public void updata(CustomerPO po) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void finish() {

    }

    @Override
    public void init() {

    }

    @Override
    public void insert(CustomerPO po) {

    }
}
