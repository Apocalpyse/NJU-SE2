package businesslogic.webworkerbl;

import businesslogicservice.webworkerbusinesslogicservice.WebworkerBusinessLogicService;
import dataservice.webworkerdataservice.WebworkerDataService;
import dataservice.webworkerdataservice.WebworkerDataServiceSqlImpl;
import po.WebworkerPO;
import vo.WebworkerVO;
public class WebworkerBL implements WebworkerBusinessLogicService{
    WebworkerDataServiceSqlImpl wds;
	static long countWeb=80000;

    public WebworkerVO getWebworker(long id){
        WebworkerVO vo=new WebworkerVO();
        WebworkerPO po;
        po=this.wds.find(id);
        vo.setAuthority(po.getAuthority());
        vo.setID(po.getID());
        vo.setWebworkerName(po.getWebworkerName());
        return vo;
    }
    public boolean creatWebworker(WebworkerVO vo){
        WebworkerPO po = new WebworkerPO();
        po.setAuthority(vo.getAuthority());
        countWeb++;
        po.setID(countWeb);
        po.setWebworkerName(vo.getWebworkerName());
        this.wds.insert(po);
        return true;
    }
    public boolean changeWebworker(WebworkerVO vo){
        WebworkerPO po = new WebworkerPO();
        po.setAuthority(vo.getAuthority());
        po.setID(vo.getID());
        po.setWebworkerName(vo.getWebworkerName());
        this.wds.updata(po);
        return true;
    }
}
