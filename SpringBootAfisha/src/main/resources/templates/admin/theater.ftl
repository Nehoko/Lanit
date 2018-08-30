<#import "../parts/common.ftl" as c>
<#import "../parts/search.ftl" as s>
<#import "../parts/crudTheater.ftl" as crud>
<#import "../parts/adminTheaterPanel.ftl" as atp>

<@c.page>
<div>
    <@s.search "/theater/edit" "${filter!}"/>
</div>
<p>
<div>
    <@crud.crudTheater "/theater/edit" nullTheater/>
</div>
<p>
<div>
    <@atp.atp theaters/>
</div>

</@c.page>