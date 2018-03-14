<%-- 
    Document   : CreationEmployeMagasin
    Created on : 12 mars 2018, 16:51:30
    Author     : i.silvestre
--%>

<%@page import="EntityBean.Categorie"%>
<%@page import="java.util.List"%>
<%@page import="EntityBean.Employe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
         <jsp:useBean id ="employeCo" scope="session" class="Employe"></jsp:useBean>
         <jsp:useBean id="listTitres" scope="request" class="java.util.List"></jsp:useBean>
         <jsp:useBean id="listCategorie" scope="request" class="java.util.List"></jsp:useBean>
        <title>Creation EmployeMagasin</title>
    </head>
    <body>
        <div class="form-group">
    <label for="role">Séléctionner un type d'employé</label>
    <select multiple class="form-control" id="role">
        <% List<String> lesRoles = listTitres;
        for(String r : lesRoles){%>
      <option><%=r %></option>
      <%}%>
    </select>
  </div>
        <label for="nom">Nom <span class="requis">*</span></label>
        <input type="text" name="nom" class="form-control" placeholder="Saisir nom" />
        <br />
        <label for="prenom">Prénom <span class="requis">*</span></label>
        <input type="text" name="prenom" class="form-control" placeholder="Saisir Prénom" />
        <br />
         <label for="adresse">Adresse <span class="requis">*</span></label>
        <input type="text" name="adresse" class="form-control" placeholder="Saisir Adresse" />
        <br />
         <br />
         <label for="telephone">Téléphone <span class="requis">*</span></label>
        <input type="text" name="telephone" class="form-control" placeholder="Saisir Telephone" />
        <br />
         <label for="email">Email <span class="requis">*</span></label>
        <input type="text" name="email" class="form-control" placeholder="Saisir Email" />
        <br />
        <div class="form-group">
    <label for="role">Séléctionner une ou plusieurs catégories :</label>
    
    <div class="form-check">
        <% List<Categorie> lesCategories = listCategorie;
        for( Categorie r : lesCategories){%>
  <input class="form-check-input" type="checkbox" id="categorie">
  <label class="form-check-label" for="defaultCheck1"><%=r.getLibelle() %></label>
    </div>
  </div>
        
    </body>
</html>
