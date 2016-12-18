package businesslogic.orderbl;

/**
 * Created by 常德隆 on 2016/11/19.
 */
import businesslogic.customerbl.CustomerController;
import businesslogic.promotionbl.PromotionBL;
import businesslogicservice.orderbusnesslogicservice.OrderBusinessLogicService;
import dataservice.customerdataservice.CustomerDataService;
import dataservice.orderdataservice.OrderDataService;
import po.*;
import vo.OrderVO;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderBL implements OrderBusinessLogicService{

    OrderDataService ods=new OrderDataService() {
        @Override
        public OrderPO find(long id) {
            return null;
        }

        @Override
        public boolean insert(OrderPO po) {
            return false;
        }

        @Override
        public boolean delete(long id) {
            return false;
        }

        @Override
        public boolean update(OrderPO po) {
            return false;
        }
    };

    CustomerDataService cds=new CustomerDataService() {
        @Override
        public CustomerPO find(long id) {
            return null;
        }

        @Override
        public boolean insert(CustomerPO po) {
            return false;
        }

        @Override
        public boolean delete(long id) {
            return false;
        }

        @Override
        public boolean update(CustomerPO po) {
            return false;
        }
    };
    private long OrderId=40000;

    public boolean createOrder(OrderVO vo)throws RemoteException{

        PromotionBL pbl=new PromotionBL();
        String date;
        Date now =new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date=dateFormat.format(now);//获得当前时间，作为订单的下单时间；

        return this.ods.insert(new OrderPO(vo.getId(),vo.getCustomerName(),vo.getCustomerPhone(),vo.getHotelName(),vo.getHotelPhone(),vo.getHotelLocation()
        ,vo.getRoomType(),vo.getRoomNumber(),vo.getRoomPrice(),pbl.getDiscount(vo.getMasterId(),vo.getRoomNumber(),vo.getRoomPrice()),vo.getStartTime(),vo.getEndTime(),date,vo.getRoomPrice()*vo.getDiscount()*vo.getRoomNumber(),vo.getOs()
        ,vo.getIsExistChild(),vo.getCustomerNumber(),vo.getMasterId()));
    }

    public OrderVO getOrder(long id) throws RemoteException{
        OrderPO p=this.ods.find(id);

        return new OrderVO(p.getId(),p.getCustomerName(),p.getCustomerPhone(),p.getHotelName(),p.getHotelPhone(),p.getHotelLocation(),
                  p.getRoomType(),p.getRoomNumber(),p.getRoomPrice(),p.getDiscount(),p.getStartTime(),p.getEndTime(),p.getExecuteTime(),p.getTotalPrice(),
                  p.getOs(),p.getIsExistChild(),p.getCustomerNumber(),p.getMasterId());
    }

    public boolean cancelOrder(long id) throws RemoteException {
        OrderPO po=this.ods.find(id);
        String now;
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        now=sdf.format(date);
        long diff=0;
        try
        {
            Date d1 = sdf.parse(now);
            Date d2 = sdf.parse(po.getStartTime());
            diff = d1.getTime() - d2.getTime();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        if(diff / (1000 * 60 * 60 )>=6){
           return this.ods.update(new OrderPO(po.getId(),po.getCustomerName(),po.getCustomerPhone(),po.getHotelName(),po.getHotelPhone(),po.getHotelLocation(),po.getRoomType(),po.getRoomNumber(),po.getRoomPrice(),po.getDiscount(),po.getStartTime(),po.getEndTime(),po.getExecuteTime(),po.getTotalPrice(),OrderState.canceled,po.getIsExistChild(),po.getCustomerNumber(),po.getMasterId()));
        }
        else{
            this.ods.update(new OrderPO(po.getId(),po.getCustomerName(),po.getCustomerPhone(),po.getHotelName(),po.getHotelPhone(),po.getHotelLocation(),po.getRoomType(),po.getRoomNumber(),po.getRoomPrice(),po.getDiscount(),po.getStartTime(),po.getEndTime(),po.getExecuteTime(),po.getTotalPrice(),OrderState.canceled,po.getIsExistChild(),po.getCustomerNumber(),po.getMasterId()));
            CustomerPO cpo=this.cds.find(po.getMasterId());
            this.cds.update(new CustomerPO(cpo.getCustomerName(),cpo.getCustomerPhone(),cpo.getBirthday(),cpo.getCompanyName(),Double.toString(Double.parseDouble(cpo.getCredit())-po.getTotalPrice()/2),cpo.getMember(),cpo.getId(),cpo.getCreditNum(),cpo.getCreditRecord(),cpo.getOrderId1(),cpo.getOrderId2(),cpo.getOrderId3(),cpo.getOrderId4()));
           return false;
        }//根据订单上的预计入住时间和撤销时的时间差，来判断是否要扣除信用值；

    }

    public boolean completeOrder(long id) throws RemoteException{
        OrderPO po=this.ods.find(id);
        CustomerPO cpo=this.cds.find(po.getMasterId());
        this.cds.update(new CustomerPO(cpo.getCustomerName(),cpo.getCustomerPhone(),cpo.getBirthday(),cpo.getCompanyName(),cpo.getCredit()+po.getTotalPrice(),cpo.getMember(),cpo.getId(),cpo.getCreditNum(),cpo.getCreditRecord(),cpo.getOrderId1(),cpo.getOrderId2(),cpo.getOrderId3(),cpo.getOrderId4()));
        CustomerController cc=new CustomerController();
        cc.recordCredit(cpo.getId(),po.getTotalPrice());
        return this.ods.update(new OrderPO(po.getId(),po.getCustomerName(),po.getCustomerPhone(),po.getHotelName(),po.getHotelPhone(),po.getHotelLocation(),po.getRoomType(),po.getRoomNumber(),po.getRoomPrice(),po.getDiscount(),po.getStartTime(),po.getEndTime(),po.getExecuteTime(),po.getTotalPrice(),OrderState.normal,po.getIsExistChild(),po.getCustomerNumber(),po.getMasterId()));
    }

    public boolean recoverOrder(long id) throws RemoteException{
        OrderPO po=this.ods.find(id);
        CustomerPO cpo=this.cds.find(po.getMasterId());
        this.cds.update(new CustomerPO(cpo.getCustomerName(),cpo.getCustomerPhone(),cpo.getBirthday(),cpo.getCompanyName(),cpo.getCredit()+po.getTotalPrice(),cpo.getMember(),cpo.getId(),cpo.getCreditNum(),cpo.getCreditRecord(),cpo.getOrderId1(),cpo.getOrderId2(),cpo.getOrderId3(),cpo.getOrderId4()));
        CustomerController cc=new CustomerController();
        cc.recordCredit(cpo.getId(),po.getTotalPrice());
        return this.ods.update(new OrderPO(po.getId(),po.getCustomerName(),po.getCustomerPhone(),po.getHotelName(),po.getHotelPhone(),po.getHotelLocation(),po.getRoomType(),po.getRoomNumber(),po.getRoomPrice(),po.getDiscount(),po.getStartTime(),po.getEndTime(),po.getExecuteTime(),po.getTotalPrice(),OrderState.normal,po.getIsExistChild(),po.getCustomerNumber(),po.getMasterId()));
    }
}
