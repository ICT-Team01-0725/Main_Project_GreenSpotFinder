<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>보호수 목록</title>
</head>

<body>

    <h1>보호수 검색 결과</h1>

    <!-- 검색 결과가 없을 때 메시지 출력 -->
    <c:choose>
        <c:when test="${not empty treeList}">
            <table border="1">
                <thead>
                    <tr>
                        <th>보호수명</th>
                        <th>수령</th>
                        <th>보호수주소</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="tree_area" items="${treeList}">
                        <tr>
                            <td>${tree_area.t_tty}</td> <!-- 보호수 이름 -->
                            <td>수령 : ${tree_area.t_age}년</td> <!-- 보호수 나이 -->
                            <td>
                                <!-- 보호수 주소 출력: t_ad가 없으면 t_rad 출력 -->
                                <c:choose>
                                    <c:when test="${empty tree_area.t_ad}">
                                        ${tree_area.t_rad}
                                    </c:when>
                                    <c:otherwise>
                                        ${tree_area.t_ad}
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p>검색 결과가 없습니다.</p>
        </c:otherwise>
    </c:choose>

</body>
</html>
