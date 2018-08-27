<#macro afisha role>
    <table border="1">
        <caption>Афиша в нашем театре</caption>
        <#if role="ADMIN">
            <thead>
                <tr>
                    <th>№</th>
                    <th>Название</th>
                    <th>Количество мест</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <#list afisha! as performance>
                    <tr>
                        <td>${performance.id}</td>
                        <td>${performance.name}</td>
                        <td>${performance.seats}</td>
                        <td><a href="/afishaEdit">Edit</a>
                    </tr>
                </#list>
            </tbody>
        <#else>
            <thead>
                <tr>
                    <th>№</th>
                    <th>Название</th>
                    <th>Количество мест</th>
                </tr>
            </thead>
            <tbody>
                <#list afisha! as performance>
                    <tr>
                        <td>${performance.id}</td>
                        <td>${performance.name}</td>
                        <td>${performance.seats}}</td>
                    </tr>
                </#list>
            </tbody>
        </#if>
    </table>
</#macro>