package businesslogicservice.customerbusinesslogicservice;

import vo.CustomerVO;
import vo.HotelVO;
import vo.OrderVO;

import java.rmi.RemoteException;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface CustomerBusinessLogicService {
     CustomerVO getCustomer (long id) throws RemoteException;
     boolean changeCustomer(CustomerVO vo) throws RemoteException;
     boolean registerMember(CustomerVO vo)throws RemoteException;
     HotelVO searchHotel(HotelVO vo)throws RemoteException;
     OrderVO viewNormalOrder(long id,int i) throws RemoteException;
     boolean recordCredit(long id,double creditChange) throws RemoteException;
}
