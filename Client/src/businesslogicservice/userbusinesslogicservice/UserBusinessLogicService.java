package businesslogicservice.userbusinesslogicservice;

import po.UserPO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface UserBusinessLogicService {
    public UserPO getUser(String id);
    public boolean login(String account,String password);
    public boolean register(String account,String password);
}
