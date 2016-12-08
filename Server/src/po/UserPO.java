package po;

import java.io.Serializable;

/**
 * Created by 常德隆 on 2016/11/19.
 */
public class UserPO implements Serializable{
    private String account;
    private String password;
    private long id;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
