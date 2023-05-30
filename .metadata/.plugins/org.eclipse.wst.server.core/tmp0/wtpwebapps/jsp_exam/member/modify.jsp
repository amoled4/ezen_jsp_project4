<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
</head>
<body>
	<form action="/mem/modify" method="post">
		<table>
			<tr>
				<th>*아이디</th>
				<td><input type="text" name="id" value="${mvo.id }" readonly="readonly"></td>
			</tr>
			<tr>
				<th>*비밀번호</th>
				<td><input type="text" name="pw" value="${mvo.pw }"></td>
			</tr>
			<tr>
				<th>*이름</th>
				<td><input type="text" name="name" value="${mvo.name }" readonly="readonly"></td>
			</tr>
			<tr>
				<th>*이메일</th>
				<td><input type="text" name="email" value="${mvo.email }"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="phone" value="${mvo.phone }"></td>
			</tr>
			<tr>
				<th>가입날짜</th>
				<td><input type="text" name="regdate" value="${mvo.regdate }" readonly="readonly"></td>
			</tr>
			<tr>
				<th>*정보수신동의</th>
				<td>
				<label for="yes"> yes
						<input type="radio" name="event" value="1">
					</label>
					<label for="no"> no
						<input type="radio" name="event" value="0">
					</label>
				</td>
			</tr>
		</table>
		<button type="submit">수정완료</button>
		<a href="/mem/remove?id=${mvo.id }"><button type="button">회원탈퇴</button></a>
		<a href="/"><button type="button">취소</button></a>
	</form>
</body>
</html>