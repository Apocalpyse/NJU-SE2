package dataservice.webworkerdataservice;

import po.WebworkerPO;

/**
 * Created by 常德隆 on 2016/12/5.
 */
public interface WebworkerDataServiceSqlImpl extends WebworkerDataService {
    @Override
    void delete(long id);

    @Override
    void insert(WebworkerPO po);

    @Override
    void update(WebworkerPO po);

    @Override
    WebworkerPO find(long id);
}
