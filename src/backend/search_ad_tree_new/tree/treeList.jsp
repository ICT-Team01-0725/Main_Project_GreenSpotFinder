<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>공원 목록</title>
</head>
<body>
    
    
    <h1>공원 검색 결과</h1>
    <table border="1">
        <thead>
            <tr>
                <th>공원명</th>
                <th>소재지지번주소</th>
                <th>관리기관명</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="park" items="${parkList}">
                <tr>
                    <td>${park.p_na}</td>
                    <td>${park.p_ad}</td>
                    <td>${park.p_ce_na}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>