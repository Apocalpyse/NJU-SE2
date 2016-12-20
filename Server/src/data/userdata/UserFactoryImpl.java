package data.userdata;

import dataservice.userdataservice.UserDataService;
import dataservice.userdataservice.UserFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by 常德隆 on 2016/12/19.
 */
public class UserFactoryImpl extends UnicastRemoteObject implements UserFactory {
    public UserFactoryImpl() throws RemoteException{
        super();
    }

    @Override
    public UserDataService createUserDataService() throws RemoteException {
        return UserDataServiceSqlImpl.getInstance();
    }
}
