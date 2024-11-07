<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>가로수길 상세</title>
</head>
<body>
    <h1>${road.rNa} 상세 정보</h1>
    <table border="1">
        <tr>
            <th>가로수길명</th>
            <td>${road.r_na}</td>
        </tr>
        <tr>
            <th>가로수 종류</th>
            <td>${road.r_ty}</td>
        </tr>
        <tr>
            <th>도로명</th>
            <td>${road.r_rna}</td>
        </tr>
        <tr>
            <th>구간명</th>
            <td>${road.r_rsec}</td>
        </tr>
        <tr>
            <th>길이</th>
            <td>${road.r_len}</td>
        </tr>
        <tr>
            <th>식재연도</th>
            <td>${road.r_ye}</td>
        </tr>
        <tr>
            <th>가로수 수량</th>
            <td>${road.r_vol}</td>
        </tr>
        <tr>
            <th>관리기관명</th>
            <td>${road.r_cena}</td>
        </tr>
        <tr>
            <th>전화번호</th>
            <td>${road.r_pho}</td>
        </tr>
        <tr>
            <th>가로수길 소개</th>
            <td>${road.r_sto}</td>
        </tr>
    </table>
</body>
</html>