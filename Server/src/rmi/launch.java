package rmi;

import data.customerdata.CustomerFactoryImpl;
import data.hoteldata.HotelFactoryImpl;
import data.orderdata.OrderFactoryImpl;
import data.promotiondata.PromotionFactoryImpl;
import data.roomdata.RoomFactoryImpl;
import data.userdata.UserFactoryImpl;
import data.webworkerdata.WebworkerFactoryImpl;
import dataservice.customerdataservice.CustomerFactory;
import dataservice.hoteldataservice.HotelFactory;
import dataservice.orderdataservice.OrderFactory;
import dataservice.promotiondataservice.PromotionFactory;
import dataservice.roomdataservice.RoomFactory;
import dataservice.userdataservice.UserFactory;
import dataservice.webworkerdataservice.WebworkerFactory;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by 常德隆 on 2016/12/20.
 */
public class launch {
    public static void main(String[] args) throws RemoteException{
        try{
            CustomerFactory customerFactory = new CustomerFactoryImpl() ;
            HotelFactory hotelFactory= new HotelFactoryImpl();
            OrderFactory orderFactory = new OrderFactoryImpl();
            PromotionFactory promotionFactory = new PromotionFactoryImpl();
            RoomFactory roomFactory = new RoomFactoryImpl();
            UserFactory userFactory = new UserFactoryImpl();
            WebworkerFactory webworkerFactory=new WebworkerFactoryImpl();

            LocateRegistry.createRegistry(12312);

            Naming.rebind("rmi://127.0.0.1:1234/customerFactory", customerFactory);
            System.out.println("服务器注册了customer工厂");

            Naming.rebind("rmi://127.0.0.1:1234/hotelFactory", hotelFactory);
            System.out.println("服务器注册了hotel工厂");

            Naming.rebind("rmi://127.0.0.1:1234/orderFactory", orderFactory);
            System.out.println("服务器注册了orderFactory工厂");

            Naming.rebind("rmi://127.0.0.1:1234/promotionFactory", promotionFactory);
            System.out.println("服务器注册了promotionFactory工厂");

            Naming.rebind("rmi://127.0.0.1:1234/userFactory", userFactory);
            System.out.println("服务器注册了userFactory工厂");

            Naming.rebind("rmi://127.0.0.1:1234/webworkerFactory", webworkerFactory);
            System.out.println("服务器注册了webworkerFactory工厂");


            System.out.println("Service Start");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
