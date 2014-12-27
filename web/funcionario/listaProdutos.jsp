<jsp:include page="../topo.jsp" />
<jsp:include page="menufuncionario.jsp" />
<!-- CONTEUDO-->
<div class="row">
    <div class="col-lg-12">
        <h3>Lista de Produtos</h3>        
    </div>
</div>


<div class="row">
    <div class="col-lg-12">

        <div class="table-responsive">
            <table class="table table-bordered table-hover table-striped">
                <thead>
                    <tr>
                        <th>Produto</th>
                        <th>Cod Produto</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr >
                        <td>Produto A</td>
                        <td>0001</td>
                        <td><a href="funcionario/cadastrarProduto.jsp" class="btn btn-success btn-lg" role="button">Alterar</a></td>
                        <td><a href="funcionario/cadastrarBebida.jsp" class="btn btn-success btn-lg" role="button">Excluir</a></td>
                    </tr>
                    <tr >
                        <td>Produto B</td>
                        <td>0002</td>
                        <td><a href="funcionario/cadastrarBebida.jsp" class="btn btn-success btn-lg" role="button">Alterar</a></td>
                        <td><a href="funcionario/cadastrarBebida.jsp" class="btn btn-success btn-lg" role="button">Excluir</a></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

</div>
<!-- /.row -->

<!--FIM CONTEUDO-->

<jsp:include page="../rodape.jsp" />