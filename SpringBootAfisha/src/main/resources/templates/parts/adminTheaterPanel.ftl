<#macro atp theaters>

<div>
    <table border="1">
        <caption>Список театров</caption>
        <thead>
        <tr>
            <th>Название</th>
            <th>Афиша</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list theaters as theater>
        <tr>
            <td>${theater.name}</td>
            <td><a href="/theater/${theater.id}/afisha/edit">Открыть</a></td>
            <td><a href="/theater/${theater.id}/edit">edit</a> </td>
            <td><a href="/theater/${theater.id}/delete">delete</a> </td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>

</#macro>