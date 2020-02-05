<%-- 
    Document   : apDhcpd
    Created on : 05/02/2019, 17:44:25
    Author     : raul
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Acces Point</title>
        <link rel="stylesheet" type="text/css" media="screen" href="css/rotas.css" />
        <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.3.min.js"></script>
    </head>
    <body>

        <article id="wrapper">
            <section id="main">
                <nav id="nav">
                    <a href="#" class="toggle-nav btn-close">x</a>
                    <h2>Configurar Acess Point</h2>
                    <nav id="menu_rotas">
                        <ul>
                            <li>
                                <a href="index.jsp"><p><b>Home</b></p></a>
                            </li>
                        </ul>
                    </nav>
                </nav>
                <section id="content">
                    <section id="menu_superior_submenu">
                        <a href="index.jsp"><h1 id="sub_menu">Home</h1><a href="#"></a>
                            <!-- <div class="liga-desliga">
                                 <input  type="checkbox" class="liga-desliga_checkbox" id="liga-desliga">
                                 <label for="liga-desliga" class="liga-desliga_botao"> </label>
                                 <section class="sair">
                                     <div id="perfil_user">
                                         <p>${usuario.nome}</p>
                                         <p>${usuario.usuario}<p>
                                     </div>
                                     <div id="container">
                                         <a href="Servlet?acao=sair"><div class="opcoes">Sair</div></a>
                                         <a href="Servlet?acao=mais"><div id="mudar" class="opcoes">Mais</div></a>
                                     </div>
                                 </section>
                             </div>-->
                            <section id="section_div_menu_sup">
                                <section id="menu-icone" class="toggle-nav btn-nav">
                                    <div></div>
                                    <div></div>
                                    <div></div>
                                </section>
                                <div id="div_menu_superior"><img id="demo_icon" src="css/icones/connection.png" alt="Configuração de AP" /><p><b>Configuração de AP</b></p></div>
                                <section>
                                    <nav id="menu_rotas_content">
                                        <ul>
                                            <a href="servletAP?acao=apHostapdInterno">
                                                <li>
                                                    <p><b>HostApd</b></p>
                                                </li>
                                            </a>
                                            <a class="active" href="servletAP?acao=apDhcpdInterno">
                                                <li>
                                                    <p><b>Dhcpd</b></p>
                                                </li>
                                            </a>
                                        </ul>
                                    </nav>
                                </section>
                            </section>
                    </section><!--Menu_superior-->
                    <section id="corpo">
                        <form action="servletAP?acao=addDhcpd" method="post">
                            <label class="inputCaixa"><p>ENDEREÇO SUB REDE:</p>
                                <input type="text" pattern="[.0-9]+" maxlenght="15" name="enderecoRede" autofocus required>
                            </label>
                            <label class="inputCaixa"><p>MÂSCARA DA SUB REDE:</p>
                                <input type="text" pattern="[.0-9]+" maxlenght="15" name="mascaraRede" required>
                            </label>
                            <label class="inputCaixa"><p>RANGE INICIO</p>
                                <input type="text" pattern="[.0-9]+" maxlenght="15" name="rangeInicio" required>
                            </label>
                            <label class="inputCaixa"><p>RANGE FINAL</p>
                                <input type="text" pattern="[.0-9]+" maxlenght="15" name="rangeFinal" required>
                            </label>
                            <label class="inputCaixa"><p>IP GATEWAY</p>
                                <input type="text" pattern="[.0-9]+" maxlenght="15" name="ipGateway" required>
                            </label>
                            <label class="inputCaixa"><p>IP BROADCAST</p>
                                <input type="text" pattern="[.0-9]+" maxlenght="15" name="ipBroadcast" required>
                            </label>
                            <br>
                            <div id="input">
                                <input type="submit" name="adcionar" value="ADD">
                            </div>
                        </form>
                        <section class="backTable">
                            <!-- RESPONSIVE TABLE -->
                            <table class="table table-responsive">
                                <thead> 
                                    <tr>
                                        <th>#</th>
                                        <th>Sub rede</th>
                                        <th>Mâscara sub rede</th>
                                        <th>Range Inicio</th>
                                        <th>Range Final</th>
                                        <th>Ip Gateway</th>
                                        <th>Ip Broadcast</th>
                                        <th>Ações</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${dhcpds}" var="dhcps">
                                        <tr>
                                            <th>${dhcps.id}</th>
                                            <th>${dhcps.enderecoSubrede}</th>
                                            <th>${dhcps.mascaraSubrede}</th>
                                            <th>${dhcps.rangeInicio}</th>
                                            <th>${dhcps.rangeFinal}</th>
                                            <th>${dhcps.gateway}</th>
                                            <th>${dhcps.broadcast}</th>
                                            <th>
                                                <a href="servletAP?acao=delDhcpd&idDhcpd=${dhcps.id}" onclick="return window.confirm('Deseja excluir o registro ${dhcps.id} ?')">
                                                    <img class="imgDel" src="css/icones/deleteTable.png" alt="imgDel" />
                                                </a>
                                            </th>
                                        </tr>
                                    </c:forEach> 
                                </tbody>
                            </table>
                            <!-- END RESPONSIVE TABLE -->
                        </section>
                    </section>
                </section><!--content-->
            </section><!--Main-->
        </article>

        <script>

            $(function () {

                $('.toggle-nav').click(function (e) {
                    e.stopPropagation();
                    toggleNav();
                });

                $('#main').click(function (e) {
                    var target = $(e.target);
                    if (!target.closest('#nav').length && $('#wrapper').hasClass('show-nav'))
                        toggleNav();
                });

                function toggleNav() {

                    if ($('#wrapper').hasClass('show-nav')) {
                        $('#wrapper').removeClass('show-nav');
                    } else {
                        $('#wrapper').addClass('show-nav');
                    }
                }
                $('.liga-desliga_checkbox').click(function () {
                    if ($('.liga-desliga_checkbox').is(':checked')) {
                        $('.sair').css('display', 'block');
                    } else {
                        $('.sair').css('display', 'none');
                    }
                });

            });

        </script>
    </body>
</html>


