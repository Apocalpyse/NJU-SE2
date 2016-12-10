package businesslogic.userbl;

import businesslogicservice.userbusinesslogicservice.UserBusinessLogicService;
import dataservice.userdataservice.UserDataService;
import dataservice.userdataservice.UserDataServiceSqlImpl;
import po.UserPO;
import vo.UserVO;

/**
 * Created by 常德隆 on 2016/11/19.
 */
public class UserBL implements UserBusinessLogicService{

    UserDataServiceSqlImpl uds;
    private long UserID=10000;

    public UserVO getUser(String account){
        UserVO vo=new UserVO();
        UserPO po;
        po=this.uds.find(account);
        vo.setAccout(po.getAccount());
        vo.setPasssword(po.getPassword());
        vo.setId(po.getId());
        return vo;
    }

    @Override
    public boolean changeUser(UserVO vo) {
        UserPO po;
        po=this.uds.find(vo.getAccout());
        po.setAccount(vo.getAccout());
        po.setPassword(vo.getPasssword());
        po.setId(vo.getId());
        return true;
    }

    public boolean login(String account, String password){
        boolean result=false;
        UserPO po;
        po=this.uds.find(account);
        if(po.getPassword()==password){
            result=true;
        }
        return result;
    }
    public boolean register(String account,String password){
        boolean result=false;
        UserPO po;
        po=this.uds.find(account);
        if(po.getAccount()!=null){
            result=false;
        }
        else{
            result=true;
            UserID++;
            po.setAccount(account);
            po.setPassword(password);
            po.setId(UserID);
            uds.insert(po);
        }
        return result;
    }
}
