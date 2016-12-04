package dataservice.userdataservice;

import po.UserPO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface UserDataService {
    public UserPO find(long id);
    public void insert(UserPO po);
    public void delete(long id);
    public void updata(UserPO po);
    public void init();
    public void finish();
}
