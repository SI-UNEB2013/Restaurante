<jsp:include page="../topo.jsp" />
<jsp:include page="menufuncionario.jsp" />

<div class="row">
    <div class="col-lg-12">
        <h3>Cadastrar Produto</h3>        
    </div>
</div>

<br>
<div class="row">
    <div class="col-lg-12">

        <div class="col-lg-6">

                        <form role="form" action="CadastraProduto" method="post" id="cadastraProduto">
                            <div id="errors"></div>
                            
                            <div class="form-group">
                                <label class="col-lg-4">Selecione o tipo</label>
                                 <div class="btn-group " data-toggle="buttons">
                                     <label class="pull-left btn btn-default">
                                         <input type="radio" value="C" name="tipo" id="tipocomida"> Comida
                                    </label>
                                     <label class="btn btn-default">
                                        <input type="radio" value="B" name="tipo" id="tipobebida"> Bebida
                                    </label>
                                </div>
                            </div>
                            <hr>
                            <div id='form-details' class="hide">
                                <div class="form-group">
                                    <label>Código</label>
                                    <input class="form-control" name="codigo" id="codigo">
                                </div>

                                <div class="form-group">
                                    <label>Nome do Produto</label>
                                    <input class="form-control" name="n_produto" id="n_produto">
                                </div>

                                <div class="form-group">
                                    <label>Ingredientes</label>
                                    <textarea class="form-control" rows="3" name="ingredientes" id="ingredientes"></textarea>
                                </div>

                                <div class="form-group ">
                                    <label>Fornecedor</label>
                                    <select name ="fornecedor" id="fornecedor" class="form-control">
                                        <option value="">Selecione</option>
                                        <option value="1">Fornecedor 1</option>
                                    </select>
                                </div>


                                <div class="form-group ">
                                    <label>Preço</label>
                                    <input type="money" name="preco" id="preco" class="form-control ">
                                </div>

                                <div class="form-group">
                                    <label>Foto do Produto</label>
                                    <input type="file" class="form-control" name="foto_produto" id="foto_produto">
                                </div>

                                <button type="submit" class="btn btn-info">Salvar Produto</button>
                                <button type="reset" class="btn btn-default">Limpar Campos</button>

                            </div>
                        </form>

                    </div>
        
            <div class="col-lg-6">
                  
                    <img src="images/Caneloni_foto-Thiago-Freire.jpg" class="img-thumbnail">
                 
            </div>
        </div>
    </div>

</div>
<!-- /.row -->

<!--FIM CONTEUDO-->

<jsp:include page="../rodape.jsp" />
