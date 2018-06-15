<%-- 
    Document   : consultarVenda
    Created on : 05/06/2018, 12:53:28
    Author     : vitor
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>HeadShot</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
        <link rel="stylesheet" type="text/css" href="css/navBlack.css">
        <link rel="stylesheet" type="text/css" href="css/endereco.css">
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">

    </head>
    <body>
        <div class="container-fluid"> <!-- INICIO CONTAINER HEADER -->
            <div class="row">
                <header class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                    <nav class="navbar navbar-expand-lg navbar-dark">
                        <a class="navbar-brand" href="homeBack.jsp">HeadShot<img id="logo" src="img/headshot.jpg" alt="imagem logo do site">com</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText"
                                aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarText">
                            <ul class="navbar-nav">
                                <li class="nav-item">
                                    <a href="cadastro.jsp" class="nav-link" >Cadastro Produto</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="consultarVenda.jsp">Consultar Venda</a>
                                </li>
                                 <li class="nav-item">
                                    <a class="nav-link" href="consultar-perguntas-back">Consultar Mensagens</a>
                                </li>
                            </ul>

                            <div class="registro">
                                <span class="navbar-text">
                                    <p> Vitor </p>
                                </span>
                                <span class="navbar-text">
                                    <a class="btn btn-sm btn-outline-secondary" href="logout-back">Sair</a>
                                </span>
                            </div>

                        </div>                    
                    </nav>
                </header>

            </div>
        </div> <!-- FIM CONTAINER HEADER -->

        <div class="container">
            <div class="row mt-2 mb-2">
                

            </div>
            <div class="row">
<c:forEach items="${listaRespostas}" var="mensagem">
        
    <div class="container mt-5 mb-5">
        <form action="responder-mensagem" method="post">
            <div class="card">
                <div class="card-header">
                    <div class="row">
                        <div class="col-6">Assunto: ${mensagem.assunto} </div><div class="col-6">Status:${mensagem.status}</div>
                    </div>
                </div>
                <div class="card-body">
                    <h3 class="text-muted">Pergunta:</h3>
                    <p>${mensagem.mensagem}</p>

                </div>
                <div class="card-body" id="resposta">
                    <h3 class="text-muted">Resposta:</h3>
                    <textarea name="resposta" type="text" maxlength="255" max="255" class="form-control" id="ass" placeholder="Preencha a resposta."></textarea>
                    <button type="submit" class="btn but-compra mt-2 ml-3">Enviar</button>
                    <input type="text" name="idMensagem" value="${mensagem.idMensagem}" style="margin-left: -9999px;"/>
                </div>
            </div>
        </form>
        </div>
   
</c:forEach>
            </div>
        </div>

    </body>
</html>