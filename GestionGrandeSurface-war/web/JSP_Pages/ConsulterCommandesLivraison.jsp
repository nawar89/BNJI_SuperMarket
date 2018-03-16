<%-- 
    Document   : ConsulterCommandesLivraison
    Created on : 16 mars 2018, 10:23:29
    Author     : Nawar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script   type="text/javascript"   src="JSP_Pages/MesJavascript.js"> </script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <jsp:useBean id="magasins" scope="request" class="java.util.List"></jsp:useBean>
         <jsp:useBean id="employes" scope="session" class="java.util.List"></jsp:useBean>
    </head>
    <body>
          <form name="LivraisonForm" onsubmit="" method="post" action="ControleAdministration">
         <div class="form-group"> 
        <fieldset>
        <legend>Livraisons</legend>
            <table id="myTable">
                <tbody style="cursor:pointer">
              <tr class="header">
                <th >ID</th>
                <th >Date Prevu</th>
                <th >adresse</th>
                <th >ville</th>
                <th >code</th>
                <th >ho</th>
                <th >hf</th>
                <th >gps</th>
              </tr>
            <% List<Magasin> listeMags = magasins ;
            
            for(Magasin m : listeMags) {%>
                   <tr onclick="addRowHandlersDirectionGeneral()">
                     <td><%=m.getId()%></td>
                     <td><%=m.getNom() %></td>
                     <td><%=m.getAdresse()%></td>
                     <td><%=m.getVille()  %></td>
                     <td><%=m.getCode_postal()  %></td>
                     <td><%=m.getHoraire_ouverteur()  %></td>
                     <td><%=m.getHoraire_fermeture()  %></td>
                     <td><%=m.getGps()  %></td>
                     
                   </tr>
            <% }%>
             </tbody>
            </table>
        </fieldset>

            </div>
            <input type="hidden"  name="magasin" class="form-control" />
            <input type="hidden" name="action" value="FroConsulterLivraison">
           <input type="submit"  class="btn btn-primary" value="Valider" />
        <input type="reset"   class="btn btn-primary"  value="Remettre à zéro" /> <br />
        
        
        </form>
    </body>
</html>
