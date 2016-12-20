package data.hoteldata;

import dataservice.hoteldataservice.HotelDataService;
import dataservice.hoteldataservice.HotelFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by 常德隆 on 2016/12/19.
 */
public class HotelFactoryImpl extends UnicastRemoteObject implements HotelFactory {
    public HotelFactoryImpl() throws RemoteException{
      super();
    }

    @Override
    public HotelDataService createHotelDataService() throws RemoteException {
        return HotelDataServiceSqlImpl.getInstance();
    }
}
