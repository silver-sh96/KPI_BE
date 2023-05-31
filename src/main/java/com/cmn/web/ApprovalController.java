package com.cmn.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cmn.service.ApprovalLineVO;
import com.cmn.service.ApprovalService;
import com.cmn.service.ApprovalStageVO;
import com.cmn.service.ApprovalVO;
import com.cmn.service.DeptVO;
import com.cmn.service.DocumentVO;

@RestController
public class ApprovalController {
	
	private static final Logger log = LoggerFactory.getLogger(DeptController.class);
	
	@Autowired
	private ApprovalService approvalService;
	
	// 전체결재내역 조회
	@RequestMapping(value = "/totalApproval.do")
	public List<ApprovalVO> getTotalApproval() throws Exception {
		List<ApprovalVO> receptApproval = approvalService.getTotalApproval();
		log.info("receptApproval   :   {}", receptApproval);
		return receptApproval;
	}
	
	// 수신결재내역 조회
	@RequestMapping(value = "/receptApproval.do")
	public List<ApprovalVO> getReceptApproval(@RequestParam("id") String id) throws Exception {
		log.info("id   :   {}", id);
		List<ApprovalVO> receptApproval = approvalService.getReceptApproval(id);
		log.info("receptApproval   :   {}", receptApproval);
		return receptApproval;
	}
	
	// 수신결재내역 검색
	@RequestMapping(value = "/receptSearch.do")
	public List<ApprovalVO> getReceptSearch(@RequestParam("fm") String fm,
											@RequestParam("st") String st,
											@RequestParam("nm") String nm,
											@RequestParam("dp") String dp,
											@RequestParam("dt1") String dt1,
											@RequestParam("dt2") String dt2,
											@RequestParam("id") String id) throws Exception {
		log.info("fm   :   {}", fm);
		log.info("st   :   {}", st);
		log.info("nm   :   {}", nm);
		log.info("dp   :   {}", dp);
		log.info("dt1   :   {}", dt1);
		log.info("dt2   :   {}", dt2);
		log.info("id   :   {}", id);
		
		List<ApprovalVO> receptSearch = approvalService.getReceptSearch(fm, st, nm, dp, dt1, dt2, id);
		log.info("receptSearch   :   {}", receptSearch);
		
		return receptSearch;
	}
	
	// 발신결재내역 조회
	@RequestMapping(value = "/requestApproval.do")
	public List<ApprovalVO> getRequestApproval(@RequestParam("id") String id) throws Exception {
		List<ApprovalVO> requestApproval = approvalService.getRequestApproval(id);
		log.info("requestApproval   :   {}", requestApproval);
		return requestApproval;
	}
	
	// 발신결재내역 검색
	@RequestMapping(value = "/requestSearch.do")
	public List<ApprovalVO> getRequsetSearch(@RequestParam("fm") String fm,
											 @RequestParam("st") String st,
											 @RequestParam("nm") String nm,
											 @RequestParam("tt") String tt,
											 @RequestParam("dt1") String dt1,
											 @RequestParam("dt2") String dt2,
											 @RequestParam("id") String id) throws Exception {
		log.info("fm   :   {}", fm);
		log.info("st   :   {}", st);
		log.info("nm   :   {}", nm);
		log.info("dp   :   {}", tt);
		log.info("dt1   :   {}", dt1);
		log.info("dt2   :   {}", dt2);
		log.info("id   :   {}", id);
		
		List<ApprovalVO> requestSearch = approvalService.getRequsetSearch(fm, st, nm, tt, dt1, dt2, id);
		log.info("requestSearch   :   {}", requestSearch);
		
		return requestSearch;
	}
	
	// 결재양식 조회
	@RequestMapping(value = "/approvalForm.do")
	public List<DocumentVO> getApprovalForm() throws Exception {
		List<DocumentVO> approvalForm = approvalService.getApprovalForm();
		log.info("approvalForm   :   {}", approvalForm);
		return approvalForm;
	}
	
	// 결재선 조회
	@RequestMapping(value = "/approvalLine.do")
	public List<ApprovalLineVO> getApprovalLine(@RequestParam("registrant") String registrant) throws Exception {
		List<ApprovalLineVO> approvalLine = approvalService.getApprovalLine(registrant);
		log.info("approvalLine   :   {}", approvalLine);
		return approvalLine;
	}
	
	// 결재선 등록
	@RequestMapping(value = "/regApprovalLine.do")
	public int regApprovalLine(@RequestParam("id") String id,
			   				   @RequestParam("approvalLineName") String approvalLineName,
							   @RequestParam("approvalLineDetail") String approvalLineDetail,
							   @RequestParam("employeeNumberDetail") String employeeNumberDetail,
							   @RequestParam("registrant") String registrant) throws Exception {
		
		log.info("id   :   {}", id);
		log.info("approvalLineName   :   {}", approvalLineName);
		log.info("approvalLineDetail   :   {}", approvalLineDetail);
		log.info("employeeNumberDetail   :   {}", employeeNumberDetail);
		log.info("registrant   :   {}", registrant);
		
		//int result = 1;
		int result = approvalService.regApprovalLine(id, approvalLineName, approvalLineDetail,
													 employeeNumberDetail, registrant);
		
		return result;
	}
	
	// 결재선 삭제
	@RequestMapping(value = "/deleteApprovalLine.do")
	public int deleteApprovalLine(@RequestParam("id") String id) throws Exception {
		
		log.info("id   :   {}", id);
		
		//int result = 1;
		int result = approvalService.deleteApprovalLine(id);
		
		return result;
	}
	
	// 결재문서 작성
	@RequestMapping(value = "/regApprovalDocument.do")
	public int regApprovalDocument(ApprovalVO approval, @RequestParam("id") String id) throws Exception {
		//결재문서 추가
		int result = approvalService.regApprovalDocument(approval);
		//int result = 1;
		log.info("approval   :   {}", approval);
		log.info("id   :   {}", id);
		
		//결재단계 추가
		String[] numArr = approval.getEmployeeNumberDetail().split("▶");
		for(int i=0; i<numArr.length; i++) {
			System.out.println(numArr[i].trim());
			approvalService.regApprovalStage(id, numArr[i].trim(), i+1, approval.getRegistrant());
		}
		
		return result;
	}
	
	
	// 결재단계 조회
	@RequestMapping(value = "/approvalStage.do")
	public List<ApprovalStageVO> getApprovalStage(@RequestParam("id") String id) throws Exception {
		log.info("id   :   {}", id);
		List<ApprovalStageVO> approvalStage = approvalService.getApprovalStage(id);
		log.info("approvalStage   :   {}", approvalStage);
		return approvalStage;
	}
	
	// 결재승인 처리
	@RequestMapping(value = "/permissionProcess.do")
	public int permissionProcess(@RequestParam("id") String id, 
								 @RequestParam("approval") String approval,
								 @RequestParam("opinion") String opinion,
								 @RequestParam("lineCnt") int lineCnt,
								 @RequestParam("nowStep") int nowStep) throws Exception {
		
		log.info("id   :   {}", id);
		log.info("approval   :   {}", approval);
		log.info("opinion   :   {}", opinion);
		log.info("lineCnt   :   {}", lineCnt);
		log.info("nowStep   :   {}", nowStep);
		
		// 본인상태 변경
		int changeMyState = approvalService.changeMyState(id, approval, opinion);
		if(lineCnt > nowStep) {
			// 전체 결재단계 변경(진행중)
			int changeAllState = approvalService.changeAllState(id, approval);
			// 발신목록 결재상태 변경(진행중)
			System.out.println("진행중");
			int changeRequestState = approvalService.changeRequestState(id, approval);
		}else {
			// 전체 결재단계 변경(승인)
			int changeAllStateEnd = approvalService.changeAllStateEnd(id, approval);
			// 발신목록 결재상태 변경(승인)
			System.out.println("승인");
			int changeRequestStateEnd = approvalService.changeRequestStateEnd(id, approval);
		}
		int result = 1;
		
		
		return result;
	}
	
	// 결재반려 처리
	@RequestMapping(value = "/rejectApproval.do")
	public int rejectApproval(@RequestParam("id") String id, 
							  @RequestParam("approval") String approval,
							  @RequestParam("opinion") String opinion) throws Exception {
		
		log.info("id   :   {}", id);
		log.info("approval   :   {}", approval);
		log.info("opinion   :   {}", opinion);
		
		// 본인상태 변경(반려)
		int changeMyStateReject = approvalService.changeMyStateReject(id, approval, opinion);
		// 전체 결재단계 변경(반려)
		int changeAllStateReject = approvalService.changeAllStateReject(id, approval);
		// 발신목록 결재상태 변경(반려)
		int changeRequestStateReject = approvalService.changeRequestStateReject(id, approval);
		
		int result = 1;
		
		
		return result;
	}

}
