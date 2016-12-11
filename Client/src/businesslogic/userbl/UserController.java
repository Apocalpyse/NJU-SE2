package businesslogic.userbl;

import po.UserPO;
import vo.UserVO;

import java.rmi.RemoteException;

/**
 * Created by 常德隆 on 2016/11/20.
 */
public class UserController {
    UserBL ubl;
    public UserController(){
        ubl=new UserBL();
    }

    public UserVO getUser(String account)throws RemoteException{return ubl.getUser(account);}

    public boolean changeUser(UserVO vo) throws RemoteException{return  ubl.changeUser(vo);}

    public boolean login(String account,String password)throws RemoteException{
        return ubl.login(account,password);
    }

    public boolean register(String account,String password) throws RemoteException{
        return ubl.register(account,password);
    }
}
