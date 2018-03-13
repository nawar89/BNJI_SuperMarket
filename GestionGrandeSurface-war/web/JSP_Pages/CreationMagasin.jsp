<%-- 
    Document   : DirectionNational
    Created on : 8 mars 2018, 13:55:41
    Author     : Nawar
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="EntityBean.Employe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         
        <script   type="text/javascript"   src="JSP_Pages/MesJavascript.js"> </script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <jsp:useBean id="employes" scope="request" class="java.util.List"></jsp:useBean>
        <title>Creation Magasin</title>
    </head>
    <body>
        <form name="MagasinForm" onsubmit="return validerCreationMagasin()" method="post" action="ControleAdministration">
         <div class="form-group"> 
        <fieldset>
        <legend>Nouveau Magasin</legend>
        
       
        
        <label for="nom">Nom <span class="requis">*</span></label>
        <input type="text" name="nom" class="form-control" placeholder="Saisir nom" />
        <br />
        <label for="prenom">ville <span class="requis">*</span></label>
        <input type="text" name="ville" class="form-control" placeholder="Saisir Prénom" />
        
        <br />
         <label for="adresse">Adresse <span class="requis">*</span></label>
        <input type="text" name="adresse" class="form-control" placeholder="Saisir Adresse" />
        
        <br />
        
         <br />
         <label for="telephone">code Postal <span class="requis">*</span></label>
        <input type="text" name="code" class="form-control" placeholder="Saisir Telephone" />
        
        <br />

         <label for="email">Email <span class="requis">*</span></label>
        <input type="text" name="email" class="form-control" placeholder="Saisir Email" />
        
        <br />

        </fieldset>
         
        
            </div>
            <input type="hidden" name="magasin" class="form-control" />
            <input type="hidden" name="action" value="FromMagasin">
           <input type="submit"  class="btn btn-primary" value="Valider" />
        <input type="reset"   class="btn btn-primary"  value="Remettre à zéro" /> <br />
        </form>
    </body>
</html>
