<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<!-- 리셋 cdn -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css">
<!-- 폰트 어썸 -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
	integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- 구글 폰트 -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" href="../screen_css/join.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>

<body>
	<div id="join">
		<header>
			<h1>헤더입니다.</h1>
		</header>
		<main>
			<section class="container">
				<div id="box">
					<h2 id="jointxt">회원가입</h2>
					<form action="" style="margin-top: 29px">
						<h3 class="h3">
							아이디 <label class="star">*</label>
						</h3>
						<input class="joininput width100" type="text" name="id"
							style="border-bottom: 1px solid #dddddd;"
							placeholder="아이디를 입력해주세요." required>
						<h3 class="h3">
							비밀번호 <label class="star">*</label>
						</h3>
						<input class="joininput width100" type="password" name="pw" id="pwid"
							style="border-bottom: 1px solid #dddddd;"
							placeholder="비밀번호를 입력해주세요." required>
							<span id="pwtest"></span>
						<h3 class="h3">
							비밀번호 확인 <label class="star">*</label>
						</h3>
						<input class="joininput width100" type="password" name="pwchk" id="pwchkid"
							style="border-bottom: 1px solid #dddddd;"
							placeholder="비밀번호를 재입력해주세요." required> <span id="pwOK">비밀번호가
							일치하지 않습니다.</span>
						<h3 class="h3">
							이름 <label class="star">*</label>
						</h3>
						<input class="joininput width100" type="text" name="name"
							style="border-bottom: 1px solid #dddddd;"
							placeholder="이름을 입력해주세요." required>
						<h3 class="h3">
							휴대전화 <label class="star">*</label>
						</h3>
						<input class="joininput width100" type="text" name="phone"
							style="border-bottom: 1px solid #dddddd;"
							placeholder="전화번호를 입력해주세요." required>
						<div class="emailsec width100">
							<h3 class="h3">
								이메일 <label class="star">*</label>
							</h3>
							<input class="joininputemail" type="text" name="email"
								style="border-bottom: 1px solid #dddddd;"
								placeholder="이메일을 입력해주세요." required>
							<lable class="com">@</lable>
							<select name="emailback" id="emailback">
								<option value="select">선택하세요</option>
								<option value="naver.com">naver.com</option>
								<option value="gmail.com">gmail.com</option>
								<option value="daum.net">daum.net</option>
								<option value="nate.com">nate.com</option>
								<option value="hanmail.net">hanmail.net</option>
								<option value="yahoo.com">yahoo.com</option>
								<option value="dreamwiz.com">dreamwiz.com</option>
								<option value="freechal.com">freechal.com</option>
								<option value="hanmir.com">hanmir.com</option>
								<option value="hotmail.com">hotmail.com</option>
								<option value="korea.com">korea.com</option>
								<option value="paran.com">paran.com</option>
							</select>
						</div>
						<label>
							<div class="option width100">
								<input class="optionchk" type="checkbox"> <span
									class="optiontxt">약관 전체 동의하기</span>
							</div>
						</label>
						<button class="joinbtn width100" onclick="join_go(this_form)" disabled>회원가입</button>
					</form>
				</div>
			</section>

		</main>
		<footer>
			<h2>푸터입니다</h2>
		</footer>
	</div>
	<script>
		// 비밀번호 대소문자 특수문자 숫자 포함 검사
		let pwtestok = 0;
		// 비밀번호 확인 일치 검사
		let pwchkok = 0;
		
		$("#pwid").keyup(function(){
			// 비밀번호 정규식
			let pwdtest = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])(?=.*[0-9])[A-Za-z\d!@#$%^&*]{8,15}$/;
			// pw 값 가져오기
			let pw = document.getElementById("pwid");
			// pw 값이 입력 되었을때
			if(pw != null){
				// 정규식으로 pw값 검사 false일때
				if(!pwdtest.test(pw.value)){
					$("#pwtest").text("비밀번호는 영어 대/소문자,특수문자,숫자를 포함하여 8자이상 15자이내여야 합니다.");
					pwtestok = 0;
				// 정규식으로 pw값 검사 true 일때
				}else{
					$("#pwtest").text("");
					pwtestok = 1;
					// function 실행 
					enabled();
				}
			
			}
			
			
		});	
		
		// 비밀번호, 비밀번호 확인 키보드 입력시
		$("#pwchkid, #pwid").keyup(function(){
			// p 비밀번호 값
			let p = document.getElementById("pwid").value;
			// pwch 비밀번호 확인 값
			let pwch = document.getElementById("pwchkid").value;
			
			// 값이 같으면
			if(p == pwch){
				$("#pwOK").text("비밀번호가 일치합니다.");
				pwchkok = 1;
				// function 실행
				enabled();
			// 값이 다르면
			}else{
				$("#pwOK").text("비밀번호가 일치하지 않습니다.");
				pwchkok = 0;
			}
			
		});
		
		// 체크박스 변화시
		$(".optionchk").change(function(){
			enabled();
		});
		
		// 이메일 뒷자리 
		let emailbac;
		// 이메일 뒷자리 선택시
		$("#emailback").change(function(){
			// 선택한 값을 emailbac 에 넣는다.
			emailbac = document.getElementById("emailback").value;
			// function 실행
			enabled();
		});
		
		// 회원가입 버튼 활성화
		function enabled() {
			// 비밀번호 정규식, 비밀번호 확인, 체크박스 체크, 이메일 뒷자리 선택시 
			if(pwtestok == 1 && pwchkok == 1 && $(".optionchk").is(":checked") && emailbac !== "select"){
				// 버튼 활성화, 색 #111111로 변경
				$(".joinbtn").prop("disabled", false).css("background-color", "#111111");
				
			}
			
		}
		
		function join_go(f){
			// 비밀번호 정규식, 비밀번호 확인, 체크박스 체크 후 적용
						
		}
    </script>
</body>

</html>
