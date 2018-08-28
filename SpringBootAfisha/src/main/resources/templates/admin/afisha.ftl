<#import "../parts/common.ftl" as c>
<#import "../parts/crudAfisha.ftl" as crud>
<#import "../parts/search.ftl" as s>
<@c.page>
<p>
    <div>
        <@s.search "/afisha" "${filter!}"/>
    </div>
<p>
    <@crud.crudAfisha "/afisha" nullAfisha/>
<p>
    <table border="1">
        <caption>Афиша в нашем театре</caption>
        <thead>
            <tr>
                <th>№</th>
                <th>Название</th>
                <th>Количество мест</th>
                <th>Партер</th>
                <th>Цена</th>
                <th>Балкон</th>
                <th>Цена</th>
                <th>Бельэтаж</th>
                <th>Цена</th>
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
                <td>${performance.seats_on_parter}</td>
                <td>${performance.price_parter}</td>
                <td>${performance.seats_on_balcony}</td>
                <td>${performance.price_balcony}</td>
                <td>${performance.seats_on_dress_circle}</td>
                <td>${performance.price_dress_circle}</td>
                <td><a href="/afisha/${performance.id}">edit</a></td>
                <td><a href="/afisha/delete/${performance.id}">delete</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>