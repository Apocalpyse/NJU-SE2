public class RoomPO {
	Long roomID;//鎴块棿ID
	String roomType;//鎴块棿绫诲瀷
	int roomTotalNumber;//鎴块棿鎬绘暟閲�
	int roomAccessNumber;//鍙瀹氱殑鎴块棿鏁伴噺
	double roomPrice;//鎴块棿浠锋牸
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
