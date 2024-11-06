<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h1 {
            color: #4CAF50;
        }

        table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        a {
            color: #0066cc;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>공원 목록</h1>
    
       <!-- 검색 폼 -->
    <form action="/searchParks" method="get">
        <input type="text" name="searchKeyword" class="search-box" placeholder="주소로 검색..." value="${searchKeyword}">
        <button type="submit" class="btn">검색</button>
    </form>

    <!-- 공원 목록을 테이블로 출력 -->
    <table border="1">
        <thead>
            <tr>
                <th>공원명</th>
                <th>공원 구분</th>
                <th>소재지 도로명 주소</th>
                <th>소재지 지번 주소</th>
                <th>관리 기관명</th>
                <th>상세 보기</th>
            </tr>
        </thead>
        <tbody>
            <!-- parkList에 있는 데이터를 출력 -->
            <c:forEach var="park" items="${parkList}">
                <tr>
                    <td>${park.p_na}</td>  <!-- 공원명 -->
                    <td>${park.p_ty}</td>  <!-- 공원 구분 -->
                    <td>${park.p_rad}</td> <!-- 소재지 도로명 주소 -->
                    <td>${park.p_ad}</td>  <!-- 소재지 지번 주소 -->
                    <td>${park.p_ce_na}</td> <!-- 관리기관명 -->
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>