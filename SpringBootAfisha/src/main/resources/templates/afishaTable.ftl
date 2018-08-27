<div class = "afishaClassic">
    <table border="1">
        <caption>Афиша в нашем театре</caption>
        <tr>
            <th>№</th>
            <th>Название</th>
            <th>Количество мест</th>
        </tr>
        {{#afisha}}
            <tr>
                <td>{{id}}</td>
                <td>{{name}}</td>
                <td>{{seats}}</td>
            </tr>
        {{/afisha}}
    </table>
</div>

<div class="afishaAdmin">
    <table border="1">
        <caption>Афиша в нашем театре</caption>
        <tr>
            <th>№</th>
            <th>Название</th>
            <th>Количество мест</th>
        </tr>
        {{#afisha}}
            <tr>
                <td>{{id}}</td>
                <td>{{name}}</td>
                <td>{{seats}}</td>
            </tr>
        {{/afisha}}
    </table>
</div>