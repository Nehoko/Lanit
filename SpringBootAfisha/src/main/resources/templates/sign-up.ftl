<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
Регистрация
    ${message!}
<@l.login "/sign-up"/>
</@c.page>