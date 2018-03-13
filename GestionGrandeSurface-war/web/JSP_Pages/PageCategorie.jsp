<%-- 
    Document   : PageCategorie
    Created on : 9 mars 2018, 15:04:23
    Author     : Nawar
--%>

<%@page import="EntityBean.SousCategorie"%>
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
         <jsp:useBean id="message" scope="request" class="String"></jsp:useBean>
        <title>Catégorie</title>
        <style type="text/css">
            .highlight { background-color: red; }
            
        </style>
    </head>
    <body>
         <h1><%=message %></h1>
        <form name="CategorieForm" onsubmit="return validerCreationCategory()" method="post" action="ControleAdministration">
         <div class="form-group"> 
        <fieldset>
        <legend> Categorie</legend>
            <label for="nom" >Categorie <span class="requis" >*</span></label>
            <select id = "catsel" name="CategorieSelect" onchange="RefreshComboBox(this,document.getElementById('souscatsel'),document.getElementById('souscatseltemp'))">
            <% List<Categorie> listeCat = categories ;
            for(Categorie cat : listeCat) {%>
                 <option value ="<%=cat.getId()%>"> <%=cat.getLibelle() %>  </option>
            <% }%>
             </select>
             <br />
             <label for="nom" >Sous Categorie <span class="requis" >*</span></label>
              <select id = "souscatsel" name="SousCategorieSelect">
           
            <% if (!listeCat.isEmpty())  {
                Categorie cat = listeCat.get(0);
                for(SousCategorie s : cat.getSousCategories() ) {%>
                <option class="filterOption" value ="<%= cat.getId()%>"> <%=s.getLibelle() %>  </option>
                <% }}%>
                
             </select>
        
          <select id = "souscatseltemp" style="display: none" >
           
            <% if (!listeCat.isEmpty())  {
                for (Categorie cat : listeCat){
                for(SousCategorie s : cat.getSousCategories() ) {%>
                <option class="filterOption" value ="<%= cat.getId()%>"> <%=s.getLibelle() %>  </option>
                <% }}}%>
                
         </select>
                
          
        <br /> 
        <input type="text" id = "catnom" name="Categorienom"  onkeyup="LectureSeulCategorie('catsel',this); LectureSeulCategorie('souscatsel',this);" class="form-control" placeholder="Saisir nom Categorie" />
        <br />
        
        <input type="text" id = "souscatnom" name="souscatnom"   class="form-control" placeholder="Saisir nom Sous Categorie" />
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
