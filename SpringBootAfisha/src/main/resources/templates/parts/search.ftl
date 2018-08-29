<#macro search path filter>
    <form action="${path}" method="get">
        <input type="text" name="search" value="${filter!}" placeholder="Введите название" size="30"/>
        <input type="submit" value="Найти"/>
    </form>
</#macro>