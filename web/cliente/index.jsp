<jsp:include page="../topo.jsp" />
<jsp:include page="menucliente.jsp" />
<!-- CONTEUDO-->

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Cardápio
                        </h1>
                        <ol class="breadcrumb">
                            <li class="active">
                                <i class="fa fa-edit"></i> Selecionar Seção de produto
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
                
                <h3 >Selecione uma Seção</h3> 
                
                <div class="row">
                    <div class="col-lg-6 text-center">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <h3>Comidas</h3>
                                <p><a href="cliente/comidas.jsp" class="btn btn-success btn-lg" role="button">Selecionar</a></p>
                                
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 text-center">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <h3>Bebidas</h3>
                                <a href="cliente/bebidas.jsp" class="btn btn-success btn-lg" role="button">Selecionar</a>
                            </div>
                        </div>
                    </div>
                    
                </div>
                <!-- /.row -->

<!--FIM CONTEUDO-->

<jsp:include page="../rodape.jsp" />