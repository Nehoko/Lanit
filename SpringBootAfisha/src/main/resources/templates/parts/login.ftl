<#import "token.ftl" as t>
<#macro login path isRegistration>
<form action="${path}" method="post">
    <div class="form-group row"><label class="col-sm-2 col-form-label"> Логин :</label>
        <div class="col-sm-3">
            <input type="text" name="username" placeholder="Логин"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Пароль: </label>
        <div class="col-sm-3">
            <input type="password" name="password" placeholder="Пароль"/>
        </div>
    </div>
    <@t.token/>
    <div><button class="btn btn-primary" type="submit">
        <#if isRegistration>
            Регистрация
            <#else>
            Вход
        </#if>
        </button></div>
</form>
</#macro>
<#macro logout>
<form action="logout" method="post">
    <@t.token/>
    <button class="btn btn-primary" type="submit" >Выход</button>
</form>
</#macro>