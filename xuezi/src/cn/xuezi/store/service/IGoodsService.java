package cn.xuezi.store.service;

import cn.xuezi.store.dto.GoodsDto;

public interface IGoodsService {
	/**
	 * 
	 * @param goodsId
	 * @return
	 */
	GoodsDto findsGoodsByGoodId(Integer goodsId);

	GoodsDto findsGoodsByGoodType(String goodsType);

}
