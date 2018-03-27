

<%@page import="EntityBean.ArticleMagasin"%>
<%@page import="EntityBean.Fournisseur"%>
<%@page import="EntityBean.SousCategorie"%>
<%@page import="java.util.List"%>
<%@page import="EntityBean.Categorie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <jsp:useBean id ="employeCo" scope="session" class="EntityBean.Employe"></jsp:useBean>


<!DOCTYPE html>
<html lang="en">
  <head>
      
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script  type="text/javascript"   src="./JSP_Pages/MesJavascript.js"> </script>
    <jsp:useBean id="articles" scope="request" class="java.util.List"></jsp:useBean>
    
    <link rel="icon" href="./Template/images/favicon.ico" type="image/ico" />
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
                    <h2>Modification du prix de vente<small></small></h2>
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
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Articles</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                        <select class="form-control" id="articlemag" name="ArticleSelect">
                        <% List<ArticleMagasin> liste = articles ;
                        for(ArticleMagasin ar : liste) {%>
                        <option data-prix ="<%=ar.getPrix_vente_actuel()%>" value ="<%=ar.getId()%>"> <%=ar.getArticle().getLibelle() %> </option>
                        <% }%>
                        </select>
                        </div>
                      </div>
                     <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Prix actuel</label>
                        <div class="ol-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control" readonly="readonly" id="ancien" placeholder="">
                        </div>
                      </div>
                       
                      <div class="form-group">
                          <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nouveauPrix">Nouveau prix<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="number" min="0" step="any" id="nouveauPrix" name="nouveauPrix" required="required" class="form-control col-md-7 col-xs-12">
                           <span class="form-control-feedback" aria-hidden="true"></span>
                        </div>
                       </div>
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                          <a href="ControleAdministration?action=Accueil" class="btn btn-primary" role="button">Annuler</a>
                          <button class="btn btn-primary" type="reset">Reset</button>
                          <input type="hidden" name="action" value="ModifA"/>
                          <button type="submit" class="btn btn-success">Modifier</button>
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
    
    <script>
       $("#ancien").attr("placeholder", $("#articlemag").find(":selected").data("prix"));
       $("#articlemag").change(function(){
       $("#ancien").attr("placeholder", $("#articlemag").find(":selected").data("prix"));
       });
    </script>
	
  </body>
</html>