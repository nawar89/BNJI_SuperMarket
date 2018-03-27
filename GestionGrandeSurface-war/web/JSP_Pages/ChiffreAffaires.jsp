

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>

<jsp:useBean id ="comPardate" scope="request" class="java.util.List"></jsp:useBean>

<%@page import="EntityBean.ligneCommandeEnLigne"%>
<%@page import="java.util.List"%>
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
     <script src="./Template/Chart.js/dist/Chart.js"></script>
  </head>

  <body class="nav-md">
     
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
               
              <%@include file ="Menu.jsp" %>
          </div>
        </div>
              <%@include file="header.jsp" %>
             
              <%   
                   List<ligneCommandeEnLigne> listcomPardate = comPardate;
                    List<Float> Ventes = new ArrayList<Float>();
                    List<String> dates = new ArrayList<String>();
                    List<String> categories = new ArrayList<String>();
               
                   for (ligneCommandeEnLigne l : listcomPardate) 
                   {
                      Ventes.add(l.getQuantite()*l.getPrix_vente());
                      dates.add("\""+l.getCommandeClient().getDate_commande_client().toString()+"\"");
                      categories.add("\""+l.getArticleMagasin().getArticle().getSousCategorie().getLibelle()+"\"");
                   }
               
              
                
              
              
              
              
              
              
              %>
        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Analyse du Chiffre d'affaire <small></small></h3>
              </div>
            </div>
            <div class="clearfix"></div>

            <div class="row">
               
            </div>
            <div class="clearfix"></div>
            <div class="row">
            </div>
            <div class="clearfix"></div>
            <div class="row">
              <div class="col-md-6 col-sm-6 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Chiffre d'affaire par catégories <small></small></h2>
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
                <canvas id="cat" width="256" height="256"></canvas>
                  </div>
                </div>
              </div>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Chiffre d'affaire par Période <small></small></h2>
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
                <canvas id="per" width="256" height="256"></canvas>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- page content -->

        <!-- footer content -->
         <%@include file="footer.jsp" %>
        <!-- footer content -->
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
    <!-- Chart.js -->
    <script src="./Template/Chart.js/dist/Chart.min.js"></script>
    
 <script>
            $(document).ready(function(){
            function getSum(total, num) {
                return total + num;
            }
                
            var ctx = $("#cat").get(0).getContext("2d");
            var cty = $("#per").get(0).getContext("2d");
            
            var tabPrixVentes = new Array;
            var tabColors = new Array;
            var tabNomProduits= new Array;
            var tabDates= new Array;
            var totalPrixVentes = <%=Ventes%>.reduce(getSum);
            for(var i=0; i<<%=Ventes%>.length; i++){
               tabPrixVentes.push(((<%=Ventes%>[i]/totalPrixVentes)*100).toFixed(2));
               tabColors.push('#' + (Math.random().toString(16) + "000000").substring(2,8));
               tabNomProduits.push(<%=categories%>[i] + " " + <%=Ventes%>[i]+"€, %");
               tabDates.push(<%=dates%>[i] + " " + <%=Ventes%>[i]+"€, %");
            }
            
            
            data = {
                datasets: [{
                data : tabPrixVentes,
                backgroundColor: tabColors
                }],
                labels: tabNomProduits
            };
             datadate = {
                datasets: [{
                data : tabPrixVentes,
                backgroundColor: tabColors
                }],
                labels: tabDates
            };
                
              var myPieChartcat = new Chart(ctx,{
                type: 'pie',
                data: data
                //options: options
                });
                var myPieChartdate = new Chart(ctx,{
                type: 'pie',
                data: datadate
                //options: options
                });
                });
  </script>
  </body>
</html>
