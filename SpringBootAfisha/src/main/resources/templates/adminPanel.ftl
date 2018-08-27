<#import "parts/common.ftl" as c>
<#import "parts/crudAfisha.ftl" as crud>
<#import "afishaList.ftl" as al>
<@c.page>
<p>
    <@crud.crudAfisha/>
    <@al.afisha "ADMIN"/>
<p>
<a href="/user">Список пользователей</a>
</@c.page>