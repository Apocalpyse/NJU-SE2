package presentation.customerui;

import businesslogic.customerbl.CustomerController;
import businesslogic.hotelbl.HotelController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by 常德隆 on 2016/12/11.
 */
public class EvaluationUI {
    public EvaluationUI(String hotelName,long hotelId){
        JFrame frame=new JFrame("评价");
        JPanel panel=new JPanel();
        JLabel label=new JLabel(hotelName);
        JComboBox star=new JComboBox();
        JTextArea evaluation=new JTextArea("在此处添加评论");
        JButton button=new JButton("确定");
        Font font=new Font("微软雅黑",Font.BOLD,16);

        frame.getContentPane().add(panel);
        frame.setFont(font);
        panel.setLayout(null);
        panel.add(label);
        panel.add(star);
        panel.add(evaluation);
        panel.add(button);
        label.setBounds(100,60,400,40);
        label.setFont(font);
        star.setBounds(100,120,80,40);
        star.setFont(font);
        evaluation.setBounds(100,180,400,120);
        evaluation.setFont(font);
        button.setBounds(260,320,80,40);
        button.setFont(font);

        star.addItem("一分");
        star.addItem("两分");
        star.addItem("三分");
        star.addItem("四分");
        star.addItem("五分");
        frame.setSize(600,380);
        frame.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList Evaluation=new ArrayList();
                    Evaluation.add(evaluation.getText());
                    HotelController hc=new HotelController();
                    hc.addEvaluation(hotelId,Evaluation);
                    Tooltip_two tt=new Tooltip_two();
                }
                catch (RemoteException e1){
                    e1.printStackTrace();
                }
            }
        });
    }
}
