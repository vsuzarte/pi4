<%-- 
    Document   : cadastrarEndereco
    Created on : 03/06/2018, 23:03:49
    Author     : gabrielsousa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

</head>

<body>

  <div class="container">
      <div class="py-5 text-center">
        
         <a href="index.jsp"><img class="mb-4" src="img/headshot.jpg" alt="" width="72" height="72"></a>
       
      </div>

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
        <div class="col-md-8 order-md-1 bg-razer pt-2 pb-4">
          <h4 class="mb-3">Cadastrar Endereço</h4>
          <form action="cadastro-endereco" method="post" class="needs-validation" novalidate>
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="zip">CEP*</label>
                <input name="cep" type="text" class="form-control" id="zip" placeholder="CEP" required>
                <div class="invalid-feedback">
                  Preencha do CEP.
                </div>
              </div>
              <div class="col-md-6 mb-3">
                
              </div>
            </div>

           <div class="row">
              <div class="col-md-6 mb-3">
                <label for="estado">Estado</label>
                <input name ="estado" type="text" class="form-control" id="estado" placeholder="Estado" required>
                <div class="invalid-feedback">
                  Preencha o Estado.
                </div>
              </div>
              <div class="col-md-6 mb-3">
                 <label for="cidade">Cidade</label>
                <input name="cidade" type="text" class="form-control" id="cidade" placeholder="Cidade" required>
                <div class="invalid-feedback">
                  Preencha a Cidade.
                </div>
              </div>
            </div>

            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="rua">Rua/Avenida*</label>
                <input name="rua" type="text" class="form-control" id="rua" placeholder="Rua/Avenida" required>
                <div class="invalid-feedback">
                  Preencha a Rua/Avenida.
                </div>
              </div>
              <div class="col-md-6 mb-3">
                 <label for="num">Número*</label>
                <input name="numero" type="text" class="form-control" id="num" placeholder="Número" required>
                <div class="invalid-feedback">
                  Preencha o Número.
                </div>
              </div>
            </div>

            <div class="mb-3">
              <label for="address2">Complemento<span class="text-muted">(Opcional)</span></label>
              <input name="complemento" type="text" class="form-control" id="address2" placeholder="Apartamento ou casa">
            </div>

            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="rua">Bairro*</label>
                <input name="bairro" type="text" class="form-control" id="bairro" placeholder="Bairro" required>
                <div class="invalid-feedback">
                  Preencha o Bairro.
                </div>
              </div>
              <div class="col-md-6 mb-3">
                 
              </div>
            </div>

            <hr class="mb-4">
            <button class="btn btn-primary btn-lg btn-block" type="submit">Continuar</button>
          </form>
        </div>
      </div>

      <footer class="my-5 pt-1 text-muted text-center text-small">
         <p class="mt-5 mb-3 text-muted">&copy; 2018 HeadShot.com</p>
      </footer>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
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
