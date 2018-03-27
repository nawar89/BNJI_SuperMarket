

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
        <title>Creation Magasin</title>
    </head>
    <body>
        <form name="MagasinForm" onsubmit="return validerCreationMagasin()" method="post" action="ControleAdministration">
         <div class="form-group"> 
        <fieldset>
        <legend>Nouveau Magasin</legend>
        <label for="nom" >Magasin <span class="requis" >*</span></label>
        <select id = "mag" name="magasinselect" onchange="AffictuerMagasinInfo(this,document.getElementsByName('magasin'))">
            <% List<Magasin> listeMag = magasins ;
            if (!listeMag.isEmpty()){%>
               <option value ="<%=0%>"> <%= "" %>  </option>
             <% }%>
            <%for(Magasin mag : listeMag) {%>
            <option value ="<%=mag.getId()%>"> <%=mag.getNom()%>  </option>
            <% }%>
             </select>
          <br />
       
        
        <label for="nom">Nom <span class="requis">*</span></label>
        <input type="text" name="nom" class="form-control" placeholder="Saisir nom" />
        <br />
        <label for="prenom">ville <span class="requis">*</span></label>
        <input type="text" name="ville" class="form-control" placeholder="Saisir ville" />
        
        <br />
         <label for="adresse">Adresse <span class="requis">*</span></label>
        <input type="text" name="adresse" class="form-control" placeholder="Saisir Adresse" />
 
         <br />
         <label for="telephone">code Postal <span class="requis">*</span></label>
        <input type="text" name="code" class="form-control" placeholder="Saisir code Postal" />
        
        <br />

         <label for="ho">Horaire ouverteure <span class="requis">*</span></label>
        <input type="text" name="ho" class="form-control" placeholder="Saisir Horaire ouverteure" />
        
        <br />
         <label for="hf">Horaire Fermeture <span class="requis">*</span></label>
        <input type="text" name="hf" class="form-control" placeholder="Saisir Horaire Fermeture" />
        
        <br />
        
         <label for="gps">gps<span class="requis">*</span></label>
        <input type="text" name="gps" class="form-control" placeholder="Saisir Horaire Fermeture" />
        
        <br />
        </fieldset>

            </div>
            <input type="hidden"  name="magasin" class="form-control" />
            <input type="hidden" name="action" value="FromMagasin">
           <input type="submit"  class="btn btn-primary" value="Valider" />
        <input type="reset"   class="btn btn-primary"  value="Remettre à zéro" /> <br />
        
        <table id="myTable" style="display: none">
                <tbody style="cursor:pointer">
              <tr class="header">
                <th >ID</th>
                <th >nom</th>
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
        </form>
    </body>
</html>
