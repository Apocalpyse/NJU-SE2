package businesslogicservice.orderbusnesslogicservice;

import vo.OrderVO;

import java.rmi.RemoteException;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface OrderBusinessLogicService {
    public boolean createOrder(OrderVO vo)throws RemoteException;
    public OrderVO getOrder(long id) throws RemoteException;
    public double cancelOrder(long id) throws RemoteException;
    public double completeOrder(long id) throws RemoteException;
    public double recoverOrder(long id)throws RemoteException;
}
