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
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="cliente/index.jsp">Categoria</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> Comidas
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
                
    <h3>Comidas</h3>
    
                <div class="row">
                    <div class="col-lg-4 text-center">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <h3>Produto 1</h3>
                                <img src="images/Caneloni_foto-Thiago-Freire.jpg" class="img-thumbnail">
                                <p>lkfjhsdlk fjhsdlkfjahsdf safsd asfasdfa sdf</p>
                                <a href="ControlaCarrinho?acao=addProduto&idProduto=32"class="btn btn-success">Selecionar</a>
                              
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 text-center">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <h3>Produto 2</h3>
                                <img src="images/Caneloni_foto-Thiago-Freire.jpg" class="img-thumbnail">
                                <p>lkfjhsdlk fjhsdlkfjahsdf safsd asfasdfa sdf</p>
                                  <a href="ControlaCarrinho?acao=addProduto&idProduto=31"class="btn btn-success">Selecionar</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 text-center">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <h3>Produto 3</h3>
                                <img src="images/Caneloni_foto-Thiago-Freire.jpg" class="img-thumbnail">
                                <p>lkfjhsdlk fjhsdlkfjahsdf safsd asfasdfa sdf</p>
                                  <a href="ControlaCarrinho?acao=addProduto&idProduto=30"class="btn btn-success">Selecionar</a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->

<!--FIM CONTEUDO-->

<jsp:include page="../rodape.jsp" />