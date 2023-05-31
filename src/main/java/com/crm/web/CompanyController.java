package com.crm.web;

import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
import com.crm.service.ChargesVO;
import com.crm.service.CompanyService;
import com.crm.service.CompanyVO;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	ObjectMapper objectMapper = new ObjectMapper();

	@RequestMapping(value = "/ComList.do")
	public List<CompanyVO> AcodeList(CompanyVO comVo) {
		List<CompanyVO> List = companyService.selectComList(comVo); 
		return List;
	}

	@RequestMapping(value = "/ComDetail.do")
	public CompanyVO ComDetail(CompanyVO comVo, @RequestParam("id") String id) {
		System.out.println(id);

		comVo.setCOMPANY_CODE(id);
		CompanyVO data = companyService.ComDetail(comVo);
		return data;
	}

	@RequestMapping(value = "/ComRegi.do")
	public CompanyVO ComRegi(CompanyVO comVo) throws Exception {
		System.out.println(comVo);
		CompanyVO data = companyService.ComRegi(comVo);
		return data;
	}

	@RequestMapping(value = "/ComEdit.do")
	public int ComEdit(CompanyVO comVo) throws Exception {
		int result = companyService.ComEdit(comVo);

		return 1;
	}

	@RequestMapping(value = "/ComCharges.do")
	public List<ChargesVO> ComCharges(CompanyVO comVo, @RequestParam("id") String id) throws Exception{
		System.out.println(id);

		comVo.setCOMPANY_CODE(id);
		List<ChargesVO> data = companyService.ComCharges(comVo);
		return data;
	}
	
	@RequestMapping(value = "/ComDel.do")
	public int ComDel(CompanyVO comVo, @RequestParam("COMPANY_CODE") String COMPANY_CODE) throws Exception {
		comVo.setCOMPANY_CODE(COMPANY_CODE);
		System.out.println(COMPANY_CODE);
		int result = companyService.ComDel(comVo);

		return 1;
	}
	
	@RequestMapping(value = "/ComDelList.do")
	public int ComDelList(CompanyVO comVo, @RequestBody List<String> data)throws Exception {
		for (int i = 0; data.size() > i; i++) {
			comVo.setCOMPANY_CODE(data.get(i));
			int result = companyService.ComDel(comVo);
		}
		return 1;
	}

	@RequestMapping(value = "/ChargeEdit.do")
	public int ChargeEdit(ChargesVO charVo) {
		int result = companyService.ChargeEdit(charVo);
		return 1;
	}

	@RequestMapping(value = "/ChargeRegi.do")
	public int ChargeRegi(ChargesVO charVo) {
		int result = companyService.ChargeRegi(charVo);
		return 1;
	}

	@RequestMapping(value = "/ChargeDel.do")
	public int ChargeDel(ChargesVO charVo, @RequestBody List<String> data)throws Exception {
		for (int i = 0; data.size() > i; i++) {
			charVo.setCHARGE_CODE(data.get(i));
			int result = companyService.ChargeDel(charVo);
		}
		return 1;
	}

}
