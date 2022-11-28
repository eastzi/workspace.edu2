<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
 
<div class="container">
  <h2>Spring MVC</h2>
  <div class="panel panel-default">
    <div class="panel-heading">BOARD</div>
    <div class="panel-body">
		<table class="table table-bordered">
			<tr>
				<td>번호</td>
				<td><input type="text" class="form-control" name="idx" readonly="readonly" value="${vo.idx}"/></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" class="form-control" name="title" readonly="readonly" value="${vo.title}"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" class="form-control" readonly="readonly">${vo.content}</textarea></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" class="form-control" name="writer" readonly="readonly" value="${vo.writer}"/></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">
					<c:if test="${!empty mvo}">
						<button class="btn btn-primary" onclick="location.href='${cpath}/board/reply?idx=${vo.idx}'">답글</button>
						<button class="btn btn-success" onclick="location.href='${cpath}/board/modify?idx=${vo.idx}'">수정</button>
					</c:if>
					<c:if test="${empty mvo}">
						<button disabled="disabled" class="btn btn-primary">답글</button>
						<button disabled="disabled" class="btn btn-success" onclick="location.href='${cpath}/board/modify?idx=${vo.idx}'">수정</button>
					</c:if>
					<button class="btn btn-info" onclick="location.href='${cpath}/board/list'">목록</button>
				</td>
			</tr>
		</table>
	</div> 
    <div class="panel-footer">스프2탄(답변형 게시판 만들기)</div>
  </div>
</div>

</body>
</html>