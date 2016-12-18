package businesslogicservice.roombusinesslogicservice;

import java.rmi.RemoteException;

import vo.RoomVO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface RoomBusinessLogicService {
    RoomVO getRoom(long roomStyle)throws RemoteException;
    boolean changeRoom(RoomVO rv)throws RemoteException;

}
