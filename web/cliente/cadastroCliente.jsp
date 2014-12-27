<jsp:include page="../topo.jsp" />
<jsp:include page="menucliente.jsp" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="row">
 <div class="col-lg-6">
<form role="form" action="ClienteController" method="post" id="cadastrocliente">
                            <div id="errors"></div>
                            
                            <div class="form-group">
                                <label>Nome</label>
                                <input class="form-control" name="nome" id="username">
                            </div>
                            
                            <div class="form-group">
                                <label>CPF</label>
                                <input class="form-control" name="cpf" id="cpf">
                            </div>
                            
                            <div class="form-group">
                                <label>Endereço</label>
                                <input class="form-control" name="endereco" id="endereco">
                            </div>
                            
                            <div class="form-group">
                                <label>Telefone</label>
                                <input class="form-control" name="telefone" id="telefone">
                            </div>
							
                            <div class="form-group">
                                <label>Senha</label>
                                <input type="password" class="form-control" name="senha" id="senha">
                            </div>
                            <button type="submit" class="btn btn-success btn-lg" role="button" value="Login">Cadastrar</button>
</form>
 </div>
</div>
<jsp:include page="../rodape.jsp" />