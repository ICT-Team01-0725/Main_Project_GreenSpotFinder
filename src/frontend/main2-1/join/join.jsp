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
<link rel="stylesheet" href="logincss/join.css">

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>

<body>
	<div id="join">
		<header>
			<h1>헤더입니다.</h1>
		</header>
		<main>
			<div class="join_container">
				<div id="box">
					<h2 id="jointxt">회원가입</h2>
					<form action="/emailchk" style="margin-top: 29px" method="post">
						<h3 class="h3">
							아이디 <label class="star">*</label>
						</h3>
						<div id="idflex">
						<input class="joininput" type="text" name="u_id" id="uid"
							placeholder="아이디를 입력해주세요." required>
						<button id="id_chk" onclick="idchk(this.form)">중복 확인</button>
						</div>
						<label id="idchkresult">중복 확인을 해주세요</label>
						<h3 class="h3">
							비밀번호 <label class="star">*</label>
						</h3>
						<input class="joininput width100" type="password" name="u_pw" id="pwid"
							placeholder="비밀번호를 입력해주세요." required>
							<span id="pwtest"></span>
						<h3 class="h3">
							비밀번호 확인 <label class="star">*</label>
						</h3>
						<input class="joininput width100" type="password" name="u_pwchk" id="pwchkid"
							placeholder="비밀번호를 다시 입력해주세요." required> <span id="pwOK">비밀번호가
							일치하지 않습니다.</span>
						<h3 class="h3">
							이름 <label class="star">*</label>
						</h3>
						<input class="joininput width100" type="text" name="u_na"
							placeholder="이름을 입력해주세요." required>
						<h3 class="h3">
							휴대전화 <label class="star">*</label>
						</h3>
						<input class="joininput width100" id="phone" type="text" name="u_phone"
							placeholder="-없이 입력해주세요." required>
						<h3 class="h3">
							성별 <label class="star">*</label>
						</h3>
							<select name="u_gen" id="gen">
								<option value="male">남성</option>
								<option value="female">여성</option>
							</select>
						<h3 class="h3">
							생년월일 <label class="star">*</label>
						</h3>
						<div id="bir">
							<input type="date" name="u_bir" class="birth width100">
							<!-- <span>년</span>
							<input type="number" name="u_bir_m" class="birth" max="12">
							<span>월</span>
							<input type="number" name="u_bir_d" class="birth">
							<span>일</span>		 -->					
						</div>
						<div class="emailsec width100">
							<h3 class="h3">
								이메일 <label class="star">*</label>
							</h3>
							<div id="flexbox">
							<input class="email" id="email" type="text" name="u_em"
								style="border-bottom: 1px solid #dddddd;"
								placeholder="이메일을 입력해주세요." required>
							<span class="com">@</span>
							<input class="email" id="emailback" type="text" name="u_emailback"
								style="border-bottom: 1px solid #dddddd;"
								placeholder="이메일을 입력해주세요." required readonly
								pattern="[a-zA-Z0-9]+[.]+[a-zA-Z]+[.]*[a-zA-Z]*">
							<select name="u_emailbacks" id="emailselect" onchange="change_input(this.value)">
								<option value="null">선택하세요</option>
								<option value="naver.com">naver.com</option>
								<option value="gmail.com">gmail.com</option>
								<option value="daum.net">daum.net</option>
								<option value="nate.com">nate.com</option>
								<option value="hanmail.net">hanmail.net</option>
								<option value="yahoo.com">yahoo.com</option>
								<option value="select">직접 입력</option>
							</select>
							</div>
						</div>
						<label>
							<div class="option width100">
								<input id="allchk" type="checkbox" /> 
								<span class="optiontxt">약관 전체 동의하기</span>
							</div>
						</label>
						<label>
							<div class="optiondetail width100">
								<input class="optionchk" id="essential1" type="checkbox" />
								<span class="optiontxt">(필수)이용약관에 동의합니다.</span>
							</div>
						</label>
						<label>
							<div class="optiondetail width100">
								<input class="optionchk" id="essential2" type="checkbox" />
								<span class="optiontxt">(필수)이용약관에 동의합니다.</span>
							</div>
						</label>
						<label>
							<div class="optiondetail width100">
								<input class="optionchk" type="checkbox" />
								<span class="optiontxt">(선택)이용약관에 동의합니다.</span>
							</div>
						</label>
						<label>
							<div class="optiondetail width100">
								<input class="optionchk" type="checkbox" />
								<span class="optiontxt">(선택)이용약관에 동의합니다.</span>
							</div>
						</label>
						<button class="joinbtn width100" onclick="joinTry(this.form)" disabled>회원가입</button>
					</form>
				</div>
			</div>

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
		// 아이디 중복 확인
		let idchkok = 0;
		
		// 중복 확인
		function idchk(f){
			const id = f.u_id.value;
			// 아이디를 입력하지 않았을 때
			if(id == "" || id.length == 0){
				alert("아이디를 입력하세요");
				// 아이디에 focus
				f.querySelector("#uid").focus();
			}
			
			$.ajax({
				// idchk 로 이동
				url : "/idchk",
				type : "post",
				dataType : "json",
				// u_id에 id값 입력
				data : {
					"u_id" : id
				},
				// 작업 성공시
				success : function(result){
					// 결과가 true 일때 
					if(result == true){
						// 사용 가능한 id
						idchkok = 1;
						$("#idchkresult").text("사용 가능한 ID 입니다.");
						enabled();
					}else{
						idchkok=0;
						$("#idchkresult").text("사용 불가능한 ID 입니다.");
						enabled();
					}
				},
				error : function(){
					alert("이런 젠장"),
					console.log(idchkok)
					}
			});
			
		}
		
		
		$("#uid").keyup(function(){
			idchkok=0;
			$("#idchkresult").text("중복 확인을 해주세요");
			enabled();
		})
		
		
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
				$("#pwOK").css("color", "green");
				pwchkok = 1;
				// function 실행
				enabled();
			// 값이 다르면
			}else{
				$("#pwOK").text("비밀번호가 일치하지 않습니다.");
				$("#pwOK").css("color", "red");
				pwchkok = 0;
			}
			
		});
		
		// 체크박스 변화시
		$(".essential").change(function(){
			enabled();
		});
		
		// 이메일 뒷자리 select 선택시
		function change_input(v) {
			// 선택하세요 일때
			if(v == "null"){
				// readonly 유지
				$("#emailback").prop("readonly", true);
				// 특정 이메일을 선택했을때
			}else if(v != "select"){
				// 이메일 입력 val을 select value값으로 설정
				$("#emailback").val(v);
				// readonly 유지
				$("#emailback").prop("readonly", true);
				// 회원가입 버튼 활성화 시도
				enabled();
				// 직접 입력 선택 
			}else{
				// readonly 해제
				$("#emailback").prop("readonly", false);
				// 기본값 지우기
				$("#emailback").val(null);
				// 회원가입 버튼 활성화 시도
				enabled();
			}
		}
		
		// 약관 전체동의 체크 눌리면
		$("#allchk").click(function(){
			// 약관 전체 체크가 체크되면
			if($("#allchk").is(":checked")){
				// container 안에 optionchk 클래스를 찾아서 checked를 true값을 넣는다.
				$(this).closest(".join_container").find(".optionchk").prop("checked",true);
			// 약관 전체 체크가 해제되면
			} else{
				// container 안에 optionchk 클래스를 찾아서 checked를 false값을 넣는다.
				$(this).closest(".join_container").find(".optionchk").prop("checked",false);
			}
			enabled()
		});
		
		// 약관을 체크 하면
		$(".optionchk").click(function(){
			enabled()
			// 하위 옵션을 모두 체크 하면
             if($("input[class='optionchk']:checked").length == 4){
            	 // 약관 전체동의 체크 
                 $("#allchk").prop("checked",true);
           	// 모두 체크를 안하면
             } else {
            	 // 약관 전체동의 해제
                 $("#allchk").prop("checked",false);
             }
         });
		
		
		
		
		// 회원가입 버튼 활성화
		function enabled() {
			console.log(idchkok+","+pwtestok+","+pwchkok+","+ $("#essential1:checked").length+","+$("#essential2:checked").length)
			// 비밀번호 정규식, 비밀번호 확인, 필수 체크박스 체크시 
			if(idchkok == 1 && pwtestok == 1 && pwchkok == 1 && $("#essential1:checked").length == 1 && $("#essential2:checked").length == 1){
					// 버튼 활성화, 색 #111111로 변경
				$(".joinbtn").prop("disabled", false).css("background-color", "#111111");
			} else{
				$(".joinbtn").prop("disabled", true).css("background-color", "#999999");
			}
		}
		
		
		// 전화번호 입력시
		$("#phone").keyup(function(){
			// 입력한 값
		    const phoneNum = phone.value;
			// 입력한 값의 길이
		    const length = phoneNum.length;
			
		    // 2~3개 - 3~4개 - 4개
		    let numbers = phoneNum.replace(/[^0-9]/g, "")
		       			.replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
		    phone.value = numbers;
		});
		
		// 회원가입 시도
		function joinTry(f){
			console.log(f);
			submit();
		}
		
		
    </script>
</body>

</html>