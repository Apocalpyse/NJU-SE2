package dataservice.userdataservice;

import po.UserPO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface UserDataService {
    public UserPO find(String account);
    public void insert(UserPO po);
    public void delete(long id);
    public void update(UserPO po);
}
