package businesslogic.customerbl;

import vo.CustomerVO;
import vo.OrderVO;

/**
 * Created by 常德隆 on 2016/11/19.
 */
public class CustomerController {
    CustomerBL cbl;
    public CustomerController(){
        cbl=new CustomerBL();
    }

    public CustomerVO getCustomer(long id){
        return cbl.getCustomer(id);
    }

    public boolean changeCustomer(CustomerVO vo){
        return cbl.changeCustomer(vo);
    }

    public boolean registerMember(CustomerVO vo){
        return cbl.registerMember(vo);
    }

    public OrderVO[] viewOrder(long id){
        return cbl.viewOrder(id);
    }

    public CustomerVO viewCredit(long id){
        return cbl.viewCredit(id);
    }

    public void recordCredit(long id,double creditChange){
        cbl.recordCredit(id,creditChange);
    }
}
