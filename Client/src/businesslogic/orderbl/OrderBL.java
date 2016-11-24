package businesslogic.orderbl;

/**
 * Created by 常德隆 on 2016/11/19.
 */
import dataservice.orderdataservice.OrderDataService;
import po.*;
import vo.OrderVO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderBL {

    public boolean createOrder(OrderVO vo){

        OrderPO o=new OrderPO();
        HotelPromotionPO P1=new HotelPromotionPO();
        WebPromotionPO P2=new WebPromotionPO();
        double p1;
        double p2;
        double[] roomPrice;
        double totalPrice=0;
        String date;
        Date now =new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean result=false;

        o.setCustomerName(vo.getCustomerName());
        o.setCustomerPhone(vo.getCustomerPhone());
        o.setHotelName(vo.getHotelName());
        o.setHotelPhone(vo.getHotelPhone());
        o.setHotelLocation(vo.getHotelLocation());
        o.setRoomType(vo.getRoomType());
        o.setRoomNumber(vo.getRoomNumber());
        o.setRoomPrice(vo.getRoomPrice());
        o.setMasterId(vo.getMasterId());

        p1=P1.getDiscount();
        p2=P2.getDiscount();
        if(p1>p2){
            o.setDiscount(p2);
        }
        else{
            o.setDiscount(p1);
        }//获得最优优惠；

        roomPrice=vo.getRoomPrice();
        for(int i=0;i<vo.getRoomPrice().length;i++){
            totalPrice=totalPrice+roomPrice[i];
        }
        totalPrice=totalPrice*o.getDiscount();//根据折扣计算出订单总价值；

        date=dateFormat.format(now);//获得当前时间，作为订单的下单时间；

        o.setTotalPrice(totalPrice);
        o.setStartTime(vo.getStartTime());
        o.setEndTime(vo.getEndTime());
        o.setExecuteTime(date);
        o.setOs(OrderState.unexecute);//将生成的订单的状态设为未执行；
        o.setIsExistChild(vo.getIsExistChild());
        o.setCustomerNumber(vo.getCustomerNumber());
        result=true;

        return result;
    }

    public OrderVO getOrder(long id){
        OrderVO v=new OrderVO();
        OrderPO p;
        OrderDataService ods=new OrderDataService();
        p=ods.find(id);

        v.setCustomerName(p.getCustomerName());
        v.setCustomerPhone(p.getCustomerPhone());
        v.setCustomerNumber(p.getCustomerNumber());
        v.setHotelName(p.getHotelName());
        v.setHotelPhone(p.getHotelPhone());
        v.setHotelLocation(p.getHotelLocation());
        v.setRoomType(p.getRoomType());
        v.setRoomNumber(p.getRoomNumber());
        v.setRoomPrice(p.getRoomPrice());
        v.setDiscount(p.getDiscount());
        v.setTotalPrice(p.getTotalPrice());
        v.setStartTime(p.getStartTime());
        v.setExecuteTime(p.getExecuteTime());
        v.setEndTime(p.getEndTime());
        v.setOs(p.getOs());
        v.setIsExistChild(p.getIsExistChild());//根据id获得订单信息；

        return v;
    }

    public double cancelOrder(long id) {
        double result=0;
        OrderDataService ods=new OrderDataService();
        OrderPO po;
        String now;
        String startTime;
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        now=sdf.format(date);
        po=ods.find(id);
        po.setOs(OrderState.canceled);//根据id获得订单，并将此订单的状态设为已撤销；
        startTime=po.getStartTime();
        long diff=0;
        try
        {
            Date d1 = sdf.parse(now);
            Date d2 = sdf.parse(startTime);
            diff = d1.getTime() - d2.getTime();
        }
        catch (Exception e)
        {
        }
        if(diff / (1000 * 60 * 60 )>=6){
            result=0;
        }
        else{
            result=po.getTotalPrice();
        }//根据订单上的预计入住时间和撤销时的时间差，来判断是否要扣除信用值；

        return result;
    }

    public double completeOrder(long id){
        double result=0;
        OrderDataService ods=new OrderDataService();
        OrderPO po;
        po=ods.find(id);
        po.setOs(OrderState.normal);
        result=po.getTotalPrice();//根据id获得订单，并将此订单的状态设为正常状态,加上对应的信用值；

        return result;
    }

    public double recoverOrder(long id){
        double result=0;
        OrderDataService ods=new OrderDataService();
        OrderPO po;
        po=ods.find(id);
        po.setOs(OrderState.normal);
        result=po.getTotalPrice();//根据id获得订单，并将此订单的状态设为正常状态；

        return result;
    }
}
