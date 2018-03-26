
<%@page import="EntityBean.ligneCommandeEnLigne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="EntityBean.Promotion"%>
<%@page import="EntityBean.ArticleMagasin"%>
<%@page import="EntityBean.Magasin"%>
<%@page import="java.util.List"%>
<%@page import="EntityBean.Categorie"%>
<!DOCTYPE html>
<html>
<head>
    
        <jsp:useBean id ="ClientCo" scope="session" class="EntityBean.Client"></jsp:useBean>
        <jsp:useBean id ="Panier" scope="session" class="EntityBean.CommandeClientEnLigne"></jsp:useBean>
        <jsp:useBean id ="cats" scope="request" class="List"></jsp:useBean>
        <jsp:useBean id ="magasin" scope="request" class="Magasin"></jsp:useBean>
        <jsp:useBean id ="promotions" scope="request" class="List"></jsp:useBean>
        
	<title>Product</title>
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
						Client_connecté@example.com
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

					<div class="header-wrapicon2">
						<img src="./TemplateClient/images/icons/icon-header-02.png" class="header-icon1 js-show-header-dropdown" alt="ICON">
                                                <%String num = "0";
                                                    if (Panier!=null){
                                                      if (Panier.getLigneCommandeEnLignes()!=null){
                                                          num = ""+Panier.getLigneCommandeEnLignes().size();
                                                }}%>
						<span class="header-icons-noti"><%=num%></span>

						<!-- Header cart noti -->
						<div class="header-cart header-dropdown">
                                                    <!-- les élements du panier -->
                                                    <% if (Panier!=null){
                                                      if (Panier.getLigneCommandeEnLignes()!=null){
                                                          
                                                            float total = 0;
                                                            for (ligneCommandeEnLigne l:Panier.getLigneCommandeEnLignes()){%>
							<ul class="header-cart-wrapitem">
                                                           <li class="header-cart-item">
									
									<div class="header-cart-item-txt">
										<a href="#" class="header-cart-item-name">
											<%=l.getArticleMagasin().getArticle().getLibelle()%>
										</a>

										<span class="header-cart-item-info">
											1 x €<%=l.getArticleMagasin().getPrix_vente_actuel()%>
										</span>
									</div>
								</li>
							</ul>
                                                                                
                                                        <% total+=l.getPrix_vente();}%>
							<div class="header-cart-total">
                                                               
								Total: €<%=total %>
							</div>

							<div class="header-cart-buttons">
								<div class="header-cart-wrapbtn">
									<!-- Button cart.html-->
									<a href="controleClient?action=voirPanier" class="flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4">
										Voir Panier
									</a>
								</div>

								<div class="header-cart-wrapbtn">
									<!-- Button -->
									<a href="#" class="flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4">
										Payer
									</a>
								</div>
							</div>
                                                       <%}}%> 
						</div>
					</div>
				</div>
			</div>
		</div>
              
	</header>

        <!-- Content page -->
	<section class="bgwhite p-t-55 p-b-65">
		<div class="container">
			<div class="row">
				<div class="col-sm-6 col-md-4 col-lg-3 p-b-50">
					<div class="leftbar p-r-20 p-r-0-sm">
						<!--  -->
						<h4 class="m-text14 p-b-7">
							Categories
						</h4>

						<ul class="p-b-54">
                                                <% List<Categorie> lcat = cats;
                                                   for (Categorie c:lcat){
                                                %>
							<li class="p-t-4">
								<a href="#" class="s-text13 active1">
							            <%=c.getLibelle() %>
								</a>
							</li>
                                                    <%}%>
							
						</ul>

						<div class="search-product pos-relative bo4 of-hidden">
							<input class="s-text7 size6 p-l-23 p-r-50" type="text" name="search-product" placeholder="Search Products...">

							<button class="flex-c-m size5 ab-r-m color2 color0-hov trans-0-4">
								<i class="fs-12 fa fa-search" aria-hidden="true"></i>
							</button>
						</div>
					</div>
				</div>

				<div class="col-sm-6 col-md-8 col-lg-9 p-b-50">
					<!--  -->
					<div class="flex-sb-m flex-w p-b-35">
						

						<span class="s-text8 p-t-5 p-b-5">
                                                    <% String numC = "0";
                                                    Magasin mag = magasin;
                                                    if(mag!=null)
                                                        if (mag.getArticleMagasins()!=null)
                                                             numC=""+mag.getArticleMagasins().size(); %>
                                                        Showing 1?12 of <%=numC%> results
						</span>
					</div>

					<!-- Product -->
                                        <form name="PanierForm" onsubmit="" method="post" action="controleClient">
                                            <input type="hidden" name="action" value="FromHOME">
                                            <input type="hidden" name = "produitSel" >
					<div class="row">
                                           
                                            <% List<Promotion> listePro = promotions;
                                                if (mag.getArticleMagasins()!=null){
                                               for (ArticleMagasin artMag:mag.getArticleMagasins()) {
                                                if(artMag.getQuantite()>0){
                                               
                                            %>
						<div class="col-sm-12 col-md-6 col-lg-4 p-b-50">
							<!-- Block2 -->
							<div class="block2">
								<div class="block2-img wrap-pic-w of-hidden pos-relative block2-labelsale">
                                                                    <% String img = "./TemplateClient/images/item-12.jpg";
                                                                      if (artMag.getArticle()!=null){
                                                                          if (artMag.getArticle().getImg()!="" && artMag.getArticle().getImg()!=null){
                                                                              img =artMag.getArticle().getImg();
                                                                          }
                                                                      }
                                                                    %>
                                                                    <img src="./TemplateClient/images/item-12.jpg" alt="IMG-PRODUCT">

									<div class="block2-overlay trans-0-4">
										<a href="#" class="block2-btn-addwishlist hov-pointer trans-0-4">
											<i class="icon-wishlist icon_heart_alt" aria-hidden="true"></i>
											<i class="icon-wishlist icon_heart dis-none" aria-hidden="true"></i>
										</a>

										<div class="block2-btn-addcart w-size1 trans-0-4">
											<!-- Button -->
                                                                                        
                                                                                        <button  onclick="document.forms['PanierForm']['produitSel'].value=this.value;document.getElementById('PanierForm').submit();" value = "<%=artMag.getId()%>" class="flex-c-m size1 bg4 bo-rad-23 hov1 s-text1 trans-0-4">
												Ajouter au panier
											</button>
										</div>
									</div>
								</div>

								<div class="block2-txt p-t-20">
									<a href="" class="block2-name dis-block s-text3 p-b-5">
										<%=artMag.getArticle().getLibelle() %>
									</a>
                                                                        
                                                                         <% String prix_promo = "";
                                                                            if (listePro!=null){
                                                                           for (Promotion p:listePro){  
                                                                               if (p.getArticle().getId()==artMag.getArticle().getId() && p.getDate_fin().compareTo(new Date()) > 0){
                                                                                   prix_promo = ""+p.getPrix_prmotion();
         
                                                                        }}} %>
                                                                        <% if (prix_promo!=""){%>
                                                                            <span class="block2-oldprice m-text7 p-r-5">
                                                                                    €<%=artMag.getPrix_vente_actuel()%>
                                                                            </span>
                                                                            <span class="block2-newprice m-text8 p-r-5">
										$<%=prix_promo%>
                                                                            </span>
                                                                        <%}else {%>
                                                                               
                                                                            <span  class="block2-price m-text6 p-r-5">
                                                                                    €<%=artMag.getPrix_vente_actuel()%>
                                                                            </span>
                                                                        <%}%>

									
								</div>
							</div>
						</div>
                                                <%}}}%>
					</div>
                                    </form>
				</div>
			</div>
		</div>
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

			<div class="w-size7 p-t-30 p-l-15 p-r-15 respon4">
				<h4 class="s-text12 p-b-30">
					Help
				</h4>

				<ul>
					<li class="p-b-9">
						<a href="#" class="s-text7">
							Track Order
						</a>
					</li>

					<li class="p-b-9">
						<a href="#" class="s-text7">
							Returns
						</a>
					</li>

					<li class="p-b-9">
						<a href="#" class="s-text7">
							Shipping
						</a>
					</li>

					<li class="p-b-9">
						<a href="#" class="s-text7">
							FAQs
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
	<script type="text/javascript" src="./TemplateClient/vendor/daterangepicker/moment.min.js"></script>
	<script type="text/javascript" src="./TemplateClient/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script type="text/javascript" src="./TemplateClient/vendor/slick/slick.min.js"></script>
	<script type="text/javascript" src="./TemplateClient/js/slick-custom.js"></script>
<!--===============================================================================================-->
	<script type="text/javascript" src="./TemplateClient/vendor/sweetalert/sweetalert.min.js"></script>
	<script type="text/javascript">
		$('.block2-btn-addcart').each(function(){
			var nameProduct = $(this).parent().parent().parent().find('.block2-name').html();
			$(this).on('click', function(){
				swal(nameProduct, "is added to cart !", "success");
			});
		});

		$('.block2-btn-addwishlist').each(function(){
			var nameProduct = $(this).parent().parent().parent().find('.block2-name').html();
			$(this).on('click', function(){
				swal(nameProduct, "is added to wishlist !", "success");
			});
		});
	</script>

<!--===============================================================================================-->
	<script type="text/javascript" src="./TemplateClient/vendor/noui/nouislider.min.js"></script>
	<script type="text/javascript">
		/*[ No ui ]
	    ===========================================================*/
	    var filterBar = document.getElementById('filter-bar');

	    noUiSlider.create(filterBar, {
	        start: [ 50, 200 ],
	        connect: true,
	        range: {
	            'min': 50,
	            'max': 200
	        }
	    });

	    var skipValues = [
	    document.getElementById('value-lower'),
	    document.getElementById('value-upper')
	    ];

	    filterBar.noUiSlider.on('update', function( values, handle ) {
	        skipValues[handle].innerHTML = Math.round(values[handle]) ;
	    });
	</script>
<!--===============================================================================================-->
	<script src="./TemplateClient/js/main.js"></script>

</body>
</html>
