/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletChefRayon;

import BeanFacade.FournisseurFacadeLocal;
import BeanSession.AdministrationLocal;
import BeanSession.ChefRayonLocal;
import EntityBean.ArticleMagasin;
import EntityBean.BonCommande;
import EntityBean.Categorie;
import EntityBean.Employe;
import EntityBean.Etat_Livraison;
import EntityBean.Fournisseur;
import EntityBean.SousCategorie;
import Structure.Aide;
import Structure.Parametre;
import Structure.Requete;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jihane
 */
public class ControlChef extends HttpServlet {

    @EJB
    private AdministrationLocal administration;

    @EJB
    private ChefRayonLocal chefRayon;
    
     public String jspClient="";
     public String message   = ""; 
     public String requete   = "";
     public Date date = new Date();
     ArrayList <Parametre> mesParam = new ArrayList<Parametre>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try 
        {
        String act=request.getParameter("action");
        if(null!=act){
            switch (act) {
                case "null":
                    jspClient="/Jihane_JSP/Accueil.jsp";
                    break;
                case "CreerFour":
                    jspClient="/Jihane_JSP/CreerFournisseur.jsp";
                    break;
                case "CreerF":
                    doActionCreerF(request,response);
                    request.setAttribute( "message", message );
                    break;
                case "Accueil":
                    jspClient="/Jihane_JSP/Accueil.jsp";
                    break;
                case "CreerArticle":
                    GoTOArticle(request,response);
                   break;
                case "CreerA":
                    doActionCreerA(request,response);
                    request.setAttribute( "message", message );
                    break;
                
            case "ModifierArticleMag" :
                GoTOArticleMag(request,response);
                 break;
            
            case "ModifA" : 
                 doActionModifArticleMag(request,response);
                 request.setAttribute( "message", message );
                 break;
            case "CreerLivraison":
                 GoTOLivraison(request,response);
                 break;
            case "CreerL" : 
                 doActionCreerLivraison(request,response);
                 request.setAttribute( "message", message );
                 break;
            case "loginFournisseur" : 
                 seConnecter(request,response);
                 request.setAttribute( "message", message );
                 break;
                
                
            }
           }
        else {
            //jspClient="/Jihane_JSP/Accueil.jsp";
           jspClient="/Jihane_JSP/login.jsp";
           
        }        
    RequestDispatcher Rd;
    Rd = getServletContext().getRequestDispatcher(jspClient);
    Rd.forward(request, response);
        }catch (Exception exception){System.err.println(exception.getMessage());}    
     
    }
    
        /////////////////////////////////////////////////////////////////////////////////////////
    protected void seConnecter(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
   //HttpSession sess=request.getSession(true);

    try{
              mesParam = new ArrayList<Parametre>();
              String email  = request.getParameter( "email" );
              String mdp     = request.getParameter( "mdp" );
              requete = Requete.getFournisseurs+ " and f.email=:email and f.mdp=:mdp";
              Parametre p = new Parametre("email", "String", email);
              mesParam.add(p);
              p = new Parametre("mdp", "String", mdp);
              mesParam.add(p);
              List<Fournisseur> listeFour = chefRayon.getFournisseur(requete, mesParam);
              if (listeFour != null && listeFour.size()== 1){
              Fournisseur four = (Fournisseur)Aide.getObjectDeListe(listeFour.toArray());
              jspClient = "/Jihane_JSP/AccueilFournisseur.jsp";
              //sess.setAttribute("employeCo", four);
               message = "Bonjour "+four.getNom();
             //jspClient = "/Jihane_JSP/Page_message.jsp";
             
                }     
        } catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/Jihane_JSP/Page_message.jsp";
}
}


    
      protected void doActionCreerF(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try
       {
           
       String nom= request.getParameter("nom");
       String adresse = request.getParameter("adresse");
       String telephone=request.getParameter("telephone");
       String email=request.getParameter("email");
       System.out.println("**************************************");
       System.out.println(Aide.GenererMDP());
       String mdp= Aide.encrypterMdp(Aide.GenererMDP());
   
       if ( nom.trim().isEmpty() || adresse.trim().isEmpty())
       {
          message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires.";
       } 
       else {
          
          chefRayon.creationFournisseur(nom, adresse, telephone, email,mdp);
           message = "Fournisseur créé avec succès !";  
           jspClient = "/Jihane_JSP/Page_message.jsp";
        }
        }catch(Exception exe){ 
           message = exe.getMessage();
           jspClient = "/Jihane_JSP/Page_message.jsp";
         }
      }
      
      
      
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
              List<Fournisseur> listeFour = chefRayon.getFournisseur(req, null);
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
      protected void GoTOArticleMag(HttpServletRequest request, HttpServletResponse response) 
              throws ServletException, IOException
      {
          
          try{
              requete=Requete.getArticleMagasin;
              List<ArticleMagasin> listeart = chefRayon.getArticleMagasin(requete, null);
              if (listeart == null){
              listeart = new ArrayList<>(); 
              }
              request.setAttribute( "articles", listeart );
              jspClient="/Jihane_JSP/modifierPrixArticle.jsp";
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
      
       String type = request.getParameter( "TypeSelect" );
       
       
       if ( libelle.trim().isEmpty() || reference.trim().isEmpty() || prix.trim().isEmpty())
       {
          message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires.";
       } 
       else 
       {
                Integer souscatID= Integer.parseInt(souscategory);
                Integer fourniID = Integer.parseInt(fourni);
                Integer prix_actuel = Integer.parseInt(prix);
                
               
                
                //Récupérer la sous-categorie
                mesParam = new ArrayList<Parametre>();
                requete= Requete.getSousCategories + " And s.id=:id";
                Parametre s = new Parametre("id", "int", souscatID);
                mesParam.add(s);
                List<SousCategorie> listeSousCat=administration.getSousCategories(requete, mesParam);
                //Récupérer le fournisseur
                mesParam = new ArrayList<Parametre>();
                requete=Requete.getFournisseurs + " And f.id=:id";
                Parametre f = new Parametre("id", "int", fourniID);
                mesParam.add(f);
                List<Fournisseur> listeFour=chefRayon.getFournisseur(requete, mesParam);
                switch (type)
                {
                   case "0":
                   String date_peremp= request.getParameter("date_p");
                   java.sql.Date d = java.sql.Date.valueOf(date_peremp);
                   chefRayon.creationProdFrais(libelle, reference, prix_actuel, date, description, listeSousCat.get(0), listeFour.get(0),d);  
                   break;
                   case "1":
                   String taille = request.getParameter("taille");
                   String coloris = request.getParameter("coloris");
                   chefRayon.creationVetement(libelle, reference, prix_actuel, date, description, listeSousCat.get(0), listeFour.get(0), taille, coloris);
                   break;
                   case "2": 
                   String garantie = request.getParameter("period_garantie");
                   Integer periode_garantie=Integer.parseInt(garantie);
                   chefRayon.creationElectromenager(libelle, reference, prix_actuel, date, description, listeSousCat.get(0), listeFour.get(0),periode_garantie);
                   break;
                   case "3":
                   chefRayon.creationArticle(libelle, reference, prix_actuel, date, description, listeSousCat.get(0), listeFour.get(0));
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
        
         protected void doActionModifArticleMag(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try
       {
           
       String prix= request.getParameter("nouveauPrix");
       String article= request.getParameter("ArticleSelect");
       if ( prix.trim().isEmpty())
       {
          message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. ";
       } 
       else {
          Integer newPrice = Integer.parseInt(prix);
          Integer articleID = Integer.parseInt(article);
           requete= Requete.getArticleMagasin + " And a.id=:id";
           Parametre a = new Parametre("id", "int", articleID);
           mesParam.add(a);
           List<ArticleMagasin> listearticle=chefRayon.getArticleMagasin(requete, mesParam);
           chefRayon.modifierPrixVente(listearticle.get(0), newPrice);
           message = "Prix modifié avec succès !";  
           jspClient = "/Jihane_JSP/Page_message.jsp";
        }
        }catch(Exception exe){ 
           message = exe.getMessage();
           jspClient = "/Jihane_JSP/Page_message.jsp";
         }
      }
         
        //Go to livraison ou il faut récupérer les employe dont le role est chefRayon + les commande de ce chef de rayon 
         
         
      protected void GoTOLivraison(HttpServletRequest request, HttpServletResponse response) 
              throws ServletException, IOException
      {
          
          try{
            // Récupérer les employés dont le rôle est chef de rayon 
              requete=Requete.getEmployes + " AND e.role_id =6";
              List<Employe> emp = administration.getEmploye(requete, null);
              if (emp == null){
              emp = new ArrayList<>(); 
              }
              request.setAttribute( "employes", emp );
              //Réupérer les commandes du fournisseur connecté et qui n'ont pas encore été livrées :
              requete=Requete.getCommandes + " And ";
              List<BonCommande> listec=administration.getBonCommande(requete, null);
              if (listec == null){
              listec = new ArrayList<>(); 
              }
              request.setAttribute( "commandes", listec );
              jspClient="/Jihane_JSP/CreerLivraison.jsp";
              message = "";
            }catch(Exception exe){
             message = exe.getMessage();
            jspClient = "/Jihane_JSP/Page_message.jsp";
            }

     } 
         
         protected void doActionCreerLivraison(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try
       {
           
      
      
       String date_pr = request.getParameter( "date_pr" );
       String commande = request.getParameter( "CommandeSelect" );
       
       
       
       if ( date_pr.trim().isEmpty() || commande.trim().isEmpty())
       {
          message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires.";
       } 
       else 
       {
                Integer commandeID= Integer.parseInt(commande);
                java.sql.Date d = java.sql.Date.valueOf(date_pr);
               //Récupérer la commande
                mesParam = new ArrayList<Parametre>();
                requete= Requete.getCommandes+ " And b.id=:id";
                Parametre s = new Parametre("id", "int", commandeID);
                mesParam.add(s);
                List<BonCommande> listeBonCommande=administration.getBonCommande(requete, mesParam);
                chefRayon.creationLivraison(null,d,null,listeBonCommande.get(0),Etat_Livraison.ENCOURS);  
                message = "Livraison créé avec succès !";  
                jspClient = "/Jihane_JSP/Page_message.jsp";
        }
         }catch(Exception exe){ 
           message = exe.getMessage();
           jspClient = "/Jihane_JSP/Page_message.jsp";
         }
      } 

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
