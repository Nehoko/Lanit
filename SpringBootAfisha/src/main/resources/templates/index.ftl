<#import "parts/common.ftl" as c>
<#import "parts/search.ftl" as s>
<#import "parts/afishaPanel.ftl" as ap>

<@c.page>
<p>
    <div>
        <@s.search "/" "${filter!}"/>
    </div>
<p>
    <div>
        <@ap.ap afisha/>
    </div>
</@c.page>