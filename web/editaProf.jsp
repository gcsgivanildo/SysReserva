
<%@page import="model.classes.Professor"%>
<%@page import="java.util.List"%>
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

        <title>Alterar Professor(a)</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div class="backFundo">
            <div class="parallax-overlay">
                <!--AQUI ENTRARÁ O HEADER-->
                <%@include file="header.jsp" %>
                <!-- <h3>Cadastrar salas</h3>-->

                <%
                    List<Professor> profs = (List<Professor>) request.getAttribute("profs");
                    int id = (int) request.getAttribute("id");
                    for (Professor prof : profs) {
                        if (prof.getSiape() == id) {
                %>


                <form id="formsCadastros" class="panel panel-info" method="POST" action="ProfServlet?logica=alteraProf">
                    <div  class="panel-heading"><i class="fa fa-check-square-o" aria-hidden="true"></i>&nbsp;Cadastro de Sala</div>
                    <div id="camposForm">
                        <input type="text" name="id" value="<%= prof.getSiape()%>" style="display:none"/>
                        Nome:<br> <input class="form-control" name="nome" value="<%= prof.getNome()%>" placeholder="Nome da Sala" type="text"  required=""/><br/>
                        Senha<br> <input class="form-control" name="senha" value="<%= prof.getSenha()%>" placeholder="Localizacao" type="tex" required=""/><br/>
                        Senha<br><input class="form-control" name="senha"  placeholder="Repita a senha" type="text" required="" /><br/>
                        <button type="submit" class="btn btn-primary" value="alterar">Alterar</button><br/>
                    </div>
                </form>
            </div> 
        </div> 
        <%}
        }%>
    </body>
</html>
