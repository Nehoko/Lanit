<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<#import "parts/search.ftl" as s>
<@c.page>
<p>
    <div>
        <@s.search "/" "${filter!}"/>
    </div>

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
                <td>${performance.name}</td>
                <td>${performance.seats}</td>
            </tr>
            </#list>
            </tbody>
        </table>

<p>
</@c.page>