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
    public CustomerController()throws RemoteException{
        cbl=new CustomerBL();
    }

    public CustomerVO getCustomer(long id)throws RemoteException{
        return cbl.getCustomer(id);
    }

    public HotelVO searchHotel(HotelVO vo)throws RemoteException{
        return cbl.searchHotel(vo);
    }

    public boolean changeCustomer(CustomerVO vo)throws RemoteException{
        return cbl.changeCustomer(vo);
    }

    public boolean registerMember(CustomerVO vo)throws RemoteException{
        return cbl.registerMember(vo);
    }

    public OrderVO viewNormalOrder(long id,int i) throws RemoteException{
        return cbl.viewNormalOrder(id,i);
    }

    public OrderVO viewAbnormalOrder(long id,int i) throws RemoteException{
        return cbl.viewAbnormalOrder(id,i);
    }

    public OrderVO viewUnexecuteOrder(long id,int i) throws RemoteException{
        return cbl.viewUnexecuteOrder(id,i);
    }

    public OrderVO viewCanceledOrder(long id,int i) throws RemoteException{
        return cbl.viewCanceledOrder(id,i);
    }

    public void recordCredit(long id,double creditChange)throws RemoteException{
        cbl.recordCredit(id,creditChange);
    }

    public long findMaxId() throws RemoteException{
        return cbl.findMaxId();
    }

    public boolean createCustomer(CustomerVO vo) throws RemoteException{
        return cbl.createCustomer(vo);
    }
}
