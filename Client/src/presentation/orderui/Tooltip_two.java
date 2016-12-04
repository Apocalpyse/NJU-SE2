package presentation.orderui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public class Tooltip_two {
    public Tooltip_two(){
        JFrame frame=new JFrame("错误");
        Font font=new Font("微软雅黑",Font.BOLD,16);
        JLabel label=new JLabel("订单信息不完整");
        JButton button=new JButton("返回");

        frame.getContentPane().add(label);
        frame.getContentPane().add(button);
        frame.setLayout(null);
        frame.setFont(font);
        label.setFont(font);
        button.setFont(font);
        label.setBounds(100,60,200,60);
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
