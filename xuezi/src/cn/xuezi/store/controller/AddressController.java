package cn.xuezi.store.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xuezi.store.bean.Address;
import cn.xuezi.store.bean.ResponseResult;
import cn.xuezi.store.bean.User;
import cn.xuezi.store.mapper.AddressMapper;
import cn.xuezi.store.service.AddressService;

@Controller
@RequestMapping("/address")
public class AddressController {

	@Resource
	private AddressService addressService;

	@Resource
	private AddressMapper addressMapper;

	@RequestMapping("/showAddressAdmin.do")
	public String showAddressAdmin() {
		return "addressAdmin";
	}

	@RequestMapping("/saveAddress.do")
	@ResponseBody
	public ResponseResult<Void> saveAddress(HttpSession session, String receiverName, String receiverProvince,
			String receiverCity, String receiverCounty, String receiverAddress, String receiverMobile,
			String receiverPhone, String receiverZip, String addressName) {
		System.out.println("control");
		ResponseResult<Void> rr = new ResponseResult<Void>();
		User user = (User) session.getAttribute("user");
		Integer id = null;
		String username = null;
		if (user != null) {
			id = user.getId();
			username = user.getUsername();
		}
		Address address = new Address();
		address.setId(id);
		address.setAddressName(addressName);
		address.setCreatedTime(new Date());
		address.setCreatedUser(username);
		address.setModifiedTime(new Date());
		address.setModifiedUser(username);
		address.setReceiverAddress(receiverAddress);
		address.setReceiverCity(receiverCity);
		address.setReceiverCounty(receiverCounty);
		address.setReceiverMobile(receiverMobile);
		address.setReceiverName(receiverName);
		address.setReceiverPhone(receiverPhone);
		address.setReceiverProvince(receiverProvince);
		address.setReceiverStatus(0);
		address.setReceiverZip(receiverZip);
		try {
			addressService.SaveReceiver(address);
			System.out.println("1111111");
			rr.setState(1);
			rr.setMessage("收货地址保存成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			rr.setState(0);
			rr.setMessage(e.getMessage());
			// e.printStackTrace();
		}

		return rr;

	}

	@RequestMapping("/saveAddressList.do")
	public String saveAddressList(HttpSession session) {
		User user = (User) session.getAttribute("user");
		Integer id = null;
		if (user != null) {
			id = user.getId();
		}
		List<Address> addressList = addressMapper.selectAdressById(id);
		// System.out.println(addressList);
		session.setAttribute("addressList", addressList);
		return "redirect:../address/showAddressAdmin.do";
	}

	@RequestMapping("/deleteAddress.do")
	@ResponseBody
	public ResponseResult<Void> deleteAddress(String addressId, HttpSession session) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		User user = (User) session.getAttribute("user");
		Integer id = null;
		if (user != null) {
			id = user.getId();
		}
		try {
			addressService.deleteReceiver(id, Integer.valueOf(addressId));
			rr.setState(1);
			rr.setMessage("收货地址删除成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			rr.setState(0);
			rr.setMessage(e.getMessage());
			// e.printStackTrace();
		}
		return rr;
	}

	@RequestMapping("/updateAddress.do")
	public ResponseResult<Void> updateAddress(HttpSession session, Integer addressId, Integer receiverStatus) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		User user = (User) session.getAttribute("user");
		Integer id = null;
		if (user != null) {
			id = user.getId();
		}
		try {
			addressService.updateReceiverStatus(id, 0, 0);
			addressService.updateReceiverStatus(id, addressId, 1);
			rr.setState(1);
			rr.setMessage("修改默认状态成功");
		} catch (Exception e) {
			rr.setState(0);
			rr.setMessage(e.getMessage());
		}
		/*
		 * Address address=addressService.viewReceiver(id, addressId);
		 * session.setAttribute("address", address);
		 */
		return rr;
	}

	@RequestMapping("/showAddressdatil.do")
	public ResponseResult<Void> showAddressdatil(HttpSession session, Integer addressId) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		User user = (User) session.getAttribute("user");
		Integer id = null;
		if (user != null) {
			id = user.getId();
		}
		/*
		 * Address address=new Address(); address.setAddressName(addressName);
		 * address.setReceiverAddress(receiverAddress);
		 * address.setReceiverCity(receiverCity);
		 * address.setReceiverCounty(receiverCounty);
		 * address.setReceiverMobile(receiverMobile);
		 * address.setReceiverName(receiverName);
		 * address.setReceiverPhone(receiverPhone);
		 * address.setReceiverProvince(receiverProvince);
		 * address.setReceiverStatus(receiverStatus);
		 * address.setReceiverZip(receiverZip);
		 */
		try {
			// addressService.updateReceiverDatil(address);
			Address address1 = addressService.viewReceiver(id, addressId);
			session.setAttribute("address", address1);
			rr.setState(1);
			rr.setMessage("展示信息");
		} catch (Exception e) {
			rr.setState(0);
			rr.setMessage(e.getMessage());
		}
		return rr;
	}

}
