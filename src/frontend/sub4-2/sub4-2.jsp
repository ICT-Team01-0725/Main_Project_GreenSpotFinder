<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>공원 이야기</title>
	<link rel="icon" type="image/x-icon" href="resources/images/favicon.png">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css">
    
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css"/>
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    
    <link rel="stylesheet" href="resources/css/menu.css" />
    <link rel="stylesheet" href="resources/css/region_menubar.css" />
    <link rel="stylesheet" href="resources/css/sub4-2.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="/resources/js/menu.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
    <script defer src="/resources/js/swiper_controller.js"></script>
</head>
<body>
	<div id="sub_main_container">
        <!-- sub_header 불러오기 -->
        <jsp:include page="../common/sub_header.jsp"></jsp:include>
        
        <!-- 컨텐츠 영역(main) 시작 -->
        <main>
            <div id="sub_container">
                <ul class="contents_box">
                    <li class="textcenter">
                        <h2 class="great_title">지역별 행사 찾기</h2>
                        <p class="subheading_title">원하는 지역에서의 녹지행사를 찾아보세요</p>
                        
                        <div class="m_menu_slide">
                            <div class="swiper">
                                <div class="swiper-wrapper sub_menu2">
                                    <div class="swiper-slide cur_submenu" onclick="location.href='/content/greetings'">
                                        <span>서울</span>
                                    </div>
                                    <div class="swiper-slide " onclick="location.href='/content/mission'">
                                        <span>경기</span>
                                    </div>
                                    <div class="swiper-slide " onclick="location.href='/content/faculty_introduction'">
                                        <span>인천</span>
                                    </div>
                                    <div class="swiper-slide " onclick="location.href='/content/faculty_recruitment'">
                                        <span>강원</span>
                                    </div>
                                    <div class="swiper-slide " onclick="location.href='/content/mou_school'">
                                        <span>충청</span>
                                    </div>
                                    <div class="swiper-slide " onclick="location.href='/content/contact'">
                                        <span>전남</span>
                                    </div>
                                    <div class="swiper-slide " onclick="location.href='/content/contact'">
                                        <span>전북</span>
                                    </div>
                                    <div class="swiper-slide " onclick="location.href='/content/contact'">
                                        <span>경남</span>
                                    </div>
                                    <div class="swiper-slide " onclick="location.href='/content/contact'">
                                        <span>경북</span>
                                    </div>
                                    <div class="swiper-slide " onclick="location.href='/content/contact'">
                                        <span>제주</span>
                                    </div>
                                </div>
                                
                                <div class="swiper-button-prev">
                                    <div class="material-icons">arrow_back</div>
                                </div>
                                <div class="swiper-button-next">
                                    <div class="material-icons">arrow_forward</div>
                                </div>
                            </div>
                        </div>


                        <div class="region_event">
                        	<ul class="region_event_menu">
                        		<li class="event_held">
                        			구분
                        		</li>
                        		<li class="event_img">
                        			이미지
                        		</li>
                        		<li class="event_contents">
                        			행사정보
                        		</li>
                        	</ul>
                        	<ul class="region_event_list">
                        		<li class="event_held">
                        			개최중
                        		</li>
                        		<li class="event_img">
                        			<img src="/resources/images/rewiew_1.jpg" alt="rewiew_1">
                        		</li>
                        		<li class="event_contents">
                        			<p class="event_title">생장 활동이 활발하지 못한 늙은 나무</p>
                        			<p class="event_subtitle">양재 매헌시민의 숲 광장</p>
                        			<p class="event_start_day"><span>시작일 :</span> 2024년 11월 08일 (금)</p>
                        			<p class="event_end_day"><span>종료일 :</span> 2024년 11월 17일 (일)</p>
                        		</li>
                        	</ul>
                        	<ul class="region_event_list">
                        		<li class="event_held">
                        			개최 예정
                        		</li>
                        		<li class="event_img">
                        			<img src="/resources/images/rewiew_1.jpg" alt="rewiew_1">
                        		</li>
                        		<li class="event_contents">
                        			<p class="event_title">생장 활동이 활발하지 못한 늙은 나무</p>
                        			<p class="event_subtitle">양재 매헌시민의 숲 광장</p>
                        			<p class="event_start_day"><span>시작일 :</span> 2024년 11월 08일 (금)</p>
                        			<p class="event_end_day"><span>종료일 :</span> 2024년 11월 17일 (일)</p>
                        		</li>
                        	</ul>
                        </div>
                    
	                    <div>
	                        <ul class="paging_num_ul">
	                            <li class="material-icons prev">
	                                keyboard_double_arrow_left
	                            </li>
	                            <li class="material-icons prev">
	                                chevron_left
	                            </li>
	                            <li class="active">1</li>
	                            <li>2</li>
	                            <li>3</li>
	                            <li>4</li>
	                            <li>5</li>
	                            <li class="material-icons next">
	                                chevron_right
	                            </li>
	                            <li class="material-icons next">
	                                keyboard_double_arrow_right
	                            </li>
	                        </ul>
	                    </div>
                    </li>
                </ul>
            </div>
        	<!-- 컨텐츠 영역(main) 끝 -->
        	
        	
        	<!-- footer 불러오기 -->
        	<jsp:include page="../common/sub_footer.jsp"></jsp:include>
        </main>
        	
        <!-- 모바일 메뉴 불러오기 -->
        <jsp:include page="../common/sub_m_menu.jsp"></jsp:include>
    </div>
    
    
    <jsp:include page="../common/topBtn.jsp"></jsp:include>
    

    
    <script>
        $(document).ready(function () {
            function toggleSidebar() {
                $(".button").toggleClass("active");
                $("main").toggleClass("move-to-left");
                $(".sidebar-item").toggleClass("active");
                $(".sidebar-item").toggleClass("active");
            }

            $(".button").on("click tap", function () {
                toggleSidebar();
            });

            
        });

        const btns = document.querySelectorAll(".sub_menu_area, .btn");

        btns.forEach((btn) => {
            btn.addEventListener("click", () => {
                const faqItem = btn.parentNode;
                const isActive = faqItem.classList.contains("active");

                removeActiveClasses();

                if (!isActive) {
                    faqItem.classList.add("active");
                }
            });
        });

        function removeActiveClasses() {
            btns.forEach((btn) => {
                btn.parentNode.classList.remove("active");
            });
        }

        function open_chatroom(){
            var windowWidth = $( window ).width(); 
            if(windowWidth > 1000) {
                //창 가로 크기가 500 미만일 경우  
                console.log("1000px 이상");
                
                $(".sidebar").addClass("displayNone");
                $(".sidebar").removeClass("displayBlock");
                $("main").removeClass("move-to-left");
                $(".button").removeClass("active");

                
                    
            } else if(windowWidth > 768) {
                //창 가로 크기가 500 미만일 경우  
                console.log("768px 이상");
                $(".sidebar").removeClass("displayNone");
                $(".sidebar").addClass("displayBlock");
                
            } else if(windowWidth > 480) {
                //창 가로 크기가 500 미만일 경우  
                console.log("480px 이상");
                $(".sidebar").removeClass("displayNone");
                $(".sidebar").addClass("displayBlock");
            }
        }

        $( window ).resize(function() {
            //창크기 변화 감지
            open_chatroom();
        });

        open_chatroom();

        // sroll top Script
        const basicScrollTop = function () {
            // The button
            const btnTop = document.querySelector('#goTop');
            // Reveal the button
            const btnReveal = function () {
                if (window.scrollY >= 300) {
                    btnTop.classList.add('is-visible');
                } else {
                    btnTop.classList.remove('is-visible');
                }
            }
            // Smooth scroll top
            // Thanks to => http://stackoverflow.com/a/22610562
            const TopscrollTo = function () {
                if (window.scrollY != 0) {
                    setTimeout(function () {
                        window.scrollTo(0, window.scrollY - 30);
                        TopscrollTo();
                    }, 5);
                }
            }
            // Listeners
            window.addEventListener('scroll', btnReveal);
            btnTop.addEventListener('click', TopscrollTo);

        };
        basicScrollTop();
    </script>
</body>
</html>