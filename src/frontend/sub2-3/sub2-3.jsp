<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공원 이야기</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
	integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link rel="stylesheet" href="resources/css/menu.css" />
<link rel="stylesheet" href="resources/css/sub2-3.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="resources/js/menu.js"></script>

<script
	src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<script defer src="resources/js/swiper_controller.js"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=39530db7eeb40a4bb4bf295655f60971&libraries=services"></script>

</head>
<body>
	<div id="sub_main_container">
		<!-- sub_header 불러오기 -->
		<jsp:include page="./common/sub_header.jsp"></jsp:include>



		<!-- nav-left -->
		<!-- nav-left -->
		<main>
			<div class="sub2-3">
				<div id="sub_container">
					<ul class="contents_box">
						<li class="textcenter">
							<h2 class="great_title">산책 코스 찾기</h2>
							<p class="subheading_title">원하는 요건을 선택하여 산책코스를 찾아보세요</p>


							<form action="searchRoad" method="get">
								<div class="filter_walking_find active">
									<ul class="walking_find_ul">
										<li>
											<p>산책코스 위치</p> <label> <input type="text"
												name="searchKeyword" value="${searchKeyword}"
												placeholder="도시명 입력">
										</label>
										</li>

										<li>
											<button class="search" onclick="search(this.form)">검색</button>
										</li>
									</ul>
								</div>

							</form>
							<div class="course_top_contents">
								<h4>추천산책코스</h4>
								<ul class="course_ul">
									<li>가고 싶은 가로수길의 위치를 확인해보세요</li>
								</ul>
							</div>
							<div class="course_slider">
								<!-- Slider main container -->
								<div class="swiper">
									<!-- Additional required wrapper -->
									<div class="swiper-wrapper">
										<!-- Slides -->
										<div class="swiper-slide">
											<ul class="course_ul">
												<li class="course_map">
													<div id="map" style="width: 100%; height: 400px;"></div>
												</li>
						</li>
						<li class="course_container">
							<div class="course_title">
								<p>산책 코스</p>
							</div>
							<div class="course_contents">
								<ul class="">
									<li>
										<p>산책코스 위치</p>
										<p>${course}</p> <!-- 여기에서 JSP로 값을 넣을 수 없습니다. JavaScript에서 처리해야 함 -->
									</li>
									<li>
										<p>수종</p>
										<p>${treetype}</p> <!-- JavaScript로 처리해야 하는 값 -->
									</li>
									<li>
										<p>그루 수</p>
										<p>${treecount}그루</p>
									</li>
									<li>
										<p>산책거리</p>
										<p>${length}Km</p>
									</li>
								</ul>
							</div>
							<div class="course_result">
								<p>
									해당 추천산책코스의 산책 거리는 총 <span>${length} km</span> 이며, <br> 총 <span>${calories}
										kcal</span> 를 소모합니다

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
	<!-- 컨텐츠 영역(main) 끝 -->


	<!-- footer 불러오기 -->
	<jsp:include page="./common/sub_footer.jsp"></jsp:include>
	</main>

	<!-- 모바일 메뉴 불러오기 -->
	<jsp:include page="./common/sub_m_menu.jsp"></jsp:include>
	</div>


	<jsp:include page="./common/topBtn.jsp"></jsp:include>



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


        $("button.filter").click(function(){
            $(".walking_find_result").toggleClass("block");
        });

        function search(f) {
            $(".walking_find_result").addClass("block");
			f.submit();
        }

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

        
	    // 서버에서 전달된 값 또는 기본값 설정
	    const roadList = "${roadList}" || [];  // 기본값 빈 배열
	    const firstStartLat = "${startLat}" || 37.5665; // 서울시청 좌표 (기본값)
	    const firstStartLng = "${startLon}" || 126.9780;
	    const firstEndLat = "${endLat}" || 37.5651; // 예시 좌표
	    const firstEndLng = "${endLon}" || 126.9894;

	    console.log(firstStartLat);
	    console.log(firstStartLng);
	    console.log(firstEndLat);
	    console.log(firstEndLng);

	    // 지도 생성
	    var mapContainer = document.getElementById('map'),
	        mapOption = {
	            center: new kakao.maps.LatLng(firstStartLat, firstStartLng), // 기본 좌표
	            level: 5 // 확대 수준 설정
	        };
	    var map = new kakao.maps.Map(mapContainer, mapOption);

	    // 시작 및 끝 마커 생성
	    var startMarker = new kakao.maps.Marker({
	        position: new kakao.maps.LatLng(firstStartLat, firstStartLng),
	        map: map
	    });
	    var endMarker = new kakao.maps.Marker({
	        position: new kakao.maps.LatLng(firstEndLat, firstEndLng),
	        map: map
	    });
	   
	    
	    map.setCenter(new kakao.maps.LatLng(firstStartLat, firstStartLng));
	    
	    
	    //
	    // Kakao 길찾기 REST API 호출 함수
    async function getRoute( startLng,startLat, endLng, endLat) {
    	console.log("경도", startLat, startLng, endLat, endLng);
        const REST_API_KEY = "7c79589a716fc6110f83c9c147e34ec8"; // REST API 키
        const url = "https://apis-navi.kakaomobility.com/v1/directions?origin=" + startLat + "," + startLng + "&destination=" + endLat + "," + endLng;
        console.log("url : ", url);
        try {
            const response = await fetch(url, {
                method: 'GET',
                headers: {
                	 'Authorization': 'KakaoAK 7c79589a716fc6110f83c9c147e34ec8'
                }
            });

            if (response.ok) {
                const data = await response.json();
                return data;
            } else {
                console.error('API 요청 실패뜸 ?:', response.statusText);
            }
        } catch (error) {
            console.error('네트워크 오류:', error);
        }
    }

    async function drawRouteOnMap(startLng, startLat, endLng, endLat) {
        const data = await getRoute(startLng, startLat, endLng, endLat);
        console.log("API 응답 데이터:", data);  // 응답 데이터 확인

        if (data && data.routes && data.routes.length > 0) {
            const path = [];
            const roads = data.routes[0].sections[0].roads;

            // roads 배열을 확인하여 좌표를 추가
            roads.forEach(road => {
                console.log("road 데이터:", road);  // road 데이터를 확인
                const vertexes = road.vertexes;
                for (let i = 0; i < vertexes.length; i += 2) {
                    if (vertexes[i + 1] !== undefined) {
                        // Lng, Lat 순서로 좌표 생성
                        path.push(new kakao.maps.LatLng(vertexes[i + 1], vertexes[i]));
                    }
                }
            });

            console.log("경로 좌표 path:", path);  // 생성된 경로 좌표 배열 확인

            // 폴리라인 생성 (경로 그리기)
            const polyline = new kakao.maps.Polyline({
                map: map,
                path: path,
                strokeWeight: 5,
                strokeColor: '#000',
                strokeOpacity: 0.7,
                strokeStyle: 'solid'
            });
            polyline.setMap(map);
            
            // 폴리라인 경로에 맞춰 지도의 범위를 설정
            const bounds = new kakao.maps.LatLngBounds();
            path.forEach(point => bounds.extend(point));
            map.setBounds(bounds);
        } else {
            alert('경로 정보를 가져오지 못했습니다.');
        }
    }
    // 경로 그리기 함수 호출
    (async () => {
        await drawRouteOnMap(firstStartLat, firstStartLng, firstEndLat, firstEndLng);
       // 경로 그리고 가운데로 호출
  
    }) ();


	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    // 코스 데이터 설정 (예시)
	    const course = "${course}" || "서울시청";
	    const treetype = "${treetype}" || "소나무";
	    const treecount = "${treecount}" || "50 그루" ;
	    const length = "${length}" || "2000";
        const calories = "${calories}"; 
        
	    // HTML에 값을 채워넣기
	    document.querySelector(".course_title p").textContent = "	산책 코스";
	    document.querySelector(".course_contents li:nth-child(1) p:nth-child(2)").textContent = course;
	    document.querySelector(".course_contents li:nth-child(2) p:nth-child(2)").textContent = treetype;
	    document.querySelector(".course_contents li:nth-child(3) p:nth-child(2)").textContent = `${treecount}그루의 ${treetype}`;
	    document.querySelector(".course_contents li:nth-child(4) p:nth-child(2)").textContent = `${length}m`;

	    // 결과 텍스트도 설정
	    document.querySelector(".course_result p").innerHTML = `해당 추천산책코스의 산책 거리는 총 <span>${length}km</span> 이며, <br> 총 <span> ${calories}kcal</span>를 소모합니다`;


    </script>
</body>
</html>