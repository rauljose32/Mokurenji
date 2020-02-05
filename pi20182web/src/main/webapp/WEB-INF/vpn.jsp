<%-- 
    Document   : vpn
    Created on : 29/12/2018, 20:23:25
    Author     : mathe
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <head>
        <meta charset="utf-8">
        <title>VPN</title>
        <link rel="stylesheet" type="text/css" media="screen" href="./design/estilo.css" />
        <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.3.min.js"></script>
        </head>
        <body>

        <article id="wrapper">
            <section id="main">
            <nav id="nav">
                <a href="#" class="toggle-nav btn-close">x</a>
                <h2>Configurar VPN</h2>
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
                            <div id="div_menu_superior"><img id="demo_icon" src="css/icones/tunnel.png" alt="Configuração de VPN" /><p><b>Configuração de VPN</b></p></div>
                            <section>
                            <nav id="menu_rotas_content">
                                <ul>
                                    <a href="index.jsp"><li>
                                                <p><b>Home</b></p>
                                     </li></a>
                                </ul>
                            </nav>
                            </section>
                        </section>
                </section><!--Menu_superior-->
                <section id="corpo">
                    <form id="form_vpn" action="ServletVPN?acao=addVPN" method="post">
                        <label class="inputCaixa"><p>IP PONTA A:</p>
                                <input type="text" pattern="[.0-9]+" maxlenght="15" required name="ippontaa">
                        </label><br>
                        <label class="inputCaixa"><p>IP PONTA B:</p>
                                <input type="text" pattern="[.0-9]+" maxlenght="15" required name="ippontab">
                        </label><br>
                        <label class="inputCaixa"><p>IP REAL:</p>
                                <input type="text" pattern="[.0-9]+"  maxlenght="15"required name="ipreal">
                        </label><br>
                        <label class="inputCaixa"><p>PORTA:</p>
                                <input type="text" pattern="[0-9]+" maxlenght="4" required name="portadotunel">
                        </label><br>
                        </table>
                        <div id="input">
                        <input type="submit" value="ADD">
                        <a id="del" href="ServletVPN?acao=delVPN"><input type="button" value="DEL"></a>
                        </div>
                    </form>
                    <section class="backTable">
                                <!-- RESPONSIVE TABLE -->
                                               <!-- RESPONSIVE TABLE -->
                            <table class="table table-responsive">
                                <thead> 
                                    <tr>
                                        <th>#</th>
                                        <th>IP Ponta A</th>
                                        <th>IP Ponta B</th>
                                        <th>IP Tunel</th>
                                        <th>Porta Tunel</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${vpns}" var="vpn">
                                        <tr>
                                            <th>${vpn.id}</th>
                                            <th>${vpn.ipPontaA}</th>
                                            <th>${vpn.ipPontaB}</th>
                                            <th>${vpn.ipTunel}</th>
                                            <th>${vpn.porta}</th>
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

            $(function(){

            $('.toggle-nav').click(function (e) {
                e.stopPropagation();
                toggleNav();
            });
            $('#del').click(function(){
               return window.confirm("Deseja deletar todos os túneis?"); 
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
        </body>
</html>
