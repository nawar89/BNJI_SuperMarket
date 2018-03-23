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
     <style>
/* Popup container - can be anything you want */
.popup {
    position: relative;
    display: inline-block;
    cursor: pointer;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
}

/* The actual popup */
.popup .popuptext {
    visibility: hidden;
    width: 160px;
    background-color: #555;
    color: #fff;
    text-align: center;
    border-radius: 6px;
    padding: 8px 0;
    position: absolute;
    z-index: 1;
    bottom: 125%;
    left: 50%;
    margin-left: -80px;
}

/* Popup arrow */
.popup .popuptext::after {
    content: "";
    position: absolute;
    top: 100%;
    left: 50%;
    margin-left: -5px;
    border-width: 5px;
    border-style: solid;
    border-color: #555 transparent transparent transparent;
}

/* Toggle this class - hide and show the popup */
.popup .show {
    visibility: visible;
    -webkit-animation: fadeIn 1s;
    animation: fadeIn 1s;
}

/* Add animation (fade in the popup) */
@-webkit-keyframes fadeIn {
    from {opacity: 0;} 
    to {opacity: 1;}
}

@keyframes fadeIn {
    from {opacity: 0;}
    to {opacity:1 ;}
}
</style> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script  type="text/javascript"   src="./JSP_Pages/MesJavascript.js"> 
  </script>
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
               
              <%@include file ="/JSP_Client/MenuClient.jsp" %>
          </div>
        </div>
              <%@include file="/JSP_Client/header.jsp" %>
 
        <!-- page content -->
        <div class="right_col" role="main">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Création Client<small></small></h2>
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
                    <form id="demo-form2" onsubmit="return verifierInputClient(document.getElementById('mot'),document.getElementById('cmot'),document.getElementById('myPopup'))" data-parsley-validate class="form-horizontal form-label-left"  method="post" action="controleClient">
                      
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="libelle">Nom <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="libelle" name="nom" required="required" class="form-control col-md-7 col-xs-12">
                           <span class="form-control-feedback" aria-hidden="true"></span>
                        </div>
                          
                      </div>
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="reference">Prénom <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="reference" name="prenom" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="prix_achat_actuel" class="control-label col-md-3 col-sm-3 col-xs-12">Adresse</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="prix_achat_actuel" class="form-control col-md-7 col-xs-12" required="required" type="text" name="adresse">
                          <span class="form-control-feedback" aria-hidden="true"></span>
                        </div>
                      </div>
                       
                      <div class="form-group">
                         <label for="description" class="control-label col-md-3 col-sm-3 col-xs-12">email</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                       <input class="resizable_textarea form-control" id="description" required="required" name="email">
                       </div>
                      </div> 
                       <div class="form-group">
                        <label for="taille" class="control-label col-md-3 col-sm-3 col-xs-12">Date Naissance</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="taille" class="form-control col-md-7 col-xs-12" type="Date" required="required" name="naissance">
                          <span class="form-control-feedback" aria-hidden="true"></span>
                        </div>
                      </div>
                        
                        <div class="form-group">
                        <label for="taille" class="control-label col-md-3 col-sm-3 col-xs-12">Mdp</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="mot" class="form-control col-md-7 col-xs-12" type="password" required="required" name="mdp">
                          <span class="form-control-feedback" aria-hidden="true"></span>
                        </div>
                      </div>
                        
                       <div class="form-group">
                        <label for="taille" class="control-label col-md-3 col-sm-3 col-xs-12">confirmer mdp</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="cmot" class="form-control col-md-7 col-xs-12" type="password" required="required" name="cmdp">
                          <span class="form-control-feedback" aria-hidden="true"></span>
                        </div>
                        <div class="popup" >
                                <span class="popuptext" id="myPopup">Mdp et confirmer mdp ne correpondent pas</span>
                        </div>
                      </div>
                       
                        
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                          <a href="ControleAdministration?action=Accueil" class="btn btn-primary" role="button">Annuler</a>
		          <button class="btn btn-primary" type="reset">Reset</button>
                          <input type="hidden" name="action" value="FromCreerClient"/>
                          <button type="submit" class="btn btn-success">Créer</button>
                        </div>
                      </div>
                    </form>
                  </div>
                </div>
              </div>

            
        </div>
        <%@include file="/JSP_Client/footer.jsp" %>
      </div>
    </div>

    <!-- jQuery -->
    
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