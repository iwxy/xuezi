package cn.xuezi.store.mapper;

import java.util.List;

import cn.xuezi.store.bean.Cart;

public interface CartMapper {
	/**
	 * 添加购物车
	 * 
	 * @param cart
	 */
	void insertCart(Cart cart);

	/**
	 * 根据cart删除购物车商品
	 * 
	 * @param cart
	 */
	void deleteCart(Integer cartId);

	/**
	 * 查询购物车list集合
	 * 
	 * @param cart
	 * @return
	 */
	List<Cart> selectCart(Cart cart);

	/**
	 * 通过商品和用户id查询购物车
	 * 
	 * @param cart
	 * @return
	 */
	Cart selectCartById(Cart cart);

	/**
	 * 更新购物车
	 * 
	 * @param cart
	 */
	void updateCart(Cart cart);
}
