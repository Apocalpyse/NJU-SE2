package dataservice.webworkerdataservice;

import po.WebworkerPO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface WebworkerDataService {
    public WebworkerPO find(long id);
    public void insert(WebworkerPO po);
    public void delete(long id);
    public void updata(WebworkerPO po);
    public void init();
    public void finish();
}
