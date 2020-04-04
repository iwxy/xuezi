package cn.xuezi.store.bean;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
	private Integer orderId;
	private Integer id;
	private Integer goodsId;
	private Integer orderStatus;
	private Integer goodsNum;
	private Date orderTime;
	private Integer orderMoney;
	private String createdUser;
	private Date createdTime;
	private String modifiedUser;
	private Date modifiedTime;
	private Integer addressId;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Integer getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(Integer orderMoney) {
		this.orderMoney = orderMoney;
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

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", id=" + id + ", goodsId=" + goodsId + ", orderStatus=" + orderStatus
				+ ", goodsNum=" + goodsNum + ", orderTime=" + orderTime + ", orderMoney=" + orderMoney
				+ ", createdUser=" + createdUser + ", createdTime=" + createdTime + ", modifiedUser=" + modifiedUser
				+ ", modifiedTime=" + modifiedTime + ", addressId=" + addressId + "]";
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Integer orderId, Integer id, Integer goodsId, Integer orderStatus, Integer goodsNum, Date orderTime,
			Integer orderMoney, String createdUser, Date createdTime, String modifiedUser, Date modifiedTime,
			Integer addressId) {
		super();
		this.orderId = orderId;
		this.id = id;
		this.goodsId = goodsId;
		this.orderStatus = orderStatus;
		this.goodsNum = goodsNum;
		this.orderTime = orderTime;
		this.orderMoney = orderMoney;
		this.createdUser = createdUser;
		this.createdTime = createdTime;
		this.modifiedUser = modifiedUser;
		this.modifiedTime = modifiedTime;
		this.addressId = addressId;
	}

}
