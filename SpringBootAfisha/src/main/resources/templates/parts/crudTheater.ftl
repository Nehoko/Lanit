<#import "token.ftl" as t>

<#macro crudTheater path theater>
<div>
    <form method="post" action="${path}">
        <p><input type="text" name="name" value="${theater.name!}" placeholder="Название Театра"/></p>

        <p><input type="text" name="address" value="${theater.address!}" placeholder="Адрес"/></p>

        <p><label><input type="number" name="mailbox" value="${theater.inbox!}">Почтовый индекс</label></p>

        <p><textarea name="description" value="${theater.description!}" placeholder="Описание театра"></textarea></p>
        <@t.token/>
        <button type="submit">Добавить</button>
    </form>
</div>
</#macro>