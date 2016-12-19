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

    public boolean createOrder(OrderVO vo,long hotelId)throws RemoteException{
        return obl.createOrder(vo,hotelId);
    }

    public OrderVO getOrder(long id)throws RemoteException{
        return obl.getOrder(id);
    }

    public boolean cancelOrder(long id)throws RemoteException{
        return obl.cancelOrder(id);
    }

    public boolean completeOrder(long id)throws RemoteException{
        return obl.completeOrder(id);
    }

    public boolean recoverOrder(long id)throws RemoteException {
        return obl.recoverOrder(id);
    }
}
