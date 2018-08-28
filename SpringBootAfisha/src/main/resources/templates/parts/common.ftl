<#import "header.ftl" as h>
<#import "footer.ftl" as f>
<#macro page>
<html>
<head>
    <meta charset="UTF-8">
    <title>Afisha</title>
    <link rel="stylesheet" href="/static/style.css"
    <@h.header/>
</head>
<body>
<#nested>
</body>
<footer>
    <@f.footer/>
</footer>
</html>
</#macro>