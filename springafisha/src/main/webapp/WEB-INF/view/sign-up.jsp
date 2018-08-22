<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.08.2018
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
--%>
<html>
<head>
    <title>Вход</title>
    <jsp:include page="_header.jsp"/>
    <jsp:include page="_menu.jsp"/>
</head>
<body>


<form action="${pageContext.request.contextPath}/" method="post" accept-charset="UTF-8">
    <p>
    <h3>${message}</h3></p>
    <p>Введите логин, используя английскую раскладку</p>
    <p><input type="text" name="login" size="40" pattern="[a-zA-Z]{2,500}$"></p>
    <p>Введите пароль, используя цифры и буквы английского языка</p>
    <p><input type="text" name="password" size="40" pattern="[a-zA-Z0-9]{2,500}$"></p>
    <p><input type="submit" name="sign-up" value="Зарегистрироваться"></p>
</form>
</body>
<footer>
    <jsp:include page="_footer.jsp"/>
</footer>
</html>