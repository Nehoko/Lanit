<#import "parts/common.ftl" as c>
<#import "parts/token.ftl" as t>
<@c.page>
User Editor

<form action="/user" method="post">
    <input type="text" name="username" value="${user.username}">
    <#list roles as role>
        <div>
            <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
        </div>
    </#list>
    <input type="hidden" value="${user.id}" name="userId">
    <@t.token/>
    <button type="submit">Save</button>
</form>
</@c.page>