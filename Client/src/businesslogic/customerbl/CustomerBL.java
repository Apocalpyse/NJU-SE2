package businesslogic.customerbl;

import dataservice.customerdataservice.CustomerDataService;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.orderdataservice.OrderDataService;
import po.CustomerPO;
import po.HotelPO;
import po.OrderPO;
import vo.CustomerVO;
import vo.HotelVO;
import vo.OrderVO;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 常德隆 on 2016/11/19.
 */
public class CustomerBL {

    public CustomerVO getCustomer(long id){
        CustomerVO vo=new CustomerVO();
        CustomerDataService cds=new CustomerDataService();
        CustomerPO po;

        po=cds.find(id);
        vo.setCustomerName(po.getCustomerName());
        vo.setCustomerPhone(po.getCustomerPhone());
        vo.setCredit(po.getCredit());
        vo.setIsCompanyMember(po.getIsCompanyMember());
        vo.setIsNormalMember(po.getIsNormalMember());
        vo.setBirthday(po.getBirthday());
        vo.setCompanyName(po.getCompanyName());
        vo.setId(po.getId());//根据id获得顾客信息；

        return vo;
    }

    public boolean changeCustomer(CustomerVO vo){
        boolean result=false;
        CustomerPO po;
        CustomerDataService cds=new CustomerDataService();
        po=cds.find(vo.getId());
        po.setCustomerName(vo.getCustomerName());
        po.setCustomerPhone(vo.getCustomerPhone());
        po.setBirthday(vo.getBirthday());
        po.setCompanyName(vo.getCompanyName());
        cds.update(po);
        result=true;
        return result;
    }

    public boolean registerMember(CustomerVO vo){
        CustomerPO po=new CustomerPO();
        CustomerDataService cds=new CustomerDataService();
        po.setCustomerName(vo.getCustomerName());
        po.setCustomerPhone(vo.getCustomerPhone());
        po.setCredit(vo.getCredit());
        po.setIsNormalMember(vo.getIsNormalMember());
        po.setIsCompanyMember(vo.getIsCompanyMember());
        po.setBirthday(vo.getBirthday());
        po.setCompanyName(vo.getCompanyName());
        po.setId(123456);
        cds.insert(po);
        return false;
    }

    public HotelVO[] searchHotel(String province,String city,String businessArea,double price,int star){
        HotelVO[] vo=new HotelVO[100];
        HotelDataService hds=new HotelDataService();
        long id=10000;
        int i=0;
        HotelPO[] po=new HotelPO[100];
        while(hds.find(id)!=null){
            po[i]=hds.find(id);
            i++;
            po[i].getHotelLocation();
        }
        return vo;
    }

    public OrderVO[] viewOrder(long id){
        CustomerDataService cds=new CustomerDataService();
        OrderDataService ods=new OrderDataService();
        CustomerPO p;
        OrderVO[] vo;
        OrderPO[] po;
        p=cds.find(id);
        long[] idTemp=p.getOrderId();
        vo=new OrderVO[idTemp.length];
        po=new OrderPO[idTemp.length];
        for(int i=0;i<idTemp.length;i++){
            po[i]=ods.find(idTemp[i]);
            vo[i].setCustomerName(po[i].getCustomerName());
            vo[i].setCustomerPhone(po[i].getCustomerPhone());
            vo[i].setCustomerNumber(po[i].getCustomerNumber());
            vo[i].setHotelName(po[i].getHotelName());
            vo[i].setHotelPhone(po[i].getHotelPhone());
            vo[i].setHotelLocation(po[i].getHotelLocation());
            vo[i].setRoomType(po[i].getRoomType());
            vo[i].setRoomNumber(po[i].getRoomNumber());
            vo[i].setRoomPrice(po[i].getRoomPrice());
            vo[i].setDiscount(po[i].getDiscount());
            vo[i].setTotalPrice(po[i].getTotalPrice());
            vo[i].setStartTime(po[i].getStartTime());
            vo[i].setExecuteTime(po[i].getExecuteTime());
            vo[i].setEndTime(po[i].getEndTime());
            vo[i].setOs(po[i].getOs());
            vo[i].setIsExistChild(po[i].getIsExistChild());
        }
        return vo;
    }

    public CustomerVO viewCredit(long id){
        CustomerDataService cds=new CustomerDataService();
        CustomerPO po;
        CustomerVO vo=new CustomerVO();
        po=cds.find(id);
        vo.setCreditRecord(po.getCreditRecord());
        return vo;
    }

    public void recordCredit(long id,double creditChange){
        String[] record=null;
        CustomerDataService cds=new CustomerDataService();
        CustomerPO po;
        int num;
        po=cds.find(id);
        num=po.getCreditNum();
        num=num+2;
        po.setCreditNum(num);
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        record[po.getCreditNum()-1]=sdf.format(date);
        record[po.getCreditNum()]=Double.toString(creditChange);
        String[] temp=po.getCreditRecord();
        temp[po.getCreditNum()-1]=record[po.getCreditNum()-1];
        temp[po.getCreditNum()]=record[po.getCreditNum()];
        po.setCreditRecord(temp);
    }
}
