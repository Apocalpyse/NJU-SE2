package po;

import java.io.Serializable;

public class RoomPO implements Serializable{
	Long roomID;//閹村潡妫縄D
	String roomType;//閹村潡妫跨猾璇茬��
	int roomTotalNumber;//閹村潡妫块幀缁樻殶闁诧拷
	int roomAccessNumber;//閸欘垶顣╃�规氨娈戦幋鍧楁？閺佷即鍣�
	double roomPrice;//閹村潡妫挎禒閿嬬壐
	public RoomPO(){
		
	}
	public RoomPO(Long i,String st,int rtn,int ran,double rp){
		roomID=i;
		roomType=st;
		roomTotalNumber=rtn;
		roomAccessNumber=ran;
		roomPrice=rp;
	}
	public void setRoomID(long i){
		roomID=i;
	}
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
	
	public Long getRoomID(){
		return roomID;
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
