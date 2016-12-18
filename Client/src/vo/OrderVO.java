package vo;

import po.OrderState;

/**
 * Created by 甯稿痉闅� on 2016/11/19.
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
	    private String executeTime;
	    private double totalPrice;
	    private OrderState os;
	    private boolean isExistChild;
	    private int customerNumber;
	    private long masterId;

	    public OrderVO(){}

	    public OrderVO(long id,String customerName,String customerPhone,String hotelName,String hotelPhone,
	                   String hotelLocation,String roomType,int roomNumber,double roomPrice,
	                   double discount,String startTime,String endTime,String executeTime,double totalPrice,
	                   OrderState os,boolean isExistChild,int customerNumber,long masterId){
	        this.id=id;
	        this.customerName=customerName;
	        this.customerPhone=customerPhone;
	        this.hotelName=hotelName;
	        this.hotelPhone=hotelPhone;
	        this.hotelLocation=hotelLocation;
	        this.roomType=roomType;
	        this.roomNumber=roomNumber;
	        this.roomPrice=roomPrice;
	        this.discount=discount;
	        this.startTime=startTime;
	        this.endTime=endTime;
	        this.executeTime=executeTime;
	        this.totalPrice=totalPrice;
	        this.os=os;
	        this.isExistChild=isExistChild;
	        this.customerNumber=customerNumber;
			this.masterId=masterId;
	    }

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

	    public String getExecuteTime() {
	        return executeTime;
	    }

	    public void setExecuteTime(String executeTime) {
	        this.executeTime = executeTime;
	    }

	    public double getTotalPrice() {
	        return totalPrice;
	    }

	    public void setTotalPrice(double totalPrice) {
	        this.totalPrice = totalPrice;
	    }

	    public OrderState getOs() {
	        return os;
	    }

	    public void setOs(OrderState os) {
	        this.os = os;
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

	    public long getMasterId() {
	        return masterId;
	    }

	    public void setMasterId(long masterId) {
	        this.masterId = masterId;
	    }
}
