package cn.xuezi.store.dto;

public class OrderList {

	private String goodsImage;
	private String goodsName;
	private String goodsStandard;
	private String goodsSystem;
	private String goodsColor;
	private Integer goodsMoney;
	private Integer goodsNum;
	private String orderTime;
	private Integer orderId;
	private Integer orderStatus;
	private Integer addressId;

	public String getGoodsImage() {
		return goodsImage;
	}

	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsStandard() {
		return goodsStandard;
	}

	public void setGoodsStandard(String goodsStandard) {
		this.goodsStandard = goodsStandard;
	}

	public String getGoodsSystem() {
		return goodsSystem;
	}

	public void setGoodsSystem(String goodsSystem) {
		this.goodsSystem = goodsSystem;
	}

	public String getGoodsColor() {
		return goodsColor;
	}

	public void setGoodsColor(String goodsColor) {
		this.goodsColor = goodsColor;
	}

	public Integer getGoodsMoney() {
		return goodsMoney;
	}

	public void setGoodsMoney(Integer goodsMoney) {
		this.goodsMoney = goodsMoney;
	}

	public Integer getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	@Override
	public String toString() {
		return "OrderList [goodsImage=" + goodsImage + ", goodsName=" + goodsName + ", goodsStandard=" + goodsStandard
				+ ", goodsSystem=" + goodsSystem + ", goodsColor=" + goodsColor + ", goodsMoney=" + goodsMoney
				+ ", goodsNum=" + goodsNum + ", orderTime=" + orderTime + ", orderId=" + orderId + ", orderStatus="
				+ orderStatus + ", addressId=" + addressId + "]";
	}

	public OrderList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderList(String goodsImage, String goodsName, String goodsStandard, String goodsSystem, String goodsColor,
			Integer goodsMoney, Integer goodsNum, String orderTime, Integer orderId, Integer orderStatus,
			Integer addressId) {
		super();
		this.goodsImage = goodsImage;
		this.goodsName = goodsName;
		this.goodsStandard = goodsStandard;
		this.goodsSystem = goodsSystem;
		this.goodsColor = goodsColor;
		this.goodsMoney = goodsMoney;
		this.goodsNum = goodsNum;
		this.orderTime = orderTime;
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.addressId = addressId;
	}

}
