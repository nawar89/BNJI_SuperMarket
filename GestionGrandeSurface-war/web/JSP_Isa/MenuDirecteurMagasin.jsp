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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id ="employeCo" scope="session" class="Employe"></jsp:useBean>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bonjour <%= employeCo.getPrenom() %> <%= employeCo.getNom() %></h1>
    </body>
</html>
