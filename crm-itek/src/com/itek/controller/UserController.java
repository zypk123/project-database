package com.itek.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itek.entity.PageBean;
import com.itek.entity.User;
import com.itek.service.UserService;
import com.itek.util.ResponseUtil;
import com.itek.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 用户user控制器
 * 
 * @author zhangyu
 * @date 2016年8月24日
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService; // 引入service

	/**
	 * 用户登陆
	 * 
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String login(User user, HttpServletRequest request) {
		User resultUser = userService.login(user);
		if (resultUser == null) {
			request.setAttribute("user", user); // 保存用户输入信息，用来回显数据
			request.setAttribute("errorMsg", "您的信息输入有误，请重新输入!");// 保存错误信息到request，传递到前台显示
			return "login";// 重新回到登陆界面
		} else {
			// 登陆成功，创建session，把用户信息保存到session中
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", resultUser);
			return "redirect:/main.jsp"; // 重定向到主界面
		}
	}

	/**
	 * 查询用户列表
	 * 
	 * @param page
	 *            页面
	 * @param rows
	 * @param s_user
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public void list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, User s_user, HttpServletResponse response)
			throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", StringUtil.formatLike(s_user.getUserName())); // 模糊查询，前后加"%"
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<User> userList = userService.find(map);
		Long total = userService.getTotal(map);
		JSONObject result = new JSONObject(); // json对象
		JSONArray jsonArray = JSONArray.fromObject(userList);// 将list集合转化成json数组
		result.put("rows", jsonArray);// 将json数组放到jsonObject
		result.put("total", total);// 传递记录总数total到jsonObject
		ResponseUtil.write(response, result);// 将jsonObject写到前台response
	}

	/**
	 * 保存用户数据,用于新增和修改后保存数据
	 * 
	 * @param user
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(User user, HttpServletResponse response) throws Exception {
		int resultTotal = 0; // 影响的记录数
		if (user.getId() == null) { // 没有id，说明是添加
			resultTotal = userService.add(user); // 添加保存
		} else {
			resultTotal = userService.update(user);// 修改保存
		}
		JSONObject result = new JSONObject();
		if (resultTotal > 0) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		ResponseUtil.write(response, result); // 把jsonObject对象写到前台页面
	}

	/**
	 * 删除用户信息
	 * 
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value = "ids") String ids, HttpServletResponse response) throws Exception {
		String[] idsStr = ids.split(","); // 逗号分隔前台传来的id字符串数组
		for (int i = 0; i < idsStr.length; i++) {
			userService.delete(Integer.parseInt(idsStr[i]));
		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}

	/**
	 * 用户密码修改
	 * 
	 * @param id
	 * @param newPassword
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/modifyPassword")
	public void modifyPassword(Integer id, String newPassword, HttpServletResponse response) throws Exception {
		User user = new User();
		user.setId(id);
		user.setPassword(newPassword);
		int resultTotal = userService.update(user);
		JSONObject result = new JSONObject();
		if (resultTotal > 0) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
	}

	/**
	 * 用户安全退出 清除session
	 * 
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate(); // 清除session
		return "redirect:/login.jsp";// 重定向到登陆页面
	}

	/**
	 * 用户选择下拉列表初始化
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/customerManagerComboList")
	public void customerManagerComboList(HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roleName", "客户经理"); // 业务规定：只允许客户经理才可以被指派营销机会
		List<User> userList = userService.find(map);
		JSONArray row = JSONArray.fromObject(userList);
		ResponseUtil.write(response, row);
	}

}
