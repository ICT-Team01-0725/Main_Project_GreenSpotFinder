<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
        integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="../resources/css/success.css">
    <script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    
</head>
<body>
<div id="successform">
	<header id="header">
	</header>
	<main id="main">
		<div id="suc_container">
			<div id="check">
				<i class="fa-regular fa-circle-check"></i>
			</div>
			<div id="success">
				<p>회원가입 완료</p>
			</div>
				<p id="username"><%-- ${u_name } --%>000님 (아이디) 로 회원가입이 완료되었습니다.
			<div id="infobox">
				<p>회원가입 내역 확인 및 수정은 <a href="" id="infoup">마이페이지 > 회원정보 수정</a>에서 가능합니다.</p>
			</div>
			<div id="twobtn">
				<button id= "menu" class="btn" onclick="go_main()">메인 바로가기</button>
				<button id= "login" class="btn" onclick="go_login()">로그인	</button>
			</div>
		</div>
	</main>
	<footer id= "footer">
	</footer>
	<script type="text/javascript">
	
		// 메인으로 이동
		function go_main() {
			location.href("/mainGo");
		}
		
		// 로그인으로 이동
		function go_login() {
			location.href("/loginGo");
		}
	</script>
	</div>
</body>
</html>
