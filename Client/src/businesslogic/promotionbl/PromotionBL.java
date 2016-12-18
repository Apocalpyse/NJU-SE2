package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import businesslogicservice.promotionbusinesslogicservice.PromotionBusinessLogicService;
import dataservice.customerdataservice.CustomerDataService;
import dataservice.promotiondataservice.PromotionDataService;
import po.*;
import vo.*;

public class PromotionBL implements PromotionBusinessLogicService {
	CustomerDataService cds = new CustomerDataService() {
		@Override
		public CustomerPO find(long id) {
			return null;
		}

		@Override
		public boolean insert(CustomerPO po) {
			return false;
		}

		@Override
		public boolean delete(long id) {
			return false;
		}

		@Override
		public boolean update(CustomerPO po) {
			return false;
		}
	};
	PromotionDataService pds = new PromotionDataService() {
		@Override
		public MemberPromotionPO find1(long id) {
			return null;
		}

		@Override
		public HotelPromotionPO find2(long id) {
			return null;
		}

		@Override
		public WebPromotionPO find3(long id) {
			return null;
		}

		@Override
		public boolean insert1(MemberPromotionPO po) {
			return false;
		}

		@Override
		public boolean delete1(long id) {
			return false;
		}

		@Override
		public boolean update1(MemberPromotionPO po) {
			return false;
		}

		@Override
		public boolean insert2(HotelPromotionPO po) {
			return false;
		}

		@Override
		public boolean delete2(long id) {
			return false;
		}

		@Override
		public boolean update2(HotelPromotionPO po) {
			return false;
		}

		@Override
		public boolean insert3(WebPromotionPO po) {
			return false;
		}

		@Override
		public boolean delete3(long id) {
			return false;
		}

		@Override
		public boolean update3(WebPromotionPO po) {
			return false;
		}
	};

	// String businessDistrict[]={"NJU","XL"};
	// WebPromotionVO vo=new WebPromotionVO();
	// WebPromotionVO(1111,"a","2016-12-06",UsageState.Using,"2016-12-06","2016-12-07",businessDistrict,MemberType.All,0.3);
	public long getCorrespondingHotelPromotion(long userid, long hotelid, String createdTime) throws RemoteException {
		long id = 0;
		// 获取始末ID
		boolean hasHP = false;
		long begin = 100;
		long end = 100;
		for (id = begin; id <= end; id++) {
			try {
				CustomerPO cpo = this.cds.find(userid);
				HotelPromotionPO hppo = this.pds.find2(id);

				if ((hppo.getHotelID()) == hotelid) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date now = new Date();
					Date orderDate = now;
					Date beginDate = now;
					Date endDate = now;

					orderDate = dateFormat.parse(createdTime);
					beginDate = dateFormat.parse(hppo.getBeginTime());
					endDate = dateFormat.parse(hppo.getEndTime());
					if (orderDate.after(beginDate) && orderDate.before(endDate)
							&& hppo.getUsageState().equals(UsageState.Using)) {
						hasHP = true;
						break;

						// 时间和状态上符合
					}

				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (hasHP == false) {
			id = 0;
		} // 找不到则为0
		return id;
	}

	public long getCorrespondingMemberPromotion() throws RemoteException {
		long id = 0;
		// 获取始末ID
		boolean hasMP = false;
		long begin = 100;
		long end = 100;
		for (id = begin; id <= end; id++) {
			try {
				MemberPromotionPO mppo = this.pds.find1(id);
				if (mppo.getUsageState().equals(UsageState.Using)) {
					hasMP = true;
					break;
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (hasMP == false) {
			id = 0;
		}
		// 无会员制度则返回0
		return id;
	}

	public long getCorrespondingWebPromotion(long userid, String createdTime) throws RemoteException {
		long id = 0;
		// 获取始末ID
		boolean hasWP = false;
		long begin = 100;
		long end = 100;
		
		for (id = begin; id <= end; id++) {
			try {
				CustomerPO cpo = this.cds.find(userid);
				WebPromotionPO hppo = this.pds.find3(id);

				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date now = new Date();
				Date orderDate = now;
				Date beginDate = now;
				Date endDate = now;
				orderDate = dateFormat.parse(createdTime);
				beginDate = dateFormat.parse(hppo.getBeginTime());
				endDate = dateFormat.parse(hppo.getEndTime());
				if (orderDate.after(beginDate) && orderDate.before(endDate)
						&& hppo.getUsageState().equals(UsageState.Using)
						&&cpo.getMember().equals(hppo.getMemberType())) {
					hasWP = true;
					break;

					// 时间和状态上符合
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (hasWP == false) {
			id = 0;
		} // 找不到则为0
		return id;
	}

	public double getDiscount(long userid, long hotelid, String createdTime, int room, double price)
			throws RemoteException {
		double lowestDiscount = 1;
		double memberDiscount = 1;
		double roomDiscount = 1;
		double amountDiscount = 1;
		double birthDiscount = 1;
		double companyDiscount = 1;
		double amount = price;
		int rooms = room;
		CustomerPO cppo = this.cds.find(userid);
		long hpid = this.getCorrespondingHotelPromotion(userid, hotelid, createdTime);
		HotelPromotionPO hppo = this.pds.find2(hpid);
		long mpid = this.getCorrespondingMemberPromotion();
		MemberPromotionPO mppo =this.pds.find1(mpid);
		long wpid = this.getCorrespondingWebPromotion(userid, createdTime);
		WebPromotionPO wppo =this.pds.find3(wpid);
		// 获取初始ID
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

		MemberPromotionPO po = this.pds.find1(id);// 获取PO
		return new MemberPromotionVO(po.getID(), po.getPromotionName(), po.getCreatedTime(), po.getUsageState(),
				po.getCredit(), po.getDiscountForMember());
	}

	public boolean creatMemberPromotion(MemberPromotionVO vo) throws RemoteException {
		return this.pds.insert1(new MemberPromotionPO(vo.getID(), vo.getPromotionName(), vo.getCreatedTime(),
				vo.getUsageState(), vo.getCredit(), vo.getDiscountForMember()));
	}

	public boolean changeMemberPromotion(MemberPromotionVO vo) throws RemoteException {

		return this.pds.update1(new MemberPromotionPO(vo.getID(), vo.getPromotionName(), vo.getCreatedTime(),
				vo.getUsageState(), vo.getCredit(), vo.getDiscountForMember()));

	}
	// MemberPromotionBL

	public HotelPromotionVO getHotelPromotion(long id) throws RemoteException {
		HotelPromotionPO po = this.pds.find2(id);
		// 获取PO
		return new HotelPromotionVO(po.getID(), po.getPromotionName(), po.getCreatedTime(), po.getUsageState(),
				po.getBeginTime(), po.getEndTime(), po.getMemberType(), po.getDiscount(), po.getDiscountForMoreRoom(),
				po.getDiscountformoreroom(), po.getDiscountForLargerAmount(), po.getDiscountforlargeramount(),
				po.getBirthDiscount(), po.getCompanyDiscount(), po.getHotelID());
	}

	public boolean creatHotelPromotion(HotelPromotionVO vo) throws RemoteException {

		return this.pds.insert2(new HotelPromotionPO(vo.getID(), vo.getPromotionName(), vo.getCreatedTime(),
				vo.getUsageState(), vo.getBeginTime(), vo.getEndTime(), vo.getMemberType(), vo.getDiscount(),
				vo.getDiscountForMoreRoom(), vo.getDiscountformoreroom(), vo.getDiscountForLargerAmount(),
				vo.getDiscountforlargeramount(), vo.getBirthDiscount(), vo.getCompanyDiscount(), vo.getHotelID()));

	}

	public boolean changeHotelPromotion(HotelPromotionVO vo) throws RemoteException {
		return this.pds.update2(new HotelPromotionPO(vo.getID(), vo.getPromotionName(), vo.getCreatedTime(),
				vo.getUsageState(), vo.getBeginTime(), vo.getEndTime(), vo.getMemberType(), vo.getDiscount(),
				vo.getDiscountForMoreRoom(), vo.getDiscountformoreroom(), vo.getDiscountForLargerAmount(),
				vo.getDiscountforlargeramount(), vo.getBirthDiscount(), vo.getCompanyDiscount(), vo.getHotelID()));
	}

	// HotelPromotionBL
	public WebPromotionVO getWebPromotion(long id) throws RemoteException {
		WebPromotionPO po = this.pds.find3(id);
		// 获取PO
		return new WebPromotionVO(po.getID(), po.getPromotionName(), po.getCreatedTime(), po.getUsageState(),
				po.getBeginTime(), po.getEndTime(), po.getBusinessDistrict(), po.getMemberType(), po.getDiscount());
		// return this.vo;
	}

	public boolean creatWebPromotion(WebPromotionVO vo) throws RemoteException {
		return this.pds.insert3(new WebPromotionPO(vo.getID(), vo.getPromotionName(), vo.getCreatedTime(),
				vo.getUsageState(), vo.getBeginTime(), vo.getEndTime(), vo.getBusinessDistrict(), vo.getMemberType(),
				vo.getDiscount()));

	}

	public boolean changeWebPromotion(WebPromotionVO vo) throws RemoteException {
		return this.pds.update3(new WebPromotionPO(vo.getID(), vo.getPromotionName(), vo.getCreatedTime(),
				vo.getUsageState(), vo.getBeginTime(), vo.getEndTime(), vo.getBusinessDistrict(), vo.getMemberType(),
				vo.getDiscount()));
	}
	// WebPromotionBL

}
