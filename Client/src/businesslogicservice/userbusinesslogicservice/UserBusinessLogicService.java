package businesslogicservice.userbusinesslogicservice;

import po.User;
import po.UserPO;
import vo.UserVO;

import java.rmi.RemoteException;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface UserBusinessLogicService {
     UserVO getUser(String id)throws RemoteException;
     boolean changeUser(UserVO vo) throws RemoteException;
     boolean login(String account,String password)throws RemoteException;
     boolean register(String account, String password, long id, User user)throws RemoteException;
}
