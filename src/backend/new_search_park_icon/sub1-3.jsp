<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>다양한 공원 찾기</title>
<!-- css 초기화 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css">
<!-- CSS 파일 링크 -->
<link rel="stylesheet" href="resources/css/common.css" />
<link rel="stylesheet" href="resources/css/sub1-3.css" />
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
<!-- parkpark.js -->
<script src="resources/js/parkpark.js"></script>








</head>

<body>
	<div class="sub1-3">
		<div class="header"></div>
		<div id="sub_container">
			<ul class="contents_box">
				<li class="textcenter">
					<h2 class="great_title">다양한 공원 찾기</h2>
					<p class="subheading_title">특별한 공원, 특별한 경험</p>


					<div class="categories">
						<ul>
							<li>
								<figure class="category_icon">
									<img src="resources/images/category_icon01.png" alt="어린이공원">
								</figure> <span class="category"> <a href="/parks?category=어린이공원">어린이공원</a>
							</span>
							</li>
							<li>
								<figure class="category_icon">
									<img src="resources/images/category_icon02.png" alt="수변공원">
								</figure> <span class="category"> <a href="/parks?category=수변공원">수변공원</a>
							</span>
							</li>
							<li>
								<figure class="category_icon">
									<img src="resources/images/category_icon03.png" alt="근린공원">
								</figure> <span class="category"> <a href="/parks?category=근린공원">근린공원</a>
							</span>
							</li>
							<li>
								<figure class="category_icon">
									<img src="resources/images/category_icon04.png" alt="체육공원">
								</figure> <span class="category"> <a href="/parks?category=체육공원">체육공원</a>
							</span>
							</li>
							<li>
								<figure class="category_icon">
									<img src="resources/images/category_icon05.png" alt="문화공원">
								</figure> <span class="category"> <a href="/parks?category=문화공원">문화공원</a>
							</span>
							</li>
						</ul>
					</div>


					<section class="contents2">
						<ul class="region_scroll_ul total_search_mg">
							<li class="region_list">
								<ul class="scroll_list_ul">
									<!-- 카테고리 선택 전, 기본 공원 목록이 동적으로 출력됩니다 -->
									<c:if test="${not empty parks}">
										<c:forEach var="park" items="${parks}">
											<li>
												<ul class="scroll_list">
													<!-- 공원의 주소에서 앞 2글자만 출력 -->
													<li class="category"><span>${park.shortPAd}</span></li>
													<li class="content">
														<h4>${park.p_na}</h4> <!-- 공원 이름 -->
														<p class="text">${park.p_ty}</p> <!-- 공원 구분 -->
														<p class="address">${park.p_ad}</p> <!-- 공원 주소 -->
													</li>
												</ul>
											</li>
										</c:forEach>
									</c:if>
								</ul>
							</li>
							<li class="region_map">
								<div id="map" style="width: 100%; height: 723px;"></div>
							</li>
						</ul>
					</section>
				</li>
			</ul>
			<div>
				<ul class="paging_num_ul">
					<!-- << 버튼 (첫 페이지일 때 숨김) -->
					<li
						class="material-icons prev <c:if test="${pageGroupStart == 1}">hide</c:if>">
						<c:if test="${pageGroupStart > 1}">
							<a href="/parks?category=${category}&page=1">keyboard_double_arrow_left</a>
						</c:if>
					</li>

					<!-- < 버튼 (첫 페이지일 때 숨김) -->
					<li
						class="material-icons prev <c:if test="${!prevGroup}">hide</c:if>">
						<c:if test="${prevGroup}">
							<a href="/parks?category=${category}&page=${prevGroupStart}">chevron_left</a>
						</c:if>
					</li>

					<!-- 페이지 번호들 -->
					<c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}">
						<li class="<c:if test='${i == currentPage}'>active</c:if>"><c:if
								test="${i == currentPage}">
                ${i} <!-- 현재 페이지 -->
							</c:if> <c:if test="${i != currentPage}">
								<a href="/parks?category=${category}&page=${i}">${i}</a>
								<!-- 링크로 페이지 이동 -->
							</c:if></li>
					</c:forEach>

					<!-- > 버튼 (마지막 페이지일 때 숨김) -->
					<li
						class="material-icons next <c:if test="${pageGroupEnd == totalPages}">hide</c:if>">
						<c:if test="${pageGroupEnd < totalPages}">
							<a href="/parks?category=${category}&page=${pageGroupEnd + 1}">chevron_right</a>
						</c:if>
					</li>

					<!-- >> 버튼 (마지막 페이지일 때 숨김) -->
					<li
						class="material-icons next <c:if test="${pageGroupEnd == totalPages}">hide</c:if>">
						<c:if test="${pageGroupEnd < totalPages}">
							<a href="/parks?category=${category}&page=${totalPages}">keyboard_double_arrow_right</a>
						</c:if>
					</li>
				</ul>
			</div>
		</div>

		<script>
			// 카카오맵 API로 지도 표시하기
			var mapContainer = document.getElementById('map');
			var mapOptions = {
				center : new kakao.maps.LatLng(37.5665, 126.9780), // 서울 중심으로 설정
				level : 8
			};
			var map = new kakao.maps.Map(mapContainer, mapOptions);

			// JSP에서 전달한 JSON 형식의 공원 데이터
			var parks = JSON.parse('${parksJson}'); // 서버에서 전달받은 JSON 데이터를 JavaScript 객체로 변환

			// 마커를 표시할 공원의 위도, 경도 값으로 반복하여 마커를 찍는다
			var markers = [];
			parks.forEach(function(park) {
				if (park.p_lat && park.p_lon) {
					var markerPosition = new kakao.maps.LatLng(park.p_lat,
							park.p_lon); // 마커의 위치

					// 카테고리별 마커 이미지 설정
					var markerImageSrc = ''; // 기본 이미지 경로 설정

					switch (park.p_ty) {
					case '어린이공원':
						markerImageSrc = 'resources/images/map_icon1.png';
						break;
					case '수변공원':
						markerImageSrc = 'resources/images/map_icon2.png';
						break;
					case '근린공원':
						markerImageSrc = 'resources/images/map_icon3.png';
						break;
					case '체육공원':
						markerImageSrc = 'resources/images/map_icon4.png';
						break;
					case '문화공원':
						markerImageSrc = 'resources/images/map_icon5.png';
						break;
					default:
						markerImageSrc = 'resources/images/map_icon1.png'; // 기본 아이콘 설정
					}

					// 마커 이미지 옵션 설정
					var markerImage = new kakao.maps.MarkerImage(
							markerImageSrc, // 아이콘 이미지 경로
							new kakao.maps.Size(40, 40) // 아이콘 크기 (이미지 크기에 맞게 조정)
					);

					// 마커 객체 생성
					var marker = new kakao.maps.Marker({
						position : markerPosition,
						title : park.p_na, // 마커의 제목
						image : markerImage
					// 마커 이미지 설정
					});

					marker.setMap(map); // 마커를 지도에 표시
					markers.push(marker); // 마커 배열에 추가
				}
			});

			// 모든 마커가 보이도록 지도 경계를 설정
			var bounds = new kakao.maps.LatLngBounds();
			markers.forEach(function(marker) {
				bounds.extend(marker.getPosition());
			});
			map.setBounds(bounds);
		</script>

		<footer>
			<h1>common-footer</h1>
		</footer>
	</div>
</body>
</html>
