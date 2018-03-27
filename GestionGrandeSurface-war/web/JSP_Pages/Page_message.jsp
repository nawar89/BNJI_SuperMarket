
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:useBean id="message" scope="request" class="String"></jsp:useBean>
    <jsp:useBean id ="FourCo" scope="session" class="EntityBean.Fournisseur"></jsp:useBean>
     <jsp:useBean id ="employeCo" scope="session" class="EntityBean.Employe"></jsp:useBean>
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>BNJI SuperMarket</title>

    <!-- Bootstrap -->
    <link href="./Template/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="./Template/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="./Template/nprogress/nprogress.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="./Template/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <!-- page content -->
        <div class="col-md-12">
          <div class="col-middle">
            <div class="text-center">
              <h1 class="error-number"></h1>
              <h2>BNJI SuperMarket - Platform by BNJI</h2>
              <p><%=message%><a href="#"></a>
              </p>
              <form method="post" action="ControleAdministration">
              <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                           <% if(FourCo!=null) {
                             if (FourCo.getId() != null ){%>
                          <input type="hidden" name="action" value="AccueilFournisseur"/>
                          <%}} if (employeCo!=null){
                           if (employeCo.getId() != null ){
                          %>
                          <input type="hidden" name="action" value="Redirection"/>
                          <%}}%>
                          <button type="submit" class="btn btn-success">Retour au Menu</button>
                        </div>
              </div>
               </form>
              
              <!--<div class="mid_center">
                <h3>Search</h3>
                <form>
                  <div class="col-xs-12 form-group pull-right top_search">
                    <div class="input-group">
                      <input type="text" class="form-control" placeholder="Search for...">
                      <span class="input-group-btn">
                              <button class="btn btn-default" type="button">Go!</button>
                          </span>
                    </div>
                  </div>
                </form>
              </div>-->
            </div>
          </div>
        </div>
        <!-- /page content -->
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

    <!-- Custom Theme Scripts -->
    <script src="./Template/js/custom.min.js"></script>
  </body>
</html>