<%-- 
    Document   : AfficherDetailLivraison
    Created on : 16 mars 2018, 15:35:42
    Author     : i.silvestre
--%>

<%@page import="EntityBean.Ligne_livraison"%>
<%@page import="EntityBean.Livraison"%>
<%@page import="EntityBean.Etat_Livraison"%>
<%@page import="EntityBean.ChefRyon_Categorie"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="EntityBean.LigneCommande"%>
<%@page import="java.util.List"%>
<%@page import="EntityBean.BonCommande"%>
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

    <title>Détails commande</title>
    <!-- Bootstrap -->
    <link href="./Template/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="./Template/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="./Template/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
   <link href="./Template/iCheck/skins/flat/green.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="./Template/css/custom.min.css" rel="stylesheet">
    
  
        <jsp:useBean id ="employeCo" scope="session" class="Employe"></jsp:useBean>
        <jsp:useBean id="livraison" scope="request" class="Livraison"></jsp:useBean>
        <jsp:useBean id="message" scope="request" class="String"></jsp:useBean>
        <title>Afficher détail commande </title>
        
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
        <div class="right_col" role="main">
       <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Détails de la commande<small></small></h2>
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
                  <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_content">
                      <div class="col-xs-12 invoice-header">
                          <h1>
                                          <i class="fa fa-globe"></i> Commande n° <%= livraison.getId() %>
                                          <%Etat_Livraison o = Etat_Livraison.ENCOURS ;
                                           if (livraison.getMention() == o) {%>
                                          <small class="pull-right">Date de réception prévue : <%= new SimpleDateFormat("yyyy-MM-dd").format(livraison.getDate_livraison_prevu()) %></small>
                                          <%} else {%>
                                          <small class="pull-right">Date de réception réelle : <%= new SimpleDateFormat("yyyy-MM-dd").format(livraison.getDate_livraison()) %></small>
                                          <% }%>
                          </h1>
                     </div>
                    <div class="row invoice-info">
                      <div class="col-sm-4 invoice-col">
                          Fournisseur
                          <address>
                                          <strong><%= livraison.getFournisseur().getNom() %></strong>
                                          <br> Adresse : <%= livraison.getFournisseur().getAdresse() %>
                                          <br> Téléphone : <%= livraison.getFournisseur().getTelephone() %>
                                          <br> Email: <%= livraison.getFournisseur().getEmail() %>
                          </address>
                        </div>
                        <div class="col-sm-4 invoice-col">
                          Agent de rayon
                          <address> <% if (livraison.getAgentLivraison()!=null) { %>
                                          <strong> <%= livraison.getAgentLivraison().getPrenom()%> <%= livraison.getAgentLivraison().getNom() %></strong>
                                          
                                          <br><%= "Telephone : " + livraison.getAgentLivraison().getTelephone() %>
                                          <br><%="Email: "+livraison.getAgentLivraison().getEmail() %>
                                          <%} else {%>
                                          <strong><%= "aucun agent responsable" %> </strong><%}%>
                                          
                                      </address>
                        </div>
                        <div class="col-sm-4 invoice-col">
                          <b>Livraison : </b>
                          <br>
                          <br>
                          <b> Statut:</b> <%=livraison.getMention()%>
                          <br>
                          <br>
                        </div>
                      </div>
                    <table class="table table-hover">
                      <thead>
                        <tr>
                          <th>#</th>
                          <th>libellé</th>
                          <th>Sous-catégorie</th>
                          <th>quantité livrée</th>
                          <th></th>
                        </tr>
                      </thead>
                      <tbody>
                          <% int i = 0;
                          List<Ligne_livraison> lesLignes = livraison.getLigne_livraisons();
                                for( Ligne_livraison l : lesLignes){
                   %>
                        <tr>
                          <th scope="row"> <%= i%> </th>
                          <td><%=l.getArticle().getLibelle()%></td>
                          <td><%=l.getArticle().getSousCategorie().getLibelle() %></td>
                          <td><%=l.getQuantite_livree() %></td>
                        </tr>
                        <% } %>
                      </tbody>
                    </table>

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

    <!-- Custom Theme Scripts -->
    <script src="./Template/js/custom.min.js"></script>
    
  </body>
    
    
</html>
