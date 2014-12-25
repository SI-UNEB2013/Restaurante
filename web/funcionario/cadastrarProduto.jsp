<jsp:include page="../topo.jsp" />
<jsp:include page="menufuncionario.jsp" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
    <div class="col-lg-12">
        <h3>Cadastrar Produto</h3>
    </div>
</div>

 <c:if test="${produto.tipo == 'C'}"> </c:if> 
<br>
<div class="row">
    <div class="col-lg-12">

        <div class="col-lg-6">

                        <form role="form" action="Produtos" method="POST" id="cadastraProduto">
                            <div id="errors"></div>
                            
                            <div class="form-group">
                                <label class="col-lg-4">Selecione o tipo</label>
                                 <div class="btn-group " data-toggle="buttons">
                                     <label class="pull-left btn btn-default <c:if test="${produto.tipo == 'C'}">active</c:if>">

                                         <input type="radio" value="C" name="tipo" id="tipocomida" <c:if test="${produto.tipo == 'C'}"> checked="checked" </c:if> > Comida
                                    </label>
                                     <label class="btn btn-default <c:if test="${produto.tipo == 'B'}">active</c:if>">
                                        <input type="radio" value="B" name="tipo" id="tipobebida" <c:if test="${produto.tipo == 'B'}"> checked="checked" </c:if> > Bebida
                                    </label>
                                </div>
                            </div>
                            <hr>
                            <div id='form-details' <c:if test="${produto.id == null}">class="hide"</c:if> >
                                <div class="form-group <c:if test="${produto.id == null}">class="hide"</c:if>">
                                    <label>Código: ${produto.id}</label>
                                    <input type="hidden" class="form-control" name="codigo" value="${produto.id}" id="idProduto">
                                </div>

                                <div class="form-group">
                                    <label>Nome do Produto</label>
                                    <input class="form-control" name="n_produto" id="n_produto" value="${produto.nome}">
                                </div>

                                <div class="form-group <c:if test="${produto.tipo != 'C'}">hide</c:if>">
                                    <label>Ingredientes</label>
                                    <textarea class="form-control" rows="3" name="ingredientes" id="ingredientes">${produto}</textarea>
                                </div>

                                <div class="form-group <c:if test="${produto.tipo != 'B'}">hide</c:if>">
                                    <label>Fornecedor</label>
                                    <select name ="fornecedor" id="fornecedor" class="form-control">
                                        <option value="">Selecione</option>
                                        <option value="1">Fornecedor 1</option>
                                    </select>
                                </div>


                                <div class="form-group ">
                                    <label>Preço</label>
                                    <input type="money" name="preco" id="preco" class="form-control " value="${produto.preco}">
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
                            
                   
        <% if(request.getParameter("id") != null) { %>
            <div class="col-lg-6">
                  
                    <img src="images/Caneloni_foto-Thiago-Freire.jpg" class="img-thumbnail">
                 
            </div>
        <% } %>
        </div>
    </div>

</div>
<!-- /.row -->

<!--FIM CONTEUDO-->

<jsp:include page="../rodape.jsp" />
