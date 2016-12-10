package data.roomdata;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dataservice.roomdataservice.RoomDataServiceSqlImpl;

import po.HotelPO;
import po.RoomPO;

/**
 * Created by 甯稿痉闅� on 2016/11/20.
 */
public class RoomData implements RoomDataServiceSqlImpl{
	 	private String sql;
	    private PreparedStatement preparedStatement;
	    private ResultSet resultSet;
	    private Connection con ;
	    String url = "jdbc:mysql://127.0.0.1:3306;databaseName=DS_HRS;user=sa;password=";
	    @Override
	    public void update(RoomPO po) {
	        sql="update 房间信息 set roomID='"+po.getRoomID()+"',roomType='"+po.getRoomType()+"',roomTotalNumber='"+po.getRoomTotalNumber()+"',roomAccessNumber='"+po.getRoomAccessNumber()+"',price='"+po.getRoomPrice()
	        	+"'where ID='"+po.getRoomID()+"'";

	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection(this.url);
	            preparedStatement=con.prepareStatement(sql);
	            preparedStatement.executeUpdate();
	            con.close();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    @Override
	    public RoomPO find(long id) {
	        sql="SELECT * from 房间信息 where ID='"+id+"'";
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection(this.url);
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
	    public void insert(RoomPO po) {
	        sql="insert into 房间信息(roomType,roomTotalNumber,roomAccessNumber,roomPrice,roomID," +
	                "," + ") values ('"+po.getRoomType()+"','"+po.getRoomTotalNumber()+"','"+po.getRoomAccessNumber()+"','"+po.getRoomPrice()+"','"+po.getRoomID()+"')";

	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection(this.url);
	            preparedStatement=con.prepareStatement(sql);
	            preparedStatement.executeUpdate();
	            con.close();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void delete(long id) {
	        sql="delete from 房间信息 where ID='"+id+"'";
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection(this.url);
	            PreparedStatement preparedStatement=con.prepareStatement(sql);
	            preparedStatement.executeUpdate();
	            con.close();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	    }
	}

