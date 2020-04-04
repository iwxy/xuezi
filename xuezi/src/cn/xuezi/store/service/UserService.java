package cn.xuezi.store.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xuezi.store.bean.User;
import cn.xuezi.store.mapper.UserMapper;
import cn.xuezi.store.service.ex.PasswordNotFoundException;
import cn.xuezi.store.service.ex.UserNotFoundException;
import cn.xuezi.store.service.ex.UsernameAlreadyExistException;

@Service
public class UserService implements IUserService {

	@Resource(name = "userMapper")
	private UserMapper userMapper;

	/**
	 * 验证用户名是否已存在
	 */
	@Override
	public boolean checkByUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userMapper.selectByUserByUsername(username) != null;
	}

	/**
	 * 验证邮箱是否已存在
	 */
	@Override
	public boolean checkByUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userMapper.selectByUserByEmail(email) != null;
	}

	/**
	 * 验证电话号码是否已存在
	 */
	@Override
	public boolean checkByUserByPhone(String phone) {
		// TODO Auto-generated method stub
		return userMapper.selectByUserByPhone(phone) != null;
	}

	/**
	 * 验证用户旧密码
	 */
	@Override
	public boolean checkOldPwd(String oldPwd) {
		// TODO Auto-generated method stub
		return userMapper.matchPassword(oldPwd) != null;
	}

	/**
	 * 注册用户信息
	 */
	@Override
	public void register(User user) {
		// 调用持久层selectByUserByUsername是否存在
		User user1 = userMapper.selectByUserByUsername(user.getUsername());
		// 如果用户不存在
		if (user1 == null) {
			// 调用insertUser向数据库中插入数据
			userMapper.insertUser(user);
		} else {
			// 抛出异常
			throw new UsernameAlreadyExistException("用户名已存在");
		}

	}

	/**
	 * 登陆
	 */
	@Override
	public User login(String username, String password) {
		User user = userMapper.selectByUserByUsername(username);
		if (user == null) {
			throw new UserNotFoundException("用户名不存在");
		} else {
			if (user.getPassword().equals(password)) {
				return user;
			} else {
				throw new PasswordNotFoundException("密码不匹配");
			}
		}

	}

	/**
	 * 修改密码
	 */
	@Override
	public void changePassword(Integer id, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		User user = userMapper.selectUserById(id);
		if (user == null) {
			throw new UserNotFoundException("用户名不存在");
		} else {
			if (user.getPassword().equals(oldPassword)) {
				// 修改密码
				User user1 = new User();
				user1.setId(id);
				user1.setPassword(newPassword);
				user1.setModifiedTime(new Date());
				userMapper.updateUser(user1);
			} else {
				// 密码比对不成功
				throw new PasswordNotFoundException("旧密码不匹配");
			}
		}

	}

	@Override
	public void changePerson(User user) {
		// TODO Auto-generated method stub
		userMapper.updateUser(user);
	}

	@Override
	public User selectUserById(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectUserById(id);

	}

}
