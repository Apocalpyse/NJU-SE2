package businesslogic.userbl;

import businesslogicservice.userbusinesslogicservice.UserBusinessLogicService;
import dataservice.userdataservice.UserDataService;
import dataservice.userdataservice.UserFactory;
import po.User;
import po.UserPO;
import vo.UserVO;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by 常德隆 on 2016/11/19.
 */
public class UserBL implements UserBusinessLogicService{

    private UserDataService uds;

    public UserBL() throws RemoteException{
        try {
            UserFactory userFactory=(UserFactory) Naming.lookup("rmi://127.0.0.1:1234/userFactory");
            this.uds=userFactory.createUserDataService();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    public UserVO getUser(String account) throws RemoteException{
        UserPO po;
        po=this.uds.find(account);
        return new UserVO(po.getAccount(),po.getPassword(),po.getId(),po.getUser());
    }

    @Override
    public boolean changeUser(UserVO vo) throws RemoteException{

        return this.uds.update(new UserPO(vo.getAccout(),vo.getPasssword(),vo.getUser()));
    }

    public boolean login(String account, String password) throws RemoteException{
        boolean result=false;
        UserPO po=this.uds.find(account);
        if(po.getPassword().equals(password)){
            result=true;
        }
        return result;
    }
    public boolean register(String account, String password, User user) throws RemoteException{
        boolean result=false;
        UserPO po=this.uds.find(account);
        if(po!=null){
            result=false;
        }
        else{
            result=true;
            uds.insert(new UserPO(account,password,user));
        }
        return result;
    }

    public long findMaxId() throws RemoteException{
        return this.uds.findMaxId();
    }
}
