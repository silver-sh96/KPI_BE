package com.cmn.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cmn.service.CodeVO;
import com.cmn.service.DeptVO;
import com.cmn.service.EmployeeVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("EmployeeMapper")
public interface EmployeeMapper {
	
	//부서 목록 조회
	List<DeptVO> getDeptList();
	
	//직급 목록 조회
	List<CodeVO> getRankList();
	
	//직책 목록 조회
	List<CodeVO> getPositionList();
	
	//상태 목록 조회
	List<CodeVO> getStatusList();
	
	//사원 목록 조회
	List<EmployeeVO> getEmployeeList();
	
	//사원 등록
	int employeeReg(EmployeeVO emloyee);
	
	//수정 사원 정보 조회
	List<EmployeeVO> getModifyInfo(String id);
	
	//사원 수정
	int employeeModify(EmployeeVO emloyee);
	
	//사원 삭제(퇴사처리)
	int employeeDelete(@Param("id") String id, @Param("modifier") String modifier);
	
	//아이디 중복검사
	int idDupleCheck(String employeeId);
	
	//사원 검색
	//List<EmployeeVO> getSearchList(@Param("key") String key, @Param("value") String value);
	List<EmployeeVO> getSearchList(@Param("cp") String cp, @Param("dp") String dp,
								   @Param("rk") String rk, @Param("id") String id, 
								   @Param("nm") String nm, @Param("st") String st);
	
	//target 정보 조회
	List<EmployeeVO> getTargetInfo(String id);

}
