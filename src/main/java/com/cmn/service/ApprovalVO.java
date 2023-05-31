package com.cmn.service;

public class ApprovalVO {
	
	private String id; // documentCode
	private String formClassifyCode;
	private String nowStep;
	private String documentStatus;
	private String totalStatus;
	private String contents;
	private String approvalLineDetail;
	private String employeeNumberDetail;
	private String title;
	private String attachmentPath;
	private String remark;
	private String writer;
	private String writerDept;
	private String writerRank;
	private String registrant;
	private String registDate;
	private String modifier;
	private String modifyDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFormClassifyCode() {
		return formClassifyCode;
	}
	public void setFormClassifyCode(String formClassifyCode) {
		this.formClassifyCode = formClassifyCode;
	}
	public String getNowStep() {
		return nowStep;
	}
	public void setNowStep(String nowStep) {
		this.nowStep = nowStep;
	}
	public String getDocumentStatus() {
		return documentStatus;
	}
	public void setDocumentStatus(String documentStatus) {
		this.documentStatus = documentStatus;
	}
	public String getTotalStatus() {
		return totalStatus;
	}
	public void setTotalStatus(String totalStatus) {
		this.totalStatus = totalStatus;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getApprovalLineDetail() {
		return approvalLineDetail;
	}
	public void setApprovalLineDetail(String approvalLineDetail) {
		this.approvalLineDetail = approvalLineDetail;
	}
	public String getEmployeeNumberDetail() {
		return employeeNumberDetail;
	}
	public void setEmployeeNumberDetail(String employeeNumberDetail) {
		this.employeeNumberDetail = employeeNumberDetail;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAttachmentPath() {
		return attachmentPath;
	}
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWriterDept() {
		return writerDept;
	}
	public void setWriterDept(String writerDept) {
		this.writerDept = writerDept;
	}
	public String getWriterRank() {
		return writerRank;
	}
	public void setWriterRank(String writerRank) {
		this.writerRank = writerRank;
	}
	public String getRegistrant() {
		return registrant;
	}
	public void setRegistrant(String registrant) {
		this.registrant = registrant;
	}
	public String getRegistDate() {
		return registDate;
	}
	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	@Override
	public String toString() {
		return "ApprovalVO [id=" + id + ", formClassifyCode=" + formClassifyCode + ", nowStep=" + nowStep
				+ ", documentStatus=" + documentStatus + ", totalStatus=" + totalStatus + ", contents=" + contents
				+ ", approvalLineDetail=" + approvalLineDetail + ", employeeNumberDetail=" + employeeNumberDetail
				+ ", title=" + title + ", attachmentPath=" + attachmentPath + ", remark=" + remark + ", writer="
				+ writer + ", writerDept=" + writerDept + ", writerRank=" + writerRank + ", registrant=" + registrant
				+ ", registDate=" + registDate + ", modifier=" + modifier + ", modifyDate=" + modifyDate + "]";
	}
	
}
