<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Developers</title>
        <jsp:include page="./estrutura/head.jsp" flush="true" />
        <script src="./autocomplete/jquery-1.12.4.js"></script>
        <script src="./autocomplete/jquery-ui.js"></script>     

        <script type="text/javascript">
            function deletar(id) {
                $.ajax({
                    dataType: 'json',
                    url: './RemoverDeveloper',
                    type: 'POST',
                    data: {
                        idDeveloper: id
                    },
                    success: function (data) {
                        pesquisar();
                    },
                    error: function () {
                        pesquisar();
                    }
                });
            }
            ;


            $(function () {
                $.ajax({
                    dataType: 'json',
                    url: './ListarDevelopersApi',
                    type: 'POST',
                    data: {
                        paginaAtual: 0
                    },
                    success: function (data) {
                        var corpo = "";
                        console.log(data[0]);
                        for (var i = 0, length = data[0].content.length; i < length; i++) {

                            var item = data[0].content[i];
                            corpo += "<tr><td>" + item.id + "</td>" + "<td>" + item.nome + "</td>" + "<td>" + item.sexo + "</td>" + "<td>" + item.idade + "</td><td>" + item.hobby + "</td><td>" + item.dataNascimento + "</td><td ><a href='./editar.jsp?idDeveloper=" + item.id + "' style='margin-right: 1%' class='btn btn-info tip-bottom' data-original-title='Editar'><i class='icon-pencil icon-white'></i></a>   <a onClick='deletar(" + item.id + ")' type='hidden'><div class='btn btn-danger '><i class='icon-white icon-trash'></i></div></a> </td>  </tr>";
                        }
                        corpo += "";
                        var linha = document.getElementById("developers");
                        $('#situacao').val(data[0].situacao);
                        $('#dataInicial').val(data[0].dataInicial);
                        $('#dataFinal').val(data[0].dataFinal);
                        $('#paginaAtual').val(data[0].paginaAtual);
                        $('#anterior').val(data[0].anterior);
                        $('#proxima').val(data[0].proxima);
                        $('#totalElements').val(data[0].totalElements);

                        linha.innerHTML = corpo;
                    },
                    error: function () {
                        alert("Verifique a tributação do item...");
                    }

                });
            })
                    ;


            function pesquisar() {
                $.ajax({
                    dataType: 'json',
                    url: './ListarDevelopersApi',
                    type: 'POST',
                    data: {
                        descricao: $('#descricao').val(),
                        paginaAtual: 0
                    },
                    success: function (data) {
                        var corpo = "";
                        console.log(data[0].content);
                        for (var i = 0, length = data[0].content.length; i < length; i++) {

                            var item = data[0].content[i];
                            corpo += "<tr><td>" + item.id + "</td>" + "<td>" + item.nome + "</td>" + "<td>" + item.sexo + "</td>" + "<td>" + item.idade + "</td><td>" + item.hobby + "</td><td>" + item.dataNascimento + "</td><td ><a href='./editar.jsp?idDeveloper=" + item.id + "' style='margin-right: 1%' class='btn btn-info tip-bottom' data-original-title='Editar'><i class='icon-pencil icon-white'></i></a>   <a onClick='deletar(" + item.id + ")' type='hidden'><div class='btn btn-danger '><i class='icon-white icon-trash'></i></div></a> </td>  </tr>";
                        }
                        corpo += "";
                        var linha = document.getElementById("developers");
                        $('#descricao').val(data[0].descricao);
                        $('#paginaAtual').val(data[0].paginaAtual);
                        $('#anterior').val(data[0].anterior);
                        $('#proxima').val(data[0].proxima);
                        $('#totalElements').val(data[0].totalElements);
                        linha.innerHTML = corpo;
                    }
                });
            }
            ;
            function pesquisarProxima() {
                $.ajax({
                    dataType: 'json',
                    url: './ListarDevelopersApi',
                    type: 'POST',
                    data: {
                        descricao: $('#descricao').val(),
                        paginaAtual: $('#proxima').val()
                    },
                    success: function (data) {
                        var corpo = "";
                        console.log(data[0].content);
                        for (var i = 0, length = data[0].content.length; i < length; i++) {

                            var item = data[0].content[i];
                            corpo += "<tr><td>" + item.id + "</td>" + "<td>" + item.nome + "</td>" + "<td>" + item.sexo + "</td>" + "<td>" + item.idade + "</td><td>" + item.hobby + "</td><td>" + item.dataNascimento + "</td><td ><a href='./editar.jsp?idDeveloper=" + item.id + "' style='margin-right: 1%' class='btn btn-info tip-bottom' data-original-title='Editar'><i class='icon-pencil icon-white'></i></a>   <a onClick='deletar(" + item.id + ")' type='hidden'><div class='btn btn-danger '><i class='icon-white icon-trash'></i></div></a> </td>  </tr>";
                        }
                        corpo += "";
                        var linha = document.getElementById("developers");
                        $('#descricao').val(data[0].descricao);
                        $('#paginaAtual').val(data[0].paginaAtual);
                        $('#anterior').val(data[0].anterior);
                        $('#proxima').val(data[0].proxima);
                        $('#totalElements').val(data[0].totalElements);
                        linha.innerHTML = corpo;
                    }
                });
            }
            ;

            function pesquisarAnterior() {
                $.ajax({
                    dataType: 'json',
                    url: './ListarDevelopersApi',
                    type: 'POST',
                    data: {
                        descricao: $('#descricao').val(),
                        paginaAtual: $('#anterior').val()
                    },
                    success: function (data) {
                        var corpo = "";
                        console.log(data[0].content);
                        for (var i = 0, length = data[0].content.length; i < length; i++) {

                            var item = data[0].content[i];
                            corpo += "<tr><td>" + item.id + "</td>" + "<td>" + item.nome + "</td>" + "<td>" + item.sexo + "</td>" + "<td>" + item.idade + "</td><td>" + item.hobby + "</td><td>" + item.dataNascimento + "</td><td ><a href='./editar.jsp?idDeveloper=" + item.id + "' style='margin-right: 1%' class='btn btn-info tip-bottom' data-original-title='Editar'><i class='icon-pencil icon-white'></i></a>   <a onClick='deletar(" + item.id + ")' type='hidden'><div class='btn btn-danger '><i class='icon-white icon-trash'></i></div></a> </td>  </tr>";
                        }
                        corpo += "";
                        var linha = document.getElementById("developers");
                        $('#descricao').val(data[0].descricao);
                        $('#paginaAtual').val(data[0].paginaAtual);
                        $('#anterior').val(data[0].anterior);
                        $('#proxima').val(data[0].proxima);
                        $('#totalElements').val(data[0].totalElements);
                        linha.innerHTML = corpo;
                    }
                });
            }
            ;

        </script>
    </head>
    <body>

        <!--Header-part-->
        <div id="header">
            <h1><a href="#">Developers - Gazin</a></h1>
        </div>
        <!--close-Header-part--> 

        <jsp:include page="./estrutura/menu.jsp" flush="true" />



        <!--Conteudo-->
        <div id="content">
            <div id="content-header">
                <div id="breadcrumb"> <a href="#" title="Dashboard" class="tip-bottom"><i class="icon-home"></i> Dashboard</a> </div>
            </div>
            <div class="container-fluid">
                <div class="row-fluid">
                    <div class="span12">
                        <c:if test="${erroEspecifico == 'erro'}">	
                            <div class="alert alert-danger">
                                <button type="button" class="close" data-dismiss="alert">&times;</button>
                                <span>${mensagem}</span>                            
                                <c:remove var="erroEspecifico"  scope="session"/>
                                <c:remove var="mensagem"  scope="session"/>
                            </div>
                        </c:if> 
                        <c:if test="${acertoEspecifico == 'acerto'}">
                            <div class="alert alert-success">
                                <button type="button" class="close" data-dismiss="alert">&times;</button>
                                <span>${mensagem}</span>
                            </div>
                            <c:remove var="acertoEspecifico"  scope="session"/>
                            <c:remove var="mensagem"  scope="session"/>
                        </c:if> 


                        <div class="widget-box">
                            <div class="widget-title">
                                <span class="icon">
                                    <i class="icon-beer"></i>
                                </span>
                                <h5>Developers</h5>

                            </div>

                            <div class="span12 well" style="padding: 1%; margin-left: 0">


                                <div class="span3"> 
                                    <label for="">.</label>
                                    <a href="./cadastro.jsp" class="btn btn-success"><i class="icon-user icon-white"></i>  Adicionar</a>      

                                </div>
                                <div class="span6">                                        
                                    <label for="">Pesquisar por nome:</label>
                                    <input type="text" class="span12 "  name="descricao" id="descricao" />

                                </div>
                                <div class="span3">
                                    <label for="">.</label>
                                    <button type="submit" class="btn btn-info span12" id="btnAdicionarAgendamento" onclick="pesquisar();"><i class="icon-white icon-search"></i> Pesquisar</button>
                                </div>

                            </div>         

                            <div class="widget-content nopadding">

                                <div class="span12 well" style="padding: 1%; margin-left: 0">

                                    <div class="span12" id="divNotas" style="margin-left: 0">

                                        <table class="table table-bordered" id="tblProdutos">
                                            <thead>
                                                <tr>
                                                    <th>id</th>
                                                    <th>Nome</th>
                                                    <th>Sexo</th>
                                                    <th>Idade</th>
                                                    <th>Hobby</th>
                                                    <th>Data de Nascimento</th>
                                                    <th>Ações</th>
                                                </tr>
                                            </thead>
                                            <tbody id="developers">

                                            </tbody>
                                        </table>                                    
                                        <div class="span12" >
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="pagination alternate">
                                <ul>
                                    <li><a href="#" onclick="pesquisarAnterior()">Anterior</a></li>
                                    <input type="hidden" id="anterior" name="anterior" />
                                    <input type="hidden" id="paginaAtual" name="paginaAtual" />                                    
                                    <input type="hidden" id="proxima" name="proxima" />
                                    <li><a href="#" onclick="pesquisarProxima()">Próxima</a></li>
                                </ul>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!--/Conteudo-->
        <div id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" class="modal fade">
            <div class="modal-dialog modal-md">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 style="color:red;"><span class="glyphicon glyphicon-lock"></span> Observações:</h4>
                    </div>
                    <div class="modal-body">
                        <div class="panel-body">
                            <div name="campo" id="campo">

                            </div>
                            <br><br><br>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="../estrutura/footer.jsp" flush="true" />










