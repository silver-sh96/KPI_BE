package com.cmn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cmn.service.CodeService;
import com.cmn.service.CodeVO;

@Service("CodeService")
public class CodeServiceImpl implements CodeService {
	@Resource(name = "CodeMapper")
	private CodeMapper codeMapper;

	@Override
	public List<CodeVO> selectAcodeList() {
		return codeMapper.selectAcodeList();
	}

	@Override
	public List<CodeVO> selectUcodeList(CodeVO codeVo) {
		return codeMapper.selectUcodeList(codeVo);
	}

	@Override
	public List<CodeVO> selectCcodeList(CodeVO codeVo) {
		return codeMapper.selectCcodeList(codeVo);
	}

	@Override
	public String deleteCode(CodeVO codeVo) {
		codeMapper.deleteCode(codeVo);
		if (codeVo.getCOMMON_CODE().length() == 2) {
			codeMapper.delSQ(codeVo);
		} else {
			if (codeVo.getCOMMON_CODE().contains("IT")) {
				codeMapper.delSQ(codeVo);
				codeMapper.delOffGoods(codeVo);
			}
		}

		return "1";
	}

	@Override
	public String registCode(CodeVO codeVo) {
		System.out.println(codeVo.getUPPER_COMMON_CODE());
		if (codeVo.getUPPER_COMMON_CODE().length() == 2) {
			codeMapper.registCodeSQ(codeVo);
			if (codeVo.getUPPER_COMMON_CODE().contains("IT")) {
				CodeVO sq;
				System.out.println("IT-SQ");

				sq = codeMapper.getSQ(codeVo);
				sq.setUPPER_COMMON_CODE(codeVo.getUPPER_COMMON_CODE());
				System.out.println(sq.getUPPER_COMMON_CODE());
				System.out.println(sq.getCOMMON_CODE());

				codeMapper.addSQ(sq);
			}
		} else {
			codeMapper.registCode(codeVo);
			codeMapper.addSQ(codeVo);
		}

		return "1";
	}

	@Override
	public String updateCode(CodeVO codeVo) {
		codeMapper.updateCode(codeVo);
		return "1";
	}

	@Override
	public String sort(CodeVO codeVo) {
		codeMapper.sort(codeVo);
		return "1";
	}

}
