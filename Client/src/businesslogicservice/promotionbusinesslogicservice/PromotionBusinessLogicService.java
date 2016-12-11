package businesslogicservice.promotionbusinesslogicservice;

import java.rmi.RemoteException;

import vo.HotelPromotionVO;
import vo.MemberPromotionVO;
import vo.WebPromotionVO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface PromotionBusinessLogicService {
    public double getDiscount(long id, int room, double price)throws RemoteException ;
    public MemberPromotionVO getMemberPromotion(long id)throws RemoteException ;
    public boolean creatMemberPromotion(MemberPromotionVO vo)throws RemoteException ;
    public boolean changeMemberPromotion(MemberPromotionVO vo)throws RemoteException ;
    public HotelPromotionVO getHotelPromotion(long id)throws RemoteException ;
    public boolean creatHotelPromotion(HotelPromotionVO vo)throws RemoteException ;
    public boolean changeHotelPromotion(HotelPromotionVO vo)throws RemoteException ;
    public WebPromotionVO getWebPromotion(long id)throws RemoteException ;
    public boolean creatWebPromotion(WebPromotionVO vo)throws RemoteException ;
    public boolean changeWebPromotion(WebPromotionVO vo)throws RemoteException ;

}
