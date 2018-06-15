<%-- 
    Document   : homeBack.jsp
    Created on : 05/06/2018, 14:40:01
    Author     : vitor
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Headshot</title>
         <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="css/form-validation.css"/>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        <link rel="stylesheet" href="css/endereco.css"/>
        <link rel="stylesheet" href="css/navBlack.css"/>

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
                                    <a class="nav-link" href="consultar-mensagens-back">Consultar Mensagens</a>
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
    </body>
</html>
