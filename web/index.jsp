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





        <div class="row">
            <div class="col-lg-12">
                <img src="images/banner.jpg" width="100%">
            </div>
        </div>
        <br>

<!--        <div class="row">
            <div class="col-lg-12 text-center">
                <h3 class="center">Seja bem vindo!</h3>
            </div>
        </div>
        -->
        <div class="row">

            <div class="col-lg-6 text-center">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h3>Confira nosso cardápio</h3>
                        <p><a href="Cardapio?tipo=C" class="btn btn-success btn-lg" role="button">Cardápio</a></p>

                    </div>
                </div>
            </div>
            <div class="col-lg-6 text-center">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h3>Acesse sua conta</h3>
                        <a href="Login" class="btn btn-success btn-lg" role="button">Login</a>
                    </div>
                </div>
            </div>

        </div>
        <!-- /.row -->

        <!--FIM CONTEUDO-->

        <jsp:include page="rodape.jsp" />