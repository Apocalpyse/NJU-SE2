package vo;

import po.Member;

/**
 * Created by 常德隆 on 2016/11/19.
 */
public class CustomerVO {
    private String customerName;
    private int[] customerPhone;
    private String birthday;
    private String companyName;
    private Member member;
    private double credit;
    private long id;
    private int creditNum;
    private String[][] creditRecord;
    private long[] orderId1;
    private long[] orderId2;
    private long[] orderId3;
    private long[] orderId4;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int[] getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(int[] customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
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

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCreditNum() {
        return creditNum;
    }

    public void setCreditNum(int creditNum) {
        this.creditNum = creditNum;
    }

    public String[][] getCreditRecord() {
        return creditRecord;
    }

    public void setCreditRecord(String[][] creditRecord) {
        this.creditRecord = creditRecord;
    }

    public long[] getOrderId1() {
        return orderId1;
    }

    public void setOrderId1(long[] orderId1) {
        this.orderId1 = orderId1;
    }

    public long[] getOrderId2() {
        return orderId2;
    }

    public void setOrderId2(long[] orderId2) {
        this.orderId2 = orderId2;
    }

    public long[] getOrderId3() {
        return orderId3;
    }

    public void setOrderId3(long[] orderId3) {
        this.orderId3 = orderId3;
    }

    public long[] getOrderId4() {
        return orderId4;
    }

    public void setOrderId4(long[] orderId4) {
        this.orderId4 = orderId4;
    }
}