package cn.xuezi.store.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xuezi.store.bean.Address;
import cn.xuezi.store.bean.Cart;
import cn.xuezi.store.bean.Goods;
import cn.xuezi.store.bean.Order;
import cn.xuezi.store.dto.OrderList;
import cn.xuezi.store.mapper.AddressMapper;
import cn.xuezi.store.mapper.CartMapper;
import cn.xuezi.store.mapper.GoodsMapper;
import cn.xuezi.store.mapper.OrderMapper;
import cn.xuezi.store.mapper.UserMapper;
import cn.xuezi.store.service.ex.GoodsNotFound;
import cn.xuezi.store.service.ex.OrderInfoException;

@Service
public class OrderService implements IOrderService {

	@Resource
	private UserMapper userMapper;
	@Resource
	private OrderMapper orderMapper;
	@Resource
	private GoodsMapper goodsMapper;
	@Resource
	private CartMapper cartMapper;
	@Resource
	private AddressMapper addressMapper;

	@Override
	public Order selectOrderByOrderId(Integer orderId) {
		return orderMapper.selectOrderByOrderId(orderId);
	}

	@Override
	public List<OrderList> selectOrder(Integer id) {
		// TODO Auto-generated method stub
		List<Order> orders = orderMapper.selectOrderByUserId(id);
		if (!orders.isEmpty()) {
			Order order = null;
			List<OrderList> orderList = new ArrayList<OrderList>();
			for (int i = 0; i < orders.size(); i++) {
				order = orders.get(i);
				Goods goods = goodsMapper.selectGoodsByGoodId(order.getGoodsId());
				if (goods == null) {
					throw new GoodsNotFound("该商品不存在！");
				} else {
					OrderList ol = convertToOrderList(goods, order);
					orderList.add(ol);
				}

				// 下面的convertToOrderList方法

			}
			return orderList;
		} else {
			return null;
		}

	}

	@Override
	public List<OrderList> selectOrderByIdAndStatus(Integer id, Integer orderStatus) {
		// TODO Auto-generated method stub
		Order o = new Order();
		o.setId(id);
		o.setOrderStatus(orderStatus);
		List<Order> orders = orderMapper.selectOrderByIdAndStatus(o);
		if (!orders.isEmpty()) {
			Order order = null;
			List<OrderList> orderList = new ArrayList<OrderList>();
			for (int i = 0; i < orders.size(); i++) {
				order = orders.get(i);
				Goods goods = goodsMapper.selectGoodsByGoodId(order.getGoodsId());
				// 下面的convertToOrderList方法
				OrderList ol = convertToOrderList(goods, order);
				orderList.add(ol);
			}
			return orderList;
		} else {
			return null;
		}

	}

	@Override
	public int addOrder(Order order) {
		// TODO Auto-generated method stub
		// try {
		if (orderMapper.selectOrderByOrderId(order.getOrderId()) != null) {
			throw new OrderInfoException("订单信息冲突，无法添加！");
		} else {
			int i = orderMapper.insertOrder(order);
			return i;
		}
	}

	@Override
	public int updateOrder(Order order) {
		return orderMapper.upadteOrder(order);
	}

	@Override
	public int deleteOrder(Integer orderId) {
		return orderMapper.deleteOrderByOrderId(orderId);
	}

	/**
	 * 将order和goods对象转换成orderList对象
	 * 
	 * @param goods
	 * @param order
	 * @return
	 */
	@Override
	public OrderList convertToOrderList(Goods goods, Order order) {
		OrderList ol = new OrderList();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		// String image = (goods.getGoodsImage().split("@"))[0];
		ol.setGoodsImage((goods.getGoodsImage().split("@"))[0]);
		ol.setGoodsName(goods.getGoodsName());
		ol.setGoodsStandard(goods.getGoodsStandard().split("@")[0]);
		ol.setGoodsSystem(goods.getGoodsSystem());
		ol.setGoodsColor(goods.getGoodsColor());
		ol.setGoodsMoney(goods.getGoodsMoney());
		ol.setGoodsNum(order.getGoodsNum());
		ol.setOrderTime(dateFormat.format(order.getOrderTime()));
		ol.setOrderId(order.getGoodsId());
		ol.setOrderStatus(order.getOrderStatus());
		ol.setAddressId(order.getAddressId());
		return ol;
	}

	@Override
	public Cart selectCartById(Integer id, Integer cartId) {
		Cart cart = new Cart();
		cart.setId(id);
		cart.setCartId(cartId);
		cart = cartMapper.selectCartById(cart);
		return cart;
	}

	@Override
	public Goods selectGoodsByGoodsId(Integer goodsId) {
		Goods goods = new Goods();
		goods = goodsMapper.selectGoodsByGoodId(goodsId);
		return goods;
	}

	@Override
	public Order setOrder(int id, String username, int addressId, int goodsNum, int goodsId, int type) {
		Goods goods = goodsMapper.selectGoodsByGoodId(goodsId);
		Order order = new Order();
		order.setId(id);
		order.setGoodsId(goods.getGoodsId());
		order.setOrderStatus(type);
		order.setGoodsNum(goodsNum);
		order.setOrderTime(new Date());
		order.setOrderMoney(goods.getGoodsMoney() * goodsNum);
		order.setCreatedUser(username);
		order.setCreatedTime(new Date());
		order.setModifiedTime(new Date());
		order.setModifiedUser(username);
		order.setAddressId(addressId);
		return order;
	}

	@Override
	public List<Address> getUserAddress(Integer id) {
		return addressMapper.selectAdressById(id);
	}
}
