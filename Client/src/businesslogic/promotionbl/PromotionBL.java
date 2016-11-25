package businesslogic.promotionbl;

import java.text.SimpleDateFormat;
import java.util.Date;

import businesslogic.customerbl.CustomerController;
import dataservice.customerdataservice.CustomerDataService;
import dataservice.promotiondataservice.PromotionDataService;
import po.*;
import vo.*;

public class PromotionBL {
	static long countMemberID=50000;
	static long countHotelID=60000;
	static long countWebID=70000;

	public double getDiscount(long id, int[] room, double[] price) {
		double lowestDiscount = 1;
		double memberDiscount = 1;
		double roomDiscount = 1;
		double amountDiscount = 1;
		double birthDiscount=1;
		String birth;
		double amount = 0;
		int rooms = 0;
		CustomerDataService cds=new CustomerDataService();
		CustomerPO cppo=cds.find(id);
		HotelPromotionPO hppo = new HotelPromotionPO();
		MemberPromotionPO mppo = new MemberPromotionPO();
		WebPromotionPO wppo=new WebPromotionPO();
		double level[] = mppo.getCredit();
		double discount[] = mppo.getDiscountForMember();
		double credit = cppo.getCredit();
		for (int i = 0; i < level.length; i++) {
			if (credit < level[i]) {
				memberDiscount = discount[i];
				break;
			}
		}
		// 1
		for (int i = 0; i < room.length; i++) {
			rooms = rooms + room[i];
		}
		int discountForMoreRoom[] = hppo.getDiscountForMoreRoom();// 更多房间折扣
		double discountformoreroom[] = hppo.getDiscountformoreroom();// 对应房间数目折扣
		for (int i = 0; i < discountForMoreRoom.length; i++) {
			if (rooms < discountForMoreRoom[i]) {
				roomDiscount = discountformoreroom[i];
			}
		}
		// 2
		for (int i = 0; i < room.length; i++) {
			amount = amount + room[i] * price[i];
		}
		double discountForLargerAmount[] = hppo.getDiscountForLargerAmount();// 更高金额折扣
		double discountforlargeramount[] = hppo.getDiscountforlargeramount();// 对应金额折扣
		for (int i = 0; i < discountForLargerAmount.length; i++) {
			if (amount < discountForLargerAmount[i]) {
				amountDiscount = discountforlargeramount[i];
			}
		}
		// 3
		birth = cppo.getBirthday();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date;
		Date now = new Date();
		date = dateFormat.format(now);
		String[] dates = date.split(" ");
		if (birth.equals(dates[0])) {
			birthDiscount=hppo.getBirthDiscount();
		}
		if(lowestDiscount>memberDiscount){
			lowestDiscount=memberDiscount;
		}
		if(lowestDiscount>roomDiscount){
			lowestDiscount=roomDiscount;
		}
		if(lowestDiscount>amountDiscount){
			lowestDiscount=amountDiscount;
		}
		if(lowestDiscount>birthDiscount){
			lowestDiscount=birthDiscount;
		}
		if(lowestDiscount>wppo.getDiscount()){
			lowestDiscount=wppo.getDiscount();
		}
		return lowestDiscount;
	}

	// 其中，MemberPromotion部分对会员折扣与HotelPromotion的多房间折扣或消费金额折扣或生日折扣以及WebPromotion折扣
	//***限制：需根据数据库的构建来获取对应的促销策略
	public MemberPromotionVO getMemberPromotion(long id) {
		MemberPromotionVO vo = new MemberPromotionVO();
		PromotionDataService pds = new PromotionDataService();
		MemberPromotionPO po;
		po = pds.getMemberPromotion(id);
		// 获取PO

		vo.setCreatedTime(po.getCreatedTime());
		vo.setID(po.getID());
		vo.setPromotionName(po.getPromotionName());
		vo.setUsageState(po.getUsageState());
		vo.setCredit(po.getCredit());
		vo.setDiscountForMember(po.getDiscountForMember());
		return vo;
	}

	public boolean creatMemberPromotion(MemberPromotionVO vo) {
		PromotionDataService pds = new PromotionDataService();
		MemberPromotionPO po = new MemberPromotionPO();

		countMemberID++;// ID计数器
		po.setID(countMemberID);// 自动生成ID

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date;
		Date now = new Date();
		date = dateFormat.format(now);
		// 获得当前时间
		po.setCreatedTime(date);
		// 设置为系统时间

		po.setUsageState(UsageState.Unused);

		po.setPromotionName(vo.getPromotionName());
		po.setCredit(vo.getCredit());
		po.setDiscountForMember(vo.getDiscountForMember());
		return pds.creat(po);
	}

	public boolean changeMemberPromotion(MemberPromotionVO vo) {
		PromotionDataService pds = new PromotionDataService();
		MemberPromotionPO po = new MemberPromotionPO();
		po.setID(vo.getID());
		po.setCreatedTime(vo.getCreatedTime());// 改为获取系统时间
		po.setPromotionName(vo.getPromotionName());
		po.setUsageState(vo.getUsageState());
		po.setCredit(vo.getCredit());
		po.setDiscountForMember(vo.getDiscountForMember());
		return pds.change(po);
	}
	// MemberPromotionBL

	public HotelPromotionVO getHotelPromotion(long id) {
		HotelPromotionVO vo = new HotelPromotionVO();
		PromotionDataService pds = new PromotionDataService();
		HotelPromotionPO po;
		po = pds.getHotelPromotion(id);
		// 获取PO
		vo.setBeginTime(po.getBeginTime());
		vo.setCreatedTime(po.getCreatedTime());
		vo.setDiscount(po.getDiscount());
		vo.setDiscountForLargerAmount(po.getDiscountForLargerAmount());
		vo.setDiscountforlargeramount(po.getDiscountforlargeramount());
		vo.setDiscountForMoreRoom(po.getDiscountForMoreRoom());
		vo.setDiscountformoreroom(po.getDiscountformoreroom());
		vo.setEndTime(po.getEndTime());
		vo.setID(po.getID());
		vo.setMemberType(po.getMemberType());
		vo.setPromotionName(vo.getPromotionName());
		vo.setUsageState(po.getUsageState());
		vo.setBirthDiscount(po.getBirthDiscount());
		return vo;
	}

	public boolean creatHotelPromotion(HotelPromotionVO vo) {
		PromotionDataService pds = new PromotionDataService();
		HotelPromotionPO po = new HotelPromotionPO();

		countHotelID++;// ID计数器
		po.setID(countHotelID);// 自动生成ID

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date;
		Date now = new Date();
		date = dateFormat.format(now);
		// 获得当前时间
		po.setCreatedTime(date);
		// 设置为系统时间

		po.setUsageState(UsageState.Unused);

		po.setBeginTime(vo.getBeginTime());
		po.setEndTime(vo.getEndTime());
		po.setDiscount(vo.getDiscount());
		po.setDiscountForLargerAmount(vo.getDiscountForLargerAmount());
		po.setDiscountforlargeramount(vo.getDiscountforlargeramount());
		po.setDiscountForMoreRoom(vo.getDiscountForMoreRoom());
		po.setDiscountformoreroom(vo.getDiscountformoreroom());
		po.setMemberType(vo.getMemberType());
		po.setPromotionName(vo.getPromotionName());
		po.setBirthDiscount(vo.getBirthDiscount());
		return pds.creat(po);
	}

	public boolean changeHotelPromotion(HotelPromotionVO vo) {
		PromotionDataService pds = new PromotionDataService();
		HotelPromotionPO po = new HotelPromotionPO();
		po.setID(vo.getID());
		po.setCreatedTime(vo.getCreatedTime());
		po.setUsageState(UsageState.Unused);// 更改自动设为未应用中
		po.setBeginTime(vo.getBeginTime());
		po.setEndTime(vo.getEndTime());
		po.setDiscount(vo.getDiscount());
		po.setDiscountForLargerAmount(vo.getDiscountForLargerAmount());
		po.setDiscountforlargeramount(vo.getDiscountforlargeramount());
		po.setDiscountForMoreRoom(vo.getDiscountForMoreRoom());
		po.setDiscountformoreroom(vo.getDiscountformoreroom());
		po.setMemberType(vo.getMemberType());
		po.setPromotionName(vo.getPromotionName());
		po.setBirthDiscount(vo.getBirthDiscount());
		return pds.change(po);
	}
	// HotelPromotionBL

	public WebPromotionVO getWebPromotion(long id) {
		WebPromotionVO vo = new WebPromotionVO();
		PromotionDataService pds = new PromotionDataService();
		WebPromotionPO po;
		po = pds.getWebPromotion(id);
		// 获取PO
		vo.setBeginTime(po.getBeginTime());
		vo.setEndTime(po.getEndTime());
		vo.setCreatedTime(po.getCreatedTime());
		vo.setDiscount(po.getDiscount());
		vo.setID(po.getID());
		vo.setMemberType(po.getMemberType());
		vo.setPromotionName(vo.getPromotionName());
		vo.setUsageState(po.getUsageState());
		vo.setBusinessDistrict(po.getBusinessDistrict());
		return vo;
	}

	public boolean creatWebPromotion(WebPromotionVO vo) {
		PromotionDataService pds = new PromotionDataService();
		WebPromotionPO po = new WebPromotionPO();

		countWebID++;// ID计数器
		po.setID(countWebID);// 自动生成ID

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date;
		Date now = new Date();
		date = dateFormat.format(now);
		// 获得当前时间
		po.setCreatedTime(date);
		// 设置为系统时间

		po.setUsageState(UsageState.Unused);

		po.setBeginTime(vo.getBeginTime());
		po.setEndTime(vo.getEndTime());
		po.setDiscount(vo.getDiscount());
		po.setMemberType(vo.getMemberType());
		po.setPromotionName(vo.getPromotionName());
		po.setBusinessDistrict(vo.getBusinessDistrict());
		return pds.creat(po);
	}

	public boolean changeWebPromotion(WebPromotionVO vo) {
		PromotionDataService pds = new PromotionDataService();
		WebPromotionPO po = new WebPromotionPO();
		po.setID(vo.getID());
		po.setCreatedTime(vo.getCreatedTime());
		po.setUsageState(UsageState.Unused);// 更改自动设为未应用中
		po.setBeginTime(vo.getBeginTime());
		po.setEndTime(vo.getEndTime());
		po.setDiscount(vo.getDiscount());
		po.setMemberType(vo.getMemberType());
		po.setPromotionName(vo.getPromotionName());
		po.setBusinessDistrict(vo.getBusinessDistrict());
		return pds.change(po);
	}
	// WebPromotionBL
}
