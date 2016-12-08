package businesslogic.customerbl;

import businesslogicservice.customerbusinesslogicservice.CustomerBusinessLogicService;
import dataservice.customerdataservice.CustomerDataServiceSqlImpl;
import dataservice.hoteldataservice.HotelDataServiceSqlImpl;
import dataservice.orderdataservice.OrderDataServiceSqlImpl;
import po.CustomerPO;
import po.HotelPO;
import po.Member;
import po.OrderPO;
import vo.CustomerVO;
import vo.HotelVO;
import vo.OrderVO;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 常德隆 on 2016/11/19.
 */
public class CustomerBL implements CustomerBusinessLogicService {

    CustomerDataServiceSqlImpl cds;
    HotelDataServiceSqlImpl hds;
    OrderDataServiceSqlImpl ods;

    public CustomerVO getCustomer(long id){
        CustomerVO vo=new CustomerVO();
        CustomerPO po;

        po=this.cds.find(id);
        vo.setCustomerName(po.getCustomerName());
        vo.setCustomerPhone(po.getCustomerPhone());
        vo.setCredit(po.getCredit());
        vo.setMember(po.getMember());
        vo.setBirthday(po.getBirthday());
        vo.setCompanyName(po.getCompanyName());
        vo.setId(po.getId());//根据id获得顾客信息；

        return vo;
    }

    public boolean changeCustomer(CustomerVO vo){
        boolean result=false;
        CustomerPO po;
        po=this.cds.find(vo.getId());
        po.setCustomerName(vo.getCustomerName());
        po.setCustomerPhone(vo.getCustomerPhone());
        po.setBirthday(vo.getBirthday());
        po.setCompanyName(vo.getCompanyName());
        cds.updata(po);
        result=true;
        return result;
    }

    public boolean registerMember(CustomerVO vo){
        CustomerPO po=new CustomerPO();
        po.setCustomerName(vo.getCustomerName());
        po.setCustomerPhone(vo.getCustomerPhone());
        po.setCredit(vo.getCredit());
        po.setMember(Member.normalMember);
        po.setBirthday(vo.getBirthday());
        if(vo.getCompanyName()!=null){
            po.setCompanyName(vo.getCompanyName());
            po.setMember(Member.companyMember);
        }
        po.setId(vo.getId());
        this.cds.insert(po);
        return false;
    }

    public HotelVO[] searchHotel(HotelVO vo){
        HotelVO[] hvo=new HotelVO[10];
        long id=10000;
        int i=0;
        while(this.hds.find(id)!=null){
            if(vo.getHotelLocation()==this.hds.find(id).getHotelLocation()){
                if(vo.getStars()==this.hds.find(id).getStars()){
                    hvo[i].setHotelName(this.hds.find(id).getHotelName());
                    hvo[i].setHotelPhone(this.hds.find(id).getHotelPhone());
                    hvo[i].setHotelLocation(this.hds.find(id).getHotelLocation());
                    hvo[i].setStars(this.hds.find(id).getStars());
                    id++;
                }
            }
        }
        return hvo;
    }

    public OrderVO[] viewOrder(long id){
        CustomerPO p;
        OrderVO[] vo;
        OrderPO[] po;
        p=this.cds.find(id);
        long[] idTemp=p.getOrderId1();
        vo=new OrderVO[idTemp.length];
        po=new OrderPO[idTemp.length];
        for(int i=0;i<idTemp.length;i++){
            po[i]=this.ods.find(idTemp[i]);
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
            vo[i].setEndTime(po[i].getEndTime());
            vo[i].setIsExistChild(po[i].getIsExistChild());
        }
        return vo;
    }

    public CustomerVO viewCredit(long id){
        CustomerPO po;
        CustomerVO vo=new CustomerVO();
        po=this.cds.find(id);
        vo.setCreditRecord(po.getCreditRecord());
        return vo;
    }

    public void recordCredit(long id,double creditChange){
        String[][] record=new String[100][3];
        CustomerPO po;
        po=this.cds.find(id);
        po.setCreditNum(po.getCreditNum()+1);
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        record[po.getCreditNum()][0]=sdf.format(date);
        record[po.getCreditNum()][1]=Double.toString(creditChange);
        String[][] temp=po.getCreditRecord();
        temp[po.getCreditNum()]=record[po.getCreditNum()];
        temp[po.getCreditNum()]=record[po.getCreditNum()];
        po.setCreditRecord(temp);
        this.cds.updata(po);
    }
}
