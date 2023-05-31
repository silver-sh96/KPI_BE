package com.crm.service;

import java.util.List;

public interface CompanyService {
	List<CompanyVO> selectComList(CompanyVO comVo);

	CompanyVO ComDetail(CompanyVO comVo);

	List<ChargesVO> ComCharges(CompanyVO comVo);

	CompanyVO ComRegi(CompanyVO comVo);

	int ComDel(CompanyVO comVo);

	int ComEdit(CompanyVO comVo);

	int ChargeEdit(ChargesVO charVo);

	int ChargeRegi(ChargesVO charVo);

	int ChargeDel(ChargesVO charVo);

}
