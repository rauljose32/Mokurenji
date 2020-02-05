<%-- 
    Document   : index
    Created on : 14/12/2018, 09:19:07
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Mokurenji</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="./design/estilo.css" />
    <script src="./bibliotecas/jquery-3.3.1.min.js"></script>
    <script src="./bibliotecas/codigo.js"></script>
    <script>           
        $(function(){

            $('.toggle-nav').click(function (e) {
                e.stopPropagation();
                toggleNav();
            });

            $('#main').click(function (e){
                var target = $(e.target);
                if(!target.closest('#nav').length && $('#wrapper').hasClass('show-nav')) toggleNav();
            });

            function toggleNav(){

                if($('#wrapper').hasClass('show-nav')){
                $('#wrapper').removeClass('show-nav');   
                }
                else {
                $('#wrapper').addClass('show-nav');
                }
            }

            $('.liga-desliga_checkbox').click(function(){
                if($('.liga-desliga_checkbox').is(':checked')){
                    $('.sair').css('display','block');
                }else{
                   $('.sair').css('display','none');
                }
            });
            });
         

                    </script>
</head>
<body >
    <section id="menu_superior">
        <h1>Mokurenji</h1>
        
        <!--<div class="liga-desliga">
            <input  type="checkbox" class="liga-desliga_checkbox" id="liga-desliga">
            <label for="liga-desliga" class="liga-desliga_botao"> </label>
            <section class="sair">
                <div id="perfil_user">
                    <p>${usuario.nome}</p>
                    <p>${usuario.usuario}<p>
                </div>
                <div id="container">
                    <a href="Servlet?acao=sair"><div class="opcoes"><b>Sair</b></div></a>
                    <a href="Servlet?acao=mais"><div id="mudar" class="opcoes"><b>Mais</b></div></a>
                </div>
            </section>
        </div>-->
        <p>Projeto Mokurenji desenvolvido por acadêmicos do curso de Sistemas para Internet <br> no ano de 2018/2019</p>
    </section>
    <section id="opcoes">
        <a  href="servletInterface?acao=irInterface"><div id="interface"><figure><img src="img/technical-support.png" alt="Configuração de interface." /></figure><p><b>Configuração de interface<b></p></div></a>
        <a  href="servletRota?acao=irRota"><div id="rota"><figure><img src="img/destination.png" alt="Configuração de rotas." /></figure><p><b>Configuração de Rotas</b></p></div></a>
        <a  href="servletNat?acao=irNat"><div id="nat"><figure><img src="img/stamp.png" alt="Configuração de nat." /></figure><p><b>Configuração de NAT</b></p></div></a>
        <a  href="ServletVPN?acao=irVPN"><div id="vpn"><figure><img src="img/tunnel.png" alt="Configuração de vpn" /></figure><p><b>Configuração de VPN</b></p></div></a>
        <a  href="servletAP?acao=irAP"><div id="ap"><figure><img src="img/connection.png" alt="Configuração de ap" /></figure><p><b>Configuração de AP</b></p></div></a>
        <a   href="#"><div><figure><img src="img/filter.png" alt="Configuração SQUID." /></figure><p><b>Configuração do SQUID<b></b></p></div></a>
    </section>
</body>
</html>