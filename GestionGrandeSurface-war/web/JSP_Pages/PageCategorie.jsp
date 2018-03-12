<%-- 
    Document   : PageCategorie
    Created on : 9 mars 2018, 15:04:23
    Author     : Nawar
--%>

<%@page import="EntityBean.Categorie"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <script   type="text/javascript"   src="JSP_Pages/MesJavascript.js"> </script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <jsp:useBean id="categories" scope="request" class="java.util.List"></jsp:useBean>
        <title>Catégorie</title>
        <style type="text/css">
            .highlight { background-color: red; }
            
        </style>
    </head>
    <body>
        <form name="CategorieForm" onsubmit="return validerCreationCategory()" method="post" action="ControleAdministration">
         <div class="form-group"> 
        <fieldset>
        <legend> Categorie</legend>
            <label for="nom" >Nom <span class="requis" >*</span></label>
            <select id = "catsel" name="CategorieSelect">
            <% List<Categorie> listeCat = categories ;
            for(Categorie cat : listeCat) {%>
                 <option value ="<%=cat.getId()%>"> <%=cat.getLibelle() %>  </option>
            <% }%>
             </select>
             
          <button type="button" onclick="modifierAffichageCategorie('nom')" style="display: none">Ajouter</button>
         
        <input type="text" id = "catnom" name="nom"  onkeyup="LectureSeulCategorie('catsel')" class="form-control" placeholder="Saisir nom Categorie" />
        <br />
        </fieldset>

            </div>
            <input type="hidden" name="category" class="form-control" />
            <input type="hidden" name="action" value="FromCategorie">
           <input type="submit"  class="btn btn-primary" value="Valider" />
        <input type="reset"   class="btn btn-primary"  value="Remettre à zéro" /> <br />
        </form>
           
          
    </body>
</html>
