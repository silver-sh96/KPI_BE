package com.cmn.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cmn.service.AuthService;
import com.cmn.service.EmployeeVO;

@Service("AuthService")
public class AuthServiceImpl implements AuthService{

	@Resource(name="AuthMapper")
	private AuthMapper authMapper;

	@Override
	public EmployeeVO Login(EmployeeVO emloyee) {
		return authMapper.Login(emloyee);
	}
	
	
}
