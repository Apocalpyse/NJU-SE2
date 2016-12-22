package businesslogicservice.hotelbusinesslogicservice;

import po.Evaluation;
import po.HotelPO;
import po.OrderState;
import vo.HotelVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface HotelBusinessLogicService {
	 boolean createHotel(HotelPO po) throws RemoteException;
     HotelVO getHotel(long id)throws RemoteException;
     boolean changeHotel(HotelVO hv)throws RemoteException;
     boolean changeGoal(HotelVO hv,Evaluation eva)throws RemoteException;
     boolean changePassWord(String account,String pw)throws RemoteException;
     boolean addEvaluation(long id,ArrayList evaluation)throws RemoteException;
     boolean changeOraderState(long id,OrderState os)throws RemoteException;
     boolean setPromotionOne(long id,int numberOfRoom,double discount)throws RemoteException;
     boolean setPromotionTwo(long id,double discount)throws RemoteException;
     boolean setPromotionThree(long id,String beginTime,String endTime)throws RemoteException;
     boolean setPromotionFour(long id,double discount)throws RemoteException;
}
