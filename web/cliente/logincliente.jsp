<jsp:include page="../topo.jsp" />
<jsp:include page="menucliente.jsp" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="row">
 <div class="col-lg-6">
<form role="form" action="Login" method="post" id="logincliente">
                            <div id="errors">${error}</div>
                            
                            <div class="form-group">
                                <label>login</label>
                                <input class="form-control" name="username" id="username">
                            </div>
							
							<div class="form-group">
                                <label>Senha</label>
                                <input type="password" class="form-control" name="senha" id="senha">
                            </div>
                            <button type="submit" class="btn btn-success btn-lg" role="button" value="Login">Login</button>
</form>
 </div>
</div>
<jsp:include page="../rodape.jsp" />
