<%-- 
    Document   : MenuAgentLivraison
    Created on : 16 mars 2018, 09:57:01
    Author     : Nawar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="message" scope="request" class="String"></jsp:useBean>
        <jsp:useBean id ="employeCo" scope="session" class="EntityBean.Employe"></jsp:useBean>
        <title>Menu Agent Livraison</title>
    </head>
    <body>
        <h1><%=message %></h1>
        <a class="btn btn-lg btn-primary btn-block" href="ControleAdministration?action=GoToConsulterLvraison" role="button">Conulter Livraison</a>
      
    </body>
</html>
