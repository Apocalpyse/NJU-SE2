package dataservice.promotiondataservice;

import po.HotelPromotionPO;
import po.MemberPromotionPO;
import po.PromotionPO;
import po.WebPromotionPO;

public interface PromotionDataServiceSqlImpl extends PromotionDataService {
	@Override
	MemberPromotionPO find1(long id);
	@Override
	HotelPromotionPO find2(long id);
	@Override
	WebPromotionPO find3(long id);
	@Override
	public void insert1(MemberPromotionPO po);
	@Override
	public void delete1(long id);
	@Override
	public void update1(MemberPromotionPO po);
	@Override
	void insert2(HotelPromotionPO po);
	@Override
	void delete2(long id);
	@Override
	void update2(HotelPromotionPO po);
	@Override
	void insert3(WebPromotionPO po);
	@Override
	void delete3(long id);
	@Override
	void update3(WebPromotionPO po);
}
