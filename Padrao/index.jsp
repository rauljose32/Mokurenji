<%-- 
    Document   : index
    Created on : 15/12/2018, 12:57:41
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="design/estilo.css" />
    
    
    <script src="bibliotecas/codigo.js"></script>
</head>
<body id="bodyLogin">
    <div class="box">
        <h2>Login</h2>
        <form action="LoginServlet" method="post">
            <div class="inputBox">
                <input type="text" name="usuario" required="">
                <label>Usuario</label>
            </div>
            <div class="inputBox">
                <input type="password" name="senha" required="">
                <label>Senha</label>
            </div>
            <input type="submit" name="" value="Logar">
        </form>
        <p style="color: red"> ${erro} </p>
    </div>
</body>
</html>