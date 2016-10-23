<%-- 
    Document   : Index
    Created on : 19/10/2016, 13:13:22
    Author     : Mucio / Givanildo / Sandeison
--%>

<%@page import="java.util.List"%>
<%@page import="model.classes.Sala"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="http://www.ifpe.edu.br/++theme++copia-tema-verde-portal-padrao/img/favicon.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/justified-nav.css" rel="stylesheet" type="text/css"/>

        <!--link para a font-awesome-->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery.js" type="text/javascript"></script>

        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>

        <title>Lista de Salas</title>
    </head>
    <body>
        <div class="backFundo">
            <div class="parallax-overlay">
                <!-- header-->
                <%@include file="header.jsp" %>
                <div id="paineis">
                    <div class="panel panel-success">
                        <!-- Default panel contents -->
                        <div class="panel-heading"><i class="fa fa-sitemap" aria-hidden="true"></i>&nbsp;Lista de Salas</div>
                        <div class="panel-body">
                            <!--Table-->
                            <table class="table">
                                <tr>
                                    <th>IdSala</th>
                                    <th>Nome</th>
                                    <th>Localiza&ccedil&atildeo</th>
                                    <th>Capacidade</th>
                                    <th>Tipo</th>
                                    <th>Status</th>
                                </tr>
                                <%
                                    List<Sala> sala = (List<Sala>) request.getAttribute("salas");
                                    for (Sala salas : sala) {

                                %> 

                                <tr>
                                    <td><%=salas.getIdSala()%></td>
                                    <td><%=salas.getNome()%></td>
                                    <td><%=salas.getLocalizacao()%></td>
                                    <td><%=salas.getCapacidade()%></td>
                                    <td><%=salas.getTipo()%></td>
                                    <td><a href="SalaServlet?logica=idAlteraSala&id=<%=salas.getIdSala()%>">Editar</a> || <a href="SalaServlet?logica=removeSala&id=<%=salas.getIdSala()%>">Remover</a></td>
                                </tr>
                                <%}%>
                            </table>
                        </div>
                    </div>
                </div>
                            <%@include file="rodape.jsp" %>
            </div>
        </div>
    </body>
</html>
