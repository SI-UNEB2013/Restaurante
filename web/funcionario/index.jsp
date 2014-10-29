<jsp:include page="../topo.jsp" />
<jsp:include page="menufuncionario.jsp" />
<!-- CONTEUDO-->
<div class="row">
    <div class="col-lg-12">
        <h3>Pedidos pendentes</h3>        
    </div>
</div>


<div class="row">
    <div class="col-lg-12">

        <div class="table-responsive">
            <table class="table table-bordered table-hover table-striped">
                <thead>
                    <tr>
                        <th>Cliente</th>
                        <th>Cod Pedido</th>
                        <th width="20">Ver pedido</th>
                    </tr>
                </thead>
                <tbody>
                    <tr >
                        <td>Victor Pastori</td>
                        <td>1265</td>
                        <td><a href="funcionario/atenderPedido.jsp" class="btn btn-success btn-lg" role="button">Ver pedido</a></td>
                    </tr>
                    <tr >
                        <td>Enéas para presidente</td>
                        <td>261</td>
                        <td><a href="funcionario/atenderPedido.jsp" class="btn btn-success btn-lg" role="button">Ver pedido</a></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

</div>
<!-- /.row -->

<!--FIM CONTEUDO-->

<jsp:include page="../rodape.jsp" />