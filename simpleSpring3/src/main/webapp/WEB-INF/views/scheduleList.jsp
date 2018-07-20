<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/common.css'/>" />
<meta charset="UTF-8">
<title>목록</title>
</head>
<body>
hi
<table class="commtable">
	<colgroup>
		<col width="10%"/>
		<col width="*"/>
		<col width="15%"/>
		<col width="20%"/>
		<col width="10%"/>
	</colgroup>
	<thead>
		<tr>
			<th scope="col">일자</th>
			<th scope="col">시간</th>
			<th scope="col">스케쥴</th>
			<th scope="col">등록자</th>
			<th scope="col">등록일</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${list != null}">
				<c:forEach items="${list }" var="row">
					<tr>
						<td>${row.YYYYMMDD }</td>
						<td>${row.HH }</td>
						<td>${row.SCHEDULE }</td>
						<td>${row.REG_ID }</td>
						<td>${row.REG_DT }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="5">조회된 결과가 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>		
	</tbody>
</table>
</body>
</html>
