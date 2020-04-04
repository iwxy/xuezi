package cn.xuezi.store.dto;

public class CartList {
	private String goodsImage;
	private String goodsName;
	private String goodsStandard;
	private String goodsSystem;
	private String goodsColor;
	private Integer goodsMoney;
	private Integer goodsNum;
	private Integer cartMoney;
	private Integer cartId;
	
	@Override
	public String toString() {
		return "CartList [goodsImage=" + goodsImage + ", goodsName=" + goodsName + ", goodsStandard=" + goodsStandard
				+ ", goodsSystem=" + goodsSystem + ", goodsColor=" + goodsColor + ", goodsMoney=" + goodsMoney
				+ ", goodsNum=" + goodsNum + ", cartMoney=" + cartMoney + ", cartId=" + cartId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
		result = prime * result + ((cartMoney == null) ? 0 : cartMoney.hashCode());
		result = prime * result + ((goodsColor == null) ? 0 : goodsColor.hashCode());
		result = prime * result + ((goodsImage == null) ? 0 : goodsImage.hashCode());
		result = prime * result + ((goodsMoney == null) ? 0 : goodsMoney.hashCode());
		result = prime * result + ((goodsName == null) ? 0 : goodsName.hashCode());
		result = prime * result + ((goodsNum == null) ? 0 : goodsNum.hashCode());
		result = prime * result + ((goodsStandard == null) ? 0 : goodsStandard.hashCode());
		result = prime * result + ((goodsSystem == null) ? 0 : goodsSystem.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartList other = (CartList) obj;
		if (cartId == null) {
			if (other.cartId != null)
				return false;
		} else if (!cartId.equals(other.cartId))
			return false;
		if (cartMoney == null) {
			if (other.cartMoney != null)
				return false;
		} else if (!cartMoney.equals(other.cartMoney))
			return false;
		if (goodsColor == null) {
			if (other.goodsColor != null)
				return false;
		} else if (!goodsColor.equals(other.goodsColor))
			return false;
		if (goodsImage == null) {
			if (other.goodsImage != null)
				return false;
		} else if (!goodsImage.equals(other.goodsImage))
			return false;
		if (goodsMoney == null) {
			if (other.goodsMoney != null)
				return false;
		} else if (!goodsMoney.equals(other.goodsMoney))
			return false;
		if (goodsName == null) {
			if (other.goodsName != null)
				return false;
		} else if (!goodsName.equals(other.goodsName))
			return false;
		if (goodsNum == null) {
			if (other.goodsNum != null)
				return false;
		} else if (!goodsNum.equals(other.goodsNum))
			return false;
		if (goodsStandard == null) {
			if (other.goodsStandard != null)
				return false;
		} else if (!goodsStandard.equals(other.goodsStandard))
			return false;
		if (goodsSystem == null) {
			if (other.goodsSystem != null)
				return false;
		} else if (!goodsSystem.equals(other.goodsSystem))
			return false;
		return true;
	}
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
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
	public Integer getCartMoney() {
		return cartMoney;
	}
	public void setCartMoney(Integer cartMoney) {
		this.cartMoney = cartMoney;
	}
	
}
