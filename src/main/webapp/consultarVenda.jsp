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
            </ul>
            
            <div class="registro">
            <span class="navbar-text">
              <p> Vitor </p>
            </span>
            <span class="navbar-text">
              <a class="btn btn-sm btn-outline-secondary" href="logout-back">Sair</a>
            </span>
          </div>
              
          </div>                    </nav>
                </header>

            </div>
        </div> <!-- FIM CONTAINER HEADER -->

        <div class="container">
            <div class="row mt-2 mb-2">
                <form action="consultar-venda-back" method="post" class="form-inline text-center">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn but-compra my-2 my-sm-0" type="submit">Procurar</button>
                </form>

            </div>
            <div class="row">
               
                <table class="table table-dark">
                    <thead>
                        <tr>
                            <th scope="col">Código da Venda</th>
                            <th scope="col">Cliente</th>
                            <th scope="col">Valor da venda</th>
                            <th scope="col">Status</th>
                        </tr>
                    </thead>
                    
                    <tbody>
                         <c:forEach items="${listaVendaBack}" var="venda" >
                        <tr>
                            <th name ="id" value="${venda.id}">${venda.id}</th>
                            <td>${venda.idCliente}</td>
                            <td>${venda.valor}</td>
                            <td>
                                <form action ="alterar-status-venda?id=${venda.id} " method="post" >
                                    <select name ="status" >
                                    <option value="${venda.status}">${venda.status}</option>
                                    <option name="status" value="pendente" >Pendente</option>
                                    <option name="status" value="aprovado">Aprovado</option>
                                    <option name="status" value="encaminhado">Encaminhando</option>
                                    <option name="status" value="entregue">Entregue</option>
                                </select>
                                    <button class="but-compra" type="submit">Alterar</button>
                                </form>
                            </td>
                        </tr>
                        </c:forEach> 
                    </tbody>
                     
                </table>
                         
            </div>
        </div>

    </body>
</html>
