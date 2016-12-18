package vo;

/**
 * Created by 常德隆 on 2016/11/19.
 */
import java.util.ArrayList;

import po.Evaluation;

public class HotelVO {
	Long id;
	String hotelManager;//酒店工作人员
	String hotelManPhone;//酒店工作人员电话
	double goal;//酒店得分
	double[]  price={0,0,0,0,0,0};//酒店价格
	String hotelName;//酒店名称
	String tradeArea;//所属商圈
	String hotelLocation;//酒店地址
	String hotelPhone;//酒店联系电话
	String stars;//酒店星级
	String instruction;//酒店简介
	ArrayList<Evaluation> evaluation;//酒店评价
	String cooperatateCompany;//酒店合作企业
	
	public HotelVO(Long i,String hm,String hmp,double go,double[] pr,String hn,String ta,String hl,String hp,String st,String in,ArrayList<Evaluation> eva,String cc){
		id=i;
		hotelManager=hm;
		hotelManPhone=hmp;
		goal=go;
		price=pr;
		hotelName=hn;
		tradeArea=ta;
		hotelLocation=hl;
		hotelPhone=hp;
		stars=st;
		instruction=in;
		evaluation=eva;
		cooperatateCompany=cc;
	}
	
	public void setID(Long i){
		id=i;
	}
	public void setHotelManager(String hm){
		hotelManager=hm;
	}
	public void setHotelManPhone(String hmp){
		hotelManPhone=hmp;
	}
	public void setGoal(double go){
		goal=go;
	}
	
	public void setPrice(double[] pr){
		price=pr;
	}
	public void setHotelName(String hn){
		hotelName=hn;
	}
	public void settradeArea(String ta){
		tradeArea=ta;
	}
	public void setHotelLocation(String hl){
		hotelLocation=hl;
	}
	public void setHotelPhone(String hp){
		hotelPhone=hp;
	}
	public void setStars(String st){
		stars=st;
	}
	public void setInstruction(String in){
		instruction=in;
	}
	public void setEvaluation(ArrayList<Evaluation> eva){
		evaluation=eva;
	}
	public void setCooperatateCompany(String str){
		cooperatateCompany=str;
	}
	
	public Long getID(){
		return id;
	}
	public String getHotelManager(){
		return hotelManager;
	}
	public String getHotelManPhone(){
		return hotelManPhone;
	}
	public Double getGoal(){
		return goal;
	}
	
	public double[] getPrice(){
		return price;
	}
	public String getHotelName(){
		return hotelName;
	}
	public String getTradeArea(){
		return tradeArea;
	}
	public String getHotelLocation(){
		return hotelLocation;
	}
	public String getHotelPhone(){
		return hotelPhone;
	}
	public String getStars(){
		return stars;
	}
	public String getInstruction(){
		return instruction;
	}
	public ArrayList<Evaluation> getEvaluation(){
		return evaluation;
	}
	public String getCooperatateCompany(){
		return cooperatateCompany;
	}
}
