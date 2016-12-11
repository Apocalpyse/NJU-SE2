package businesslogic.promotionbl;

import java.rmi.RemoteException;

import vo.*;

public class PromotionController {
	PromotionBL bl;

	public PromotionController() {
		bl = new PromotionBL();
	}

	public MemberPromotionVO getMemberPromotion(long id) throws RemoteException {
		return bl.getMemberPromotion(id);
	}

	public boolean creatMemberPromotion(MemberPromotionVO vo) throws RemoteException {
		return bl.creatMemberPromotion(vo);
	}

	public boolean changeMemberPromotion(MemberPromotionVO vo) throws RemoteException {
		return bl.changeMemberPromotion(vo);
	}

	public HotelPromotionVO getHotelPromotion(long id) throws RemoteException {
		return bl.getHotelPromotion(id);
	}

	public boolean creatHotelPromotion(HotelPromotionVO vo) throws RemoteException {
		return bl.creatHotelPromotion(vo);
	}

	public boolean changeHotelPromotion(HotelPromotionVO vo) throws RemoteException {
		return bl.changeHotelPromotion(vo);
	}

	public WebPromotionVO getWebPromotion(long id) throws RemoteException {
		return bl.getWebPromotion(id);
	}

	public boolean creatWebPromotion(WebPromotionVO vo) throws RemoteException {
		return bl.creatWebPromotion(vo);
	}

	public boolean changeWebPromotion(WebPromotionVO vo) throws RemoteException {
		return bl.changeWebPromotion(vo);
	}
}
