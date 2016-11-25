package businesslogic.webworkerbl;

import dataservice.webworkerdataservice.WebworkerDataService;
import po.WebworkerPO;
import vo.WebworkerVO;
public class WebworkerBL {
    public WebworkerVO getWebworker(long id){
        WebworkerVO vo=new WebworkerVO();
        WebworkerDataService wds=new WebworkerDataService();
        WebworkerPO po;
        po=wds.get(id);
        vo.setAuthority(po.getAuthority());
        vo.setID(po.getID());
        vo.setPassword(po.getPassword());
        vo.setWebworkerName(po.getWebworkerName());
        return vo;
    }
    public boolean creatWebworker(WebworkerVO vo){
    	WebworkerDataService wds=new WebworkerDataService();
        WebworkerPO po = new WebworkerPO();
        po.setAuthority(vo.getAuthority());
        po.setID(vo.getID());
        po.setPassword(vo.getPassword());
        po.setWebworkerName(vo.getWebworkerName());
        return wds.creat(po);
    }
    public boolean changeWebworker(WebworkerVO vo){
    	WebworkerDataService wds=new WebworkerDataService();
        WebworkerPO po = new WebworkerPO();
        po.setAuthority(vo.getAuthority());
        po.setID(vo.getID());
        po.setPassword(vo.getPassword());
        po.setWebworkerName(vo.getWebworkerName());
        return wds.change(po);
    }
}
