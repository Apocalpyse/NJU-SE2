package presentation.userui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 常德隆 on 2016/12/2.
 */
public class Tooltip_two {
    public Tooltip_two(){
        JFrame frame=new JFrame();
        Font font=new Font("微软雅黑",Font.BOLD,16);
        JLabel label=new JLabel("注册成功");
        JButton button1=new JButton("去登录");
        JButton button2=new JButton("取消");

        frame.setLayout(null);
        frame.getContentPane().add(label);
        frame.getContentPane().add(button1);
        frame.getContentPane().add(button2);
        frame.setFont(font);
        label.setFont(font);
        button1.setFont(font);
        button2.setFont(font);
        label.setBounds(160,40,80,40);
        button1.setBounds(120,120,80,40);
        button2.setBounds(200,120,80,40);
        frame.setVisible(true);
        frame.setSize(400,240);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginUI ui=new LoginUI();
                frame.dispose();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
}
