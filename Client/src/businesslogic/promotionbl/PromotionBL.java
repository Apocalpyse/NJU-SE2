package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;

import java.util.Date;

import businesslogic.customerbl.CustomerController;
import businesslogicservice.promotionbusinesslogicservice.PromotionBusinessLogicService;
import dataservice.customerdataservice.CustomerDataService;
import dataservice.customerdataservice.CustomerDataServiceSqlImpl;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.promotiondataservice.PromotionDataServiceSqlImpl;
import po.*;
import vo.*;

public class PromotionBL implements PromotionBusinessLogicService {

	static long countMemberID = 50000;
	static long countHotelID = 60000;
	static long countWebID = 70000;
	CustomerDataServiceSqlImpl cds;
	PromotionDataServiceSqlImpl pds;

	// String businessDistrict[]={"NJU","XL"};
	// WebPromotionVO vo=new
	// WebPromotionVO(1111,"a","2016-12-06",UsageState.Using,"2016-12-06","2016-12-07",businessDistrict,MemberType.All,0.3);
	public double getDiscount(long id, int room, double price) throws RemoteException {
		double lowestDiscount = 1;
		double memberDiscount = 1;
		double roomDiscount = 1;
		double amountDiscount = 1;
		double birthDiscount = 1;
		double companyDiscount = 1;
		double amount = price;
		int rooms = room;
		CustomerPO cppo = this.cds.find(id);
		HotelPromotionPO hppo = new HotelPromotionPO();
		MemberPromotionPO mppo = new MemberPromotionPO();
		WebPromotionPO wppo = new WebPromotionPO();
		double level[] = mppo.getCredit();
		double discount[] = mppo.getDiscountForMember();
		double credit = Double.parseDouble(cppo.getCredit());
		if (!cppo.getMember().equals(Member.notMember)) {
			for (int i = 0; i < level.length; i++) {
				if (credit < level[i]) {
					memberDiscount = discount[i];
					break;
				}
			}
		}
		// member discount
		if (rooms >= hppo.getDiscountForMoreRoom()) {
			roomDiscount = hppo.getDiscountformoreroom();// 对应房间数目折扣
		}
		// 2
		if (amount >= hppo.getDiscountForLargerAmount()) {
			amountDiscount = hppo.getDiscountforlargeramount();// 对应金额折扣
		}
		// 3
		if (!cppo.getMember().equals(Member.notMember)) {
			companyDiscount = hppo.getCompanyDiscount();// 企业会员与普通会员共享折扣
		}
		// company discount
		String birth = cppo.getBirthday();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date;
		Date now = new Date();
		date = dateFormat.format(now);
		String[] dates = date.split(" ");
		if (birth.equals(dates[0])) {
			birthDiscount = hppo.getBirthDiscount();
		}
		// birthday discount

		if (lowestDiscount > memberDiscount) {
			lowestDiscount = memberDiscount;
		}
		if (lowestDiscount > roomDiscount) {
			lowestDiscount = roomDiscount;
		}
		if (lowestDiscount > amountDiscount) {
			lowestDiscount = amountDiscount;
		}
		if (lowestDiscount > birthDiscount) {
			lowestDiscount = birthDiscount;
		}
		if (lowestDiscount > companyDiscount) {
			lowestDiscount = companyDiscount;
		}
		if (lowestDiscount > wppo.getDiscount()) {
			lowestDiscount = wppo.getDiscount();
		}
		return lowestDiscount;
	}

	// 其中，MemberPromotion部分对会员折扣与HotelPromotion的多房间折扣或消费金额折扣或生日折扣以及WebPromotion折扣
	// ***限制：需根据数据库的构建来获取对应的促销策略
	public MemberPromotionVO getMemberPromotion(long id) throws RemoteException {
		MemberPromotionVO vo = new MemberPromotionVO();
		MemberPromotionPO po;
		po = this.pds.find1(id);
		// 获取PO

		vo.setCreatedTime(po.getCreatedTime());
		vo.setID(po.getID());
		vo.setPromotionName(po.getPromotionName());
		vo.setUsageState(po.getUsageState());
		vo.setCredit(po.getCredit());
		vo.setDiscountForMember(po.getDiscountForMember());
		return vo;
	}

	public boolean creatMemberPromotion(MemberPromotionVO vo) throws RemoteException {
		MemberPromotionPO po = new MemberPromotionPO();

		po.setID(vo.getID());// 自动生成I
		po.setCreatedTime(vo.getCreatedTime());
		po.setUsageState(vo.getUsageState());
		po.setPromotionName(vo.getPromotionName());
		po.setCredit(vo.getCredit());
		po.setDiscountForMember(vo.getDiscountForMember());
		this.pds.insert1(po);
		return true;
	}

	public boolean changeMemberPromotion(MemberPromotionVO vo) throws RemoteException {
		MemberPromotionPO po = new MemberPromotionPO();
		po.setID(vo.getID());
		po.setCreatedTime(vo.getCreatedTime());
		po.setPromotionName(vo.getPromotionName());
		po.setUsageState(vo.getUsageState());
		po.setCredit(vo.getCredit());
		po.setDiscountForMember(vo.getDiscountForMember());
		this.pds.update1(po);
		return true;
	}
	// MemberPromotionBL

	public HotelPromotionVO getHotelPromotion(long id) throws RemoteException {
		HotelPromotionVO vo = new HotelPromotionVO();
		HotelPromotionPO po;
		po = this.pds.find2(id);
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

	public boolean creatHotelPromotion(HotelPromotionVO vo) throws RemoteException {
		HotelPromotionPO po = new HotelPromotionPO();

		po.setID(vo.getID());
		po.setCreatedTime(vo.getCreatedTime());
		po.setUsageState(vo.getUsageState());
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
		po.setCompanyDiscount(vo.getCompanyDiscount());
		this.pds.insert2(po);
		return true;
	}

	public boolean changeHotelPromotion(HotelPromotionVO vo) throws RemoteException {
		HotelPromotionPO po = new HotelPromotionPO();
		po.setID(vo.getID());
		po.setCreatedTime(vo.getCreatedTime());
		po.setUsageState(vo.getUsageState());
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
		po.setCompanyDiscount(vo.getCompanyDiscount());
		this.pds.update2(po);
		return true;
	}
	// HotelPromotionBL

	public WebPromotionVO getWebPromotion(long id) throws RemoteException {
		WebPromotionVO vo = new WebPromotionVO();
		WebPromotionPO po;
		po = this.pds.find3(id);
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
		// return this.vo;
	}

	public boolean creatWebPromotion(WebPromotionVO vo) throws RemoteException {
		WebPromotionPO po = new WebPromotionPO();

		po.setID(vo.getID());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date;
		Date now = new Date();
		date = dateFormat.format(now);
		// 获得当前时间
		po.setCreatedTime(date);
		// 设置为系统时间
		po.setUsageState(vo.getUsageState());

		po.setBeginTime(vo.getBeginTime());
		po.setEndTime(vo.getEndTime());
		po.setDiscount(vo.getDiscount());
		po.setMemberType(vo.getMemberType());
		po.setPromotionName(vo.getPromotionName());
		po.setBusinessDistrict(vo.getBusinessDistrict());
		this.pds.insert3(po);
		return true;
	}

	public boolean changeWebPromotion(WebPromotionVO vo) throws RemoteException {
		WebPromotionPO po = new WebPromotionPO();
		po.setID(vo.getID());
		po.setCreatedTime(vo.getCreatedTime());
		po.setUsageState(vo.getUsageState());
		po.setBeginTime(vo.getBeginTime());
		po.setEndTime(vo.getEndTime());
		po.setDiscount(vo.getDiscount());
		po.setMemberType(vo.getMemberType());
		po.setPromotionName(vo.getPromotionName());
		po.setBusinessDistrict(vo.getBusinessDistrict());
		this.pds.update3(po);
		return true;
	}
	// WebPromotionBL
}
