package data.webworkerdata;

import po.CustomerPO;
import po.Member;
import po.WebworkerPO;

import java.sql.*;

import dataservice.promotiondataservice.PromotionDataServiceSqlImpl;
import dataservice.webworkerdataservice.WebworkerDataServiceSqlImpl;

/**
 * Created by 常德隆 on 2016/11/20.
 */
public class WebworkerData implements WebworkerDataServiceSqlImpl{
	private String sql;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private Connection con;
	String url = "jdbc:sqlserver://127.0.0.1:1368;databaseName=DS_HRS;user=sa;password=";

	@Override
	public void update(WebworkerPO po) {
		sql = "update 网站营销人员信息 set name='" + po.getWebworkerName() + "',phone='" + po.getWebworkerPhone()
				+ "',authority'" + po.getAuthority() + "',id'" + po.getID() + "' where ID='" + po.getID() + "'";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(this.url);
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.executeUpdate();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public WebworkerPO find(long id) {
		sql = "SELECT * from 网站营销人员信息 where ID='" + id + "'";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(this.url);
			preparedStatement = con.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				WebworkerPO cpo = new WebworkerPO();
				cpo.setWebworkerName(resultSet.getString(1));

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
	public void insert(WebworkerPO po) {
		sql = "insert into 网站营销人员信息(name,phone,authority,id) values ('" + po.getWebworkerName() + "','"
				+ po.getWebworkerPhone() + "','" + po.getAuthority() + "','" + po.getID() + "')";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(this.url);
			preparedStatement = con.prepareStatement(sql);
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
		sql = "delete from 网站营销人员信息  where ID='" + id + "'";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(this.url);
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.executeUpdate();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
