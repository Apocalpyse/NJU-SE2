package presentation.customerui;

import businesslogic.customerbl.CustomerController;
import businesslogic.hotelbl.HotelBL;
import businesslogic.hotelbl.HotelController;
import businesslogic.roombl.RoomController;
import dataservice.hoteldataservice.HotelDataService;
import po.HotelPO;
import vo.HotelVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.rmi.RemoteException;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public class SearchResultUI {

    HotelDataService hds;

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

        HotelVO hvo;
        try{
            CustomerController cc=new CustomerController();
            RoomController rc=new RoomController();
            hvo=cc.searchHotel(vo);
            for(int i=0;i<10;i++) {
                long[] roomId = new long[6];
                roomId[0] = hvo.getID() * 10 + 1;
                roomId[1] = hvo.getID() * 10 + 2;
                roomId[2] = hvo.getID() * 10 + 3;
                roomId[3] = hvo.getID() * 10 + 4;
                roomId[4] = hvo.getID() * 10 + 5;
                roomId[5] = hvo.getID() * 10 + 6;
                obj[i][0] = hvo.getHotelName();
                obj[i][1] = hvo.getHotelPhone();
                obj[i][2] = hvo.getHotelLocation();
                obj[i][3] = (rc.getRoom(roomId[0]).getRoomPrice() + rc.getRoom(roomId[1]).getRoomPrice() + rc.getRoom(roomId[2]).getRoomPrice() +
                        rc.getRoom(roomId[3]).getRoomPrice() + rc.getRoom(roomId[4]).getRoomPrice() + rc.getRoom(roomId[5]).getRoomPrice()) / 6;
                obj[i][4] = hvo.getStars();
            }
        }catch (RemoteException e){
            e.printStackTrace();
        }


        frame.getContentPane().add(panel);
        frame.setSize(1000,600);
        frame.setVisible(true);
    }
}
