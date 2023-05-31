package com.cmn.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cmn.service.ApprovalService;
import com.cmn.service.DocumentVO;
import com.cmn.service.EmployeeService;
import com.cmn.service.EmployeeVO;

@Controller
public class EditorController {
	
	private static final Logger log = LoggerFactory.getLogger(EditorController.class);
	
	@Autowired
	private ApprovalService approvalService;
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/editor.do")
	public String editorPage(@RequestParam("documentCode") String documentCode, @RequestParam("id") String id, Model model) {
		log.info("documentCode   :   {}", documentCode);
		log.info("id   :   {}", id);
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		Date date = new Date();
		String year = dateFormat.format(date).substring(0,4);
		String today = dateFormat.format(date);
		
		String src = "";
		List<DocumentVO> documentList = approvalService.getApprovalForm();
		List<EmployeeVO> target = employeeService.getTargetInfo(id);
		for(int i=0; i<documentList.size(); i++) {
			for(int j=0; j<target.size(); j++) {
				if(documentList.get(i).getId().equals(documentCode)) {
					src = documentList.get(i).getFormSrc()
							.replace("{employeeCompany}", target.get(j).getEmployeeCompany())
							.replace("{year}", year)
							.replace("{employeeDept}", target.get(j).getEmployeeDept())
							.replace("{date}", today)
							.replace("{employeeFullName}", target.get(j).getEmployeeFullName())
							.replace("{employeeRank}", target.get(j).getEmployeeRank());
				}
			}
		}
		log.info("target   :   {}", target);
		
		model.addAttribute("documentCode", documentCode);
		model.addAttribute("src", src);
		model.addAttribute("target", target);
		
		return "editor";
	}

}
