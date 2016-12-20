package dataservice.promotiondataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by 常德隆 on 2016/12/19.
 */
public interface PromotionFactory extends Remote {
    PromotionDataService createPromotionDataService() throws RemoteException;
}
