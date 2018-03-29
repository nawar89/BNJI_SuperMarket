<%@page import="EntityBean.SousCategorie"%>
<%@page import="EntityBean.Categorie"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <script   type="text/javascript"   src="JSP_Pages/MesJavascript.js"> </script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <jsp:useBean id="categories" scope="request" class="java.util.List"></jsp:useBean>
         <jsp:useBean id="message" scope="request" class="String"></jsp:useBean>
        <title>Catégorie</title>
        <style type="text/css">
            .highlight { background-color: red; }
            
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" href="Template/images/favicon.ico" type="image/ico" />

   

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
              <%@include file ="/JSP_Pages/MenuDirectionNational.jsp" %>
              
         </div>
        </div>
              <%@include file="/JSP_Pages/header.jsp" %>
              <h2><%=message%></h2>
        <!-- page content -->
        <div class="right_col" role="main">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                    <h2>Création de catégories<small></small></h2>
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
                        <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" name="CategorieForm" onsubmit="return validerCreationCategory()" method="post" action="ControleAdministration">
                            
                             <div class="form-group">
                              <label class="control-label col-md-3 col-sm-3 col-xs-12">Catégorie</label>
                             <div class="col-md-6 col-sm-6 col-xs-12">
                            <select class="form-control" id = "catsel" name="CategorieSelect" onchange="RefreshComboBox(this,document.getElementById('souscatsel'),document.getElementById('souscatseltemp'))">
                                <% List<Categorie> listeCat = categories ;
                            for(Categorie cat : listeCat) {%>
                                 <option value ="<%=cat.getId()%>"> <%=cat.getLibelle() %>  </option>
                            <% }%>
                            </select>
                               </div>
                              </div>
                            
                            <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Sous-Catégorie</label>
                             <div class="col-md-6 col-sm-6 col-xs-12">
                            <select class="form-control" id = "souscatsel" name="SousCategorieSelect">

                          <% if (!listeCat.isEmpty())  {
                              Categorie cat = listeCat.get(0);
                              for(SousCategorie s : cat.getSousCategories() ) {%>
                              <option class="filterOption" value ="<%= cat.getId()%>"> <%=s.getLibelle() %>  </option>
                              <% }}%>
                           </select>
                             </div>
                            </div>
                            
                             <select id = "souscatseltemp" style="display: none" >
           
                                <% if (!listeCat.isEmpty())  {
                                    for (Categorie cat : listeCat){
                                    for(SousCategorie s : cat.getSousCategories() ) {%>
                                    <option class="filterOption" value ="<%= cat.getId()%>"> <%=s.getLibelle() %>  </option>
                                    <% }}}%>

                             </select>
                                    <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="libelle">Nom catégorie <span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                      <input type="text" id = "catnom" name="Categorienom"  onkeyup="LectureSeulCategorie('catsel',this); LectureSeulCategorie('souscatsel',this);" class="form-control col-md-7 col-xs-12" placeholder="Saisir nom Categorie">
                                       <span class="form-control-feedback" aria-hidden="true"></span>
                                    </div>

                                  </div>
                                    
                                     <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="libelle">Nom sous-catégorie <span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                      <input type="text" id = "souscatnom" name="souscatnom"  class="form-control col-md-7 col-xs-12" placeholder="Saisir nom Sous Categorie">
                                       <span class="form-control-feedback" aria-hidden="true"></span>
                                    </div>

                                  </div>
                             
                                   <div class="ln_solid"></div>
                                   <div class="form-group">
                                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                    
                                      <input type="hidden"  name="category" class="form-control" />
                                       <input type="hidden" name="action" value="FromCategorie">
                                      <button type="submit" class="btn btn-success">Valider</button>
                                    <input type="reset"   class="btn btn-primary"  value="Remettre à zéro" />
                                    </div>
                                  </div>
                                    
                                    
                        </form>      
                    </div>
                </div>  
            </div> 
                             
        </div>
        <%@include file="/JSP_Pages/footer.jsp" %>
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