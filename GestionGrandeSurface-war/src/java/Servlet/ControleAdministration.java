/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import BeanSession.AdministrationLocal;
import EntityBean.Article;
import EntityBean.BonCommande;
import EntityBean.Categorie;
import EntityBean.Employe;
import EntityBean.Fournisseur;
import EntityBean.LigneCommande;
import EntityBean.Magasin;
import EntityBean.Promotion;
import EntityBean.Role;
import Structure.Aide;
import Structure.Parametre;
import Structure.Requete;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Parameter;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
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
    public String DirNAT = "DirNat";
    public String DirMAG = "DirMag";
    Employe employeConnecte = null;
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
                jspClient="/JSP_Isa/PageConnexion.jsp";
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
   public void verifierConnexion(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        employeConnecte = (Employe) session.getAttribute("employeCo");
        
        session.setAttribute("employeCo", employeConnecte);
        
        if (employeConnecte ==null){
            jspClient="/JSP_Isa/PageConnexion.jsp";
        
        }else {
        String act=request.getParameter("action");
        if (act.equals("GoToDirectionNational")){
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
         Parametre p = new Parametre("nom", "String", DirMAG);
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
             message = "Role "+DirMAG+" n'existe pas";}
    
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
                            List<LigneCommande> commandeLignes = Aide.ParserLignesCommandes(lignes,monCommande);
                        }
                    }
              
              jspClient = "/JSP_Pages/Page_Message.jsp";
              message = "";
}catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/JSP_Pages/Page_Message.jsp";
}

}

//////////////////////////////////////////////////////////////////////////////////////////////////////////





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
