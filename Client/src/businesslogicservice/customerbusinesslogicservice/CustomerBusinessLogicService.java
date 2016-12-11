package businesslogicservice.customerbusinesslogicservice;

import vo.CustomerVO;
import vo.HotelVO;
import vo.OrderVO;

import java.rmi.RemoteException;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface CustomerBusinessLogicService {
    public CustomerVO getCustomer (long id) throws RemoteException;
    public boolean changeCustomer(CustomerVO vo) throws RemoteException;
    public boolean registerMember(CustomerVO vo)throws RemoteException;
    public HotelVO[] searchHotel(HotelVO vo)throws RemoteException;
    public OrderVO[] viewOrder(long id) throws RemoteException;
    public CustomerVO viewCredit(long id)throws RemoteException;
    public void recordCredit(long id,double creditChange) throws RemoteException;
}
