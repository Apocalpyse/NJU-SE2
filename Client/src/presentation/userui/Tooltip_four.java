package presentation.userui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 常德隆 on 2016/12/2.
 */
public class Tooltip_four {
    public Tooltip_four(){
        JFrame frame=new JFrame("错误");
        Font font=new Font("微软雅黑",Font.BOLD,16);
        JLabel label=new JLabel("两次输入的密码不一致");
        JButton button=new JButton("返回");

        frame.setFont(font);
        frame.getContentPane().add(label);
        frame.getContentPane().add(button);
        frame.setLayout(null);
        label.setFont(font);
        label.setBounds(100,60,200,60);
        button.setFont(font);
        button.setBounds(160,120,80,40);
        frame.setSize(400,240);
        frame.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
}
