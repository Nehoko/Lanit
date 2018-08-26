<header>
    {{>_header}}
</header>
<body>
    <table border="1">
        <caption>Пользователи афиши</caption>
        <tr>
            <th>id</th>
            <th>username</th>
            <th>role</th>
        </tr>
        {{#users}}
            <tr>
                <td>{{id}}</td>
                <td>{{username}}</td>
                <td>{{roles}}</td>
                <td><a href="/edit">edit</a></td>
            </tr>
        {{/users}}
    </table>
</body>
<footer>
    {{>_footer}}
</footer>