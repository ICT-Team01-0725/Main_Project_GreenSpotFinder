<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css" rel="stylesheet">
    <title>지역별 보호수 찾기</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/sub3-3.css">
</head>
<body>
    <div id="sub_main_container">
        <div class="wrap"></div>

        <!-- nav-left -->
        <main>
            <div id="sub_container">
                <ul class="contents_box">
                    <li class="textcenter">
                        <h2 class="great_title">지역별 보호수 찾기</h2>
                        <p class="subheading_title">우리 생활 속 보호수의 위치를 찾아보세요</p>
                        <ul class="sub_search_container">
                            <li class="sub_search">
                                <div class="sub_search_div">
                                    <form action="/park/searchTree" method="get">
                                        <input type="text" name="t_ad" placeholder="상세주소로 검색하기">
                                        <button type="submit">
                                            <span class="material-icons">search</span>
                                        </button>
                                    </form>
                                </div>
                            </li>
                        </ul>

                        <!-- 지역별 보호수 목록 -->
                        <ul class="region_paging_ul total_search_mg">
                            <li class="region_list">
                                <ul class="paging_list_ul">
                                    <c:if test="${not empty treeList}">
                                        <c:forEach items="${treeList}" var="tree_area">
                                            <li>
                                                <ul class="paging_list">
                                                    <li class="category"><span>지역</span></li>
                                                    <li class="content">
                                                        <h4>${tree_area.t_tty}</h4>  						<!-- 보호수명 -->
                                                        <p class="text">수령 : ${tree_area.t_age}</p>       <!-- 보호수명 설명 -->
                                                        <p class="address">
                                                            <c:choose>
                                                                <c:when test="${not empty tree_area.t_ad}">
                                                                    ${tree_area.t_ad}      <!-- t_ad 값이 있으면 출력 -->
                                                                </c:when>
                                                                <c:otherwise>
                                                                    ${tree_area.t_rad}     <!-- t_ad 값이 없으면 t_rad 출력 -->
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </p> <!-- 주소 출력 -->
                                                    </li>
                                                </ul>
                                            </li>
                                        </c:forEach>
                                    </c:if>

                                    <!-- 검색값이 비어있을 경우 -->
                                    <c:if test="${empty treeList and not empty searchQuery}">
                                        <p style="margin-top: 30px;">검색된 보호수가 없습니다.</p>
                                    </c:if>

                                </ul>
                            </li>

                            <!-- 지도 표시 -->
                            <li class="region_map">
                                <div id="map" style="width: 100%; height: 723px;"></div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </main>
    </div>
</body>
</html>
