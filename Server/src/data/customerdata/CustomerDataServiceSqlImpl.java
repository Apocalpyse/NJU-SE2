package data.customerdata;

import dataservice.customerdataservice.CustomerDataService;
import po.CustomerPO;
import po.Member;

import java.sql.*;

/**
 * Created by 常德隆 on 2016/11/20.
 */
public class CustomerDataServiceSqlImpl implements CustomerDataService {

    private String sql;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection con ;
    String url = "jdbc:mysql://127.0.0.1:3306/DS_HRS";
    String name="root";
    String password="2578";

    @Override
    public boolean update(CustomerPO po) {
      sql="update 客户信息 set name='"+po.getCustomerName()+"',phone='"+po.getCustomerPhone()+"',credit='"+po.getCredit()+"',creditNum='"+po.getCreditNum()+"',creditRecord='"+po.getCreditRecord()
              +"',birthday='"+po.getBirthday()+"',companyName'"+po.getCompanyName()+"',member'"+po.getMember()+"',id'"+po.getId()+"',orderId1'"+po.getOrderId1()+"',orderId2'"+po.getOrderId2()+"',orderId3'"
              +po.getOrderId3()+"',orderId4'"+po.getOrderId4()+"' where ID='"+po.getId()+"'";

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
    public CustomerPO find(long id) {
        sql="SELECT * from 客户信息 where ID='"+id+"'";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(this.url,this.name,this.password);
            preparedStatement=con.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();

            if (resultSet.next()) {
                CustomerPO cpo=new CustomerPO();
                cpo.setCustomerName(resultSet.getString(1));
                cpo.setCustomerPhone(resultSet.getString(2));
                cpo.setCredit(resultSet.getString(3));
                cpo.setCreditNum(resultSet.getString(4));
                String[] temp1=resultSet.getString(5).split(" ");
                String[][] temp2=null;
                int j=0;
                for(int i=0;i<temp1.length;i=i+3){
                    temp2[j][0]=temp1[i];
                    temp2[j][1]=temp1[i+1];
                    temp2[j][2]=temp1[i+2];
                    j++;
                }
                cpo.setCreditRecord(temp2);
                cpo.setBirthday(resultSet.getString(6));
                cpo.setCompanyName(resultSet.getString(7));
                switch (resultSet.getString(8)){
                    case "notMember": cpo.setMember(Member.notMember);
                    case "normalMember": cpo.setMember(Member.normalMember);
                    case "companyMember": cpo.setMember(Member.companyMember);
                }
                cpo.setId(Long.parseLong(resultSet.getString(9)));
                String[] temp3=resultSet.getString(10).split(" ");
                String[] temp4=resultSet.getString(11).split(" ");
                String[] temp5=resultSet.getString(12).split(" ");
                String[] temp6=resultSet.getString(13).split(" ");
                cpo.setOrderId1(temp3);
                cpo.setOrderId2(temp4);
                cpo.setOrderId3(temp5);
                cpo.setOrderId4(temp6);
                con.close();
                return  cpo;
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
    public boolean insert(CustomerPO po) {
        sql="insert into 客户信息(name,phone,credit,creditNum,creditRecord,birthday,companyName,member,id,orderId1,orderId2,orderId3,orderId4) values ('"+po.getCustomerName()+"','"+po.getCustomerPhone()+"','"+po.getCredit()+"','"+po.getCreditNum()+"','"+po.getCreditRecord()+"','"+po.getBirthday()+"','"
                +po.getCompanyName()+"','"+po.getMember()+"','"+po.getId()+"','"+po.getOrderId1()+"','"+po.getOrderId2()+"','"+po.getOrderId3()+"','"+po.getOrderId4()+"')";

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
        sql="delete from 客户信息 where ID='"+id+"'";
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


}
