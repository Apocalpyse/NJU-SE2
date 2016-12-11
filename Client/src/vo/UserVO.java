package vo;

import po.User;

/**
 * Created by 常德隆 on 2016/11/19.
 */
public class UserVO {
    private String accout;
    private String passsword;
    private long id;
    private User user;

    public UserVO(){
        accout="";
        passsword="";
    }

    public String getAccout() {
        return accout;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setAccout(String accout) {
        this.accout = accout;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
