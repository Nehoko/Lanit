<#import "login.ftl" as l>
<#macro menu>
<div class="menu-container">

    <a href="/">Главная страница</a>
    |
    <a href="/adminPanel">Панель администрации</a>
    |
    <a href="/userPanel">Личный кабинет</a>
    |
    <a href="/sign-up">Регистрация</a>
    |
    <a href="/theater">Список Театров</a>
    <p>

    <div>
        Привет,
    <#if username??>
        ${username!}
    <#else>
    Аноним
    </#if>
        <@l.logout/>
    </div>


</div>
</#macro>