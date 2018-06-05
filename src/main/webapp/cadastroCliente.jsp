<%-- 
    Document   : cadastroCliente
    Created on : 04/06/2018, 16:17:10
    Author     : gabrielsousa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>

<head>
  <title>HeadShot</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="css/login.css"/>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
  crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">

</head>

<body class="text-center">


  <form action="cadastro-cliente" method="post" class="form-signin">
        <img class="mb-4" src="img/headshot.jpg" alt="" width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal">Criar Conta</h1>

        <label for="inputNome" class="sr-only">Nome</label>
        <input name="nome" type="text" id="inputNome" class="form-control" placeholder="Nome" required autofocus>

        <label for="inputEmail" class="sr-only">Email</label>
        <input name="email" type="email" id="inputEmail" class="form-control" placeholder="Email" required>

        <label for="inputPassword" class="sr-only">Senha</label>
        <input name="senha" type="password" id="inputPassword" class="form-control" placeholder="Senha" required>

        <label for="inputPassword2" class="sr-only">Confirmar Senha</label>
        <input name="senha2" type="password" id="inputPassword2" class="form-control" placeholder="Confirmar senha" required>
        <div class="mb-3">
        </div>
        <button class="btn btn-lg btn-block but mb-3" type="submit">Criar conta</button>

        <a href="index.jsp" class="text-muted">Cancelar</a>

        <p class="mt-5 mb-3 text-muted">&copy; 2018 HeadShot.com</p>
      </form>



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
