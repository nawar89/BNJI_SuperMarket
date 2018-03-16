<%-- 
    Document   : ConsulterCommandesLivraison
    Created on : 16 mars 2018, 10:23:29
    Author     : Nawar
--%>

<%@page import="EntityBean.Livraison"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script   type="text/javascript"   src="JSP_Pages/MesJavascript.js"> </script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <jsp:useBean id="livraisons" scope="request" class="java.util.List"></jsp:useBean>
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
                <th >Fournisseur</th>
                <th >Agent Livraison</th>
                <th >Date Prevu</th>
                <th >Menton</th>
                
              </tr>
            <% List<Livraison> listeLivs = livraisons ;
            
            for(Livraison l : listeLivs) {%>
                   <tr onclick="addRowHandlersDirectionGeneral()">
                     <td><%=l.getId()%></td>
                     <td><%=l.getFournisseur().getNom() %></td>
                     <% String agent = "not assigned";
                         if (l.getAgentLivraison() != null){ agent = l.getAgentLivraison().getNom()+" "+l.getAgentLivraison().getPrenom(); }%>
                     <td><%=agent %></td>
                     <td><%=l.getDate_livraison_prevu()%></td>
                     <td><%=l.getMention()%></td>
                     <% String  %>
                     <td><input type="radio" name="radQ3" value="2" id="rad" title="prendre" style="display: none" /></td>
                     
                   </tr>
                 <% }%>
             </tbody>
            </table>
        </fieldset>

            </div>
            <input type="hidden"  name="livraison" class="form-control" />
            <input type="hidden" name="action" value="FroConsulterLivraison">
           <input type="submit"  class="btn btn-primary" value="Valider" />
        <input type="reset"   class="btn btn-primary"  value="Remettre à zéro" /> <br />
        
        
        </form>
    </body>
</html>
