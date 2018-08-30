<#import "../parts/common.ftl" as c>
<#import "../parts/crudAfisha.ftl" as crud>
<@c.page>
Редактирование спектакля

    <@crud.crudAfisha "/afisha/${performance.id}/edit" performance/>
</@c.page>