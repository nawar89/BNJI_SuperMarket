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
import EntityBean.Categorie;
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
                    jspClient="/ChefRayonJSP/Accueil.jsp";
                    break;
                case "CreerFour":
                    jspClient="/ChefRayonJSP/CreerFournisseur.jsp";
                    break;
                case "CreerF":
                    doActionCreerF(request,response);
                    request.setAttribute( "message", message );
                    break;
                case "Accueil":
                    jspClient="/ChefRayonJSP/Accueil.jsp";
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
            }
            
            
        }
        else {
            jspClient="/ChefRayonJSP/Accueil.jsp";
        }        
    RequestDispatcher Rd;
    Rd = getServletContext().getRequestDispatcher(jspClient);
    Rd.forward(request, response);
        }catch (Exception exception){System.err.println(exception.getMessage());}    
     
    }
    
      protected void doActionCreerF(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try
       {
           
       String nom= request.getParameter("nom");
       String adresse = request.getParameter("adresse");
       String telephone=request.getParameter("telephone");
       String email=request.getParameter("email");
     
   
       if ( nom.trim().isEmpty() || adresse.trim().isEmpty())
       {
          message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"CreerFournisseur.jsp\">Cliquez ici</a> pour accéder au formulaire de création.";
       } 
       else {
          
          chefRayon.creationFournisseur(nom, adresse, telephone, email);
           message = "Fournisseur créé avec succès !";  
           jspClient = "/ChefRayonJSP/Page_message.jsp";
        }
        }catch(Exception exe){ 
           message = exe.getMessage();
           jspClient = "/ChefRayonJSP/Page_message.jsp";
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
              jspClient="/ChefRayonJSP/CreerArticle.jsp";
              message = "";
}catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/ChefRayonJSP/Page_message.jsp";
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
              jspClient="/ChefRayonJSP/modifierPrixArticle.jsp";
              message = "";
            }catch(Exception exe){
             message = exe.getMessage();
            jspClient = "/ChefRayonJSP/Page_message.jsp";
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
   
       if ( libelle.trim().isEmpty() || reference.trim().isEmpty() || prix.trim().isEmpty())
       {
          message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"CreerArticle.jsp\">Cliquez ici</a> pour accéder au formulaire de création.";
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
                chefRayon.creationArticle(libelle, reference, prix_actuel, date, description, listeSousCat.get(0), listeFour.get(0));
                message = "Article créé avec succès !";  
                jspClient = "/ChefRayonJSP/Page_message.jsp";
        }
         }catch(Exception exe){ 
           message = exe.getMessage();
           jspClient = "/ChefRayonJSP/Page_message.jsp";
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
          message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"modifierPrixArticle.jsp\">Cliquez ici</a> pour accéder au formulaire de création.";
       } 
       else {
          Integer newPrice = Integer.parseInt(prix);
          Integer articleID = Integer.parseInt(prix);
           requete= Requete.getArticleMagasin + " And a.id=:id";
           Parametre a = new Parametre("id", "int", articleID);
           mesParam.add(a);
           List<ArticleMagasin> listearticle=chefRayon.getArticleMagasin(requete, mesParam);
           chefRayon.modifierPrixVente(listearticle.get(0), newPrice);
           message = "Prix modifié avec succès !";  
           jspClient = "/ChefRayonJSP/Page_message.jsp";
        }
        }catch(Exception exe){ 
           message = exe.getMessage();
           jspClient = "/ChefRayonJSP/Page_message.jsp";
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
