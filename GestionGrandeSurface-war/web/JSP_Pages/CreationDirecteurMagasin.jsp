

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
          <jsp:useBean id="magasins" scope="request" class="java.util.List"></jsp:useBean>
           <jsp:useBean id="mesEmployes" scope="request" class="java.util.List"></jsp:useBean>
           <jsp:useBean id="message" scope="request" class="String"></jsp:useBean>
        <title>Creation Direction Magasin</title>
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
                    <h2>Création Directeur magasin<small></small></h2>
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
                      <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" name="EmployeForm" onsubmit="return validerCreationDirectureMagasin(document.getElementById('mag'))" method="post" action="ControleAdministration">
                          <div class="form-group"> 
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Selectionner magasin</label>
                             <div class="col-md-6 col-sm-6 col-xs-12">
                            <select class="form-control" id = "mag" name="magasinselect" onchange="RefreshTableEmployee(this,'myTable')">
                            
                             <% List<Magasin> listeMag = magasins ;
                            if (!listeMag.isEmpty()){%>
                               <option value ="<%=0%>"> <%= "" %>  </option>
                             <% }%>
                            <%for(Magasin mag : listeMag) {%>
                            <option value ="<%=mag.getId()%>"> <%=mag.getNom()%>  </option>
                            <% }%>
                            </select>
                        </div>
                        </div>
                         <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nom">Nom <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" name="nom" required="required" class="form-control col-md-7 col-xs-12"  placeholder="Saisir nom" />
                          <span class="form-control-feedback" aria-hidden="true"></span>
                        </div>
                        </div>
                            
                        <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="prenom">Prénom <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" name="prenom" required="required" class="form-control col-md-7 col-xs-12"  placeholder="Saisir prenom" />
                          <span class="form-control-feedback" aria-hidden="true"></span>
                        </div>
                        </div>
                        <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="adresse">Adresse <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" name="adresse" required="required" class="form-control col-md-7 col-xs-12"  placeholder="Saisir adresse" />
                          <span class="form-control-feedback" aria-hidden="true"></span>
                        </div>
                        </div>
                            <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="telephone">Téléphone <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" name="telephone" required="required" class="form-control col-md-7 col-xs-12"  placeholder="Saisir téléphone" />
                          <span class="form-control-feedback" aria-hidden="true"></span>
                        </div>
                        </div>
                            
                            <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="mail">Email <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input  type="text" name="email" required="required" class="form-control col-md-7 col-xs-12"  placeholder="Saisir email" />
                          <span class="form-control-feedback" aria-hidden="true"></span>
                        </div>
                        </div>
                            
             <input type="text" id="myInput" onkeyup="RechercherEmployeParNom()" placeholder="Recherchr par Nom.." title="">
             <br>
            <table class="table table-striped" id="myTable">
                <tbody style="cursor:pointer">
              <tr class="header">
                <th style="width:10%;">ID</th>
                <th style="width:40%;">Employé</th>
                <th style="width:25%;">Role</th>
                <th style="width:25%;">Magasin</th>
              </tr>
            <% List<Employe> listeEmployes = mesEmployes ;
            
            for(Employe em : listeEmployes) {%>
                   <tr onclick="addRowHandlersDirectionGeneral()">
                     <td><%=em.getId()%></td>
                     <td><%=em.getNom()%></td>
                     <td><%=em.getRole().getNom()  %></td>
                     <% String maga = "-";
                         if (em.getMagasin() != null){ maga = em.getMagasin().getNom();} %>
                     <td><%=maga  %></td>
                   </tr>
            <% }%>
             </tbody>
            </table>
                          
                
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                          <input type="hidden" name="employe" class="form-control" />
                          <input type="hidden" name="action" value="FromDirectionMagasin">
                          <button type="submit"  class="btn btn-success" value="Valider">Valider</button>
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
