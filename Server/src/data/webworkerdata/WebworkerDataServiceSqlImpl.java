package data.webworkerdata;

import dataservice.webworkerdataservice.WebworkerDataService;
import po.Authority;
import po.CustomerPO;
import po.Member;
import po.WebworkerPO;

import java.sql.*;


/**
 * Created by 常德隆 on 2016/11/20.
 */
public class WebworkerDataServiceSqlImpl implements WebworkerDataService {
	private String sql;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private Connection con;
	String url = "jdbc:mysql://127.0.0.1:3306/DS_HRS";
	String name="root";
	String password="2578";

	@Override
	public boolean update(WebworkerPO po) {
		sql = "update 网站营销人员信息 set name='" + po.getWebworkerName() + "',phone='" + po.getWebworkerPhone()
				+ "',authority'" + po.getAuthority() + "',id'" + po.getID() + "' where ID='" + po.getID() + "'";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(this.url,this.name,this.password);
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
	public WebworkerPO find(long id) {
		sql = "SELECT * from 网站营销人员信息 where ID='" + id + "'";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(this.url,this.name,this.password);
			preparedStatement = con.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				WebworkerPO cpo = new WebworkerPO();
				cpo.setWebworkerName(resultSet.getString(1));
				cpo.setWebworkerPhone(resultSet.getString(2));
				if (resultSet.getString(3).equals("Marketer")) {
					cpo.setAuthority(Authority.Marketer);
				} else {
					cpo.setAuthority(Authority.Manager);
				}
				cpo.setID(Long.parseLong(resultSet.getString(4)));
				con.close();
				return cpo;
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
	public boolean insert(WebworkerPO po) {
		sql = "insert into 网站营销人员信息(name,phone,authority,id) values ('" + po.getWebworkerName() + "','"
				+ po.getWebworkerPhone() + "','" + po.getAuthority() + "','" + po.getID() + "')";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(this.url,this.name,this.password);
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
	public boolean delete(long id) {
		sql = "delete from 网站营销人员信息  where ID='" + id + "'";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(this.url,this.name,this.password);
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
}
