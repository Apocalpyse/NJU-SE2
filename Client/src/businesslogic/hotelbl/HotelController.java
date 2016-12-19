package businesslogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.Evaluation;
import po.OrderState;
import vo.HotelVO;

public class HotelController {
	HotelBL hbl;
	public HotelController()throws RemoteException{
		hbl=new HotelBL();
	}
	public HotelVO getHotel(long id)throws RemoteException{
		return hbl.getHotel(id);
	}
	public boolean changeHotel(HotelVO hv)throws RemoteException{
		return hbl.changeHotel(hv);
	}
	public boolean changeGoal(HotelVO hv,Evaluation eva)throws RemoteException{
		return hbl.changeGoal(hv, eva);
	}
	public boolean changePassWord(String account,String pw)throws RemoteException{
		return hbl.changePassWord(account, pw);
	}
	public boolean addEvaluation(long id,ArrayList evaluation)throws RemoteException{
		return hbl.addEvaluation(id, evaluation);
	}
    public boolean changeOraderState(long id,OrderState os)throws RemoteException{
    	return hbl.changeOraderState(id, os);
    }
    public boolean setPromotionOne(long id,int numberOfRoom,double discount)throws RemoteException{
    	return hbl.setPromotionOne(id,numberOfRoom, discount);
    }
    public boolean setPromotionTwo(long id,double discount)throws RemoteException{
    	return hbl.setPromotionTwo(id,discount);
    }
    public boolean setPromotionThree(long id,String beginTime,String endTime)throws RemoteException{
    	return hbl.setPromotionThree(id,beginTime, endTime);
    }
    public boolean setPromotionFour(long id,double discount)throws RemoteException{
    	return hbl.setPromotionFour(id,discount);
    }
}
