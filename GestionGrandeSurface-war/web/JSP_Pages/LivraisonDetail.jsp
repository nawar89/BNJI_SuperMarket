<%-- 
    Document   : ConsulterLivraison
    Created on : 14 mars 2018, 15:58:47
    Author     : i.silvestre
--%>

<%@page import="EntityBean.Type_Reclamation"%>
<%@page import="EntityBean.Ligne_livraison"%>
<%@page import="EntityBean.Livraison"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="EntityBean.LigneCommande"%>
<%@page import="java.util.List"%>
<%@page import="EntityBean.Employe"%>
<%@page import="EntityBean.BonCommande"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script   type="text/javascript"   src="JSP_Pages/MesJavascript.js"> var ArrayAccept = [];</script>
    <title></title>

    <!-- Bootstrap -->
    <link href="./Template/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="./Template/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="./Template/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="./Template/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Datatables -->
    <link href="./Template/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="./Template/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="./Template/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="./Template/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="./Template/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="./Template/css/custom.min.css" rel="stylesheet">
        
         <jsp:useBean id ="employeCo" scope="session" class="Employe"></jsp:useBean>
         <jsp:useBean id="livraison" scope="request" class="Livraison"></jsp:useBean>
         <jsp:useBean id="message" scope="request" class="String"></jsp:useBean>

        
    </head>
    <body class="nav-md">
     
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
               
              <%@include file ="MenuAgentLivraison.jsp" %>
          </div>
        </div>
              <%@include file="header.jsp" %>
 
        <!-- page content -->
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Tableau <small> ecrire qqch ici si on veut </small></h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for...">
                    <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Go!</button>
                    </span>
                  </div>
                </div>
              </div>
            </div>
              <h2>Magasin <%=employeCo.getMagasin().getNom()%></h2>

            <div class="clearfix"></div>
            <div class="row">
                  <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Plus Table Design</h2>
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
                    <p class="text-muted font-13 m-b-30">
                    </p>
                    
                    <form id ="monForm" method="post" name="LivraisonForm" action="ControleAdministration" onsubmit="return doSaveLivraisonLigneAgent(document.getElementById('myTable'))">
                    <div id="datatable-checkbox_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="dataTables_length" id="datatable-checkbox_length">
                                </div>
                                    
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                       <table id = "myTable" class="table table-striped jambo_table bulk_action">
                      <thead>
                        <tr role="row">
                            <th>
                              <div class="icheckbox_flat-green" style="position: relative;"><input type="checkbox" id="check-all" class="flat" style="position: absolute; opacity: 0;"><ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins></div>
                            </th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-checkbox" rowspan="1" colspan="1" aria-label="Nom chef de rayon : activer pour ordonner" style="width: 167px;">#</th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-checkbox" rowspan="1" colspan="1" aria-label="Nom fournisseur : activer pour ordonner" style="width: 277px;">Article</th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-checkbox" rowspan="1" colspan="1" aria-label="catégorie d'articles : activer pour ordonner" style="width: 126px;">Quantité livrée</th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-checkbox" rowspan="1" colspan="1" aria-label="Date de la commande : activer pour ordonner" style="width: 124px;">Quantité acceptée</th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-checkbox" rowspan="1" colspan="1" aria-label="Date de la commande : activer pour ordonner" style="width: 124px;">Type Reclamation</th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-checkbox" rowspan="1" colspan="1" aria-label="Date de la commande : activer pour ordonner" style="width: 124px;">Reclamation</th>
                        </tr>
                      </thead>
                      <tbody style="cursor:pointer">
                        
                      <%  Livraison liv = livraison;
                        if (liv.getLigne_livraisons()!=null){
                        for(Ligne_livraison lg : liv.getLigne_livraisons()) {%>
                        <tr >
                           <td class="a-center ">
                              <div class="icheckbox_flat-green" style="position: relative;"><input type="checkbox" class="flat" name="table_records" style="position: absolute; opacity: 0;"><ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins></div>
                            </td>
                                 <td><%=lg.getId()%></td>
                                 <td><%=lg.getArticle().getLibelle() %></td>
                                 <td><%=lg.getQuantite_livree() %></td>
                                 <td onchange=""><input type="text" onkeyup="document.getElementsByName('acepte').value = this.value;AfficherReclamationLigneLivraison(document.getElementById('recDev'),document.getElementById('myTable'));" name="nom" class="form-control" value ="<%=lg.getQuantite_livree() %>" /></td>
                                 <td></td>
                                 <td></td>
                                 <td style="display: none"></td>
                               </tr>
                             <% }}%>
                        
                      </tbody>
                   
                    </table>
                            </div>
                      
                        </div>
                             
                                
                      <div id = "recDev" class="row" style="display: none">
                          <div class="col-sm-5">
                              <label for="rec">Type Reclamation <span class="requis">*</span></label>
                             <select id = "recsel"  name="ReclamationSelect" >
                           
                                 <option value ="<%=0%>"> <%=Type_Reclamation.RECLAMATION_LIVRAISON %>  </option>
                                 <option value ="<%=1%>"> <%=Type_Reclamation.RECLAMATION_COMMANDE %>  </option>
                                 <option value ="<%=2%>"> <%=Type_Reclamation.RECLAMATION_QUALITE %>  </option>
                           
                             </select>  
                              <br />
                              <br />
                              <label for="rec">Reclamation <span class="requis">*   </span></label>
                              <input type="text" id="recText" name="rec" class="form-control" placeholder="Saisir reclamation" />
                              <input type="hidden" name="ligneLivraisonID" class="form-control" />
                                <br />
                                <br />
                                <input type="button" onclick= "creerReclamationLigneLivraison(document.getElementById('myTable'),document.getElementById('recsel'),document.getElementById('recDev'));" value="Ajouter Reclamation">
                                <br />
                                <br />
                                
                          </div>
                          <div class="col-sm-7">
                          </div>
                      </div>
                    </div>
                        <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                            <button style="display: non" id="send" type="submit" class="btn btn-success">Valider</button>
                            <input type="hidden" name="action" value="FromLivraisonDetail">
                            <input type="hidden" name="acepte" class="form-control" />
                          <input type="hidden" name="livlignes" class="form-control" />
                        </div>
                      </div>
                    </form>
                        
                  </div>
                </div>
              </div>
              </div>
            </div>
          </div>
        </div>
        
        <%@include file="footer.jsp" %>
      </div>

<!-- jQuery -->
    <script src="./Template/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="./Template/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="./Template/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="./Template/nprogress/nprogress.js"></script>
    <!-- iCheck -->
    <script src="./Template/iCheck/icheck.min.js"></script>
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

    <!-- Custom Theme Scripts -->
    <script src="./Template/js/custom.min.js"></script>
    </body> 
</html>
