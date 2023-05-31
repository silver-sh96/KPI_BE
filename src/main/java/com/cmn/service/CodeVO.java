package com.cmn.service;

public class CodeVO {
	
	private String COMMON_CODE ;
	private String id ;
	private String PERIOD ;
	private String UPPER_COMMON_CODE;
	private String CODE_NAME;
	private String CODE_DESCRIPTION;
	private String USE_YN;
	private String DELETE_YN;
	private String REGISTRANT;
	private String REGIST_DATE;
	private String MODIFIER;
	private String MODIFY_DATE;
	private String REF1;
	
	private String searchKey;
	private String searchValue; 
	
	private String nowdate;
	
	public String getREF1() {
		return REF1;
	}
	public void setREF1(String rEF1) {
		REF1 = rEF1;
	}
	public String getNowdate() {
		return nowdate;
	}
	public void setNowdate(String nowdate) {
		this.nowdate = nowdate;
	}
	public String getPERIOD() {
		return PERIOD;
	}
	public void setPERIOD(String pERIOD) {
		PERIOD = pERIOD;
	}
	public String getCOMMON_CODE() {
		return COMMON_CODE;
	}
	public void setCOMMON_CODE(String cOMMON_CODE) {
		COMMON_CODE = cOMMON_CODE;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUPPER_COMMON_CODE() {
		return UPPER_COMMON_CODE;
	}
	public void setUPPER_COMMON_CODE(String uPPER_COMMON_CODE) {
		UPPER_COMMON_CODE = uPPER_COMMON_CODE;
	}
	public String getCODE_NAME() {
		return CODE_NAME;
	}
	public void setCODE_NAME(String cODE_NAME) {
		CODE_NAME = cODE_NAME;
	}
	public String getCODE_DESCRIPTION() {
		return CODE_DESCRIPTION;
	}
	public void setCODE_DESCRIPTION(String cODE_DESCRIPTION) {
		CODE_DESCRIPTION = cODE_DESCRIPTION;
	}
	public String getUSE_YN() {
		return USE_YN;
	}
	public void setUSE_YN(String uSE_YN) {
		USE_YN = uSE_YN;
	}
	public String getDELETE_YN() {
		return DELETE_YN;
	}
	public void setDELETE_YN(String dELETE_YN) {
		DELETE_YN = dELETE_YN;
	}
	public String getREGISTRANT() {
		return REGISTRANT;
	}
	public void setREGISTRANT(String rEGISTRANT) {
		REGISTRANT = rEGISTRANT;
	}
	public String getREGIST_DATE() {
		return REGIST_DATE;
	}
	public void setREGIST_DATE(String rEGIST_DATE) {
		REGIST_DATE = rEGIST_DATE;
	}
	public String getMODIFIER() {
		return MODIFIER;
	}
	public void setMODIFIER(String mODIFIER) {
		MODIFIER = mODIFIER;
	}
	public String getMODIFY_DATE() {
		return MODIFY_DATE;
	}
	public void setMODIFY_DATE(String mODIFY_DATE) {
		MODIFY_DATE = mODIFY_DATE;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	
	
	
}