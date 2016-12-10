package dataservice.promotiondataservice;

import po.HotelPromotionPO;
import po.MemberPromotionPO;
import po.PromotionPO;
import po.WebPromotionPO;

public interface PromotionDataService {
    public MemberPromotionPO find1(long id);
    public HotelPromotionPO find2(long id);
    public WebPromotionPO find3(long id);
    public void insert1(MemberPromotionPO po);
    public void delete1(long id);
    public void update1(MemberPromotionPO po);
    public void insert2(HotelPromotionPO po);
    public void delete2(long id);
    public void update2(HotelPromotionPO po);
    public void insert3(WebPromotionPO po);
    public void delete3(long id);
    public void update3(WebPromotionPO po);
}
