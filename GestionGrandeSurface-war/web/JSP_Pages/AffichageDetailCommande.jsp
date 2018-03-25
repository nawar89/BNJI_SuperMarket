
<%@page import="EntityBean.Livraison"%>
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
         <jsp:useBean id="commande" scope="request" class="BonCommande"></jsp:useBean>
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
                    <h2>Lignes commandes<small>Détails de la commande</small></h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                      <div class="col-xs-12 invoice-header">
                          <h1>
                                          <i class="fa fa-globe"></i> Commande n° <%= commande.getId() %>
                                          <small class="pull-right">Date de la commande : <%= new SimpleDateFormat("yyyy-MM-dd").format(commande.getDate_commande()) %></small>
                                      </h1>
                        </div>
                    <div class="row invoice-info">
                      <div class="col-sm-4 invoice-col">
                          Fournisseur
                          <address>
                                          <strong><%= commande.getFournisseur().getNom() %></strong>
                                          <br> Adresse : <%= commande.getFournisseur().getAdresse() %>
                                          <br> Téléphone : <%= commande.getFournisseur().getTelephone() %>
                                          <br> Email: <%= commande.getFournisseur().getEmail() %>
                          </address>
                        </div>
                        <div class="col-sm-4 invoice-col">
                          Chef de rayon
                          <address>
                                          <strong> <%= commande.getChefRyon().getPrenom()%> <%= commande.getChefRyon().getNom() %></strong>
                                          
                                          <br>Téléphone : <%= commande.getChefRyon().getTelephone() %>
                                          <br>Email: <%= commande.getChefRyon().getEmail() %>
                                      </address>
                        </div>
                                      <% float total = 0.01f ; 
                              for (LigneCommande l : commande.getLigneCommandes()) {
                              total = total + (l.getPrix_achat()*l.getQuantite()) ;}
                              total = total - 0.01f ;%>
                        <div class="col-sm-4 invoice-col">
                          <b>Commande : </b>
                          <br>
                          <br>
                          <b> Statut:</b><% if (commande.getLivraisons().isEmpty()) { %>
                                        <%= "Non prise en charge"%>
                          <%} else if (commande.getLivraisons().size()== 1){ %>
                                        <%= commande.getLivraisons().get(0).getMention()%>
                          <%} else {%>
                                        <%= commande.getLivraisons().get(commande.getLivraisons().size()-1).getMention()%> (plusieurs livraisons effectuées)
                          <%}%>
                          <br>
                          <b>Total : <%= total %> € </b>
                          <br>
                        </div>
                      </div>
                    <table class="table table-hover">
                      <thead>
                        <tr>
                          <th>#</th>
                          <th>libellé</th>
                          <th>Sous-catégorie</th>
                          <th>Prix d'achat</th>
                          <th>quantité achetée</th>
                          <th>total ligne</th>
                        </tr>
                      </thead>
                      <tbody>
                          <% int i = 0;
                          List<LigneCommande> lesLignes = commande.getLigneCommandes();
                                for( LigneCommande l : lesLignes){
                          
                          i = i+1 ; 
                          float totalLigne = 0.01f ;
                          totalLigne = l.getQuantite()*l.getPrix_achat(); %>
                        <tr>
                          <th scope="row"> <%= i%> </th>
                          <td><%=l.getArticle().getLibelle()%></td>
                          <td><%=l.getArticle().getSousCategorie().getLibelle() %></td>
                          <td><%=l.getPrix_achat() %></td>
                          <td><%=l.getQuantite() %></td>
                          <td> <%= totalLigne %> € </td>
                        </tr>
                        <% } %>
                      </tbody>
                    </table>

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
