package data.promotiondata;

import dataservice.promotiondataservice.PromotionDataService;
import po.HotelPromotionPO;
import po.MemberPromotionPO;
import po.MemberType;
import po.UsageState;
import po.WebPromotionPO;

import java.rmi.RemoteException;
import java.sql.*;

public class PromotionDataServiceSqlImpl implements PromotionDataService {
	private String sql;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private Connection con;
	String url = "jdbc:mysql://127.0.0.1:3306/DS_HRS";
	String name = "root";
	String password = "2578";

	private static PromotionDataServiceSqlImpl pdssi=null;

	public static PromotionDataServiceSqlImpl getInstance() throws RemoteException {
		if(pdssi==null){
			pdssi=new PromotionDataServiceSqlImpl();
		}
		return pdssi;
	}

	@Override
	public boolean update1(MemberPromotionPO po) {
		sql = "update 会员制度信息 set name='" + po.getPromotionName() + "',time='" + po.getCreatedTime() + "',creditLevels='"
				+ po.getCredit() + "',discountLevels='" + po.getDiscountForMember() + "'," + "usageState='"
				+ po.getUsageState() + "',id'" + po.getID() + "' where ID='" + po.getID() + "'";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(this.url, this.name, this.password);
			preparedStatement = con.prepareStatement(sql);
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
	public MemberPromotionPO find1(long id) {
		sql = "SELECT * from 会员制度信息 where ID='" + id + "'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(this.url, this.name, this.password);
			preparedStatement = con.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				MemberPromotionPO mppo = new MemberPromotionPO();
				mppo.setPromotionName(resultSet.getString(1));
				mppo.setCreatedTime(resultSet.getString(2));
				String[] temp1 = resultSet.getString(3).split(" ");
				double[] temp2 = null;
				for (int i = 0; i < temp1.length; i = i + 3) {
					temp2[i] = Double.parseDouble(temp1[i]);
				}
				// 获取creditLevels数组
				mppo.setCredit(temp2);
				String[] temp3 = resultSet.getString(4).split(" ");
				double[] temp4 = null;
				for (int i = 0; i < temp1.length; i = i + 3) {
					temp4[i] = Double.parseDouble(temp3[i]);
				}
				// 获取discountLevels数组
				mppo.setDiscountForMember(temp4);
				switch (resultSet.getString(5)) {
				case "Unused":
					mppo.setUsageState(UsageState.Unused);
					break;
				case "Using":
					mppo.setUsageState(UsageState.Using);
					break;
				}
				mppo.setID(id);
				con.close();
				return mppo;
			} else {
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
	public boolean insert1(MemberPromotionPO po) {
		sql = "insert into 会员制度信息 (name,time,creditLevels,discountLevels,usageState,id) values ('"
				+ po.getPromotionName() + "','" + po.getCreatedTime() + "','" + po.getCredit() + "','"
				+ po.getDiscountForMember() + "'," + "','" + po.getUsageState() + "','" + po.getID() + "')";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(this.url, this.name, this.password);
			preparedStatement = con.prepareStatement(sql);
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
	public boolean delete1(long id) {
		sql = "delete from 会员制度信息  where ID='" + id + "'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(this.url, this.name, this.password);
			PreparedStatement preparedStatement = con.prepareStatement(sql);
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
	public long findMaxId1() {
		sql = "select max(ID) from 会员制度信息";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(this.url, this.name, this.password);
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.executeUpdate();
			long result = resultSet.getLong(1);
			con.close();
			return result;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	// *********MEMBERPROMOTION

	@Override
	public boolean update2(HotelPromotionPO po) {
		sql = "update 酒店促销策略信息  set name='" + po.getPromotionName() + "',createdTime='" + po.getCreatedTime()
				+ "',beginTime='" + po.getBeginTime() + "',endTime='" + po.getEndTime() + "',birthDiscount ='"
				+ po.getBirthDiscount() + "',companyDiscount='" + po.getCompanyDiscount() + "',discount='"
				+ po.getDiscount() + "',largerAmount='" + po.getDiscountForLargerAmount()
				+ "',discountForLargerAmount='" + po.getDiscountforlargeramount() + "',moreRoom='"
				+ po.getDiscountForMoreRoom() + "',discountForMoreRoom'" + po.getDiscountformoreroom()
				+ "',memberType='" + po.getMemberType() + "',usageState='" + po.getUsageState() + "',hotelid'"
				+ po.getHotelID() + "',id'" + po.getID() + "' where ID='" + po.getID() + "'";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(this.url, this.name, this.password);
			preparedStatement = con.prepareStatement(sql);
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
	public HotelPromotionPO find2(long id) {
		sql = "SELECT * from 酒店促销策略信息  where ID='" + id + "'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(this.url, this.name, this.password);
			preparedStatement = con.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				HotelPromotionPO hppo = new HotelPromotionPO();
				hppo.setPromotionName(resultSet.getString(1));
				hppo.setCreatedTime(resultSet.getString(2));
				hppo.setBeginTime(resultSet.getString(3));
				hppo.setEndTime(resultSet.getString(4));
				hppo.setBirthDiscount(Double.parseDouble(resultSet.getString(5)));
				hppo.setCompanyDiscount(Double.parseDouble(resultSet.getString(6)));
				hppo.setDiscount(Double.parseDouble(resultSet.getString(7)));
				hppo.setDiscountForLargerAmount(Double.parseDouble(resultSet.getString(8)));
				hppo.setDiscountforlargeramount(Double.parseDouble(resultSet.getString(9)));
				hppo.setDiscountForMoreRoom(Integer.parseInt(resultSet.getString(10)));
				hppo.setDiscountformoreroom(Double.parseDouble(resultSet.getString(11)));
				switch (resultSet.getString(12)) {
				case "ALL":
					hppo.setMemberType(MemberType.All);
					break;
				case "Average":
					hppo.setMemberType(MemberType.Average);
					break;
				case "Birthday":
					hppo.setMemberType(MemberType.Birthday);
					break;
				case "CooperationMember":
					hppo.setMemberType(MemberType.CooperationMember);
					break;
				case "Member":
					hppo.setMemberType(MemberType.Member);
					break;
				case "VIPMember":
					hppo.setMemberType(MemberType.VIPMember);
					break;
				}
				switch (resultSet.getString(13)) {
				case "Unused":
					hppo.setUsageState(UsageState.Unused);
					break;
				case "Using":
					hppo.setUsageState(UsageState.Using);
					break;
				}
				hppo.setHotelID(Long.parseLong(resultSet.getString(13)));
				hppo.setID(Long.parseLong(resultSet.getString(14)));
				con.close();
				return hppo;
			} else {
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
	public boolean insert2(HotelPromotionPO po) {
		sql = "insert into 酒店促销策略信息 (name,createdTime,beginTime,endTime,birthDiscount,companyDiscount,discount,discountForLargerAmount,discountforlargeramount,"
				+ "discountForMoreRoom,discountformoreroom,memberType,usageState,hotelid,id) values ('"
				+ po.getPromotionName() + "','" + po.getCreatedTime() + "','" + po.getBeginTime() + "','"
				+ po.getEndTime() + "','" + po.getBirthDiscount() + "','" + po.getCompanyDiscount() + "','"
				+ po.getDiscount() + "','" + po.getDiscountForLargerAmount() + "','" + po.getDiscountforlargeramount()
				+ "','" + po.getDiscountForMoreRoom() + "','" + po.getDiscountformoreroom() + "','" + po.getMemberType()
				+ "','" + po.getUsageState() + "','" + po.getHotelID() + "','" + po.getID() + "')";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(this.url, this.name, this.password);
			preparedStatement = con.prepareStatement(sql);
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
	public boolean delete2(long id) {
		sql = "delete from 酒店促销策略信息  where ID='" + id + "'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(this.url, this.name, this.password);
			PreparedStatement preparedStatement = con.prepareStatement(sql);
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
	public long findMaxId2() {
		sql = "select max(ID) from 酒店促销策略信息";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(this.url, this.name, this.password);
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.executeUpdate();
			long result = resultSet.getLong(1);
			con.close();
			return result;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean update3(WebPromotionPO po) {
		sql = "update 网站促销策略信息  set name='" + po.getPromotionName() + "',createdTime='" + po.getCreatedTime()
				+ "',beginTime='" + po.getBeginTime() + "',endTime='" + po.getEndTime() + "',discount='"
				+ po.getDiscount() + "',memberType='" + po.getMemberType() + "',businessDistrict='"
				+ po.getBusinessDistrict() + "',usageState='" + po.getUsageState() + "',id='" + po.getID()
				+ "' where ID='" + po.getID() + "'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(this.url, this.name, this.password);
			preparedStatement = con.prepareStatement(sql);
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
	public WebPromotionPO find3(long id) {
		sql = "SELECT * from 网站促销策略信息  where ID='" + id + "'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(this.url, this.name, this.password);
			preparedStatement = con.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				WebPromotionPO wppo = new WebPromotionPO();
				wppo.setPromotionName(resultSet.getString(1));
				wppo.setCreatedTime(resultSet.getString(2));
				wppo.setBeginTime(resultSet.getString(3));
				wppo.setEndTime(resultSet.getString(4));
				wppo.setDiscount(Double.parseDouble(resultSet.getString(5)));
				switch (resultSet.getString(6)) {
				case "ALL":
					wppo.setMemberType(MemberType.All);
					break;
				case "Average":
					wppo.setMemberType(MemberType.Average);
					break;
				case "Birthday":
					wppo.setMemberType(MemberType.Birthday);
					break;
				case "CooperationMember":
					wppo.setMemberType(MemberType.CooperationMember);
					break;
				case "Member":
					wppo.setMemberType(MemberType.Member);
					break;
				case "VIPMember":
					wppo.setMemberType(MemberType.VIPMember);
					break;
				}
				wppo.setBusinessDistrict(resultSet.getString(7).split(" "));
				switch (resultSet.getString(8)) {
				case "Unused":
					wppo.setUsageState(UsageState.Unused);
					break;
				case "Using":
					wppo.setUsageState(UsageState.Using);
					break;
				}
				wppo.setID(Long.parseLong(resultSet.getString(9)));
				con.close();
				return wppo;
			} else {
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
	public boolean insert3(WebPromotionPO po) {
		sql = "insert into 网站促销策略信息 (name,createdTime,beginTime,endTime,discount,memberType,businessDistrict,usageState,id) values ('"
				+ po.getPromotionName() + "','" + po.getCreatedTime() + "','" + po.getBeginTime() + "','"
				+ po.getEndTime() + "','" + po.getDiscount() + "','" + po.getMemberType() + "','"
				+ po.getBusinessDistrict() + "','" + po.getUsageState() + "','" + po.getID() + "')";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(this.url, this.name, this.password);
			preparedStatement = con.prepareStatement(sql);
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
	public boolean delete3(long id) {
		sql = "delete from 网站促销策略信息  where ID='" + id + "'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(this.url, this.name, this.password);
			PreparedStatement preparedStatement = con.prepareStatement(sql);
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
	public long findMaxId3() {
		sql = "select max(ID) from 网站促销策略信息";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(this.url, this.name, this.password);
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.executeUpdate();
			long result = resultSet.getLong(1);
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
