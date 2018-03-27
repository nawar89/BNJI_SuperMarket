

<%@page import="EntityBean.Article"%>
<%@page import="EntityBean.Promotion"%>
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
         <jsp:useBean id="promotions" scope="request" class="java.util.List"></jsp:useBean>
         <jsp:useBean id="articles" scope="request" class="java.util.List"></jsp:useBean>
         <jsp:useBean id ="employeCo" scope="session" class="EntityBean.Employe"></jsp:useBean>
        <title>Creation Promo</title>
    </head>
    <body>
        <form name="PromotionForm" onsubmit="return validerCreationPromotion()" method="post" action="ControleAdministration">
         <div class="form-group"> 
        <fieldset>
        <legend>Nouveau Promotion</legend>
        <label for="nom" >Article <span class="requis" >*</span></label>
        <select id = "art" name="Articleselect" onchange="AffictuerPromoInfo(this,document.getElementsByName('dateCherche'),document.getElementById('myTable'))">
            <% List<Article> listeArticle = promotions ;
            if (!listeArticle.isEmpty()){%>
               <option value ="<%=0%>"> <%= "" %>  </option>
             <% }%>
            <%for(Article ar : listeArticle) {%>
            <option value ="<%=ar.getId()%>"> <%=ar.getLibelle()%>  </option>
            <% }%>
             </select>
             
        <label for="ho">chercher par date<span class="requis">*</span></label>
        <input type="date" name="dateCherche" class="form-control" placeholder="Saisir un date" onchange="AffictuerPromoInfo(document.getElementById('art'),this,document.getElementById('myTable'))/>
      
             
          <br />

        <label for="prenom">Date Debut <span class="requis">*</span></label>
        <input type="date" name="datedeb" class="form-control" placeholder="Saisir date debut" />
        
        <br />
         <label for="adresse">Date Fin <span class="requis">*</span></label>
        <input type="date" name="datefin" class="form-control" placeholder="Saisir date fin" />
 
         <br />
        
         <label for="ho">Prix promo <span class="requis">*</span></label>
        <input type="text" name="prixpromo" class="form-control" placeholder="Saisir prix en €" />
        
        <br />
         
        </fieldset>

            </div>
            <input type="hidden"  name="promo" class="form-control" />
            <input type="hidden" name="action" value="FromPromotion">
           <input type="submit"  class="btn btn-primary" value="Valider" />
        <input type="reset"   class="btn btn-primary"  value="Remettre à zéro" /> <br />
        
        <table id="myTable" >
                <tbody style="cursor:pointer">
              <tr class="header">
                <th >ID Promo</th>
                <th >ID Aricle</th>
                <th >Article</th>
                <th >Directeur National</th>
                <th >Date debut</th>
                <th >Date fin</th>
                <th >prix achat</th>
                <th >prix promo</th>
              </tr>
            <% List<Promotion> listePro = promotions ;
            
            for(Promotion p : listePro) {%>
                   <tr onclick="addRowHandlersPromotion()">
                     <td><%=p.getId()%></td>
                     <td><%=p.getArticle().getId() %></td>
                     <td><%=p.getArticle().getLibelle() %></td>
                     <td><%=p.getDirectionNationale().getNom() %></td>
                     <td><%=p.getDate_debut()  %></td>
                     <td><%=p.getDate_fin()  %></td>
                     <td><%=p.getArticle().getPrix_achat_actuel() %></td>
                      <td><%=p.getPrix_prmotion() %></td>
                     
                   </tr>
            <% }%>
             </tbody>
            </table>
        </form>
    </body>
</html>
