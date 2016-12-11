package businesslogicservice.webworkerbusinesslogicservice;

import java.rmi.RemoteException;

import vo.WebworkerVO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface WebworkerBusinessLogicService {
    public WebworkerVO getWebworker(long id)throws RemoteException ;
    public boolean creatWebworker(WebworkerVO vo)throws RemoteException ;
    public boolean changeWebworker(WebworkerVO vo)throws RemoteException ;
}
