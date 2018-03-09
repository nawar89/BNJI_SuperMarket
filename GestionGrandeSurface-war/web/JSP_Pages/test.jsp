<%-- 
    Document   : test
    Created on : 8 mars 2018, 10:03:38
    Author     : Nawar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <script   type="text/javascript"   src="JSP_Pages/MesJavascript.js">

            
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Chercher Article</title>
        <style>
* {
  box-sizing: border-box;
}

#myInput {
  background-image: url('/css/searchicon.png');
  background-position: 10px 10px;
  background-repeat: no-repeat;
  width: 100%;
  font-size: 16px;
  padding: 12px 20px 12px 40px;
  border: 1px solid #ddd;
  margin-bottom: 12px;
}

#myTable {
  border-collapse: collapse;
  width: 100%;
  border: 1px solid #ddd;
  font-size: 18px;
}

#myTable th, #myTable td {
  text-align: left;
  padding: 12px;
}

#myTable tr {
  border-bottom: 1px solid #ddd;
}

#myTable tr.header, #myTable tr:hover {
  background-color: #f1f1f1;
}
</style>

    </head>
    <body>
        <h1>Hello World!</h1>
        <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name" >

<table id="myTable">
    <tbody style="cursor:pointer">
  <tr class="header">
    <th style="width:60%;">Article</th>
    <th style="width:40%;">Catégorie</th>
  </tr>
  <tr onclick="addRowHandlers()">
    <td>BANAN</td>
    <td>FRAIS</td>
  </tr>
  <tr>
    <td>BB</td>
    <td>Vetement</td>
  </tr>
  <tr>
    <td>CC</td>
    <td>Vetement</td>
  </tr>
  <tr>
    <td>DD</td>
    <td>FRAIS</td>
  </tr>
  </tbody>
</table>
 <input type="hidden" name="employe" class="form-control" />
<script> 



</script>


    </body>
</html>
