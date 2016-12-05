package dataservice.promotiondataservice;

import po.PromotionPO;

/**
 * Created by 常德隆 on 2016/12/5.
 */
public interface PromotionDataServiceSqlImpl extends PromotionDataService {
    @Override
    void updata(PromotionPO po);

    @Override
    void insert(PromotionPO po);

    @Override
    void init();

    @Override
    void finish();

    @Override
    PromotionPO find(long id);

    @Override
    void delete(long id);
}
