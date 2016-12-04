package businesslogicservice.hotelbusinesslogicservice;

import po.OrderState;
import vo.HotelVO;

import java.util.ArrayList;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface HotelBusinessLogicService {
    public HotelVO getHotel(long id);
    public boolean changeHotel(HotelVO hv);
    public boolean changePassWord(long id,String pw);
    public boolean addEvaluation(long id,ArrayList evaluation);
    public boolean changeOraderState(long id, OrderState os);
    public boolean setPromotionOne(double[] numberOfRoom,double[] discount);
    public boolean setPromotionTwo(double discount);
    public boolean setPromotionThree(String beginTime,String endTime);
}
