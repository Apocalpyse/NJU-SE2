package po;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * Created by 常德隆 on 2016/11/19.
 */
public class HotelPO implements Serializable{
    private String password;//密码
    private String hotelName;//酒店名称
    private String tradeArea;//所属商圈
    private String hotelLocation;//酒店地址
    private int[] hotelPhone;//酒店联系电话
    private int stars;//酒店星级
    private String instruction;//酒店简介
    private ArrayList<Evaluation> eval;//酒店评价
    private String cooperatateCompany;//酒店合作企业

    public HotelPO(){}

    public HotelPO(String hn,String ta,String hl,int[] hp,int st,String in,Evaluation eva){
        hotelName=hn;
        tradeArea=ta;
        hotelLocation=hl;
        hotelPhone=hp;
        stars=st;
        instruction=in;
        eval.add(eva);
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
    public void setHotelPhone(int[] hp){
        hotelPhone=hp;
    }
    public void setStars(int st){
        stars=st;
    }
    public void setInstruction(String in){
        instruction=in;
    }
    public void setEvaluation(Evaluation eva){
        eval.add(eva);
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
    public int[] getHotelPhone(){
        return hotelPhone;
    }
    public int getStars(){
        return stars;
    }
    public String getInstruction(){
        return instruction;
    }
    public ArrayList getEvaluation(){
        return eval;
    }
}
