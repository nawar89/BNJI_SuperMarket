<%-- 
    Document   : MenuChefRayon
    Created on : Mar 12, 2018, 2:57:22 PM
    Author     : Jihane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
    <link href="../Template/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../Template/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../Template/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../Template/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- bootstrap-progressbar -->
    <link href="../Template/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    
    <!-- Custom Theme Style -->
    <link href="../Template/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="nav-md">
     
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <!--Cette partie est commentée
            
            <div class="navbar nav_title" style="border: 0;">
              <a href="MenuChefRayon.jsp" class="site_title"><i class="fa fa-paw"></i> <span>BNJI SuperMarket</span></a>
            </div>-->

          <!--  <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <!--<div class="profile clearfix">
              <div class="profile_pic">
                <img src="../Template/images/img.jpg" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>Welcome,</span>
                <h2>Chef de Rayon</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->
         <!-- sidebar menu -->
           <!-- <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
             <ul class="nav side-menu">
                  <li><a><i class="fa fa-home"></i> Accueil <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="MenuChefRayon.jsp">Dashboard</a></li>
                      <li><a href="MenuChefRayon.jsp">Dashboard2</a></li>
                      <li><a href="MenuChefRayon.jsp">Dashboard3</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-edit"></i> Fournisseurs <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="creerFournisseur.jsp">Creer un Fournisseur </a></li>
                      <li><a href="MainServlet?action=listerFour">Afficher Fournisseurs</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-desktop"></i> Articles <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="creerArticle.jsp">Créer un Article</a></li>
                      <li><a href="modifierArticle">Modifier le prix de vente d'un article du magasin</a></li>
                      <li><a href="MainServlet?action=listerArticle">Consulter les articles de votre rayon</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-table"></i> Livraisons <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="MainServlet?action=consulterLivr">Consulter les livraisons non comforme</a></li>
                    </ul>
                  </li>
                </ul>
              </div>
             

            </div>
            <!-- /sidebar menu --> 
            <br /> 

           

            <!-- /menu footer buttons -->
          <!--  <div class="sidebar-footer hidden-small">
              <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
              </a>
            </div>
            <!-- /menu footer buttons -->
          </div>
        </div>

        
          <!-- top navigation -->
      <!--  <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <img src="../Template/images/img.jpg" alt="">Chef de Rayon
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="javascript:;"> Profile</a></li>
                    <li>
                      <a href="javascript:;">
                        <span class="badge bg-red pull-right">50%</span>
                        <span>Settings</span>
                      </a>
                    </li>
                    <li><a href="javascript:;">Help</a></li>
                    <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                  </ul>
                </li>

                <li role="presentation" class="dropdown">
                  <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                    <i class="fa fa-envelope-o"></i>
                    <span class="badge bg-green">6</span>
                  </a>
                  <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
                    <li>
                      <a>
                        <span class="image"><img src="Template/images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img src="Template/images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img src="Template/images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img src="Template/images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <div class="text-center">
                        <a>
                          <strong>See All Alerts</strong>
                          <i class="fa fa-angle-right"></i>
                        </a>
                      </div>
                    </li>
                  </ul>
                </li>
              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->
 
        <!-- page content -->
        <div class="right_col" role="main">
        
        </div>
        <!-- /page content -->

        <!-- footer content -->
       <!-- <footer>
          <div class="pull-right">
            BNJI SuperMarket - Platform by BNJI
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>

    <!-- jQuery -->
    <script src="../Template/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="../Template/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="../Template/fastclick/lib/fastclick.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="../Template/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="../Template/iCheck/icheck.min.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="../Template/js/custom.min.js"></script>
	
  </body>
</html>



