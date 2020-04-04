package cn.xuezi.store.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xuezi.store.bean.Goods;
import cn.xuezi.store.dto.GoodsDto;
import cn.xuezi.store.mapper.GoodsMapper;

@Service
public class GoodsServcie implements IGoodsService {
	@Resource(name = "goodsMapper")
	private GoodsMapper goodsMapper;

	/**
	 * 通过商品编号查询商品信息
	 */
	@Override
	public GoodsDto findsGoodsByGoodId(Integer goodsId) {
		Goods goods = goodsMapper.selectGoodsByGoodId(goodsId);

		GoodsDto goodsDto = new GoodsDto();
		goodsDto.setGoodsId(goods.getGoodsId());
		goodsDto.setGoodsName(goods.getGoodsName());
		goodsDto.setGoodsMoney(goods.getGoodsMoney());
		// 商品颜色
		String goodsColor = goods.getGoodsColor();
		String[] color = goodsColor.split("@");
		List<String> listColor = new ArrayList<String>();
		// listColor.add(goodsColor);
		for (int i = 0; i < color.length; i++) {
			listColor.add(i, color[i]);
		}
		goodsDto.setGoodsColor(listColor);
		// 商品规格
		String goodsStandard = goods.getGoodsStandard();
		String[] standard = goodsStandard.split("@");
		List<String> listStandard = new ArrayList<String>();
		for (int i = 0; i < standard.length; i++) {
			System.out.println(standard[i]);
			listStandard.add(i, standard[i]);
		}
		goodsDto.setGoodsStandard(listStandard);
		// 商品图片
		String goodsImage = goods.getGoodsImage();
		String[] image = goodsImage.split("@");
		List<String> listImage = new ArrayList<String>();
		for (int i = 0; i < image.length; i++) {
			System.out.println(image[i]);
			listImage.add(i, image[i]);
		}
		goodsDto.setGoodsImage(listImage);
		goodsDto.setGoodsSystem(goods.getGoodsSystem());
		goodsDto.setGoodsStorage(goods.getGoodsStorage());
		goodsDto.setGoodsResolution(goods.getGoodsResolution());
		goodsDto.setGoodsGraphics(goods.getGoodsGraphics());
		goodsDto.setGoodsProcessor(goods.getGoodsProcessor());
		goodsDto.setGoodsDisplaystorage(goods.getGoodsDisplaystorage());
		goodsDto.setGoodsType(goods.getGoodsType());
		goodsDto.setGoodsDisk(goods.getGoodsDisk());
		goodsDto.setGoodsBigimage(goods.getGoodsBigimage());
		goodsDto.setGoodsPack(goods.getGoodsPack());

		return goodsDto;
	}

	@Override
	public GoodsDto findsGoodsByGoodType(String goodsType) {
		Goods goods = goodsMapper.selectGoodsByGoodsType(goodsType);

		GoodsDto goodsDto = new GoodsDto();
		goodsDto.setGoodsId(goods.getGoodsId());
		goodsDto.setGoodsName(goods.getGoodsName());
		goodsDto.setGoodsMoney(goods.getGoodsMoney());
		// 商品颜色
		String goodsColor = goods.getGoodsColor();
		String[] color = goodsColor.split("@");
		List<String> listColor = new ArrayList<String>();
		// listColor.add(goodsColor);
		for (int i = 0; i < color.length; i++) {
			System.out.println(color[i]);
			listColor.add(i, color[i]);
		}
		goodsDto.setGoodsColor(listColor);
		// 商品规格
		String goodsStandard = goods.getGoodsStandard();
		String[] standard = goodsStandard.split("@");
		List<String> listStandard = new ArrayList<String>();
		for (int i = 0; i < standard.length; i++) {
			System.out.println(standard[i]);
			listStandard.add(i, standard[i]);
		}
		goodsDto.setGoodsStandard(listStandard);
		// 商品图片
		String goodsImage = goods.getGoodsImage();
		String[] image = goodsImage.split("@");
		List<String> listImage = new ArrayList<String>();
		for (int i = 0; i < image.length; i++) {
			System.out.println(image[i]);
			listImage.add(i, image[i]);
		}
		goodsDto.setGoodsImage(listImage);
		goodsDto.setGoodsSystem(goods.getGoodsSystem());
		goodsDto.setGoodsStorage(goods.getGoodsStorage());
		goodsDto.setGoodsResolution(goods.getGoodsResolution());
		goodsDto.setGoodsGraphics(goods.getGoodsGraphics());
		goodsDto.setGoodsProcessor(goods.getGoodsProcessor());
		goodsDto.setGoodsDisplaystorage(goods.getGoodsDisplaystorage());
		goodsDto.setGoodsType(goods.getGoodsType());
		goodsDto.setGoodsDisk(goods.getGoodsDisk());
		goodsDto.setGoodsBigimage(goods.getGoodsBigimage());
		goodsDto.setGoodsPack(goods.getGoodsPack());

		return goodsDto;
	}

}
