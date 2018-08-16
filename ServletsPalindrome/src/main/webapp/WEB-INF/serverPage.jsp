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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
</head>
<body>
    <form action="${pageContext.request.contextPath}/" method="post" accept-charset="UTF-8" >
        <p><h3>${message}</h3></p>
        <p><input type="text" name="text" size ="40"></p>
        <p><input type="submit" name="check" value="Check"></p>
    </form>
    <p>Слова-палиндромы:</p>
    ${words}
    <p>Предложения-палиндромы:</p>
    ${sentences}
</body>
</html>