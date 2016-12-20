package dataservice.roomdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by 常德隆 on 2016/12/19.
 */
public interface RoomFactory extends Remote {
    RoomDataService createRoomDataService() throws RemoteException;
}
