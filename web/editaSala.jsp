
<%@page import="java.util.List"%>
<%@page import="model.classes.Sala"%>
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

        <title>Alterar Sala</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div class="backFundo"> 
            <div class="parallax-overlay">
                <!--AQUI ENTRARÁ O HEADER-->
                <%@include file="header.jsp" %>
                <!-- <h3>Cadastrar salas</h3>-->

                <%
                    List<Sala> salas = (List<Sala>) request.getAttribute("editar");
                    int id = (int) request.getAttribute("id");
                    for (Sala sala : salas) {
                        if (sala.getIdSala() == id) {
                %>


                <form id="formsCadastros" class="panel panel-info" method="POST" action="SalaServlet?logica=alteraSala">
                    <div  class="panel-heading"><i class="fa fa-check-square-o" aria-hidden="true"></i>&nbsp;Alterar Sala</div>
                    <div id="camposForm">
                        <input type="text" name="id" value="<%= sala.getIdSala()%>" style="display:none"/>
                        Nome:<br> <input class="form-control" name="nome" value="<%= sala.getNome()%>" placeholder="Nome da Sala" type="text"  required=""/><br/>
                        Localização:<br> <input class="form-control" name="localizacao" value="<%= sala.getLocalizacao()%>" placeholder="Localizacao" type="tex" required=""/><br/>
                        Capacidade:<br><input class="form-control" name="capacidade" value="<%= sala.getCapacidade()%>" placeholder="Capacidade da sala" type="text" required="" pattern="[0-9]+$"/><br/>
                        Tipo<br><input class="form-control" name="tipo" value="<%= sala.getTipo()%>" placeholder="Tipo" type="text" required=""/><br/>
                        <button type="submit" class="btn btn-primary" value="alterar">Alterar</button><br/>
                    </div>
                </form>
            </div> 
        </div> 
        <%}
        }%>
    </body>
</html>
