package com.web.vo;

import java.time.LocalDateTime;

/**
 * 문의VO
 * @author user
 *
 */
public class EnquiryVO {

    private int enquirySeq;
    private LocalDateTime creatdDate;
    private String subject; 
    private String contents;
    private String name;
    private String emailAddr;
    private Boolean replyYN;
    
    
	public int getEnquirySeq() {
		return enquirySeq;
	}
	public void setEnquirySeq(int enquirySeq) {
		this.enquirySeq = enquirySeq;
	}
	public LocalDateTime getCreatdDate() {
		return creatdDate;
	}
	public void setCreatdDate(LocalDateTime creatdDate) {
		this.creatdDate = creatdDate;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailAddr() {
		return emailAddr;
	}
	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}
	public Boolean getReplyYN() {
		return replyYN;
	}
	public void setReplyYN(Boolean replyYN) {
		this.replyYN = replyYN;
	}
    
}
