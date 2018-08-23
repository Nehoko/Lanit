<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.08.2018
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false"
%>
<%--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
--%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
    <title>Вход</title>
    <jsp:include page="_header.jsp"/>
    <jsp:include page="_menu.jsp"/>
</head>
<body>

<form action="${pageContext.request.contextPath}/" method="post" accept-charset="UTF-8">
    <p>
    <p>Логин: <label>
        <input type="text" name="login" size="40" pattern="[a-zA-Z]{6,500}$">
    </label></p>
    <p>Пароль: <label>
        <input type="text" name="password" size="40" pattern="[a-zA-Z0-9]{6,500}$">
    </label></p>
    <p><input type="submit" name="sign-in" value="Войти"></p>
    <p>
</form>
</body>
<footer>
    <jsp:include page="_footer.jsp"/>
</footer>
</html>