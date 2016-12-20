package data.roomdata;

import java.rmi.RemoteException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import dataservice.roomdataservice.RoomDataService;
import po.RoomPO;

/**
 * Created by 甯稿痉闅� on 2016/11/20.
 */
public class RoomDataServiceSqlImpl implements RoomDataService {
	 	private String sql;
	    private PreparedStatement preparedStatement;
	    private ResultSet resultSet;
	    private Connection con ;
	    String url = "jdbc:mysql://127.0.0.1:3306/DS_HRS";
	    String name="root";
	    String password="2578";

	private static RoomDataServiceSqlImpl rdssi=null;

	public static RoomDataServiceSqlImpl getInstance() throws RemoteException {
		if(rdssi==null){
			rdssi=new RoomDataServiceSqlImpl();
		}
		return rdssi;
	}

	    @Override
	    public boolean update(RoomPO po) {
	        sql="update 房间信息 set roomID='"+po.getRoomID()+"',roomType='"+po.getRoomType()+"',roomTotalNumber='"+po.getRoomTotalNumber()+"',roomAccessNumber='"+po.getRoomAccessNumber()+"',price='"+po.getRoomPrice()
	        	+"'where ID='"+po.getRoomID()+"'";

	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection(this.url,this.name,this.password);
	            preparedStatement=con.prepareStatement(sql);
	            preparedStatement.executeUpdate();
	            con.close();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return true;
	    }
	    @Override
	    public RoomPO find(long id) {
	        sql="SELECT * from 房间信息 where ID='"+id+"'";
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection(this.url,this.name,this.password);
	            preparedStatement=con.prepareStatement(sql);
	            resultSet=preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                RoomPO rpo=new RoomPO();
	                rpo.setRoomID(Long.parseLong(resultSet.getString(1)));
	                rpo.setRoomType(resultSet.getString(2));
	                rpo.setRoomTotalNumber(resultSet.getInt(3));
	                rpo.setRoomAccessNumber(resultSet.getInt(4));
	                rpo.setRoomPrice(resultSet.getDouble(5));
	           
	                return rpo;
	            }
	            else {
	                con.close();
	                return null;
	            }

	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    @Override
	    public boolean insert(RoomPO po) {
	        sql="insert into 房间信息(roomType,roomTotalNumber,roomAccessNumber,roomPrice,roomID," +
	                "," + ") values ('"+po.getRoomType()+"','"+po.getRoomTotalNumber()+"','"+po.getRoomAccessNumber()+"','"+po.getRoomPrice()+"','"+po.getRoomID()+"')";

	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection(this.url,this.name,this.password);
	            preparedStatement=con.prepareStatement(sql);
	            preparedStatement.executeUpdate();
	            con.close();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return true;
	    }

	    @Override
	    public boolean delete(long id) {
	        sql="delete from 房间信息 where ID='"+id+"'";
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection(this.url,this.name,this.password);
	            PreparedStatement preparedStatement=con.prepareStatement(sql);
	            preparedStatement.executeUpdate();
	            con.close();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
          return true;
	    }

	@Override
	public long findMaxId() {
		sql="select max(ID) from 房间信息";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(this.url,this.name,this.password);
			PreparedStatement preparedStatement=con.prepareStatement(sql);
			preparedStatement.executeUpdate();
			long result=resultSet.getLong(1);
			con.close();
			return result;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	}

