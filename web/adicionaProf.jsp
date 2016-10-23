
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
        <script src="index/ie-emulation-modes-warning.js.download"></script>
        <script src="/admin2.js"></script>

        <title>Cadastro de Professor</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div class="backFundo">
            <div class="parallax-overlay">
                <!--AQUI ENTRARÁ O HEADER-->
                <%@include file="header.jsp" %>
                <!-- <h3>Cadastrar salas</h3>-->
                <form id="formsCadastros" class="panel panel-info" method="POST" action="ProfServlet?logica=adicionaProf">
                    <div  class="panel-heading"><i class="fa fa-check-square-o" aria-hidden="true"></i>&nbsp;Cadastro de Professor</div>
                    <div id="camposForm">
                        <p>${msg}</p>
                        <input class="form-control" name="siape" placeholder="SIAPE do Professor(a)" type="text"  required="" pattern="[0-9]+$"/><br/>
                        <input class="form-control" name="nome" placeholder="Nome do Professor(a)" type="tex" required=""/><br/>
                        <input class="form-control" name="senha" placeholder="senha" type="password" required="" /><br/>
                        <input class="form-control" name="senha" placeholder="senha2" type="password" required=""/><br/>
                        <button type="submit" class="btn btn-primary" value="gravar">Gravar</button><br/>
                    </div>
                </form>
            </div> 
        </div> 
    </body>
</html>
