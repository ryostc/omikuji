<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>おみくじの結果</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${errors != null}">
                <h1>入力内容にエラーがあります</h1>
                <ul>
                    <c:forEach var="error" items="${errors}">
                        <li><c:out value="${error}" /></li>
                    </c:forEach>
                </ul>
            </c:when>
            <c:otherwise>
                <h1>おみくじの結果</h1>
                <p><c:out value="${username}" />さんの今日の運勢は<c:out value="${result}" />です．</p>
            </c:otherwise>
        </c:choose>
    </body>
</html>