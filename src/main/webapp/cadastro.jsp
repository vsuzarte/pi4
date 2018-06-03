<%-- 
    Document   : cadastro
    Created on : 02/06/2018, 20:35:20
    Author     : vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>LOJA</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="css/navBlack.css"/>
        <link rel="stylesheet" href="css/estilo.css"/>
        <link rel="stylesheet" href="css/form-validation.css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">

    </head>

    <body>

        <div class="container-fluid"> <!-- INICIO CONTAINER HEADER -->
            <div class="row">
                <header class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                    <nav class="navbar navbar-expand-lg navbar-dark">
                        <a class="navbar-brand" href="index.html">HeadShot<img id="logo" src="img/headshot.jpg" alt="imagem logo do site">com</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText"
                                aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>



                    </nav>
                </header>

            </div>
        </div> <!-- FIM CONTAINER HEADER -->
        
        <div class="container-fluid">

      <div class="row">
        
        <div class="col-md-8 order-md-1 bg-razer pt-2 pb-4">
          <h4 class="mb-3">Cadastrar Produto</h4>
          <form action="${pageContext.request.contextPath}/cadastro-produto" method="post">
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="zip">Nome*</label>
                <input type="text" class="form-control" id="nome" name = "nomeProduto" placeholder="NOME" required>
              </div>
              <div class="col-md-6 mb-3">
                 <label for="desc">Descrição*</label>
                <input type="text" class="form-control" id="desc" name = "descricao" placeholder="Descrição" required>
              </div>
            </div>

           <div class="row">
              <div class="col-md-6 mb-3">
                <label for="valor">Valor</label>
                <input type="number" class="form-control" id="valor" name = "valorProduto" placeholder="Valor"required>
              </div>
              <div class="col-md-6 mb-3">
                 <label for="categoria">Valor</label>
                <input type="text" class="form-control" id="categoria" name = "categoria" placeholder="Categoria"required>
              </div>
            </div>

            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="desc1">Desc1*</label>
                <input type="text" class="form-control" id="desc1" name = "c1" placeholder="Desc1" required>
              </div>
              <div class="col-md-6 mb-3">
                 <label for="desc2">Desc2*</label>
                <input type="text" class="form-control" id="desc2" name = "c2" placeholder="desc2" required>
              </div>
            </div>

            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="nome">Desc3*</label>
                <input type="text" class="form-control" id="desc3" name = "c3" placeholder="Desc3" required>
              </div>
              <div class="col-md-6 mb-3">
                 <label for="desc4">Desc4*</label>
                <input type="text" class="form-control" id="desc4" name = "c4" placeholder="Desc4" required>
              </div>
            </div>
              
               <div class="row">
              <div class="col-md-6 mb-3">
                <label for="desc5">Desc5*</label>
                <input type="text" class="form-control" id="desc5" name = "c5" placeholder="Desc5" required>
              </div>
              <div class="col-md-6 mb-3">
                 <label for="desc6">Desc6*</label>
                <input type="text" class="form-control" id="desc6" name = "c6" placeholder="Desc6" required>
              </div>
            </div>

            <hr class="mb-4">
            <button class="btn btn-primary btn-lg btn-block" type="submit">Salvar</button>
          </form>
        </div>
      </div>

      <footer class="my-5 pt-1 text-muted text-center text-small">
         <p class="mt-5 mb-3 text-muted">&copy; 2018 HeadShot.com</p>
      </footer>
    </div>


        

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
    <script src="headshot.js" type="text/javascript"></script>

</body>

</html>
