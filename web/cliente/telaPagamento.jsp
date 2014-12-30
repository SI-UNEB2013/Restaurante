<jsp:include page="../topo.jsp" />
<jsp:include page="menucliente.jsp" />
<!-- CONTEUDO-->

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                          Tela de Pagamento
                        </h1>
                        <ol class="breadcrumb">
                            <li class="active">
                                <i class="fa fa-edit"></i> Tela de Pagamento
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
                
                <h3 >Confirmar Pagamento</h3> 
                
                
                
<div class="row">
    <div class="col-lg-12">
        <h5 >Cliente:  Cliente x</h5> 
    </div>
</div>
<div class="row">
    <div class="col-lg-12">

        <div class="table-responsive">
            <table class="table table-bordered table-hover table-striped">
                <thead>
                    <tr>
                        <th>Cod Pedido</th>
                        <th>Pedido</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    <tr >
                        <td>1010</td>
                        <td>Pedido 1</td>
                        <td>100,00</td>
                        
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
        <div class="col-lg-6">
            <form role="form" action="Pagamento" method="post" id="confirmaPagamento">
                            <div id="errors"></div>
                            
                            <div class="form-group">
                                <label>Numero do Cartão</label>
                                <input class="form-control" name="numCartao" id="numCartao">
                            </div>
							
							<div class="form-group">
                                <label>Senha</label>
                                <input type="password" class="form-control" name="senha" id="senha">
                            </div>
            <button type="submit" class="btn btn-success btn-lg" role="button" value="confirmar">Confirmar</button>
            </form>
            
        
        </div>
   

</div>
<!-- /.row -->

<!--FIM CONTEUDO-->

<jsp:include page="../rodape.jsp" />