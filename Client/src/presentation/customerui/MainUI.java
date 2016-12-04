package presentation.customerui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 常德隆 on 2016/11/29.
 */
public class MainUI {
    public MainUI(){
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
        city.setBounds(500,100,150,60);
        label6.setBounds(660,100,30,60);
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
        label7.setBounds(400,60,50,60);
        name.setBounds(460,60,150,60);
        label8.setBounds(620,60,50,60);
        phone.setBounds(680,60,150,60);
        label9.setBounds(400,180,50,60);
        member.setBounds(460,180,150,60);
        label10.setBounds(620,180,50,60);
        credit.setBounds(680,180,150,60);


        //订单浏览界面；


        //信用查看界面；


        frame.setFont(font);
        frame.getContentPane().add(jtp);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(1000,600);
    }
    public static void main(String[] args){
        MainUI ui=new MainUI();
    }
}
