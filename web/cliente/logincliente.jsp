<jsp:include page="../topo.jsp" />
<jsp:include page="menucliente.jsp" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="row">
 <div class="col-lg-6">
<form role="form" action="cliente/telaPagamento.jsp" method="post" id="confirmaPagamento">
                            <div id="errors"></div>
                            
                            <div class="form-group">
                                <label>CPF</label>
                                <input class="form-control" name="numCartao" id="numCartao">
                            </div>
							
							<div class="form-group">
                                <label>Senha</label>
                                <input type="password" class="form-control" name="senha" id="senha">
                            </div>
                            <input type="submit" class="btn btn-success btn-lg" role="button" value="Login">
</form>
 </div>
</div>
<jsp:include page="../rodape.jsp" />
