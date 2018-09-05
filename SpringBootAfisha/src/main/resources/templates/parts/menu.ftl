<#include "security.ftl">
<#import "login.ftl" as l>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Afisha</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Главная</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/theater">Список театров</a>
            </li>
            <#if isUser>
                <li class="nav-item">
                    <a class="nav-link" href="/userPanel">Личный кабинет</a>
                </li>
            <#else>
                <li class="nav-item">
                    <a class="nav-link" href="/login">Вход</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/sign-up">Регистрация</a>
                </li>
            </#if>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/adminPanel">Панель администрации</a>
                </li>

            </#if>
        </ul>
        <div>
            <#if isUser>
            <@l.logout/>
            </#if>
        </div>
        <div class="navbar-text ml-3">${name}</div>
    </div>
</nav>