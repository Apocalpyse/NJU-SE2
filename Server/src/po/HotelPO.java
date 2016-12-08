package po;
import java.util.ArrayList;

public class HotelPO {
	Long id;
	String password;//密码
	String hotelName;//酒店名称
	String tradeArea;//所属商圈
	String hotelLocation;//酒店地址
	String hotelPhone;//酒店联系电话
	String stars;//酒店星级
	String instruction;//酒店简介
	ArrayList<Evaluation> eval;//酒店评价
	String cooperatateCompany;//酒店合作企业
	public HotelPO(Long i,String hn,String ta,String hl,String hp,String st,String in,Evaluation eva,String cc){
		id=i;
		hotelName=hn;
		tradeArea=ta;
		hotelLocation=hl;
		hotelPhone=hp;
		stars=st;
		instruction=in;
		eval.add(eva);
		cooperatateCompany=cc;
	}
	public void setID(Long i){
		id=i;
	}
	public void setPassword(String pw){
		password=pw;
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
	public void setEvaluation(ArrayList arrayList){
	
	}
	public void setCooperatateCompany(String str){
		cooperatateCompany=str;
	}
	
	public Long getID(){
		return id;
	}
	public String getPassword(){
		return password;
	}
	public String getHotelName(){
		return hotelName;
	}
	public String gettradeArea(){
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
	public ArrayList getEvaluation(){
		return eval;
	}
	public String getCooperatateCompany(){
		return cooperatateCompany;
	}
}
