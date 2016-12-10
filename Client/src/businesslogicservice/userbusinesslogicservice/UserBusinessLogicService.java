package businesslogicservice.userbusinesslogicservice;

import po.UserPO;
import vo.UserVO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface UserBusinessLogicService {
    public UserVO getUser(String id);
    public boolean changeUser(UserVO vo);
    public boolean login(String account,String password);
    public boolean register(String account,String password);
}
