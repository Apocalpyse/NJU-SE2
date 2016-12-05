package dataservice.userdataservice;

import po.UserPO;

/**
 * Created by 常德隆 on 2016/12/5.
 */
public interface UserDataServiceSqlImpl extends UserDataService {
    @Override
    void updata(UserPO po);

    @Override
    void insert(UserPO po);

    @Override
    void init();

    @Override
    void finish();

    @Override
    UserPO find(String account);

    @Override
    void delete(long id);
}
