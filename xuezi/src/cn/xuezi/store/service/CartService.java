package cn.xuezi.store.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xuezi.store.bean.Cart;
import cn.xuezi.store.bean.User;
import cn.xuezi.store.mapper.CartMapper;
import cn.xuezi.store.mapper.UserMapper;

@Service
public class CartService implements ICartService {
	@Resource
	private CartMapper cartMapper;
	@Resource
	private UserMapper userMapper;

	@Override
	public void deleteCart(Integer cartId) {
		// TODO Auto-generated method stub
		cartMapper.deleteCart(cartId);
	}

	@Override
	public void insertCart(Integer Id, Integer goodsId, Integer num, Integer goodsMoney) {
		// TODO Auto-generated method stub
		User user = userMapper.selectUserById(Id);
		String username = user.getUsername();
		Cart cart1 = new Cart();
		cart1.setId(Id);
		cart1.setGoodsId(goodsId);
		Cart cart2 = cartMapper.selectCartById(cart1);
		if (cart2 == null) {
			cart2 = new Cart();
			cart2.setGoodsId(goodsId);
			cart2.setGoodsNum(num);
			cart2.setId(Id);
			cart2.setCartMoney(goodsMoney);
			cart2.setCreatedUser(username);
			cart2.setCreatedTime(new Date());
			cart2.setModifiedUser(username);
			cart2.setModifiedTime(new Date());
			cartMapper.insertCart(cart2);
		} else {
			int num1 = cart2.getGoodsNum() + num;
			int newCartMoney = goodsMoney * num1;
			cart2.setGoodsNum(num1);
			cart2.setCartMoney(newCartMoney);
			cart2.setModifiedUser(username);
			cart2.setModifiedTime(new Date());
			cartMapper.updateCart(cart2);
		}
	}

}
