<%-- 
    Document   : CreateBonCommande
    Created on : 14 mars 2018, 15:28:37
    Author     : Nawar
--%>

<%@page import="EntityBean.Article"%>
<%@page import="java.util.List"%>
<%@page import="EntityBean.Fournisseur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <script   type="text/javascript"   src="JSP_Pages/MesJavascript.js"> 
        var myTableArray = [];
        
        
        
       </script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <jsp:useBean id="fournisseurs" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="message" scope="request" class="String"></jsp:useBean>
        <jsp:useBean id ="employeCo" scope="session" class="EntityBean.Employe"></jsp:useBean>
    <title>Bon Commande</title>
    </head>
    <body>
        <h1>Bon Commande</h1>
        
        <form name="CommandeForm" onsubmit="return doSave(document.getElementById('myTable'))" method="post" action="ControleAdministration">
         <div class="form-group"> 
        <fieldset>
        <legend>Nouveau Commande</legend>
       
        
          <label for="nom" >Fournisseur <span class="requis" >*</span></label>
            <select id = "forsel" name="FourniSelect" onchange="RefreshComboBoxTable(this,document.getElementById('artsel'),document.getElementById('artseltemp'))">
            <% List<Fournisseur> listefor = fournisseurs ;
            for(Fournisseur cat : listefor) {%>
                 <option value ="<%=cat.getId()%>"> <%=cat.getNom()%>  </option>
            <% }%>
             </select>
             <br />
             <label for="nom" >Article<span class="requis" >*</span></label>
              <select id = "artsel" name="articleSelect">
           
            <% if (!listefor.isEmpty())  {
                Fournisseur f = listefor.get(0);
                for(Article a : f.getArticles() ) {%>
                <option class="filterOption" value ="<%= a.getId()%>"> <%=a.getLibelle() %>  </option>
                <% }}%>
                
             </select>
                
            <button type="button" onclick="AjouterDansTable(document.getElementById('artsel'),document.getElementById('myTable'),document.getElementById('artseltemp'))">Ajouter!</button>
            <button type="button" onclick="doSave(document.getElementById('myTable'))">test!</button>    
                
            <table id="artseltemp"  style="display: none">
                <tbody style="cursor:pointer">
              <tr class="header">
                <th >ID for</th>
                <th >Id article</th>
                <th >libelle</th>
                <th >Prix article</th>
                 
              </tr>
              
              
                  <% if (!listefor.isEmpty())  {
                for (Fournisseur f : listefor){
                for(Article a : f.getArticles() ) {%>
                <tr >
                <td><%= f.getId()%>"></td>
                <td><%=a.getId()%></td>
                <td><%=a.getLibelle() %></td>
                <td><%=a.getPrix_achat_actuel()%></td>
                 </tr>
                <% }}}%>
                    
             
                
             </tbody>
            </table>   
         
        <br /> 
          <table id="myTable" >
                <tbody style="cursor:pointer">
              <tr class="header">
                <th >ID Aricle</th>
                <th >Aricle</th>
                <th >Prix achat</th>
                <th >Quantité</th>
                <th >Prix total</th>
                
              </tr>
           
                
             </tbody>
            </table>   
         
        </fieldset>

            </div>
            <input type="hidden"  name="lignes" class="form-control" />
            <input type="hidden" name="action" value="FromBonCommande">
            <input type="submit"  onclick="" class="btn btn-primary" value="Valider" />
        <input type="reset"   class="btn btn-primary"  value="Remettre à zéro" /> <br />
        
       
        </form>
    </body>
</html>
