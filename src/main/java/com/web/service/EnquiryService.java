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

@Service
public class EnquiryService {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
    private DataSourceTransactionManager txManager;
	
	private Logger logger = LogManager.getLogger(EnquiryService.class);

	/**
	 * 문의 저장
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
			System.out.println("데이터 저장 오류: " + ex.toString());
		}
		
	}
	
	/*
	 * public BoardVO selectBoardOne(String param) { return
	 * sqlSession.selectOne("selectBoard8One", param); }
	 * 
	 * public void updateBoard8Read(String param) {
	 * sqlSession.insert("updateBoard8Read", param); }
	 * 
	 * public void deleteBoardOne(String param) {
	 * sqlSession.delete("deleteBoard8One", param); }
	 * 
	 * public List<?> selectBoard8FileList(String param) { return
	 * sqlSession.selectList("selectBoard8FileList", param); }
	 * 
	 * =============================================================== public
	 * List<?> selectBoard8ReplyList(String param) { return
	 * sqlSession.selectList("selectBoard8ReplyList", param); }
	 * 
	 *//**
		 * 댓글 저장.
		 */
	/*
	 * public void insertBoardReply(BoardReplyVO param) { if (param.getReno() ==
	 * null || "".equals(param.getReno())) { if (param.getReparent() != null) {
	 * BoardReplyVO replyInfo = sqlSession.selectOne("selectBoard8ReplyParent",
	 * param.getReparent()); param.setRedepth(replyInfo.getRedepth());
	 * param.setReorder(replyInfo.getReorder() + 1);
	 * sqlSession.selectOne("updateBoard8ReplyOrder", replyInfo); } else { Integer
	 * reorder = sqlSession.selectOne("selectBoard8ReplyMaxOrder",
	 * param.getBrdno()); param.setReorder(reorder); }
	 * 
	 * sqlSession.insert("insertBoard8Reply", param); } else {
	 * sqlSession.insert("updateBoard8Reply", param); } }
	 * 
	 *//**
		 * 댓글 삭제. 자식 댓글이 있으면 삭제 안됨.
		 *//*
			 * public boolean deleteBoard8Reply(String param) { Integer cnt =
			 * sqlSession.selectOne("selectBoard8ReplyChild", param);
			 * 
			 * if ( cnt > 0) { return false; }
			 * 
			 * sqlSession.update("updateBoard8ReplyOrder4Delete", param);
			 * 
			 * sqlSession.delete("deleteBoard8Reply", param);
			 * 
			 * return true; }
			 */
}
