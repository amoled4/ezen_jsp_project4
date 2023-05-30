<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반갑습니다</title>
</head>
<body>
	<c:if test="${ses.id ne null }">
		<strong>${ses.name }</strong> 님이 로그인하셨습니다. <br>
		<a href="/mem/logout"><button type="button">로그아웃</button></a>
		<a href="/mem/edit?id=${ses.id }"><button type="button">회원정보수정</button></a>
	</c:if>
	<c:if test="${ses.auth eq '1' }">
		<a href="/mem/list"><button>관리자 페이지</button></a>
	</c:if>



	<c:if test="${ses.id eq null }">
		<form action="/mem/login" method="post">
			<table>
				<tr>
					<td><input type="text" name="id" placeholder="아이디"></td>
				</tr>
				<tr>
					<td><input type="password" name="pw" placeholder="비밀번호"></td>
				</tr>
			</table>
			<button type="submit">로그인</button>
			<a href="/mem/join"><button type="button">회원가입</button></a>
		</form>
	</c:if>
</body>
</html>