package businesslogic.orderbl;

/**
 * Created by 常德隆 on 2016/11/19.
 */
import po.*;
import vo.OrderVO;

public class OrderBL {

    public boolean createOrder(OrderVO vo){

        OrderPO o=new OrderPO();
        CustomerPO c = new CustomerPO();
        HotelPO h=new HotelPO();
        RoomPO r=new RoomPO();
        HotelPromotionPO p1=new HotelPromotionPO();
        WebPromotionPO p2=new WebPromotionPO();
        o.setCustomerName(c.getCustomerName());
        o.setCustomerPhone(c.getCustomerPhone());
        o.setHotelName(h.getHotelName());
        o.setHotelPhone(h.getHotelPhone());
        o.setHotelLocation(h.getHotelLocation());
        o.setRoomType(r.getRoomType());

        if(p1.getDiscount()>p2.getDiscount()){
            o.setDiscount(p2.getDiscount());
        }
        else{
            o.setDiscount(p1.getDiscount());
        }

        return true;
    }

    public OrderVO getOrder(long id){
       OrderVO v=new OrderVO();
       return v;
    }

    public boolean cancelOrder(long id){
        return false;
    }

    public boolean completeOrder(long id){
        return false;
    }

    public boolean recoverOrder(long id){
       return false;
    }
}
