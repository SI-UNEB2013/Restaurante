<jsp:include page="topo.jsp" />

<!-- Navigation (Barra do topo)-->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
        <a class="navbar-brand" href="cliente/index.jsp">Gourmet Delivery</a>
    </div>
    <!-- Top Menu Items -->
</nav>

<div id="page-wrapper">
    <div class="container-fluid">


        <!-- CONTEUDO-->




        <h3>Erro</h3>
        <div class="row">
            <div class="col-lg-6 text-center warning">
                 ${erro}
            </div>
        </div>
    </div>
    <!-- /.row -->

    <!--FIM CONTEUDO-->
</div>
<jsp:include page="rodape.jsp" />