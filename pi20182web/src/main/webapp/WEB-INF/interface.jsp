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
        <title>Interface</title>
        <link rel="stylesheet" type="text/css" media="screen" href="css/rotas.css" />
        <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.3.min.js"></script>
    </head>
    <body>

        <article id="wrapper">
            <section id="main">
                <nav id="nav">
                    <a href="#" class="toggle-nav btn-close">x</a>
                    <h2>Configurar Interface</h2>
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
                                <div id="div_menu_superior"><img id="demo_icon" src="css/icones/technical-support.png" alt="Configuração de Interface" /><p><b>Configuração de Interface</b></p></div>
                                <section><!--
                                    <nav id="menu_rotas_content">
                                        <ul>
                                            <a href="index.jsp">
                                                <li>
                                                   <p><b>Home</b></p>
                                                </li>
                                            </a>
                                        </ul>
                                    </nav>-->
                                </section>
                            </section>
                    </section><!--Menu_superior-->
                    <section id="corpo">
                        <form action="servletInterface?acao=addInterface" method="post">
                            <label class="inputCaixa"><p>NOME DA INTERFACE:</p>
                                <input type="text" name="nomeInterface" maxlength="20" autofocus required>
                            </label>
                            <label class="inputCaixa"><p>IP:</p>
                                <input type="text" name="ip" pattern="[.0-9]+" maxlength="15" required>
                            </label>
                            <label class="inputCaixa"><p>MÂSCARA:</p>
                                <input type="text" name="mascara" pattern="[.0-9]+" maxlength="15" required>
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
                                        <th>Nome interface</th>
                                        <th>Ip</th>
                                        <th>Mâscara</th>
                                        <th>Ações</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${interfaces}" var="int">
                                    <tr>
                                        <th>${int.id}</th>
                                        <th>${int.nome}</th>
                                        <th>${int.ip}</th>
                                        <th>${int.mascara}</th>
                                        <th>
                                            <a href="servletInterface?acao=delInterface&idInterface=${int.id}" onclick="return window.confirm('Deseja excluir o registro ${int.id} ?')">
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


