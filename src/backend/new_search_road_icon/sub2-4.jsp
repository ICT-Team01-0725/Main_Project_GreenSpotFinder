<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>가로수길 수목조회</title>
<!-- css 초기화 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css">
<!-- CSS 파일 링크 -->
<link rel="stylesheet" href="/resources/css/menu.css" />
<link rel="stylesheet" href="resources/css/common.css" />
<link rel="stylesheet" href="resources/css/sub2-4.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
<!-- fontawesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" />
<!-- Material icon -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined" rel="stylesheet" />
<!-- Kakao Map API SDK -->
<script
	src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=ab07141ee929664c409a80cf396d1118&libraries=services"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
</head>

<!-- sub_header 불러오기 -->
        <jsp:include page="../common/sub_header.jsp"></jsp:include>


<body>

	<ul class="contents_box">
		<li class="textcenter">
			<h2 class="great_title">가로수길 수목조회</h2>
			<p class="subheading_title">원하는 수목이 있는 가로수길을 찾아보세요</p>

			<div class="categories">
				<ul>
					<li>
						<figure class="category_icon">
							<img src="resources/images/garosu_category_icon01.png" alt="벚나무">
						</figure> <span class="category"> <a href="/roads?type=벚"
							class="<c:if test='${type eq "벚나무"}'>active</c:if>">벚나무</a>
					</span>
					</li>
					<li>
						<figure class="category_icon">
							<img src="resources/images/garosu_category_icon02.png" alt="은행나무">
						</figure> <span class="category"> <a href="/roads?type=은행">은행나무</a>
					</span>
					</li>
					<li>
						<figure class="category_icon">
							<img src="resources/images/garosu_category_icon03.png" alt="단풍나무">
						</figure> <span class="category"> <a href="/roads?type=단풍">단풍나무</a>
					</span>
					</li>
					<li>
						<figure class="category_icon">
							<img src="resources/images/garosu_category_icon04.png" alt="자작나무">
						</figure> <span class="category"> <a href="/roads?type=자작">자작나무</a>
					</span>
					</li>
					<li>
						<figure class="category_icon">
							<img src="resources/images/garosu_category_icon05.png"
								alt="메타세콰이어">
						</figure> <span class="category"> <a href="/roads?type=메타">메타세콰이어</a>
					</span>
					</li>
				</ul>
			</div>

			<section class="contents2">
				<ul class="region_scroll_ul total_search_mg">
					<li class="region_list">
						<ul class="scroll_list_ul">
							<c:if test="${not empty roads}">
								<c:forEach var="road" items="${roads}">
									<li>
										<ul class="scroll_list">
											<li class="category"><span>${road.shortRCeAd}</span></li>
											<li class="content">
												<h4>${road.r_ce_ad}</h4>
												<p class="text">${road.r_sto}</p>
												<p class="address">${road.r_rsec}</p>
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
					<li class="material-icons prev <c:if test="${pageGroupStart == 1}">hide</c:if>">
						<c:if test="${pageGroupStart > 1}">
							<a href="/roads?type=${type}&page=1">keyboard_double_arrow_left</a>
						</c:if>
					</li>

					<li class="material-icons prev <c:if test="${!prevGroup}">hide</c:if>">
						<c:if test="${prevGroup}">
							<a href="/roads?type=${type}&page=${prevGroupStart}">chevron_left</a>
						</c:if>
					</li>

					<c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}">
						<li class="<c:if test='${i == currentPage}'>active</c:if>"><c:if
								test="${i == currentPage}">${i}</c:if> <c:if
								test="${i != currentPage}">
								<a href="/roads?type=${type}&page=${i}">${i}</a>
							</c:if></li>
					</c:forEach>

					<li class="material-icons next <c:if test="${pageGroupEnd == totalPages}">hide</c:if>">
						<c:if test="${pageGroupEnd < totalPages}">
							<a href="/roads?type=${type}&page=${pageGroupEnd + 1}">chevron_right</a>
						</c:if>
					</li>

					<li class="material-icons next <c:if test="${pageGroupEnd == totalPages}">hide</c:if>">
						<c:if test="${pageGroupEnd < totalPages}">
							<a href="/roads?type=${type}&page=${totalPages}">keyboard_double_arrow_right</a>
						</c:if>
					</li>
				</ul>
			</div>
			
			
			
	<script>
		// 카카오맵 API로 지도 표시하기
		var mapContainer = document.getElementById('map');
		var mapOptions = {
			center : new kakao.maps.LatLng(37.5665, 126.9780), // 서울 중심으로 설정
			level : 8
		};
		var map = new kakao.maps.Map(mapContainer, mapOptions);

		// JSP에서 전달한 JSON 형식의 공원 데이터  :  JSON 데이터를 JavaScript 객체로 변환
		var roads = JSON.parse('${roadsJson}');

		// 마커를 표시할 공원의 위도, 경도 값으로 반복하여 마커를 찍는다
		var markers = [];
		roads.forEach(function(road) {
			if (road.r_s_lat && road.r_s_lon) {
				var markerPosition = new kakao.maps.LatLng(road.r_s_lat,
						road.r_s_lon); // 마커의 위치

				// 카테고리별 마커 이미지 설정
				var markerImageSrc = ''; // 기본 이미지 경로 설정

				switch (road.r_ty) {
				case '벚나무':
					markerImageSrc = 'resources/images/map_grosu_icon1.png';
					break;
				case '은행나무':
					markerImageSrc = 'resources/images/map_grosu_icon2.png';
					break;
				case '단풍나무':
					markerImageSrc = 'resources/images/map_grosu_icon3.png';
					break;
				case '자작나무':
					markerImageSrc = 'resources/images/map_grosu_icon4.png';
					break;
				case '메타세콰이어':
					markerImageSrc = 'resources/images/map_grosu_icon5.png';
					break;
				default:
					markerImageSrc = 'resources/images/map_grosu_icon1.png'; // 기본 아이콘 설정
				}

				// 마커 이미지 옵션 설정
				var markerImage = new kakao.maps.MarkerImage(markerImageSrc, // 아이콘 이미지 경로
				new kakao.maps.Size(40, 40) // 아이콘 크기 (이미지 크기에 맞게 조정)
				);

				// 마커 객체 생성
				var marker = new kakao.maps.Marker({
					position : markerPosition,
					title : road.r_na, // 마커의 제목
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


		<!-- footer 불러오기 -->
        	<jsp:include page="../common/sub_footer.jsp"></jsp:include>

</body>
</html>
