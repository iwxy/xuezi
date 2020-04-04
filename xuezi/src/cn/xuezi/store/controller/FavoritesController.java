package cn.xuezi.store.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xuezi.store.bean.Favorites;
import cn.xuezi.store.bean.Goods;
import cn.xuezi.store.bean.ResponseResult;
import cn.xuezi.store.bean.User;
import cn.xuezi.store.service.IFavoritesService;

@Controller
@RequestMapping("/favorites")
public class FavoritesController {

	@Resource
	IFavoritesService favoritesService;

	// http://localhost:8080/xuezi/favorites/showFavorites.do
	@RequestMapping("/showFavorites.do")
	public String showFavorites(HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Goods> goodsList = favoritesService.selectAllFavorites(user.getId());
		session.setAttribute("goodsList", goodsList);
		session.setAttribute("goodsListSize", goodsList.size());
		return "favorites";
	}

	@RequestMapping("/insertFavorites.do")
	public String addFavorites(Integer goodsId, HttpSession session) {
		User user = (User) session.getAttribute("user");
		Favorites favorites = new Favorites();
		favorites.setGoodsId(goodsId);
		favorites.setId(user.getId());
		favorites.setCreatedUser("admin");
		favorites.setCreatedTime(new Date());
		favorites.setModifiedUser("admin");
		favorites.setModifiedTime(new Date());
		favoritesService.insertFavorites(favorites);
		return "redirect:../favorites/showFavorites.do";
	}

	/* ==============================删除商品收藏============================= */

	@RequestMapping("/delFavorites.do")
	@ResponseBody
	public ResponseResult<Void> deleteFavoritesByFavoritesId(String itemIds[], HttpSession session) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		User user = (User) session.getAttribute("user");
		try {
			for (String goodsId : itemIds) {
				favoritesService.deleteFavoritesByGoodsId(Integer.valueOf(goodsId), user.getId());
			}
			rr.setState(1);
			rr.setMessage("删除成功");
		} catch (Exception e) {
			rr.setState(0);
		}
		return rr;
	}

}
