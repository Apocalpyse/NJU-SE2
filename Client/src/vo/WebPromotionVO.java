package vo;

import po.MemberType;
import po.UsageState;

public class WebPromotionVO {
	private long ID;//编号
	private String promotionName;//名称
	private String createdTime;//创建时间
	private UsageState usageState;//使用状态
	private String beginTime;//起始时间
	private String endTime;//结束时间
	private String businessDistrict[];//针对商圈
	private MemberType memberType;//针对用户类型
	private double discount;//折扣
	
	public WebPromotionVO(long iD, String promotionName, String createdTime, UsageState usageState, String beginTime,
			String endTime, String[] businessDistrict, MemberType memberType, double discount) {
		super();
		ID = iD;
		this.promotionName = promotionName;
		this.createdTime = createdTime;
		this.usageState = usageState;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.businessDistrict = businessDistrict;
		this.memberType = memberType;
		this.discount = discount;
	}
	public String[] getBusinessDistrict() {
		return businessDistrict;
	}
	public void setBusinessDistrict(String[] businessDistrict) {
		this.businessDistrict = businessDistrict;
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
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
