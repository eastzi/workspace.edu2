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
  <script type="text/javascript">
  	$(document).ready(function(){
  		var result = '${result}';
  		checkModal(result);
  		
  		$("#regBtn").click(function(){
  			location.href="${cpath}/board/register";
  		});
  	});
  	
  	function checkModal(result) {
		if(result == '') {
			return;
		}
		if(parseInt(result) > 0){
			// 새로운 다이얼로그 창 띄우기
			$(".modal-body").html("게시글" + parseInt(result) + "번이 등록되었습니다.");
		}
		$("#myModal").modal("show");
	}
  	
  	function goMsg() {
		alert("삭제된 게시물입니다.");
	}
  </script>
</head>
<body>
 
<div class="container">
  <h2>Spring MVC</h2>
  <div class="panel panel-default">
    <div class="panel-heading">
    	<!-- 로그인을 안한 경우 -->
    	<c:if test="${empty mvo}">
		<form class="form-inline" action="${cpath}/login/loginProcess" method="post">
		    <div class="form-group">
		      <label for="memID">ID:</label>
		      <input type="text" class="form-control" placeholder="Enter ID" name="memID">
		    </div>
		    <div class="form-group">
		      <label for="memPwd">Password:</label>
		      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="memPwd">
		    </div>
		    <button type="submit" class="btn btn-default">Submit</button>
	    </form>
	    </c:if> 
	    
	    <!-- 로그인을 한 경우 -->
	    <c:if test="${!empty mvo}">
	    <form class="form-inline" action="${cpath}/login/logoutProcess" method="post">
		    <div class="form-group">
		      <label>${mvo.memName}님 방문을 환영합니다.</label>
		    </div>
		    <button type="submit" class="btn btn-warning btn-default">로그아웃</button>
	    </form>
	    </c:if>
	</div>
    <div class="panel-body">
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<c:forEach var="vo" items="${list}">
				<tr>
					<td>${vo.idx}</td>
					<!-- 들여쓰기 설정하기 -->
					<td>
					<c:if test="${vo.boardLevel > 0}">
						<c:forEach begin="1" end="${vo.boardLevel}"> <!-- 1-1 이면 반복1번, 1-2이면 반복2번 들여쓰기 -->
							<span style="padding-left: 10px"></span>
						</c:forEach>
					</c:if>
					<c:if test="${vo.boardLevel > 0}"> <!-- 0보다 큰 경우 [RE] 붙이기 --> 
						<c:if test="${vo.boardAvailable == 1}"> <!-- 삭제가 안된 경우 -->
							<a href="${cpath}/board/get?idx=${vo.idx}"><c:out value='[RE]${vo.title}'/></a>
						</c:if>
						<c:if test="${vo.boardAvailable == 0}"> <!-- 삭제된 경우 -->
							<a href="javascript:goMsg()">[RE]삭제된 게시물입니다.</a>				
						</c:if>
					</c:if>
					<c:if test="${vo.boardLevel == 0}"> <!-- 0인 경우 [RE]없는 부모글 -->
						<c:if test="${vo.boardAvailable == 1}"> <!-- 삭제가 안된 경우 -->
							<a href="${cpath}/board/get?idx=${vo.idx}"><c:out value='${vo.title}'/></a>				
						</c:if>
						<c:if test="${vo.boardAvailable == 0}"> <!-- 삭제된 경우 -->
							<a href="javascript:goMsg()">삭제된 게시물입니다.</a>				
						</c:if>
					</c:if>
					</td>
					<td>${vo.writer}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${vo.indate}"/></td>
					<td>${vo.count}</td>
				</tr>				
			</c:forEach>
			<!-- 로그인을 한 경우에만 글쓰기 버튼 보이기 -->
			<c:if test="${!empty mvo}">
			<tr>
				<td colspan="5">
					<button id="regBtn" class="btn btn-primary pull-right">글쓰기</button>
				</td>
			</tr>
			</c:if>
		</table>
		<!-- Modal 추가 -->
		<div id="myModal" class="modal fade" role="dialog">
  			<div class="modal-dialog">

			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">Modal Header</h4>
			      </div>
			      <div class="modal-body">
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			      </div>
			    </div>
			
		    </div>
		</div>
	</div> 
    <div class="panel-footer">스프2탄(답변형 게시판 만들기)</div>
  </div>
</div>

</body>
</html>