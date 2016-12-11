package businesslogic.orderbl;

import vo.OrderVO;

import java.rmi.RemoteException;

/**
 * Created by 常德隆 on 2016/11/19.
 */
public class OrderController {
    OrderBL obl;

    public OrderController(){
        obl=new OrderBL();
    }

    public boolean createOrder(OrderVO vo)throws RemoteException{
        return obl.createOrder(vo);
    }

    public OrderVO getOrder(long id)throws RemoteException{
        return obl.getOrder(id);
    }

    public double cancelOrder(long id)throws RemoteException{
        return obl.cancelOrder(id);
    }

    public double completeOrder(long id)throws RemoteException{
        return obl.completeOrder(id);
    }

    public double recoverOrder(long id)throws RemoteException {
        return obl.recoverOrder(id);
    }
}
