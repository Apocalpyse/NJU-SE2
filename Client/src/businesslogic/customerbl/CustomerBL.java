package businesslogic.customerbl;

import po.CustomerPO;
import po.HotelPO;

/**
 * Created by 常德隆 on 2016/11/19.
 */
public class CustomerBL {

    public CustomerVO getCustomer(long id){
        CustomerVO p=new CustomerVO();
        return p;
    }

    public boolean changeCustomer(CustomerVO vo){
       return false;
    }

    public boolean registerMember(CustomerVO vo){
       return false;
    }

    public HotelVO[] searchHotel(){

    }

    public OrderVO[] viewOrder(long id){

    }

    public CustomerVO viewCredit(long id){

    }
}
