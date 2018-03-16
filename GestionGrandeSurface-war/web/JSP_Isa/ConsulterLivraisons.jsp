<%-- 
    Document   : ConsulterLivraisons
    Created on : 16 mars 2018, 15:35:25
    Author     : i.silvestre
--%>

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

    <title>Consulter Commandes magasin</title>

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
         <jsp:useBean id="listLivraisons" scope="request" class="java.util.List"></jsp:useBean>
         <jsp:useBean id="message" scope="request" class="String"></jsp:useBean>

        
    </head>
    <body class="nav-md">
     
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
               
              <%@include file ="MenuDirMag.jsp" %>
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
              <h2>Liste des Livraisons Magasin <%=employeCo.getMagasin().getNom()%></h2>

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
                    
                    <form method="post" action="DirecteurMagasin?action=afficherDetailLivraison">
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
                            <th class="sorting" tabindex="0" aria-controls="datatable-checkbox" rowspan="1" colspan="1" aria-label="Nom fournisseur : activer pour ordonner" style="width: 167px;">Nom fournisseur</th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-checkbox" rowspan="1" colspan="1" aria-label="Mention livraison : activer pour ordonner" style="width: 277px;">Mention</th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-checkbox" rowspan="1" colspan="1" aria-label="Agent de livraison : activer pour ordonner" style="width: 96px;">Agent de livraison responsable</th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-checkbox" rowspan="1" colspan="1" aria-label="Date prévue : activer pour ordonner" style="width: 126px;">Date de livraison prévue</th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-checkbox" rowspan="1" colspan="1" aria-label="Date réelle : activer pour ordonner" style="width: 124px;">Date de livraison réelle</th>
                            
                        </tr>
                      </thead>
                      <tbody>
                        
                          <% float total = 0.01f ;
                              List<Livraison> lesLivraisons = listLivraisons;
                        for( BonCommande r : lesCommandes){ 
                        for (LigneCommande l : r.getLigneCommandes()) {
                            total = total + (l.getPrix_achat()*l.getQuantite()) ;}
                          total = total - 0.01f ;%>
                          
                      <tr role="row" class="odd">
                        <td>
			</td>
                        <th class="sorting_1">
                            <input type="radio" class="flat" name="idCommande" value ="<%=r.getId()%>" required="" data-parsley-multiple="commande" style="position: absolute; opacity: 0;">
                           
                        </th>
						  
                          <td><%= r.getChefRyon().getPrenom()%> <%= r.getChefRyon().getNom()%></td>
                          <td><%= r.getFournisseur().getNom()%></td>
                          <td><%=r.getLigneCommandes().get(0).getArticle().getSousCategorie().getCategorie().getLibelle() %></td>
                          <td><%= new SimpleDateFormat("yyyy-MM-dd").format(r.getDate_commande()) %></td>
                          <td><%=total %> € </td>
                      </tr>
                        
                        <%;}%>
                        
                      </tbody>
                      </form>
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
                        <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                          <button id="send" type="submit" class="btn btn-success">Consulter le détail d'une commande</button>
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
