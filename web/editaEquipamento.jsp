
<%@page import="model.classes.Equipamento"%>
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

        <title>Cadastro de Sala</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div class="backFundo">
            <div class="parallax-overlay">
                <!--AQUI ENTRARÁ O HEADER-->
                <%@include file="header.jsp" %>
                <!-- <h3>Cadastrar salas</h3>-->

                <%
                    List<Equipamento> equips = (List<Equipamento>) request.getAttribute("equips");
                    int id = (int) request.getAttribute("id");
                    for (Equipamento equip : equips) {
                        if (equip.getIdEquipamento() == id) {
                %>


                <form id="formsCadastros" class="panel panel-info" method="POST" action="EquipServlet?logica=alteraEquipamento">
                    <div  class="panel-heading"><i class="fa fa-check-square-o" aria-hidden="true"></i>&nbsp;Cadastro de Sala</div>
                    <div id="camposForm">
                        <input type="text" name="id" value="<%= equip.getIdEquipamento()%>" style="display:none"/>
                        Nome do Equipamento:<br><input class="form-control" name="nome" value="<%= equip.getNomeEquipamento()%>" placeholder="Nome do Equipamento" type="text"  required=""/><br/>
                        Marca:<br><input class="form-control" name="marca" value="<%= equip.getMarca()%>" placeholder="Marca" type="tex" required=""/><br/>
                        Tipo:<br><input class="form-control" name="tipo" value="<%= equip.getTipo()%>" placeholder="Tipo Equipamento" type="text" required=""/><br/>
                        Uitlidade<br><input class="form-control" name="utilidade" value="<%= equip.getUtilidade()%>" placeholder="Utilidade" type="text" required=""/><br/>
                        <button type="submit" class="btn btn-primary" value="alterar">Alterar</button><br/>

                    </div>
                </form>
                        <%@include file="rodape.jsp" %>
            </div> 
        </div> 
        <%}
        }%>
    </body>
</html>
