package presentation.customerui;

import businesslogic.customerbl.CustomerController;
import businesslogic.hotelbl.HotelBL;
import businesslogic.hotelbl.HotelController;
import dataservice.hoteldataservice.HotelDataServiceSqlImpl;
import po.HotelPO;
import vo.HotelVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public class SearchResultUI {

    HotelDataServiceSqlImpl hds;

    public SearchResultUI(HotelVO vo){
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
        table.getTableHeader().setFont(font);
        table.setRowHeight(40);

        HotelVO[] hvo=new HotelVO[10];

        CustomerController cc=new CustomerController();
        hvo=cc.searchHotel(vo);
        obj[0][0]=hvo[hvo.length-1].getHotelName();
        obj[0][1]=hvo[hvo.length-1].getHotelPhone();
        obj[0][2]=hvo[hvo.length-1].getHotelLocation();
        obj[0][4]=hvo[hvo.length-1].getStars();


        frame.getContentPane().add(panel);
        frame.setSize(1000,600);
        frame.setVisible(true);
    }
}
