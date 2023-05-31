package com.cmn.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cmn.service.CodeService;
import com.cmn.service.CodeVO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CodeController {

	@Autowired
	private CodeService codeService;

	ObjectMapper objectMapper = new ObjectMapper();

	@RequestMapping(value = "/AcodeList.do")
	public List<CodeVO> AcodeList(CodeVO codeVo) {
		List<CodeVO> aCodeList = codeService.selectAcodeList();
		return aCodeList;
	}

	// 상위 코드 데이터 select
	@RequestMapping(value = "/UcodeList.do")
	public List<CodeVO> UcodeList(CodeVO codeVo, @RequestParam("searchCode") String code,
			@RequestParam("searchName") String codeName, @RequestParam("searchUse") String use) {
		codeVo.setCOMMON_CODE(code);
		codeVo.setCODE_NAME(codeName);
		codeVo.setUSE_YN(use);

		List<CodeVO> uCodeList = codeService.selectUcodeList(codeVo);

		return uCodeList;
	}

	// 일반 코드 데이터 select
	@RequestMapping(value = "/CcodeList.do")
	public List<CodeVO> CcodeList(CodeVO codeVo, @RequestParam("seletedUcode") String Ucode,
			@RequestParam("searchKey") String searchKey, @RequestParam("searchValue") String searchValue)
			throws Exception {
		codeVo.setCOMMON_CODE(Ucode);
		codeVo.setSearchKey(searchKey);
		codeVo.setSearchValue(searchValue);

		List<CodeVO> cCodeList = codeService.selectCcodeList(codeVo);
		return cCodeList;
	}

	@RequestMapping(value = "/CodeRegist.do")
	public int CodeRegist(CodeVO codeVo) throws Exception {
		String result = codeService.registCode(codeVo);
		return 1;
	}

	@RequestMapping(value = "/CodeUpdate.do")
	public int CodeUpate(CodeVO codeVo, HttpServletRequest request, HttpServletResponse response,
			@RequestBody String data) throws Exception {

		JsonNode jsonNode = objectMapper.readTree(data);

		codeVo.setCOMMON_CODE(jsonNode.get("COMMON_CODE").asText());
		codeVo.setCODE_NAME(jsonNode.get("CODE_NAME").asText());
		codeVo.setCODE_DESCRIPTION(jsonNode.get("CODE_DESCRIPTION").asText());
		codeVo.setUSE_YN(jsonNode.get("USE_YN").asText());
		codeVo.setMODIFIER(jsonNode.get("MODIFIER").asText());
		codeVo.setPERIOD(jsonNode.get("PERIOD").asText());
		codeVo.setREF1(jsonNode.get("REF1").asText());

		System.out.println(codeVo.getCOMMON_CODE());

		String result = codeService.updateCode(codeVo);
		System.out.println("!! 수정");

		return 1;
	}

	@RequestMapping(value = "/CodeSort.do")
	public int CodeSort(CodeVO codeVo, @RequestParam("key") String key, @RequestParam("value") String value) {
		codeVo.setCOMMON_CODE(key);
		codeVo.setPERIOD(value);
		String result = codeService.sort(codeVo);
		return 1;
	}

	// 코드 삭제 Delete
	@ResponseBody
	@RequestMapping(value = "/CodeDelete.do")
	public int CodeDelete(CodeVO codeVo, HttpServletRequest request, HttpServletResponse response,
			@RequestBody List<String> data) throws Exception {
		for (int i = 0; data.size() > i; i++) {
			codeVo.setCOMMON_CODE(data.get(i));
			String result = codeService.deleteCode(codeVo);
		}
		return 1;
	}

}
