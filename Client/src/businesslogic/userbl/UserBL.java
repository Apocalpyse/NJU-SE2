package businesslogic.userbl;

import dataservice.userdataservice.UserDataService;
import po.UserPO;

/**
 * Created by 常德隆 on 2016/11/19.
 */
public class UserBL {
    public boolean login(String account,String password){
        boolean result=false;
        UserDataService uds=new UserDataService();
        UserPO po=new UserPO();
        po=uds.find(account);
        if(po.getPassword()==password){
            result=true;
        }
        return result;
    }
    public boolean register(String account,String password){
        boolean result=false;
        UserDataService uds=new UserDataService();
        UserPO po=new UserPO();
        po=uds.find(account);
        if(po.getAccount()!=null){
            result=false;
        }
        else{
            result=true;
            uds.insert(po);
        }
        return result;
    }
}
