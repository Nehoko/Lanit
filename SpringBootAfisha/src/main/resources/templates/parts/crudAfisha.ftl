<#import "token.ftl" as t>

<#macro crudAfisha path performance>
<div>
    <form method="post" action="${path}">
        <p><input type="text" name="name" value="${performance.name!}" placeholder="Название спектакля"/></p>

        <p><input type="number" name="seats" value="${performance.seats!}" placeholder="Количество мест"/></p>

        <p><label><input type="number" name="seats_on_parter" value="${performance.seats_on_parter!}">Места в партере</label></p>
        <p><label><input type="number" name="price_parter" value="${performance.price_parter!}">Цена за партер</label></p>

        <p><label><input type="number" name="seats_on_balcony" value="${performance.seats_on_balcony!}">Места на балконе</label></p>
        <p><label><input type="number" name="price_balcony" value="${performance.price_balcony!}">Цена за балкон</label></p>

        <p><label><input type="number" name="seats_on_dress_circle" value="${performance.seats_on_dress_circle!}">Места на бельэтаже</label></p>
        <p><label><input type="number" name="price_dress_circle" value="${performance.price_dress_circle!}">Цена за бельэтаж</label></p>

        <p><textarea name="description" value="${performance.description!}" placeholder="Описание спектакля"></textarea></p>
        <@t.token/>
        <button type="submit">Добавить</button>
    </form>
</div>
</#macro>