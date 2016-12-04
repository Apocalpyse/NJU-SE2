package businesslogicservice.userbusinesslogicservice;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface UserBusinessLogicService {
    public boolean login(String account,String password);
    public boolean register(String account,String password);
}
