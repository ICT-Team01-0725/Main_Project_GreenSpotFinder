<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>공원 상세</title>
</head>
<body>
    <h1>${park.p_na} 상세 정보</h1>
    <table border="1">
        <tr>
            <th>공원명</th>
            <td>${park.p_na}</td>
        </tr>
        <tr>
            <th>공원구분</th>
            <td>${park.p_ty}</td>
        </tr>
        <tr>
            <th>소재지 도로명 주소</th>
            <td>${park.p_rad}</td>
        </tr>
        <tr>
            <th>위도</th>
            <td>${park.p_lat}</td>
        </tr>
        <tr>
            <th>경도</th>
            <td>${park.p_lon}</td>
        </tr>
        <tr>
            <th>관리기관명</th>
            <td>${park.p_ce_na}</td>
        </tr>
        <tr>
            <th>전화번호</th>
            <td>${park.p_pho}</td>
        </tr>
        <tr>
            <th>제공기관명</th>
            <td>${park.p_ce_ad}</td>
        </tr>
    </table>
</body>
</html>