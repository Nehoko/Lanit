<#import "../parts/common.ftl" as c>

<@c.page>

    ${theater.name}
<p>
    ${theater.description!}
<p>

    <a href="/theater/${theater.id}/afisha">Перейти к афише театра ${theater.name}</a>

</@c.page>