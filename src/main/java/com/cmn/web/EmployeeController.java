package com.cmn.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cmn.service.CodeVO;
import com.cmn.service.DeptVO;
import com.cmn.service.EmployeeService;
import com.cmn.service.EmployeeVO;

@RestController
public class EmployeeController {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;
	
	// main 
	@RequestMapping(value = "/main.do")
	public String mainPage() {
		return "Hello, KPI Project";
	}
	
	// 부서 목록 조회 
	@RequestMapping(value = "/deptList.do")
	public List<DeptVO> getDeptList() throws Exception {
		List<DeptVO> deptList = employeeService.getDeptList();
		log.info("deptList   :   {}", deptList);
		return deptList;
	}
	
	// 직급 목록 조회 
	@RequestMapping(value = "/rankList.do")
	public List<CodeVO> getRankList() throws Exception {
		List<CodeVO> rankList = employeeService.getRankList();
		log.info("rankList   :   {}", rankList);
		return rankList;
	}
	
	// 직책 목록 조회 
	@RequestMapping(value = "/positionList.do")
	public List<CodeVO> getPositionList() throws Exception {
		List<CodeVO> positionList = employeeService.getPositionList();
		log.info("positionList   :   {}", positionList);
		return positionList;
	}
	
	// 상태 목록 조회 
	@RequestMapping(value = "/statusList.do")
	public List<CodeVO> getStatusList() throws Exception {
		List<CodeVO> statusList = employeeService.getStatusList();
		log.info("statusList   :   {}", statusList);
		return statusList;
	}
	
	// 사원 목록 조회 
	@RequestMapping(value = "/employeeList.do")
	public List<EmployeeVO> getEmployeeList() throws Exception {
		List<EmployeeVO> employeeList = employeeService.getEmployeeList();
		log.info("employeeList   :   {}", employeeList);
		return employeeList;
	}
	
	// 사원 등록
	@RequestMapping(value = "/employeeReg.do")
	public int employeeReg(EmployeeVO emloyee, @RequestParam("id") String id) throws Exception {
		log.info("emloyee   :   {}", emloyee);
		int result = employeeService.employeeReg(emloyee);
		return result;
	}
	
	
	// 수정사원 정보 조회(!!)
	@RequestMapping(value = "/modifyInfo.do") 
	public List<EmployeeVO> getModifyInfo(@RequestParam("id") String id) throws Exception {
		log.info("id   :   {}", id); 
		List<EmployeeVO> employeeInfo = employeeService.getModifyInfo(id);
		log.info("employeeInfo   :   {}", employeeInfo); 
		
		return employeeInfo; 
	}
	
	// 사원 수정
	@RequestMapping(value = "/employeeModify.do")
	public int employeeModify(EmployeeVO emloyee, @RequestParam("id") String id) {
		log.info("emloyee   :   {}", emloyee);
		int result = employeeService.employeeModify(emloyee);
		//int result = 1;
		return result;
	}
	
	// 사원 삭제(퇴사처리)
	@RequestMapping(value = "/employeeDelete.do")
	public int employeeDelete(@RequestParam("id") String id, 
		  	  				  @RequestParam("modifier") String modifier) {
		log.info("id   :   {}", id); 
		int result = employeeService.employeeDelete(id, modifier);
		//int result = 1;
		return result;
	}
	
	// 아이디 중복검사
	@RequestMapping(value = "/idDupleCheck.do")
	public int idDupleCheck(@RequestParam("employeeId") String employeeId) {
		log.info("employeeId   :   {}", employeeId); 
		int result = employeeService.idDupleCheck(employeeId);
		log.info("result   :   {}", result); 
		return result;
	}
	
	/* 
	// 기존 사원 검색!!
	@RequestMapping(value = "/searchList.do") 
	public List<EmployeeVO> getSearchList(@RequestParam(name = "key", required = false, defaultValue = "id") String key,
										  @RequestParam(name = "value", required = false) String value) throws Exception {
		log.info("key   :   {}", key); 
		log.info("value   :   {}", value); 
		
		if(key.equals("id")) {
			key = "e.EMPLOYEE_NUMBER";
		}else if(key.equals("employeeCompany")) {
			key = "e.EMPLOYEE_COMPANY";
		}else if(key.equals("employeeDept")) {
			key = "dc.CODE_NAME";
		}else if(key.equals("employeeFullName")) {
			key = "e.EMPLOYEE_FULL_NAME";
		}else if(key.equals("employeeRank")) {
			key = "rc.CODE_NAME";
		}else if(key.equals("employeeStatus")) {
			key = "sc.CODE_NAME";
		}
		
		List<EmployeeVO> searchInfo = employeeService.getSearchList(key, value);
		log.info("searchInfo   :   {}", searchInfo); 
		
		return searchInfo; 
	} 
	*/
	
	// 사원 검색!!
	@RequestMapping(value = "/searchList.do") 
	public List<EmployeeVO> getSearchList(@RequestParam(name = "cp", required = false) String cp,
										  @RequestParam(name = "dp", required = false) String dp,
										  @RequestParam(name = "rk", required = false) String rk,
										  @RequestParam(name = "id", required = false) String id,
										  @RequestParam(name = "nm", required = false) String nm,
										  @RequestParam(name = "st", required = false) String st) throws Exception {
		log.info("cp   :   {}", cp); 
		log.info("dp   :   {}", dp); 
		log.info("rk   :   {}", rk); 
		log.info("id   :   {}", id); 
		log.info("nm   :   {}", nm); 
		log.info("st   :   {}", st); 
		
		List<EmployeeVO> searchInfo = employeeService.getSearchList(cp, dp, rk, id, nm, st);
		log.info("searchInfo   :   {}", searchInfo);
		
		return searchInfo; 
	}
	
	// target 정보 조회
	@RequestMapping(value = "/targetInfo.do") 
	public List<EmployeeVO> getTargetInfo(@RequestParam("id") String id) throws Exception {
		log.info("id   :   {}", id); 
		List<EmployeeVO> targetInfo = employeeService.getTargetInfo(id);
		log.info("targetInfo   :   {}", targetInfo); 
		
		return targetInfo; 
	}

}
