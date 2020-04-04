package cn.xuezi.store.mapper;

import java.util.List;

import cn.xuezi.store.bean.Favorites;
import cn.xuezi.store.bean.Goods;

public interface FavoritesMapper {
	/*
	 * 通过收藏商品Id删除商品
	 */
	void deleteFavoritesByGoodsId(Favorites favorites);

	/*
	 * 增加收藏商品
	 */
	void insertFavorites(Favorites favorites);

	/*
	 * 全选
	 * 
	 */
	List<Goods> selectAllFavorites(Integer id);

}
