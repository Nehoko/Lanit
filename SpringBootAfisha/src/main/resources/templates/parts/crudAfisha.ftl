<#import "token.ftl" as t>

<#macro crudAfisha>
<div>
    <form method="post" action="/">
        <input type="text" name="name" placeholder="Название спектакля"/>
        <input type="number" name="seats" placeholder="Количество мест"/>
        <@t.token/>
        <button type="submit">Добавить</button>
    </form>
</div>
</#macro>