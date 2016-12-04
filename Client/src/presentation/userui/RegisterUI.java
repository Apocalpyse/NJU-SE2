package presentation.userui;

import businesslogic.userbl.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 常德隆 on 2016/11/29.
 */
public class RegisterUI {
    public RegisterUI(){
        JFrame frame=new JFrame("注册");
        Font font=new Font("微软雅黑",Font.BOLD,16);
        frame.setFont(font);
        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        JLabel label1=new JLabel("账户");
        label1.setFont(font);
        JLabel label2=new JLabel("密码");
        label2.setFont(font);
        JLabel label3=new JLabel("确认密码");
        label3.setFont(font);
        JTextField textField1=new JTextField();
        textField1.setFont(font);
        JTextField textField2=new JTextField();
        textField2.setFont(font);
        JTextField textField3=new JTextField();
        textField3.setFont(font);
        JButton button1=new JButton("确定");
        button1.setFont(font);
        JButton button2=new JButton("返回");
        button2.setFont(font);

        panel1.add(textField1);
        panel1.add(textField2);
        panel1.add(textField3);
        panel1.add(label1);
        panel1.add(label2);
        panel1.add(label3);
        label1.setBounds(100,0,60,55);
        textField1.setBounds(160,0,700,55);
        label2.setBounds(100,65,60,55);
        textField2.setBounds(160,65,700,55);
        label3.setBounds(60,130,100,55);
        textField3.setBounds(160,130,660,55);
        panel1.setLayout(null);
        panel2.add(button1);
        panel2.add(button2);
        panel2.setLayout(null);
        button1.setBounds(0,0,80,40);
        button2.setBounds(120,0,80,40);
        frame.setLayout(null);
        frame.getContentPane().add(panel1);
        frame.getContentPane().add(panel2);
        panel1.setBounds(100,100,800,320);
        panel2.setBounds(400,440,200,40);
        frame.setVisible(true);
        frame.setSize(1000,600);
        textField1.setEditable(true);
        textField2.setEditable(true);
        textField3.setEditable(true);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField2.getText()==textField3.getText()){
                    UserController uc=new UserController();
                    if(uc.register(textField1.getText(),textField2.getText())){
                        Tooltip_two tt=new Tooltip_two();
                        frame.dispose();
                    }
                    else{
                        Tooltip_three tt=new Tooltip_three();
                    }
                }
                else{
                         Tooltip_four tf=new Tooltip_four();
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                LoginUI ui=new LoginUI();
            }
        });
    }
    //public static void main(String[] args){
    //    RegisterUI rui=new RegisterUI();
    //}
}
