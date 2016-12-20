package presentation.orderui;

import businesslogic.orderbl.OrderBL;
import businesslogic.orderbl.OrderController;
import vo.OrderVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.rmi.RemoteException;

/**
 * Created by 常德隆 on 2016/11/29.
 */
public class OrderUI {

    OrderController oc;

    public OrderUI(boolean is,long hotelId){
        JFrame frame=new JFrame("订单");
        Font font=new Font("微软雅黑",Font.BOLD,16);
        frame.setFont(font);
        JPanel panel=new JPanel();
        JTextField customerName=new JTextField();
        customerName.setFont(font);
        JTextField customerPhone=new JTextField();
        customerPhone.setFont(font);
        JTextField hotelName=new JTextField();
        hotelName.setFont(font);
        JTextField hotelPhone=new JTextField();
        hotelPhone.setFont(font);
        JTextField hotelLocation=new JTextField();
        hotelLocation.setFont(font);
        JComboBox roomType=new JComboBox();
        roomType.setFont(font);
        JTextField roomPrice=new JTextField();
        roomPrice.setFont(font);
        JTextField roomNumber=new JTextField();
        roomNumber.setFont(font);
        JTextField discount=new JTextField();
        discount.setFont(font);
        JTextField startTime=new JTextField();
        startTime.setFont(font);
        JTextField endTime=new JTextField();
        endTime.setFont(font);
        JTextField totalPrice=new JTextField();
        totalPrice.setFont(font);
        JComboBox isExistChild=new JComboBox();
        isExistChild.setFont(font);
        JTextField customerNumber=new JTextField();
        customerNumber.setFont(font);
        JLabel CustomerName=new JLabel("客户姓名");
        CustomerName.setFont(font);
        JLabel CustomerPhone=new JLabel("客户电话");
        CustomerPhone.setFont(font);
        JLabel HotelName=new JLabel("酒店名称");
        HotelName.setFont(font);
        JLabel HotelPhone=new JLabel("酒店电话");
        HotelPhone.setFont(font);
        JLabel HotelLocation=new JLabel("酒店地址");
        HotelLocation.setFont(font);
        JLabel RoomType=new JLabel("房间类型");
        RoomType.setFont(font);
        JLabel RoomPrice=new JLabel("房间单价");
        RoomPrice.setFont(font);
        JLabel RoomNumber=new JLabel("房间数量");
        RoomNumber.setFont(font);
        JLabel Discount=new JLabel("折扣");
        Discount.setFont(font);
        JLabel StartTime=new JLabel("入住时间");
        StartTime.setFont(font);
        JLabel EndTime=new JLabel("截至时间");
        EndTime.setFont(font);
        JLabel TotalPrice=new JLabel("总价");
        TotalPrice.setFont(font);
        JLabel IsExistChild=new JLabel("是否有儿童");
        IsExistChild.setFont(font);
        JLabel CustomerNumber=new JLabel("预计客户总人数");
        CustomerNumber.setFont(font);
        JButton button1=new JButton("确定");
        button1.setFont(font);
        JButton button2=new JButton("取消");
        button2.setFont(font);
        JLabel OrderState=new JLabel("订单状态");
        OrderState.setFont(font);
        OrderState.setVisible(is);
        JComboBox orderState=new JComboBox();
        orderState.setFont(font);
        orderState.setVisible(is);

        panel.add(customerName);
        panel.add(customerPhone);
        panel.add(hotelName);
        panel.add(hotelPhone);
        panel.add(hotelLocation);
        panel.add(roomType);
        panel.add(roomPrice);
        panel.add(roomNumber);
        panel.add(discount);
        panel.add(startTime);
        panel.add(endTime);
        panel.add(totalPrice);
        panel.add(isExistChild);
        panel.add(customerNumber);
        panel.add(CustomerName);
        panel.add(CustomerPhone);
        panel.add(HotelName);
        panel.add(HotelPhone);
        panel.add(HotelLocation);
        panel.add(RoomType);
        panel.add(RoomPrice);
        panel.add(RoomNumber);
        panel.add(Discount);
        panel.add(StartTime);
        panel.add(EndTime);
        panel.add(TotalPrice);
        panel.add(IsExistChild);
        panel.add(CustomerNumber);
        panel.add(button1);
        panel.add(button2);
        panel.add(orderState);
        panel.add(OrderState);
        panel.setLayout(null);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.setSize(900,1000);
        CustomerName.setBounds(100,60,100,60);
        customerName.setBounds(200,60,240,60);
        CustomerPhone.setBounds(450,60,100,60);
        customerPhone.setBounds(550,60,240,60);
        HotelName.setBounds(100,150,100,60);
        hotelName.setBounds(200,150,240,60);
        HotelPhone.setBounds(450,150,100,60);
        hotelPhone.setBounds(550,150,240,60);
        HotelLocation.setBounds(100,240,100,60);
        hotelLocation.setBounds(200,240,240,60);
        RoomType.setBounds(450,240,100,60);
        roomType.setBounds(550,240,240,60);
        RoomPrice.setBounds(100,330,100,60);
        roomPrice.setBounds(200,330,240,60);
        RoomNumber.setBounds(450,330,100,60);
        roomNumber.setBounds(550,330,240,60);
        Discount.setBounds(100,420,100,60);
        discount.setBounds(200,420,240,60);
        StartTime.setBounds(450,420,100,60);
        startTime.setBounds(550,420,240,60);
        EndTime.setBounds(100,510,100,60);
        endTime.setBounds(200,510,240,60);
        TotalPrice.setBounds(450,510,100,60);
        totalPrice.setBounds(550,510,240,60);
        IsExistChild.setBounds(100,600,100,60);
        isExistChild.setBounds(200,600,240,60);
        CustomerNumber.setBounds(450,600,100,60);
        customerNumber.setBounds(550,600,240,60);
        OrderState.setBounds(100,690,100,60);
        orderState.setBounds(200,690,240,60);
        button1.setBounds(350,840,80,40);
        button2.setBounds(470,840,80,40);

        roomType.addItem("标准间");
        roomType.addItem("双人间");
        roomType.addItem("三人间");
        isExistChild.addItem("是");
        isExistChild.addItem("否");
        orderState.addItem("正常");
        orderState.addItem("异常");
        orderState.addItem("已撤销");
        orderState.addItem("未执行");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    OrderController oc=new OrderController();
                    OrderVO ovo=new OrderVO();
                    boolean isexistchild;
                    if(isExistChild.getSelectedItem().toString()=="是"){
                        isexistchild=true;
                    }
                    else {
                        isexistchild=false;
                    }
                    ovo.setCustomerName(customerName.getText());
                    ovo.setCustomerPhone(customerPhone.getText());
                    ovo.setHotelName(hotelName.getText());
                    ovo.setHotelPhone(hotelPhone.getText());
                    ovo.setHotelLocation(hotelLocation.getText());
                    ovo.setRoomType(roomType.getSelectedItem().toString());
                    ovo.setRoomNumber(Integer.parseInt(roomNumber.getText()));
                    ovo.setRoomPrice(Double.parseDouble(roomPrice.getText()));
                    ovo.setStartTime(startTime.getText());
                    ovo.setEndTime(endTime.getText());
                    ovo.setDiscount(Double.parseDouble(discount.getText()));
                    ovo.setIsExistChild(isexistchild);
                    ovo.setTotalPrice(Double.parseDouble(totalPrice.getText()));
                    ovo.setCustomerNumber(Integer.parseInt(customerNumber.getText()));
                    oc.createOrder(ovo,hotelId);
                    if(oc.createOrder(ovo,hotelId)){
                        Tooltip_one to=new Tooltip_one();
                        frame.dispose();
                    }
                    else{
                        Tooltip_two tt=new Tooltip_two();
                    }
                }catch (RemoteException e1){
                    e1.printStackTrace();
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
}
