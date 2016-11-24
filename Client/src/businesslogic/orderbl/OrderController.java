package businesslogic.orderbl;

import vo.OrderVO;

/**
 * Created by 常德隆 on 2016/11/19.
 */
public class OrderController {
    OrderBL obl;

    public OrderController(){
        obl=new OrderBL();
    }

    public boolean createOrder(OrderVO vo){
        return obl.createOrder(vo);
    }

    public OrderVO getOrder(long id){
        return obl.getOrder(id);
    }

    public double cancelOrder(long id){
        return obl.cancelOrder(id);
    }

    public double completeOrder(long id){
        return obl.completeOrder(id);
    }

    public double recoverOrder(long id){
        return obl.recoverOrder(id);
    }
}
