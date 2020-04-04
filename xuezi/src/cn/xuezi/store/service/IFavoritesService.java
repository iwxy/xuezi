package cn.xuezi.store.service;

import java.util.List;

import cn.xuezi.store.bean.Favorites;
import cn.xuezi.store.bean.Goods;

public interface IFavoritesService {
	public void deleteFavoritesByGoodsId(Integer goodsId, Integer userId);

	public void insertFavorites(Favorites favorites);

	/* public List<Goods> selectAllFavorites(Integer id); */
	public List<Goods> selectAllFavorites(Integer userId);

}
