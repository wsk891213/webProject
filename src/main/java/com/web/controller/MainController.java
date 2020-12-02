package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/** 
* @packageName : com.web.controller 
* @fileName : MainController.java 
* @author : WooSin Kim
* @date : 2020.12.01 
* @description : 
* =========================================================== 
* DATE					AUTHOR					NOTE 
* ----------------------------------------------------------- 
* 2020.12.01			WooSin Kim				최초 생성 
*/
@Controller 
public class MainController {

    /** 
    * 메인 페이지
    * @methodName : main 
    * @author : WooSin Kim
    * @date : 2020.12.01 
    * @param modelMap
    * @return 
    */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(ModelMap modelMap) {
    	
        return "fo/main/index";
    }
    
   
}
