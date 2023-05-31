package com.cmn.service;

import java.util.List;

public interface EmployeeService {

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
	int employeeDelete(String id, String modifier);
	
	//아이디 중복검사
	int idDupleCheck(String employeeId);
	
	//사원 검색
	//List<EmployeeVO> getSearchList(String key, String value);
	List<EmployeeVO> getSearchList(String cp, String dp, String rk, String id, String nm, String st);
	
	//target 정보 조회
	List<EmployeeVO> getTargetInfo(String id);
}
