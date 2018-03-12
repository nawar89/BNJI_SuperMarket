<%-- 
    Document   : PageConnexion
    Created on : 12 mars 2018, 13:53:10
    Author     : i.silvestre
--%>

<%@page import="EntityBean.Employe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script   type="text/javascript"   src="JSP_Pages/MesJavascript.js"> </script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page de connexion</title>
    </head>
    <body>
         <form name="connexion" onsubmit="" method="post">
             <div class="form-group"> 
            <fieldset>
            <legend>Nouveau Direction national</legend>
            <label for="login"> Login<span class="requis">*</span></label>
            <input type="text" name="login" class="form-control" placeholder="Saisir login" />
            <br />
            <label for="mdp">Mot de passe <span class="requis">*</span></label>
            <input type="password" name="mdp" class="form-control" placeholder="Saisir mot de passe" />
            <br />
             </fieldset>
                 
            <input type="hidden" name="action" value="doActionConnexion">
            <input type="submit"  class="btn btn-primary" value="Se connecter" />
            <input type="reset"   class="btn btn-primary"  value="Remettre à zéro" /> <br/>
            </div>
        </form>
    </body>
</html>
