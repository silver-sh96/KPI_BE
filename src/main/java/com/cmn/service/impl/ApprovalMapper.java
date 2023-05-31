package com.cmn.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cmn.service.ApprovalLineVO;
import com.cmn.service.ApprovalStageVO;
import com.cmn.service.ApprovalVO;
import com.cmn.service.DocumentVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("ApprovalMapper")
public interface ApprovalMapper {
	
	// 전체결재내역 조회
	List<ApprovalVO> getTotalApproval();
	
	// 수신결재내역 조회
	List<ApprovalVO> getReceptApproval(@Param("id") String id);
	
	// 수신결재내역 검색
	List<ApprovalVO> getReceptSearch(@Param("fm") String fm,
									 @Param("st") String st,
									 @Param("nm") String nm,
									 @Param("dp") String dp,
								  	 @Param("dt1") String dt1,
									 @Param("dt2") String dt2,
									 @Param("id") String id);
	
	// 발신결재내역 조회
	List<ApprovalVO> getRequestApproval(@Param("id") String id);

	// 발신결재내역 검색
	List<ApprovalVO> getRequsetSearch(@Param("fm") String fm,
									  @Param("st") String st,
									  @Param("nm") String nm,
									  @Param("tt") String tt,
								  	  @Param("dt1") String dt1,
									  @Param("dt2") String dt2,
									  @Param("id") String id);
	
	// 결재양식 조회
	List<DocumentVO> getApprovalForm();
	
	// 결재선 조회
	List<ApprovalLineVO> getApprovalLine(@Param("registrant") String registrant);
	
	// 결재선 추가
	int regApprovalLine(@Param("id") String id,
						@Param("approvalLineName") String approvalLineName,
						@Param("approvalLineDetail") String approvalLineDetail,
						@Param("employeeNumberDetail") String employeeNumberDetail,
						@Param("registrant") String registrant);
	
	// 결재선 삭제
	int deleteApprovalLine(@Param("id") String id);

	// 결재문서 추가
	int regApprovalDocument(ApprovalVO approval);
	
	// 결재단계 추가
	int regApprovalStage(@Param("id") String id,
						 @Param("approval") String approval,
						 @Param("step") int step,
						 @Param("registrant") String registrant);
	
	// 결재단계 조회
	List<ApprovalStageVO> getApprovalStage(@Param("id") String id);
	
	// 본인 상태 변경
	int changeMyState(@Param("id") String id,
			 		  @Param("approval") String approval,
			 		  @Param("opinion") String opinion);
	
	// 전체 결재단계 변경(진행중)
	int changeAllState(@Param("id") String id,
					   @Param("approval") String approval);
	
	// 전체 결재단계 변경(승인)
	int changeAllStateEnd(@Param("id") String id,
						  @Param("approval") String approval);
	
	// 발신목록 결재상태 변경(진행중)
	int changeRequestState(@Param("id") String id,
						   @Param("approval") String approval);
	
	// 발신목록 결재상태 변경(승인)
	int changeRequestStateEnd(@Param("id") String id,
			@Param("approval") String approval);

	// 본인 상태 변경(반려)
	int changeMyStateReject(@Param("id") String id,
			 		  @Param("approval") String approval,
			 		  @Param("opinion") String opinion);

	// 전체 결재단계 변경(반려)
	int changeAllStateReject(@Param("id") String id,
						  @Param("approval") String approval);

	// 발신목록 결재상태 변경(반려)
	int changeRequestStateReject(@Param("id") String id,
			@Param("approval") String approval);
}
