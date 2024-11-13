<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>지역별 보호수 찾기</title>

<!-- css 초기화 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css">

<!-- 수정된 CSS 파일 경로 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/sub2-2.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/common.css" />

<!-- 외부 라이브러리 CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" href="https://unpkg.com/leaflet@1.9.3/dist/leaflet.css" />

<!-- 외부 라이브러리 JS -->
<script src="https://unpkg.com/leaflet@1.9.3/dist/leaflet.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>

<!-- 수정된 JS 파일 경로 -->
<script src="${pageContext.request.contextPath}/static/js/swiper_controller2.js"></script>
<script src="${pageContext.request.contextPath}/static/road_visual_D3_leaflet.html"></script>

</head>
<body>
	<div id="sub_main_container">
		<div class="wrap"></div>

		<!-- nav-left -->
		<main>
			<div id="sub_container">
				<ul class="contents_box">
					<li class="textcenter">
						<h2 class="great_title">지역별 가로수길 찾기</h2>
						<p class="subheading_title">우리 생활 속 가로수길의 위치를 찾아보세요</p> <!-- 검색 폼 -->
						<ul class="sub_search_container">
							<li class="sub_search">
								<div class="sub_search_div">
									<form action="/finalroadsearch/searchRoadByAddress" method="get">
										<input type="text" name="address" placeholder="상세주소로 검색하기">
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
									<div class="swiper-slide cur_submenu"
										onclick="location.href='/finalroadsearch/findRoadByRegion?region=서울'">
										<span>서울</span>
									</div>
									<div class="swiper-slide"
										onclick="location.href='/finalroadsearch/findRoadByRegion?region=경기'">
										<span>경기</span>
									</div>
									<div class="swiper-slide"
										onclick="location.href='/finalroadsearch/findRoadByRegion?region=인천'">
										<span>인천</span>
									</div>
									<div class="swiper-slide"
										onclick="location.href='/finalroadsearch/findRoadByRegion?region=강원'">
										<span>강원</span>
									</div>
									<div class="swiper-slide"
										onclick="location.href='/finalroadsearch/findRoadByRegion?region=충청'">
										<span>충청</span>
									</div>
									<div class="swiper-slide"
										onclick="location.href='/finalroadsearch/findRoadByRegion?region=경상'">
										<span>경상</span>
									</div>
									<div class="swiper-slide"
										onclick="location.href='/finalroadsearch/findRoadByRegion?region=전라'">
										<span>전라</span>
									</div>
									<div class="swiper-slide"
										onclick="location.href='/finalroadsearch/findRoadByRegion?region=제주'">
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
							<li class="region_map">
								<!-- iframe으로 지도 포함 -->
								<div class="region_map">
									<iframe src="/static/road_visual_D3_leaflet.html"
										style="width: 100%; height: 780px; border: none;"></iframe>
								</div>
							<li class="region_list">

								<ul class="paging_list_ul">
									<c:choose>
										<c:when test="${not empty roadList}">
											<c:forEach items="${roadList}" var="road">
												<li>
													<ul class="paging_list">
														<li class="category"><span>지역</span></li>
														<li class="content">
															<h4>${road.r_na}</h4> <!-- 가로수길 이름 -->
															<p class="text">${road.r_ce_na}</p> <!-- 관리기관명 -->
															<p class="address">${road.r_ce_ad}</p> <!-- 가로수길 주소 -->
														</li>
													</ul>
												</li>
											</c:forEach>
										</c:when>
									</c:choose>

									<!-- 검색된 결과가 없을 경우 -->
									<c:if test="${empty roadList}">
										<p style="margin-top: 30px;">검색된 공원이 존재하지 않습니다.</p>
									</c:if>

								</ul> <!-- 페이지 네비게이션 추가 -->
								<ul class="paging_num_ul">
									<li class="material-icons prev">
										keyboard_double_arrow_left</li>
									<li class="material-icons prev">chevron_left</li>
									<li class="active">1</li>
									<li>2</li>
									<li>3</li>
									<li>4</li>
									<li>5</li>
									<li class="material-icons next">chevron_right</li>
									<li class="material-icons next">
										keyboard_double_arrow_right</li>
								</ul>
							</li>
						</ul>
				</ul>
			</div>

			<footer> </footer>
		</main>
	</div>
</body>
</html>