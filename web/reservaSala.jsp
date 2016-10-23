
<%@page import="model.classes.Equipamento"%>
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

        <title>Reservar Sala</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div class="backFundo">
            <div class="parallax-overlay">
                <!--AQUI ENTRARÁ O HEADER-->
                <%@include file="header.jsp" %>
                <!-- <h3>Cadastrar salas</h3>-->
                <form id="formsCadastros" class="panel panel-info" method="POST" action="SalaServlet?logica=adicionaSala">
                    <div  class="panel-heading"><i class="fa fa-check-square-o" aria-hidden="true"></i>&nbsp;Reservar Sala</div>
                    <div id="camposForm">
                        <p>${msg}</p>
                        <input class="form-control" name="data" placeholder="data que quer a reserva" type="date"  required=""/><br/>
                        <input class="form-control" name="hora" placeholder="hora que quer a reserva" type="datetime" required=""/><br/>
                        <select name="duracao" class="form-control" >
                            <option values="30">30 minutos</option>
                            <option values="60">Uma hora</option>
                            <option values="90">Uma hora e meia</option>
                            <option values="120">duas horas</option>
                        </select><br>

                        <input class="form-control" name="siape" placeholder="digite seu siape" type="text" required="" pattern="[0-9]+$"/><br/>

                        <select name="sala" class="form-control" >
                            <% List<Sala> sala = (List<Sala>) request.getAttribute("salas");
                                for (Sala salas : sala) {
                            %>
                            <option values="<%=salas.getIdSala()%>"><%=salas.getNome()%></option> 
                            <%}%>
                        </select><br>



                        <select name="equip" class="form-control" >
                            <% List<Equipamento> equip = (List<Equipamento>) request.getAttribute("equips");
                                for (Equipamento equips : equip) {
                            %>
                            <option values="<%=equips.getIdEquipamento()%>"><%=equips.getNomeEquipamento()%></option>  
                            <%}%>
                        </select><br>
                        <button type="submit" class="btn btn-primary" value="gravar">Reservar</button><br/>
                    </div>
                </form>
                          <%@include file="rodape.jsp" %>
            </div> 
                        
        </div> 
                      
    </body>
</html>
