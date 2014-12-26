<jsp:include page="../topo.jsp" />
<jsp:include page="menucliente.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- CONTEUDO-->

<!-- Page Heading -->
<div class="row">
  
    <div class="col-lg-12">
        <ul class="nav nav-tabs">
            <li role="presentation" class="<c:if test="${param.tipo == 'C'}"> active</c:if>" >
                    <a href="Cardapio?tipo=C">Comidas</a>
            </li>
            <li role="presentation" class="<c:if test="${param.tipo == 'B'}">active</c:if>" >
                    <a href="Cardapio?tipo=B">Bebidas</a>
            </li>
            <li role="presentation">
                
                <h4 class="col-lg-1 col-lg-offset-12">
                            <b>Cardápio<b>
                        </h4>
            </li>
       </ul>
    </div>    
</div>
<br>
    <!-- /.row -->


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