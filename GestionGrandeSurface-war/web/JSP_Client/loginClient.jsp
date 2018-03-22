
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Login</title>

    <!-- Bootstrap -->
    <link href="./Template/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="./Template/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="./Template/nprogress/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="./Template/animate.css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="./Template/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="login">
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
          <section class="login_content">
            <form method="post" action="controleClient">
              <h1>Connectez-vous</h1>
              <div>
                <input type="text" name ="login" class="form-control" placeholder="Utilisateur" required="required" />
              </div>
              <div>
                <input type="password" name="mdp" class="form-control" placeholder="Mot de passe" required="required" />
              </div>
              <div>
                <button type="submit" name= "action" value="loginClient" class="btn btn-success">Connexion Client</button>
                
              
              </div>

              <div class="clearfix"></div>

              <div class="separator">
               
                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-paw"></i> BNJI SuperMarket</h1>
                  <p>©2018 All Rights Reserved. BNJI SuperMarket. Privacy and Terms</p>
                </div>
              </div>
               <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                          <a href="/JSP_Client/creerClient" class="btn btn-primary" role="button">Créer mon compte</a>
		         
                        </div>
                      </div>
            </form>
          </section>
        </div>
      
      </div>
    </div>
  </body>
</html>

