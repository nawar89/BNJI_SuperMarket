
<%@page import="EntityBean.Magasin"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="EntityBean.Employe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
  <head>
      <script   type="text/javascript"   src="JSP_Pages/MesJavascript.js"> </script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <jsp:useBean id="magasins" scope="request" class="java.util.List"></jsp:useBean>
        <title>Creation Magasin</title>
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
                    <h2>Création Magasin<small></small></h2>
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
                    <br />
                    <form name="MagasinForm" onsubmit="return validerCreationMagasin()" method="post" action="ControleAdministration">
                        
                        <div class="form-group">
                        <label for="nom" >Magasin <span class="requis" >*</span></label>
                        <select id = "mag" name="magasinselect" onchange="AffictuerMagasinInfo(this,document.getElementsByName('magasin'))">
                            <% List<Magasin> listeMag = magasins ;
                            if (!listeMag.isEmpty()){%>
                               <option value ="<%=0%>"> <%= "" %>  </option>
                             <% }%>
                            <%for(Magasin mag : listeMag) {%>
                            <option value ="<%=mag.getId()%>"> <%=mag.getNom()%>  </option>
                            <% }%>
                          </select>
                          </div>

                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nom">Nom <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="nom" name="nom" required="required" class="form-control col-md-7 col-xs-12" placeholder="Saisir nom">
                           <span class="fa fa-user form-control-feedback  right" aria-hidden="true"></span>
                        </div>
                          
                      </div>
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="ville">Ville <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="adresse" name="ville" required="required" class="form-control col-md-7 col-xs-12" placeholder="Saisir ville" >
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="adresse" class="control-label col-md-3 col-sm-3 col-xs-12">Adresse</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="telephone" class="form-control col-md-7 col-xs-12" type="text" name="adresse"  required="required" placeholder="Saisir adresse">
                          <span class="fa fa-phone form-control-feedback right" aria-hidden="true"></span>
                         
                        </div>
                   
                      </div>
                      <div class="form-group">
                         <label for="code" class="control-label col-md-3 col-sm-3 col-xs-12">code potal</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="code" class="form-control col-md-7 col-xs-12" type="text" required="required" name="code" placeholder="Saisir code">
                          <span class="fa fa-envelope form-control-feedback right" aria-hidden="true"></span>
                        </div>
                      </div>
                          
                          <div class="form-group">
                         <label for="ho" class="control-label col-md-3 col-sm-3 col-xs-12">Horaire ouverteure</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="ho" class="form-control col-md-7 col-xs-12" required="required"  type="text" name="ho" placeholder="Saisir Horaire ouverteure">
                          <span class="fa fa-envelope form-control-feedback right" aria-hidden="true"></span>
                        </div>
                         </div>
                          
                          
                          <div class="form-group">
                         <label for="ho" class="control-label col-md-3 col-sm-3 col-xs-12">Horaire Fermeture</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="hf" class="form-control col-md-7 col-xs-12" type="text" name="hf" placeholder="Saisir Horaire Fermeture">
                          <span class="fa fa-envelope form-control-feedback right" aria-hidden="true"></span>
                        </div>
                         </div>
                          
                          <div class="form-group">
                         <label for="ho" class="control-label col-md-3 col-sm-3 col-xs-12">Gps</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="gps" class="form-control col-md-7 col-xs-12" type="text" name="gps" placeholder="Saisir gps">
                          <span class="fa fa-envelope form-control-feedback right" aria-hidden="true"></span>
                        </div>
                         </div>
                         <table id="myTable" style="display: none">
                            <tbody style="cursor:pointer">
                          <tr class="header">
                            <th >ID</th>
                            <th >nom</th>
                            <th >adresse</th>
                            <th >ville</th>
                            <th >code</th>
                            <th >ho</th>
                            <th >hf</th>
                            <th >gps</th>
                          </tr>
                        <% List<Magasin> listeMags = magasins ;

                        for(Magasin m : listeMags) {%>
                               <tr onclick="addRowHandlersDirectionGeneral()">
                                 <td><%=m.getId()%></td>
                                 <td><%=m.getNom() %></td>
                                 <td><%=m.getAdresse()%></td>
                                 <td><%=m.getVille()  %></td>
                                 <td><%=m.getCode_postal()  %></td>
                                 <td><%=m.getHoraire_ouverteur()  %></td>
                                 <td><%=m.getHoraire_fermeture()  %></td>
                                 <td><%=m.getGps()  %></td>

                               </tr>
                        <% }%>
                         </tbody>
                        </table>  
                          
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                          <a href="JSP_Pages/MenuDirectionNational.jsp" class="btn btn-primary" role="button">Annuler</a>
		          <input type="hidden"  name="magasin" class="form-control" />
                          <input type="hidden" name="action" value="FromMagasin">
                          <input type="submit"  class="btn btn-primary" value="Valider" />
                        <input type="reset"   class="btn btn-primary"  value="Remettre à zéro" />
                        </div>
                      </div>

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