package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.service.LoginService;
import com.web.vo.UserVO;


/** 
* @packageName : com.web.controller 
* @fileName : LoginController.java 
* @author : WooSin Kim
* @date : 2020.12.02 
* @description : 
* =========================================================== 
* DATE					AUTHOR					NOTE 
* ----------------------------------------------------------- 
* 2020.12.02			WooSin Kim				최초 생성 
*/
@Controller 
public class LoginController {
	
	@Autowired
    private LoginService loginService;
	
	
    /** 
    * 로그인 화면 메인
    * @methodName : loginForm 
    * @author : WooSin Kim
    * @date : 2020.12.02 
    * @param modelMap
    * @return 
    */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(ModelMap modelMap) {
    	
    	
        return "bo/user/login";
    }
    
    
    /** 
    * submit 로그인 폼
    * @methodName : submitLoginFrm 
    * @author : WooSin Kim
    * @date : 2020.12.02 
    * @param enquiryVO
    * @param modelMap
    * @return 
    */
    @RequestMapping(value = "/submitLoginFrm", method = RequestMethod.POST)
    @ResponseBody
    public String submitLoginFrm(@ModelAttribute UserVO userVO, ModelMap modelMap) {
    	
    	//로그인 체크 
    	if(loginService.checkUser(userVO)) {
    		
    		//세션에 로그인 정보 넣어주기(TODO)
    		
    		return "SUCCESS";
    	}else {
    		
    		return "FAIL";
    	}
   
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
}
