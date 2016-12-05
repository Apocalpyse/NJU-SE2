package dataservice.promotiondataservice;

import po.HotelPromotionPO;
import po.MemberPromotionPO;
import po.PromotionPO;
import po.WebPromotionPO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface PromotionDataService {
    public MemberPromotionPO find1(long id);
    public HotelPromotionPO find2(long id);
    public WebPromotionPO find3(long id);
    public void insert(PromotionPO po);
    public void delete(long id);
    public void updata(PromotionPO po);
    public void init();
    public void finish();
}
