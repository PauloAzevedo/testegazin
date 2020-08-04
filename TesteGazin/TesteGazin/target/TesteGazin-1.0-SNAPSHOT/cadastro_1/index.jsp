

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Lira Sistemas - Cadastro de Agendamento</title>
        <jsp:include page="../estrutura/head.jsp" flush="true" />



        <script src="../assets/js/matrix.js"></script> 
        <script src="../assets/js/bootstrap.min.js"></script> 
        <link rel="stylesheet" href="../autocomplete/jquery-ui.css">
           
    </head>
    <body>

        <!--Header-part-->
        <div id="header">
            <h1><a href="#">Cadastro de Dev</a></h1>
        </div>
        <!--close-Header-part--> 

        <jsp:include page="../estrutura/menu.jsp" flush="true" />



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
                                <span>Salvo com sucesso! ${mensagem}</span>
                            </div>
                            <c:remove var="acertoEspecifico"  scope="session"/>
                            <c:remove var="mensagem"  scope="session"/>
                        </c:if> 


                        <div class="widget-box">
                            <div class="widget-title">
                                <span class="icon">
                                    <i class="icon-beer"></i>
                                </span>
                                <h5>Cadastro de Agendamento</h5>

                            </div>

                            <div class="widget-content nopadding">
                                <form action="../CadastrarDeveloper" id="formCliente"  data-toggle="validator" role="form" method="post" class="form-horizontal">

                                    <div >
                                        <ul class="nav nav-tabs">
                                            <li class="active" id="tabDetalhes"><a href="#tab1" data-toggle="tab">Agendamento</a></li>
                                        </ul>
                                        <div class="tab-content">
                                            <div class="tab-pane active" id="tab1">
                                                
                                                <div class="span12" style="padding: 1%; margin-left: 0">

                                                    <div class="span6">                                        
                                                        <label for="cliente" >Nome<span class="required">*</span></label>

                                                        <input id="nome" type="text" class="span12" name="nome" placeholder="Nome do Dev"/>


                                                    </div>
                                                    
                                                    <div class="span4">                                        
                                                        <label for="">Sexo</label>
                                                        <select name="sexo" id="sexo" class="span12" > 
                                                            <option value="M">Masculino</option>
                                                            <option value="F">Feminino</option>
                                                        </select>                                                            
                                                    </div>
                                                    
                                                     <div class="span4">                                        
                                                        <label for="">Data Nascimento:<span class="required">*</span></label>
                                                        <input id="data_nascimento" type="date" class="span12 datepicker"  name="data_nascimento" value="<%= Util.calendarToStringWeb(Calendar.getInstance())%>"/>
                                                        <div class="help-block with-errors"></div>
                                                    </div>


                                                </div>

                                                <div class="span12 well" style="padding: 1%; margin-left: 0">
                                                    <div class="span12">                                        
                                                        <label for="" >Hobby:</label>
                                                        <textarea id="hobby" type="text" class="span12"  name="hobby" > </textarea>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                        <div class="form-actions">
                                            <div class="span12">
                                                <div class="span6 offset3">
                                                    
                                                        <button type="submit" class="btn btn-success"><i class="icon-user icon-white"></i> Salvar Dados</button>
                                                  
                                                    <a href="../" id="" class="btn"><i class="icon-arrow-left"></i> Voltar</a>
                                                </div>
                                            </div>
                                        </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <!--/Conteudo-->

    <!--Footer-part-->
    <div class="row-fluid">
        <div id="footer" class="span12"> 2018 &copy; Sistema de Emissão de Notas</div>
    </div>
    <!--end-Footer-part-->



    <script src="../js/jquery.validate.js"></script>        
    <script type="text/javascript">
            $(document).ready(function () {
                $('#formCliente').validate({
                    rules: {
                        nome: {required: true},
                        data_nascimento: {required: true},
                        hobby: {required: true}
                    },
                    messages: {
                        nome: {required: 'Campo Requerido.'},
                        data_nascimento: {required: 'Campo Requerido.'},
                        hobby: {required: 'Campo Requerido.'}
                    },

                    errorClass: "help-inline",
                    errorElement: "span",
                    highlight: function (element, errorClass, validClass) {
                        $(element).parents('.control-group').addClass('error');
                    },
                    unhighlight: function (element, errorClass, validClass) {
                        $(element).parents('.control-group').removeClass('error');
                        $(element).parents('.control-group').addClass('success');
                    },

                });
            });
    </script>
    <script type="text/javascript" src="../datepicker/jquery.mask.js"></script>
    <script type="text/javascript">
            $("#telefone").mask("(00) 0000-0000");
            $("#celular").mask("(00) 90000-0000");
            $("#telefone_contato").mask("(00) 0000-0000");
            $("#cpf_contato").mask("000.000.000-00");
            $("#cep").mask("00000-000");
    </script>
    <script src="../datepicker/validador-cpf-cnpj.js"></script>
    <script type="text/javascript">
            // Testando a validação usando jQuery
            $(function () {

                // ## EXEMPLO 3
                // Aciona a validação e formatação ao sair do input
                $('#cpf_cnpj').blur(function () {

                    // O CPF ou CNPJ
                    var cpf_cnpj = $(this).val();

                    // Testa a validação e formata se estiver OK
                    if (formata_cpf_cnpj(cpf_cnpj)) {
                        $(this).val(formata_cpf_cnpj(cpf_cnpj));
                        buscarCliente();
                    } else {
                        alert('CPF ou CNPJ inválido!');
                    }



                });

            });
    </script>    
</body>
</html>










