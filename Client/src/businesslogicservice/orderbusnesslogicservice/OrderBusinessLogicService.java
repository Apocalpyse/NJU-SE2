package businesslogicservice.orderbusnesslogicservice;

import vo.OrderVO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface OrderBusinessLogicService {
    public boolean createOrder(OrderVO vo);
    public OrderVO getOrder(long id);
    public double cancelOrder(long id);
    public double completeOrder(long id);
    public double recoverOrder(long id);
}
