<%-- 
    Document   : CreationCasse
    Created on : 19 mars 2018, 13:19:04
    Author     : i.silvestre
--%>

<%@page import="EntityBean.ArticleMagasin"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="EntityBean.Ligne_Casse"%>
<%@page import="EntityBean.Casse"%>
<%@page import="EntityBean.Categorie"%>
<%@page import="java.util.List"%>
<%@page import="EntityBean.Employe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="Template/images/favicon.ico" type="image/ico" />
    <!-- Bootstrap -->
    <link href="./Template/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="./Template/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="./Template/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- bootstrap-wysiwyg -->
    <link href="./Template/google-code-prettify/bin/prettify.min.css" rel="stylesheet">
    <!-- Select2 -->
    <link href="./Template/select2/dist/css/select2.min.css" rel="stylesheet">
    <!-- Switchery -->
    <link href="./Template/switchery/dist/switchery.min.css" rel="stylesheet">
    <!-- starrr -->
    <link href="./Template/starrr/dist/starrr.css" rel="stylesheet">
    <!-- bootstrap-daterangepicker -->
    <link href="./Template/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="./Template/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- bootstrap-progressbar -->
    <link href="./Template/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- Datatables -->
    <link href="./Template/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="./Template/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="./Template/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="./Template/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="./Template/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="./Template/css/custom.min.css" rel="stylesheet">
        
         <jsp:useBean id ="employeCo" scope="session" class="Employe"></jsp:useBean>
         <jsp:useBean id="casse" scope="request" class="Casse"></jsp:useBean>
         <jsp:useBean id="message" scope="request" class="String"></jsp:useBean>
         <jsp:useBean id="listeArticles" scope="request" class="java.util.List"></jsp:useBean>
         <jsp:useBean id="listeLot" scope="request" class="java.util.List"></jsp:useBean>
         
         
         
        <title>Creation casse</title>
    </head>
    <body class="nav-md">
     
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
               
              <%@include file ="MenuAgRayon.jsp" %>
          </div>
        </div>
              <%@include file="header.jsp" %>
 
        <!-- page content -->
        <div class="right_col" role="main">
       <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Page Création casse<small></small></h2>
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
                      <div class="col-xs-12 invoice-header">
                          <h1>
                                          <i class="fa fa-globe"></i> Casse du <%= new SimpleDateFormat("yyyy-MM-dd").format(casse.getDate_casse())  %>
                                          
                          </h1>
                     </div>
                      <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                     <table class="table table-hover">
                      <thead>
                        <tr>
                          <th>#</th>
                          <th>Article</th>
                          <th>quantité</th>
                        </tr>
                      </thead>
                      <tbody>
                          <% if (!casse.getLigne_Casses().isEmpty())
                          {
                              int i = 0;
                          List<Ligne_Casse> lesLignes = casse.getLigne_Casses();
                                for( Ligne_Casse l : lesLignes){
                          i = i+1 ;%>
                        <tr>
                          <th scope="row"> <%= i%> </th>
                          <td><%=l.getArticle().getArticle().getLibelle() %></td>
                          <td><%=l.getQuantite() %></td>
                        </tr>
                        <% }} %>
                      </tbody>
                     </table>
                          </div>
                      
                      </div>
                      <div class="col-md-6 col-md-offset-3">
                          <a type ="button" class="btn btn-success">Ajouter une ligne </a>
                        </div>
                  </div>
                      <div class ="x_content">
                          
                          <div id="wizard_verticle" class="form_wizard wizard_verticle">
                      <ul class="list-unstyled wizard_steps anchor">
                        <li>
                          <a href="#step-11" class="selected" isdone="1" rel="1">
                            <span class="step_no">1</span>
                          </a>
                        </li>
                        <li>
                          <a href="#step-22" class="done" isdone="1" rel="2">
                            <span class="step_no">2</span>
                          </a>
                        </li>
                        <li>
                          <a href="#step-33" class="done" isdone="1" rel="3">
                            <span class="step_no">3</span>
                          </a>
                        </li>
                      </ul>
                    <div class="stepContainer" style="height: 366px;">
                      <div id="step-11" class="content" style="display: block;">
                        <h2 class="StepTitle">Etape 1 : choix article</h2>
                        <form class="form-horizontal form-label-left">
                            <div id="datatable-checkbox_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="dataTables_length" id="datatable-checkbox_length">
                                </div>  
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <table id="datatable-checkbox" class="table table-striped table-bordered bulk_action dataTable no-footer" role="grid" aria-describedby="datatable-checkbox_info">
                      <thead>
                        <tr role="row">
                            <th class="sorting_disabled" rowspan="1" colspan="1" aria-label="
                                " style="width: 12px;">     
                            </th>
                            <th class="sorting_asc" tabindex="0" aria-controls="datatable-checkbox" rowspan="1" colspan="1" aria-sort="ascending" aria-label=": activate to sort column descending" style="width: 46px;">                             
                            </th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-checkbox" rowspan="1" colspan="1" aria-label="Référence : activer pour ordonner" style="width: 167px;">Reference</th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-checkbox" rowspan="1" colspan="1" aria-label="Libellé : activer pour ordonner" style="width: 277px;">Libellé</th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-checkbox" rowspan="1" colspan="1" aria-label="Fournisseur : activer pour ordonner" style="width: 126px;">Fournisseur</th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-checkbox" rowspan="1" colspan="1" aria-label="Catégorie d'articles : activer pour ordonner" style="width: 126px;">Catégorie</th>
                        </tr>
                      </thead>
                      <tbody>
                        
                          <% float total = 0.01f ;
                              List<ArticleMagasin> lesArticles = listeArticles;
                        for( ArticleMagasin a : lesArticles){ 
                        %>
                          
                      <tr role="row" class="odd">
                        <td>
			</td>
                        <th class="sorting_1">
                            <input type="radio" class="flat" name="idArticle" value ="<%= a.getId() %>" required="" data-parsley-multiple="article" style="position: absolute; opacity: 0;">
                           
                        </th>
						  
                          <td><%= a.getArticle().getReference() %></td>
                          <td><%= a.getArticle().getLibelle() %></td>
                          <td><%= a.getArticle().getFournisseur().getNom() %></td>
                          <td><%= a.getArticle().getSousCategorie().getCategorie().getLibelle() %></td>
                      </tr>
                        <%}%>
                        
                      </tbody>
                    </table>
                            </div>
                      
                        </div>
                      <div class="row">
                          <div class="col-sm-5">
                                  
                          </div>
                          <div class="col-sm-7">
                          </div>
                      </div>
                    </div>
                        </form>
                      </div>
                        <div id="step-22" class="content" style="display: none;">
                        <h2 class="StepTitle">Etape 2 : choix lot</h2>
                        Rechercher Lots
                      </div>
                        <div id="step-33" class="content" style="display: none;">
                            <h2 class="StepTitle">Etape 3 : saisir quantité perdue</h2>
                        Saisir quantité
                      </div>
                    </div>
                              <div class="actionBar">
                                  <div class="msgBox">
                                      <div class="content">
                                          
                                      </div>
                                      <a href="#" class="close">X</a>
                                  </div>
                                  <div class="loader">Loading</div>
                                  <a href="#" class="buttonFinish buttonDisabled btn btn-default">Finish</a>
                                  <a href="#" class="buttonNext btn btn-success">Next</a>
                                  <a href="#" class="buttonPrevious btn btn-primary buttonDisabled">Previous</a>
                              </div>
                          </div>
                          
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
     <!-- jquery.inputmask -->
    <script src="./Template/jquery.inputmask/dist/min/jquery.inputmask.bundle.min.js"></script>
    <!-- Custom Theme Scripts -->
   <script src="./Template/js/custom-min.js"></script>
   <!-- jQuery Smart Wizard -->
    <script src="./Template/jQuery-Smart-Wizard/js/jquery.smartWizard.js"></script>
    <!-- Datatables -->
    <script src="./Template/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="./Template/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="./Template/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
    <script src="./Template/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
    <script src="./Template/datatables.net-buttons/js/buttons.flash.min.js"></script>
    <script src="./Template/datatables.net-buttons/js/buttons.html5.min.js"></script>
    <script src="./Template/datatables.net-buttons/js/buttons.print.min.js"></script>
    <script src="./Template/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
    <script src="./Template/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
    <script src="./Template/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="./Template/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
    <script src="./Template/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
    <script src="./Template/jszip/dist/jszip.min.js"></script>
    <script src="./Template/pdfmake/build/pdfmake.min.js"></script>
    <script src="./Template/pdfmake/build/vfs_fonts.js"></script>
    </body> 
</html>
