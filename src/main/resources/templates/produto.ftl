<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Produtos!</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/produto.css'/>"/>
</head>
<body>
<div class="container">
    <h1>Produtos</h1>
    <table>
        <thead>
        <tr>
            <th>
                ID
            </th>
            <th>
                Descrição
            </th>
            <th>
                Valor Unitário
            </th>
        </tr>
        </thead>
        <tbody>
        <#list produtoList as produto>
            <tr>
                <td>
                    ${produto.id}
                </td>
                <td>
                    ${produto.descricao}
                </td>
                <td>
                    ${produto.valorUnitario}
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>