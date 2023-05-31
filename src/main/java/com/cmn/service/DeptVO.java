package com.cmn.service;

public class DeptVO {
	
	private String deptCode;
	private String upperDeptCode;
	private String deptName;
	private String remarks;
	private String period;
	private String workValue;
	private String useYN;
	private String deleteYN;
	private String registrant;
	private String registDate;
	private String modifier;
	private String modifyDate;
	
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getUpperDeptCode() {
		return upperDeptCode;
	}
	public void setUpperDeptCode(String upperDeptCode) {
		this.upperDeptCode = upperDeptCode;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getWorkValue() {
		return workValue;
	}
	public void setWorkValue(String workValue) {
		this.workValue = workValue;
	}
	public String getUseYN() {
		return useYN;
	}
	public void setUseYN(String useYN) {
		this.useYN = useYN;
	}
	public String getDeleteYn() {
		return deleteYN;
	}
	public void setDeleteYn(String deleteYN) {
		this.deleteYN = deleteYN;
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
		return "DeptVO [deptCode=" + deptCode + ", upperDeptCode=" + upperDeptCode + ", deptName=" + deptName
				+ ", remarks=" + remarks + ", period=" + period + ", workValue=" + workValue + ", useYN=" + useYN
				+ ", deleteYN=" + deleteYN + ", registrant=" + registrant + ", registDate=" + registDate + ", modifier="
				+ modifier + ", modifyDate=" + modifyDate + "]";
	}
	

}
