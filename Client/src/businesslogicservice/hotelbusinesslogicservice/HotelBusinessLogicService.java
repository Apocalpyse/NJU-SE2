package businesslogicservice.hotelbusinesslogicservice;

import po.OrderState;
import vo.HotelVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface HotelBusinessLogicService {
     HotelVO getHotel(long id)throws RemoteException;
     boolean changeHotel(HotelVO hv)throws RemoteException;
     boolean changePassWord(long id,String pw)throws RemoteException;
     boolean addEvaluation(long id,ArrayList evaluation)throws RemoteException;
     boolean changeOrderState(long id, OrderState os)throws RemoteException;
     boolean setPromotionOne(double[] numberOfRoom,double[] discount)throws RemoteException;
     boolean setPromotionTwo(double discount)throws RemoteException;
     boolean setPromotionThree(String beginTime,String endTime)throws RemoteException;
}
