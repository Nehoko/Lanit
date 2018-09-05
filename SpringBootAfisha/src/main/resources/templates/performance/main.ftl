<#import "../parts/common.ftl" as c>
<@c.page>
${performance.name}
<p>
    ${performance.description!}
<p>
<form action="/buy/${performance.id}" method="get">
    <button class="btn btn-primary" type="submit">Купить билет</button>
</form>
</@c.page>