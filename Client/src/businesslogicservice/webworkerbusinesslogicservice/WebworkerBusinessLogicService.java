package businesslogicservice.webworkerbusinesslogicservice;

import java.rmi.RemoteException;

import vo.WebworkerVO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface WebworkerBusinessLogicService {
     WebworkerVO getWebworker(long id)throws RemoteException ;
     boolean creatWebworker(WebworkerVO vo)throws RemoteException ;
     boolean changeWebworker(WebworkerVO vo)throws RemoteException ;
     long findMaxId()throws RemoteException;
}
