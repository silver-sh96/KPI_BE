package com.cmn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cmn.service.ApprovalLineVO;
import com.cmn.service.ApprovalService;
import com.cmn.service.ApprovalStageVO;
import com.cmn.service.ApprovalVO;
import com.cmn.service.DocumentVO;

@Service("ApprovalService")
public class ApprovalServiceImpl implements ApprovalService {
	@Resource(name = "ApprovalMapper")
	private ApprovalMapper approvalMapper;
	
	// 전체결재내역 조회
	@Override
	public List<ApprovalVO> getTotalApproval() {
		List<ApprovalVO> receptApproval = approvalMapper.getTotalApproval();
		return receptApproval;
	}
	
	// 수신결재내역 조회
	@Override
	public List<ApprovalVO> getReceptApproval(String id) {
		List<ApprovalVO> receptApproval = approvalMapper.getReceptApproval(id);
		return receptApproval;
	}
	
	// 수신결재내역 검색
	@Override
	public List<ApprovalVO> getReceptSearch(String fm, 
										    String st, 
										    String nm, 
										    String dp, 
										    String dt1, 
										    String dt2, 
										    String id) {
		List<ApprovalVO> receptSearch = approvalMapper.getReceptSearch(fm, st, nm, dp, dt1, dt2, id);
		return receptSearch;
	}
	
	// 발신결재내역 조회
	@Override
	public List<ApprovalVO> getRequestApproval(String id) {
		List<ApprovalVO> requestApproval = approvalMapper.getRequestApproval(id);
		return requestApproval;
	}

	// 발신결재내역 검색
	@Override
	public List<ApprovalVO> getRequsetSearch(String fm, 
										     String st, 
										     String nm, 
										     String tt, 
										     String dt1, 
										     String dt2, 
										     String id) {
		List<ApprovalVO> requestSearch = approvalMapper.getRequsetSearch(fm, st, nm, tt, dt1, dt2, id);
		return requestSearch;
	}
	
	// 결재양식 조회
	@Override
	public List<DocumentVO> getApprovalForm() {
		List<DocumentVO> approvalForm = approvalMapper.getApprovalForm();
		return approvalForm;
	}
	
	// 결재선 조회
	@Override
	public List<ApprovalLineVO> getApprovalLine(String registrant) {
		List<ApprovalLineVO> approvalLine = approvalMapper.getApprovalLine(registrant);
		return approvalLine;
	}
	
	// 결재선 추가
	@Override
	public int regApprovalLine(String id, String approvalLineName, String approvalLineDetail,
 		    				   String employeeNumberDetail, String registrant) {
		int result = approvalMapper.regApprovalLine(id, approvalLineName, approvalLineDetail,
				 									employeeNumberDetail, registrant);
		return result;
	}
	
	// 결재선 삭제
	@Override
	public int deleteApprovalLine(String id) {
		int result = approvalMapper.deleteApprovalLine(id);
		return result;
	}
	
	// 결재문서 추가
	@Override
	public int regApprovalDocument(ApprovalVO approval) {
		int result = approvalMapper.regApprovalDocument(approval);
		return result;
	}
	
	// 결재단계 추가
	@Override
	public int regApprovalStage(String id, String approval, int step, String registrant) {
		int result = approvalMapper.regApprovalStage(id, approval, step, registrant);
		return result;
	}
	
	// 결재단계 조회
	@Override
	public List<ApprovalStageVO> getApprovalStage(String id) {
		List<ApprovalStageVO> approvalStage = approvalMapper.getApprovalStage(id);
		return approvalStage;
	}

	// 본인 상태 변경
	@Override
	public int changeMyState(String id, String approval, String opinion) {
		int result = approvalMapper.changeMyState(id, approval, opinion);
		return result;
	}
	
	// 전체 결재단계 변경(진행중)
	@Override
	public int changeAllState(String id, String approval) {
		int result = approvalMapper.changeAllState(id, approval);
		return result;
	}
	
	// 전체 결재단계 변경(승인)
	@Override
	public int changeAllStateEnd(String id, String approval) {
		int result = approvalMapper.changeAllStateEnd(id, approval);
		return result;
	}
	
	// 발신목록 결재상태 변경(진행중)
	@Override
	public int changeRequestState(String id, String approval) {
		int result = approvalMapper.changeRequestState(id, approval);
		return result;
	}
	
	// 발신목록 결재상태 변경(승인)
	@Override
	public int changeRequestStateEnd(String id, String approval) {
		int result = approvalMapper.changeRequestStateEnd(id, approval);
		return result;
	}
	
	// 본인 상태 변경(반려)
	@Override
	public int changeMyStateReject(String id, String approval, String opinion) {
		int result = approvalMapper.changeMyStateReject(id, approval, opinion);
		return result;
	}

	// 전체 결재단계 변경(반려)
	@Override
	public int changeAllStateReject(String id, String approval) {
		int result = approvalMapper.changeAllStateReject(id, approval);
		return result;
	}

	// 발신목록 결재상태 변경(반려)
	@Override
	public int changeRequestStateReject(String id, String approval) {
		int result = approvalMapper.changeRequestStateReject(id, approval);
		return result;
	}

}
