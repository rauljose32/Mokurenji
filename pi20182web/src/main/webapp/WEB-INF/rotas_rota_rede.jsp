<%-- 
    Document   : rotas_rota_default.jsp
    Created on : 04/02/2019, 20:47:53
    Author     : thanyla
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Rota Rede</title>
        <link rel="stylesheet" type="text/css" media="screen" href="css/rotas.css" />
        <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.3.min.js"></script>
    </head>
    <body>

        <article id="wrapper">
            <section id="main">
                <nav id="nav">
                    <a href="#" class="toggle-nav btn-close">x</a>
                    <h2>Configurar Rotas</h2>
                    <nav id="menu_rotas">
                        <ul>
                            <li>
                                <a href="index.jsp"><p><b>Home</b></p></a>
                            </li>
                            <li>
                                <a href="servletRota?acao=rotaDefault"><p><b>Rota default</b></p></a>
                            </li>
                            <li>
                                <a href="servletRota?acao=rotaHost"><p><b>Rota de host</b></p></a>
                            </li>
                            <li>
                                <a href="servletRota?acao=rotaRede"><p><b>Rota de rede</b></p></a>
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
                                <div id="div_menu_superior"><img id="demo_icon" src="css/icones/destination.png" alt="Configuração de Rota" /><p><b>Configuração de Rota</b></p></div>
                                <section>
                                    <nav id="menu_rotas_content">
                                        <ul>
                                            <a href="servletRota?acao=rotaDefault">
                                                <li>
                                                    <p><b>Rota default</b></p>
                                                </li>
                                            </a>
                                            <a href="servletRota?acao=rotaHost">
                                                <li>
                                                    <p><b>Rota host</b></p>
                                                </li>
                                            </a>
                                            <a class="active" href="servletRota?acao=rotaRede">
                                                <li>
                                                    <p><b>Rota rede</b></p>
                                                </li>
                                            </a>
                                        </ul>
                                    </nav>
                                </section>
                            </section>
                    </section><!--Menu_superior-->
                    <section id="corpo">
                        <form action="servletRota?acao=addRotaRede" method="post">
                            <label class="inputCaixa"><p>IP REDE DESTINO:</p>
                                <input type="text" name="ipRede" pattern="[.0-9]+" maxlength="15" autofocus required>
                            </label>
                            <br>
                            <label class="inputCaixa"><p>IP MÂSCARA:</p>
                                <input type="text" name="ipMascara" pattern="[.0-9]+" maxlength="15" required>
                            </label>
                            <br>
                            <label class="inputCaixa"><p>IP GATEWAY:</p>
                                <input type="text" name="ipGateway" pattern="[.0-9]+" maxlength="15" required>
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
                                        <th>IP Rede</th>
                                        <th>MÂSCARA</th>
                                        <th>IP Gateway</th>
                                        <th>Ações</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${rotasRede}" var="rede">
                                    <tr>
                                        <th>${rede.id}</th>
                                        <th>${rede.redeDestino}</th>
                                        <th>${rede.mascara}</th>
                                        <th>${rede.gateway}</th>
                                        <th>
                                            <a href="servletRota?acao=delRotaRede&idrotaRede=${rede.id}" onclick="return window.confirm('Deseja excluir o registro ${rede.id} ?')">
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


