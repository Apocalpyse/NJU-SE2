package po;

/**
 * Created by 常德隆 on 2016/11/19.
 */
public class RoomPO {
    //图片
    private String[] roomType;//房间类型
    private int[] roomTotalNumber;//房间总数量
    private int[] roomAccessNumber;//可预定的房间数量
    private double[] roomPrice;//房间价格

    public RoomPO(){}

    public RoomPO(String[] st,int[] rtn,int[] ran,double[] rp){
        roomType=st;
        roomTotalNumber=rtn;
        roomAccessNumber=ran;
        roomPrice=rp;
    }

    public void setRoomType(String[] st){
        roomType=st;
    }
    public void setRoomTotalNumber(int[] rtn){
        roomTotalNumber=rtn;
    }
    public void setRoomAccessNumber(int[] ran){
        roomAccessNumber=ran;
    }
    public void setRoomPrice(double[] rp){
        roomPrice=rp;
    }

    public String[] getRoomType(){
        return roomType;
    }
    public int[] getRoomTotalNumber(){
        return roomTotalNumber;
    }
    public int[] getRoomAccessNumber(){
        return roomAccessNumber;
    }
    public double[] getRoomPrice(){
        return roomPrice;
    }
}
