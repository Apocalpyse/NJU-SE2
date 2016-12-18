package po;
import po.Member;
import java.io.Serializable;

/**
 * Created by 常德隆 on 2016/11/19.
 */
public class CustomerPO implements Serializable{
    private String customerName;
    private String customerPhone;
    private String birthday;
    private String companyName;
    private String credit;
    private Member member;
    private long id;
    private String creditNum;
    private String[][] creditRecord;
    private String[] orderId1;
    private String[] orderId2;
    private String[] orderId3;
    private String[] orderId4;

    public CustomerPO(){}

    public CustomerPO(String customerName,String customerPhone,Member member ,String birthday,String companyName,String credit){
        this.customerName=customerName;
        this.customerPhone=customerPhone;
        this.member=member;
        this.birthday=birthday;
        this.companyName=companyName;
        this.credit=credit;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member normalmember) {
        this.member = normalmember;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreditNum() {
        return creditNum;
    }

    public void setCreditNum(String creditNum) {
        this.creditNum = creditNum;
    }

    public String[][] getCreditRecord() {
        return creditRecord;
    }

    public void setCreditRecord(String[][] creditRecord) {
        this.creditRecord = creditRecord;
    }

    public String[] getOrderId1() {
        return orderId1;
    }

    public void setOrderId1(String[] orderId1) {
        this.orderId1 = orderId1;
    }

    public String[] getOrderId2() {
        return orderId2;
    }

    public void setOrderId2(String[] orderId2) {
        this.orderId2 = orderId2;
    }

    public String[] getOrderId3() {
        return orderId3;
    }

    public void setOrderId3(String[] orderId3) {
        this.orderId3 = orderId3;
    }

    public String[] getOrderId4() {
        return orderId4;
    }

    public void setOrderId4(String[] orderId4) {
        this.orderId4 = orderId4;
    }
}
