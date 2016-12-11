package businesslogicservice.userbusinesslogicservice;

import po.UserPO;
import vo.UserVO;

import java.rmi.RemoteException;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface UserBusinessLogicService {
    public UserVO getUser(String id)throws RemoteException;
    public boolean changeUser(UserVO vo) throws RemoteException;
    public boolean login(String account,String password)throws RemoteException;
    public boolean register(String account,String password)throws RemoteException;
}
