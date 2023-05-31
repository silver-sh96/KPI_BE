package com.crm.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.crm.service.ChargesVO;
import com.crm.service.CompanyService;
import com.crm.service.CompanyVO;

@Service("CompanyService")
public class CompanyServiceImpl implements CompanyService {
	@Resource(name = "CompanyMapper")
	private CompanyMapper companyMapper;

	@Override
	public List<CompanyVO> selectComList(CompanyVO comVo) {
		return companyMapper.selectComList(comVo);
	}

	@Override
	public CompanyVO ComDetail(CompanyVO comVo) {
		return companyMapper.ComDetail(comVo);
	}

	@Override 
	public List<ChargesVO> ComCharges(CompanyVO comVo) {
		return companyMapper.ComCharges(comVo);
	}

	@Override
	public CompanyVO ComRegi(CompanyVO comVo) {
		companyMapper.ComRegi(comVo);
		CompanyVO data = companyMapper.SQCompCode(comVo);
		return data;

	}
	

	@Override
	public int ComEdit(CompanyVO comVo) {
		return companyMapper.ComEdit(comVo);
	}

	@Override
	public int ComDel(CompanyVO comVo) {
		companyMapper.ComDelChargesAll(comVo);
		CompanyVO data = companyMapper.SQCompDel(comVo);
		if (data != null) {
			companyMapper.SQDrop(comVo);
		}
		return companyMapper.ComDel(comVo);
	}

	
	@Override
	public int ChargeEdit(ChargesVO charVo) {
		return companyMapper.ChargeEdit(charVo);
	}

	@Override
	public int ChargeRegi(ChargesVO charVo) {
		ChargesVO data = companyMapper.SQCompView(charVo);
		if (data == null) {
			companyMapper.SQComp(charVo);
		}
		return companyMapper.ChargeRegi(charVo);

	} 
	
	@Override
	public int ChargeDel(ChargesVO charVo) {
		return companyMapper.ChargeDel(charVo);

	} 
}
