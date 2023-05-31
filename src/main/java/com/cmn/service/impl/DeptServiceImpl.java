package com.cmn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cmn.service.CodeVO;
import com.cmn.service.DeptService;
import com.cmn.service.DeptVO;

@Service("DeptService")
public class DeptServiceImpl implements DeptService {
	@Resource(name = "DeptMapper")
	private DeptMapper deptMapper;
	
	// 부서원 조회 
	@Override
	public List<CodeVO> getDeptMember(String dept) {
		List<CodeVO> deptMember = deptMapper.getDeptMember(dept);
		return deptMember;
	}
	
	// 부서장 초기화 
	@Override
	public int changeDefault(String dept, String modifier) {
		int result = deptMapper.changeDefault(dept, modifier);
		return result;
	}
	
	// 부서장 변경 
	@Override
	public int changeHead(String head, String modifier) {
		int result = deptMapper.changeHead(head, modifier);
		return result;
	}
	
	// 부서장 변경 
	@Override
	public int deptCodeDupleChk(String deptCode) {
		int result = deptMapper.deptCodeDupleChk(deptCode);
		return result;
	}
	
	// 부서 등록
	@Override
	public int deptReg(DeptVO dept) {
		int result = deptMapper.deptReg(dept);
		//int result = 1;
		return result;
	}
	
	// 부서 수정
	@Override
	public int deptModify(DeptVO dept) {
		int result = deptMapper.deptModify(dept);
		//int result = 1;
		return result;
	}
	
	// 부서 삭제
	@Override
	public int deptDelete(String deptCode, String modifier) {
		int result = deptMapper.deptDelete(deptCode, modifier);
		//int result = 1;
		return result;
	}
	
	// 부서원 이동
	@Override
	public int memberMove(String deptCode, String modifier) {
		int result = deptMapper.memberMove(deptCode, modifier);
		//int result = 1;
		return result;
	}
	
	// 부서 이동 (선택부서 부서원 추가)
	@Override
	public int memberTransfer(String target, String dept, String modifier) {
		int result = deptMapper.memberTransfer(target, dept, modifier);
		//int result = 1;
		return result;
	}
	
	// 부서 이동 (선택부서 부서원 삭제)
	@Override
	public int memberRemove(String target, String dept, String modifier) {
		int result = deptMapper.memberRemove(target, dept, modifier);
		//int result = 1;
		return result;
	}
	
	// dnd dragkey 상위부서 조회
	@Override
	public String getDragUpperDept(String dragKey) {
		String dragUpperDept = deptMapper.getDragUpperDept(dragKey);
		//int result = 1;
		return dragUpperDept;
	}
	
	// dnd dropkey 상위부서 조회
	@Override
	public String getDropUpperDept(String dropKey) {
		String dropUpperDept = deptMapper.getDropUpperDept(dropKey);
		//int result = 1;
		return dropUpperDept;
	}
	
	// dnd 하위 부서가 없는 부서로 dept 이동(하위부서 개수 cnt)
	@Override
	public int chkChildCnt(String dropKey) {
		int result = deptMapper.chkChildCnt(dropKey);
		//int result = 1;
		return result;
	}
	
	// dnd 상위 부서가 같은 부서 간 dept 이동(target 상위부서변경(하위부서X))
	@Override
	public int dndDeptMoveTarget(String dragKey, String dropKey, String modifier) {
		int result = deptMapper.dndDeptMoveTarget(dragKey, dropKey, modifier);
		//int result = 1;
		return result;
	}
	
	// dnd 상위 부서가 같은 부서 간 dept 이동(target 상위부서변경(하위부서O))
	@Override
	public int dndDeptMoveTargetHaveChild(String dragKey, String dropKey, int resultCheckChild, String modifier) {
		int result = deptMapper.dndDeptMoveTargetHaveChild(dragKey, dropKey, resultCheckChild, modifier);
		//int result = 1;
		return result;
	}
	
	// dnd 상위 부서가 같은 부서 간 dept 이동(다른부서 우선순위 변경)
	@Override
	public int dndDeptMoveAnother(int dragPosition, String dragUpperDept, String modifier) {
		int result = deptMapper.dndDeptMoveAnother(dragPosition, dragUpperDept, modifier);
		//int result = 1;
		return result;
	}
	
	// dnd 하위로 이동(다른부서 우선순위 변경)
	@Override
	public int dndUnderMoveAnother(int dropPosition, String dragUpperDept, int dragPosition, String modifier) {
		int result = deptMapper.dndUnderMoveAnother(dropPosition, dragUpperDept, dragPosition, modifier);
		//int result = 1;
		return result;
	}

	// dnd 하위로 이동(target 순서변경)
	@Override
	public int dndUnderMoveTarget(String dragKey, int dropPosition, String modifier) {
		int result = deptMapper.dndUnderMoveTarget(dragKey, dropPosition, modifier);
		//int result = 1;
		return result;
	}
	
	// dnd 상위로 이동(다른부서 우선순위 변경)
	@Override
	public int dndOverMoveAnother(int dropPosition, String dragUpperDept, int dragPosition, String modifier) {
		int result = deptMapper.dndOverMoveAnother(dropPosition, dragUpperDept, dragPosition, modifier);
		//int result = 1;
		return result;
	}
	
	// dnd 상위로 이동(target 순서변경)
	@Override
	public int dndOverMoveTarget(String dragKey, int dropPosition, String modifier) {
		int result = deptMapper.dndOverMoveTarget(dragKey, dropPosition, modifier);
		//int result = 1;
		return result;
	}
	
	// dnd 상위 부서가 다른 부서 간 dept 이동(다른부서 우선순위 변경)
	@Override
	public int dndDiffDeptMoveAnother(String dropUpperDept, int dropPosition, String modifier) {
		int result = deptMapper.dndDiffDeptMoveAnother(dropUpperDept, dropPosition, modifier);
		//int result = 1;
		return result;
	}
	
	// dnd 상위 부서가 다른 부서 간 dept 이동(target 순서변경)
	@Override
	public int dndDiffDeptMoveTarget(String dropUpperDept, String dragKey, int dropPosition, String modifier) {
		int result = deptMapper.dndDiffDeptMoveTarget(dropUpperDept, dragKey, dropPosition, modifier);
		//int result = 1;
		return result;
	}
	
	// dnd 상위 부서가 다른 부서 간 dept 이동(기존부서 우선순위 변경)
	@Override
	public int dndDiffDeptMoveOriginAnother(String dragUpperDept, int dragPosition, String modifier) {
		int result = deptMapper.dndDiffDeptMoveOriginAnother(dragUpperDept, dragPosition, modifier);
		//int result = 1;
		return result;
	}
}
