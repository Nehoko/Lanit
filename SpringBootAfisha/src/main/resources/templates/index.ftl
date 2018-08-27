<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
<p>
    <div>
        <form action="/" method="get">
            <input type="text" name="search" value="${filter!}" placeholder="Введите название спектакля" size="30"/>
            <input type="submit" value="Найти"/>
        </form>
    </div>

        <table border="1">
            <caption>Афиша в нашем театре</caption>
            <tr>
                <th>№</th>
                <th>Название</th>
                <th>Количество мест</th>
            </tr>
    <#list afisha as performance>
            <tr>
                <td>${performance.id}</td>
                <td>${performance.name}</td>
                <td>${performance.seats}</td>
            </tr>
    <#else>
    <tr>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    </#list>
        </table>

<p>
</@c.page>