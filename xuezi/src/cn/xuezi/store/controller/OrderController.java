package cn.xuezi.store.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xuezi.store.bean.Address;
import cn.xuezi.store.bean.Cart;
import cn.xuezi.store.bean.Goods;
import cn.xuezi.store.bean.Order;
import cn.xuezi.store.bean.ResponseResult;
import cn.xuezi.store.bean.User;
import cn.xuezi.store.dto.OrderList;
import cn.xuezi.store.service.IAddressService;
import cn.xuezi.store.service.ICartService;
import cn.xuezi.store.service.IGoodsService;
import cn.xuezi.store.service.IOrderService;
import cn.xuezi.store.service.IUserService;
import cn.xuezi.store.service.ex.OrderStatusNotMatchException;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Resource
	private IUserService userService;
	@Resource
	private IOrderService orderService;
	@Resource
	private IAddressService addressService;
	@Resource
	private ICartService cartService;
	@Resource
	private IGoodsService goodsService;

	@RequestMapping("/showOrderConfirm.do")
	public String showOrderConfirm() {
		return "orderConfirm";
	}

	@RequestMapping("/showOrderInfo.do")
	public String showOrderInfo() {
		return "orderInfo";
	}

	@RequestMapping("/showOrders.do")
	public String showOrders() {
		return "orders";
	}

	/**
	 * 从订单列表里面，查看订单详情，将当前对象传到controller
	 * 
	 * @param order
	 * @param session
	 * @return
	 */
	@RequestMapping("/showThisOrderInfo.do")
	public String showThisOrderInfo(Integer orderId, HttpSession session) {
		session.removeAttribute("msg");
		List<OrderList> ol = (List<OrderList>) session.getAttribute("orderList");
		OrderList order = new OrderList();
		for (int i = 0; i < ol.size(); i++) {
			if (ol.get(i).getOrderId() == orderId) {
				order = ol.get(i);
			}
		}
		System.out.println(order);
		User user = (User) session.getAttribute("user");
		int id = user.getId();
		int aid = order.getAddressId();// aid可能为空
		Address address = addressService.viewReceiver(id, aid);// 地址可能不存在
		session.setAttribute("address", address);
		session.setAttribute("thisOrder", order);
		return "redirect:../order/showOrderInfo.do";
	}

	/**
	 * 查看该用户的所有订单
	 * 
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping("/showUserOrders.do")
	public String showUserOrders(HttpSession session) {
		session.removeAttribute("msg");
		// ResponseResult<Void> rr = new ResponseResult<Void>();
		User user = (User) session.getAttribute("user");
		Integer id = user.getId();
		List<OrderList> orderList = orderService.selectOrder(id);
		System.out.println(orderList);
		if (orderList == null) {
			// throw new OrderNotFoundException("您还没有任何订单，您可以先逛逛哦！");
			session.setAttribute("msg", "您没有任何该类订单，您可以先去别处逛逛哦！");
			return "redirect:../order/showOrders.do";// "redirect:../order/showOrders.do"
		} else {
			session.setAttribute("orderList", orderList);
			return "redirect:../order/showOrders.do";// "redirect:../order/showOrders.do"
		}

	}

	/**
	 * 查看该用户的不同状态的订单
	 * 
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping("/showDifferentOrders.do")
	public String showDifferentOrders(Integer type, HttpSession session) {
		session.removeAttribute("msg");
		User user = (User) session.getAttribute("user");
		Integer id = user.getId();
		List<OrderList> orderList = orderService.selectOrderByIdAndStatus(id, type);
		if (orderList == null) {
			session.setAttribute("orderList", orderList);
			session.setAttribute("msg", "您没有任何该类订单，您可以先去别处逛逛哦！");
			return "redirect:../order/showOrders.do";// "redirect:../order/showOrders.do"

		} else {
			session.setAttribute("orderList", orderList);
		}
		return "redirect:../order/showOrders.do";// "redirect:../order/showOrders.do"

	}

	/**
	 * 付钱3
	 * 
	 * @param cartId
	 * @param addressId
	 * @param session
	 * @return
	 */
	@RequestMapping("/eachAdd.do")
	@ResponseBody
	public ResponseResult<Void> eachAdd(int[] orderId, int addressId, HttpSession session) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		System.out.println(orderId[0]);
		for (int i = 0; i < orderId.length; i++) {
			User user = (User) session.getAttribute("user");
			String username = user.getUsername();
			Integer id = user.getId();
			Order order = orderService.selectOrderByOrderId(orderId[i]);
			order.setOrderStatus(3);
			order.setAddressId(addressId);
			int n = orderService.updateOrder(order);
			try {
				if (n != 0) {
					rr.setState(1);
					rr.setMessage("付款信息正确，前往选择支付方式！");
				} else {
					rr.setState(0);
					rr.setMessage("付款信息错误！");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				rr.setState(0);
				rr.setMessage(e.getMessage());
			}
		}
		return rr;
	}

	/**
	 * 确认并付款，2，添加订单
	 * 
	 * @param cartId
	 * @param type
	 * @return
	 */
	@RequestMapping("/addCartOrder.do")
	@ResponseBody
	public ResponseResult<Void> addCartOrder(Integer orderId, Integer addressId, HttpSession session) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		User user = (User) session.getAttribute("user");
		String username = user.getUsername();
		Integer id = user.getId();
		Order order = orderService.selectOrderByOrderId(orderId);
		order.setOrderStatus(3);
		order.setAddressId(addressId);
		try {
			int i = orderService.addOrder(order);
			if (i != 0) {
				rr.setState(1);
				rr.setMessage("添加成功！");
			} else {
				rr.setState(0);
				rr.setMessage("添加失败！");
			}
			return rr;// "redirect:../order/showUserOrders.do"
		} catch (Exception e) {
			// TODO Auto-generated catch block
			rr.setState(0);
			rr.setMessage(e.getMessage());
			return rr;// "redirect:../order/showUserOrders.do"
		}
	}

	/**
	 * 去结算:从购物车选中去结算，将一个个被选中的列出来,未付款1
	 * 
	 * @param goodsIdList
	 * @return
	 */
	@RequestMapping("/selectCartOrder.do")
	public String selectCartOrder(int cartId, int goodsNum, HttpSession session) {
		// ResponseResult<Void> rr = new ResponseResult<Void>();
		// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd
		// hh:mm:ss");

		User user = (User) session.getAttribute("user");
		Integer id = user.getId();
		String username = user.getUsername();
		Cart cart = orderService.selectCartById(id, cartId);
		List<OrderList> orderList = new ArrayList<OrderList>();
		OrderList ol = new OrderList();
		Goods goods = new Goods();
		int n = 0;
		// for (int i = 0; i < goodsIdList.length; i++) {
		goods = orderService.selectGoodsByGoodsId(cart.getGoodsId());
		Order order = orderService.setOrder(id, username, 0, goodsNum, goods.getGoodsId(), 1);
		n = orderService.addOrder(order);
		ol = orderService.convertToOrderList(goods, order);
		orderList.add(ol);
		// }
		List<Address> addressList = orderService.getUserAddress(id);
		session.setAttribute("orderList", orderList);
		session.setAttribute("addressList", addressList);
		System.out.println(orderList);
		return "redirect:../order/showOrderConfirm.do";// orderConfirm
		// System.out.println(orderList);
		// if (n != 0) {
		// System.out.println("if1");
		// rr.setState(1);
		// rr.setMessage("添加成功！");
		// return rr;
		// } else {
		// System.out.println("if2");
		// rr.setState(0);
		// rr.setMessage("添加失败！");
		// return rr;
		// }

	}

	@RequestMapping("/trunToCartOrder.do")
	public String trunToCartOrder(int orderId, HttpSession session) {
		Order order = orderService.selectOrderByOrderId(orderId);
		Goods goods = orderService.selectGoodsByGoodsId(order.getGoodsId());
		OrderList orderList = orderService.convertToOrderList(goods, order);
		session.setAttribute("orderList", orderList);
		return "redirect:../order/showOrderConfirm.do";
	}

	/**
	 * 商品详情页下单，status为1，保存order对象，跳到orderConfirm.jsp页面
	 * 
	 * @param cartId
	 * @param type
	 * @return
	 */
	@RequestMapping("/addGoodsOrder.do")
	public String addGoodsOrder(Integer goodsId, Integer goodsNum, String color, HttpSession session) {
		Goods goods = orderService.selectGoodsByGoodsId(goodsId);
		goods.setGoodsColor(color);
		User user = (User) session.getAttribute("user");
		Integer id = user.getId();
		String username = user.getUsername();
		Order order = new Order();
		order.setId(id);
		order.setGoodsId(goodsId);
		order.setOrderStatus(2);
		order.setGoodsNum(goodsNum);
		order.setCreatedTime(new Date());
		order.setCreatedUser(username);
		order.setOrderTime(new Date());
		Integer orderMoney = goods.getGoodsMoney() * goodsNum;
		order.setOrderMoney(orderMoney);
		order.setModifiedTime(new Date());
		order.setModifiedUser(username);
		order.setAddressId(null);
		int i = orderService.addOrder(order);
		OrderList ol = orderService.convertToOrderList(goods, order);
		session.setAttribute("orderList", ol);
		return "orderConfirm";
	}

	/**
	 * 改变订单状态(左侧栏、确认并付款的确认支付)
	 * 
	 * @param orderId
	 * @param type
	 * @return
	 */
	@RequestMapping("/updateOrder.do")
	@ResponseBody
	public ResponseResult<Void> updateOrder(Integer orderId, Integer type, HttpSession session) {
		// Order order = orderService.selectOrderByOrderId(orderId);
		System.out.println("controll");
		ResponseResult<Void> rr = new ResponseResult<Void>();
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		Order order = new Order();
		order.setOrderId(orderId);
		order.setOrderStatus(type);
		order.setModifiedTime(new Date());
		order.setModifiedUser(user.getUsername());
		int i = orderService.updateOrder(order);
		if (i != 0) {
			rr.setState(1);
			rr.setMessage("修改成功！");
		} else {
			rr.setState(0);
			rr.setMessage("修改失败！");
		}
		// 0：已完成；1：待付款；2：待收货；3：待评价；
		return rr;// "redirect:../order/showUserOrders.do"
	}

	@RequestMapping("/deleteOrder.do")
	@ResponseBody
	public ResponseResult<Void> deleteOrder(Integer orderId) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		Order order = orderService.selectOrderByOrderId(orderId);
		if (order.getOrderStatus() == 1) {
			int i = orderService.deleteOrder(orderId);
			if (i != 0) {
				rr.setState(1);
				rr.setMessage("删除成功！");
			} else {
				rr.setState(0);
				rr.setMessage("删除失败！");
			}
		} else {
			throw new OrderStatusNotMatchException("订单状态不符合");
		}

		return rr;// "redirect:../order/showUserOrders.do"
	}

}
