package data.roomdata;

import dataservice.roomdataservice.RoomDataService;
import dataservice.roomdataservice.RoomFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by 常德隆 on 2016/12/19.
 */
public class RoomFactoryImpl extends UnicastRemoteObject implements RoomFactory {
    public RoomFactoryImpl() throws RemoteException{
        super();
    }

    @Override
    public RoomDataService createRoomDataService() throws RemoteException {
        return RoomDataServiceSqlImpl.getInstance();
    }
}
