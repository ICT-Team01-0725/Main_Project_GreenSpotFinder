<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- user profile -->
<div class="user_profile">
    <ul class="user_profile_ul">
        <li class="user_profile_photo">
            <figure>
                <img src="resources/images/rewiew_1.jpg" alt="rewiew_1">
            </figure>
        </li>
        <li class="user_profile_contents">
            <div class="my_profile">
                <p class="name">손흥민</p>            <!--MySQL : user_tbl / u_id -->
                <p class="birth">kim03189</p>       <!--MySQL : user_tbl / u_bir -->  

                <ul class="my_btn">
                    <li>
                        <button onclick="my_info_check()">내 프로필</button>
                    </li>
                    <li>
                        <button onclick="my_info_mody()">회원정보 수정</button>
                    </li>
                </ul>
            </div>
        </li>
        <li class="user_profile_number">
            <div class="my_num">
                <ul>
                    <li>
                        <!-- 변경 : '내가 한 신고'로 변경 -->
                        <p>나의 리뷰</p>
                        <span class="nums" data-count="10">0</span>
                    </li>
                    <li>
                        <!-- 변경 : '내가 한 문의'로 변경 -->
                        <p>나의 스크랩</p>
                        <span class="nums" data-count="50">0</span>
                    </li>
                    <li>
                        <!-- 변경 : '가입일수'로 변경 -->
                        <p>내가 쓴 게시물</p>
                        <span class="nums" data-count="6">0</span>
                    </li>
                </ul>
            </div>
        </li>
    </ul>
</div>
