package com.cmn.service.impl;

import java.util.List;

import com.cmn.service.CodeVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("CodeMapper")
public interface CodeMapper {
	List<CodeVO> selectAcodeList();
	List<CodeVO> selectUcodeList(CodeVO codeVo);
	List<CodeVO> selectCcodeList(CodeVO codeVo);
	void deleteCode(CodeVO codeVo); 
	void delSQ(CodeVO codeVo);
	void delOffGoods(CodeVO codeVo);
	void registCode(CodeVO codeVo);
	void updateCode(CodeVO codeVo);
	void addSQ(CodeVO codeVo);
	void sort(CodeVO codeVo);
	void registCodeSQ(CodeVO codeVo);
	CodeVO getSQ(CodeVO codeVo);
}
