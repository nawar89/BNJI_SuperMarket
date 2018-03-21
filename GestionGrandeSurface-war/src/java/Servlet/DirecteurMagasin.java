/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import BeanSession.AdministrationLocal;
import BeanSession.DirecteurMagasinLocal;
import EntityBean.ArticleMagasin;
import EntityBean.BonCommande;
import EntityBean.Casse;
import EntityBean.Categorie;
import EntityBean.ChefRyon_Categorie;
import EntityBean.Employe;
import EntityBean.Livraison;
import EntityBean.Lot;
import EntityBean.Magasin;
import EntityBean.Role;
import Structure.Aide;
import Structure.Parametre;
import Structure.Requete;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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
 * @author i.silvestre
 */
@WebServlet(name = "DirecteurMagasin", urlPatterns = {"/DirecteurMagasin"})
public class DirecteurMagasin extends HttpServlet {

    @EJB
    private DirecteurMagasinLocal directeurMagasin;

    @EJB
    private AdministrationLocal administration;
    
    public String jspClient = null;
    public String message   = null; 
    public String requete   = null;
    public final String DirNAT = "DirNat";
    public final String DirMag = "DirMag";
    public final String ChefRayon = "ChefRayon";
    public final String agentRayon = "AgRayon";
    public final String agentLivraison = "AgLivraison";
    public final String agentCaisse = "AgCaisse";
    
    
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

        String act=request.getParameter("action");
            if ((act == null)||(act.equals("null")))
            {
                 jspClient="/JSP_Isa/PageConnexion.jsp";
            }else {
            
                  verifierConnexion(request, response);
            }
            
            RequestDispatcher Rd;
            Rd = getServletContext().getRequestDispatcher(jspClient);
            Rd.forward(request, response);
            
            }catch(Exception exeption){System.err.println(exeption.getMessage());}
        
        
        //////////////////////////////////////////////////////////////////////////////
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DirecteurMagasin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DirecteurMagasin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////
    public void verifierConnexion(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
                
        String act=request.getParameter("action");
        if (act.equals("doActionConnexion"))
        {
            seConnecter(request,response);
            request.setAttribute( "message", message );
        }
        else if (act.equals("loadCreationEmployeMagasin"))
        {
            chargerPageCreationEmployeMagasin(request, response);
            
            request.setAttribute("message", message);
        }
        else if (act.equals("creerEmployeMagasin")){
            creerEmployeMagasin(request, response);
            request.setAttribute( "message", message );
            
        } else if (act.equals("consulterCommandes")){
            chargerPageConsultationCommandes(request,response);
            request.setAttribute("message", message);

        } else if (act.equals("afficherDetailCommande")){
            afficherDetailCommande(request, response);
            request.setAttribute("message", message);
            
       } else if (act.equals("consulterLivraisons")){
            chargerPageConsultationLivraisons(request,response);
            request.setAttribute("message", message);
        } else if (act.equals("afficherDetailLivraison")){
            afficherDetailLivraison(request,response);
            request.setAttribute("message", message);
        }/** ici, début if/else agent de rayon**/
        else if (act.equals("passerLaCasse")){
            creationCasse(request,response);
            request.setAttribute("message", message);
        }else if (act.equals("choixArticleCasse")){
            finaliserLigneCasse(request,response);
        }else if (act.equals("enregistreLigneCasse")){
            enregistrerLigneCasse(request,response);
        }

    }
    
    /////////////////////////////////////////////////////////////////////////////////////////
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
                             jspClient = "/JSP_Pages/MenuDirectionNational.jsp";
                             sess.setAttribute("employeCo", emp);
                             message = "Bonjour "+emp.getPrenom()+" "+emp.getNom() ;
                             break;
                         case ChefRayon:
                             jspClient = "/JSP_Pages/MenuChefRayon.jsp";
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
    ////////////////////////////////////////////////////////////////////////////////
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
                directeurMagasin.creerEmployeMagasin(nom, prenom, adresse, tel, email, login, mdp, roleEmploye ,mag, listCat);
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
            List<ArticleMagasin> listeArticlesMagasin = directeurMagasin.getArticleMagasin(requeteArticle, mesParam);
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
            List<Casse> listeCasses = directeurMagasin.getCasse(Requete.getCasseParEmploye + " AND a.id = ?1 AND c.date_casse = ?2", mesParam);
            if (listeCasses.isEmpty())
            {
            Casse casse = directeurMagasin.creerCasse(employeCo, d);
            
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
            ArticleMagasin article = (ArticleMagasin)Aide.getObjectDeListe(directeurMagasin.getArticleMagasin(Requete.getArticleMagasin+ " AND a.id = ?1", mesParam).toArray());
            List<Lot> listeLots = administration.getLots(Requete.getLotParMagasin + " AND a.id = ?1", mesParam);
            mesParam.clear();
            Integer i = Integer.parseInt(idCasse);
            p = new Parametre("1", "long", i);
            mesParam.add(p);
            Casse casse = (Casse)Aide.getObjectDeListe(directeurMagasin.getCasse(Requete.getCasses+ " AND c.id = ?1", mesParam).toArray());
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
                List<Lot> listeLots = directeurMagasin.getLot(Requete.getLots+ " AND l.id = :id", mesParam);
                lot = (Lot)Aide.getObjectDeListe(listeLots.toArray());
            }
            mesParam.clear();
            Integer i = Integer.parseInt(idArticleMagasin);
            p = new Parametre("1", "long", i);
            mesParam.add(p);
            ArticleMagasin article = (ArticleMagasin)Aide.getObjectDeListe(directeurMagasin.getArticleMagasin(Requete.getArticleMagasin+ " AND a.id = ?1", mesParam).toArray());
            mesParam.clear();
            Integer id = Integer.parseInt(idCasse);
            
            p = new Parametre("id", "long", id);
            mesParam.add(p);
            Casse casse = (Casse)Aide.getObjectDeListe(directeurMagasin.getCasse(Requete.getCasses+ " AND c.id = :id", mesParam).toArray());
            
            directeurMagasin.creerLigneCasse(lot, article, q, casse);
            creationCasse(request,response);
            request.setAttribute("message", message);   
        } catch (Exception exe) {
            message = exe.getMessage();
            jspClient = "/JSP_Pages/Page_Message.jsp";   
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
