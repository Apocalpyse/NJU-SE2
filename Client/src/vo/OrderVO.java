package vo;

import po.OrderState;

/**
 * Created by 常德隆 on 2016/11/19.
 */
public class OrderVO {
    private long id;
    private String customerName;
    private String customerPhone;
    private String hotelName;
    private String hotelPhone;
    private String hotelLocation;
    private String roomType;
    private int roomNumber;
    private double roomPrice;
    private double discount;
    private String startTime;
    private String endTime;
    private double totalPrice;
    private boolean isExistChild;
    private int customerNumber;

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id=id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String name){
        this.customerName=name;
    }

    public String getCustomerPhone(){
        return customerPhone;
    }

    public void setCustomerPhone(String phone){
        this.customerPhone=phone;
    }

    public String getHotelName(){
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelPhone() {
        return hotelPhone;
    }

    public void setHotelPhone(String hotelPhone) {
        this.hotelPhone = hotelPhone;
    }

    public String getHotelLocation() {
        return hotelLocation;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean getIsExistChild() {
        return isExistChild;
    }

    public void setIsExistChild(boolean isExistChild) {
        this.isExistChild = isExistChild;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }
}
