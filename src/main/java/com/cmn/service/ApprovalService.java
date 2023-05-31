package com.cmn.service;

import java.util.List;

public interface ApprovalService {
	
	// 전체결재내역 조회
	List<ApprovalVO> getTotalApproval();
	
	// 수신결재내역 조회
	List<ApprovalVO> getReceptApproval(String id);
	
	// 수신결재내역 검색
	List<ApprovalVO> getReceptSearch(String fm, 
									 String st, 
									 String nm, 
									 String dp, 
									 String dt1, 
									 String dt2, 
									 String id);
	
	// 발신결재내역 조회
	List<ApprovalVO> getRequestApproval(String id);

	// 발신결재내역 검색
	List<ApprovalVO> getRequsetSearch(String fm, 
									  String st, 
									  String nm, 
									  String tt, 
									  String dt1, 
									  String dt2, 
									  String id);
	
	// 결재양식 조회
	List<DocumentVO> getApprovalForm();
	
	// 결재선 조회
	List<ApprovalLineVO> getApprovalLine(String registrant);
	
	// 결재선 추가
	int regApprovalLine(String id, String approvalLineName, String approvalLineDetail,
			 		    String employeeNumberDetail, String registrant);
	
	// 결재선 삭제
	int deleteApprovalLine(String id);
	
	// 결재문서 추가
	int regApprovalDocument(ApprovalVO approval);
	
	// 결재단계 추가
	int regApprovalStage(String id, String approval, int step, String registrant);

	// 결재단계 조회
	List<ApprovalStageVO> getApprovalStage(String id);
	
	// 본인 상태 변경
	int changeMyState(String id, String approval, String opinion);
	
	// 전체 결재단계 변경(진행중)
	int changeAllState(String id, String approval);
	
	// 전체 결재단계 변경(승인)
	int changeAllStateEnd(String id, String approval);
	
	// 발신목록 결재상태 변경(진행중)
	int changeRequestState(String id, String approval);
	
	// 발신목록 결재상태 변경(승인)
	int changeRequestStateEnd(String id, String approval);
	
	// 본인 상태 변경(반려)
	int changeMyStateReject(String id, String approval, String opinion);
	
	// 전체 결재단계 변경(반려)
	int changeAllStateReject(String id, String approval);
	
	// 발신목록 결재상태 변경(반려)
	int changeRequestStateReject(String id, String approval);

}
