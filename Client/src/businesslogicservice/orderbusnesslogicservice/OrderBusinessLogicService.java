package businesslogicservice.orderbusnesslogicservice;

import vo.OrderVO;

import java.rmi.RemoteException;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface OrderBusinessLogicService {
     boolean createOrder(OrderVO vo,long hotelId)throws RemoteException;
     OrderVO getOrder(long id) throws RemoteException;
     boolean cancelOrder(long id) throws RemoteException;
     boolean completeOrder(long id) throws RemoteException;
     boolean recoverOrder(long id)throws RemoteException;
}
