

<%@page import="EntityBean.ArticleMagasin"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id ="employeCo" scope="session" class="EntityBean.Employe"></jsp:useBean>
 <jsp:useBean id="articles" scope="request" class="java.util.List"></jsp:useBean>
<jsp:useBean id="message" scope="request" class="String"></jsp:useBean>


<!DOCTYPE html>
<html lang="en">
  <head>
      
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script  type="text/javascript"   src="./JSP_Pages/MesJavascript.js"> </script>
    <link rel="icon" href="./Template/images/favicon.ico" type="image/ico" />
    <title>Articles</title>
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
    <!-- Datatables -->
    <link href="./Template/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="./Template/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="./Template/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="./Template/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="./Template/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">
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
                   <h2> Bienvenu dans votre espace BNJI SuperMarket<small></small></h2>
                <div class="x_panel">
                  <div class="x_title">
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
                      <% List<ArticleMagasin> lesars = articles; 
                      if(lesars.size()==0) {%>
                      <i class="fa fa-bell-slash-o"> Vous n'avez aucune notification</i>
                      <%}else { %>
                      <i class="fa fa-bell"> Nouvelle(s) Notification(s) : <%=lesars.size()%> article(s) à modifier</i>
                      <br>
                    <br>
                    <form method="post" action="ControleAdministration">
                      <div id="datatable-checkbox_wrapper" class=form-group dataTables_wrapper form-inline dt-bootstrap no-footer">
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="dataTables_length" id="datatable-checkbox_length">
                                </div>
                                    
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                      <table class="table table-striped table-bordered bulk_action dataTable no-footer" role="grid" aria-describedby="datatable-checkbox_info">
                      <thead>
                        <tr role="row">
                            <th style="display : none"></th>
                                <th style="width: 167px;">Article</th>
                                <th style="width: 126px;">Catégorie</th>
                                <th style="width: 126px;">Sous catégorie</th>
                                <th style="width: 126px;">Fournisseur</th>
                                <th style="width: 126px;">Prix d'achat</th>
                                <th style="width: 126px;">Votre Prix de vente</th>
                             </tr>
                      </thead>
                      <tbody>
                         <% 
                          for( ArticleMagasin a : lesars){ 
                         %>
                        <tr role="row" class="odd">
                        <td style="display : none"></td>
                        <td><%=a.getArticle().getLibelle()%></td>
                        <td><%=a.getArticle().getSousCategorie().getCategorie().getLibelle()%></td>
                        <td><%=a.getArticle().getSousCategorie().getLibelle()%></td>
                        <td><%=a.getArticle().getFournisseur().getNom()%></td>
                        <td><%=a.getArticle().getPrix_achat_actuel()%></td>
                        <td>
                        <input type="number" min="0" step="any" required id="prix" name="prix">
                        </td>
                        </tr>
                        
                      </tbody>
                       <%;}%>
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
                    <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                          <a href="ControleAdministration?action=Accueil" class="btn btn-primary" role="button">Annuler</a>
		          <button class="btn btn-primary" type="reset">Reset</button>
                          <input type="hidden" name="action" value="SetPrix"/>
                          <button type="submit" class="btn btn-success">Enregistrer les modifications</button>
                        </div>
                      </div>
                    </form>
                    <% } %>
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