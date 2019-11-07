<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cliente!</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/cliente.css'/>"/>
</head>
<body>
<div class="container">
    <h1>Clientes que compraram o produto ${nomeProduto}</h1>
    <#list clientes as cliente>
        Id: ${cliente.id}
        <br/>
        Nome: ${cliente.nome}
        <br/>
        Cpf: ${cliente.cpf}
        <br/>
        Telefone: ${cliente.telefone}
    </#list>
</div>
</body>
</html>