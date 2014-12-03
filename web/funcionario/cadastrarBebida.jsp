<jsp:include page="../topo.jsp" />
<jsp:include page="menufuncionario.jsp" />

<div class="row">
    <div class="col-lg-12">
        <h3>Cadastrar Bebida</h3>        
    </div>
</div>


<div class="row">
    <div class="col-lg-12">

        <div class="col-lg-6">

            <form method="post" action="produtoController" role="form" id="cadastraBebida">
                <div id="errors"></div>
                            <div class="form-group">
                                <label>Código</label>
                                <input class="form-control" name="codigo" id="codigo">
                            </div>
							
							<div class="form-group">
                                <label>Nome do Produto</label>
                                <input class="form-control" name="n_produto" id="n_produto">
                            </div>
							
							<div class="form-group">
                                <label>Forecedor</label>
                                <input class="form-control" name="fornecedor" id="fornecedor">
                            </div>
							
							<div class="form-group">
                                <label>Foto do Produto</label>
                                <input type="file" name="foto_produto" id="foto_produto">
                            </div>
							
                            <button type="submit" class="btn btn-default">Salvar Produto</button>
                            <button type="reset" class="btn btn-default">Limpar Campos</button>

                        </form>

                    </div>
    </div>

</div>
<!-- /.row -->

<!--FIM CONTEUDO-->

<jsp:include page="../rodape.jsp" />
