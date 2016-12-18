package businesslogic.userbl;

import businesslogicservice.userbusinesslogicservice.UserBusinessLogicService;
import dataservice.userdataservice.UserDataService;
import po.User;
import po.UserPO;
import vo.UserVO;

import java.rmi.RemoteException;

/**
 * Created by 常德隆 on 2016/11/19.
 */
public class UserBL implements UserBusinessLogicService{

    UserDataService uds=new UserDataService() {
        @Override
        public UserPO find(String account) {
            return null;
        }

        @Override
        public boolean insert(UserPO po) {
            return false;
        }

        @Override
        public boolean delete(long id) {
            return false;
        }

        @Override
        public boolean update(UserPO po) {
            return false;
        }
    };

    public UserVO getUser(String account) throws RemoteException{
        UserPO po;
        po=this.uds.find(account);
        return new UserVO(po.getAccount(),po.getPassword(),po.getId(),po.getUser());
    }

    @Override
    public boolean changeUser(UserVO vo) throws RemoteException{

        return this.uds.update(new UserPO(vo.getAccout(),vo.getPasssword(),vo.getId(),vo.getUser()));
    }

    public boolean login(String account, String password) throws RemoteException{
        boolean result=false;
        UserPO po=this.uds.find(account);
        if(po.getPassword().equals(password)){
            result=true;
        }
        return result;
    }
    public boolean register(String account, String password, long id, User user) throws RemoteException{
        boolean result=false;
        UserPO po=this.uds.find(account);
        if(po!=null){
            result=false;
        }
        else{
            result=true;
            uds.insert(new UserPO(account,password,id,user));
        }
        return result;
    }
}
