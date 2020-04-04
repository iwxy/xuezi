package cn.xuezi.store.bean;

import java.io.Serializable;
import java.util.Date;

public class Address implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer addressId;
	private Integer Id;
	private String receiverName;
	private String receiverProvince;
	private String receiverCity;
	private String receiverCounty;
	private String receiverAddress;
	private String receiverMobile;
	private String receiverPhone;
	private String receiverZip;
	private String addressName;
	private Integer receiverStatus;
	private String createdUser;
	private Date createdTime;
	private String modifiedUser;
	private Date modifiedTime;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result + ((addressName == null) ? 0 : addressName.hashCode());
		result = prime * result + ((createdTime == null) ? 0 : createdTime.hashCode());
		result = prime * result + ((createdUser == null) ? 0 : createdUser.hashCode());
		result = prime * result + ((modifiedTime == null) ? 0 : modifiedTime.hashCode());
		result = prime * result + ((modifiedUser == null) ? 0 : modifiedUser.hashCode());
		result = prime * result + ((receiverAddress == null) ? 0 : receiverAddress.hashCode());
		result = prime * result + ((receiverCity == null) ? 0 : receiverCity.hashCode());
		result = prime * result + ((receiverCounty == null) ? 0 : receiverCounty.hashCode());
		result = prime * result + ((receiverMobile == null) ? 0 : receiverMobile.hashCode());
		result = prime * result + ((receiverName == null) ? 0 : receiverName.hashCode());
		result = prime * result + ((receiverPhone == null) ? 0 : receiverPhone.hashCode());
		result = prime * result + ((receiverProvince == null) ? 0 : receiverProvince.hashCode());
		result = prime * result + ((receiverStatus == null) ? 0 : receiverStatus.hashCode());
		result = prime * result + ((receiverZip == null) ? 0 : receiverZip.hashCode());
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
		Address other = (Address) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (addressName == null) {
			if (other.addressName != null)
				return false;
		} else if (!addressName.equals(other.addressName))
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
		if (receiverAddress == null) {
			if (other.receiverAddress != null)
				return false;
		} else if (!receiverAddress.equals(other.receiverAddress))
			return false;
		if (receiverCity == null) {
			if (other.receiverCity != null)
				return false;
		} else if (!receiverCity.equals(other.receiverCity))
			return false;
		if (receiverCounty == null) {
			if (other.receiverCounty != null)
				return false;
		} else if (!receiverCounty.equals(other.receiverCounty))
			return false;
		if (receiverMobile == null) {
			if (other.receiverMobile != null)
				return false;
		} else if (!receiverMobile.equals(other.receiverMobile))
			return false;
		if (receiverName == null) {
			if (other.receiverName != null)
				return false;
		} else if (!receiverName.equals(other.receiverName))
			return false;
		if (receiverPhone == null) {
			if (other.receiverPhone != null)
				return false;
		} else if (!receiverPhone.equals(other.receiverPhone))
			return false;
		if (receiverProvince == null) {
			if (other.receiverProvince != null)
				return false;
		} else if (!receiverProvince.equals(other.receiverProvince))
			return false;
		if (receiverStatus == null) {
			if (other.receiverStatus != null)
				return false;
		} else if (!receiverStatus.equals(other.receiverStatus))
			return false;
		if (receiverZip == null) {
			if (other.receiverZip != null)
				return false;
		} else if (!receiverZip.equals(other.receiverZip))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", Id=" + Id + ", receiverName=" + receiverName
				+ ", receiverProvince=" + receiverProvince + ", receiverCity=" + receiverCity + ", receiverCounty="
				+ receiverCounty + ", receiverAddress=" + receiverAddress + ", receiverMobile=" + receiverMobile
				+ ", receiverPhone=" + receiverPhone + ", receiverZip=" + receiverZip + ", addressName=" + addressName
				+ ", receiverStatus=" + receiverStatus + ", createdUser=" + createdUser + ", createdTime=" + createdTime
				+ ", modifiedUser=" + modifiedUser + ", modifiedTime=" + modifiedTime + "]";
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverProvince() {
		return receiverProvince;
	}
	public void setReceiverProvince(String receiverProvince) {
		this.receiverProvince = receiverProvince;
	}
	public String getReceiverCity() {
		return receiverCity;
	}
	public void setReceiverCity(String receiverCity) {
		this.receiverCity = receiverCity;
	}
	public String getReceiverCounty() {
		return receiverCounty;
	}
	public void setReceiverCounty(String receiverCounty) {
		this.receiverCounty = receiverCounty;
	}
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public String getReceiverMobile() {
		return receiverMobile;
	}
	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public String getReceiverZip() {
		return receiverZip;
	}
	public void setReceiverZip(String receiverZip) {
		this.receiverZip = receiverZip;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public Integer getReceiverStatus() {
		return receiverStatus;
	}
	public void setReceiverStatus(Integer receiverStatus) {
		this.receiverStatus = receiverStatus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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
