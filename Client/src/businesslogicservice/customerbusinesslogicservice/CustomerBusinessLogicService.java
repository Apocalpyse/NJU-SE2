package businesslogicservice.customerbusinesslogicservice;

import vo.CustomerVO;
import vo.HotelVO;
import vo.OrderVO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface CustomerBusinessLogicService {
    public CustomerVO getCustomer(long id);
    public boolean changeCustomer(CustomerVO vo);
    public boolean registerMember(CustomerVO vo);
    public HotelVO[] searchHotel(String province, String city, String businessArea, String price, String star);
    public OrderVO[] viewOrder(long id);
    public CustomerVO viewCredit(long id);
    public void recordCredit(long id,double creditChange);
}
