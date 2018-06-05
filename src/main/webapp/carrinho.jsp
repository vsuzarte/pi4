<%-- 
    Document   : carrinho
    Created on : 03/06/2018, 14:24:13
    Author     : gabrielsousa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <title>HeadShot</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
  crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="css/estilo.css">
  <link rel="stylesheet" type="text/css" href="css/navBlack.css">
  <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">

</head>

<body>

  <div class="container-fluid"> <!-- INICIO CONTAINER HEADER -->
    <div class="row">

      <header class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
        <nav class="navbar navbar-expand-lg navbar-dark">
          <a class="navbar-brand" href="index.jsp">HeadShot<img id="logo" src="img/headshot.jpg" alt="imagem logo do site">com</a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText"
          aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
          <ul class="navbar-nav">
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Categorias <i class="fas fa-headphones"></i></i>
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                <a class="dropdown-item" href="categoria/headset.html">Headset</button> </a>
                <a class="dropdown-item" href="mouse.html">Mouse</a>
                <a class="dropdown-item" href="mousepad.html">Mousepad</a>
                <a class="dropdown-item" href="teclados.html">Teclados</a>
              </div>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="mostrar-carrinho">Seu Carrinho <i class="fas fa-shopping-cart"></i></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="vendas.jsp">Suas Compras <i class="fas fa-shopping-bag"></i></a>
            </li>
          </ul>
          <form action="consultar-produto" method="get"class="form-inline">
              <input class="form-control" type="search" name ="nome" placeholder="Buscar no site." aria-label="Search">
              <button class="btn btn-sm btn-outline-secondary" type="submit">Buscar <i class="fas fa-search"></i></button>
            </form>
          <div class="registro">
          <c:if test = "${sessionScope.cliente == null}">
            <span class="navbar-text">
              <a class="btn btn-sm btn-outline-secondary" href="login.jsp">Entre <i class="fas fa-user"></i></a>
            </span>
                </c:if>
                
                   <c:if test = "${sessionScope.cliente != null}">
                       <p class="btn btn-sm btn-outline-secondary">Bem vindo ${cliente.nomeCliente} <i class="fas fa-user"></i></p>
            <span class="navbar-text">
              <a class="btn btn-sm btn-outline-secondary" href="logout">Sair <i class="fas fa-user"></i></a>
            </span>
                </c:if>
            <c:if test = "${sessionScope.cliente == null}">
            <span class="navbar-text">
              <a class="btn btn-sm btn-outline-secondary" href="cadastroCliente.jsp" t>Cadastre-se <i class="fas fa-user-plus"></i></a>
            </span>
                </c:if>
        </div>
        </div>
      </nav>
    </header>

  </div>
  </div> <!-- FIM CONTAINER HEADER -->

<div class="container-fluid mt-3">
  <h1>Meu Carrinho</h1>
  <table id="cart" class="table table-hover table-condensed">
    <thead>
      <tr>
        <th style="width:40%">Produto</th>
        <th style="width:10%">Preço</th>
        <th style="width:20%">Quantidade</th>
        <th style="width:20%" class="text-center">Subtotal</th>
        <th style="width:10%"></th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${carrinho}" var="produto">
      <tr>
        <td>
          <div class="row">
            <div class="col-sm-2 hidden-xs"><img src='<c:url value="${produto.img}"/>' style="height: 100px; width: 100px;" alt="Mouse deathAdder" class="img-responsive"/></div>
            <div class="col-sm-10">
              <h4 class="nomargin">${produto.nome}</h4>
              <p class="desc-car">${produto.descricao}</p>
            </div>
          </div>
        </td>
        <td data-th="Price">R$ ${produto.preco}</td>
        <td data-th="Quantity">
          <div class="input-group number-spinner mt-2 mb-3">
    <span class="input-group-btn">
      <a href ="diminuir-quantidade?produto=${produto.nome}" class="btn btn-sm but-compra" data-dir="dwn"><i class="fas fa-minus"></i></a>
    </span>
    <input type="text" id="quanti" class="text-center" disabled value="${produto.qtde}">
    <span class="input-group-btn">
      <a href="aumentar-quantidade?produto=${produto.nome}" class="btn btn-sm but-compra" data-dir="up"><i class="fas fa-plus"></i></a>
    </span>
  </div>
        </td>
        <td data-th="Subtotal" class="text-center">R$ ${produto.valor}</td>
        <td class="actions" data-th="">
        

          <a href ="remover-produto-carrinho?produto=${produto.nomeProduto}" class="btn but-compra btn-sm"><i class="fas fa-trash-alt"></i></button>
        </td>
      </tr>

    </c:forEach>
    </tbody>
    <tfoot>
      <tr>
        <td><a href="index.jsp" class="btn but-compra"><i class="fa fa-angle-left"></i> Continuar Comprando</a></td>
        <td colspan="2" class="hidden-xs"></td>
        <td class="hidden-xs text-center"><strong>Total R$ ${totalCarrinho}</strong></td>
        <td><a href="finalizar-venda" class="btn btn-block but-compra">Finalizar <i class="fa fa-angle-right"></i></a></td>
      </tr>
    </tfoot>
  </table>
</div>


<div class="container-fluid mt-3">
  <div class="row">
  <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 text-center">
   <div class="row">
    <div class="col-12 col-sm-12 col-md-3 col-lg-3 col-xl-3 text-center roda mt-2">

      <h2>Redes Sociais</h2>
      <ul class="nav flex-column">
        <li class="nav-item">
          <a class="nav-link" href="https://facebook.com/"><img src="img/face.png" alt="icone facebook" class="text-center" style="height: 40px; width: 40px;">
          /headshot</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="https://twitter.com/"><img src="img/insta.png" alt="icone twitter" class="text-center" style="height: 40px; width: 40px;">@headshot</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="https://www.instagram.com/"><img src="img/twitter.png" alt="icone instagram" class="text-center" style="height: 40px; width: 40px;">@headshot</a>
        </li>

      </ul>
    </div>
    <div class="col-12 col-sm-12 col-md-3 col-lg-3 col-xl-3 text-center roda mt-2">
     <h2>Patrocinadores</h2>
     <ul class="nav flex-column">
      <li class="nav-item">
        <a class="nav-link" href="https://www.razer.com/"><img src="img/razer-logo.png" alt="icone Razer" class="text-center" style="height: 40px; width: 40px;">Razer</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="https://steelseries.com/"><img src="img/steel.jpg" alt="icone SteelSeries" class="text-center" style="height: 40px; width: 40px;">SteelSeries</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="https://www.logitech.com/"><img src="img/LOG.png" alt="icone logitech" class="text-center" style="height: 40px; width: 40px;">Logitech</a>
      </li>
    </ul>
  </div>
  <div class="col-12 col-sm-12 col-md-3 col-lg-3 col-xl-3 text-center roda mt-2">
   <h2>Categorias</h2>
   <ul class="nav flex-column">
    <li class="nav-item">
      <a class="nav-link" href="categoria/headset.html">Headset</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="mouse.html">Mouse</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="mousepad.html">Mousepad</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="teclados.html">Teclado</a>
    </li>
  </ul>
</div>
  <div class="col-12 col-sm-12 col-md-3 col-lg-3 col-xl-3 roda mt-2">
    <h2>Informações</h2>
    <ul class="nav flex-column">
      <li class="nav-item">
        <a class="nav-link"><i class="fas fa-home"></i> Rua Dust, n°2 - Aztec - 66613-666</a>
      </li>
      <li class="nav-item">
        <a class="nav-link"><i class="fas fa-envelope"></i> headshot@gmail.com</a>
      </li>

      <li class="nav-item">
        <a class="nav-link"><i class="fas fa-phone-square"></i> 55(11)3048-6661</a>
      </li>
    </ul>
  </div>
  </div>
  </div>
  </div>
  </div>

  <div class="container-fluid" id="final"><div class="row"><div class="col-12 text-center"><p>Copyright © 2018 HeadShot<img src="img/headshot.jpg" style="height: 20px; width: 20px;"/>com   |   Todos direitos Reservados.</p></div></div></div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
crossorigin="anonymous"></script>
<script defer src="https://use.fontawesome.com/releases/v5.0.8/js/solid.js" integrity="sha384-+Ga2s7YBbhOD6nie0DzrZpJes+b2K1xkpKxTFFcx59QmVPaSA8c7pycsNaFwUK6l"
crossorigin="anonymous"></script>
<script defer src="https://use.fontawesome.com/releases/v5.0.8/js/fontawesome.js" integrity="sha384-7ox8Q2yzO/uWircfojVuCQOZl+ZZBg2D2J5nkpLqzH1HY0C1dHlTKIbpRz/LG23c"
crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.8.1/baguetteBox.min.js"></script>
<script src="headshot.js" type="text/javascript"></script>

</body>

</html>

