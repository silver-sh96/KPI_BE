package com.cmn.service;

public class ApprovalLineVO {
	
	private String id; //approvalLineNumber
	private String approvalLineName;
	private String approvalLineDetail;
	private String employeeNumberDetail;
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
	public String getApprovalLineName() {
		return approvalLineName;
	}
	public void setApprovalLineName(String approvalLineName) {
		this.approvalLineName = approvalLineName;
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
		return "ApprovalLineVO [id=" + id + ", approvalLineName=" + approvalLineName + ", approvalLineDetail="
				+ approvalLineDetail + ", employeeNumberDetail=" + employeeNumberDetail + ", registrant=" + registrant
				+ ", registDate=" + registDate + ", modifier=" + modifier + ", modifyDate=" + modifyDate + "]";
	}
	
	
}
