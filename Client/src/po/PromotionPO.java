package po;

import java.io.Serializable;

/**
 * Created by 常德隆 on 2016/11/19.
 */
public class PromotionPO implements Serializable{
        private long ID;//编号
        private String promotionName;//名称
        private String createdTime;//创建时间
        private UsageState usageState;//使用状态

        public PromotionPO(){}

        public PromotionPO(long id,String promotionName,String createdTime,UsageState usageState){
            this.ID=id;
            this.promotionName=promotionName;
            this.createdTime=createdTime;
            this.usageState=usageState;
        }

        public String getPromotionName() {
            return promotionName;
        }
        public void setPromotionName(String promotionName) {
            this.promotionName = promotionName;
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

