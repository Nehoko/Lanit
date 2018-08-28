<#import "../parts/common.ftl" as c>
<#import "../parts/token.ftl" as t>

<@c.page>
Редактирование спектакля

<form action="/afisha" method="post">
    <input type="text" name="name" value="${performance.name}">
    <input type="number" name="seats" value="${performance.seats}">
    <input type="hidden" value="${performance.id}" name="performanceId">
    <@t.token/>
    <button type="submit">Сохранить</button>
</form>
</@c.page>