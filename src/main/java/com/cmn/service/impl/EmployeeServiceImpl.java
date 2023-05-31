package com.cmn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cmn.service.CodeVO;
import com.cmn.service.DeptVO;
import com.cmn.service.EmployeeService;
import com.cmn.service.EmployeeVO;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Resource(name = "EmployeeMapper")
	private EmployeeMapper employeeMapper;
	
	// 부서 목록 조회 
	@Override
	public List<DeptVO> getDeptList() {
		List<DeptVO> deptList = employeeMapper.getDeptList();
		return deptList;
	}
	
	// 직급 목록 조회 
	@Override
	public List<CodeVO> getRankList(){
		List<CodeVO> rankList = employeeMapper.getRankList();
		return rankList;
	}
	
	// 직책 목록 조회 
	@Override
	public List<CodeVO> getPositionList(){
		List<CodeVO> positionList = employeeMapper.getPositionList();
		return positionList;
	}
	
	// 상태 목록 조회 
	@Override
	public List<CodeVO> getStatusList(){
		List<CodeVO> statusList = employeeMapper.getStatusList();
		return statusList;
	}

	// 사원 목록 조회
	@Override
	public List<EmployeeVO> getEmployeeList() {
		List<EmployeeVO> employeeList = employeeMapper.getEmployeeList();
		return employeeList;
	}
	
	// 사원 등록
	@Override
	public int employeeReg(EmployeeVO emloyee) {
		
		int result = employeeMapper.employeeReg(emloyee);
		return result;
	}
	
	// 수정사원 정보 조회
	@Override
	public List<EmployeeVO> getModifyInfo(String id) {
		List<EmployeeVO> employeeInfo = employeeMapper.getModifyInfo(id);
		return employeeInfo; 
	}
	
	// 사원 수정
	@Override
	public int employeeModify(EmployeeVO emloyee) {
		int result = employeeMapper.employeeModify(emloyee);
		//int result = 1;
		return result;
	}
	
	// 사원 삭제(퇴사처리)
	@Override
	public int employeeDelete(String id, String modifier) {
		int result = employeeMapper.employeeDelete(id, modifier);
		return result;
	}
	
	// 아이디 중복검사
	@Override
	public int idDupleCheck(String employeeId) {
		int result = employeeMapper.idDupleCheck(employeeId);
		return result;
	}
	
	// 사원 검색
	@Override
	/*
	 * 기존사원검색
	public List<EmployeeVO> getSearchList(String key, String value) {
		List<EmployeeVO> searchInfo = employeeMapper.getSearchList(key, value);
		return searchInfo; 
	}
	*/
	public List<EmployeeVO> getSearchList(String cp, String dp, String rk, String id, String nm, String st) {
		List<EmployeeVO> searchInfo = employeeMapper.getSearchList(cp, dp, rk, id, nm, st);
		return searchInfo; 
	}
	
	// target 정보 조회
	@Override
	public List<EmployeeVO> getTargetInfo(String id) {
		List<EmployeeVO> targetInfo = employeeMapper.getTargetInfo(id);
		return targetInfo; 
	}

}
