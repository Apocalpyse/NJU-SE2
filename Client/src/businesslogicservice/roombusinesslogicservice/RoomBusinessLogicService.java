package businesslogicservice.roombusinesslogicservice;

import vo.RoomVO;

/**
 * Created by 常德隆 on 2016/12/4.
 */
public interface RoomBusinessLogicService {
    public RoomVO getRoom(String roomStyle);
    public boolean changeRoom(RoomVO rv);

}
