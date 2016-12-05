package presentation.customerui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public class SearchResultUI {
    public SearchResultUI(){
        Font font=new Font("微软雅黑",Font.BOLD,16);
        JFrame frame=new JFrame("搜索结果");
        JPanel panel=new JPanel();
        Object[][] obj=new Object[10][5];
        String[] colunName={"酒店名称","联系电话","酒店地址","人均价格","星级"};
        DefaultTableModel dt=new DefaultTableModel(obj,colunName);
        JTable table=new JTable(dt);
        JScrollPane scrollPane=new JScrollPane(table);

        panel.add(scrollPane);
        panel.setFont(font);
        table.setPreferredScrollableViewportSize(new Dimension(800,400));
        table.setFont(font);
        table.setRowHeight(40);

        frame.getContentPane().add(panel);
        frame.setSize(1000,600);
        frame.setVisible(true);
    }
}
