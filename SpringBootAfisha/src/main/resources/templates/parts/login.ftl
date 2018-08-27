<#import "token.ftl" as t>
<#macro login path>
<form action="${path}" method="post">
    <div><label> Логин : <input type="text" name="username"/> </label></div>
    <div><label> Пароль: <input type="password" name="password"/> </label></div>
    <@t.token/>
    <div><input type="submit" value="Вход"/></div>
</form>
</#macro>
<#macro logout>
<form action="logout" method="post">
    <@t.token/>
    <input type="submit" value="Выход">
</form>
</#macro>