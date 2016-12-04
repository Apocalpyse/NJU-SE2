package presentation.userui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 常德隆 on 2016/11/30.
 */
public class Tooltip_one {
    public Tooltip_one(){
        JFrame frame=new JFrame("错误");
        Font font=new Font("微软雅黑",Font.BOLD,16);
        JButton button=new JButton("返回");
        JLabel label=new JLabel("帐号或密码错误");
        JPanel panel=new JPanel();

        panel.setLayout(null);
        panel.add(label);
        panel.add(button);
        frame.setFont(font);
        label.setFont(font);
        button.setFont(font);
        label.setBounds(150,20,100,50);
        button.setBounds(160,120,80,40);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.setSize(400,240);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
}
