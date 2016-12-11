package businesslogic.customerbl;

import vo.CustomerVO;
import vo.HotelVO;
import vo.OrderVO;

import java.rmi.RemoteException;

/**
 * Created by 常德隆 on 2016/11/19.
 */
public class CustomerController {
    CustomerBL cbl;
    public CustomerController(){
        cbl=new CustomerBL();
    }

    public CustomerVO getCustomer(long id)throws RemoteException{
        return cbl.getCustomer(id);
    }

    public HotelVO[] searchHotel(HotelVO vo)throws RemoteException{
        return cbl.searchHotel(vo);
    }

    public boolean changeCustomer(CustomerVO vo)throws RemoteException{
        return cbl.changeCustomer(vo);
    }

    public boolean registerMember(CustomerVO vo)throws RemoteException{
        return cbl.registerMember(vo);
    }

    public OrderVO[] viewOrder(long id) throws RemoteException{
        return cbl.viewOrder(id);
    }

    public CustomerVO viewCredit(long id)throws RemoteException {
        return cbl.viewCredit(id);
    }

    public boolean addEvaluation(String score,String evaluation)throws RemoteException{return cbl.addEvaluation(score,evaluation);}

    public void recordCredit(long id,double creditChange)throws RemoteException{
        cbl.recordCredit(id,creditChange);
    }
}
