<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!-- left-menu -->
<div class="sidebar">
    <ul class="sidebar-list">
        <li>
            <ul class="container">
                <div class="profile_container">
                    <ul class="profile">
                        <li>
                            <figure>
                                <img src="resources/images/CK_cb036052326.jpg" alt="" srcset="">
                            </figure>
                        </li>
                        <li>
                            <p class="profile_nickname">닉네임(아이디)</p>
                            <p class="profile_email">kim03189@naver.com</p>
                        </li>
                    </ul>
                    <ul class="profile_btn">
                       <li>
                           <button class="mypage" onclick="move_mypage_main()">마이페이지</button>
                       </li>
                       <li>
                           <button class="logout" onclick="logout()">로그아웃</button>
                       </li>
                    </ul>
                </div>
                    
                <ul class="slider_gnb">
	               <li onclick="move_login">
	                   로그인
	               </li>
	               <li onclick="move_join()">
	                   회원가입
	               </li>
	               <li onclick="move_customer()">
	                   고객센터
	               </li>
                </ul>
                <li class="sub_menu">
                    <div class="sub_menu_area">
                        <h3 class="title">
                            공원찾기
                        </h3>
                    </div>
                    <div class="answer">
                        <p class="text" onclick="move_sub1_1()">
                            공원 이야기
                        </p>
                        <p class="text" onclick="move_sub1_2()">
                            지역별 공원찾기
                        </p>
                        <p class="text" onclick="move_sub1_3()">
                            면적별 공원 찾기
                        </p>
                        <p class="text" onclick="move_sub1_4()">
                            공원 연락하기
                        </p>
                    </div>
                    <button class="btn">
                        <i class="fa-solid fa-chevron-up icon open"></i>
                        <i class="fa-solid fa-chevron-down icon close"></i>
                    </button>
                </li>
                <li class="sub_menu">
                    <div class="sub_menu_area">
                        <h3 class="title">
                            가로수길 찾기
                        </h3>
                    </div>
                    <div class="answer">
                        <p class="text" onclick="move_sub2_1()">
                            가로수길 걷기
                        </p>
                        <p class="text" onclick="move_sub2_2()">
                            지역별 가로수길 찾기
                        </p>
                        <p class="text" onclick="move_sub2_3()">
                            산책코스 찾기
                        </p>
                        <p class="text" onclick="move_sub2_4()">
                            가로수길 수목 조회
                        </p>
                    </div>
                    <button class="btn">
                        <i class="fa-solid fa-chevron-up icon open"></i>
                        <i class="fa-solid fa-chevron-down icon close"></i>
                    </button>
                </li>
                <li class="sub_menu">
                    <div class="sub_menu_area">
                        <h3 class="title">
                            지역 속 보호수
                        </h3>
                    </div>
                    <div class="answer">
                        <p class="text" onclick="move_sub3_1()">
                            보호수란?
                        </p>
                        <p class="text" onclick="move_sub3_2()">
                            지역별로 찾기
                        </p>
                        <p class="text" onclick="move_sub3_3()">
                            보호수 현황표
                        </p>
                    </div>
                    <button class="btn">
                        <i class="fa-solid fa-chevron-up icon open"></i>
                        <i class="fa-solid fa-chevron-down icon close"></i>
                    </button>
                </li>
                <li class="sub_menu">
                    <div class="sub_menu_area">
                        <h3 class="title">
                            녹지 행사
                        </h3>
                    </div>
                    <div class="answer">
                        <p class="text" onclick="move_sub4_1()">
                            날짜별 행사 찾기
                        </p>
                        <p class="text" onclick="move_sub4_2()">
                            지역별로 행사 찾기
                        </p>
                    </div>
                    <button class="btn">
                        <i class="fa-solid fa-chevron-up icon open"></i>
                        <i class="fa-solid fa-chevron-down icon close"></i>
                    </button>
                </li>
                <li class="sub_menu">
                    <div class="sub_menu_area">
                        <h3 class="title">
                            커뮤니티
                        </h3>
                    </div>
                    <div class="answer">
                        <p class="text" onclick="move_notice()">
                            공지사항
                        </p>
                        <p class="text" onclick="move_notice()">
                            리뷰
                        </p>
                        <p class="text" onclick="move_notice()">
                            고객의 소리
                        </p>
                        <p class="text" onclick="location.href='faq.html'">
                            자주하는 질문
                        </p>
                        <p class="text" onclick="location.href='qna.html'">
                            1:1 문의
                        </p>
                    </div>
                    <button class="btn">
                        <i class="fa-solid fa-chevron-up icon open"></i>
                        <i class="fa-solid fa-chevron-down icon close"></i>
                    </button>
                </li>
            </ul>
            <div class="weather_widget">
                <img src="resources/images/weather_widget.png" alt="날씨 위젯">
            </div>
        </li>
    </ul>
</div>