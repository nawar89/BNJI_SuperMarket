<%-- 
    Document   : Accueil
    Created on : Mar 13, 2018, 11:34:11 AM
    Author     : Jihane
--%>

<%@page import="EntityBean.Fournisseur"%>
<%@page import="EntityBean.SousCategorie"%>
<%@page import="java.util.List"%>
<%@page import="EntityBean.Categorie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
      
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script  type="text/javascript"   src="./JSP_Pages/MesJavascript.js"> </script>
    <jsp:useBean id="categories" scope="request" class="java.util.List"></jsp:useBean>
    <jsp:useBean id="fournisseurs" scope="request" class="java.util.List"></jsp:useBean>
    <link rel="icon" href="Template/images/favicon.ico" type="image/ico" />
    <title>Gestion Grande Surface</title>
    

    <!-- Bootstrap -->
    <link href="./Template/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="./Template/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="./Template/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="./Template/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- bootstrap-progressbar -->
    <link href="./Template/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    
    <!-- Custom Theme Style -->
    <link href="./Template/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="nav-md">
     
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
               
              <%@include file ="Menu.jsp" %>
          </div>
        </div>
              <%@include file="header.jsp" %>
 
        <!-- page content -->
        <div class="right_col" role="main">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Création d'Article<small></small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                         <li><a href="#">Settings 1</a>
                         </li>
                         <li><a href="#">Settings 2</a>
                         </li>
                        </ul>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <br />
                    <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left"  method="post" action="ControleAdministration">
                      <div class="form-group">
                       <label class="control-label col-md-3 col-sm-3 col-xs-12">Type d'article</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <select class="form-control" id ="typeselect" name="TypeSelect">
                                <option value ="0">Articles Frais</option>
                                <option value ="1">Vêtement</option>
                                <option value ="2">Electromenager</option>
                                <option value ="3">Autres</option>
                            </select>
                        </div>
                       </div>
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="libelle">Libellé <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="libelle" name="libelle" required="required" class="form-control col-md-7 col-xs-12">
                           <span class="form-control-feedback" aria-hidden="true"></span>
                        </div>
                          
                      </div>
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="reference">Référence <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="reference" name="reference" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="prix_achat_actuel" class="control-label col-md-3 col-sm-3 col-xs-12">Prix d'achat</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="prix_achat_actuel" class="form-control col-md-7 col-xs-12" type="text" name="prix_achat_actuel">
                          <span class="form-control-feedback" aria-hidden="true"></span>
                        </div>
                      </div>
                       
                      <div class="form-group">
                         <label for="description" class="control-label col-md-3 col-sm-3 col-xs-12">Description</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                       <textarea class="resizable_textarea form-control" id="description" name="description"></textarea>
                       </div>
                      </div> 
                       <div class="form-group">
                        <label for="taille" class="control-label col-md-3 col-sm-3 col-xs-12">Taille</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="taille" class="form-control col-md-7 col-xs-12" type="text" name="taille">
                          <span class="form-control-feedback" aria-hidden="true"></span>
                        </div>
                      </div>
                        <div class="form-group">
                        <label for="coloris" class="control-label col-md-3 col-sm-3 col-xs-12">Coloris</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="coloris" class="form-control col-md-7 col-xs-12" type="text" name="coloris">
                          <span class="form-control-feedback" aria-hidden="true"></span>
                        </div>
                        </div>
                        <div class="form-group">
                        <label for="period_garantie" class="control-label col-md-3 col-sm-3 col-xs-12">Période de garantie</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="period_garantie" class="form-control col-md-7 col-xs-12" type="text" name="period_garantie">
                          <span class="form-control-feedback" aria-hidden="true"></span>
                        </div>
                        </div>
                      <div class="form-group">
                       <label class="control-label col-md-3 col-sm-3 col-xs-12">Catégorie</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <select class="form-control" id = "catsel" name="CategorieSelect" onchange="RefreshComboBoxArticle(this,document.getElementById('souscatsel'),document.getElementById('souscatseltemp'))">
                            <% List<Categorie> listeCat = categories ;
                            for(Categorie cat : listeCat) {%>
                            <option value ="<%=cat.getId()%>"> <%=cat.getLibelle() %>  </option>
                            <% }%>
                            </select>
                            
                            
                        </div>
                       </div>
                            
                      <div class="form-group">
                       <label class="control-label col-md-3 col-sm-3 col-xs-12">Sous Catégorie</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                        <select class="form-control" id = "souscatsel" name="SousCategorieSelect">
                        <% if (!listeCat.isEmpty())  {
                        Categorie cat = listeCat.get(0);
                        for(SousCategorie s : cat.getSousCategories() ) {%>
                        <option class="filterOption" value ="<%=s.getId()%>"> <%=s.getLibelle() %>  </option>
                            <% }}%>
                        </select>
                        <table  id = "souscatseltemp" style="display: none">
                            <% if (!listeCat.isEmpty())  {
                            for (Categorie cat : listeCat){
                         for(SousCategorie s : cat.getSousCategories() ) {%>
                         <tr>
                             <td><%=cat.getId()%></td>      
                             <td><%=s.getId()%></td>
                             <td><%=s.getLibelle() %></td>
                            </tr>
                         <% }}}%>
                         </table>
                        
                       </div>
                       </div>
                       <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Fournisseurs</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                        <select class="form-control" name="FournisseurSelect">
                        <% List<Fournisseur> listeFour = fournisseurs ;
                        for(Fournisseur four : listeFour) {%>
                        <option value ="<%=four.getId()%>"> <%=four.getNom() %>  </option>
                        <% }%>
                        </select>
                        
                        </div>
                      </div>
                        <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Image</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">

                        <input type="file" name="pic" accept="image/*">
                        </div>
                      </div>
                        
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                          <a href="ControlChef?action=Accueil" class="btn btn-primary" role="button">Annuler</a>
		          <button class="btn btn-primary" type="reset">Reset</button>
                          <input type="hidden" name="action" value="FromCreerArticle"/>
                          <button type="submit" class="btn btn-success">Créer</button>
                        </div>
                      </div>
                    </form>
                  </div>
                </div>
              </div>

            
        </div>
        <%@include file="footer.jsp" %>
      </div>
    </div>

    <!-- jQuery -->
    <script src="./Template/jquery/dist/jquery.min.js"></script>
    <script>
       function RefreshComboBoxArticle(ddl1,ddl2,table) {
   
            var row = table.getElementsByTagName("tr");
            var selectedValue = ddl1.options[ddl1.selectedIndex].value;
             console.log(selectedValue)
            ddl2.options.length = 0;
            for (i = 0; i < row.length; i++) {
                if (selectedValue == row[i].getElementsByTagName("td")[0].innerHTML){
                    createOption(ddl2, row[i].getElementsByTagName("td")[2].innerHTML,row[i].getElementsByTagName("td")[1].innerHTML );
                    
                }
            }      
    } 
  </script>
    <!-- Bootstrap -->
    <script src="./Template/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="./Template/fastclick/lib/fastclick.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="./Template/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="./Template/iCheck/icheck.min.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="./Template/js/custom.min.js"></script>
	
  </body>
</html>