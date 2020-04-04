package cn.xuezi.store.mapper;

import cn.xuezi.store.bean.User;

public interface UserMapper {
	/**
	 * 根据用户名查询用户信息
	 * 
	 * @param username
	 * @return
	 */
	User selectByUserByUsername(String username);

	/**
	 * 
	 * @param phone
	 * @return
	 */
	User selectByUserByPhone(String phone);

	/**
	 * 
	 * @param email
	 * @return
	 */
	User selectByUserByEmail(String email);

	/**
	 * 添加用户信息
	 * 
	 * @param user
	 */
	void insertUser(User user);

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 */
	void updateUser(User user);

	/**
	 * 
	 * @param id
	 * @return
	 */
	User selectUserById(Integer id);

	/**
	 * 验证密码
	 * 
	 * @param oldPwd
	 * @return
	 */
	User matchPassword(String oldPwd);

}
