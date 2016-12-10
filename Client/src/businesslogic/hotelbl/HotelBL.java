package businesslogic.hotelbl;

import java.util.ArrayList;

import businesslogicservice.hotelbusinesslogicservice.HotelBusinessLogicService;
import dataservice.hoteldataservice.HotelDataServiceSqlImpl;
import dataservice.orderdataservice.OrderDataServiceSqlImpl;
import dataservice.userdataservice.UserDataServiceSqlImpl;
import dataservice.promotiondataservice.PromotionDataServiceSqlImpl;
import po.HotelPO;
import po.HotelPromotionPO;
import po.OrderPO;
import po.UserPO;
import po.OrderState;
import vo.HotelVO;

public class HotelBL implements HotelBusinessLogicService{

	HotelDataServiceSqlImpl hotelDataService;
	OrderDataServiceSqlImpl orderDataService ;
	PromotionDataServiceSqlImpl promotionDataService;
	UserDataServiceSqlImpl userDataService;

	public HotelVO getHotel(long id){
		HotelVO hv=new HotelVO();
		HotelPO hp;
		hp=this.hotelDataService.find(id);
		hv.setHotelName(hp.getHotelName());
		hv.settradeArea(hp.getTradeArea());
		hv.setHotelLocation(hp.getHotelName());
		hv.setHotelPhone(hp.getHotelPhone());
		hv.setStars(hp.getStars());
		hv.setInstruction(hp.getInstruction());
		hv.setEvaluation(hp.getEvaluation());
		return hv;
	}

	public boolean changeHotel(HotelVO hv){
		boolean result=false;
		HotelPO hp2;
		hp2=this.hotelDataService.find(hv.getID());
		hp2.setID(hv.getID());
		hp2.setHotelName(hv.getHotelName());
		hp2.setTradeArea(hv.getTradeArea());
		hp2.setHotelLocation(hv.getHotelLocation());
		hp2.setHotelPhone(hv.getHotelPhone());
		hp2.setStars(hv.getStars());
		hp2.setInstruction(hv.getInstruction());
		hp2.setEvaluation(hv.getEvaluation());
		hp2.setCooperatateCompany(hv.getCooperatateCompany());
		result=true;
		return result;
	}

	public boolean changePassWord(String account,String pw){
		UserPO up;
		up=this.userDataService.find(account);
		if(pw==up.getPassword()){
			return true;
		}
		else{
			return false;
		}
		
	}
	

	public boolean addEvaluation(long id,ArrayList evaluation){
		boolean result=false;
		HotelPO hp;
		hp=this.hotelDataService.find(id);
		hp.setEvaluation(evaluation);
		result=true;
		return result;
	}
    public boolean changeOraderState(long id,OrderState os){
    	boolean result=false;
		OrderPO op;
		op=this.orderDataService.find(id);
		op.setOs(os);
		result=true;
		return result;
    }
    public boolean setPromotionOne(double numberOfRoom,double discount){
    	boolean result=false;
    	HotelPromotionPO hpo = null;
    	hpo.setDiscountforlargeramount(numberOfRoom);
    	hpo.setDiscountformoreroom(discount);
    	result=true;
    	return true;
    }
    public boolean setPromotionTwo(double discount){
    	boolean result=false;
    	HotelPromotionPO hpo = null;
    	hpo.setBirthDiscount(discount);
    	result=true;
    	return true;
    }
    public boolean setPromotionThree(String beginTime,String endTime){
    	boolean result=false;
    	HotelPromotionPO hpo = null;
    	hpo.setBeginTime(beginTime);
    	hpo.setEndTime(endTime);
    	result=true;
    	return true;
    }

	@Override
	public boolean setPromotionOne(double[] numberOfRoom, double[] discount) {
		// TODO Auto-generated method stub
		return false;
	}
    
}
