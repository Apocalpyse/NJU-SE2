package data.userdata;


import po.UserPO;

/**
 * Created by 常德隆 on 2016/12/11.
 */
public class test {
    UserDataServiceSqlImpl uds=new UserDataServiceSqlImpl();
    public static void main(String[] args){
        test t=new test();
        int a=t.find();
    }
    public int find(){
        UserPO upo=this.uds.find("changdelong");
        System.out.print(upo.getId());
        return 1;
    }
}
