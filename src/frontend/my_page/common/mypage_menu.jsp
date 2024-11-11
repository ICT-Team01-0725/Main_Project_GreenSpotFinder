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
                <p onclick="my_calendar()">캘린더</p>
                <p onclick="my_scraps()">스크랩</p>
                <p onclick="my_review()">내가 쓴 리뷰</p>
            </div>
        </li>
        <li class="dropdown">
            <div class="dropdown-menu">내 정보 보기</div>
            <div class="dropdown-content">
                <p onclick="my_info_check()">내 프로필</p>
            </div>
        </li>
        <li class="dropdown">
            <div class="dropdown-menu">문의 내역</div>
            <div class="dropdown-content">
                <p onclick="my_qna()">1 : 1 문의 내역</p>
                <p onclick="my_report()">불편사항 신고 내역</p>
            </div>
        </li>
    </ul>
</nav>