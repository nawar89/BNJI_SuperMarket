
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import BeanSession.AdministrationLocal;
import EntityBean.Article;
import EntityBean.ArticleMagasin;
import EntityBean.BonCommande;
import EntityBean.Casse;
import EntityBean.Categorie;
import EntityBean.ChefRyon_Categorie;
import EntityBean.Employe;
import EntityBean.Etat_Livraison;
import EntityBean.Fournisseur;
import EntityBean.LigneCommande;
import EntityBean.Ligne_livraison;
import EntityBean.Livraison;
import EntityBean.Lot;
import EntityBean.Magasin;
import EntityBean.Promotion;
import EntityBean.Role;
import EntityBean.SousCategorie;
import EntityBean.Type_Reclamation;
import Structure.Aide;
import Structure.Parametre;
import Structure.Requete;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Parameter;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.rmi.CORBA.Util;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nawar
 */
@WebServlet(name = "ControleAdministration", urlPatterns = {"/ControleAdministration"})
public class ControleAdministration extends HttpServlet {

    @EJB
    private AdministrationLocal administration;
    public String jspClient = null;
    public String message   = null; 
    public String requete   = null;
    public Date date = new Date();
    public final String DirNAT = "DirNat";
    public final String DirMag = "DirMag";
    public final String ChefRayon = "ChefRayon";
    public final String agentRayon = "AgRayon";
    public final String agentLivraison = "AgLivraison";
    public final String agentCaisse = "AgCaisse";
    
    Employe employeConnecte = null;
    Fournisseur fournisseurConnecte = null;
    HttpSession session=null;   
    ArrayList <Parametre> mesParam = null;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
        
            session=request.getSession(true);

            String act=request.getParameter("action");
            if ((act == null)||(act.equals("null")))
            {
                // jspClient="/JSP_Pages/MenuDirectionNational.jsp";
                jspClient="/JSP_Pages/Accueil.jsp";
            }else {  

                  verifierConnexion(request, response);
            }
            
            
            
            RequestDispatcher Rd;
            Rd = getServletContext().getRequestDispatcher(jspClient);
            Rd.forward(request, response);

        }catch(Exception exepption){System.err.println(exepption.getMessage());}
        /////////////////////////////////////////////////////////////////////////////////////////////////
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControleAdministration</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControleAdministration at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////
protected void seConnecter(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
   HttpSession sess=request.getSession(true);
   mesParam = new ArrayList<Parametre>();
    try{
              String login   = request.getParameter( "login" );
              String mdp     = request.getParameter( "mdp" );
              requete = Requete.getEmployes+ " and e.login=:login and e.mdp=:mdp";
              Parametre p = new Parametre("login", "String", login);
              mesParam.add(p);
              p = new Parametre("mdp", "String", mdp);
              mesParam.add(p);
              List<Employe> listeEmp = administration.getEmploye(requete, mesParam);
              if (listeEmp != null && listeEmp.size()== 1){
                  Employe emp = (Employe)Aide.getObjectDeListe(listeEmp.toArray());
                     switch (emp.getRole().getNom()){
                         case DirMag:
                             jspClient = "/JSP_Isa/MenuDirecteurMagasin.jsp";
                             sess.setAttribute("employeCo", emp);
                             message = "Bonjour "+emp.getPrenom()+" "+emp.getNom() ;
                             break;
                         case DirNAT:
                             jspClient = "/JSP_Pages/AccueilDirectionNational.jsp";
                             sess.setAttribute("employeCo", emp);
                             message = "Bonjour "+emp.getPrenom()+" "+emp.getNom() ;
                             break;
                         case ChefRayon:
                             jspClient = "/Jihane_JSP/Accueil.jsp";
                             sess.setAttribute("employeCo", emp);
                             message = "Bonjour "+emp.getPrenom()+" "+emp.getNom() ;
                             break;
                         case agentRayon:
                             jspClient = "/JSP_Isa/MenuAgentRayon.jsp";
                             sess.setAttribute("employeCo", emp);
                             message = "Bonjour "+emp.getPrenom()+" "+emp.getNom() ;
                             break;
                        case agentLivraison:
                             jspClient = "/JSP_Pages/AccueilAgentLivraison.jsp";
                             sess.setAttribute("employeCo", emp);
                             message = "Bonjour "+emp.getPrenom()+" "+emp.getNom() ;
                             break;
     
                     }     
              }        
    }catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/JSP_Pages/Page_Message.jsp";
}

}
    
    
    
   public void verifierConnexion(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        employeConnecte = (Employe) session.getAttribute("employeCo");
        
        session.setAttribute("employeCo", employeConnecte);
        String act=request.getParameter("action");
        if (employeConnecte ==null && !act.equals("loginEmp") && !act.equals("loginFournisseur")){
            jspClient="/JSP_Pages/Accueil.jsp";
        
        }else {
        
        if (act.equals("loginEmp"))
        {
            seConnecter(request,response);
            request.setAttribute( "message", message );
        }
        else if (act.equals("GoToDirectionNational")){
            DoActPageDirectionNational(request,response);
            request.setAttribute( "message", message );
        }
        else if (act.equals("FromDirectionNational")){
            DirectionNational(request,response); 
            jspClient = "/JSP_Pages/Page_Message.jsp";
            request.setAttribute( "message", message );
            
        } else if (act.equals("GoToCartegorie")){
            GoTOCategorie(request,response); 
            request.setAttribute( "message", message );
        }
        
        else if (act.equals("FromCategorie")){
            FromCategorie(request,response); 
            request.setAttribute( "message", message );
        }
        
        else if (act.equals("GoToCreationDirecteurMagasin")){
            GoTOCreationDirecteurMagasin(request,response); 
            request.setAttribute( "message", message );
        }
        
        else if (act.equals("FromDirectionMagasin")){
            FromCreationDirecteurMagasin(request,response); 
            request.setAttribute( "message", message );
        }
         else if (act.equals("GoToMagasin")){
            GoTOCreationMagasin(request,response); 
            request.setAttribute( "message", message );
        }
        
        else if (act.equals("FromMagasin")){
            FromCreationMagasin(request,response); 
            request.setAttribute( "message", message );
        }
        
        else if (act.equals("GoToPromotion")){
            GoTOCreationPromotion(request,response); 
            request.setAttribute( "message", message );
        }
        
         else if (act.equals("FromPromotion")){
            FromCreationPromotion(request,response); 
            request.setAttribute( "message", message );
        }
        
         else if (act.equals("GoToCreationBonCommande")){
            GoToGoToCreationBonCommande(request,response); 
            request.setAttribute( "message", message );
        }
        
        else if (act.equals("FromBonCommande")){
            FromCreationBonCommande(request,response); 
            request.setAttribute( "message", message );
        }
        
        else if (act.equals("GoToConsulterLvraison")){
            GoToConsulterLvraison(request,response); 
            request.setAttribute( "message", message );
        }
                
         else if (act.equals("FromConsulterLivraison")){
            FromConsulterLvraison(request,response); 
            request.setAttribute( "message", message );
        }
                
        else if (act.equals("FromLivraisonDetail")){
            FromLivraisonDetail(request,response); 
            request.setAttribute( "message", message );
        }
        else if (act.equals("GOTOCreerLivraison")){
            GoTOLivraison(request,response); 
            request.setAttribute( "message", message );
        }
        else if (act.equals("FromCreerLivraison")){
            FromLivraison(request,response); 
            request.setAttribute( "message", message );
        }  
                
        else if (act.equals("CreerArticle")){
            GoTOArticle(request,response); 
            request.setAttribute( "message", message );
        }
        
        else if (act.equals("FromCreerArticle")){
            doActionCreerA(request,response); 
            request.setAttribute( "message", message );
        }
        
        
      }
    }
    
            
protected void DirectionNational(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
    requete = null;
    mesParam = new ArrayList<Parametre>();
    String employe = null; 
    try{
        employe = request.getParameter( "employe" );
        //Construire requete SQL
         requete = Requete.getRoles + " AND r.nom =:nom";
         Parametre p = new Parametre("nom", "String", DirNAT);
         mesParam.add(p);
         List<Role> listRole = administration.getRoles(requete, mesParam);
         Role role = (Role)Aide.getObjectDeListe(listRole.toArray());
         if (role != null){
                if (!employe.isEmpty()){
                    mesParam = new ArrayList<Parametre>();
                    Integer idEmp = Integer.parseInt(employe);
                    p = new Parametre("id","int",idEmp);
                    requete = Requete.getEmployes + " AND e.id =:id"; 
                    mesParam.add(p);
                    List<Employe> listeEmp = administration.getEmploye(Requete.getEmployes, mesParam);
                    Employe emp = (Employe)Aide.getObjectDeListe(listeEmp.toArray());
                    if (emp !=null)
                    {
                        
                        administration.employeModifierRole(emp,role);  
                        message = "Employe Modifié";
             
                     }else message = "Employe n'existe pas";
                }else{

                String nom     = request.getParameter( "nom" );
                String prenom  = request.getParameter( "prenom" );
                String adresse = request.getParameter( "adresse" );
                String tel     = request.getParameter( "telephone" );
                String email   = request.getParameter( "email" );
                String login   = Aide.GenererLogin(nom,prenom);
                String mdp     = Aide.encrypterMdp(Aide.GenererMDP());
                administration.creerEmployee(nom, prenom, adresse,tel, email,login,mdp,role, null);
               //Aide.envoyerEmail(email);  il faut envoyer l'email 
               message = "Employe est créé";
                    
            }
     }else message = "Role Direction National n'existe pas";
    
}catch(Exception exe){
    message = exe.getMessage();}

}  

protected void DoActPageDirectionNational(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
   
    try{
        //Construire requete SQL        
              requete = Requete.getEmployes;
              List<Employe> listeEmp = administration.getEmploye(requete, null);
              if (listeEmp == null){
              listeEmp = new ArrayList<Employe>(); 
              }
              request.setAttribute( "employes", listeEmp );
              jspClient = "/JSP_Pages/DirectionNational.jsp";
}catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/JSP_Pages/Page_Message.jsp";
}

} 


protected void GoTOCategorie(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
   
    try{
        //Construire requete SQL        
              requete = Requete.getCategories;
              List<Categorie> listeCat = administration.getCategories(requete, null);
              if (listeCat == null){
              listeCat = new ArrayList<Categorie>(); 
              }
              request.setAttribute( "categories", listeCat );
              jspClient = "/JSP_Pages/PageCategorie.jsp";
              message = "";
}catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/JSP_Pages/Page_Message.jsp";
}

} 

protected void FromCategorie(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
   mesParam = new ArrayList<Parametre>();
    try{
        //Construire requete SQL 
              String Nouveaucategory = request.getParameter( "Categorienom" );
              String category = request.getParameter( "CategorieSelect" );
              String souscategoryLibelle = request.getParameter( "souscatnom" );
              if (Nouveaucategory.isEmpty()){
                Integer catID = Integer.parseInt(category);
                requete = Requete.getCategories + " And c.id=:id";
                Parametre p = new Parametre("id", "int", catID);
                mesParam.add(p);
                List<Categorie> listeCat = administration.getCategories(requete, mesParam);
                if (listeCat != null){
                    Categorie cat = (Categorie)Aide.getObjectDeListe(listeCat.toArray());
                    if (!souscategoryLibelle.isEmpty()){
                        administration.creerSousCategorie(souscategoryLibelle, cat);
                    }

                    message = "Categorie est créé";
                    jspClient = "/JSP_Pages/PageCategorie.jsp";
                    mesParam = new ArrayList<Parametre>();
                     requete = Requete.getCategories;
                    listeCat = administration.getCategories(requete, null);
                    if (listeCat == null){
                    listeCat = new ArrayList<Categorie>(); 
                    }
                    request.setAttribute( "categories", listeCat );
                    
                    
                }else  {message = "Categorie n'existe pas";
                     jspClient = "/JSP_Pages/Page_Message.jsp";
                }
               //nouveau categorie
              }else {
                 
                 administration.creerCategorie(Nouveaucategory);
                 requete = Requete.getCategories + " And c.libelle=:libelle";
                 mesParam = new ArrayList<Parametre>();
                Parametre p = new Parametre("libelle", "String", Nouveaucategory);
                mesParam.add(p);
                List<Categorie> listeCat = administration.getCategories(requete, mesParam);
                if (listeCat != null){
                    Categorie cat = (Categorie)Aide.getObjectDeListe(listeCat.toArray());
                    if (!souscategoryLibelle.isEmpty()){
                        administration.creerSousCategorie(souscategoryLibelle, cat);
                    }
                    message = "Categorie est créé";
                    jspClient = "/JSP_Pages/PageCategorie.jsp";
                     mesParam = new ArrayList<Parametre>();
                     requete = Requete.getCategories;
                    listeCat = administration.getCategories(requete, null);
                    if (listeCat == null){
                    listeCat = new ArrayList<Categorie>(); 
                    }
                    request.setAttribute( "categories", listeCat );
                }
            }
             
              
              
    }catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/JSP_Pages/Page_Message.jsp";
}

}

protected void GoTOCreationDirecteurMagasin(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
   
    try{
        //Construire requete SQL        
              requete = Requete.getEmployes+" and e.magasin is not null";
              List<Employe> listeEmps = administration.getEmploye(requete, null);
              if (listeEmps == null){
              listeEmps = new ArrayList<Employe>(); 
              }
              request.setAttribute( "mesEmployes", listeEmps );
              requete = Requete.getMagasins;
              List<Magasin> listeMags = administration.getMagasins(requete, null);
              if (listeMags == null){
              listeMags = new ArrayList<Magasin>(); 
              }
              request.setAttribute( "magasins", listeMags );
              
              jspClient = "/JSP_Pages/CreationDirecteurMagasin.jsp";
              message = "";
}catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/JSP_Pages/Page_Message.jsp";
}

}


//////////////////////////////////////////////////////////////////////////////////////////////////////////


            
protected void FromCreationDirecteurMagasin(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
    requete = null;
    mesParam = new ArrayList<Parametre>();
    String employe = null; 
    try{
        employe = request.getParameter( "employe" );
        //Construire requete SQL
         requete = Requete.getRoles + " AND r.nom =:nom";
         Parametre p = new Parametre("nom", "String", DirMag);
         mesParam.add(p);
         List<Role> listRole = administration.getRoles(requete, mesParam);
         Role role = (Role)Aide.getObjectDeListe(listRole.toArray());
         if (role != null){
                if (!employe.isEmpty()){
                    mesParam = new ArrayList<Parametre>();
                    Integer idEmp = Integer.parseInt(employe);
                    p = new Parametre("id","int",idEmp);
                    requete = Requete.getEmployes + " AND e.id =:id"; 
                    mesParam.add(p);
                    List<Employe> listeEmp = administration.getEmploye(Requete.getEmployes, mesParam);
                    Employe emp = (Employe)Aide.getObjectDeListe(listeEmp.toArray());
                    if (emp !=null)
                    {
                        
                        administration.employeModifierRole(emp,role);  
                        message = "Employe Modifié";
                        jspClient = "/JSP_Pages/Page_Message.jsp";
                     }else {message = "Employe n'existe pas";
                            jspClient = "/JSP_Pages/Page_Message.jsp";
                    }
                }else{
                
                
                String magasin     = request.getParameter( "magasinselect" );
                if (!magasin.isEmpty()){
                    Integer magID =  Integer.parseInt(magasin);
                    requete = Requete.getMagasins+" and m.id=:id";
                    mesParam = new ArrayList<Parametre>();
                    p = new Parametre("id", "int", magID);
                    mesParam.add(p);
                    List<Magasin> listeMags = administration.getMagasins(requete, mesParam);
                    if (listeMags !=null){
                        Magasin ma = (Magasin)Aide.getObjectDeListe(listeMags.toArray());
                        String nom     = request.getParameter( "nom" );
                        String prenom  = request.getParameter( "prenom" );
                        String adresse = request.getParameter( "adresse" );
                        String tel     = request.getParameter( "telephone" );
                        String email   = request.getParameter( "email" );
                        String login   = Aide.GenererLogin(nom,prenom);
                      
                        String mdp     = Aide.GenererMDP();
                        //Aide.envoyerEmail(email,mdp);  il faut envoyer l'email
                        String EncryptedMdp = Aide.encrypterMdp(mdp);
                        administration.creerEmployee(nom, prenom, adresse,tel, email,login,EncryptedMdp,role, ma);
                        
                       message = "Employe est créé";
                       jspClient = "/JSP_Pages/Page_Message.jsp";
                   }else {message = "magasin n'existe pas";
                            jspClient = "/JSP_Pages/Page_Message.jsp";
                    }
                }else {
                    jspClient = "/JSP_Pages/Page_Message.jsp";
                    message = "il faut choisir magasin";}
                    
            }
     }else {
             jspClient = "/JSP_Pages/Page_Message.jsp";
             message = "Role "+DirMag+" n'existe pas";}
    
}catch(Exception exe){
    message = exe.getMessage();}

} 
   
    ////////////////////////////////////////////////////////////////////////////////////////////////////

protected void GoTOCreationMagasin(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
    
    try{
        //Construire requete SQL        
              
              requete = Requete.getMagasins;
              List<Magasin> listeMags = administration.getMagasins(requete, null);
              if (listeMags == null){
              listeMags = new ArrayList<Magasin>(); 
              }
              request.setAttribute( "magasins", listeMags );
              
              jspClient = "/JSP_Pages/CreationMagasin.jsp";
              message = "";
}catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/JSP_Pages/Page_Message.jsp";
}

}


protected void FromCreationMagasin(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
   mesParam = new ArrayList<Parametre>();
    try{
        //Construire requete SQL        
              String magasin     = request.getParameter( "magasinselect" );
              String nom         = request.getParameter( "nom" );
              String adresse         = request.getParameter( "adresse" );
              String ville         = request.getParameter( "ville" );
              String code         = request.getParameter( "code" );
              String ho       = request.getParameter( "ho" );
              String hf       = request.getParameter( "hf" );
              String gps       = request.getParameter( "gps" );
              if (!magasin.isEmpty()){
                  if (!magasin.equals("0")){
                      Integer magID =  Integer.parseInt(magasin);
                      Parametre p = new Parametre("id", "int", magID);
                      mesParam.add(p);
                      requete = Requete.getMagasins+" and m.id=:id";
                      List<Magasin> listeMags = administration.getMagasins(requete, mesParam);
                    if (listeMags !=null){
                        Magasin ma = (Magasin)Aide.getObjectDeListe(listeMags.toArray());
                        administration.modifierMagasin(nom, adresse, ville, code, ho, hf, gps, ma);
                        message = "Magasin est modifié";
                    }
                  }else {
                      administration.creerMagasin(adresse, nom, code, ville, ho, hf, gps);
                      message = "Magasin est créé";
                   }
                  
              }else message = "magasin n'existe pas";
              jspClient = "/JSP_Pages/Page_Message.jsp";
              
}catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/JSP_Pages/Page_Message.jsp";
}

}


protected void GoTOCreationPromotion(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
    
    try{
        //Construire requete SQL        
              
              requete = Requete.getArticles;
              List<Article> listeArts = administration.getArticle(requete, null);
              if (listeArts == null){
              listeArts = new ArrayList<Article>(); 
              }
              request.setAttribute( "articles", listeArts );
              
              requete = Requete.getPromotions;
              List<Promotion> listePrs = administration.getPromotions(requete, null);
              if (listePrs == null){
              listePrs = new ArrayList<Promotion>(); 
              }
              request.setAttribute( "promotions", listePrs );
              
              jspClient = "/JSP_Pages/CreerPromotion.jsp";
              message = "";
}catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/JSP_Pages/Page_Message.jsp";
}

}


protected void FromCreationPromotion(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
   mesParam = new ArrayList<Parametre>();
    try{
        //Construire requete SQL        
              String promo     = request.getParameter( "promo" );
              String Articleselect         = request.getParameter( "Articleselect" );
              String datedeb         = request.getParameter( "datedeb" );
              String datefin         = request.getParameter( "datefin" );
              String prixpromo         = request.getParameter( "prixpromo" );
             
              if (!Articleselect.isEmpty()){
                  if (!Articleselect.equals("0")){
                      Date dated = java.sql.Date.valueOf(datedeb);
                      Date datef = java.sql.Date.valueOf(datefin);
                      float prix = Float.parseFloat(prixpromo);
                      Integer artId =  Integer.parseInt(Articleselect);
                      Parametre p = new Parametre("id", "int", artId);
                      mesParam.add(p);
                      requete = Requete.getArticles+" and a.id=:id";
                      List<Article> listearts = administration.getArticle(requete, mesParam);
                    if (listearts !=null){
                        Article article = (Article)Aide.getObjectDeListe(listearts.toArray());
                        //Employe monEmp = (Employe) session.getAttribute("session");
                        //Employe monEmp = null;
                        if (!promo.isEmpty()){ //modifier promotion
                          mesParam = new ArrayList<Parametre>(); 
                          Integer proID =  Integer.parseInt(promo);
                          p = new Parametre("id", "int", proID);
                          mesParam.add(p);
                          requete = Requete.getPromotions+" and p.id=:id";
                          List<Promotion> listpro = administration.getPromotions(requete, mesParam);
                                if (listpro !=null){
                                   Promotion pro = (Promotion)Aide.getObjectDeListe(listpro.toArray());
                                   administration.modifierPromotion(dated, datef, prix, employeConnecte, article, pro);
                                   message = "Promotion est moifié";
                                }
                            
                        }else { //nouveau promotion
                                administration.creerPromotion(dated, datef, prix, employeConnecte, article);
                                message = "Promotion est créé";
                        }
                    }
                  }else {
                      
                      message = "Article n'existe pas";
                   }
                  
              }else message = "il faut choisir un article";
              jspClient = "/JSP_Pages/Page_Message.jsp";
              
}catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/JSP_Pages/Page_Message.jsp";
}

}

protected void GoToGoToCreationBonCommande(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
    
    try{
        //Construire requete SQL        
              
              requete = Requete.getFournisseurs;
              List<Fournisseur> listeFor = administration.getFournisseur(requete, null);
              if (listeFor == null){
              listeFor = new ArrayList<Fournisseur>(); 
              }
              request.setAttribute( "fournisseurs", listeFor );

              jspClient = "/JSP_Pages/CreateBonCommande.jsp";
              message = "";
}catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/JSP_Pages/Page_Message.jsp";
}

}



protected void FromCreationBonCommande(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
    mesParam = new ArrayList<Parametre>();
    try{
        //Construire requete SQL        
              String  lignes = request.getParameter("lignes");
              String fourni  = request.getParameter("FourniSelect");
              Integer forId =  Integer.parseInt(fourni);
                      Parametre p = new Parametre("id", "int", forId);
                      mesParam.add(p);
                      requete = Requete.getFournisseurs+" and f.id=:id";
                      List<Article> listearts = administration.getArticle(requete, mesParam);
                    if (listearts !=null){
                        Fournisseur fournisseur = (Fournisseur)Aide.getObjectDeListe(listearts.toArray());
                        BonCommande monCommande = administration.creerBonCommande(employeConnecte, new Date(), fournisseur, null, null);
                        if (!lignes.isEmpty()){
                            List<LigneCommande> commandeLignes = ParserLignesCommandes(lignes,monCommande);
                             message = "BonCommande est bien créé";
                        }
                    }
              
              jspClient = "/JSP_Pages/Page_Message.jsp";
             
}catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/JSP_Pages/Page_Message.jsp";
}

}

//////////////////////////////////////////////////////////////////////////////////////////////////////////

public  List<LigneCommande> ParserLignesCommandes(String input,BonCommande com){
         List<LigneCommande> lignes = new ArrayList<LigneCommande>();
         mesParam = new ArrayList<Parametre>();
         try{
            String [] temp  = input.split(",");
            int count = 0;
            int quantite = 0;
            float prix = 0;
            Article art = null;
            LigneCommande l = new LigneCommande();
            for (int i=0;i<temp.length;i++){
                if ((i)%5==0 || i==0){
                    count = 1;
                }
                if(count==1){
                    
                    Integer articleID = Integer.parseInt(temp[i]);
                    Parametre p = new Parametre("id", "int", articleID);
                      mesParam.add(p);
                      String requete = Requete.getArticles+" and a.id=:id";
                      List<Article> listearts = administration.getArticle(requete, mesParam);
                    if (listearts !=null){
                        art = (Article)Aide.getObjectDeListe(listearts.toArray());
                    }
                }
                else if (count==3){
                       prix = Float.parseFloat(temp[i]); 
                 }else if (count==4){
                       quantite = Integer.parseInt(temp[i]);
                 }else if (count==5){
                        //creerLigneCommande
                        if (com !=null && art !=null){
                            administration.creerLigneCommande(com, art, quantite, prix);
                        }else{ message = "article n'exite pas";
                            break;
                        }
                  }
                 count++;   
                
            }
         }catch(Exception exe){message = exe.getMessage();
            jspClient = "/JSP_Pages/Page_Message.jsp";
         }
         return lignes;
     }


//////////////////////////////////////////////////////////////////////////////////////////////
protected void GoToConsulterLvraison(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
    mesParam = new ArrayList<Parametre>();
    try{
        //Construire requete SQL        
              Integer magasinId = Integer.parseInt(""+employeConnecte.getMagasin().getId());
              requete = Requete.getLivraisonParMagasin + " and m.id = ?1 and ( l.mention = ?2 or  l.mention = ?3)";
              Parametre p = new Parametre("1", "long", employeConnecte.getMagasin().getId());
              mesParam.add(p);
              p = new Parametre("2", "Etat_livraison", Etat_Livraison.ENCOURS);
              mesParam.add(p);
              p = new Parametre("3", "Etat_livraison", Etat_Livraison.RECEPTIONNE);
              mesParam.add(p);
              List<Livraison> listelivs = administration.getLivraisons(requete, mesParam);
              if (listelivs == null){
              listelivs = new ArrayList<Livraison>(); 
              }
              request.setAttribute( "livraisons", listelivs );

              jspClient = "/JSP_Pages/ConsulterCommandesLivraison.jsp";
              message = "";
}catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/JSP_Pages/Page_Message.jsp";
}

}


//////////////////////////////////////////////////////////////////////////////////////

protected void FromConsulterLvraison(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
    mesParam = new ArrayList<Parametre>();
    try{
        //Construire requete SQL 
              String livraison = request.getParameter("livraison");
              if (!livraison.isEmpty()){
                    Integer livID = Integer.parseInt(livraison);
                    requete = Requete.getLivraisons + " and l.id =:id";
                    Parametre p = new Parametre("id", "int", livID);
                    mesParam.add(p);
                    List<Livraison> listelivs = administration.getLivraisons(requete, mesParam);
                    if (listelivs!=null){
                        Livraison liv = (Livraison)Aide.getObjectDeListe(listelivs.toArray());
                        administration.modifierLivraison(new Date(), Etat_Livraison.RECEPTIONNE, liv,employeConnecte);
                        request.setAttribute( "livraison", liv );
                        jspClient = "/JSP_Pages/LivraisonDetail.jsp";
                    }
              }else {
                message = "il y pas de livraison";
                 jspClient = "/JSP_Pages/Page_Message.jsp";
              }
             
             
              message = "";
}catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/JSP_Pages/Page_Message.jsp";
}

}



protected void FromLivraisonDetail(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
    mesParam = new ArrayList<Parametre>();
    try{
        //Construire requete SQL 
              String ligneslivraison = request.getParameter("livlignes");
              if (!ligneslivraison.isEmpty()){
                        ParserLignesLivraison(ligneslivraison);
                        jspClient = "/JSP_Pages/Page_Message.jsp";
                    }
              else {
                message = "il y pas de ligne de livraison";
                 jspClient = "/JSP_Pages/Page_Message.jsp";
              }
             
             
              message = "";
}catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/JSP_Pages/Page_Message.jsp";
}

}


//////////////////////////////////////////////////////////////////////////////////////////


public  void ParserLignesLivraison(String input){
         
         mesParam = new ArrayList<Parametre>();
         try{
            String [] temp  = input.split(",");
            int count = 0;
            int quantiteAccepte = 0;
            String reclamationType = "";
            String rec = "";
            Ligne_livraison ligne = null;
            Ligne_livraison l = new Ligne_livraison();
            for (int i=0;i<temp.length;i++){
                if ((i)%4==0 || i==0){
                    count = 1;
                    reclamationType = "";
                    rec = "";
                }
                if(count==1){
                    
                    Integer ligneID = Integer.parseInt(temp[i]);
                    Parametre p = new Parametre("id", "int", ligneID);
                      mesParam.add(p);
                      String requete = Requete.getLigneLivraisons+" and l.id=:id";
                      List<Ligne_livraison> listelignes = administration.getLignesLivraison(requete, mesParam);
                    if (listelignes !=null){
                        ligne = (Ligne_livraison)Aide.getObjectDeListe(listelignes.toArray());
                    }
                }
                else if (count==4){
                       quantiteAccepte = Integer.parseInt(temp[i]); 
                       administration.modifierLigneLivraison(ligne, quantiteAccepte);
                       //Article magasin treatement
                       mesParam = new ArrayList<Parametre>();
                       Parametre p = new Parametre("article", "Article", ligne.getArticle());
                       mesParam.add(p);
                       requete = Requete.getArticleMagasin+" and a.article=:article";
                       List<ArticleMagasin> listeArts = administration.getArticleMagasin(requete, mesParam);
                       ArticleMagasin artMag = null;
                       if (listeArts !=null){
                           artMag = (ArticleMagasin)Aide.getObjectDeListe(listeArts.toArray());
                           administration.ajouterQuantite(artMag, quantiteAccepte);
                       }else{
                           artMag = administration.creerArticleMag(quantiteAccepte, 0.0f, ligne.getArticle(), employeConnecte.getMagasin());
                       }
                       //Lot tratement
                       if(ligne.getDate_de_peremption()!=null){
                           
                           //verifer si lot existe deja 
                           mesParam = new ArrayList<Parametre>();
                           p = new Parametre("articleMagasin", "ArticleMagasin", artMag);
                           mesParam.add(p);
                           p = new Parametre("date_de_peremption", "Date", ligne.getDate_de_peremption());
                           mesParam.add(p);
                           requete = Requete.getLots+" and l.articleMagasin=:articleMagasin and l.date_de_peremption=:date_de_peremption";
                            List<Lot> lots = administration.getLots(requete, mesParam);
                            Lot lot = null;
                            if (lots !=null){
                                lot = (Lot)Aide.getObjectDeListe(lots.toArray());
                                administration.ajouterQuantiteLot(lot, quantiteAccepte);
                                
                            }else  administration.creerLot(ligne.getDate_de_peremption(), quantiteAccepte, artMag);
                            
                            
                           
                       }
                       
                        if (!rec.isEmpty() && !reclamationType.isEmpty()){
                            switch(reclamationType){
                                case "RECLAMATION_LIVRAISON":
                                    administration.creerReclamation(rec, Type_Reclamation.RECLAMATION_LIVRAISON, ligne, new Date());
                                    break;
                                case "RECLAMATION_COMMANDE":
                                    administration.creerReclamation(rec, Type_Reclamation.RECLAMATION_COMMANDE, ligne, new Date());
                                    break;
                                    
                                case "RECLAMATION_QUALITE":
                                    administration.creerReclamation(rec, Type_Reclamation.RECLAMATION_QUALITE, ligne, new Date());
                                    break;
                            
                            }
                            administration.modifierEtat(ligne.getLivraison(),Etat_Livraison.EN_RECLAMATION);
                        }
                    
                    message = "Livraison est bien traité";
                       
                 }else if (count==3){
                     if (!temp[i].isEmpty())
                       rec = temp[i];
                 }else if (count==2){
                        //creerLigneCommande
                        if (!temp[i].isEmpty())
                           reclamationType =  temp[i];
                        
                       
                  }
                 count++;   
                
            }
         }catch(Exception exe){message = exe.getMessage();
            jspClient = "/JSP_Pages/Page_Message.jsp";
         }
        
     }



protected void GoTOLivraison(HttpServletRequest request, HttpServletResponse response) 
              throws ServletException, IOException
      {
             HttpSession sess=request.getSession(true);
          
          try{

             // Fournisseur fourCo = (Fournisseur) sess.getAttribute("FourCo");
              //long fourID = fourCo.getId();
              requete=Requete.getCommandesParFournisseurLivr + " And f.id=:id";
              mesParam= new ArrayList<Parametre>();
              Parametre c = new Parametre("id", "long", 1);
              mesParam.add(c);
              List<BonCommande> listec=administration.getBonCommande(requete, mesParam);
              if (listec == null){
              listec = new ArrayList<>(); 
              }
              request.setAttribute( "commandes", listec );
              jspClient="/JSP_Pages/creerLivrasionNawar.jsp";
              message = "";
            }catch(Exception exe){
             message = exe.getMessage();
            jspClient = "/JSP_Pages/Page_message.jsp";
            }

     } 


    protected void FromLivraison(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException
    {
        mesParam = new ArrayList<Parametre>();
        try{
            //Construire requete SQL 
                  String ligneslivraison = request.getParameter("ligneLivraisonQte");
                  if (!ligneslivraison.isEmpty()){
                            String DatePrevu = request.getParameter("date_pr");
                            String bon = request.getParameter("bonCommande");
                            mesParam = new ArrayList<Parametre>();
                            Parametre p = new Parametre("id", "int", bon);
                            mesParam.add(p);
                            requete = Requete.getBonCommandes+" and b.id=:id";
                            List<BonCommande> listebons = administration.getBonCommande(requete, mesParam);
                            
                            if (listebons !=null){
                                BonCommande bonCom = (BonCommande)Aide.getObjectDeListe(listebons.toArray());
                                Date date = java.sql.Date.valueOf(DatePrevu);
                                Livraison liv = administration.creerLivraison(null, date, fournisseurConnecte, bonCom, Etat_Livraison.ENCOURS);
                                ParserLigneCommandeVersLignesLivraison(ligneslivraison,liv);
                           
                            }else message = "Bon Commande n'existe pas ";
                            
                            jspClient = "/JSP_Pages/Page_Message.jsp";
                        }
                  else {
                    message = "il y pas de ligne de livraison";
                     jspClient = "/JSP_Pages/Page_Message.jsp";
                  }


                  message = "";
    }catch(Exception exe){
        message = exe.getMessage();
        jspClient = "/JSP_Pages/Page_Message.jsp";
    }

}


public  void ParserLigneCommandeVersLignesLivraison(String input,Livraison liv){
         
         mesParam = new ArrayList<Parametre>();
         try{
            String [] temp  = input.split(",");
            int count = 0;
            int quantiteLivree = 0;
            Date datePermertion = null;
            Article art = null;
            BonCommande bon = null;
            
            for (int i=0;i<temp.length;i++){
                if ((i)%4==0 || i==0){
                    count = 1;
                    art = null;
                    quantiteLivree = 0;
                    
                }
                if (count==2){
                       Integer artID = Integer.parseInt(temp[i]); 
                       
                       mesParam = new ArrayList<Parametre>();
                       Parametre p = new Parametre("id", "int", artID);
                       mesParam.add(p);
                       requete = Requete.getArticles+" and a.id=:id";
                       List<Article> listeArts = administration.getArticle(requete, mesParam);
                       
                       if (listeArts !=null){
                           art = (Article)Aide.getObjectDeListe(listeArts.toArray());
                      
                       }else message = "un article n'existe pas";
                }else if (count==3){
                    quantiteLivree =   Integer.parseInt(temp[i]); 
                
                }
                else if (count==4){
                    if (!temp[i].isEmpty()){
                        datePermertion = java.sql.Date.valueOf(temp[i]);
                    }
                   administration.creerLigneLivraison(quantiteLivree, 0, art, liv, datePermertion);
                   
                }
 
                 count++;   
                
            }
            if (!message.isEmpty()){
                message = "livraison est créé";
            }
         }catch(Exception exe){message = exe.getMessage();
            jspClient = "/JSP_Pages/Page_Message.jsp";
         }
        
     }

    
    
///////////////////////////////////////////////////ISA///////////////////////////////////////////

     protected void creerEmployeMagasin(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
   HttpSession sess=request.getSession(true);
    try{
        Employe employeCo = (Employe) sess.getAttribute("employeCo");
        mesParam = new ArrayList<Parametre>();
        Parametre p = null;
                String nom     = request.getParameter( "nom" );
                String prenom  = request.getParameter( "prenom" );
                String adresse = request.getParameter( "adresse" );
                String tel     = request.getParameter( "telephone" );
                String email   = request.getParameter( "email" );
                String title    = request.getParameter("role");
                String[] categories = request.getParameterValues("categorie");
                Magasin mag = employeCo.getMagasin();
                
                List<Categorie> listCat = new ArrayList<>();
                listCat.clear();
                if (categories != null)
                {
                    List<String> listIdCat = new ArrayList<>();
                           listIdCat =  Arrays.asList(categories); 
                    for (String element : listIdCat)
                    {
                    Integer i = Integer.parseInt(element);
                    p = new Parametre("idcat", "int", i);
                    mesParam.add(p); 
                    List<Categorie> listResult = new ArrayList<>();
                           listResult = administration.getCategories(Requete.getCategories+" AND c.id = :idcat", mesParam);
                    Categorie result = (Categorie)Aide.getObjectDeListe(listResult.toArray());
                    listCat.add(result);
                    }
                }
               mesParam.clear();
               String nomRole = Aide.aTitletoRoleName(title);
               p = new Parametre("nom","String", nomRole);
               mesParam.add(p);
               String requeteRole = Requete.getRoles+" AND r.nom = :nom";
               List<Role> resultInList = administration.getRoles(requeteRole, mesParam);
               Role roleEmploye =(Role)Aide.getObjectDeListe(resultInList.toArray());
                                      
                String login   = Aide.GenererLogin(nom,prenom);
                String mdp     = Aide.encrypterMdp(Aide.GenererMDP());
                administration.creerEmployeMagasin(nom, prenom, adresse, tel, email, login, mdp, roleEmploye ,mag, listCat);
               //Aide.envoyerEmail(email);  il faut envoyer l'email 
               message = "Employe est créé";
               sess.setAttribute("employeCo", employeCo);
               jspClient = "/JSP_Isa/MenuDirecteurMagasin.jsp";
                         
    }catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/JSP_Pages/Page_Message.jsp";
}

}
     //////////////////////////////////////////////////////////////////////////////
      protected void chargerPageCreationEmployeMagasin(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
   HttpSession sess=request.getSession(true);
    try{
            mesParam = new ArrayList<Parametre>();
            Parametre p = null;
             Employe employeCo = (Employe) sess.getAttribute("employeCo");
              List<Categorie> listCat = administration.getCategories(Requete.getCategories, null) ;
              p = new Parametre("dirmag", "String", DirMag);
              mesParam.add(p);
              p = new Parametre("dirnat", "String", DirNAT);
              mesParam.add(p);
              List<Role> listRoles = administration.getRoles(Requete.getRoles+" AND r.nom <> :dirmag AND r.nom <> :dirnat", mesParam);
           
            List<String> listTitles = Aide.rolesToTitles(listRoles);
            jspClient = "/JSP_Isa/CreationEmployeMagasin.jsp";
            request.setAttribute( "listCategorie", listCat );
            request.setAttribute("listTitres", listTitles);
            sess.setAttribute("employeCo", employeCo); 
            message = "";
            
                        
    }catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/JSP_Pages/Page_Message.jsp";
}

}
      ////////////////////////////////////////////////////////////////////////////
      protected void chargerPageConsultationCommandes(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
        try {
            HttpSession sess=request.getSession(true);
            mesParam = new ArrayList<Parametre>();
            Parametre p = null;
            Employe employeCo = (Employe) sess.getAttribute("employeCo");
            Magasin mag = employeCo.getMagasin();
            p = new Parametre("1", "long", mag.getId());
            mesParam.add(p);
            List<BonCommande> listeCommandes = administration.getBonCommande(Requete.getCommandesParMagasin+ " AND m.id = ?1 ", mesParam);
            
            jspClient = "/JSP_Isa/ConsulterCommandes.jsp"; 
            sess.setAttribute("employeCo", employeCo);
            request.setAttribute("listCommandes", listeCommandes);
            message = "";
        } catch (Exception exe) {
            message = exe.getMessage();
            jspClient = "/JSP_Pages/Page_Message.jsp";   
        }

   
    
}
//////////////////////////////////////////////////////////////////////////////////
         protected void afficherDetailCommande(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
        try {
            HttpSession sess=request.getSession(true);
            Employe employeCo = (Employe) sess.getAttribute("employeCo");
            String[] idCommandes= request.getParameterValues( "idCommande" );
            List<String> listIdCat = new ArrayList<>();
            listIdCat =  Arrays.asList(idCommandes);
            if(listIdCat.size()==1)
            {
            String idCommande= listIdCat.get(0);
            
            mesParam = new ArrayList<Parametre>();
            Parametre p = null;
            Integer i = Integer.parseInt(idCommande);
            p= new Parametre("id", "int", i);
            mesParam.add(p);
            
            List<BonCommande> listeCommandes = administration.getBonCommande(Requete.getCommandes+" AND b.id = :id", mesParam);
            BonCommande commande = (BonCommande)Aide.getObjectDeListe(listeCommandes.toArray());
            
            
            jspClient = "/JSP_Isa/AffichageDetailCommande.jsp"; 
            sess.setAttribute("employeCo", employeCo);
            request.setAttribute("commande", commande);
            message = "";
            }
        } catch (Exception exe) {
            message = exe.getMessage();
            jspClient = "/JSP_Pages/Page_Message.jsp";   
        }

   
    
}
//////////////////////////////////////////////////////////////////////////////////
         protected void afficherDetailLivraison(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
        try {
            HttpSession sess=request.getSession(true);
            Employe employeCo = (Employe) sess.getAttribute("employeCo");
            String[] idLivraisons= request.getParameterValues( "idLivraison" );
            List<String> listIdLivraison = new ArrayList<>();
            listIdLivraison =  Arrays.asList(idLivraisons);
            if(listIdLivraison.size()==1)
            {
            String idLivraison= listIdLivraison.get(0);
            
            mesParam = new ArrayList<Parametre>();
            Parametre p = null;
            Integer i = Integer.parseInt(idLivraison);
            p= new Parametre("id", "int", i);
            mesParam.add(p);
            
            List<BonCommande> listeLivraisons = administration.getBonCommande(Requete.getLivraisons+" AND l.id = :id", mesParam);
            Livraison livraison = (Livraison)Aide.getObjectDeListe(listeLivraisons.toArray());
            
            
            jspClient = "/JSP_Isa/AfficherDetailLivraison.jsp"; 
            sess.setAttribute("employeCo", employeCo);
            request.setAttribute("livraison", livraison);
            message = "";
            }
        } catch (Exception exe) {
            message = exe.getMessage();
            jspClient = "/JSP_Pages/Page_Message.jsp";   
        }

   
    
}
         ////////////////////////////////////////////////////////////////////////////
      protected void chargerPageConsultationLivraisons(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
        try {
            HttpSession sess=request.getSession(true);
            mesParam = new ArrayList<Parametre>();
            Parametre p = null;
            Employe employeCo = (Employe) sess.getAttribute("employeCo");
            Magasin mag = employeCo.getMagasin();
            p = new Parametre("1", "long", mag.getId());
            mesParam.add(p);
            List<BonCommande> listeLivraisons = administration.getBonCommande(Requete.getLivraisonsParMagasin+ " AND m.id = ?1 ", mesParam);
            
            jspClient = "/JSP_Isa/ConsulterLivraisons.jsp"; 
            sess.setAttribute("employeCo", employeCo);
            request.setAttribute("listLivraisons", listeLivraisons);
            message = "";
        } catch (Exception exe) {
            message = exe.getMessage();
            jspClient = "/JSP_Pages/Page_Message.jsp";   
        }
}
      /////////////////////////////////////////////////////////////
      /** PARTIE AGENT DE RAYON **/
      /////////////////////////////////////////////////////////////
      protected void creationCasse(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
        try {
            HttpSession sess=request.getSession(true);
            mesParam = new ArrayList<Parametre>();
            Employe employeCo = (Employe) sess.getAttribute("employeCo");
            Parametre p = null;
            /// je récupère les affectations de mon agent de rayon
            List<ChefRyon_Categorie> listeCatEmploye = employeCo.getChefRyon_Categories();
            
            List<Long> idCategories;
            idCategories = new ArrayList<Long>();
            for (ChefRyon_Categorie association : listeCatEmploye)
            {
                Long i = association.getCategorie().getId();
                idCategories.add(i);
            }
            /// je construit ma requete avec les catégories (la taille de la requete dépend du nombre d'affectation de mon employé
            String requeteArticle = Requete.getArticlesMagasinParMagasinCategorie;
            
            
            for (int i = 1; i<= idCategories.size(); i++)
            {
                if(i==1){
                    requeteArticle = requeteArticle + " AND (";
                }
                if(i>1){
                    requeteArticle = requeteArticle+" OR";
                }
                requeteArticle = requeteArticle + " c.id = ?"+i;
                String position = Integer.toString(i);
                p = new Parametre(position,"long",idCategories.get(i-1));
                mesParam.add(p);
                if (i == (idCategories.size()))
                {
                   requeteArticle = requeteArticle + " )" ; 
                }  
            }
            String lastPosition = Integer.toString(idCategories.size()+1);
            requeteArticle = requeteArticle + " AND m.id =?"+lastPosition;
            p = new Parametre(lastPosition,"long",employeCo.getMagasin().getId());
            mesParam.add(p);
            List<ArticleMagasin> listeArticlesMagasin = administration.getArticleMagasin(requeteArticle, mesParam);
            mesParam.clear();
            
            Date d = new Date();
            long time = d.getTime();
            d.setTime((time / 1000) * 1000);
            d.setHours(0);
            d.setMinutes(0);
            d.setSeconds(0);
            
            p = new Parametre("1", "long", employeCo.getId());
            mesParam.add(p);
            p = new Parametre("2", "Date", d);
            mesParam.add(p);
            List<Casse> listeCasses = administration.getCasse(Requete.getCasseParEmploye + " AND a.id = ?1 AND c.date_casse = ?2", mesParam);
            if (listeCasses.isEmpty())
            {
            Casse casse = administration.creerCasse(employeCo, d);
            
            jspClient = "/JSP_Isa/CreationCasse.jsp"; 
            sess.setAttribute("employeCo", employeCo);
            request.setAttribute("listeArticles", listeArticlesMagasin);
            request.setAttribute("casse", casse);
            
            message = "";
            }else
            {
                Casse casse = (Casse)Aide.getObjectDeListe(listeCasses.toArray());
             jspClient = "/JSP_Isa/CreationCasse.jsp"; 
            sess.setAttribute("employeCo", employeCo);
            request.setAttribute("listeArticles", listeArticlesMagasin);
            request.setAttribute("casse", casse);   
            }
        } catch (Exception exe) {
            message = exe.getMessage();
            jspClient = "/JSP_Pages/Page_Message.jsp";   
        }  
}
            /////////////////////////////////////////////////////////////
      protected void finaliserLigneCasse(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
        try {
            HttpSession sess=request.getSession(true);
            String[] articlesMagasin = request.getParameterValues("idArticle" );
            Employe employeCo =(Employe)sess.getAttribute("employeCo");
            String idCasse = request.getParameter("idCasse");
            mesParam = new ArrayList<Parametre>();
            List<String> listIdArticle = new ArrayList<>();
            listIdArticle =  Arrays.asList(articlesMagasin);
            String idArticleMagasin= listIdArticle.get(0);
            
            Integer idArticle = Integer.parseInt(idArticleMagasin); 
            
            Parametre p = new Parametre("1", "int",idArticle);
            mesParam.add(p);
            ArticleMagasin article = (ArticleMagasin)Aide.getObjectDeListe(administration.getArticleMagasin(Requete.getArticleMagasin+ " AND a.id = ?1", mesParam).toArray());
            List<Lot> listeLots = administration.getLots(Requete.getLotParMagasin + " AND a.id = ?1", mesParam);
            mesParam.clear();
            Integer i = Integer.parseInt(idCasse);
            p = new Parametre("1", "long", i);
            mesParam.add(p);
            Casse casse = (Casse)Aide.getObjectDeListe(administration.getCasse(Requete.getCasses+ " AND c.id = ?1", mesParam).toArray());
            jspClient = "/JSP_Isa/CreerLigneCasse.jsp"; 
            
            sess.setAttribute("employeCo", employeCo);
            request.setAttribute("listeLots", listeLots);
            request.setAttribute("casse", casse);
            request.setAttribute("articleMag", article);
            message = "";
        } catch (Exception exe) {
            message = exe.getMessage();
            jspClient = "/JSP_Pages/Page_Message.jsp";   
        }  
}
      
                  /////////////////////////////////////////////////////////////
      protected void enregistrerLigneCasse(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
        try {
            HttpSession sess=request.getSession(true);
            String idLot = request.getParameter( "idLot" );
            Employe employeCo =(Employe)sess.getAttribute("employeCo");
            String idCasse = request.getParameter("idCasse");
            String quantite = request.getParameter("quantite");
            String idArticleMagasin = request.getParameter("idArticleMag");
            message = "";
            Integer q = Integer.parseInt(quantite);
            mesParam = new ArrayList<Parametre>();
            Parametre p = null;
            Lot lot = null;
            
            if (idLot != null)
            {
                Integer i = Integer.parseInt(idLot);
                p = new Parametre("id","long", i);
                mesParam.add(p);
                List<Lot> listeLots = administration.getLots(Requete.getLots+ " AND l.id = :id", mesParam);
                lot = (Lot)Aide.getObjectDeListe(listeLots.toArray());
            }
            mesParam.clear();
            Integer i = Integer.parseInt(idArticleMagasin);
            p = new Parametre("1", "long", i);
            mesParam.add(p);
            ArticleMagasin article = (ArticleMagasin)Aide.getObjectDeListe(administration.getArticleMagasin(Requete.getArticleMagasin+ " AND a.id = ?1", mesParam).toArray());
            mesParam.clear();
            Integer id = Integer.parseInt(idCasse);
            
            p = new Parametre("id", "long", id);
            mesParam.add(p);
            Casse casse = (Casse)Aide.getObjectDeListe(administration.getCasse(Requete.getCasses+ " AND c.id = :id", mesParam).toArray());
            
            administration.creerLigneCasse(lot, article, q, casse);
            creationCasse(request,response);
            request.setAttribute("message", message);   
        } catch (Exception exe) {
            message = exe.getMessage();
            jspClient = "/JSP_Pages/Page_Message.jsp";   
        }  
}






//////////////////////////////////////////////JIHANE///////////////////////////////////////////////////
      
protected void GoTOArticle(HttpServletRequest request, HttpServletResponse response) 
              throws ServletException, IOException
      {
          
          try{
              requete=Requete.getCategories;
              List<Categorie> listeCat = administration.getCategories(requete, null);
              
              if (listeCat == null){
              listeCat = new ArrayList<>(); 
              }
              request.setAttribute( "categories", listeCat );
              String req = "";
              req=Requete.getFournisseurs;
              List<Fournisseur> listeFour = administration.getFournisseur(req, null);
              if (listeFour == null){
              listeFour = new ArrayList<>(); 
              }
              request.setAttribute( "fournisseurs", listeFour );
              jspClient="/Jihane_JSP/CreerArticle.jsp";
              message = "";
}catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/Jihane_JSP/Page_message.jsp";
}
}  


protected void doActionCreerA(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try
       {
           
       String libelle= request.getParameter("libelle");
       String reference = request.getParameter("reference");
       String description=request.getParameter("description");
       String prix=request.getParameter("prix_achat_actuel");
       String souscategory = request.getParameter( "SousCategorieSelect" );
       String fourni= request.getParameter( "FournisseurSelect" );
       String img = request.getParameter( "pic" );
       String type = request.getParameter( "TypeSelect" );
       
       
       if ( libelle.trim().isEmpty() || reference.trim().isEmpty() || prix.trim().isEmpty())
       {
          message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires.";
       } 
       else 
       {
                Integer souscatID= Integer.parseInt(souscategory);
                System.out.println(souscatID);
                Integer fourniID = Integer.parseInt(fourni);
                Float prix_actuel = Float.parseFloat(prix);
                
                //Récupérer la sous-categorie
                mesParam = new ArrayList<Parametre>();
                requete= Requete.getSousCategories + " And s.id=:id";
                Parametre s = new Parametre("id", "int", souscatID);
                mesParam.add(s);
                List<SousCategorie> listeSousCat=administration.getSousCategories(requete, mesParam);
                System.out.println(listeSousCat.size());
                if(listeSousCat==null)
                {
                    listeSousCat= new ArrayList<>();
                }
                //Récupérer le fournisseur
                mesParam = new ArrayList<Parametre>();
                requete=Requete.getFournisseurs + " And f.id=:id";
                Parametre f = new Parametre("id", "int", fourniID);
                mesParam.add(f);
                List<Fournisseur> listeFour=administration.getFournisseur(requete, mesParam);
                if(listeFour==null)
                {
                    listeFour = new ArrayList<>();
                }
                switch (type)
                {
                   case "0":
                   administration.creationProdFrais(libelle, reference, prix_actuel, date, description, listeSousCat.get(0), listeFour.get(0),img);  
                   break;
                   case "1":
                   String taille = request.getParameter("taille");
                   String coloris = request.getParameter("coloris");
                   administration.creationVetement(libelle, reference, prix_actuel, date, description, listeSousCat.get(0), listeFour.get(0),img, taille, coloris);
                   break;
                   case "2": 
                   String garantie = request.getParameter("period_garantie");
                   Integer periode_garantie=Integer.parseInt(garantie);
                   administration.creationElectromenager(libelle, reference, prix_actuel, date, description, listeSousCat.get(0), listeFour.get(0),img,periode_garantie);
                   break;
                   case "3":
                   administration.creationArticle(libelle, reference, prix_actuel, date, description, listeSousCat.get(0), listeFour.get(0),img);
                   break;
                  }
                message = "Article créé avec succès !";  
                jspClient = "/Jihane_JSP/Page_message.jsp";
        }
         }catch(Exception exe){ 
           message = exe.getMessage();
           jspClient = "/Jihane_JSP/Page_message.jsp";
         }
      } 
 //////////////////////////////////////////////////////////////////////////

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
