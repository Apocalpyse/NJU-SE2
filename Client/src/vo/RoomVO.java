package vo;

/**
 * Created by 常德隆 on 2016/11/19.
 */
public class RoomVO {
	//图片
	String roomType;//房间类型
	int roomTotalNumber;//房间总数量
	int roomAccessNumber;//可预定的房间数量
	double roomPrice;//房间价格
		
	public void setRoomType(String st){
		roomType=st;
	}
	public void setRoomTotalNumber(int rtn){
		roomTotalNumber=rtn;
	}
	public void setRoomAccessNumber(int ran){
		roomAccessNumber=ran;
	}
	public void setRoomPrice(double rp){
		roomPrice=rp;
	}
		
	public String getRoomType(){
		return roomType;
	}
	public int getRoomTotalNumber(){
		return roomTotalNumber;
	}
	public int getRoomAccessNumber(){
		return roomAccessNumber;
	}
	public double getRoomPrice(){
		return roomPrice;
	}	
}
