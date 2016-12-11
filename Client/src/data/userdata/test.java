package data.userdata;

import po.UserPO;

/**
 * Created by 常德隆 on 2016/12/11.
 */
public class test {
    public static void main(String[] args){
        UserData ud=new UserData();
        UserPO upo=ud.find("changdelong");
        System.out.print(upo.getId());
    }
}
