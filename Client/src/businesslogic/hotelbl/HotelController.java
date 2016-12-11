package businesslogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.OrderState;
import vo.HotelVO;

public class HotelController {
	HotelBL hbl;
	public HotelController(){
		hbl=new HotelBL();
	}
	public HotelVO getHotel(long id)throws RemoteException{
		return hbl.getHotel(id);
	}
	public boolean changeHotel(HotelVO hv)throws RemoteException{
		return hbl.changeHotel(hv);
	}
	public boolean changePassWord(long id,String pw)throws RemoteException{
		return hbl.changePassWord(id, pw);
	}
	public boolean addEvaluation(long id,ArrayList evaluation)throws RemoteException{
		return hbl.addEvaluation(id, evaluation);
	}
    public boolean changeOraderState(long id,OrderState os)throws RemoteException{
    	return hbl.changeOraderState(id, os);
    }
    public boolean setPromotionOne(double[] numberOfRoom,double[] discount)throws RemoteException{
    	return hbl.setPromotionOne(numberOfRoom, discount);
    }
    public boolean setPromotionTwo(double discount)throws RemoteException{
    	return hbl.setPromotionTwo(discount);
    }
    public boolean setPromotionThree(String beginTime,String endTime)throws RemoteException{
    	return hbl.setPromotionThree(beginTime, endTime);
    }
}
