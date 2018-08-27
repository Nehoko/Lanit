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

    <p>

    <div>
        Привет, username
        <@l.logout/>
    </div>


</div>
</#macro>