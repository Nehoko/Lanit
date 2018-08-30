<#macro ap afisha>

        <table border="1">
            <caption>Афиша в нашем театре</caption>
            <thead>
            <tr>
                <th>№</th>
                <th>Название</th>
                <th>Количество мест</th>
            </tr>
            </thead>
            <tbody>
            <#list afisha as performance>
            <tr>
                <td>${performance.id}</td>
                <td><a href="/performance/${performance.id}">${performance.name}</a></td>
                <td>${performance.seats}</td>
            </tr>
            </#list>
            </tbody>
        </table>

</#macro>