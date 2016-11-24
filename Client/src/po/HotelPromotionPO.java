package po;

import java.io.Serializable;

/**
 * Created by 常德隆 on 2016/11/19.
 */
    public class HotelPromotionPO extends PromotionPO implements Serializable{
        private long ID;//编号
        private String promotionName;//名称
        private String createdTime;//创建时间
        private UsageState usageState;//使用状态
        private String beginTime;//起始时间
        private String endTime;//结束时间
        private MemberType memberType;//针对用户类型
        private double discount;//折扣
        private int discountForMore[];//更多房间折扣
        private double discountformore[];//对应房间数目折扣

        public HotelPromotionPO(){}

        public HotelPromotionPO(long iD, String promotionName, String createdTime, UsageState usageState, String beginTime,
                                String endTime, MemberType memberType, double discount,int discountForMore[],double discountformore[]) {
            ID = iD;
            this.promotionName = promotionName;
            this.createdTime = createdTime;
            this.usageState = usageState;
            this.beginTime = beginTime;
            this.endTime = endTime;
            this.memberType = memberType;
            this.discount = discount;
            this.discountForMore=discountForMore;
            this.discountformore=discountformore;
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
        public int[] getDiscountForMore() {
            return discountForMore;
        }
        public void setDiscountForMore(int[] discountForMore) {
            this.discountForMore = discountForMore;
        }
        public double[] getDiscountformore() {
            return discountformore;
        }
        public void setDiscountformore(double[] discountformore) {
            this.discountformore = discountformore;
        }

    }





