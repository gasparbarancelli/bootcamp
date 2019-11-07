<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cliente ${cliente.nome}!</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/cliente.css'/>"/>
</head>
<body>
<div class="container">
    <h1>Produtos</h1>
    Id: ${cliente.id}
    <br/>
    Nome: ${cliente.nome}
    <br/>
    Cpf: ${cliente.cpf}
    <br/>
    Telefone: ${cliente.telefone}
</div>
</body>
</html>