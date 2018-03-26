<%@page import="EntityBean.ligneCommandeEnLigne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="EntityBean.Promotion"%>
<%@page import="EntityBean.ArticleMagasin"%>
<%@page import="EntityBean.Magasin"%>
<%@page import="java.util.List"%>
<%@page import="EntityBean.Categorie"%>
<!DOCTYPE html>
<html lang="en">
<head>
        <jsp:useBean id ="ClientCo" scope="session" class="EntityBean.Client"></jsp:useBean>
        <jsp:useBean id ="Panier" scope="session" class="EntityBean.CommandeClientEnLigne"></jsp:useBean>
        <jsp:useBean id ="dates" scope="request" class="List"></jsp:useBean>
	<title>Cart</title>
        <script  type="text/javascript"   src="./JSP_Pages/MesJavascript.js"> 
            <%  String x = "";
                List<String> dd = dates;
                if (dd!=null){
                for (String d:dd){
                    if (x.equals("")){
                        x += d;
                    }else
                        x += ","+d;
                }}%>
            var disableddates = [<%=x%>];
 
                    function DisableSpecificDates(date) {

                     var m = date.getMonth();
                     var d = date.getDate();
                     var y = date.getFullYear();

                     // First convert the date in to the mm-dd-yyyy format 
                     // Take note that we will increment the month count by 1 
                     var currentdate = (m + 1) + '-' + d + '-' + y ;

                      // We will now check if the date belongs to disableddates array 
                     for (var i = 0; i < disableddates.length; i++) {

                     // Now check if the current date is in disabled dates array. 
                     if ($.inArray(currentdate, disableddates) != -1 ) {
                     return [false];
                     }
                     }

                  }


                 $(function() {
                   $( "#datepicker" ).datepicker({
                   beforeShowDay: DisableSpecificDates
                 });
               });
            
        </script>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
	<link rel="icon" type="image/png" href="./TemplateClient/images/icons/favicon.png"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="./TemplateClient/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="./TemplateClient/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="./TemplateClient/fonts/themify/themify-icons.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="./TemplateClient/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="./TemplateClient/fonts/elegant-font/html-css/style.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="./TemplateClient/vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="./TemplateClient/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="./TemplateClient/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="./TemplateClient/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="./TemplateClient/vendor/slick/slick.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="./TemplateClient/vendor/noui/nouislider.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="./TemplateClient/css/util.css">
	<link rel="stylesheet" type="text/css" href="./TemplateClient/css/main.css">
<!--===============================================================================================-->
</head>
<body class="animsition">

	<!-- Header -->
	<header class="header1">
		<!-- Header desktop -->
		<div class="container-menu-header">
			<div class="topbar">
				<div class="topbar-social">
					<a href="#" class="topbar-social-item fa fa-facebook"></a>
					<a href="#" class="topbar-social-item fa fa-instagram"></a>
					<a href="#" class="topbar-social-item fa fa-pinterest-p"></a>
					<a href="#" class="topbar-social-item fa fa-snapchat-ghost"></a>
					<a href="#" class="topbar-social-item fa fa-youtube-play"></a>
				</div>
				<div class="topbar-child2">
					<span class="topbar-email">
						fashe@example.com
					</span>	
				</div>
			</div>

			<div class="wrap_header">
				<!-- Logo -->
				<a href="index.html" class="logo">
					<img src="./TemplateClient/images/icons/logo.png" alt="IMG-LOGO">
				</a>

				<!-- Menu -->
				<div class="wrap_menu">
					<nav class="menu">
						<ul class="main_menu">
							<li>
								<a href="index.html">Commander</a>
							</li>

							<li>
								<a href="product.html">Panier</a>
                                                        </li>

							<li>
								<a href="contact.html">Mes commandes</a>
							</li>
                                                        <li>
								<a href="contact.html">Déconnexion</a>
							</li>
						</ul>
					</nav>
				</div>

				<!-- Header Icon -->
				<div class="header-icons">
					<a href="#" class="header-wrapicon1 dis-block">
						<img src="./TemplateClient/images/icons/icon-header-01.png" class="header-icon1" alt="ICON">
					</a>

					<span class="linedivide1"></span>

				</div>
			</div>
		</div>

	</header>

	<!-- Title Page -->
	<section class="bg-title-page p-t-40 p-b-50 flex-col-c-m" style="background-image: url(images/heading-pages-01.jpg);">
		<h2 class="l-text2 t-center">
			Cart
		</h2>
	</section>

	<!-- Cart -->
       
	<section class="cart bgwhite p-t-70 p-b-100">
             
        <form name="PanierForm"  onsubmit="chargerDonneesPanier(document.getElementById('MyTable'));" method="post" action="controleClient">
            <input type="hidden" name="action" value="validerPanier">
            <input type="hidden" id = "temp" >
            <input type="hidden" name = "vals" >
            <%if (Panier!=null){
                if (Panier.getLigneCommandeEnLignes()!=null){
                                           
             %>
		<div class="container"> 
			<!-- Cart item -->
			<div class="container-table-cart pos-relative">
				<div class="wrap-table-shopping-cart bgwhite">
                                    
					<table id = "MyTable" class="table-shopping-cart">
						<tr class="table-head">
							
							<th class="column-2">Product</th>
							<th class="column-3">Price</th>
							<th class="column-4 p-l-70">Quantity</th>
							<th class="column-5">Total</th>
						</tr>
                                            <%  float total = 0;
                                                int count = 1;
                                                String name = "";
                                                String id = "";
                                                for (ligneCommandeEnLigne ligne:Panier.getLigneCommandeEnLignes()){
                                                   total=total+ligne.getPrix_vente();
                                                   name = "chp"+count;
                                                   id = "id='"+name+"'";
                                                   count++;
                                            %>
						<tr class="table-row">
							<td style="display: none" class="column-1"><%=ligne.getId() %></td>
							<td class="column-2"><%=ligne.getArticleMagasin().getArticle().getLibelle()%></td>
							<td class="column-3"><%=ligne.getPrix_vente() %></td>
							<td class="column-4">
								<div class="flex-w bo5 of-hidden w-size17">
									<button   onclick="actualiserMoins(document.getElementById('<%=name%>'),document.getElementById('temp'));updateTablePanier(document.getElementById('MyTable'),document.getElementById('temp',document.getElementById('total')));" class="btn-num-product-down color1 flex-c-m size7 bg8 eff2">
										<i class="fs-12 fa fa-minus" aria-hidden="true"></i>
									</button>
                                                                     <%String max = "max='"+ligne.getArticleMagasin().getQuantite()+"'";
                                                                      
                                                                     %>
                                                                     <input <%=id%> class="size8 m-text18 t-center num-product"  type="number" min="-1" <%=max%>  value="1">
                                                                     
                                                                     <button  onclick="actualiserPlus(document.getElementById('<%=name%>'),document.getElementById('temp'));updateTablePanier(document.getElementById('MyTable'),document.getElementById('temp'),document.getElementById('total'));" class="btn-num-product-up color1 flex-c-m size7 bg8 eff2">
										<i class="fs-12 fa fa-plus" aria-hidden="true"></i>
									</button>
                                                                         
								</div>
							</td>
							<td class="column-5"><%=ligne.getPrix_vente()%></td>
                                                        <td style="display: none" class="column-6">1</td>
                                                        
						</tr>
                                                <%}%>
					</table>
                                        
				</div>
			</div>

			<div class="flex-w flex-sb-m p-t-25 p-b-25 bo8 p-l-35 p-r-60 p-lr-15-sm">
				<div class="size10 trans-0-4 m-t-10 m-b-10">
					<!-- Button -->
                                        <input type="submit"  class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4">

				</div>
   
			</div>

                          <div class="form-group">
                            <label for="date_p" class="control-label col-md-3 col-sm-3 col-xs-12">Date de Livraison souhaité</label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input id="datepicker" class="form-control col-md-7 col-xs-12" type="Date"  name="datepicker2">
                              <span class="form-control-feedback" aria-hidden="true"></span>
                            </div>
                           </div>               
                                        
			<!-- Total -->
			<div class="bo9 w-size18 p-l-40 p-r-40 p-t-30 p-b-38 m-t-30 m-r-0 m-l-auto p-lr-15-sm">
				<h5 class="m-text20 p-b-24">
					Cart Totals
				</h5>

				<!--  -->
				<div class="flex-w flex-sb-m p-b-12">
					<span class="s-text18 w-size19 w-full-sm">
						Subtotal:
					</span>
                                        
					<span id = "total" class="s-text18 w-size19 w-full-sm">
						€<%=total%>
					</span>
				</div>
				<!--  -->				

				<div class="size15 trans-0-4">
					<!-- Button -->
					<button class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4">
						Proceed to Checkout
					</button>
				</div>
			</div>
		</div>
                <%}}%>
                </form>
	</section>
       


	<!-- Footer -->
	<footer class="bg6 p-t-45 p-b-43 p-l-45 p-r-45">
		<div class="flex-w p-b-90">
			<div class="w-size6 p-t-30 p-l-15 p-r-15 respon3">
				<h4 class="s-text12 p-b-30">
					GET IN TOUCH
				</h4>

				<div>
					<p class="s-text7 w-size27">
						Any questions? Let us know in store at 8th floor, 379 Hudson St, New York, NY 10018 or call us on (+1) 96 716 6879
					</p>

					<div class="flex-m p-t-30">
						<a href="#" class="fs-18 color1 p-r-20 fa fa-facebook"></a>
						<a href="#" class="fs-18 color1 p-r-20 fa fa-instagram"></a>
						<a href="#" class="fs-18 color1 p-r-20 fa fa-pinterest-p"></a>
						<a href="#" class="fs-18 color1 p-r-20 fa fa-snapchat-ghost"></a>
						<a href="#" class="fs-18 color1 p-r-20 fa fa-youtube-play"></a>
					</div>
				</div>
			</div>

			<div class="w-size7 p-t-30 p-l-15 p-r-15 respon4">
				<h4 class="s-text12 p-b-30">
					Links
				</h4>

				<ul>
					<li class="p-b-9">
						<a href="#" class="s-text7">
							Search
						</a>
					</li>

					<li class="p-b-9">
						<a href="#" class="s-text7">
							About Us
						</a>
					</li>

					<li class="p-b-9">
						<a href="#" class="s-text7">
							Contact Us
						</a>
					</li>

					<li class="p-b-9">
						<a href="#" class="s-text7">
							Returns
						</a>
					</li>
				</ul>
			</div>

			<div class="w-size8 p-t-30 p-l-15 p-r-15 respon3">
				<h4 class="s-text12 p-b-30">
					Newsletter
				</h4>

				<form>
					<div class="effect1 w-size9">
						<input class="s-text7 bg6 w-full p-b-5" type="text" name="email" placeholder="email@example.com">
						<span class="effect1-line"></span>
					</div>

					<div class="w-size2 p-t-20">
						<!-- Button -->
						<button class="flex-c-m size2 bg4 bo-rad-23 hov1 m-text3 trans-0-4">
							Subscribe
						</button>
					</div>

				</form>
			</div>
		</div>

		<div class="t-center p-l-15 p-r-15">
			<a href="#">
				<img class="h-size2" src="./TemplateClient/images/icons/paypal.png" alt="IMG-PAYPAL">
			</a>

			<a href="#">
				<img class="h-size2" src="./TemplateClient/images/icons/visa.png" alt="IMG-VISA">
			</a>

			<a href="#">
				<img class="h-size2" src="./TemplateClient/images/icons/mastercard.png" alt="IMG-MASTERCARD">
			</a>

			<a href="#">
				<img class="h-size2" src="./TemplateClient/images/icons/express.png" alt="IMG-EXPRESS">
			</a>

			<a href="#">
				<img class="h-size2" src="./TemplateClient/images/icons/discover.png" alt="IMG-DISCOVER">
			</a>

			<div class="t-center s-text8 p-t-20">
				Copyright © 2018 All rights reserved.
			</div>
		</div>
	</footer>



	<!-- Back to top -->
	<div class="btn-back-to-top bg0-hov" id="myBtn">
		<span class="symbol-btn-back-to-top">
			<i class="fa fa-angle-double-up" aria-hidden="true"></i>
		</span>
	</div>

	<!-- Container Selection -->
	<div id="dropDownSelect1"></div>
	<div id="dropDownSelect2"></div>



<!--===============================================================================================-->
	<script type="text/javascript" src="./TemplateClient/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script type="text/javascript" src="./TemplateClient/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script type="text/javascript" src="./TemplateClient/vendor/bootstrap/js/popper.js"></script>
	<script type="text/javascript" src="./TemplateClient/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script type="text/javascript" src="./TemplateClient/vendor/select2/select2.min.js"></script>
	<script type="text/javascript">
		$(".selection-1").select2({
			minimumResultsForSearch: 20,
			dropdownParent: $('#dropDownSelect1')
		});

		$(".selection-2").select2({
			minimumResultsForSearch: 20,
			dropdownParent: $('#dropDownSelect2')
		});
	</script>
<!--===============================================================================================-->
	<script src="./TemplateClient/js/main.js"></script>

</body>
</html>
