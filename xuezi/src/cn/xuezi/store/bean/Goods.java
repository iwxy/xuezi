package cn.xuezi.store.bean;

import java.util.Date;

public class Goods {
	private Integer goodsId;
	private String goodsName;
	private Integer goodsMoney;
	private String goodsColor;
	private String goodsStandard;
	private String goodsImage;
	private String goodsSystem;
	private String goodsStorage;
	private String goodsResolution;
	private String goodsGraphics;
	private String goodsProcessor;
	private String goodsDisplaystorage;
	private String goodsType;
	private String goodsDisk;
	private String goodsBigimage;
	private String goodsPack;
	private String createdUser;
	private Date createdTime;
	private String modifiedUser;
	private Date modifiedTime;
	
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Goods(Integer goodsId, String goodsName, Integer goodsMoney, String goodsColor, String goodsStandard,
			String goodsImage, String goodsSystem, String goodsStorage, String goodsResolution, String goodsGraphics,
			String goodsProcessor, String goodsDisplaystorage, String goodsType, String goodsDisk,
			String goodsBigimage, String goodsPack, String createdUser, Date createdTime, String modifiedUser,
			Date modifiedTime) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsMoney = goodsMoney;
		this.goodsColor = goodsColor;
		this.goodsStandard = goodsStandard;
		this.goodsImage = goodsImage;
		this.goodsSystem = goodsSystem;
		this.goodsStorage = goodsStorage;
		this.goodsResolution = goodsResolution;
		this.goodsGraphics = goodsGraphics;
		this.goodsProcessor = goodsProcessor;
		this.goodsDisplaystorage = goodsDisplaystorage;
		this.goodsType = goodsType;
		this.goodsDisk = goodsDisk;
		this.goodsBigimage = goodsBigimage;
		this.goodsPack = goodsPack;
		this.createdUser = createdUser;
		this.createdTime = createdTime;
		this.modifiedUser = modifiedUser;
		this.modifiedTime = modifiedTime;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getGoodsMoney() {
		return goodsMoney;
	}

	public void setGoodsMoney(Integer goodsMoney) {
		this.goodsMoney = goodsMoney;
	}

	public String getGoodsColor() {
		return goodsColor;
	}

	public void setGoodsColor(String goodsColor) {
		this.goodsColor = goodsColor;
	}

	public String getGoodsStandard() {
		return goodsStandard;
	}

	public void setGoodsStandard(String goodsStandard) {
		this.goodsStandard = goodsStandard;
	}

	public String getGoodsImage() {
		return goodsImage;
	}

	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}

	public String getGoodsSystem() {
		return goodsSystem;
	}

	public void setGoodsSystem(String goodsSystem) {
		this.goodsSystem = goodsSystem;
	}

	public String getGoodsStorage() {
		return goodsStorage;
	}

	public void setGoodsStorage(String goodsStorage) {
		this.goodsStorage = goodsStorage;
	}

	public String getGoodsResolution() {
		return goodsResolution;
	}

	public void setGoodsResolution(String goodsResolution) {
		this.goodsResolution = goodsResolution;
	}

	public String getGoodsGraphics() {
		return goodsGraphics;
	}

	public void setGoodsGraphics(String goodsGraphics) {
		this.goodsGraphics = goodsGraphics;
	}

	public String getGoodsProcessor() {
		return goodsProcessor;
	}

	public void setGoodsProcessor(String goodsProcessor) {
		this.goodsProcessor = goodsProcessor;
	}

	public String getGoodsDisplaystorage() {
		return goodsDisplaystorage;
	}

	public void setGoodsDisplaystorage(String goodsDisplaystorage) {
		this.goodsDisplaystorage = goodsDisplaystorage;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getGoodsDisk() {
		return goodsDisk;
	}

	public void setGoodsDisk(String goodsDisk) {
		this.goodsDisk = goodsDisk;
	}

	public String getGoodsBigimage() {
		return goodsBigimage;
	}

	public void setGoodsBigimage(String goodsBigimage) {
		this.goodsBigimage = goodsBigimage;
	}

	public String getGoodsPack() {
		return goodsPack;
	}

	public void setGoodsPack(String goodsPack) {
		this.goodsPack = goodsPack;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsMoney=" + goodsMoney + ", goodsColor="
				+ goodsColor + ", goodsStandard=" + goodsStandard + ", goodsImage=" + goodsImage + ", goodsSystem="
				+ goodsSystem + ", goodsStorage=" + goodsStorage + ", goodsResolution=" + goodsResolution
				+ ", goodsGraphics=" + goodsGraphics + ", goodsProcessor=" + goodsProcessor + ", goodsDisplaystorage="
				+ goodsDisplaystorage + ", goodsType=" + goodsType + ", goodsDisk=" + goodsDisk + ", goodsBigimage="
				+ goodsBigimage + ", goodsPack=" + goodsPack + ", createdUser=" + createdUser + ", createdTime="
				+ createdTime + ", modifiedUser=" + modifiedUser + ", modifiedTime=" + modifiedTime + "]";
	}
	
	
	
	


}
