<#macro tp theaters>

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
            <td><a href="/theater/${theater.id}">${theater.name}</a></td>
            <td><a href="/theater/${theater.id}/afisha">Открыть</a></td>
        </tr>
        </#list>
    </tbody>
</table>

</#macro>