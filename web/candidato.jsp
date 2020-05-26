<%@page import="java.util.List"%>
<%@page import="unicesumar.Candidato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Votação</title>
        <link rel="stylesheet" href="recursos/css/StyleSheet.css">
    </head>
    <body>
        <form method="post" action="candidato">
            <header><h1>Sistema de Votação</h1></header>

            <div id="wrapper">
                <div id="inputs">

                    Candidato 1: <input type="text" name="candidato1" placeholder="Informe nome" required/> <br/><br/>
                    Candidato 2: <input type="text" name="candidato2" placeholder="Informe nome" required/> <br/><br/>
                    Candidato 3: <input type="text" name="candidato3" placeholder="Informe nome" required/> <br/><br/>
                    Candidato 4: <input type="text" name="candidato4" placeholder="Informe nome" required/> <br/><br/>
                    Candidato 5: <input type="text" name="candidato5" placeholder="Informe nome" required/> <br/><br/>
                    Quantidade de Votos: <input type="number" name="votos" placeholder="Informe total de votos" required/> <br/> <br/>
                </div>

                <div id="btn">

                    <button type="submit">Enviar</button>

                </div>
            </div>
        </form>
    </body>
</html>
