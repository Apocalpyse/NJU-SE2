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
    String url = "jdbc:mysql://127.0.0.1:3306/DS_HRS";
    String name="root";
    String password="2578";

    @Override
    public void update(UserPO po) {
        sql="update 帐号信息 set myaccount='"+po.getAccount()+"',mypassword='"+po.getPassword()+"',id='"+po.getId()+"'";

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
    }

    @Override
    public UserPO find(String account) {
        sql="SELECT * from 帐号信息 where myaccount='"+account+"'";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动加载成功");
            con = DriverManager.getConnection(this.url,this.name,this.password);
            System.out.println("数据库连接成功");
            preparedStatement=con.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();

            if (resultSet.next()) {
                UserPO upo=new UserPO();
                upo.setId(Long.parseLong(resultSet.getString(1)));
                upo.setAccount(resultSet.getString(2));
                upo.setPassword(resultSet.getString(3));
                con.close();
                return upo;
            }
            else {
                con.close();
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
        sql="insert into 帐号信息(myaccount,mypassword,id) values ('"+po.getAccount()+"','"+po.getPassword()+"','"+po.getId()+"')";

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
    }

    @Override
    public void delete(long id) {
        sql="delete from 帐号信息 where ID='"+id+"'";
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

    }
}
