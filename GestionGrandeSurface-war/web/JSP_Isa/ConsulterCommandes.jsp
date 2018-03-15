<%-- 
    Document   : ConsulterLivraison
    Created on : 14 mars 2018, 15:58:47
    Author     : i.silvestre
--%>

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

    <title>Creation EmployeMagasin</title>

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
         <jsp:useBean id="listCommandes" scope="request" class="java.util.List"></jsp:useBean>
         <jsp:useBean id="message" scope="request" class="String"></jsp:useBean>--%>

        
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
                <h3>Tables <small>Some examples to get you started</small></h3>
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
              <h2>Liste des livraisons Magasin <%=employeCo.getMagasin().getNom()%></h2>

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
                    <div id="datatable-checkbox_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="dataTables_length" id="datatable-checkbox_length">
                                </div>
                                    
                            </div>
                            <div class="col-sm-6">
                                <div id="datatable-checkbox_filter" class="dataTables_filter">
                                    <label>Search:
                                        <input type="search" class="form-control input-sm" placeholder="" aria-controls="datatable-checkbox">
                                    </label>
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
                                <div class="icheckbox_flat-green" style="position: relative;">
                                    <input type="checkbox" id="check-all" class="flat" style="position: absolute; opacity: 0;">
                                </div>
                            </th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-checkbox" rowspan="1" colspan="1" aria-label="Nom chef de rayon : activer pour ordonner" style="width: 167px;">Nom Chef de rayon</th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-checkbox" rowspan="1" colspan="1" aria-label="Nom fournisseur : activer pour ordonner" style="width: 277px;">Nom fournisseur</th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-checkbox" rowspan="1" colspan="1" aria-label="catégorie d'articles : activer pour ordonner" style="width: 126px;">Catégorie concernée</th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-checkbox" rowspan="1" colspan="1" aria-label="Date de la commande : activer pour ordonner" style="width: 124px;">Date de la commande</th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-checkbox" rowspan="1" colspan="1" aria-label="prix total : activer pour ordonner" style="width: 96px;">prix total</th>
                        </tr>
                      </thead>
                      <tbody>
                          <% float total = 0.1f ;
                              List<BonCommande> lesCommandes = listCommandes;
                        for( BonCommande r : lesCommandes){ 
                        for (LigneCommande l : r.getLigneCommandes()) {
                            total = total + (l.getPrix_achat()*l.getQuantite()) ;}%>
                          
                      <tr role="row" class="odd">
                        <td>
			</td>
                        <th class="sorting_1">
                            <div class="icheckbox_flat-green" style="position: relative;">
                                <input type="checkbox" id="check-all" value ="<%=r.getId()%>" class="flat" style="position: absolute; opacity: 0;">
                            </div>
                        </th>
						  
                          <td><%= r.getChefRyon().getPrenom()%> <%= r.getChefRyon().getNom()%></td>
                          <td><%= r.getFournisseur().getNom()%></td>
                          <td><%=r.getLigneCommandes().get(0).getArticle().getSousCategorie().getCategorie()%></td>
                          <td><%=r.getDate_commande() %></td>
                          <td><%=total %></td>
                        </tr>
                        <%;}%>
                      </tbody>
                    </table>
                            </div>
                        </div>
                      <div class="row">
                          <div class="col-sm-5">
                                  
                          </div>
                          <div class="col-sm-7">
                              <div class="dataTables_paginate paging_simple_numbers" id="datatable-checkbox_paginate">
                                  <ul class="pagination">
                                      <li class="paginate_button previous disabled" id="datatable-checkbox_previous">
                                          <a href="#" aria-controls="datatable-checkbox" data-dt-idx="0" tabindex="0">Previous
                                          </a>
                                      </li>
                                      <li class="paginate_button active">
                                          <a href="#" aria-controls="datatable-checkbox" data-dt-idx="1" tabindex="0">1
                                          </a>
                                      </li>
                                      <li class="paginate_button ">
                                          <a href="#" aria-controls="datatable-checkbox" data-dt-idx="2" tabindex="0">2
                                          </a>
                                      </li>
                                      <li class="paginate_button ">
                                              <a href="#" aria-controls="datatable-checkbox" data-dt-idx="3" tabindex="0">3
                                              </a>
                                          </li>
                                          <li class="paginate_button ">
                                              <a href="#" aria-controls="datatable-checkbox" data-dt-idx="4" tabindex="0">4
                                              </a>
                                          </li>
                                          <li class="paginate_button ">
                                              <a href="#" aria-controls="datatable-checkbox" data-dt-idx="5" tabindex="0">5
                                              </a>
                                          </li>
                                          <li class="paginate_button ">
                                              <a href="#" aria-controls="datatable-checkbox" data-dt-idx="6" tabindex="0">6
                                              </a>
                                          </li>
                                          <li class="paginate_button next" id="datatable-checkbox_next">
                                              <a href="#" aria-controls="datatable-checkbox" data-dt-idx="7" tabindex="0">Next
                                              </a>
                                          </li>
                                  </ul>
                              </div>
                          </div>
                      </div>
                    </div>
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
    <script src="../build/js/custom.min.js"></script>
    </body> 
</html>
