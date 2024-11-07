<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도로구간 검색</title>
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

    .search-form {
        margin-bottom: 20px;
    }

    .search-box {
        width: 300px;
        padding: 8px;
        font-size: 14px;
    }

    .btn {
        padding: 8px 16px;
        font-size: 14px;
        cursor: pointer;
        background-color: #4CAF50;
        color: white;
        border: none;
    }
</style>
</head>
<body>
    <h1>주소 검색</h1>
    
    <!-- 검색 폼 -->
    <form action="/searchRoads" method="get">
        <input type="text" name="searchKeyword" class="search-box" placeholder="주소로 검색..." value="${searchKeyword}">
        <button type="submit" class="btn">검색</button>
    </form>

    <!-- 검색 결과 테이블 -->
    <c:if test="${not empty roadList}">
        <table border="1">
            <thead>
                <tr>
                    <th>가로수길명</th>
                    <th>가로수길 설명</th>
                    <th>주소</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="road" items="${roadList}">
                    <tr>
                        <td>${road.r_na}</td>        <!-- 가로수길명 -->
                        <td>${road.r_sto}</td>       <!-- 가로수길 설명 -->
                        <td>${road.r_ce_ad}</td>     <!-- 주소 -->
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <!-- 검색 결과가 없을 경우 메시지 -->
    <c:if test="${empty roadList}">
        <p>검색 결과가 없습니다.</p>
    </c:if>

</body>
</html>