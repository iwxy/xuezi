package cn.xuezi.store.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xuezi.store.bean.Address;
import cn.xuezi.store.bean.User;
import cn.xuezi.store.mapper.AddressMapper;
import cn.xuezi.store.mapper.UserMapper;

@Service
public class AddressService implements IAddressService {
	@Resource
	private AddressMapper addressMapper;
	@Resource
	private UserMapper userMapper;

	/**
	 * 保存收货地址
	 */
	@Override
	public void SaveReceiver(Address address) {
		// TODO Auto-generated method stub
		// Address address1=addressMapper.selectAdressByAddressId(address);
		// if(address1==null) {
		System.out.println("service....");
		addressMapper.insertAddress(address);
		System.out.println("service");
		// }else {
		// 抛异常
		// }
	}

	/**
	 * 显示收货地址
	 */
	@Override
	public Address viewReceiver(Integer id, Integer addressId) {
		// TODO Auto-generated method stub
		Address address = new Address();
		address.setAddressId(addressId);
		address.setId(id);
		Address address1 = addressMapper.selectAdressByAddressId(address);
		if (address1 != null) {
			// return address1;
		} else {
			// 抛异常
		}
		return address1;
	}

	/**
	 * 删除收货地址
	 */
	@Override
	public void deleteReceiver(Integer id, Integer addressId) {
		// TODO Auto-generated method stub
		Address address = new Address();
		address.setAddressId(addressId);
		address.setId(id);
		Address address1 = addressMapper.selectAdressByAddressId(address);
		if (address1 != null) {
			addressMapper.deleteAddress(address1);
		} else {
			// 抛异常
		}
	}

	/**
	 * 更改收货地址状态
	 */
	@Override
	public void updateReceiverStatus(Integer id, Integer addressId, Integer receiverStatus) {
		// TODO Auto-generated method stub
		if (addressId == 0) {
			addressMapper.updateAllAddressStatus(id);
		}
		User user = userMapper.selectUserById(id);
		Address address = new Address();
		address.setAddressId(addressId);
		address.setId(id);
		Address address1 = addressMapper.selectAdressByAddressId(address);
		if (address1 != null) {
			address1.setReceiverStatus(receiverStatus);
			address1.setModifiedUser(user.getUsername());
			address1.setModifiedTime(new Date());
			addressMapper.updateAddress(address1);
		} else {
			// 抛异常
		}

	}

	/**
	 * 更新收货地址
	 */
	@Override
	public void updateReceiverDatil(Address address) {
		// TODO Auto-generated method stub
		User user = userMapper.selectUserById(address.getId());
		Address address1 = new Address();
		address1.setId(address.getId());
		address1.setAddressId(address.getAddressId());
		Address address2 = addressMapper.selectAdressByAddressId(address);
		if (address2 != null) {
			address1.setModifiedUser(user.getUsername());
			address1.setModifiedTime(new Date());
			addressMapper.updateAddress(address2);
		} else {
			// 抛异常
		}
	}

}
