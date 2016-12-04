package businesslogic.hotelbl;

import java.util.ArrayList;

import businesslogicservice.hotelbusinesslogicservice.HotelBusinessLogicService;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.roomdataservice.RoomDataService;
import po.HotelPO;
import po.HotelPromotionPO;
import po.OrderPO;
import po.OrderState;
import po.RoomPO;
import vo.HotelVO;
import vo.RoomVO;

public class HotelBL implements HotelBusinessLogicService{
	public HotelVO getHotel(long id){
		HotelDataService hotelDataService=new HotelDataService();
		HotelVO hv=new HotelVO();
		HotelPO hp;
		hp=hotelDataService.find(id);
		hv.setPassword(hp.getPassword());
		hv.setHotelName(hp.getHotelName());
		hv.settradeArea(hp.gettradeArea());
		hv.setHotelLocation(hp.getHotelName());
		hv.setHotelPhone(hp.getHotelPhone());
		hv.setStars(hp.getStars());
		hv.setInstruction(hp.getInstruction());
		hv.setEvaluation(hp.getEvaluation());
		return hv;
	}
	public boolean changeHotel(HotelVO hv){
		boolean result=false;
		HotelDataService hotelDataService2 = null;
		HotelPO hp2;
		hp2=hotelDataService2.find(hv.getID());
		hp2.setID(hv.getID());
		hp2.setPassword(hv.getPassword());
		hp2.setHotelName(hv.getHotelName());
		hp2.settradeArea(hv.gettradeArea());
		hp2.setHotelLocation(hv.getHotelLocation());
		hp2.setHotelPhone(hv.getHotelPhone());
		hp2.setStars(hv.getStars());
		hp2.setInstruction(hv.getInstruction());
		hp2.setEvaluation(hv.getEvaluation());
		hp2.setCooperatateCompany(hv.getCooperatateCompany());
		result=true;
		return result;
	}
	public boolean changePassWord(long id,String pw){
		HotelDataService hotelDataService = null;
		HotelPO hp;
		hp=hotelDataService.find(id);
		if(pw==hp.getPassword()){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean addEvaluation(long id,ArrayList evaluation){
		boolean result=false;
		HotelDataService hotelDataService = null;
		HotelPO hp;
		hp=hotelDataService.find(id);
		hp.setEvaluation(evaluation);
		result=true;
		return result;
	}
    public boolean changeOraderState(long id,OrderState os){
    	boolean result=false;
		OrderDataService orderDataService = null;
		OrderPO op;
		op=orderDataService.find(id);
		op.setOs(os);
		result=true;
		return result;
    }
    public boolean setPromotionOne(double[] numberOfRoom,double[] discount){
    	boolean result=false;
    	PromotionDataService promotionDataService;
    	HotelPromotionPO hpo = null;
    	hpo.setDiscountforlargeramount(numberOfRoom);
    	hpo.setDiscountformoreroom(discount);
    	result=true;
    	return true;
    }
    public boolean setPromotionTwo(double discount){
    	boolean result=false;
    	PromotionDataService promotionDataService;
    	HotelPromotionPO hpo = null;
    	hpo.setBirthDiscount(discount);
    	result=true;
    	return true;
    }
    public boolean setPromotionThree(String beginTime,String endTime){
    	boolean result=false;
    	PromotionDataService promotionDataService;
    	HotelPromotionPO hpo = null;
    	hpo.setBeginTime(beginTime);
    	hpo.setEndTime(endTime);
    	result=true;
    	return true;
    }
    
}
