<#import "parts/common.ftl" as c>
<#import "parts/token.ftl" as t>
<@c.page>
<p>
<div>
    <form method="post" action="/">
        <input type="text" name="name" placeholder="Название спектакля"/>
        <input type="number" name="seats" placeholder="Количество мест"/>
        <@t.token/>
        <button type="submit">Добавить</button>
    </form>
</div>
<div>
</div>
</@c.page>