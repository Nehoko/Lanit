<#import "../parts/common.ftl" as c>
<#import "../parts/token.ftl" as t>
<#import "../parts/crudTheater.ftl" as crud>
<@c.page>
Редактирование театра

    <@crud.crudTheater "/theater/edit" theater />
    <a href="theater/${theater.id}/afisha">Редактирование афиши</a>
</@c.page>