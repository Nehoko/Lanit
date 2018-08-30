<#import "../parts/common.ftl" as c>
<#import "../parts/crudAfisha.ftl" as crud>
<#import "../parts/search.ftl" as s>
<#import "../parts/adminAfishaPanel.ftl" as aap>
<@c.page>
<p>
    <div>
        <@s.search "/theater/${theater.id}/afisha" "${filter!}"/>
    </div>
<p>
    <@crud.crudAfisha "/theater/${theater.id}/afisha/add" nullAfisha/>
<p>
    <@aap.aap afisha/>
</@c.page>