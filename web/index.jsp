<%-- 
    Document   : Index
    Created on : 19/10/2016, 13:13:22
    Author     : Mucio / Givanildo / Sandeison
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <link rel="icon" href="http://www.ifpe.edu.br/++theme++copia-tema-verde-portal-padrao/img/favicon.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!--link para a font-awesome-->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery.js" type="text/javascript"></script>

        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>

        <title>SysReserva</title>
    </head>
    <body>
        <div class="backFundo">
            <div class="parallax-overlay">
                <!-- <h3>Acessar Sistema de Reservas</h3>-->
                <form id="formAcesso" class="panel panel-info" method="POST" action="ProfServlet?logica=logaProf">
                    <div  class="panel-heading"><i class="fa fa-check-square-o" aria-hidden="true"></i>&nbsp;Acesse para Reservas</div>
                    <p style="text-align: center; color: red;"> ${msgl} </p>
                    <div id="camposForm"><br/>
                        <input class="form-control" name="siape" placeholder="Digite seu Número SIAPE" type="text" pattern="[0-9]+$" required="required"/><br/>
                        <input class="form-control" name="nome" placeholder="Nome do Professor" type="tex" required="required"/><br/>
                        <input class="form-control" name="senha" placeholder="Senha" type="password" required="required" value=""/><br/>
                        <button type="submit" class="btn btn-primary">Acessar</button>
                    </div>
                </form>
                    <%@include file="rodape.jsp" %>
            </div>
        </div>
    </body>
</html>
