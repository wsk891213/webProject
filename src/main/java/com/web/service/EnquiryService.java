package com.web.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.StringUtils;

import com.web.vo.EnquiryVO;

/** 
* @packageName : com.web.service 
* @fileName : EnquiryService.java 
* @author : WooSin Kim
* @date : 2020.12.02 
* @description : 
* =========================================================== 
* DATE					AUTHOR					NOTE 
* ----------------------------------------------------------- 
* 2020.12.02			WooSin Kim				최초 생성 
*/
@Service
public class EnquiryService {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
    private DataSourceTransactionManager txManager;
	
	private Logger logger = LogManager.getLogger(EnquiryService.class);

	/** 
	* 문의 저장
	* @methodName : insertEnquiry 
	* @author : WooSin Kim
	* @date : 2020.12.02 
	* @param enquiryVO 
	*/
	public void insertEnquiry(EnquiryVO enquiryVO) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = txManager.getTransaction(def);
		
		try {
			if (StringUtils.isEmpty(enquiryVO.getCreatdDate())) {
				sqlSession.insert("insertEnquiry", enquiryVO);
				
				txManager.commit(status);
			} else {
				sqlSession.update("updateEnquiry", enquiryVO);
			}
			
		} catch (TransactionException ex) {
			txManager.rollback(status);
		}
		
	}
	
}
