package data.promotiondata;

import dataservice.promotiondataservice.PromotionDataService;
import dataservice.promotiondataservice.PromotionFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by 常德隆 on 2016/12/19.
 */
public class PromotionFactoryImpl extends UnicastRemoteObject implements PromotionFactory {
    public PromotionFactoryImpl() throws RemoteException{
        super();
    }

    @Override
    public PromotionDataService createPromotionDataService() throws RemoteException {
        return PromotionDataServiceSqlImpl.getInstance();
    }
}
