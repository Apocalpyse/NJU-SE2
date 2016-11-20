package po;

/**
 * Created by 常德隆 on 2016/11/19.
 */
public class UserPO {
    private String account;
    private String password;

    public UserPO(){}

    public UserPO(String account,String password){
        this.account=account;
        this.password=password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
