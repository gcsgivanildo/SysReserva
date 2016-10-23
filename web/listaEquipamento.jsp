<%-- 
    Document   : Index
    Created on : 19/10/2016, 13:13:22
    Author     : Mucio / Givanildo / Sandeison
--%>

<%@page import="java.util.List"%>
<%@page import="model.classes.Equipamento"%>
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

        <title>Lista de Equipamentos</title>
    </head>
    <body>
        <div class="backFundo">
            <div class="parallax-overlay">
                <!-- header-->
                <%@include file="header.jsp" %>
                <div id="paineis">
                    <div class="panel panel-success">
                        <!-- Default panel contents -->
                        <div class="panel-heading"><i class="fa fa-list-ul" aria-hidden="true"></i>&nbsp;Lista de Equipamentos</div>
                        <div class="panel-body">
                            <!--Table-->
                            <table class="table" >
                                <tr>
                                    <th>IdEquipamento</th>
                                    <th>Nome Equipamento</th>
                                    <th>Marca</th>
                                    <th>Tipo</th>
                                    <th>Utilidade</th>
                                    <th>Status</th>
                                </tr>

                                <%
                                    List<Equipamento> equip = (List<Equipamento>) request.getAttribute("equips");
                                    for (Equipamento equips : equip) {

                                %> 

                                <tr>
                                    <td><%=equips.getIdEquipamento()%></td>
                                    <td><%=equips.getNomeEquipamento()%></td>
                                    <td><%=equips.getMarca()%></td>
                                    <td><%=equips.getTipo()%></td>
                                    <td><%=equips.getUtilidade()%></td>
                                    <td><a href="EquipServlet?logica=idAlteraEquipamento&id=<%=equips.getIdEquipamento()%>">Editar</a> || 
                                        <a href="EquipServlet?logica=removeEquipamento&id=<%=equips.getIdEquipamento()%>">Remover</a></td>

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
