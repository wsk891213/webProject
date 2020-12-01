package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


/** 
* @packageName : com.web.controller 
* @fileName : AdminController.java 
* @author : WooSin Kim
* @date : 2020.12.01 
* @description : 
* =========================================================== 
* DATE					AUTHOR					NOTE 
* ----------------------------------------------------------- 
* 2020.12.01			WooSin Kim				최초 생성 
*/
@Controller 
public class AdminController {
	
//    @Autowired
//    private EnquiryService enquiryService;
    
	
    /** 
    * 관리자 페이지 메인
    * @methodName : main 
    * @author : WooSin Kim
    * @date : 2020.12.01 
    * @param modelMap
    * @return 
    */
    @RequestMapping(value = "/admin")
    public String main(ModelMap modelMap) {
        return "bo/index/index";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
}
