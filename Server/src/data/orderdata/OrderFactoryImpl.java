package data.orderdata;

import dataservice.orderdataservice.OrderDataService;
import dataservice.orderdataservice.OrderFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by 常德隆 on 2016/12/19.
 */
public class OrderFactoryImpl extends UnicastRemoteObject implements OrderFactory {
    public OrderFactoryImpl() throws RemoteException{
        super();
    }

    @Override
    public OrderDataService createOrderDataService() throws RemoteException {
        return OrderDataServiceSqlImpl.getInstance();
    }
}
