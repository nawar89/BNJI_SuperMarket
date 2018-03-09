<%-- 
    Document   : Page_Message
    Created on : 9 mars 2018, 09:40:32
    Author     : Nawar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="message" scope="request" class="String"></jsp:useBean>
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%=message %></h1>
    </body>
</html>
