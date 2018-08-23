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
    <title>Регистрация</title>
    <jsp:include page="_header.jsp"/>
    <jsp:include page="_menu.jsp"/>
</head>
<body>


<form action="${pageContext.request.contextPath}/save" method="post" accept-charset="UTF-8">
    <p>
    <p>Логин: <input type="text" name="login" size="40" pattern="[a-zA-Z]{6,500}$"></p>
    <p>Пароль: <input type="text" name="password" size="40" pattern="[a-zA-Z0-9]{6,500}$"></p>
    <p><input type="submit" name="sign-up" value="Зарегистрироваться"></p>
    <p>
        <div>Логин должен быть длинной не менее 6 символов и содержать в себе англоязычные буквы.</div>
        <div>Пароль должен состоять из англоязычных букв и цифр и длинной не менее 6 символов</div>
    </p>
</form>
</body>
<footer>
    <jsp:include page="_footer.jsp"/>
</footer>
</html>