package presentation.customerui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 常德隆 on 2016/12/11.
 */
public class Tooltip_two {
    public Tooltip_two(){
        JFrame frame=new JFrame("成功");
        JLabel label=new JLabel("成功添加评价，谢谢！");
        JButton button=new JButton("确定");
        Font font=new Font("微软雅黑",Font.BOLD,16);

        frame.getContentPane().add(label);
        frame.getContentPane().add(button);
        frame.setLayout(null);
        label.setBounds(80,40,240,60);
        button.setBounds(160,140,80,60);
        label.setFont(font);
        button.setFont(font);
        frame.setFont(font);
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
