<#import "../parts/common.ftl" as c>
<#import "../parts/crudAfisha.ftl" as crud>
<#import "../parts/search.ftl" as s>
<@c.page>
<p>
    <div>
        <@s.search "/afisha" "${filter!}"/>
    </div>
<p>
    <@crud.crudAfisha/>
<p>
    <table border="1">
        <caption>Афиша в нашем театре</caption>
        <thead>
            <tr>
                <th>№</th>
                <th>Название</th>
                <th>Количество мест</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        <#list afisha as performance>
            <tr>
                <td>${performance.id}</td>
                <td>${performance.name}</td>
                <td>${performance.seats}</td>
                <td><a href="/afisha/${performance.id}">edit</a></td>
                <td><a href="/afisha/delete/${performance.id}">delete</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>