<%@page import="EntityBean.Article"%>
<%@page import="EntityBean.Fournisseur"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <jsp:useBean id="fournisseurs" scope="request" class="java.util.List"></jsp:useBean>
     <jsp:useBean id="message" scope="request" class="String"></jsp:useBean>
        <jsp:useBean id ="employeCo" scope="session" class="EntityBean.Employe"></jsp:useBean>
<!DOCTYPE html>
<html lang="en">
  <head>
      <script   type="text/javascript"   src="JSP_Pages/MesJavascript.js"> 
        var myTableArray = [];
        
        
        
       </script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
               
              <%@include file ="MenuCR.jsp" %>
          </div>
        </div>
              <%@include file="header.jsp" %>
 
        <!-- page content -->
        <div class="right_col" role="main">
      <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Création de Bon commande<small></small></h2>
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
                    
                    
                     <form name="CommandeForm" onsubmit="return doSave(document.getElementById('myTable'))" method="post" action="ControleAdministration">
                   
                        
                          
                             <label for="nom" class="control-label col-md-3 col-sm-3 col-xs-12">Fournisseur <span class="requis" >*</span></label>
                              <br>
                                <select class="form-control" id = "forsel" name="FourniSelect" class="form-control" onchange="RefreshComboBoxTable(this,document.getElementById('artsel'),document.getElementById('artseltemp'))">
                                <% List<Fournisseur> listefor = fournisseurs ;
                                for(Fournisseur cat : listefor) {%>
                                     <option value ="<%=cat.getId()%>"> <%=cat.getNom()%>  </option>
                                <% }%>
                                 </select>
 
                                 
                             <br>   
                              <label for="l" class="control-label col-md-3 col-sm-3 col-xs-12">Article<span class="requis" >*</span></label>
                               
                                <br>   
                               <select class="form-control"  id = "artsel" name="articleSelect" >

                                <% List<Fournisseur> listefors = fournisseurs ;
                                 if (!listefor.isEmpty())  {
                                 Fournisseur f = listefors.get(0);
                                 for(Article a : f.getArticles() ) {%>
                                 <option  value ="<%= a.getId()%>"> <%=a.getLibelle() %>  </option>
                                 <% }}%>

                              </select>
                                 <br>
                                 <button type="button" class="btn btn-success" onclick="AjouterDansTable(document.getElementById('artsel'),document.getElementById('myTable'),document.getElementById('artseltemp'))">Ajouter!</button>
                       
                            
            
                
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
                          
                          
                       <table id = "myTable" class="table table-striped table-hover">
                      <thead>
                        <tr role="row">
                            
                            <th class="sorting" tabindex="0" aria-controls="datatable-checkbox" rowspan="1" colspan="1" aria-label="Nom chef de rayon : activer pour ordonner" style="width: 167px;">#</th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-checkbox" rowspan="1" colspan="1" aria-label="Nom fournisseur : activer pour ordonner" style="width: 277px;">Article</th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-checkbox" rowspan="1" colspan="1" aria-label="catégorie d'articles : activer pour ordonner" style="width: 126px;">Prix achat</th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-checkbox" rowspan="1" colspan="1" aria-label="Date de la commande : activer pour ordonner" style="width: 124px;">Quantité</th>
                            <th style="display: none" class="sorting" tabindex="0" aria-controls="datatable-checkbox" rowspan="1" colspan="1" aria-label="Date de la commande : activer pour ordonner" style="width: 124px;">Prix total</th>
                            
                        </tr>
                      </thead>
                      <tbody style="cursor:pointer">
                         
                           
                        
                      </tbody>
                   
                    </table>
                   
                      
                        
                             
                                
                        <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                            <input type="hidden"  name="lignes" class="form-control" />
                             <input type="hidden" name="action" value="FromBonCommande">
                            <input type="submit"  onclick="" class="btn btn-primary" value="Valider" />
                            <input type="reset"   class="btn btn-primary"  value="Remettre à zéro" /> <br />
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