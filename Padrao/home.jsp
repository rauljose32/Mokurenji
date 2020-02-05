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
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="./design1/estilo.css" />
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
        <h1>INTERAPOLO</h1>
        
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
        <p>Interapolo é um projeto integrador desenvolvido por acadêmicos do curso de Sistemas para Internet <br> no ano de 2018</p>
    </section>
    <section id="opcoes">
        <a  href="Servlet?acao=rota"><div id="rota"><img src="img/icons/destination.png" alt="Configuração de rotas." /><p><b>Configuração de Rotas</b></p></div></a>
        <a  href="Servlet?acao=nat"><div id="nat"><img src="img/icons/stamp.png" alt="Configuração de nat." /><p><b>Configuração de NAT</b></p></div></a>
        <a  href="Servlet?acao=vpn"><div id="vpn"><img src="img/icons/tunnel.png" alt="Configuração de vpn" /><p><b>Configuração de VPN</b></p></div></a>
        <a  href="Servlet?acao=ap"><div id="ap"><img src="img/icons/connection.png" alt="Configuração de ap" /><p><b>Configuração de AP</b></p></div></a>
        <a  href="Servlet?acao=interface"><div id="interface"><img src="img/icons/technical-support.png" alt="Configuração de interface." /><p><b>Configuração de interface<b></p></div></a>
        <a   href="#"><div><img src="img/icons/filter.png" alt="Configuração SQUID." /><p><b>Configuração do SQUID<b></b></p></div></a>
    </section>
</body>
</html>