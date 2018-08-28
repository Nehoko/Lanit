<#import "../parts/common.ftl" as c>
<#import "../parts/token.ftl" as t>
<@c.page>
${performance.name}
<p>
    ${performance.description!}
<p>
<form action="/buy/${performance.id}" method="get">
    <button type="submit">Купить билет</button>
</form>
</@c.page>