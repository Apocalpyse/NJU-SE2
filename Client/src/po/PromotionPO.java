package po;

public class PromotionPO {
	private long ID;//编号
	private String promotionName;//名称
	public String getPromotionName() {
		return promotionName;
	}
	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}
	private String createdTime;//创建时间
	private UsageState usageState;//使用状态
	public PromotionPO(){
		
	}
	public PromotionPO(long iD, String promotionName, String createdTime, UsageState usageState) {
		super();
		ID = iD;
		this.promotionName = promotionName;
		this.createdTime = createdTime;
		this.usageState = usageState;
	}
	public long getID() {
		return ID;
	}
	public void setID(long ID) {
		this.ID = ID;
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
}
