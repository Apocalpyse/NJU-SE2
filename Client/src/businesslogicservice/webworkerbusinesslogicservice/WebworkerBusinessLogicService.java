package businesslogicservice.webworkerbusinesslogicservice;

import vo.WebworkerVO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface WebworkerBusinessLogicService {
    public WebworkerVO getWebworker(long id);
    public boolean creatWebworker(WebworkerVO vo);
    public boolean changeWebworker(WebworkerVO vo);
}
