package presentation.customerui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by 常德隆 on 2016/12/11.
 */
public class Tooltip_one {
    public  Tooltip_one() {
        JFrame frame = new JFrame("错误");
        JLabel label = new JLabel("没有选择订单");
        JButton button = new JButton("确定");
        Font  font=new Font("微软雅黑",Font.BOLD,16);

        frame.setLayout(null);
        frame.getContentPane().add(label);
        frame.getContentPane().add(button);
        frame.setFont(font);
        label.setBounds(80,40,240,60);
        label.setFont(font);
        button.setBounds(160,140,80,60);
        button.setFont(font);
        frame.setSize(400,240);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
}
