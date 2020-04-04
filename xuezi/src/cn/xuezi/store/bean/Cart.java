package cn.xuezi.store.bean;

import java.util.Date;

public class Cart {
		private Integer cartId;
		private Integer goodsId;
		private Integer Id;
		private Integer goodsNum;
		private Integer cartMoney;
		private String createdUser;
		private Date createdTime;
		private String modifiedUser;
		private Date modifiedTime;
		@Override
		public String toString() {
			return "Cart [cartId=" + cartId + ", goodsId=" + goodsId + ", Id=" + Id + ", goodsNum=" + goodsNum
					+ ", cartMoney=" + cartMoney + ", createdUser=" + createdUser + ", createdTime=" + createdTime
					+ ", modifiedUser=" + modifiedUser + ", modifiedTime=" + modifiedTime + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((Id == null) ? 0 : Id.hashCode());
			result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
			result = prime * result + ((cartMoney == null) ? 0 : cartMoney.hashCode());
			result = prime * result + ((createdTime == null) ? 0 : createdTime.hashCode());
			result = prime * result + ((createdUser == null) ? 0 : createdUser.hashCode());
			result = prime * result + ((goodsId == null) ? 0 : goodsId.hashCode());
			result = prime * result + ((goodsNum == null) ? 0 : goodsNum.hashCode());
			result = prime * result + ((modifiedTime == null) ? 0 : modifiedTime.hashCode());
			result = prime * result + ((modifiedUser == null) ? 0 : modifiedUser.hashCode());
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
			Cart other = (Cart) obj;
			if (Id == null) {
				if (other.Id != null)
					return false;
			} else if (!Id.equals(other.Id))
				return false;
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
			if (createdTime == null) {
				if (other.createdTime != null)
					return false;
			} else if (!createdTime.equals(other.createdTime))
				return false;
			if (createdUser == null) {
				if (other.createdUser != null)
					return false;
			} else if (!createdUser.equals(other.createdUser))
				return false;
			if (goodsId == null) {
				if (other.goodsId != null)
					return false;
			} else if (!goodsId.equals(other.goodsId))
				return false;
			if (goodsNum == null) {
				if (other.goodsNum != null)
					return false;
			} else if (!goodsNum.equals(other.goodsNum))
				return false;
			if (modifiedTime == null) {
				if (other.modifiedTime != null)
					return false;
			} else if (!modifiedTime.equals(other.modifiedTime))
				return false;
			if (modifiedUser == null) {
				if (other.modifiedUser != null)
					return false;
			} else if (!modifiedUser.equals(other.modifiedUser))
				return false;
			return true;
		}
		public Integer getCartId() {
			return cartId;
		}
		public void setCartId(Integer cartId) {
			this.cartId = cartId;
		}
		public Integer getGoodsId() {
			return goodsId;
		}
		public void setGoodsId(Integer goodsId) {
			this.goodsId = goodsId;
		}
		public Integer getId() {
			return Id;
		}
		public void setId(Integer id) {
			Id = id;
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
		
}
