package businesslogic.userbl;

/**
 * Created by 常德隆 on 2016/11/20.
 */
public class UserController {
    UserBL ubl;
    public UserController(){
        ubl=new UserBL();
    }

    public boolean login(String account,String password){
        return ubl.login(account,password);
    }

    public boolean register(String account,String password){
        return ubl.register(account,password);
    }
}
