package businesslogicservice.promotionbusinesslogicservice;

import vo.HotelPromotionVO;
import vo.MemberPromotionVO;
import vo.WebPromotionVO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface PromotionBusinessLogicService {
    public double getDiscount(long id, int room, double price);
    public MemberPromotionVO getMemberPromotion(long id);
    public boolean creatMemberPromotion(MemberPromotionVO vo);
    public boolean changeMemberPromotion(MemberPromotionVO vo);
    public HotelPromotionVO getHotelPromotion(long id);
    public boolean creatHotelPromotion(HotelPromotionVO vo);
    public boolean changeHotelPromotion(HotelPromotionVO vo);
    public WebPromotionVO getWebPromotion(long id);
    public boolean creatWebPromotion(WebPromotionVO vo);
    public boolean changeWebPromotion(WebPromotionVO vo);

}
