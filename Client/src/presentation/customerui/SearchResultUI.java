package presentation.customerui;

import businesslogic.customerbl.CustomerController;
import businesslogic.hotelbl.HotelBL;
import businesslogic.hotelbl.HotelController;
import dataservice.hoteldataservice.HotelDataServiceSqlImpl;
import po.HotelPO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public class SearchResultUI {

    HotelDataServiceSqlImpl hds;

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
        table.getTableHeader().setFont(font);
        table.setRowHeight(40);

        //HotelPO[] hpo=new HotelPO[10];
        //CustomerController cc=new CustomerController();
        //hpo=cc.searchHotel();

        //for(int i=0;i<15;i++){
        //  obj[i][0]=creditRecord[creditRecord.length-i][0];
        //  obj[i][1]=creditRecord[creditRecord.length-i][1];
        //  obj[i][2]=creditRecord[creditRecord.length-i][2];
        //}

        frame.getContentPane().add(panel);
        frame.setSize(1000,600);
        frame.setVisible(true);
    }
}
