package dataservice.webworkerdataservice;

import po.WebworkerPO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface WebworkerDataService {
     WebworkerPO find(long id);
     boolean insert(WebworkerPO po);
     boolean delete(long id);
     boolean update(WebworkerPO po);
     long findMaxId();
}
