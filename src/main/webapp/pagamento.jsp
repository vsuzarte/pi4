<%-- 
    Document   : pagamento
    Created on : 03/06/2018, 22:15:19
    Author     : gabrielsousa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <title>LOJA</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="css/form-validation.css"/>
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
  crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
  <link rel="stylesheet" href="css/endereco.css"/>
  <link rel="stylesheet" type="text/css" href="css/navBlack.css">

</head>

<body>

  <nav class="navbar">
  <a class="navbar-brand" href="#"> HeadShot<img id="logo" src="img/headshot.jpg" alt="imagem logo do site">com</a>
</nav>

  <div class="container">
      

      <div class="row">
        <div class="col-md-4 order-md-2 mb-4 pt-2 pb-4">
          <h4 class="d-flex justify-content-between align-items-center mb-3">
            <span class="text-muted">Carrinho</span>
            <span class="badge badge-secondary badge-pill">3</span>
          </h4>
            
          <ul class="list-group mb-3">
    
              <c:forEach items="${carrinho}" var="produto">
                  
            <li class="list-group-item d-flex justify-content-between lh-condensed">
              <div>
                <img class="text-center" src='<c:url value="${produto.img}"/>' style="height: 70px; width: 70px;" alt="Mouse deathAdder" class="img-responsive"/>
                <h6 class="my-0">${produto.nomeProduto}</h6>
                <small class="text-muted">${produto.descricao}</small>
              </div>
              <span class="text-muted">R$ ${produto.valor}</span>
            </li>
            
            </c:forEach>
         
          </ul>

         
        </div>

        <div class="col-md-8 order-md-1 pt-2 pb-4">
          

              <h4>Enviar para: </h4>
              <div class="card">
          <div class="card-body">
            <blockquote class="blockquote mb-0">
              <img src="img/placeholder.png" style="height: 50px; width: 50px;" class="mb-2">
              <h5><c:out value ="${cliente.ruaCliente}"/></h5>
              <p><c:out value ="${cliente.ruaCliente}, ${cliente.estadoCliente} - CEP: ${cliente.cepCliente}"/></p>
              <span><p><c:out value ="Entregar para: ${cliente.nomeCliente}"/></p></span>
              <footer><a class="float-right" href="cadastrarEndereco.jsp">Enviar para outro endereço</a></footer>
            </blockquote>
          </div>
          
          </div>

              <form action ="finalizar-venda-pagamento" class="needs-validation mt-3" novalidate>
                <h4 class="mb-3">Pagamento</h4>

            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="cc-name">Nome no cartão*</label>
                <input type="text" class="form-control" id="cc-name" placeholder="" required>
                <small class="text-muted">Assim como está escrito no cartão</small>
                <div class="invalid-feedback">
                  Preencha o nome no cartão
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="cc-number">Número do cartão*</label>
                <input  name = "cartao" type="text" class="form-control" id="cc-number" placeholder="" required>
                <div class="invalid-feedback">
                  Preencha o número no cartão
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-3 mb-3">
                <label for="cc-expiration">Data de vencimento*</label>
                <input type="text" class="form-control" id="cc-expiration" placeholder="MM/AA" required>
                <div class="invalid-feedback">
                  Preencha a data de vencimento
                </div>
              </div>
              <div class="col-md-3 mb-3">
                <label for="cc-expiration">CVV*</label>
                <input type="text" class="form-control" id="cc-cvv" placeholder="Código segurança" required>
                <div class="invalid-feedback">
                  Preencha o código de segurança
                </div>

              </div>
               <div class="col-md-3 mb-3">
                    <img src="img/CVV.jpg" style="width: 250px; height: 150px;">                
              </div>
            </div>
            <hr class="mb-4">
            <button class="btn btn-primary btn-lg btn-block" type="submit">Finalizar Compra</button>
          </form>

        </div>


      </div>

      <footer class="my-5 pt-1 text-muted text-center text-small">
           <div class="container-fluid" id="final"><div class="row"><div class="col-12 text-center"><p>Copyright © 2018 HeadShot<img src="img/headshot.jpg" style="height: 20px; width: 20px;"/>com   |   Todos direitos Reservados.</p></div></div></div>
      </footer>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
     <script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../../../assets/js/vendor/popper.min.js"></script>
    <script src="../../../../dist/js/bootstrap.min.js"></script>
    <script src="../../../../assets/js/vendor/holder.min.js"></script>
    <script>
      // Example starter JavaScript for disabling form submissions if there are invalid fields
      (function() {
        'use strict';

        window.addEventListener('load', function() {
          // Fetch all the forms we want to apply custom Bootstrap validation styles to
          var forms = document.getElementsByClassName('needs-validation');

          // Loop over them and prevent submission
          var validation = Array.prototype.filter.call(forms, function(form) {
            form.addEventListener('submit', function(event) {
              if (form.checkValidity() === false) {
                event.preventDefault();
                event.stopPropagation();
              }
              form.classList.add('was-validated');
            }, false);
          });
        }, false);
      })();
    </script>

</body>

</html>
