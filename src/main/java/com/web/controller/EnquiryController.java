package com.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionException;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.service.EnquiryService;
import com.web.vo.EnquiryVO;

@Controller 
public class EnquiryController {
	
    @Autowired
    private EnquiryService enquiryService;
    
    private Logger logger = LogManager.getLogger(EnquiryController.class);
    
    /**
     * 문의 저장
     * @param enquiryVO
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/insertEnquiry")
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
