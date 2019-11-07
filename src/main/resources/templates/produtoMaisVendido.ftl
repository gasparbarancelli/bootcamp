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
    <h1>Produtos ${produto.concatenar}</h1>
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
        </tbody>
    </table>
</div>
</body>
</html>