<#import "../parts/common.ftl" as c>
<#import "../parts/token.ftl" as t>
<#import "../parts/crudTheater.ftl" as crud>
<@c.page>
Редактирование театра

    <@crud.crudTheater "/theater/${theater.id}/edit" theater />
<p>
    <a href="/theater/${theater.id}/afisha/edit">Редактирование афиши</a>
</@c.page>