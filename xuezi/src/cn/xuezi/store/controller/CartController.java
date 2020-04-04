package cn.xuezi.store.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.xuezi.store.bean.Cart;
import cn.xuezi.store.bean.Goods;
import cn.xuezi.store.bean.User;
import cn.xuezi.store.dto.CartList;
import cn.xuezi.store.mapper.CartMapper;
import cn.xuezi.store.mapper.GoodsMapper;
import cn.xuezi.store.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Resource
	private CartService cartService;
	@Resource
	private CartMapper cartMapper;
	@Resource
	private GoodsMapper goodsMapper;

	@RequestMapping("/showCart.do")
	public String showCart() {
		return "cart";
	}

	@RequestMapping("/viewCart.do")
	public String viewCart(HttpSession session) {
		User user = (User) session.getAttribute("user");
		Integer id = null;
		if (user != null) {
			id = user.getId();
		}
		CartList cartList = new CartList();
		Cart cart = new Cart();
		cart.setId(id);
		List<Cart> lc = cartMapper.selectCart(cart);
		List<CartList> lcl = new ArrayList<CartList>();
		for (int i = 0; i < lc.size(); i++) {
			Goods goods = goodsMapper.selectGoodsByGoodId(lc.get(i).getGoodsId());
			cartList.setGoodsColor(goods.getGoodsColor().split("@")[0]);
			cartList.setGoodsImage(goods.getGoodsImage().split("@")[0]);
			cartList.setGoodsMoney(goods.getGoodsMoney());
			cartList.setGoodsName(goods.getGoodsName());
			cartList.setGoodsStandard(goods.getGoodsStandard().split("@")[0]);
			cartList.setGoodsSystem(goods.getGoodsSystem().split("@")[0]);
			cartList.setGoodsNum(lc.get(i).getGoodsNum());
			cartList.setCartMoney(lc.get(i).getCartMoney());
			cartList.setCartId(lc.get(i).getCartId());
			lcl.add(cartList);
		}
		int lclSize = lcl.size();
		session.setAttribute("lclSize", lclSize);
		session.setAttribute("lcl", lcl);
		return "redirect:../cart/showCart.do";
	}

	@RequestMapping("/insertCart.do")
	public String insertCart(HttpSession session, Integer goodsId, Integer goodsNum, Integer goodsMoney) {
		User user = (User) session.getAttribute("user");
		Integer id = null;
		if (user != null) {
			id = user.getId();
		}
		try {
			cartService.insertCart(id, goodsId, goodsNum, goodsMoney);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:../cart/viewCart.do";
	}

	@RequestMapping("/deleteCart.do")
	public String deleteCart(String itemIds[], HttpSession session) {
		int cartId;
		System.out.println("shanchula");
		try {
			for (int i = 0; i < itemIds.length; i++) {
				cartId = Integer.valueOf(itemIds[i]);
				cartService.deleteCart(cartId);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return "redirect:../cart/viewCart.do";
	}
}
