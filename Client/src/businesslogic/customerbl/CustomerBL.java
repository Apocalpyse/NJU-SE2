package businesslogic.customerbl;

import businesslogicservice.customerbusinesslogicservice.CustomerBusinessLogicService;
import dataservice.customerdataservice.CustomerDataService;
import dataservice.customerdataservice.CustomerFactory;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.hoteldataservice.HotelFactory;
import dataservice.orderdataservice.OrderDataService;
import dataservice.orderdataservice.OrderFactory;
import po.CustomerPO;
import po.Member;
import po.OrderPO;
import vo.CustomerVO;
import vo.HotelVO;
import vo.OrderVO;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 常德隆 on 2016/11/19.
 */
public class CustomerBL implements CustomerBusinessLogicService {

    private CustomerDataService cds;
    private HotelDataService hds;
    private OrderDataService ods;

    public CustomerBL() throws RemoteException{
        try {
            CustomerFactory customerFactory=(CustomerFactory) Naming.lookup("rmi://127.0.0.1:1234/customerFactory");
            this.cds=customerFactory.createCustomerDataService();
            HotelFactory hotelFactory=(HotelFactory) Naming.lookup("rmi://127.0.0.1:1234/hotelFactory");
            this.hds=hotelFactory.createHotelDataService();
            OrderFactory orderFactory=(OrderFactory) Naming.lookup("rmi://127.0.0.1:1234/orderFactory");
            this.ods=orderFactory.createOrderDataService();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    public CustomerVO getCustomer(long id) throws RemoteException{
        CustomerPO po=this.cds.find(id);
        return new CustomerVO(po.getCustomerName(),po.getCustomerPhone(),po.getBirthday(),po.getCompanyName(),po.getCredit()
        ,po.getMember(),po.getId(),po.getCreditNum(),po.getCreditRecord(),po.getOrderId1(),po.getOrderId2(),po.getOrderId3(),po.getOrderId4());
    }

    public boolean changeCustomer(CustomerVO vo) throws RemoteException{

        return this.cds.update(new CustomerPO(vo.getCustomerName(),vo.getCustomerPhone(),vo.getBirthday(),vo.getCompanyName()
        ,vo.getCredit(),vo.getMember(),vo.getId(),vo.getCreditNum(),vo.getCreditRecord(),vo.getOrderId1(),vo.getOrderId2(),vo.getOrderId3(),vo.getOrderId4()));
    }

    public boolean registerMember(CustomerVO vo) throws RemoteException{
        if(vo.getCompanyName()!=null){
            return this.cds.insert(new CustomerPO(vo.getCustomerName(),vo.getCustomerPhone(),vo.getBirthday(),vo.getCompanyName(),vo.getCredit(),Member.companyMember,vo.getId(),vo.getCreditNum(),vo.getCreditRecord(),vo.getOrderId1(),vo.getOrderId2(),vo.getOrderId3(),vo.getOrderId4()));
        }
        return this.cds.insert(new CustomerPO(vo.getCustomerName(),vo.getCustomerPhone(),vo.getBirthday(),vo.getCompanyName(),vo.getCredit(),Member.normalMember,vo.getId(),vo.getCreditNum(),vo.getCreditRecord(),vo.getOrderId1(),vo.getOrderId2(),vo.getOrderId3(),vo.getOrderId4()));
    }

    public HotelVO searchHotel(HotelVO vo) throws RemoteException{

        return new HotelVO();
    }


    public OrderVO viewNormalOrder(long id,int i)throws RemoteException{
        CustomerPO p=this.cds.find(id);
        OrderPO po=this.ods.find(Long.parseLong(p.getOrderId1()[i]));
        return new OrderVO(po.getId(),po.getCustomerName(),po.getCustomerPhone(),po.getHotelName(),po.getHotelPhone(),po.getHotelLocation(),po.getRoomType(),po.getRoomNumber(),po.getRoomPrice(),po.getDiscount(),po.getStartTime(),po.getEndTime(),po.getExecuteTime(),po.getTotalPrice(),po.getOs(),po.getIsExistChild(),po.getCustomerNumber(),po.getMasterId());
    }


    public boolean recordCredit(long id,double creditChange)throws RemoteException{
        String[][] record=new String[100][3];
        CustomerPO po=this.cds.find(id);
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        record[Integer.parseInt(po.getCreditNum())][0]=sdf.format(date);
        record[Integer.parseInt(po.getCreditNum())][1]=Double.toString(creditChange);
        String[][] temp=po.getCreditRecord();
        temp[Integer.parseInt(po.getCreditNum())][0]=record[Integer.parseInt(po.getCreditNum())][0];
        temp[Integer.parseInt(po.getCreditNum())][1]=record[Integer.parseInt(po.getCreditNum())][1];

        return this.cds.update(new CustomerPO(po.getCustomerName(),po.getCustomerPhone(),po.getBirthday(),po.getCompanyName(),po.getCredit(),po.getMember(),po.getId(),po.getCreditNum()+1,temp,po.getOrderId1(),po.getOrderId2(),po.getOrderId3(),po.getOrderId4()));
    }

    public long findMaxId() throws RemoteException{
        return this.cds.findMaxId();
    }
}
