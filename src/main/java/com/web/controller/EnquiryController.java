package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionException;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.service.EnquiryService;
import com.web.vo.EnquiryVO;


/** 
* @packageName : com.web.controller 
* @fileName : EnquiryController.java 
* @author : WooSin Kim
* @date : 2020.12.01 
* @description : 
* =========================================================== 
* DATE					AUTHOR					NOTE 
* ----------------------------------------------------------- 
* 2020.12.01			WooSin Kim				최초 생성 
*/
@Controller 
public class EnquiryController {
	
    @Autowired
    private EnquiryService enquiryService;
    
    /** 
    * 문의 저장
    * @methodName : insertEnquiry 
    * @author : WooSin Kim
    * @date : 2020.12.01 
    * @param enquiryVO
    * @param modelMap
    * @return 
    */
    @RequestMapping(value = "/insertEnquiry", method = RequestMethod.POST)
    @ResponseBody
    public String insertEnquiry(@ModelAttribute EnquiryVO enquiryVO, ModelMap modelMap) {
    	try {
    		
    		enquiryService.insertEnquiry(enquiryVO);
    		return "SUCCESS";
    		
		} catch (TransactionException ex) {
			
			return "FAIL";
		}
        
    }
    
   
}
