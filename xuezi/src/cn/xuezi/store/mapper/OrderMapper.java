package cn.xuezi.store.mapper;

import java.util.List;

import cn.xuezi.store.bean.Order;

public interface OrderMapper {
	/**
	 * 根据用户id查询用户的订单
	 * 
	 * @param username
	 * @return
	 */
	List<Order> selectOrderByUserId(Integer id);

	/**
	 * 根据订单id查询订单详情
	 * 
	 * @param orderId
	 * @return
	 */
	Order selectOrderByOrderId(Integer orderid);

	/**
	 * 根据id和status查询订单
	 * 
	 * @param order
	 * @return
	 */
	List<Order> selectOrderByIdAndStatus(Order order);

	/**
	 * 添加订单
	 * 
	 * @param order
	 */
	int insertOrder(Order order);

	/**
	 * 修改订单状态
	 * 
	 * @param order
	 */
	int upadteOrder(Order order);

	/**
	 * 根据订单id查询订单详情
	 * 
	 * @param orderId
	 * @return
	 */
	int deleteOrderByOrderId(Integer orderId);

}
