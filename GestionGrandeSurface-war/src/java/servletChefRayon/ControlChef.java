/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletChefRayon;

import BeanFacade.FournisseurFacadeLocal;
import BeanSession.AdministrationLocal;
import BeanSession.ChefRayonLocal;
import EntityBean.Categorie;
import Structure.Aide;
import Structure.Parametre;
import Structure.Requete;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
    
     public String jspClient=null;
     public String message   = null; 
     public String requete   = null;
     ArrayList <Parametre> mesParam = null;

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
                    jspClient="/ChefRayonJSP/CreerArticle.jsp";
                    break;
                case "CreerA":
                    doActionCreerA(request,response);
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
      
      
        protected void doActionCreerA(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try
       {
           
       String libelle= request.getParameter("libelle");
       String reference = request.getParameter("reference");
       String description=request.getParameter("description");
       String prix=request.getParameter("prix_achat_actuel");
       String category = request.getParameter( "CategorieSelect" );
       String souscategoryLibelle = request.getParameter( "souscatnom" );
   
       if ( libelle.trim().isEmpty() || reference.trim().isEmpty() || prix.trim().isEmpty())
       {
          message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"CreerFournisseur.jsp\">Cliquez ici</a> pour accéder au formulaire de création.";
       } 
       else {
              //Récupérer la catégorie choisi
               
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
              
          
           //chefRayon.creationArticle(libelle, reference, 0, date_de_creation, description, sous_categorie, fournisseur);
           message = "Fournisseur créé avec succès !";  
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
