package cn.xuezi.store.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.xuezi.store.dto.GoodsDto;
import cn.xuezi.store.service.IGoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Resource
	private IGoodsService goodsService;

	/* ==================显示商品详情信息页面=================== */
	@RequestMapping("/product_details.do")
	public String product_details(Integer goodsId, HttpSession session) {
		GoodsDto goods = goodsService.findsGoodsByGoodId(goodsId);
		if (goods != null) {
			session.setAttribute("goods", goods);

		} else {
			session.setAttribute("msg", "该商品详情不存在");
		}
		return "product_details";
	}

	/* ==================通过商品类型查询=================== */
	@RequestMapping("/selectGoodsByType.do")
	public String selectGoodsByType(String goodsType, HttpSession session) {
		GoodsDto goods = goodsService.findsGoodsByGoodType(goodsType);
		if (goods != null) {
			session.setAttribute("goods", goods);
		} else {
			session.setAttribute("msg", "该商品详情不存在");
		}
		return "product_details";
	}

}
