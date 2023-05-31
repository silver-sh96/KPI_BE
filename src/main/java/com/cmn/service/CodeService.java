package com.cmn.service;

import java.util.List;

public interface CodeService {
	List<CodeVO> selectAcodeList();

	List<CodeVO> selectUcodeList(CodeVO codeVo);

	List<CodeVO> selectCcodeList(CodeVO codeVo);

	String deleteCode(CodeVO codeVo);

	String registCode(CodeVO codeVo);

	String updateCode(CodeVO codeVo);

	String sort(CodeVO codeVo);

}
