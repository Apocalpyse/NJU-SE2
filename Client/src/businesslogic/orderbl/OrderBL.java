package businesslogic.orderbl;

/**
 * Created by 常德隆 on 2016/11/19.
 */
import businesslogic.customerbl.CustomerController;
import businesslogic.promotionbl.PromotionController;
import businesslogicservice.orderbusnesslogicservice.OrderBusinessLogicService;
import dataservice.customerdataservice.CustomerDataService;
import dataservice.customerdataservice.CustomerFactory;
import dataservice.orderdataservice.OrderDataService;
import dataservice.orderdataservice.OrderFactory;
import po.*;
import vo.OrderVO;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderBL implements OrderBusinessLogicService{

    private OrderDataService ods;
    private CustomerDataService cds;

    public OrderBL() throws RemoteException{
        try {
            OrderFactory orderFactory =(OrderFactory) Naming.lookup("rmi://127.0.0.1:1234/orderFactory");
            this.ods = orderFactory.createOrderDataService();
            CustomerFactory customerFactory=(CustomerFactory) Naming.lookup("rmi://127.0.0.1:1234/customerFactory");
            this.cds=customerFactory.createCustomerDataService();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    public boolean createOrder(OrderVO vo,long hotelId)throws RemoteException{

        PromotionController pc=new PromotionController();
        String date;
        Date now =new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date=dateFormat.format(now);//获得当前时间，作为订单的下单时间；

        return this.ods.insert(new OrderPO(vo.getId(),vo.getCustomerName(),vo.getCustomerPhone(),vo.getHotelName(),vo.getHotelPhone(),vo.getHotelLocation()
        ,vo.getRoomType(),vo.getRoomNumber(),vo.getRoomPrice(),pc.getDiscount(vo.getMasterId(),hotelId,vo.getExecuteTime(),vo.getRoomNumber(),vo.getRoomPrice()),vo.getStartTime(),vo.getEndTime(),date,vo.getRoomPrice()*vo.getDiscount()*vo.getRoomNumber(),vo.getOs()
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

    public long findMaxId() throws RemoteException{
        return this.ods.findMaxId();
    }
}
