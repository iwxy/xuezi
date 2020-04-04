package cn.xuezi.store.mapper;

import java.util.List;

import cn.xuezi.store.bean.Address;

public interface AddressMapper {
	/**
	 * 保存收货地址
	 * @param user
	 */
	void insertAddress(Address address);
	/**
	 * 用戶ID查詢收貨地址
	 * @param id
	 * @return
	 */
	List<Address> selectAdressById(Integer id);
	/**
	 * 通過用戶id和addressId查询
	 * @param id
	 * @param addressId
	 * @return
	 */
	Address selectAdressByAddressId(Address address);
	/**
	 * 修改收货地址
	 * @param address
	 */
	void updateAddress(Address address);
	/**
	 * 删除收货地址
	 * @param address
	 */
	void deleteAddress(Address address);
	
	void updateAllAddressStatus(Integer id);
}
