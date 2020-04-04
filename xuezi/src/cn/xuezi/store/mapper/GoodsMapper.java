package cn.xuezi.store.mapper;

import java.util.List;

import cn.xuezi.store.bean.Goods;

public interface GoodsMapper {
	/**
	 * 通过商品编号查询商品信息
	 * @param goodsId
	 * @return
	 */
	Goods selectGoodsByGoodId(Integer goodsId);
	/**
	 * 通过商品类型查询商品信息
	 * @param goodsType
	 * @return
	 */
	Goods selectGoodsByGoodsType(String goodsType);
	/**
	 * 超级搜索
	 * @param messages
	 * @return
	 */
	List<Goods> selectGoods(String messages);

}
