<%-- 
    Document   : index
    Created on : 02/06/2018, 17:39:14
    Author     : vitor
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <!DOCTYPE html>
  <html ng-app="ofertas" ng-controller="ofControl">

  <head>
    <title>LOJA</title>
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
                  <a class="dropdown-item" href="headset.html">Headset</button> </a>
                  <a class="dropdown-item" href="mouse.html">Mouse</a>
                  <a class="dropdown-item" href="mousepad.html">Mousepad</a>
                  <a class="dropdown-item" href="teclados.html">Teclados</a>
                </div>
              </li>
              <li class="nav-item">
                <a href="mostrar-carrinho" class="nav-link" >Seu Carrinho <i class="fas fa-shopping-cart"></i></a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="compras.html">Suas Compras <i class="fas fa-shopping-bag"></i></a>
              </li>
            </ul>
            <form action="consultar-produto" method="get"class="form-inline">
              <input class="form-control" type="search" name ="nome" placeholder="Buscar no site." aria-label="Search">
              <button class="btn btn-sm btn-outline-secondary" type="submit">Buscar <i class="fas fa-search"></i></button>
            </form>
            <div class="registro">
            <span class="navbar-text">
              <a class="btn btn-sm btn-outline-secondary" href="login.jsp" type="button">Entre <i class="fas fa-user"></i></a>
            </span>
            <span class="navbar-text">
              <a class="btn btn-sm btn-outline-secondary" href="cadastroCliente.jsp" type="button">Cadastre-se <i class="fas fa-user-plus"></i></a>
            </span>
          </div>
          </div>
        </nav>
      </header>

    </div>
    </div> <!-- FIM CONTAINER HEADER -->

    <div class="container-fluid"> <!-- INICIO CONTAINER CARROSEL -->
     <div class="row">
       <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img class="d-block w-100" src="img/foneS.png" alt="Fone Arctis SteelSeries">
            </div>
            <div class="carousel-item">
              <img class="d-block w-100" src="img/manba.png" alt="Mouse Razer Mamba">
            </div>
            <div class="carousel-item">
              <img class="d-block w-100" src="img/tecladoRZ.png" alt="Teclado Razer Ornata">
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
      </div>
    </div>
    </div> <!-- FIM CONTAINER CARROSEL -->

    <div class="container-fluid">
      <div class="row">
        <div class="col-12 col-sm-12 col-md-3 col-lg-3 col-xl-3"> <!-- INICIO LISTA CATEGORIAS -->

          <div class="text-center m-3">
            <h3 class="of">CATEGORIAS</h3>
            <ul class="list-group">
      <li class="list-group-item d-flex justify-content-between align-items-center">
        <a href="categoria/headset.html">Headset</a>

      </li>
      <li class="list-group-item d-flex justify-content-between align-items-center">
        <a href="mouse.html">Mouse</a>

      </li>
      <li class="list-group-item d-flex justify-content-between align-items-center">
        <a href="mousepad.html">Mousepad</a>

      </li>
      <li class="list-group-item d-flex justify-content-between align-items-center">
        <a href="teclados.html">Teclado</a>

      </li>
    </ul>

        </div> <!-- FIM LISTA CATEGORIAS -->
      </div>

      <div class="col-12 col-sm-12 col-md-9 col-lg-9 col-xl-9"> <!-- INICIO DA AREA DE PRODUTOS -->

        <div class="text-center m-3">
          <h3 class="of">OFERTAS</h3>
        </diV>

        <div   class="row">
            
            <c:forEach items="${listaProduto}" var="produto">
          <div class="col-12 col-sm-12 col-md-4 col-lg-4 col-xl-4 mb-3"> <!-- INICIO DO PRODUTOS -->

            <div class="mycard text-center">
              <figure>
                
                  <img src='<c:url value="${produto.img}"/>' style="width: 130px; height: 130px" alt= {{p.nome}}>
                  
                <div>
                  <h3><c:out value="${produto.nomeProduto}"/></h3>
                  <h3><c:out value="${produto.categoria}"/></h3>


                  <div class="mycardFooter">
                    <b>R$ <c:out value="${produto.valorProduto}"/></b>
                  </div>
                </div>

            </figure>

            <button type="button"  class="btn btn-sm mb-1 but-compra">Detalhes</button>
            <a href="add-produto-carrinho?produto=${produto.nomeProduto}" class="btn btn-sm mb-1 but-compra">Comprar</a>

          </div>
              
        

        </div> <!-- FIM DO PRODUTOS -->
  </c:forEach>

    </div>
  </div>

</div>
</div>


    <div class="container mt-3">
    <div class="row">
    <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 text-center">
     <div class="row">
      <div class="col-12 col-sm-12 col-md-3 col-lg-3 col-xl-3 text-center roda">

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
      <div class="col-12 col-sm-12 col-md-3 col-lg-3 col-xl-3 text-center roda">
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
    <div class="col-12 col-sm-12 col-md-3 col-lg-3 col-xl-3 text-center roda">
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
    <div class="col-12 col-sm-12 col-md-3 col-lg-3 col-xl-3 roda">
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

  <script src="js/ofertas.js" type="text/javascript"></script>


  </body>

  </html>

