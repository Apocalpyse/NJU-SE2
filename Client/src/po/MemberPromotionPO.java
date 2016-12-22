package po;

import java.io.Serializable;

public class MemberPromotionPO extends PromotionPO implements Serializable{
	private long ID;//编号
	private String promotionName;//名称
	private String createdTime;//创建时间
	private UsageState usageState;//使用状态
	private double credit[];//会员等级划分
	private double discountForMember[];//对各等级折扣
	public MemberPromotionPO(){
		
	}

	public MemberPromotionPO(long iD, String promotionName, String createdTime, UsageState usageState, double[] credit,
			double[] discountForMember) {
		super();
		ID = iD;
		this.promotionName = promotionName;
		this.createdTime = createdTime;
		this.usageState = usageState;
		this.credit = credit;
		this.discountForMember = discountForMember;
	}

	public long getID() {
		return ID;
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
	public double[] getCredit() {
		return credit;
	}
	public void setCredit(double[] credit) {
		this.credit = credit;
	}
	public double[] getDiscountForMember() {
		return discountForMember;
	}
	public void setDiscountForMember(double[] discountForMember) {
		this.discountForMember = discountForMember;
	}
	
}
