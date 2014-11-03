<jsp:include page="../topo.jsp" />
<jsp:include page="menufuncionario.jsp" />

<div class="row">
    <div class="col-lg-12">
        <h3>Cadastrar Produto</h3>        
    </div>
</div>


<div class="row">
    <div class="col-lg-12">

        <div class="col-lg-6">

                        <form role="form">

                            <div class="form-group">
                                <label>Código</label>
                                <input class="form-control" name="codigo">
                            </div>
							
                            <p><a href="funcionario/cadastrarProduto.jsp" class="btn btn-success btn-lg" role="button">Alterar</a></p>
                            <button type="reset" class="btn btn-default">Limpar Campos</button>

                        </form>

                    </div>
    </div>

</div>
<!-- /.row -->

<!--FIM CONTEUDO-->

<jsp:include page="../rodape.jsp" />

