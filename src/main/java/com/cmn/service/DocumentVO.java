package com.cmn.service;

public class DocumentVO {
	
	private String id; //formCode
	private String documentVerifyCode;
	private String formName;
	private String formSrc;
	private String useYN;
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
	public String getDocumentVerifyCode() {
		return documentVerifyCode;
	}
	public void setDocumentVerifyCode(String documentVerifyCode) {
		this.documentVerifyCode = documentVerifyCode;
	}
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public String getFormSrc() {
		return formSrc;
	}
	public void setFormSrc(String formSrc) {
		this.formSrc = formSrc;
	}
	public String getUseYN() {
		return useYN;
	}
	public void setUseYN(String useYN) {
		this.useYN = useYN;
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
		return "DocumentVO [id=" + id + ", documentVerifyCode=" + documentVerifyCode + ", formName=" + formName
				+ ", formSrc=" + formSrc + ", useYN=" + useYN + ", registrant=" + registrant + ", registDate="
				+ registDate + ", modifier=" + modifier + ", modifyDate=" + modifyDate + "]";
	}
	
}
