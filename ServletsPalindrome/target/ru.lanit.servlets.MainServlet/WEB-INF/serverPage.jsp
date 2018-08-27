<%--
  Created by IntelliJ IDEA.
  User: fun4l
  Date: 16.08.2018
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
</head>
<body>
<<<<<<< HEAD
    <form action="${pageContext.request.contextPath}/" method="post" accept-charset="UTF-8" >
        <p><h3>${message}</h3></p>
        <p><input type="text" name="text" size="40" pattern="[A-Za-zА-Яа-яЁё0-9\\s\\.\\,\\:\\;\\!\\?]{2,500}[^+\-=%/`~^]"></p>
        <p><input type="submit" name="check" value="Check"></p>
    </form>
    <p>Слова-палиндромы:</p>
    <c:forEach var="word" items="${words}">
        ${word}<br>
    </c:forEach>
    <p>Предложения-палиндромы:</p>
    <c:forEach var="sentence" items="${sentences}">
        ${sentence}<br>
    </c:forEach>
=======
<form action="${pageContext.request.contextPath}/" method="post" accept-charset="UTF-8">
    <p>
    <h3>${message}</h3></p>
    <p><input type="text" name="text" size="40" pattern="^[^+\-=%/`~^]{2,500}$"></p>
    <p><input type="submit" name="check" value="Check"></p>
</form>
<p>Слова-палиндромы:</p>
<c:forEach var="word" items="${words}">
    ${word}<br>
</c:forEach>
<p>Предложения-палиндромы:</p>
<c:forEach var="sentence" items="${sentences}">
    ${sentence}<br>
</c:forEach>
>>>>>>> 70875e8efba4314b18afd68f04b3703dcd4c1e1c
</body>
</html>