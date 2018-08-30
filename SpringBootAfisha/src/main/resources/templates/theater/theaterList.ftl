<#import "../parts/common.ftl" as c>
<#import "../parts/search.ftl" as s>
<#import "../parts/theaterPanel.ftl" as tp>

<@c.page>
<p>

<div>
    <@s.search "/theater" "${filter!}"/>
</div>

<div>
    <@tp.tp theaters/>
</div>

</@c.page>