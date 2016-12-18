package dataservice.promotiondataservice;

import po.HotelPromotionPO;
import po.MemberPromotionPO;
import po.PromotionPO;
import po.WebPromotionPO;

public interface PromotionDataService {
     MemberPromotionPO find1(long id);
     HotelPromotionPO find2(long id);
     WebPromotionPO find3(long id);
     boolean insert1(MemberPromotionPO po);
     boolean delete1(long id);
     boolean update1(MemberPromotionPO po);
     boolean insert2(HotelPromotionPO po);
     boolean delete2(long id);
     boolean update2(HotelPromotionPO po);
     boolean insert3(WebPromotionPO po);
     boolean delete3(long id);
     boolean update3(WebPromotionPO po);
     long findMaxId1();
     long findMaxId2();
     long findMaxId3();
}
