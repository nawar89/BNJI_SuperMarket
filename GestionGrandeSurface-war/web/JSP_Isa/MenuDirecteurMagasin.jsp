<%-- 
    Document   : MenuDirecteurMagasin
    Created on : 12 mars 2018, 14:33:48
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
        <jsp:useBean id ="employeCo" scope="session" class="Employe"></jsp:useBean>
        <jsp:useBean id="message" scope="request" class="String"></jsp:useBean>

    </head>
    <body>
        <h1><%=message %></h1>
    
        <a class="btn btn-lg btn-primary btn-block" href="DirecteurMagasin?action=loadCreationEmployeMagasin" role="button">Créer un nouvel employé</a>
        <a class="btn btn-lg btn-primary btn-block" href="DirecteurMagasin?action=consulterCommandes" role="button">Consulter commandes</a>
        <a class="btn btn-lg btn-primary btn-block" href="DirecteurMagasin?action=consulterLivraisons" role="button">Consulter livraisons</a>


    </body>
</html>
