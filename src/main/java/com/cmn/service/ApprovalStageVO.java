package com.cmn.service;

public class ApprovalStageVO {
	
	private String id; //DOCUMENT_CODE
	private String approval;
	private String approvalName;
	private String approvalRank;
	private String nowStep;
	private String approvalResult;
	private String approvalStep;
	private String approvalDate;
	private String opinion;
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
	public String getApproval() {
		return approval;
	}
	public void setApproval(String approval) {
		this.approval = approval;
	}
	public String getApprovalName() {
		return approvalName;
	}
	public void setApprovalName(String approvalName) {
		this.approvalName = approvalName;
	}
	public String getApprovalRank() {
		return approvalRank;
	}
	public void setApprovalRank(String approvalRank) {
		this.approvalRank = approvalRank;
	}
	public String getNowStep() {
		return nowStep;
	}
	public void setNowStep(String nowStep) {
		this.nowStep = nowStep;
	}
	public String getApprovalResult() {
		return approvalResult;
	}
	public void setApprovalResult(String approvalResult) {
		this.approvalResult = approvalResult;
	}
	public String getApprovalStep() {
		return approvalStep;
	}
	public void setApprovalStep(String approvalStep) {
		this.approvalStep = approvalStep;
	}
	public String getApprovalDate() {
		return approvalDate;
	}
	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
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
		return "ApprovalStageVO [id=" + id + ", approval=" + approval + ", approvalName=" + approvalName
				+ ", approvalRank=" + approvalRank + ", nowStep=" + nowStep + ", approvalResult=" + approvalResult
				+ ", approvalStep=" + approvalStep + ", approvalDate=" + approvalDate + ", opinion=" + opinion
				+ ", registrant=" + registrant + ", registDate=" + registDate + ", modifier=" + modifier
				+ ", modifyDate=" + modifyDate + "]";
	}
	
}
