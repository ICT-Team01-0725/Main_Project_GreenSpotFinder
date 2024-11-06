<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
        integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="logincss/login.css">
	<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
	<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
	
	
</head>

<body>
	<c:if test="${loginok} == 'fail'">
		alert("로그인에 실패했습니다.");
	</c:if>
    <div id="login">
        <header>
            <h1>헤더입니다.</h1>
        </header>

        <main>

			<div class="login_container">
				<div id="box">
					<h2 id="logintxt" data-aos="fade-up">로그인</h2>
					<form action="loginok" method="post" style="margin-top: 29px">
						<h3 class="h3">아이디</h3>
						<input class="id" type="text"
							style="border-bottom: 1px solid #dddddd;"
							placeholder="아이디를 입력해주세요.">
						<h3 class="h3">비밀번호</h3>
						<input class="pw" type="password"
							style="border-bottom: 1px solid #dddddd;"
							placeholder="비밀번호를 입력해주세요.">
						<button id="loginbtn" onclick="submit()">로그인</button>
					</form>
					<div id="three">

						<a href="/idFindGo" class="tmp">아이디 찾기</a>
						<a href="/pwFindGo" class="tmp">비밀번호 찾기</a> 
						<a href="/joinGo" class="tmp">회원가입</a>
					</div>
					<div style="padding: 20px 0px;">
						<p class="ptag">아이디와 비밀번호 입력하기 귀찮으시죠?</p>
						<p class="ptag">1초 회원가입으로 입력없이 간편하게 로그인 하세요.</p>
					</div>
					
				
					<button class="sns kakao" onclick="location.href='https://kauth.kakao.com/oauth/authorize?client_id=673fbc7db4cc9805a5120f9f38a7289a&redirect_uri=http://localhost:8080/kakaologin&response_type=code'">카카오 로그인</button>
					<button class="sns naver" onclick="location.href='https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=bv_786diGR8Y0y00e9Bx&redirect_uri=http://localhost:8080/naverlogin&state=STATE_STRING'">네이버로 로그인</button>
				</div>
			</div>

		</main>
        <footer>
            <h2>푸터입니다</h2>
        </footer>
    </div>
    <script>
    AOS.init();
  
		

    </script>
</body>

</html>