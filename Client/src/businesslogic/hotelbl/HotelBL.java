package businesslogic.hotelbl;

import vo.HotelVO;

/**
 * Created by 常德隆 on 2016/11/19.
 */
public class HotelBL {
    public HotelVO getHotel(long id){
       return null;
    }
    public boolean changeHotel(HotelVO hv){
        return false;
    }
    public boolean changePassWord(){
       return false;
    }
    public boolean addEvaluation(long id,int score,String evaluation){
      return false;
    }
    public boolean changeOraderState(long id){
      return false;
    }
    public boolean setPromotionOne(int[] numberOfRoom,int[] discount){
       return false;
    }
    public boolean setPromotionTwo(int discount){
       return false;
    }
    public boolean setPromotionThree(String startTime,String endTime){
       return false;
    }
}
