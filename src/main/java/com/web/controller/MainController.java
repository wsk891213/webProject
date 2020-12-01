package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class MainController {

	/**
	 * 메인 페이지
	 * @param modelMap
	 * @return
	 */
    @RequestMapping(value = "/")
    public String main(ModelMap modelMap) {
        return "main/main";
    }
    
   
}
