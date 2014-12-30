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
    </div>
</div>
<!-- /.row -->

<div class="row">

    <div class="col-lg-12">

        <c:choose>
            <c:when test="${carrinho == null || carrinho.getItens().size() == 0}">
                
                <h3>Carrinho vazio.</h3>
                <a href="Cardapio?tipo=C" class="btn btn-default " role="button">Continuar escolhendo</a>

            </c:when>
            <c:otherwise>

                <div class="table-responsive">
                    <table class="table table-bordered table-hover table-striped">
                        <thead>
                            <tr>
                                <th>Cod Produto</th>
                                <th>Produto</th>
                                <th>Valor Unit.</th>
                                <th>Qtd</th>
                                <th>Valor</th>
                                <th>Ações</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach items="${carrinho.getItens()}" var="item">
                                <tr>
                                    <td>${item.produto.id}</td>
                                    <td width="450">${item.produto.nome}</td>
                                    <td>${item.produto.preco}</td>
                                    <td><input type="text" class="form-control small input-sm" size=1 value="${item.qtd}"></td>
                                    <td>${item.getTotal()}</td>
                                    <td> 
                                        <a href="ControlaCarrinho?acao=alteraQtd&qtd=&idProduto=${item.produto.id}" class="btn btn-success" role="button">
                                            <span class="fa-check-circle fa-lg"> </span>Atualizar</a>&nbsp;&nbsp;&nbsp;
                                        <a href="ControlaCarrinho?acao=removeProduto&idProduto=${item.produto.id}" class="btn btn-danger" role="button">x</a>
                                    </td>
                                </tr>

                            </c:forEach>


                            <tr >
                                <td colspan="4" align="right"><b>Total</b></td>
                                <td><b>${carrinho.getTotal()}</b></td>
                            </tr>
                        </tbody>
                    </table>
                    <a href="Cardapio?tipo=C" class="btn btn-default " role="button">Continuar escolhendo</a>
                    <a href="cliente/logincliente.jsp" class="btn btn-success btn-lg" role="button">Confirmar compra</a>

                </div>

            </c:otherwise>
        </c:choose>

    </div>

</div>
<!-- /.row -->

<!--FIM CONTEUDO-->

<jsp:include page="../rodape.jsp" />