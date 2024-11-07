<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
     <meta charset="UTF-8">
    <title>가로수길 목록</title>
</head>
<body>

    <h1>가로수길 검색 결과</h1>
    <table border="1">
        <thead>
            <tr>
                <th>가로수길명</th>
                <th>구간명</th>
                <th>주소</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="road" items="${roadList}">
                <tr>
                    <td>${tree.t_sta_info}</td>        <!-- 분류 -->
                    <td>${tree.t_sta_spec}</td>       <!-- 보호수종류 -->
                    <td>${tree.t_sta_ad}</td>     <!-- 주소 -->
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>