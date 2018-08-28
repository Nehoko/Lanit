<#import "../parts/common.ftl" as c>
<#import "../parts/token.ftl" as t>
<#import "../parts/crudAfisha.ftl" as crud>
<@c.page>
Редактирование спектакля

    <@crud.crudAfisha "/afisha/edit" performance/>
</@c.page>