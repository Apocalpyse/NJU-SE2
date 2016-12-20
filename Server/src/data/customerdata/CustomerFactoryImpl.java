package data.customerdata;

import dataservice.customerdataservice.CustomerDataService;
import dataservice.customerdataservice.CustomerFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by 常德隆 on 2016/12/19.
 */
public class CustomerFactoryImpl extends UnicastRemoteObject implements CustomerFactory {
    public CustomerFactoryImpl() throws RemoteException{
        super();
    }

    @Override
    public CustomerDataService createCustomerDataService() throws RemoteException {
        return CustomerDataServiceSqlImpl.getInstance();
    }
}
