package businesslogic.hotelbl;

import java.util.ArrayList;

import po.OrderState;
import vo.HotelVO;

public class HotelController {
	HotelBL hbl;
	public HotelController(){
		hbl=new HotelBL();
	}
	public HotelVO getHotel(long id){
		return hbl.getHotel(id);
	}
	public boolean changeHotel(HotelVO hv){
		return hbl.changeHotel(hv);
	}
	public boolean changePassWord(long id,String pw){
		return hbl.changePassWord(id, pw);
	}
	public boolean addEvaluation(long id,ArrayList evaluation){
		return hbl.addEvaluation(id, evaluation);
	}
    public boolean changeOraderState(long id,OrderState os){
    	return hbl.changeOraderState(id, os);
    }
    public boolean setPromotionOne(double[] numberOfRoom,double[] discount){
    	return hbl.setPromotionOne(numberOfRoom, discount);
    }
    public boolean setPromotionTwo(double discount){
    	return hbl.setPromotionTwo(discount);
    }
    public boolean setPromotionThree(String beginTime,String endTime){
    	return hbl.setPromotionThree(beginTime, endTime);
    }
}
