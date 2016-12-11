package businesslogicservice.hotelbusinesslogicservice;

import po.OrderState;
import vo.HotelVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface HotelBusinessLogicService {
    public HotelVO getHotel(long id)throws RemoteException;
    public boolean changeHotel(HotelVO hv)throws RemoteException;
    public boolean changePassWord(long id,String pw)throws RemoteException;
    public boolean addEvaluation(long id,ArrayList evaluation)throws RemoteException;
    public boolean changeOraderState(long id, OrderState os)throws RemoteException;
    public boolean setPromotionOne(double[] numberOfRoom,double[] discount)throws RemoteException;
    public boolean setPromotionTwo(double discount)throws RemoteException;
    public boolean setPromotionThree(String beginTime,String endTime)throws RemoteException;
}
