<%-- 
    Document   : DirectionNational
    Created on : 8 mars 2018, 13:55:41
    Author     : Nawar
--%>

<%@page import="EntityBean.Magasin"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="EntityBean.Employe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         
        <script   type="text/javascript"   src="JSP_Pages/MesJavascript.js"> </script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <jsp:useBean id="magasins" scope="request" class="java.util.List"></jsp:useBean>
           <jsp:useBean id="mesEmployes" scope="request" class="java.util.List"></jsp:useBean>
           <jsp:useBean id="message" scope="request" class="String"></jsp:useBean>
        <title>Creation Direction Magasin</title>
    </head>
    <body>
        <h1><%= message %></h1>
    <form name="EmployeForm" onsubmit="return validerCreationDirectureMagasin(document.getElementById('mag'))" method="post" action="ControleAdministration">
         <div class="form-group"> 
        <fieldset>
        <legend>Nouveau Directeur Magasin</legend>
        
            <label for="nom" >Magasin <span class="requis" >*</span></label>
            <select id = "mag" name="magasinselect" onchange="RefreshTableEmployee(this,'myTable')">
            <% List<Magasin> listeMag = magasins ;
            if (!listeMag.isEmpty()){%>
               <option value ="<%=0%>"> <%= "" %>  </option>
             <% }%>
            <%for(Magasin mag : listeMag) {%>
            <option value ="<%=mag.getId()%>"> <%=mag.getNom()+"("+mag.getVille()+")"%>  </option>
            <% }%>
             </select>
             <br />
       
        
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

        </fieldset>
         
            <input type="text" id="myInput" onkeyup="RechercherEmployeParNom()" placeholder="Recherchr par Nom.." title="">
            <table id="myTable">
                <tbody style="cursor:pointer">
              <tr class="header">
                <th style="width:10%;">ID</th>
                <th style="width:40%;">Employé</th>
                <th style="width:25%;">Role</th>
                <th style="width:25%;">Magasin</th>
              </tr>
            <% List<Employe> listeEmployes = mesEmployes ;
            
            for(Employe em : listeEmployes) {%>
                   <tr onclick="addRowHandlersDirectionGeneral()">
                     <td><%=em.getId()%></td>
                     <td><%=em.getNom()%></td>
                     <td><%=em.getRole().getNom()  %></td>
                     <% String maga = "-";
                         if (em.getMagasin() != null){ maga = em.getMagasin().getNom();} %>
                     <td><%=maga  %></td>
                   </tr>
            <% }%>
             </tbody>
            </table>
            </div>
            <input type="hidden" name="employe" class="form-control" />
            <input type="hidden" name="action" value="FromDirectionMagasin">
           <input type="submit"  class="btn btn-primary" value="Valider" />
        <input type="reset"   class="btn btn-primary"  value="Remettre à zéro" /> <br />
        </form>
    </body>
</html>
