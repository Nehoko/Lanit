<#import "../parts/common.ftl" as c>
<#import "../parts/search.ftl" as s>
<@c.page>

<p>

<div>
    <@s.search "/theater" "${filter!}"/>
</div>

<div>
    <table border="1">
        <caption>Список театров</caption>
        <thead>
        <tr>
            <th>Название</th>
            <th>Афиша</th>
        </tr>
        </thead>
        <tbody>
        <#list theaters as theater>
            <tr>
                <td>${theater.name}</td>
                <td><a href="/theater/${theater.id}/afisha">Открыть</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>

</@c.page>