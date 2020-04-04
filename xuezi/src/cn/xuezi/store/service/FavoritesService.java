package cn.xuezi.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xuezi.store.bean.Favorites;
import cn.xuezi.store.bean.Goods;
import cn.xuezi.store.mapper.FavoritesMapper;

@Service
public class FavoritesService implements IFavoritesService {
	@Resource
	private FavoritesMapper favoritesMapper;

	public FavoritesService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void deleteFavoritesByGoodsId(Integer goodsId, Integer userId) {
		// TODO Auto-generated method stub
		Favorites favorites = new Favorites();
		favorites.setGoodsId(goodsId);
		favorites.setId(userId);
		favoritesMapper.deleteFavoritesByGoodsId(favorites);

	}

	@Override
	public void insertFavorites(Favorites favorites) {
		System.out.println("service....");
		favoritesMapper.insertFavorites(favorites);
		System.out.println("service");

	}

	@Override
	public List<Goods> selectAllFavorites(Integer userId) {
		List<Goods> goodsList = favoritesMapper.selectAllFavorites(userId);
		for (int i = 0; i < goodsList.size(); i++) {
			Goods g = goodsList.get(i);
			String img = g.getGoodsImage();
			String s[] = img.split("@");
			g.setGoodsImage(s[0]);
			goodsList.set(i, g);
		}
		return goodsList;
	}

}
