<jsp:include page="../topo.jsp" />
<jsp:include page="menucliente.jsp" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- CONTEUDO-->

<!-- Page Heading -->
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Carrinho
        </h1>
        <ol class="breadcrumb">
            <li class="active">
                <i class="fa fa-edit"></i> Edição de carrinho
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
                        <th>Valor Unit.</th>
                        <th>Qtd</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach items="${carrinho.getItens()}" var="item">
                        <tr>
                            <td>${item.produto.id}</td>
                            <td>${item.produto.nome}</td>
                            <td>${item.produto.preco}</td>
                            <td>${item.qtd}</td>
                            <td>${item.getTotal()}</td>
        <!--                    <td><a href="Produtos?acao=editarProduto&id=${produto.id}" class="btn btn-success btn-lg" role="button">Editar</a></td>-->
                        </tr>

                    </c:forEach>


                    <tr >
                        <td colspan="4" align="right"><b>Total</b></td>
                        <td><b>${carrinho.getTotal()}</b></td>
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