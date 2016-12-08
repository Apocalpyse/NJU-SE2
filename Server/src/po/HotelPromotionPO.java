package po;

public class HotelPromotionPO extends PromotionPO{
	private long ID;//编号
	private String promotionName;//名称
	private String createdTime;//创建时间
	private UsageState usageState;//使用状态
	private String beginTime;//起始时间
	private String endTime;//结束时间
	private MemberType memberType;//针对用户类型
	private double discount;//折扣
	private int discountForMoreRoom[];//更多房间折扣
	private double discountformoreroom[];//对应房间数目折扣
	private double discountForLargerAmount[];//更高金额折扣
	private double discountforlargeramount[];//对应金额折扣
	private double birthDiscount;//生日折扣
	public HotelPromotionPO(){
		
	}
	public HotelPromotionPO(long ID, String promotionName, String createdTime, UsageState usageState, String beginTime,
			String endTime, MemberType memberType, double discount,int discountForMoreRoom[],double discountformoreroom[]
					,double discountForLargerAmount[],double discountforlargeramount[],double birthDiscount) {
		this.ID = ID;
		this.promotionName = promotionName;
		this.createdTime = createdTime;
		this.usageState = usageState;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.memberType = memberType;
		this.discount = discount;
		this.discountForMoreRoom=discountForMoreRoom;
		this.discountformoreroom=discountformoreroom;
		this.discountForLargerAmount=discountForLargerAmount;
		this.discountforlargeramount=discountforlargeramount;
	}
	public double getBirthDiscount() {
		return birthDiscount;
	}
	public void setBirthDiscount(double birthDiscount) {
		this.birthDiscount = birthDiscount;
	}
	public long getID() {
		return ID;
	}
	public double[] getDiscountForLargerAmount() {
		return discountForLargerAmount;
	}
	public double[] getDiscountformoreroom() {
		return discountformoreroom;
	}
	public void setDiscountformoreroom(double[] discountformoreroom) {
		this.discountformoreroom = discountformoreroom;
	}
	public int[] getDiscountForMoreRoom() {
		return discountForMoreRoom;
	}
	public void setDiscountForLargerAmount(double[] discountForLargerAmount) {
		this.discountForLargerAmount = discountForLargerAmount;
	}
	public double[] getDiscountforlargeramount() {
		return discountforlargeramount;
	}
	public void setDiscountforlargeramount(double[] discountforlargeramount) {
		this.discountforlargeramount = discountforlargeramount;
	}
	public void setDiscountForMoreRoom(int[] discountForMoreRoom) {
		this.discountForMoreRoom = discountForMoreRoom;
	}
	public void setID(long ID) {
		this.ID = ID;
	}
	public String getPromotionName() {
		return promotionName;
	}
	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public UsageState getUsageState() {
		return usageState;
	}
	public void setUsageState(UsageState usageState) {
		this.usageState = usageState;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public MemberType getMemberType() {
		return memberType;
	}
	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}


	
}
