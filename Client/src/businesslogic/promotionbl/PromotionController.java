package businesslogic.promotionbl;
import vo.*;

public class PromotionController {
	PromotionBL bl;

	public PromotionController() {
		bl = new PromotionBL();
	}

	public MemberPromotionVO getMemberPromotion(long id) {
		return bl.getMemberPromotion(id);
	}
	public boolean creatMemberPromotion(MemberPromotionVO vo) {
		return bl.creatMemberPromotion(vo);
	}
	public boolean changeMemberPromotion(MemberPromotionVO vo) {
		return bl.changeMemberPromotion(vo);
	}
	public HotelPromotionVO getHotelPromotion(long id) {
		return bl.getHotelPromotion(id);
	}
	public boolean creatHotelPromotion(HotelPromotionVO vo) {
		return bl.creatHotelPromotion(vo);
	}
	public boolean changeHotelPromotion(HotelPromotionVO vo) {
		return bl.changeHotelPromotion(vo);
	}
	public WebPromotionVO getWebPromotion(long id) {
		return bl.getWebPromotion(id);
	}
	public boolean creatWebPromotion(WebPromotionVO vo) {
		return bl.creatWebPromotion(vo);
	}
	public boolean changeWebPromotion(WebPromotionVO vo) {
		return bl.changeWebPromotion(vo);
	}
}
