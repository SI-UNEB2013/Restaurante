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
            <li role="presentation" class="col-lg-6 text-center">
                <h4 class="">
                            <b>Cardápio</b>
                </h4>
            </li>
            <li role="presentation" class="col-lg-3 text-right" style="margin-right:0px; padding-right: 0px">
                
                    
                     
                    <c:if test="${(carrinho.getItens().size()) >0 ==false}">
                          
                        <b><span class="fa fa-money"></span> Carrinho vazio.</b>
                    </c:if>
                    <c:if test="${carrinho.getItens().size() > 0}">
                        
                        <a href="ControlaCarrinho">
                               <span class="fa fa-money"></span> 
                            Itens no carrinho: ${carrinho.getItens().size()}
                        </a>
                    </c:if>
                        
                    
            </li>
       </ul>
    </div>    
</div>
<br>
    <!-- /.row -->


    <div class="row">
           <c:forEach items="${produtos}" var="produto">
        <div class="col-lg-4 text-center">
            <div class="panel panel-default">
                
                              
                          
                <div class="panel-body">
                    <h3>${produto.getNome()}</h3>
                    <img src="images/Caneloni_foto-Thiago-Freire.jpg" class="img-thumbnail">
                    <h3 class="warning text-info "><b>R$ ${produto.getPreco()}</b></h3>
                    <a href="ControlaCarrinho?acao=addProduto&idProduto=${produto.getId()}"class="btn btn-success">Adicionar</a>

                </div>
            </div>
        </div>
        </c:forEach>      
        
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