package dataservice.promotiondataservice;

import po.HotelPromotionPO;
import po.MemberPromotionPO;
import po.PromotionPO;
import po.WebPromotionPO;

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
    HotelPromotionPO find2(long id);

    @Override
    MemberPromotionPO find1(long id);

    @Override
    WebPromotionPO find3(long id);

    @Override
    void delete(long id);
}
