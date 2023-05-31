package com.cmn.service.impl;

import com.cmn.service.EmployeeVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("AuthMapper")
public interface AuthMapper {

	EmployeeVO Login(EmployeeVO emloyee);
}
