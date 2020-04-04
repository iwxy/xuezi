package cn.xuezi.store.service;

import cn.xuezi.store.bean.User;

public interface IUserService {
	/**
	 * 验证用户名是否存在
	 * 
	 * @param username
	 * @return
	 */
	boolean checkByUserByUsername(String username);

	/**
	 * 验证邮箱是否已存在
	 * 
	 * @param email
	 * @return
	 */
	boolean checkByUserByEmail(String email);

	/**
	 * 验证电话号码是否已存在
	 * 
	 * @param phone
	 * @return
	 */
	boolean checkByUserByPhone(String phone);

	/**
	 * 验证旧密码
	 * 
	 * @param oldPwd
	 * @return
	 */
	boolean checkOldPwd(String oldPwd);

	/**
	 * 注册用户信息
	 * 
	 * @param user
	 */
	void register(User user);

	/**
	 * 登陆验证
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	User login(String username, String password);

	/**
	 * 修改密码
	 * 
	 * @param id
	 * @param user
	 */
	void changePassword(Integer id, String oldPassword, String newPassword);

	void changePerson(User user);

	User selectUserById(Integer id);

}
