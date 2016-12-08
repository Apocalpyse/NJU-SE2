package dataservice.promotiondataservice;

import po.PromotionPO;

/**
 * Created by 常德隆 on 2016/12/5.
 */
public interface PromotionDataServiceSqlImpl extends PromotionDataService {
    @Override
    void update(PromotionPO po);

    @Override
    void insert(PromotionPO po);

    @Override
    PromotionPO find(long id);

    @Override
    void delete(long id);
}
