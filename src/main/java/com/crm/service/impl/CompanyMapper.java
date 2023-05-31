package com.crm.service.impl;

import java.util.List;

import com.crm.service.ChargesVO;
import com.crm.service.CompanyVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("CompanyMapper")
public interface CompanyMapper {
	List<CompanyVO> selectComList(CompanyVO comVo);

	CompanyVO ComDetail(CompanyVO comVo);

	List<ChargesVO> ComCharges(CompanyVO comVo);

	int ComRegi(CompanyVO comVo);

	int ComEdit(CompanyVO comVo);

	int ComDel(CompanyVO comVo);

	int ComDelChargesAll(CompanyVO comVo);

	int SQDrop(CompanyVO comVo);

	int ChargeEdit(ChargesVO charVo);

	CompanyVO SQCompCode(CompanyVO comVo);

	ChargesVO SQCompView(ChargesVO charVo);

	CompanyVO SQCompDel(CompanyVO comVo);

	void SQComp(ChargesVO charVo);

	int ChargeRegi(ChargesVO charVo);

	int ChargeDel(ChargesVO charVo);

}
