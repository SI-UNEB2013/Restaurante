$(function () {
    $('#cadastraProduto').on('submit', function (e) {

        var error = '';
        if ($('#idProduto').val() == ''){
            if ($('input[name=tipo]:checked').val() == undefined) {
            error += "Selecione o tipo do produto<br>";
            }
        }
        
        if ($('#n_produto').val() == '') {
            error += "Informe o nome do produto<br>";
        }
        if($('input[name=tipo]:checked').val() == 'C') {
            if ($('#ingredientes').val() == '') {
                error += "Informe os ingredientes<br>";
            }    
        } else if($('input[name=tipo]:checked').val() == 'B'){
            if ($('#fornecedor').val() == '') {
                error += "Informe o fornecedor<br>";
            }
        }
        
        if ($('#idProduto').val() == '' &&  $('#foto_produto').val() == '') {
            error += "Selecione uma foto<br>";
        }

        if (error != '') {
            $('#errors').addClass('alert alert-danger').html(error);
            return false;
        }
    });
    
    $("input[name=tipo]").on('change',function(e){
        $('#form-details').removeClass('hide');
        if($(e.target).val() == 'B') {
                
            $('#ingredientes').parent().hide();
            $('#fornecedor').parent().removeClass('hide').show();
        } else {
            $('#ingredientes').parent().removeClass('hide').show();
            $('#fornecedor').parent().hide();
        }
          
        console.log($(e.target).val());
    });
    
    
    $('#cadastraBebida').on('submit', function (e) {

        var error = '';
        if ($('#codigo').val() == '') {
            error += "Informe o código do produto<br>";
        }
        if ($('#n_produto').val() == '') {
            error += "Informe o nome do produto<br>";
        }
        if ($('#fornecedor').val() == '') {
            error += "Informe o fornecedor<br>";
        }
        if ($('#foto_produto').val() == '') {
            error += "Selecione uma foto<br>";
        }

        if (error != '') {
            $('#errors').addClass('alert alert-danger').html(error);
            return false;
        }
    });
    
    $('#cadastraBebida').on('submit', function (e) {

        var error = '';
        if ($('#codigo').val() == '') {
            error += "Informe o codigo do produto<br>";
        }
    });
});
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


