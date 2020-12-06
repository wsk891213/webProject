package com.web.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.web.vo.UserVO;

/** 
* @packageName : com.web.service 
* @fileName : LoginService.java 
* @author : WooSin Kim
* @date : 2020.12.02 
* @description : 
* =========================================================== 
* DATE					AUTHOR					NOTE 
* ----------------------------------------------------------- 
* 2020.12.02			WooSin Kim				최초 생성 
*/
@Service
public class LoginService {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
    private DataSourceTransactionManager txManager;
	

	/** 
	* 로그인 체크
	* @methodName : checkUser 
	* @author : WooSin Kim
	* @date : 2020.12.02 
	* @param userVO 
	*/
	public Boolean checkUser(UserVO userVO) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = txManager.getTransaction(def);
		
		try {
			//해당 로그인 정보를 가진 유저가 있는지 확인
			int userCheck = sqlSession.selectOne("selectOneUser", userVO);
						
			if(userCheck > 0) {
				//해당 유저 있음
				return true;
			}else {
				//해당 유저 없음
				return false;
			}
			
		} catch (TransactionException ex) {
			return false;
		}
		
	}
	
	
	public Boolean checkIDifExist(UserVO userVO) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = txManager.getTransaction(def);
		
		try {
			//해당 로그인 정보를 가진 유저가 있는지 확인
			int userCheck = sqlSession.selectOne("checkIDifExist", userVO);
						
			if(userCheck > 0) {
				//해당 유저 있음
				return true;
			}else {
				//해당 유저 없음
				return false;
			}
			
		} catch (TransactionException ex) {
			return false;
		}
		
	}
}
