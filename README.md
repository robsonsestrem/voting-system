# Descrição da atividade:
Para o trabalho, deve-se criar um sistema web (usando o NetBeans) que vai consistir em um
formulário para entrada de dados em JSP e uma classe que será o servlet que tratará esse dado e
retornará em forma de página.
Implementar um sistema de votação. O programa deve gerar votos aleatórios entre 5
candidatos (1 a 5). Deve exibir quantos votos cada candidato teve e exibir, ao final, quem
foi o vencedor e com quantos votos.

## Interface com o usuário:
A interface deve conter 5 campos de texto, para receber do usuário os nomes de 5 candidatos em nossa
simulação de eleição, mais um campo onde receberá o número total de votos que haverá na eleição.
Um botão de envio deve ser colocado para enviar esses dados ao servidor.

## Servidor:
O servidor receberá os dados enviados, deixará os candidatos com o nome na ordem em que foram
digitados e gerará, aleatoriamente, a quantidade de votos que foi informada. Por exemplo, se o usuário
digitar “10000”, serão gerados 10 mil votos aleatórios entre 1 e 5 (ou 0 a 4 para aproveitar os índices do
array), que deverão ser salvos (somados).
Então, o servidor retornará a quantidade de votos que cada um teve e irá destacar o vencedor. A forma de
exibição você pode definir como achar melhor.

Imagens da aplicação:
<img src="/web/recursos/image/envio_dados.png">
<br>
<img src="/web/recursos/image/resultado.png">
<br>
