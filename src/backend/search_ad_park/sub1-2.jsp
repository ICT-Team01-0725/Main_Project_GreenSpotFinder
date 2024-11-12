<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>지역별 공원 찾기</title>
<!-- css 초기화 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css">
<!-- CSS 파일 링크 -->
<link rel="stylesheet" type="text/css" href="/resources/css/common.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/sub1-2.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
<!-- fontawesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" />
<!-- Material icon -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- Kakao Map API SDK -->
<script
	src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=ab07141ee929664c409a80cf396d1118&libraries=services"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>

<script type="text/javascript" src="/resources/js/swiper_controller2.js"></script>
</head>


<body>


	<div id="sub_main_container">
		<div class="wrap"></div>

		<!-- nav-left -->
		<main>
			<div id="sub_container">
				<ul class="contents_box">
					<li class="textcenter">
						<h2 class="great_title">지역별 공원 찾기</h2>
						<p class="subheading_title">가고 싶은 공원의 위치를 확인해보세요</p> <!-- 검색 폼 -->
						<ul class="sub_search_container">
							<li class="sub_search">
								<div class="sub_search_div">
									<form action="/park/searchPark" method="get">
										<input type="text" name="p_ad" placeholder="상세주소로 검색하기">
										<button type="submit">
											<span class="material-icons">search</span>
										</button>
									</form>
								</div>
							</li>
						</ul>

						<div class="m_menu_slide">
							<div class="swiper">
								<div class="swiper-wrapper sub_menu2">
									<div class="swiper-slide cur_submenu" onclick="location.href='/park/findPark?region=서울'">
										<span>서울</span>
									</div>
									<div class="swiper-slide" onclick="location.href='/park/findPark?region=경기'">
										<span>경기</span>
									</div>
									<div class="swiper-slide" onclick="location.href='/park/findPark?region=인천'">
										<span>인천</span>
									</div>
									<div class="swiper-slide" onclick="location.href='/park/findPark?region=강원'">
										<span>강원</span>
									</div>
									<div class="swiper-slide" onclick="location.href='/park/findPark?region=충청'">
										<span>충청</span>
									</div>
									<div class="swiper-slide" onclick="location.href='/park/findPark?region=경상'">
										<span>경상</span>
									</div>
									<div class="swiper-slide" onclick="location.href='/park/findPark?region=전라'">
										<span>전라</span>
									</div>
									<div class="swiper-slide" onclick="location.href='/park/findPark?region=제주'">
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
						
						
                               <ul class="region_paging_ul total_search_mg">
                            <li class="region_list">
                                <ul class="paging_list_ul">
									<!-- 첫 화면에 공원 리스트 출력 -->
									<c:choose>
                                        <c:when test="${isFirstVisit}">
                                            <h3>가장 인기 있는 공원 4곳</h3>
                                            <c:forEach var="park" items="${parkList}">
                                                <li>
                                                    <ul class="paging_list">
                                                        <li class="category"><span>지역</span></li>
                                                        <li class="content">
                                                            <h4>${park.p_na}</h4>
                                                            <p class="text">${park.p_ce_na}</p>
                                                            <p class="address">${park.p_ad}</p>
                                                        </li>
                                                    </ul>
                                                </li>
                                            </c:forEach>
                                        </c:when>

                                        <c:when test="${not empty parkList}">
                                            <c:forEach var="park" items="${parkList}">
                                                <li>
                                                    <ul class="paging_list">
                                                        <li class="category"><span>지역</span></li>
                                                        <li class="content">
                                                            <h4>${park.p_na}</h4>
                                                            <p class="text">${park.p_ce_na}</p>
                                                            <p class="address">${park.p_ad}</p>
                                                        </li>
                                                    </ul>
                                                </li>
                                            </c:forEach>
                                        </c:when>

                                        <c:otherwise>
                                            <p style="margin-top: 30px;">검색 결과가 없습니다.</p>
                                        </c:otherwise>
                                    </c:choose>
								</ul>
								<!-- 페이지 네비게이션 추가 -->
								<ul class="paging_num_ul">
									<li class="material-icons prev">keyboard_double_arrow_left</li>
									<li class="material-icons prev">chevron_left</li>
									<li class="active">1</li>
									<li>2</li>
									<li>3</li>
									<li>4</li>
									<li>5</li>
									<li class="material-icons next">chevron_right</li>
									<li class="material-icons next">keyboard_double_arrow_right</li>
								</ul>
							</li>

							<!-- 지도 표시 섹션 -->
							<li class="region_map">
								<div id="map" style="width: 100%; height: 723px;"></div>
							</li>
						</ul>
					</li>
				</ul>
			</div>

			<footer> </footer>
		</main>
	</div>

	<script>
		window.onload = function() {
			// 카카오 맵 초기화
			var mapContainer = document.getElementById('map');
			var mapOption = {
				center : new kakao.maps.LatLng(33.450701, 126.570667), // 기본 중심 좌표
				level : 3 // 기본 확대 수준
			};
			var map = new kakao.maps.Map(mapContainer, mapOption); // 지도 생성

			// 마커를 추가할 LatLngBounds 객체 생성
			var bounds = new kakao.maps.LatLngBounds();

			// 검색된 공원 리스트에 대해 마커 생성
			<c:if test="${not empty parkList}">
			<c:forEach var="park" items="${parkList}">
			<c:if test="${not empty park.p_lat and not empty park.p_lon}">
			// 위도와 경도 값 가져오기
			var lat = "${park.p_lat}"; // 위도
			var lon = "${park.p_lon}"; // 경도
			var name = "${park.p_na}"; // 공원명

			// 위도와 경도 값이 유효한지 확인
			if (!isNaN(lat) && !isNaN(lon)) {
				var position = new kakao.maps.LatLng(lat, lon); // 마커 위치 설정

				// 마커 생성
				var marker = new kakao.maps.Marker({
					position : position
				});

				// 마커를 지도에 추가
				marker.setMap(map);

				// 마커의 위치를 bounds 객체에 포함시켜 지도 범위 자동 조정
				bounds.extend(position);

				// 마커에 클릭 이벤트 추가 (정보 창 표시)
				var infowindow = new kakao.maps.InfoWindow({
					content : '<div style="padding:5px;">' + name + '</div>'
				});

				kakao.maps.event.addListener(marker, 'click', function() {
					infowindow.open(map, marker);
				});
			} else {
				console.error("유효하지 않은 위도, 경도 값:", lat, lon);
			}
			</c:if>
			</c:forEach>

			// 모든 마커를 포함하는 영역으로 지도의 범위를 설정
			map.setBounds(bounds);
			</c:if>

			// 공원이 없을 경우 기본 위치로 지도 설정
			<c:if test="${empty parkList}">
			map.setCenter(new kakao.maps.LatLng(33.450701, 126.570667)); // 기본 위치
			</c:if>
		}
	</script>
</body>
</html>
