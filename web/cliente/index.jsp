<jsp:include page="../topo.jsp" />
<jsp:include page="menucliente.jsp" />
<!-- CONTEUDO-->

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Listagem de pedidos
                        </h1>
                    </div>
                </div>
                <!-- /.row -->
                
<!--                <h3 >Confirmar pedido</h3> -->
                
                
<div class="row">
    <div class="col-lg-12">

        <div class="table-responsive">
            <table class="table table-bordered table-hover table-striped">
                <thead>
                    <tr>
                        <th>Cód Pedido</th>
                        <th>Total</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                     <c:forEach items="${compras}" var="item">
                                <tr>
                                    <td>${item.getPedido().getId()}</td>
                                    <td width="450">${item.getTotal()}</td>
                                    <td>${item.status()}</td>
                                    <td>
                                        <a href="ControlaCarrinho?acao=alteraQtd&qtd=&idProduto=${item.produto.id}" class="btn btn-success" role="button">
                                            <span class="fa-check-circle fa-lg"> </span>Detalhes do pedido</a>
                                    </td>
                                </tr>
                    </c:forEach>
                </tbody>
            </table>
            
        </div>
    </div>

</div>
<!-- /.row -->

<!--FIM CONTEUDO-->

<jsp:include page="../rodape.jsp" />