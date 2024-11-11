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
    
    <link rel="stylesheet" href="/resources/css/menu.css" />
    <link rel="stylesheet" href="/resources/css/sub2-3.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="resources/js/menu.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
    <script defer src="/resources/js/swiper_controller.js"></script>
</head>
<body>
	<div id="sub_main_container">
        <!-- sub_header 불러오기 -->
        <jsp:include page="../common/sub_header.jsp"></jsp:include>
        
        <!-- 컨텐츠 영역(main) 시작 -->
        <main>
            <div class="sub2-3"> 
                <div id="sub_container">
                    <ul class="contents_box">
                        <li class="textcenter">
                            <h2 class="great_title">산책 코스 찾기</h2>
                            <p class="subheading_title">원하는  요건을 선택하여 산책코스를 찾아보세요</p>



                            <form action="#" method="get">
                                <div class="walking_find_result">
                                    <ul>
                                        <li>
                                            <div class="walking_find_title">
                                                산책코스 위치
                                            </div>
                                            <div class="walking_find_chk">
                                                <ul>
                                                    <li>
                                                        <input type="checkbox" class="course" name="course_all" id="course_all" />
                                                        <label for="course_all">전체</label>
                                                    </li>
                                                    <li>
                                                        <input type="checkbox" class="course" name="course" id="course_1" />
                                                        <label for="course_1">서울</label>
                                                    </li>
                                                    <li>
                                                        <input type="checkbox" class="course" name="course" id="course_2" />
                                                        <label for="course_2">경기</label>
                                                    </li>
                                                    <li>
                                                        <input type="checkbox" class="course" name="course" id="course_3" />
                                                        <label for="course_3">인천</label>
                                                    </li>
                                                    <li>
                                                        <input type="checkbox" class="course" name="course" id="course_4" />
                                                        <label for="course_4">강원</label>
                                                    </li>
                                                    <li>
                                                        <input type="checkbox" class="course" name="course" id="course_5" />
                                                        <label for="course_5">충청</label>
                                                    </li>
                                                    <li>
                                                        <input type="checkbox" class="course" name="course" id="course_6" />
                                                        <label for="course_6">전남</label>
                                                    </li>
                                                    <li>
                                                        <input type="checkbox" class="course" name="course" id="course_7" />
                                                        <label for="course_7">전북</label>
                                                    </li>
                                                    <li>
                                                        <input type="checkbox" class="course" name="course" id="course_8" />
                                                        <label for="course_8">경남</label>
                                                    </li>
                                                    <li>
                                                        <input type="checkbox" class="course" name="course" id="course_9" />
                                                        <label for="course_9">경북</label>
                                                    </li>
                                                    <li>
                                                        <input type="checkbox" class="course" name="course" id="course_10" />
                                                        <label for="course_10">제주</label>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="walking_find_title">
                                                수종
                                            </div>
                                            <div class="walking_find_chk">
                                                <ul>
                                                    <li>
                                                        <input type="checkbox" class="dropsy" name="dropsy_all" id="dropsy_all" />
                                                        <label for="dropsy_all">전체</label>
                                                    </li>
                                                    <li>
                                                        <input type="checkbox" class="dropsy" name="dropsy" id="dropsy_1" />
                                                        <label for="dropsy_1">벚나무</label>
                                                    </li>
                                                    <li>
                                                        <input type="checkbox" class="dropsy" name="dropsy" id="dropsy_2" />
                                                        <label for="dropsy_2">은행나무</label>
                                                    </li>
                                                    <li>
                                                        <input type="checkbox" class="dropsy" name="dropsy" id="dropsy_3" />
                                                        <label for="dropsy_3">단풍나무</label>
                                                    </li>
                                                    <li>
                                                        <input type="checkbox" class="dropsy" name="dropsy" id="dropsy_4" />
                                                        <label for="dropsy_4">자작나무</label>
                                                    </li>
                                                    <li>
                                                        <input type="checkbox" class="dropsy" name="dropsy" id="dropsy_5" />
                                                        <label for="dropsy_5">메타세콰이어</label>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="walking_find_title">
                                                가로수 분포도
                                            </div>
                                            <div class="walking_find_chk">
                                                <ul>
                                                    <li>
                                                        <input type="checkbox" class="distribution" name="distribution_all" id="distribution_all" />
                                                        <label for="distribution_all">전체</label>
                                                    </li>
                                                    <li>
                                                        <input type="checkbox" class="distribution" name="distribution" id="distribution_1" />
                                                        <label for="distribution_1">밀집</label>
                                                    </li>
                                                    <li>

                                                        <input type="checkbox" class="distribution" name="distribution" id="distribution_2" />
                                                        <label for="distribution_2">보통</label>
                                                    </li>
                                                    <li>
                                                        <input type="checkbox" class="distribution" name="distribution" id="distribution_3" />
                                                        <label for="distribution_3">낮음</label>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="walking_find_title">
                                                산책 거리
                                            </div>
                                            <div class="walking_find_chk">
                                                <ul>
                                                    <li>
                                                        <input type="checkbox" class="distance" name="distance_all" id="distance_all" />
                                                        <label for="distance_all">전체</label>
                                                    </li>
                                                    <li>
                                                        
                                                        <input type="checkbox" class="distance" name="distance" id="distance_1" />
                                                        <label for="distance_1">장거리</label>
                                                    </li>
                                                    <li>
                                                        <input type="checkbox" class="distance" name="distance" id="distance_2" />
                                                        <label for="distance_2">중거리</label>
                                                    </li>
                                                    <li>
                                                        <input type="checkbox" class="distance" name="distance" id="distance_3" />
                                                        <label for="distance_3">단거리</label>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                                
                                <button class="search" onclick="search(this.form)">검색</button>
                            </form>
                            <div class="course_top_contents">
                                <h4>
                                    추천산책코스
                                </h4>
                                <ul class="course_ul"> 
                                    <li>
                                        가고 싶은 가로수길의 위치를 확인해보세요
                                    </li>
                                    <li>
                                        추천코스  총 10건
                                    </li>
                                </ul>  
                            </div>             
                            <div class="course_slider">
                                <!-- Slider main container -->
                                <div class="swiper">
                                    <!-- Additional required wrapper -->
                                    <div class="swiper-wrapper">
                                        <!-- Slides -->
                                        <div class="swiper-slide"  onclick="location.href='sub4-1.html'">
                                            <ul class="course_ul">
                                                <li class="course_map">
                                                    <!-- * 카카오맵 - 지도퍼가기 -->
                                                    <!-- 1. 지도 노드 -->
                                                    <div id="daumRoughmapContainer1729606213318" class="root_daum_roughmap root_daum_roughmap_landing"></div>

                                                    <!--
                                                        2. 설치 스크립트
                                                        * 지도 퍼가기 서비스를 2개 이상 넣을 경우, 설치 스크립트는 하나만 삽입합니다.
                                                    -->
                                                    <script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

                                                    <!-- 3. 실행 스크립트 -->
                                                    <script charset="UTF-8">
                                                        new daum.roughmap.Lander({
                                                            "timestamp" : "1729606213318",
                                                            "key" : "2mz4b",
                                                            "mapWidth" : "640",
                                                            "mapHeight" : "378"
                                                        }).render();
                                                    </script>
                                                </li>
                                                <li class="course_container">
                                                    <div class="course_title">
                                                        <p>첫번째 산책 코스</p>
                                                    </div>
                                                    <div class="course_contents">
                                                        <ul class="">
                                                            <li>
                                                                <p>산책코스 위치</p>
                                                                <p>서울 (경로  ~ 경로)</p>
                                                            </li>
                                                            <li>
                                                                <p>수종</p>
                                                                <p>벚나무</p>
                                                            </li>
                                                            <li>
                                                                <p>가로수 분포도</p>
                                                                <p>높음</p>
                                                            </li>
                                                            <li>
                                                                <p>산책거리</p>
                                                                <p>중거리</p>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                    <div class="course_result">
                                                        <p>
                                                            해당 추천산책코스의 산책 거리는 총 <span>1.1km</span> 이며, <br>
                                                            총 <span>46 kcal</span>를 소모합니다 
                                                        </p>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="swiper-slide"  onclick="location.href='sub4-1.html'">
                                            <ul class="course_ul">
                                                <li class="course_map">
                                                    <!-- * 카카오맵 - 지도퍼가기 -->
                                                    <!-- 1. 지도 노드 -->
                                                    <div id="daumRoughmapContainer1729607437653" class="root_daum_roughmap root_daum_roughmap_landing"></div>

                                                    <!--
                                                        2. 설치 스크립트
                                                        * 지도 퍼가기 서비스를 2개 이상 넣을 경우, 설치 스크립트는 하나만 삽입합니다.
                                                    -->
                                                    <script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

                                                    <!-- 3. 실행 스크립트 -->
                                                    <script charset="UTF-8">
                                                        new daum.roughmap.Lander({
                                                            "timestamp" : "1729607437653",
                                                            "key" : "2mz4h",
                                                            "mapWidth" : "640",
                                                            "mapHeight" : "378"
                                                        }).render();
                                                    </script>
                                                </li>
                                                <li class="course_container">
                                                    <div class="course_title">
                                                        <p>두번째 산책 코스</p>
                                                    </div>
                                                    <div class="course_contents">
                                                        <ul class="">
                                                            <li>
                                                                <p>산책코스 위치</p>
                                                                <p>서울 (경로  ~ 경로)</p>
                                                            </li>
                                                            <li>
                                                                <p>수종</p>
                                                                <p>벚나무</p>
                                                            </li>
                                                            <li>
                                                                <p>가로수 분포도</p>
                                                                <p>높음</p>
                                                            </li>
                                                            <li>
                                                                <p>산책거리</p>
                                                                <p>중거리</p>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                    <div class="course_result">
                                                        <p>
                                                            해당 추천산책코스의 산책 거리는 총 <span>1.1km</span> 이며, <br>
                                                            총 <span>46 kcal</span>를 소모합니다 
                                                        </p>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="swiper-slide"  onclick="location.href='sub4-1.html'">
                                            <ul class="course_ul">
                                                <li class="course_map">
                                                    <!-- * 카카오맵 - 지도퍼가기 -->
                                                    <!-- 1. 지도 노드 -->
                                                    <div id="daumRoughmapContainer1729608084814" class="root_daum_roughmap root_daum_roughmap_landing"></div>

                                                    <!--
                                                        2. 설치 스크립트
                                                        * 지도 퍼가기 서비스를 2개 이상 넣을 경우, 설치 스크립트는 하나만 삽입합니다.
                                                    -->
                                                    <script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

                                                    <!-- 3. 실행 스크립트 -->
                                                    <script charset="UTF-8">
                                                        new daum.roughmap.Lander({
                                                            "timestamp" : "1729608084814",
                                                            "key" : "2mz4k",
                                                            "mapWidth" : "640",
                                                            "mapHeight" : "378"
                                                        }).render();
                                                    </script>
                                                </li>
                                                <li class="course_container">
                                                    <div class="course_title">
                                                        <p>세번째 산책 코스</p>
                                                    </div>
                                                    <div class="course_contents">
                                                        <ul class="">
                                                            <li>
                                                                <p>산책코스 위치</p>
                                                                <p>서울 (경로  ~ 경로)</p>
                                                            </li>
                                                            <li>
                                                                <p>수종</p>
                                                                <p>벚나무</p>
                                                            </li>
                                                            <li>
                                                                <p>가로수 분포도</p>
                                                                <p>높음</p>
                                                            </li>
                                                            <li>
                                                                <p>산책거리</p>
                                                                <p>중거리</p>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                    <div class="course_result">
                                                        <p>
                                                            해당 추천산책코스의 산책 거리는 총 <span>1.1km</span> 이며, <br>
                                                            총 <span>46 kcal</span>를 소모합니다 
                                                        </p>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <!-- If we need pagination -->
                                    <!-- <div class="swiper-pagination"></div> -->
                                </div>
                            </div>
                            
                            <div class="swiper-button-container">
                                <!-- If we need navigation buttons -->
                                <div class="swiper-button-prev">
                                    <div class="material-icons">arrow_back</div>
                                </div>
                                <div class="swiper-button-next">
                                    <div class="material-icons">arrow_forward</div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        	
        	
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

        // 체크박스
        $(document).ready(function(){
            // 산책코스 위치 - 체크 박스 전체 선택 및 전체 해제
            $("#course_all").click(function(){
                if ($("#course_all").is(":checked")){
                    $(".course").prop("checked",true);
                } else {
                    $(".course").prop("checked",false);
                }
            });

            $(".course").click(function(){
                if($("input[name='course']:checked").length == 10){
                    $("#course_all").prop("checked",true);
                } else {
                    $("#course_all").prop("checked",false);
                }
            });

            // 수종 위치 - 체크 박스 전체 선택 및 전체 해제
            $("#dropsy_all").click(function(){
                if ($("#dropsy_all").is(":checked")){
                    $(".dropsy").prop("checked",true);
                } else {
                    $(".dropsy").prop("checked",false);
                }
            });

            $(".dropsy").click(function(){
                if($("input[name='dropsy']:checked").length == 5){
                    $("#dropsy_all").prop("checked",true);
                } else {
                    $("#dropsy_all").prop("checked",false);
                }
            });

            // 가로수 분포도 위치 - 체크 박스 전체 선택 및 전체 해제
            $("#distribution_all").click(function(){
                if ($("#distribution_all").is(":checked")){
                    $(".distribution").prop("checked",true);
                } else {
                    $(".distribution").prop("checked",false);
                }
            });

            $(".distribution").click(function(){
                if($("input[name='distribution']:checked").length == 3){
                    $("#distribution_all").prop("checked",true);
                } else {
                    $("#distribution_all").prop("checked",false);
                }
            });

            // 산책 거리 위치 - 체크 박스 전체 선택 및 전체 해제
            $("#distance_all").click(function(){
                if ($("#distance_all").is(":checked")){
                    $(".distance").prop("checked",true);
                } else {
                    $(".distance").prop("checked",false);
                }
            });

            $(".distance").click(function(){
                if($("input[name='distance']:checked").length == 3){
                    $("#distance_all").prop("checked",true);
                } else {
                    $("#distance_all").prop("checked",false);
                }
            });
        });
    </script>
</body>
</html>