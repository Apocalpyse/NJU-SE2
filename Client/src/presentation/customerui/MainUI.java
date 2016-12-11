package presentation.customerui;

import businesslogic.customerbl.CustomerController;
import businesslogic.orderbl.OrderController;
import businesslogic.userbl.UserController;
import dataservice.customerdataservice.CustomerDataServiceSqlImpl;
import dataservice.hoteldataservice.HotelDataServiceSqlImpl;
import dataservice.orderdataservice.OrderDataServiceSqlImpl;
import dataservice.userdataservice.UserDataServiceSqlImpl;
import po.CustomerPO;
import po.OrderPO;
import po.UserPO;
import vo.CustomerVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.UserVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;

/**
 * Created by 常德隆 on 2016/11/29.
 */
public class MainUI {

    CustomerController cc;
    OrderController oc;
    UserController uc;

    public MainUI(String account,String password){
        JFrame frame=new JFrame("DS酒店管家");
        JTabbedPane jtp=new JTabbedPane(JTabbedPane.LEFT);
        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel();
        JPanel panel4=new JPanel();
        Font font=new Font("微软雅黑",Font.BOLD,16);

        jtp.setFont(font);
        jtp.add("搜索酒店",panel1);
        jtp.add("个人信息",panel2);
        jtp.add("我的订单",panel3);
        jtp.add("信用记录",panel4);

        //搜索界面；
        JLabel label1=new JLabel("地址选择");
        JLabel label2=new JLabel("房间价格");
        JLabel label3=new JLabel("酒店星级");
        JLabel label4=new JLabel("省");
        JLabel label5=new JLabel("市");
        JLabel label6=new JLabel("商圈");
        label1.setFont(font);
        label2.setFont(font);
        label3.setFont(font);
        label4.setFont(font);
        label5.setFont(font);
        label6.setFont(font);
        JButton button=new JButton("搜索");
        button.setFont(font);
        JComboBox province=new JComboBox();
        province.setFont(font);
        JComboBox city=new JComboBox();
        city.setFont(font);
        JComboBox businessArea=new JComboBox();
        businessArea.setFont(font);
        JCheckBox price1=new JCheckBox("0~99");
        price1.setFont(font);
        JCheckBox price2=new JCheckBox("100~199");
        price2.setFont(font);
        JCheckBox price3=new JCheckBox("200~299");
        price3.setFont(font);
        JCheckBox price4=new JCheckBox("299以上");
        price4.setFont(font);
        JCheckBox star1=new JCheckBox("一星级");
        star1.setFont(font);
        JCheckBox star2=new JCheckBox("二星级");
        star2.setFont(font);
        JCheckBox star3=new JCheckBox("三星级");
        star3.setFont(font);
        JCheckBox star4=new JCheckBox("四星级");
        star4.setFont(font);
        JCheckBox star5=new JCheckBox("五星级");
        star5.setFont(font);

        panel1.add(label1);
        panel1.add(label2);
        panel1.add(label3);
        panel1.add(label4);
        panel1.add(label5);
        panel1.add(label6);
        panel1.setLayout(null);
        panel1.add(province);
        panel1.add(city);
        panel1.add(businessArea);
        panel1.add(price1);
        panel1.add(price2);
        panel1.add(price3);
        panel1.add(price4);
        panel1.add(star1);
        panel1.add(star2);
        panel1.add(star3);
        panel1.add(star4);
        panel1.add(star5);
        label1.setBounds(100,100,150,60);
        label4.setBounds(260,100,30,60);
        province.setBounds(300,100,150,60);
        label5.setBounds(460,100,30,60);
        city.setBounds(500,100,130,60);
        label6.setBounds(640,100,50,60);
        businessArea.setBounds(700,100,150,60);
        label2.setBounds(100,200,120,60);
        price1.setBounds(270,200,120,60);
        price2.setBounds(440,200,120,60);
        price3.setBounds(610,200,120,60);
        price4.setBounds(780,200,120,60);
        label3.setBounds(100,300,100,60);
        star1.setBounds(240,300,100,60);
        star2.setBounds(380,300,100,60);
        star3.setBounds(520,300,100,60);
        star4.setBounds(660,300,100,60);
        star5.setBounds(800,300,100,60);
        button.setBounds(440,460,120,40);
        panel1.add(button);

        HotelVO vo=new HotelVO();
        StringBuffer sb=new StringBuffer();
        sb.append((String) province.getSelectedItem());
        sb.append((String)city.getSelectedItem());
        sb.append((String)businessArea.getSelectedItem());
        vo.setHotelLocation(sb.toString());
        String[] stars=new String[5];
        if(star1.isSelected()){
            stars[0]="1";
            vo.setStars(stars[0]);
        }
        if(star2.isSelected()){
            stars[1]="2";
            vo.setStars(stars[1]);
        }
        if(star3.isSelected()){
            stars[2]="3";
            vo.setStars(stars[2]);
        }
        if(star4.isSelected()){
            stars[3]="4";
            vo.setStars(stars[3]);
        }
        if(star5.isSelected()){
            stars[4]="5";
            vo.setStars(stars[4]);
        }

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchResultUI ui=new SearchResultUI(vo);
            }
        });

        //个人信息界面；
        panel2.setLayout(null);
        JLabel label7=new JLabel("姓名");
        label7.setFont(font);
        JLabel label8=new JLabel("联系电话");
        label8.setFont(font);
        JLabel label9=new JLabel("会员");
        label9.setFont(font);
        JLabel label10=new JLabel("信用值");
        label10.setFont(font);
        JLabel label11=new JLabel("生日");
        label11.setFont(font);
        JLabel label12=new JLabel("企业名称");
        label12.setFont(font);
        JTextField name=new JTextField();
        name.setFont(font);
        name.setEditable(false);
        JTextField phone=new JTextField();
        phone.setFont(font);
        phone.setEditable(false);
        JTextField member=new JTextField();
        member.setFont(font);
        member.setEditable(false);
        JTextField credit=new JTextField();
        credit.setFont(font);
        credit.setEditable(false);
        JTextField birthday=new JTextField();
        birthday.setFont(font);
        birthday.setEditable(false);
        JTextField companyName=new JTextField();
        companyName.setFont(font);
        companyName.setEditable(false);
        JButton button1=new JButton("编辑");
        button1.setFont(font);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name.setEditable(true);
                phone.setEditable(true);
                birthday.setEditable(true);
                companyName.setEditable(true);
            }
        });
        JButton button2=new JButton("确定");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name.setEditable(false);
                phone.setEditable(false);
                birthday.setEditable(false);
                companyName.setEditable(false);
            }
        });
        button2.setFont(font);
        panel2.add(label7);
        label7.setBounds(300,60,70,60);
        panel2.add(name);
        name.setBounds(380,60,150,60);
        panel2.add(label8);
        label8.setBounds(540,60,70,60);
        panel2.add(phone);
        phone.setBounds(620,60,150,60);
        panel2.add(label9);
        label9.setBounds(300,180,70,60);
        panel2.add(member);
        member.setBounds(380,180,150,60);
        panel2.add(label10);
        label10.setBounds(540,180,70,60);
        panel2.add(credit);
        credit.setBounds(620,180,150,60);
        panel2.add(label11);
        label11.setBounds(300,300,70,60);
        panel2.add(birthday);
        birthday.setBounds(380,300,150,60);
        panel2.add(label12);
        label12.setBounds(540,300,70,60);
        panel2.add(companyName);
        companyName.setBounds(620,300,150,60);
        panel2.add(button1);
        panel2.add(button2);
        button1.setBounds(600,500,80,40);
        button2.setBounds(720,500,80,40);

        //订单浏览界面；
        Object[][] obj1=new Object[10][5];
        Object[][] obj2=new Object[10][5];
        Object[][] obj3=new Object[10][5];
        Object[][] obj4=new Object[10][5];
        obj1[0][0]="50000";
        obj1[0][1]="2016-8-18";
        obj1[0][2]="2016-8-19";
        obj1[0][3]="南京大酒店";
        obj1[0][4]="正常";
        String[] colunName={"订单编号","预计执行日期","预计结束日期","酒店名称","订单状态"};
        DefaultTableModel dt1=new DefaultTableModel(obj1,colunName);
        DefaultTableModel dt2=new DefaultTableModel(obj2,colunName);
        DefaultTableModel dt3=new DefaultTableModel(obj3,colunName);
        DefaultTableModel dt4=new DefaultTableModel(obj4,colunName);
        JTable table1=new JTable(dt1);
        JTable table2=new JTable(dt2);
        JTable table3=new JTable(dt3);
        JTable table4=new JTable(dt4);
        JScrollPane scrollPane1=new JScrollPane(table1);
        JScrollPane scrollPane2=new JScrollPane(table2);
        JScrollPane scrollPane3=new JScrollPane(table3);
        JScrollPane scrollPane4=new JScrollPane(table4);
        JPanel panel5=new JPanel();
        JPanel panel6=new JPanel();
        JPanel panel7=new JPanel();
        JPanel panel8=new JPanel();
        JTabbedPane jtp2=new JTabbedPane(JTabbedPane.NORTH);
        panel5.add(scrollPane1);
        panel6.add(scrollPane2);
        panel7.add(scrollPane3);
        panel8.add(scrollPane4);
        table1.getTableHeader().setFont(font);
        table2.getTableHeader().setFont(font);
        table3.getTableHeader().setFont(font);
        table4.getTableHeader().setFont(font);
        table1.setPreferredScrollableViewportSize(new Dimension(750,400));
        table2.setPreferredScrollableViewportSize(new Dimension(750,400));
        table3.setPreferredScrollableViewportSize(new Dimension(750,400));
        table4.setPreferredScrollableViewportSize(new Dimension(750,400));
        table1.setRowHeight(40);
        table2.setRowHeight(40);
        table3.setRowHeight(40);
        table4.setRowHeight(40);
        jtp2.add("正常订单",panel5);
        jtp2.add("异常订单",panel6);
        jtp2.add("已撤销订单",panel7);
        jtp2.add("未执行订单",panel8);
        jtp2.setFont(font);
        table1.setFont(font);
        table2.setFont(font);
        table3.setFont(font);
        table4.setFont(font);
        panel3.setLayout(null);
        panel3.add(jtp2);
        jtp2.setBounds(0,0,1000,600);

        JButton button3=new JButton("撤销");
        panel8.add(button3);
        button3.setBounds(460,500,80,60);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (table4.getSelectedRow()==-1){
                        Tooltip_one to=new Tooltip_one();
                    }
                    else{
                        OrderController oc=new OrderController();
                        String temp=table4.getValueAt(table4.getSelectedRow()-1,1).toString();
                        oc.cancelOrder(Long.parseLong(temp));
                        dt4.removeRow(table4.getSelectedRow()-1);
                    }
                }catch (RemoteException e1){
                    e1.printStackTrace();
                }
            }
        });

        JButton button4=new JButton("评价");
        panel5.add(button4);
        button3.setBounds(460,500,80,60);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table1.getSelectedRow()==-1){
                    Tooltip_one to=new Tooltip_one();
                }
                else{
                   EvaluationUI eui=new EvaluationUI(obj1[table1.getSelectedRow()-1][3].toString(),1111);
                }
            }
        });

        UserVO uvo;
        CustomerVO cvo;
        OrderVO[] opo1=new OrderVO[10];
        OrderVO[] opo2=new OrderVO[10];
        OrderVO[] opo3=new OrderVO[10];
        OrderVO[] opo4=new OrderVO[10];
        try{
            uvo=uc.getUser(account);
            cvo=cc.getCustomer(uvo.getId());
            String[] tempId1=cvo.getOrderId1();
            String[] tempId2=cvo.getOrderId2();
            String[] tempId3=cvo.getOrderId3();
            String[] tempId4=cvo.getOrderId4();
            for(int i=0;i<10;i++){
                opo1[i]=oc.getOrder(Long.parseLong(tempId1[i]));
                obj1[i][0]=opo1[i].getId();
                obj2[i][0]=opo2[i].getId();
                obj3[i][0]=opo3[i].getId();
                obj4[i][0]=opo4[i].getId();
                obj1[i][1]=opo1[i].getStartTime();
                obj2[i][1]=opo2[i].getStartTime();
                obj3[i][1]=opo3[i].getStartTime();
                obj4[i][1]=opo4[i].getStartTime();
                obj1[i][2]=opo1[i].getEndTime();
                obj2[i][2]=opo2[i].getEndTime();
                obj3[i][2]=opo3[i].getEndTime();
                obj4[i][2]=opo4[i].getEndTime();
                obj1[i][3]=opo1[i].getHotelName();
                obj2[i][3]=opo2[i].getHotelName();
                obj3[i][3]=opo3[i].getHotelName();
                obj4[i][3]=opo4[i].getHotelName();
                obj1[i][4]=opo1[i].getOs();
                obj2[i][4]=opo2[i].getOs();
                obj3[i][4]=opo3[i].getOs();
                obj4[i][4]=opo4[i].getOs();
            }

        }catch (RemoteException e){
            e.printStackTrace();
        }


        //信用查看界面；
        Object[][] obj5=new Object[15][2];
        String[] colunName2={"时间","变化数量"};
        DefaultTableModel dt5=new DefaultTableModel(obj5,colunName2);
        JTable table5=new JTable(dt5);
        JScrollPane scrollPane5=new JScrollPane(table5);
        table5.getTableHeader().setFont(font);
        panel4.add(scrollPane5);
        table5.setFont(font);
        table5.setPreferredScrollableViewportSize(new Dimension(780,400));
        table5.setRowHeight(30);

       /* CustomerVO cvo;
        UserPO upo;
        String[][] creditRecord;
        upo=this.uc.getUser(account);
        cvo=this.cc.viewCredit(upo.getId());
        creditRecord=cvo.getCreditRecord();
        for(int i=0;i<15;i++){
            obj5[i][0]=creditRecord[creditRecord.length-i][0];
            obj5[i][1]=creditRecord[creditRecord.length-i][1];
        }*/


        frame.setFont(font);
        frame.getContentPane().add(jtp);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(1000,600);
    }
    public static void main(String[] args){
        MainUI ui=new MainUI("123456","000");
    }
}
