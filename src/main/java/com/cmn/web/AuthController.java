package com.cmn.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmn.service.AuthService;
import com.cmn.service.EmployeeVO;
@RestController
public class AuthController {

	
	@Autowired
	private AuthService authService;
	
	@RequestMapping(value = "/login.do")
	public EmployeeVO employeeModify(EmployeeVO emloyee) {
		EmployeeVO resultemp = new EmployeeVO();
		 resultemp = authService.Login(emloyee);
		return resultemp;
	}
}
