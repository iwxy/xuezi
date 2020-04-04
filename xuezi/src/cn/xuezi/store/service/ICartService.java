package cn.xuezi.store.service;

import cn.xuezi.store.bean.Cart;

public interface ICartService {
	/**
	 * 通过购物车id商品购物车
	 * @param cartId
	 */
	void deleteCart(Integer cartId);
	/**
	 * 添加购物车
	 * @param cart
	 */
	void insertCart(Integer Id,Integer goodsId,Integer num,Integer goodsMoney);
}
