package com.cmn.service;

import java.util.List;


public interface DeptService {
	
	//부서원 조회
	List<CodeVO> getDeptMember(String dept);
	
	//부서장 초기화
	int changeDefault(String dept, String modifier);
	
	//부서장 변경
	int changeHead(String head, String modifier);
	
	//부서코드 중복조회
	int deptCodeDupleChk(String deptCode);
	
	//부서 등록
	int deptReg(DeptVO dept);
	
	//부서 수정
	int deptModify(DeptVO dept);
	
	//부서 삭제
	int deptDelete(String deptCode, String modifier);
	
	//부서원 이동 
	int memberMove(String deptCode, String modifier);
	
	// 부서 이동 (선택부서 부서원 추가)
	int memberTransfer(String target, String dept, String modifier);
	
	// 부서 이동 (선택부서 부서원 삭제)
	int memberRemove(String target, String dept, String modifier);
	
	// dnd dragkey 상위부서 조회
	String getDragUpperDept(String dragKey);
	
	// dnd dropkey 상위부서 조회
	String getDropUpperDept(String dropKey);
	
	// dnd 하위 부서가 없는 부서로 dept 이동(하위부서 개수 cnt)
	int chkChildCnt(String dropKey);
	
	// dnd 상위 부서가 같은 부서 간 dept 이동(target 상위부서변경(하위부서X))
	int dndDeptMoveTarget(String dragKey, String dropKey, String modifier);
	
	// dnd 상위 부서가 같은 부서 간 dept 이동(target 상위부서변경(하위부서O))
	int dndDeptMoveTargetHaveChild(String dragKey, String dropKey, int resultCheckChild, String modifier);
	
	// dnd 상위 부서가 같은 부서 간 dept 이동(다른부서 우선순위 변경)
	int dndDeptMoveAnother(int dragPosition, String dragUpperDept, String modifier);
	
	// dnd 하위로 이동(다른부서 우선순위 변경)
	int dndUnderMoveAnother(int dropPosition, String dragUpperDept, int dragPosition, String modifier);

	// dnd 하위로 이동(target 순서변경)
	int dndUnderMoveTarget(String dragKey, int dropPosition, String modifier);
	
	// dnd 상위로 이동(다른부서 우선순위 변경)
	int dndOverMoveAnother(int dropPosition, String dragUpperDept, int dragPosition, String modifier);
	
	// dnd 상위로 이동(target 순서변경)
	int dndOverMoveTarget(String dragKey, int dropPosition, String modifier);
	
	// dnd 상위 부서가 다른 부서 간 dept 이동(다른부서 우선순위 변경)
	int dndDiffDeptMoveAnother(String dropUpperDept, int dropPosition, String modifier);
	
	// dnd 상위 부서가 다른 부서 간 dept 이동(target 순서변경)
	int dndDiffDeptMoveTarget(String dropUpperDept, String dragKey, int dropPosition, String modifier);
	
	// dnd 상위 부서가 다른 부서 간 dept 이동(기존부서 우선순위 변경)
	int dndDiffDeptMoveOriginAnother(String dragUpperDept, int dragPosition, String modifier);
}
