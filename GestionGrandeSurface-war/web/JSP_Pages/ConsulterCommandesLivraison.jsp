<%-- 
    Document   : ConsulterCommandesLivraison
    Created on : 16 mars 2018, 10:23:29
    Author     : Nawar
--%>

<%@page import="EntityBean.Livraison"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
        <script   type="text/javascript"   src="JSP_Pages/MesJavascript.js"> </script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <jsp:useBean id="livraisons" scope="request" class="java.util.List"></jsp:useBean>
         <jsp:useBean id="employeCo" scope="session" class="EntityBean.Employe"></jsp:useBean>
    </head>
    <body class="nav-md">
        
        <div class="container body">
        <div class="main_container">
         <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
               
              <%@include file ="MenuAgentLivraison.jsp" %>
          </div>
        </div>
           <%@include file="header.jsp" %>
           
          <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" name="LivraisonForm" onsubmit="" method="post" action="ControleAdministration">
         <div class="form-group"> 
        <fieldset>
        <legend>Livraisons</legend>
            <table id="myTable">
                <tbody style="cursor:pointer">
              <tr class="header">
                <th >ID</th>
                <th >Fournisseur</th>
                <th >Agent Livraison</th>
                <th >Date Prevu</th>
                <th >Menton</th>
                
           
             </tbody>
            </table>
             <div class="x_panel">
                  <div class="x_title">
                    <h2>Hover rows <small>Try hovering over the rows</small></h2>
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
                    <table class="table table-hover" >
                      <thead>
                        <tr>
                          <th>#</th>
                          <th>Fournisseur</th>
                          <th>Agent Livraison</th>
                          <th>Date Prevu</th>
                          <th >Menton</th>
                        </tr>
                      </thead>
                      <tbody>
                      
              
                        <% List<Livraison> listeLivs = livraisons ;

                        for(Livraison l : listeLivs) {%>
                               <tr onclick="addRowHandlersDirectionGeneral()">
                                 <td><%=l.getId()%></td>
                                 <td><%=l.getFournisseur().getNom() %></td>
                                 <% String agent = "not assigned";
                                     if (l.getAgentLivraison() != null){ agent = l.getAgentLivraison().getNom()+" "+l.getAgentLivraison().getPrenom(); }%>
                                 <td><%=agent %></td>
                                 <td><%=l.getDate_livraison_prevu()%></td>
                                 <td><%=l.getMention()%></td>
                                 <% String disp = "";
                                     if (l.getAgentLivraison()!=null){
                                         disp = "style='display: none'"; 
                                     }
                                 %>
                                 <td><input type="button" onclick="" name="but" title="prendre" <%=disp %> /></td>
                                 
                               </tr>
                             <% }%>
                      
                      </tbody>
                    </table>

                  </div>
                </div>             
        </fieldset>
                <%@include file="footer.jsp" %>
            </div>
              <input type="hidden"  name="livraison" class="form-control" />
            <input type="hidden" name="action" value="FromConsulterLivraison">
           <input type="submit"  class="btn btn-primary" value="Valider" />
        <input type="reset"   class="btn btn-primary"  value="Remettre à zéro" /> <br />
        
        
        </form>
          </div>
         </div>
          
    </body>
</html>
