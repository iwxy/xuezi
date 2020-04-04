package cn.xuezi.store.service;

import cn.xuezi.store.bean.Address;

public interface IAddressService {
	/**
	 * 保存收货地址
	 * @param address
	 */
	void SaveReceiver(Address address);
	/**
	 * 点击修改后显示在页面
	 * @param id
	 * @param addressId
	 */
	Address viewReceiver(Integer id,Integer addressId);
	void deleteReceiver(Integer id,Integer addressId);
	void updateReceiverStatus(Integer id,Integer addressId,Integer receiverStatus);
	void updateReceiverDatil(Address address);
}
