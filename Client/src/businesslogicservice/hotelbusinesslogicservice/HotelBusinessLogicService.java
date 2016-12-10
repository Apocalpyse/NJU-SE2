package businesslogicservice.hotelbusinesslogicservice;

import po.Evaluation;
import po.OrderState;
import vo.HotelVO;

import java.util.ArrayList;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface HotelBusinessLogicService {
    public HotelVO getHotel(long id);
    public boolean changeHotel(HotelVO hv);
    public boolean changeGoal(HotelVO hv,Evaluation eva);
    public boolean changePassWord(String account,String pw);
    public boolean addEvaluation(long id,ArrayList evaluation);
    public boolean changeOraderState(long id, OrderState os);
    public boolean setPromotionOne(double[] numberOfRoom,double[] discount);
    public boolean setPromotionTwo(double discount);
    public boolean setPromotionThree(String beginTime,String endTime);
}
