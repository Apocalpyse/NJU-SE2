package dataservice.customerdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by 常德隆 on 2016/12/19.
 */
public interface CustomerFactory extends Remote {
     CustomerDataService createCustomerDataService() throws RemoteException;
}
