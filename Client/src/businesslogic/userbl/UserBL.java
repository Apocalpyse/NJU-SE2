package businesslogic.userbl;

import businesslogicservice.userbusinesslogicservice.UserBusinessLogicService;
import dataservice.userdataservice.UserDataService;
import dataservice.userdataservice.UserDataServiceSqlImpl;
import po.UserPO;

/**
 * Created by 常德隆 on 2016/11/19.
 */
public class UserBL implements UserBusinessLogicService{

    UserDataServiceSqlImpl uds;
    private long UserID=10000;

    public UserPO getUser(String account){
        UserPO po=new UserPO();
        po=this.uds.find(account);
        return po;
    }

    public boolean login(String account,String password){
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
