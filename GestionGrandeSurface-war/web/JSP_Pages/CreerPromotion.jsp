

<%@page import="EntityBean.Article"%>
<%@page import="EntityBean.Promotion"%>
<%@page import="EntityBean.Magasin"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="EntityBean.Employe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <script   type="text/javascript"   src="JSP_Pages/MesJavascript.js"> </script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <jsp:useBean id="promotions" scope="request" class="java.util.List"></jsp:useBean>
         <jsp:useBean id="articles" scope="request" class="java.util.List"></jsp:useBean>
         <jsp:useBean id ="employeCo" scope="session" class="EntityBean.Employe"></jsp:useBean>
        <title>Creation Promo</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" href="Template/images/favicon.ico" type="image/ico" />

    

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
               
             <%@include file ="/JSP_Pages/MenuDirectionNational.jsp" %>
          </div>
        </div>
              <%@include file="/JSP_Pages/header.jsp" %>
 
        <!-- page content -->
        <div class="right_col" role="main">
      <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Création Promotion<small></small></h2>
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
                      <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" name="PromotionForm" onsubmit="return validerCreationPromotion()" method="post" action="ControleAdministration">
                        <div class="form-group">
                       <label class="control-label col-md-3 col-sm-3 col-xs-12">Article concerné</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <select class="form-control" id = "art" name="Articleselect" onchange="AffictuerPromoInfo(this,document.getElementsByName('dateCherche'),document.getElementById('myTable'))">
                             <% List<Article> listeArticle = articles ;
                            if (!listeArticle.isEmpty()){%>
                               <option value ="<%=0%>"> <%= "" %>  </option>
                             <% }%>
                            <%for(Article ar : listeArticle) {%>
                            <option value ="<%=ar.getId()%>"> <%=ar.getLibelle()%>  </option>
                            <% }%>
                             </select>
                              </div>
                       </div> 
                             <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="date">chercher par date <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="date" name="dateCherche"  class="form-control col-md-7 col-xs-12"  placeholder="Saisir une date" onchange="AffictuerPromoInfo(document.getElementById('art'),this,document.getElementById('myTable'))"/>
                          <span class="form-control-feedback" aria-hidden="true"></span>
                        </div>
                        </div> 
                              <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="dated">Date Debut <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="date"  name="datedeb" required="required" class="form-control col-md-7 col-xs-12"  placeholder="Saisir une date de début"/>
                          <span class="form-control-feedback" aria-hidden="true"></span>
                        </div>
                        </div> 
                        <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="datef">Date Fin <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="date" name="datefin" required="required" class="form-control col-md-7 col-xs-12"  placeholder="Saisir une date de Fin"/>
                          <span class="form-control-feedback" aria-hidden="true"></span>
                        </div>
                        </div> 
                         
                        <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="prix">Prix promo <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="number" min="0" step="any" name="prixpromo" required="required" class="form-control col-md-7 col-xs-12"  placeholder="Saisir prix en €"/>
                          <span class="form-control-feedback" aria-hidden="true"></span>
                        </div>
                        </div>
                             
             <div class="ln_solid"></div>
              <div class="form-group">
              <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
            <input type="hidden"  name="promo" class="form-control" />
            <input type="hidden" name="action" value="FromPromotion">
           <input type="submit"  class="btn btn-success" value="Valider" />
           <input type="reset"   class="btn btn-primary"  value="Remettre à zéro" /> 
            </div>
                        </div>
        
        <table class="table table-striped" id="myTable" >
                <tbody style="cursor:pointer">
              <tr class="header">
                <th >ID Promo</th>
                <th >ID Aricle</th>
                <th >Article</th>
                <th >Directeur National</th>
                <th >Date debut</th>
                <th >Date fin</th>
                <th >prix achat</th>
                <th >prix promo</th>
              </tr>
            <% List<Promotion> listePro = promotions ;
            
            for(Promotion p : listePro) {%>
                   <tr onclick="addRowHandlersPromotion()">
                     <td><%=p.getId()%></td>
                     <td><%=p.getArticle().getId() %></td>
                     <td><%=p.getArticle().getLibelle() %></td>
                     <td><%=p.getDirectionNationale().getNom() %></td>
                     <td><%=p.getDate_debut()  %></td>
                     <td><%=p.getDate_fin()  %></td>
                     <td><%=p.getArticle().getPrix_achat_actuel() %></td>
                      <td><%=p.getPrix_prmotion() %></td>
                     
                   </tr>
            <% }%>
             </tbody>
            </table>
   
                             
                       
                          
                          
                          
                          
                          
                      </form>
                      
                    
                      
                  </div>
                </div>
              </div>
        </div>
        <%@include file="/JSP_Pages/footer.jsp" %>
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
	
  </body>
    
</html>
