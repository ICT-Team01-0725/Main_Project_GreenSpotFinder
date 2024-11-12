<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<nav class="mypage_nav">
    <ul>
        <li class="home" onclick="move_mypage_main()">
            <i class="fa-solid fa-house"></i>
        </li>
        <li class="dropdown">
            <div class="dropdown-menu">히스토리</div>
            <div class="dropdown-content">
                <p onclick="my_calendar()">캘린더</p>            <!-- 개별 캘린더 X / sub 4-1의 캘린더 페이지로 단순 이동 --> 
                <p onclick="my_scraps()">스크랩</p>              <!-- 현재 스크랩 불가 상태 / '공지사항' 으로 변경 / sub 5-1 공지사항 이동 -->
                <p onclick="my_review()">내가 쓴 리뷰</p>         <!-- 기존에 유지하기로 한 개인별 리뷰 페이지로 이동 --> 
            </div>
        </li>
        <li class="dropdown">
            <div class="dropdown-menu">내 정보 보기</div>
            <div class="dropdown-content">
                <p onclick="my_info_check()">내 프로필</p>       <!-- 기본 내용을 유지하되, mypage_profile.jsp와의 충돌 여부 확인하기 -->
            </div>
        </li>
        <li class="dropdown">
            <div class="dropdown-menu">문의 내역</div>
            <div class="dropdown-content">
                <p onclick="my_qna()">1 : 1 문의 내역</p>        <!-- 사용자별 1:1 문의로 이동하되, 만약 어려워진다면 sub 5-5로 이동하기 --> 
                <p onclick="my_report()">불편사항 신고 내역</p>    <!-- 사용자별 신고 내역으로 이동하되, 만약 어려워진다면 sub 5-3로 이동하기 -->
            </div>
        </li>
    </ul>
</nav>
