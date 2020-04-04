package cn.xuezi.store.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.xuezi.store.bean.ResponseResult;
import cn.xuezi.store.bean.User;
import cn.xuezi.store.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;

	/* =========================注册======================= */
	// 显示注册页面
	@RequestMapping("/showRegister.do")
	public String showRegister() {
		return "register";

	}

	/**
	 * 验证用户名是否已注册
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping("/checkUsername.do")
	@ResponseBody // 不经过视图解析
	public ResponseResult<Void> checkUsername(String username) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		boolean b = userService.checkByUserByUsername(username);
		if (b) {
			rr.setState(0);
			rr.setMessage("该用户名已存在");
		} else {
			rr.setState(1);
			rr.setMessage("用户名可以使用");
		}
		return rr;

	}

	/**
	 * 验证邮箱是否已存在
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping("/checkEmail.do")
	@ResponseBody // 不经过视图解析
	public ResponseResult<Void> checkEmail(String email) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		boolean b = userService.checkByUserByEmail(email);
		if (b) {
			rr.setState(0);
			rr.setMessage("该邮箱已被注册");
		} else {
			rr.setState(1);
			rr.setMessage("邮箱验证成功");
		}
		return rr;

	}

	/**
	 * 验证电话号码是否已存在
	 * 
	 * @param phone
	 * @return
	 */
	@RequestMapping("/checkPhone.do")
	@ResponseBody // 不经过视图解析
	public ResponseResult<Void> checkPhone(String phone) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		boolean b = userService.checkByUserByPhone(phone);
		if (b) {
			rr.setState(0);
			rr.setMessage("该电话号码已被注册");
		} else {
			rr.setState(1);
			rr.setMessage("电话号码验证成功");
		}
		return rr;

	}

	@RequestMapping("/register.do")
	@ResponseBody
	public ResponseResult<Void> register(@RequestParam("uname") String username, @RequestParam("upwd") String password,
			String email, String phone) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setGender(1);
		user.setImage("touxiang.png");
		user.setEmail(email);
		user.setPhone(phone);
		user.setCreatedUser(username);
		user.setCreatedTime(new Date());
		user.setModifiedUser(username);
		user.setModifiedTime(new Date());
		try {
			userService.register(user);
			rr.setState(1);
			rr.setMessage("注册成功");
		} catch (Exception e) {
			rr.setState(0);
			rr.setMessage(e.getMessage());
		}
		return rr;
	}

	/* =========================登陆======================= */
	// 显示登陆页面
	@RequestMapping("/showLogin.do")
	public String showLogin() {
		return "login";

	}

	@RequestMapping("/login.do")
	@ResponseBody // 不经过视图解析
	public ResponseResult<Void> login(String username, String password, HttpSession session) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		try {
			User user = userService.login(username, password);
			session.setAttribute("user", user);
			rr.setState(1);
			rr.setMessage("登陆成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			rr.setState(0);
			rr.setMessage(e.getMessage());
		}
		return rr;

	}

	/* ============================退出========================== */
	// 显示登陆页面
	@RequestMapping("/exit.do")
	public String exit(HttpSession session) {
		session.invalidate();

		return "redirect:../main/showIndex.do";

	}

	/* ============ 显示修改用户密码安全管理====================== */
	@RequestMapping("/showPersonal_password.do")
	public String showPersonal_password() {

		return "personal_password";

	}

	/* =======================修改用户密码====================== */
	// 修改用户密码
	@RequestMapping("/updatePassword.do")
	@ResponseBody // 不经过视图解析
	public ResponseResult<Void> updatePassword(HttpSession session, String oldPwd, String newPwd) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		User user = (User) session.getAttribute("user");
		Integer id = null;
		if (user != null) {
			id = user.getId();
		}
		try {
			userService.changePassword(id, oldPwd, newPwd);
			rr.setState(1);
			rr.setMessage("修改成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			rr.setState(0);
			rr.setMessage(e.getMessage());
		}
		return rr;
	}

	/**
	 * 验证用户名密码
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping("/checkOldPwd.do")
	@ResponseBody // 不经过视图解析
	public ResponseResult<Void> checkOldPwd(String oldPwd, HttpSession session) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		User user = (User) session.getAttribute("user");
		boolean b = false;
		if (oldPwd.equals(user.getPassword())) {
			b = true;
		}
		if (b) {
			rr.setState(0);
			rr.setMessage("密码验证成功");
		} else {
			rr.setState(1);
			rr.setMessage("密码验证失败");
		}
		return rr;

	}

	/* ==================我的信息==================== */
	@RequestMapping("/showPersonage.do")
	public String showPersonage() {
		return "personage";
	}

	/* ====================图像上传================ */
	@RequestMapping("/upload.do")
	@ResponseBody // 不经过视图解析
	public ResponseResult<Void> upload(@RequestParam("file") MultipartFile file, HttpSession session)
			throws IllegalStateException, IOException {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		// 获取服务器中的真实路径
		String path = session.getServletContext().getRealPath("/");
		// 上传文件
		System.out.println(path);
		file.transferTo(new File(path, "/upload/" + file.getOriginalFilename()));
		rr.setState(1);
		rr.setMessage("上传成功");
		return rr;

	}

	@RequestMapping("/updatePerson.do")
	@ResponseBody
	public ResponseResult<Void> updatePerson(HttpSession session, String image, String username, Integer gender,
			String phone, String email) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		User u = (User) session.getAttribute("user");
		User user = new User();
		user.setId(u.getId());
		user.setPassword(u.getPassword());
		user.setUsername(username);
		user.setEmail(email);
		user.setPhone(phone);
		user.setImage(image);
		user.setGender(gender);
		user.setCreatedTime(new Date());
		user.setCreatedUser(username);
		user.setModifiedTime(new Date());
		user.setModifiedUser(username);
		try {
			userService.changePerson(user);
			rr.setState(1);
			rr.setMessage("修改成功");
			session.setAttribute("user", user);
		} catch (Exception e) {
			rr.setState(0);
			rr.setMessage(e.getMessage());
			// e.printStackTrace();
		}
		return rr;
	}

}
