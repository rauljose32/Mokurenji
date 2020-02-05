<%-- 
    Document   : vpn
    Created on : 29/12/2018, 20:23:25
    Author     : mathe
--%>

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
                                    <a href="Servlet?acao=home"><p><b>Home</b></p></a>
                            </li>
                        </ul>
                </nav>
            </nav>
                 <section id="content">
                 <section id="menu_superior_submenu">
                        <a href="Servlet?acao=home"><h1 id="sub_menu">INTERAPOLO</h1><a href="#"></a>
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
                                <div id="div_menu_superior"><img id="demo_icon" src="./img/destination.png" alt="Configuração de Rotas" /><p><b>Configuração de Rotas</b></p></div>
                            <section>
                            <nav id="menu_rotas_content">
                                <ul>
                                    <a href="Servlet?acao=home"><li>
                                                <p><b>Rota Rede</b></p>
                                     </li></a>
                                    <a href="Servlet?acao=home"><li>
                                                <p><b>Rota Host</b></p>
                                     </li></a>
                                    <a href="Servlet?acao=home"><li>
                                                <p><b>Rota Default</b></p>
                                     </li></a>
                                </ul>
                            </nav>
                            </section>
                        </section>
                </section><!--Menu_superior-->
                <section id="corpo">
                    <form>
                        <label class="inputCaixa"><p>IP PONTA A:</p>
                                <input type="text" name="ippontaa" placeholder="">
                        </label><br>
                        <label class="inputCaixa"><p>IP PONTA B:</p>
                                <input type="text" name="ippontab" placeholder="">
                        </label><br>
                        <label class="inputCaixa"><p>IP REAL:</p>
                                <input type="text" name="ipreal" placeholder="">
                        </label><br>
                        <label class="inputCaixa"><p>PORTA:</p>
                                <input type="number" name="portadotunel" placeholder="">
                        </label><br>
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
                                        <th>Exemplo</th>
                                        <th>Ações</th>
                                    </tr>
                                  </thead>
                                  <tbody> 
                                    <tr>
                                        <td>1</td>
                                        <td>Ex1</td>
                                        <td><div class="inputTable">
                                                <a  href=""><img class="imgDel" src="css/icones/deleteTable.png" alt="imgDel" /></a>
                                        </div></td>

                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>Ex2</td>
                                        <td><div class="inputTable">
                                                <a  href=""><img class="imgDel" src="css/icones/deleteTable.png" alt="imgDel" /></a>
                                        </div></td>
                                    </tr>
                                                                        <tr>
                                        <td>3</td>
                                        <td>Ex3</td>
                                        <td><div class="inputTable">
                                                <a  href=""><img class="imgDel" src="css/icones/deleteTable.png" alt="imgDel" /></a>
                                        </div></td>
                                    </tr>
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

