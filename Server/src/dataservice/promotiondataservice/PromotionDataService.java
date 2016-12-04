package dataservice.promotiondataservice;

import po.PromotionPO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface PromotionDataService {
    public PromotionPO find(long id);
    public void insert(PromotionPO po);
    public void delete(long id);
    public void updata(PromotionPO po);
    public void init();
    public void finish();
}
