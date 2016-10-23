<%-- 
    Document   : header
    Created on : 20/10/2016, 20:32:21
    Author     : Mucio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link rel="icon" href="http://www.ifpe.edu.br/++theme++copia-tema-verde-portal-padrao/img/favicon.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!--link para a font-awesome-->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/justified-nav.css" rel="stylesheet" type="text/css"/>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>

        <script src="js/jquery-ui.js"></script>
        <link rel="stylesheet" href="css/jquery-ui.css"> 

    <body>
        <div class="container">
            <!-- The justified navigation menu is meant for single line per list item.
                 Multiple lines will require custom code not provided by Bootstrap. -->
            <div class="masthead">
                <h3 class="text-muted">SysReserva - IFPE</h3>
                <nav>
                    <ul class="nav nav-justified">
                        <li><a href="ReservaServlet?logica=reservaSala"><i class="fa fa-sign-in" aria-hidden="true"></i> Reservar Sala</a></li>
                        <li><a href="adicionaProf.jsp"><i class="fa fa-plus" aria-hidden="true"></i> Add Professor</a></li>
                        <li><a href="adicionaSala.jsp"><i class="fa fa-plus" aria-hidden="true"></i> Add Sala</a></li>
                        <li><a href="adicionaEquip.jsp"><i class="fa fa-plus" aria-hidden="true"></i> Add Equipamentos</a></li>
                        <li><a href="ProfServlet?logica=listaProf"><i class="fa fa-list-ul" aria-hidden="true"></i> Lista Professor</a></li>
                        <li><a href="SalaServlet?logica=listaSala"><i class="fa fa-list-ul" aria-hidden="true"></i> Lista Sala</a></li>
                        <li><a href="EquipServlet?logica=listaEquipamento"><i class="fa fa-list-ul" aria-hidden="true"></i> Lista Equipamentos</a></li>
                    </ul>
                </nav>
            </div>
        </div>
        <br/>
    </body>
</html>
