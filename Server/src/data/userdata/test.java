package data.userdata;


import dataservice.userdataservice.UserDataService;
import po.UserPO;

/**
 * Created by 常德隆 on 2016/12/11.
 */
public class test {
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

        @Override
        public long findMaxId() {
            return 0;
        }
    };
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
