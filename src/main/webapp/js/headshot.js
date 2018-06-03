var app = angular.module('hs', []);
app.controller('principal', function ($scope, $http) {


    $http.get('produtos.json').then(function (response) {
        $scope.mouses = response.data.mouses;
        $scope.fones = response.data.fones;
        $scope.teclados = response.data.teclados;
        $scope.mousepads = response.data.mousepads;


    });


    $scope.mouses = [];
    $scope.teclados = [];
    $scope.fones = [];
    $scope.mousepads = [];

    $scope.opcaoMouse = 0;
    $scope.opcaoTeclado = 0;
    $scope.opcaoMousepad = 0;
    $scope.opcaoFone = 0;

    $scope.mostrarTudo = true;
    $scope.mostrarMouse = false;
    $scope.mostrarTeclado = false;
    $scope.mostrarMousepad = false;
    $scope.mostrarFone = false;

    $scope.opcaoRazer = 0;
    $scope.opcaoLogitech = 0;
    $scope.opcaoMultilazer = 0;
    $scope.opcaoSteelseries = 0;

    $scope.mostrarRazer = false;
    $scope.mostrarLogitech = false;
    $scope.mostrarMultilazer = false;
    $scope.mostrarSteelseries = false;


    $scope.opcaoPrecos = 0;

    $scope.todos = function(){
        $scope.opcaoPrecos = 0;
    }

    $scope.op1 = function(){
        $scope.opcaoPrecos = 1;
    }

    $scope.op2 = function(){
        $scope.opcaoPrecos = 2;
    }

    $scope.op3 = function(){
        $scope.opcaoPrecos = 3;
    }

    $scope.op4 = function(){
        $scope.opcaoPrecos = 4;
    }

    $scope.addRazer = function(){
        $scope.opcaoRazer++;
        if($scope.opcaoRazer % 2 != 0){
         $scope.mostrarRazer = true;
        }else{
         $scope.mostrarRazer = false;
        }


    }

    $scope.addMultilazer = function(){
        $scope.opcaoMultilazer++;
        if($scope.opcaoMultilazer % 2 != 0){
         $scope.mostrarMultilazer = true;
        }else{
         $scope.mostrarMultilazer = false;
        }


    }


    $scope.addSteelseries = function(){
        $scope.opcaoSteelseries++;
        if($scope.opcaoSteelseries % 2 != 0){
         $scope.mostrarSteelseries = true;
        }else{
         $scope.mostrarSteelseries = false;
        }


    }

    $scope.addLogitech = function(){
        $scope.opcaoLogitech++;
        if($scope.opcaoLogitech % 2 != 0){
         $scope.mostrarLogitech = true;
        }else{
         $scope.mostrarLogitech = false;
        }


    }





    $scope.filtro = function (produto) {
        var filtro = "";
        var min = 0;
        var max = 0;

 if($scope.opcaoPrecos == 1){
     min = 0;
     max = 100;

 }

 if($scope.opcaoPrecos == 2){
    min = 100;
    max = 300;

}

if($scope.opcaoPrecos == 3){
    min = 300;
    max = 500;

}

if($scope.opcaoPrecos == 4){
    min = 500;
    max = 9000000000;

}


        if ( $scope.mostrarRazer == true){
               filtro += "Razer";
        }

         if ( $scope.mostrarMultilazer == true){
            filtro += "Multilazer";
        }

    if ( $scope.mostrarLogitech == true){
        filtro += "Logitech";
        }

        if ( $scope.mostrarSteelseries == true){
            filtro += "Steelseries";
            }

  if (filtro == "" && $scope.opcaoPrecos == 0){
     return true;
  }

  if (filtro != "" && $scope.opcaoPrecos == 0){
    return filtro.includes(produto.marca);
 }

 if (filtro == "" && $scope.opcaoPrecos != 0){
    return(produto.valor >= min && produto.valor <= max) ;
 }



        return filtro.includes(produto.marca) && (produto.valor >= min && produto.valor <= max) ;
    };







    $scope.mostrarMouses = function() {
        $scope.mostrarTudo = false;
       $scope.opcaoMouse++;
       if($scope.opcaoMouse % 2 != 0){
        $scope.mostrarMouse = true;
       }else{
        $scope.mostrarMouse = false;
       }
      };

      $scope.mostrarTeclados = function() {
        $scope.mostrarTudo = false;
        $scope.opcaoTeclado++;
        if($scope.opcaoTeclado % 2 != 0){
         $scope.mostrarTeclado = true;
        }else{
         $scope.mostrarTeclado = false;
        }
       };

       $scope.mostrarFones = function() {
        $scope.mostrarTudo = false;
        $scope.opcaoFone++;
        if($scope.opcaoFone % 2 != 0){
         $scope.mostrarFone = true;
        }else{
         $scope.mostrarFone = false;
        }
       };

       $scope.mostrarMousepads = function() {
        $scope.mostrarTudo = false;
        $scope.opcaoMousepad++;
        if($scope.opcaoMousepad % 2 != 0){
            $scope.mostrarMousepad = true;
        }else{
            $scope.mostrarMousepad = false;
        }
       };



});

$(document).on('click', '.number-spinner button', function () {
	var btn = $(this),
		oldValue = btn.closest('.number-spinner').find('input').val().trim(),
		newVal = 0;

	if (btn.attr('data-dir') == 'up') {
		newVal = parseInt(oldValue) + 1;
	} else {
		if (oldValue > 1) {
			newVal = parseInt(oldValue) - 1;
		} else {
			newVal = 1;
		}
	}
	btn.closest('.number-spinner').find('input').val(newVal);
});
