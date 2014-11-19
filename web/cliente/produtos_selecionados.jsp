<jsp:include page="../topo.jsp" />
<jsp:include page="menucliente.jsp" />
<!-- CONTEUDO-->

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Confirmar pedido
                        </h1>
                        <ol class="breadcrumb">
                            <li class="active">
                                <i class="fa fa-edit"></i> Confirmação pedido
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
                
                <h3 >Confirmar pedido</h3> 
                
                
<div class="row">
    <div class="col-lg-12">

        <div class="table-responsive">
            <table class="table table-bordered table-hover table-striped">
                <thead>
                    <tr>
                        <th>Cod Produto</th>
                        <th>Produto</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    <tr >
                        <td>1265</td>
                        <td>Produto 1</td>
                        <td>10,00</td>
                        
                    </tr>
                    <tr >
                        <td>261</td>
                        <td>Produto 2</td>
                        <td>10,00</td>
                    </tr>
                    
                    <tr >
                        <td colspan="2" align="right"><b>Total</b></td>
                        <td><b>20,00</b></td>
                    </tr>
                </tbody>
            </table>
            <a href="cliente/logincliente.jsp" class="btn btn-success btn-lg" role="button">Confirmar compra</a>
        </div>
    </div>

</div>
<!-- /.row -->

<!--FIM CONTEUDO-->

<jsp:include page="../rodape.jsp" />