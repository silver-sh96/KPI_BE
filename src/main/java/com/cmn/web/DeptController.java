package com.cmn.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cmn.service.CodeVO;
import com.cmn.service.DeptService;
import com.cmn.service.DeptVO;

@RestController
public class DeptController {
	
	private static final Logger log = LoggerFactory.getLogger(DeptController.class);

	@Autowired
	private DeptService deptService;
	
	// 부서원 조회
	@RequestMapping(value = "/deptMember.do")
	public List<CodeVO> getDeptMember(@RequestParam("dept") String dept) throws Exception {
		log.info("dept   :   {}", dept);
		List<CodeVO> deptMember = deptService.getDeptMember(dept);
		log.info("deptMember   :   {}", deptMember);
		return deptMember;
	}
	
	// 부서장 변경 
	@RequestMapping(value = "/changeDeptHead.do")
	public int changeDeptHead(@RequestParam("head") String head, 
						  	  @RequestParam("dept") String dept, 
						  	  @RequestParam("modifier") String modifier) throws Exception {
		log.info("head   :   {}", head);
		log.info("dept   :   {}", dept);
		int result1 = deptService.changeDefault(dept, modifier);
		int result2 = deptService.changeHead(head, modifier);
		int result = result1 + result2;
		log.info("result   :   {}", result);
		//int result = 1;
		return result;
	}
	
	// 부서코드 중복조회
	@RequestMapping(value = "/deptCodeDupleChk.do")
	public int deptCodeDupleChk(@RequestParam("deptCode") String deptCode) throws Exception {
		log.info("dept   :   {}", deptCode);
		int result = deptService.deptCodeDupleChk(deptCode);
		//log.info("result   :   {}", result);
		//int result = 1;
		return result;
	}
	
	// 부서 등록
	@RequestMapping(value = "/deptReg.do")
	public int deptReg(DeptVO dept, @RequestParam("deptCode") String deptCode) throws Exception {
		log.info("dept   :   {}", dept);
		log.info("deptCode   :   {}", deptCode);
		int result = deptService.deptReg(dept);
		log.info("result   :   {}", result);
		//int result = 1;
		return result;
	}
	
	// 부서 수정
	@RequestMapping(value = "/deptModify.do")
	public int deptModify(DeptVO dept, @RequestParam("deptCode") String deptCode) throws Exception {
		log.info("dept   :   {}", dept);
		log.info("deptCode   :   {}", deptCode);
		int result = deptService.deptModify(dept);
		log.info("result   :   {}", result);
		//int result = 1;
		return result;
	}
	
	// 부서 삭제
	@RequestMapping(value = "/deptDelete.do")
	public int deptDelete(@RequestParam("deptCode") String deptCode,
						  @RequestParam("modifier") String modifier) throws Exception {
		log.info("deptCode   :   {}", deptCode);
		// 삭제
		int deptDel = deptService.deptDelete(deptCode, modifier);
		// 부서원 이동
		int memberMove = deptService.memberMove(deptCode, modifier);
		int result = 1;
		log.info("result   :   {}", result);
		return result;
	}
	
	// 부서 이동 (선택부서 부서원 추가)
	@RequestMapping(value = "/memberTransfer.do")
	public int memberTransfer(@RequestParam(name = "target", required = false) String target,
			  				  @RequestParam(name = "dept", required = false) String dept,
				  			  @RequestParam(name = "modifier", required = false) String modifier) throws Exception {
		log.info("target   :   {}", target);
		log.info("dept   :   {}", dept);
		int result = deptService.memberTransfer(target, dept, modifier);
		//log.info("result   :   {}", result);
		//int result = 0;
		return result;
	}
	
	// 부서 이동 (선택부서 부서원 삭제)
	@RequestMapping(value = "/memberRemove.do")
	public int memberRemove(@RequestParam(name = "target", required = false) String target,
			  				@RequestParam(name = "dept", required = false) String dept,
			  				@RequestParam(name = "modifier", required = false) String modifier) throws Exception {
		log.info("target   :   {}", target);
		log.info("dept   :   {}", dept);
		int result = deptService.memberRemove(target, dept, modifier);
		//log.info("result   :   {}", result);
		//int result = 0;
		return result;
	}
	
	// 부서 우선순위 변경
	@RequestMapping(value = "/dndDept.do")
	public int dndDept(@RequestParam(name = "dragKey", required = false) String dragKey,
					   @RequestParam(name = "dragPosition", required = false) int dragPosition,
			  		   @RequestParam(name = "dropKey", required = false) String dropKey,
			  		   @RequestParam(name = "dropPosition", required = false) int dropPosition,
			  		   @RequestParam(name = "positionDept", required = false) int positionDept,
			  		   @RequestParam(name = "modifier", required = false) String modifier) throws Exception {
		
		log.info("dragKey   :   {}", dragKey);
		log.info("dragPosition   :   {}", dragPosition);
		log.info("dropKey   :   {}", dropKey);
		log.info("dropPosition   :   {}", dropPosition);
		log.info("positionDept   :   {}", positionDept);
		
		String dragUpperDept = deptService.getDragUpperDept(dragKey);
		System.out.println(dragUpperDept+ " <-- dragUpperDept");
		String dropUpperDept = deptService.getDropUpperDept(dropKey);
		System.out.println(dropUpperDept+ " <-- dropUpperDept");
		
		if(positionDept == 0) {
			System.out.println("상위 부서가 같은 부서 간 dept 이동");
			int resultCheckChild = deptService.chkChildCnt(dropKey);
			if(resultCheckChild == 0) {
				System.out.println("하위 부서 X");
				int resultTarget = deptService.dndDeptMoveTarget(dragKey, dropKey, modifier);
				int resultAnother = deptService.dndDeptMoveAnother(dragPosition, dragUpperDept, modifier);
			} else {
				System.out.println("하위 부서 O");
				int resultTarget = deptService.dndDeptMoveTargetHaveChild(dragKey, dropKey, resultCheckChild, modifier);
				int resultAnother = deptService.dndDeptMoveAnother(dragPosition, dragUpperDept, modifier);
			}
		} else {
			if(dragUpperDept.equals(dropUpperDept)) {
				if(dragPosition < dropPosition) {
					System.out.println("하위로 이동");
					//int dropNum = dropPosition-1;
					int resultAnother = deptService.dndUnderMoveAnother(dropPosition, dragUpperDept, dragPosition, modifier);
					int resultTarget = deptService.dndUnderMoveTarget(dragKey, dropPosition, modifier);
				}
				if(dragPosition > dropPosition) {
					System.out.println("상위로 이동");
					int resultAnother = deptService.dndOverMoveAnother(dropPosition, dragUpperDept, dragPosition, modifier);
					int resultTarget = deptService.dndOverMoveTarget(dragKey, dropPosition, modifier);
				}
			} else {
				System.out.println("상위 부서가 다른 부서 간 dept 이동");
				int resultAnother = deptService.dndDiffDeptMoveAnother(dropUpperDept, dropPosition, modifier);
				int resultTarget = deptService.dndDiffDeptMoveTarget(dropUpperDept, dragKey, dropPosition, modifier);
				int resultOriginAnother = deptService.dndDiffDeptMoveOriginAnother(dragUpperDept, dragPosition, modifier);
			}
		}
		
		//int result = deptService.memberRemove(target, dept);
		//log.info("result   :   {}", result);
		int result = 1;
		return result;
	}

}
