package com.cmn.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cmn.service.CodeVO;
import com.cmn.service.DeptVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("DeptMapper")
public interface DeptMapper {

	//부서원 조회
	List<CodeVO> getDeptMember(String dept);
	
	//부서장 초기화
	int changeDefault(@Param("dept") String dept, @Param("modifier") String modifier);
	
	//부서장 변경
	int changeHead(@Param("head") String head, @Param("modifier") String modifier);

	// 부서코드 중복조회
	int deptCodeDupleChk(String deptCode);
	
	//부서 등록
	int deptReg(DeptVO dept);
	
	//부서 수정
	int deptModify(DeptVO dept);
	
	//부서 삭제
	int deptDelete(@Param("deptCode") String deptCode, @Param("modifier") String modifier);
	
	//부서원 이동
	int memberMove(@Param("deptCode") String deptCode, @Param("modifier") String modifier);
	
	// 부서 이동 (선택부서 부서원 추가)
	int memberTransfer(@Param("target") String target, @Param("dept") String dept, @Param("modifier") String modifier);

	// 부서 이동 (선택부서 부서원 삭제)
	int memberRemove(@Param("target") String target, @Param("dept") String dept, @Param("modifier") String modifier);
	
	// dnd dragkey 상위부서 조회
	String getDragUpperDept(String dragKey);
	
	// dnd dropkey 상위부서 조회
	String getDropUpperDept(String dropKey);
	
	// dnd 하위 부서가 없는 부서로 dept 이동(하위부서 개수 cnt)
	int chkChildCnt(@Param("dropKey") String dropKey);
	
	// dnd 상위 부서가 같은 부서 간 dept 이동(target 상위부서변경(하위부서X))
	int dndDeptMoveTarget(@Param("dragKey") String dragKey, 
						  @Param("dropKey") String dropKey, 
						  @Param("modifier") String modifier);
	
	// dnd 상위 부서가 같은 부서 간 dept 이동(target 상위부서변경(하위부서O))
	int dndDeptMoveTargetHaveChild(@Param("dragKey") String dragKey, 
								   @Param("dropKey") String dropKey, 
								   @Param("resultCheckChild") int resultCheckChild, 
								   @Param("modifier") String modifier);
	
	// dnd 상위 부서가 같은 부서 간 dept 이동(다른부서 우선순위 변경)
	int dndDeptMoveAnother(@Param("dragPosition") int dragPosition, 
						   @Param("dragUpperDept") String dragUpperDept, 
						   @Param("modifier") String modifier);
	
	// dnd 하위로 이동(다른부서 우선순위 변경)
	int dndUnderMoveAnother(@Param("dropPosition") int dropPosition, 
					 		@Param("dragUpperDept") String dragUpperDept, 
					 		@Param("dragPosition") int dragPosition, 
							@Param("modifier") String modifier);
	
	// dnd 하위로 이동(target 순서변경)
	int dndUnderMoveTarget(@Param("dragKey") String dragKey, 
						   @Param("dropPosition") int dropPosition, 
						   @Param("modifier") String modifier);
	
	// dnd 상위로 이동(다른부서 우선순위 변경)
	int dndOverMoveAnother(@Param("dropPosition") int dropPosition, 
						   @Param("dragUpperDept") String dragUpperDept, 
						   @Param("dragPosition") int dragPosition, 
						   @Param("modifier") String modifier);
	
	// dnd 상위로 이동(target 순서변경)
	int dndOverMoveTarget(@Param("dragKey") String dragKey, 
						  @Param("dropPosition") int dropPosition, 
						  @Param("modifier") String modifier);
	
	// dnd 상위 부서가 다른 부서 간 dept 이동(다른부서 우선순위 변경)
	int dndDiffDeptMoveAnother(@Param("dropUpperDept") String dropUpperDept, 
							   @Param("dropPosition") int dropPosition, 
							   @Param("modifier") String modifier);
	
	// dnd 상위 부서가 다른 부서 간 dept 이동(target 순서변경)
	int dndDiffDeptMoveTarget(@Param("dropUpperDept") String dropUpperDept, 
							  @Param("dragKey") String dragKey, 
							  @Param("dropPosition") int dropPosition, 
							  @Param("modifier") String modifier);
	
	// dnd 상위 부서가 다른 부서 간 dept 이동(기존부서 우선순위 변경)
	int dndDiffDeptMoveOriginAnother(@Param("dragUpperDept") String dragUpperDept, 
							   		 @Param("dragPosition") int dragPosition, 
									 @Param("modifier") String modifier);
}
