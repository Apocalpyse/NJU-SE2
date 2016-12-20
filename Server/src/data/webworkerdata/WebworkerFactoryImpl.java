package data.webworkerdata;

import dataservice.webworkerdataservice.WebworkerDataService;
import dataservice.webworkerdataservice.WebworkerFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by 常德隆 on 2016/12/19.
 */
public class WebworkerFactoryImpl extends UnicastRemoteObject implements WebworkerFactory {
    public WebworkerFactoryImpl() throws RemoteException{
        super();
    }

    @Override
    public WebworkerDataService createWebworkerDataService() throws RemoteException {
        return WebworkerDataServiceSqlImpl.getInstance();
    }
}
