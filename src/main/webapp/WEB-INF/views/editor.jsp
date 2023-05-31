<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="smarteditor2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<title>editorPage</title>
</head>
<body>
<div class="fr-box fr-basic fr-top" role="application">
	<textarea name="notice_content" id="smartEditor" style="width: 100%; min-height: 400px;">
		<c:forEach items="${target }" var="t">
			<c:out value="${src }" />
		</c:forEach>
		<%-- <c:forEach items="${documentList }" var="dl">
			<c:if test="${dl.id eq documentCode}">
			<c:set var="formSrc" value="${dl.formSrc}" />
				${fn:escapeXml(formSrc) }
			</c:if>
			<c:forEach items="${target }" var="t">
				<c:if test="${dl.id eq documentCode}">
					${dl.formSrc }
				</c:if>
			</c:forEach>
		</c:forEach> --%>
	</textarea>
</div>
</body>

<script type="text/javascript">

	$("#smartEditor").hide();
	
	var oEditors = [];
	
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors,
		elPlaceHolder : "smartEditor", //저는 textarea의 id와 똑같이 적어줬습니다.
		sSkinURI : "smarteditor2/SmartEditor2Skin.html", //경로를 꼭 맞춰주세요!
		fCreator : "createSEditor2",
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,
	
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,
	
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : false
		},
	});
	
</script>
</html>