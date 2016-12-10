package data.userdata;

import dataservice.userdataservice.UserDataServiceSqlImpl;
import po.CustomerPO;
import po.Member;
import po.UserPO;

import java.sql.*;

/**
 * Created by 常德隆 on 2016/11/20.
 */
public class UserData implements UserDataServiceSqlImpl{
    private String sql;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection con ;
    String url = "jdbc:mysql://127.0.0.1:3306;databaseName=DS_HRS;user=sa;password=";

    @Override
    public void update(UserPO po) {
        sql="update 登录信息 set account='"+po.getAccount()+"',password='"+po.getPassword()+"',id='"+po.getId()+"'";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
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
    public UserPO find(String account) {
        sql="SELECT * from 登录信息 where ID='"+account+"'";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(this.url);
            preparedStatement=con.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();

            if (resultSet.next()) {
                UserPO upo=new UserPO();
                upo.setAccount(resultSet.getString(1));
                upo.setPassword(resultSet.getString(2));
                upo.setId(Long.parseLong(resultSet.getString(3)));
                con.close();
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
    public void insert(UserPO po) {
        sql="insert into 登录信息(account,password,id) values ('"+po.getAccount()+"','"+po.getPassword()+"','"+po.getId()+"')";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
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
        sql="delete from 登录信息 where ID='"+id+"'";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
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
