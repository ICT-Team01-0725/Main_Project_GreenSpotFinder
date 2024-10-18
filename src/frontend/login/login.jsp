<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="../screen_css/login.css">


</head>

<body>
    <div id="login">
        <header>
            <h1>헤더입니다.</h1>
        </header>

        <main>

			<section class="container">
				<div id="box">
					<h2 id="logintxt">로그인</h2>
					<form action="" style="margin-top: 29px">
						<h3 class="h3">아이디</h3>
						<input class="id" type="text"
							style="border-bottom: 1px solid #dddddd;"
							placeholder="아이디를 입력해주세요.">
						<h3 class="h3">비밀번호</h3>
						<input class="pw" type="text"
							style="border-bottom: 1px solid #dddddd;"
							placeholder="비밀번호를 입력해주세요.">
						<button id="loginbtn" onclick="">로그인</button>
					</form>
					<div id="three">

						<a href="" class="tmp">아이디 찾기</a> <a href="" class="tmp">비밀번호
							찾기</a> <a href="" class="tmp">회원가입</a>
					</div>
					<div style="padding: 20px 0px;">
						<p class="ptag">아이디와 비밀번호 입력하기 귀찮으시죠?</p>
						<p class="ptag">1초 회원가입으로 입력없이 간편하게 로그인 하세요.</p>
					</div>
					<button class="sns kakao" onclick="">카카오 1초 로그인/회원가입</button>
					<button class="sns naver" onclick="">네이버로 로그인</button>
				</div>
			</section>

		</main>
        <footer>
            <h2>푸터입니다</h2>
        </footer>
    </div>
    <script>
		
		

    </script>
</body>

</html>