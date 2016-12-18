package dataservice.userdataservice;

import po.UserPO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface UserDataService {
     UserPO find(String account);
     boolean insert(UserPO po);
     boolean delete(long id);
     boolean update(UserPO po);
     long findMaxId();
}
