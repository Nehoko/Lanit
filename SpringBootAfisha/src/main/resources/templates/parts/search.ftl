<#macro search path filter>
    <form action="${path}" method="get">
        <input type="text" name="search" value="${filter!}" placeholder="Введите название" size="30"/>
        <button class="btn btn-primary" type="submit">Найти</button>
    </form>
</#macro>