package cn.edu.haust.yfy.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.haust.yfy.service.CommonService;

/**
 * 用户控制器
 * @author : WangDesen
 * */
@Controller
public class UserController {

	//private static Logger logger = Logger.getLogger(UserController.class.getName());

	@Resource(name = "CommonService")
	private CommonService commonService;

	
	
	/**
	 * 统计用户数量
	 * @param appID
	 * @param username
	 * */
	@RequestMapping("/count_user.do")
	@ResponseBody
	public Long countUser(){
//		String sql = "select count(1) from users where status = ?";
//		return commonService.countResult(sql, 1);
		return 88L;
	}
	
}
