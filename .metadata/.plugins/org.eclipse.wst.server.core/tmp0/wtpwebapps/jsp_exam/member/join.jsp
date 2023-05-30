<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="/mem/joinus" method="post">
		<table>
			<tr>
				<th>*아이디</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>*비밀번호</th>
				<td><input type="text" name="pw"></td>
			</tr>
			<tr>
				<th>*이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>*이메일</th>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="phone"></td>
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
		<br> <strong>* 표시는 필수 입력입니다.</strong> <br>
		<button type="submit">가입완료</button>
		<a href="/"><button type="button">취소</button></a>
	</form>
</body>
</html>