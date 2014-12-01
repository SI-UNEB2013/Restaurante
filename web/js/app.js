$(function () {
    $('#cadastraProduto').on('submit', function (e) {

        var error = '';
        if ($('#codigo').val() == '') {
            error += "Informe o codigo do produto<br>";
        }
        if ($('#n_produto').val() == '') {
            error += "Informe o nome do produto<br>";
        }
        if ($('#ingredientes').val() == '') {
            error += "Informe os ingredientes<br>";
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


