package cn.xuezi.store.service;

import java.util.List;

import cn.xuezi.store.bean.Address;
import cn.xuezi.store.bean.Cart;
import cn.xuezi.store.bean.Goods;
import cn.xuezi.store.bean.Order;
import cn.xuezi.store.dto.OrderList;

public interface IOrderService {

	/**
	 * 根据用户id查询用户的订单
	 * 
	 * @param username
	 * @return
	 */
	List<OrderList> selectOrder(Integer id);

	/**
	 * 添加订单
	 * 
	 * @param order
	 */
	int addOrder(Order order);

	/**
	 * 根据订单id查询订单详情
	 * 
	 * @param order
	 */
	Order selectOrderByOrderId(Integer orderId);

	/**
	 * 修改订单状态
	 * 
	 * @param order
	 */
	int updateOrder(Order order);

	/**
	 * 删除订单
	 * 
	 * @param orderId
	 * @return
	 */
	int deleteOrder(Integer orderId);

	/**
	 * 根据用户id和status查询订单
	 * 
	 * @param id
	 * @param orderStatus
	 * @return
	 */
	List<OrderList> selectOrderByIdAndStatus(Integer id, Integer orderStatus);

	/**
	 * 根据cartId查询cart
	 * 
	 * @param cartId
	 * @return
	 */
	Cart selectCartById(Integer id, Integer cartId);

	/**
	 * 根据goodsId来查询goods
	 * 
	 * @param goodsId
	 * @return
	 */
	Goods selectGoodsByGoodsId(Integer goodsId);

	/**
	 * 将order和goods对象转换成orderList对象
	 * 
	 * @param goods
	 * @param order
	 * @return
	 */
	OrderList convertToOrderList(Goods goods, Order order);

	/**
	 * 生成订单
	 * 
	 * @param id
	 * @param username
	 * @param addressId
	 * @param goodsNum
	 * @param goodsId
	 * @param type
	 * @return
	 */
	Order setOrder(int id, String username, int addressId, int goodsNum, int goodsId, int type);

	/**
	 * 查询用户的所有地址
	 * 
	 * @param id
	 * @return
	 */
	List<Address> getUserAddress(Integer id);

}
