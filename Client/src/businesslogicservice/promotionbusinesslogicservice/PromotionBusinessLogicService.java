package businesslogicservice.promotionbusinesslogicservice;

import java.rmi.RemoteException;

import vo.HotelPromotionVO;
import vo.MemberPromotionVO;
import vo.WebPromotionVO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface PromotionBusinessLogicService {
     double getDiscount(long id, int room, double price)throws RemoteException ;
     MemberPromotionVO getMemberPromotion(long id)throws RemoteException ;
     boolean creatMemberPromotion(MemberPromotionVO vo)throws RemoteException ;
     boolean changeMemberPromotion(MemberPromotionVO vo)throws RemoteException ;
     HotelPromotionVO getHotelPromotion(long id)throws RemoteException ;
     boolean creatHotelPromotion(HotelPromotionVO vo)throws RemoteException ;
     boolean changeHotelPromotion(HotelPromotionVO vo)throws RemoteException ;
     WebPromotionVO getWebPromotion(long id)throws RemoteException ;
     boolean creatWebPromotion(WebPromotionVO vo)throws RemoteException ;
     boolean changeWebPromotion(WebPromotionVO vo)throws RemoteException ;

}
