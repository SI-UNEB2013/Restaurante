<jsp:include page="../topo.jsp" />
<jsp:include page="menufuncionario.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- CONTEUDO-->
<div class="row">
    <div class="col-lg-12">
        <h3>Produtos</h3>        
    </div>
</div>


<div class="row">
    <div class="col-lg-12">

        <div class="table-responsive">
            <table class="table table-bordered table-hover table-striped">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Produto</th>
                        <th>Tipo</th>
                        <th width="20">Ver pedido</th>
                    </tr>
                </thead>
                <tbody>
                   
                <c:forEach items="${produtos}" var="produto">
                <tr>
                    <td>${produto.id}</td>
                    <td>${produto.nome}</td>
                    <td>${produto.foto}</td>
                    <td><a href="Produtos?acao=editarProduto&id=${produto.id}" class="btn btn-success btn-lg" role="button">Editar</a></td>
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
