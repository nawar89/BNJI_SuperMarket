/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import BeanSession.AdministrationLocal;
import BeanSession.ClientSessionLocal;
import EntityBean.Article;
import EntityBean.ArticleMagasin;
import EntityBean.BonCommande;
import EntityBean.Categorie;
import EntityBean.Client;
import EntityBean.CommandeClientEnLigne;
import EntityBean.Employe;
import EntityBean.Etat_Commande;
import EntityBean.Magasin;
import EntityBean.Promotion;
import EntityBean.ligneCommandeEnLigne;
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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "controleClient", urlPatterns = {"/controleClient"})
public class controleClient extends HttpServlet {

    @EJB
    private AdministrationLocal administration;
    
    @EJB
    private ClientSessionLocal clientSession;
    public String jspClient = null;
    public String message   = null; 
    public String requete   = null;
    public Date date = new Date();
    
    Client clientConnecte = null;
    CommandeClientEnLigne monPanier = null;
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

        }catch(Exception exepption){
            System.err.println(exepption.getMessage());
        }
        
        
        ////////////////////////////////////////////////////////////
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controleClient</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controleClient at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////////
    
       public void verifierConnexion(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        clientConnecte = (Client) session.getAttribute("ClientCo");
        
        session.setAttribute("ClientCo", clientConnecte);
        
        String act=request.getParameter("action");
        if (clientConnecte ==null && !act.equals("loginClient") && !act.equals("login") && !act.equals("FromCreerClient")&& !act.equals("GoTOCreerClient")){
            
            jspClient="/JSP_Pages/Accueil.jsp";
        
        }else {
        
        if (act.equals("loginClient"))
        {
            seConnecter(request,response);
            request.setAttribute( "message", message );
        }
        else if (act.equals("home")){
            GOHOME(request,response);
            request.setAttribute( "message", message );
        }
        else if (act.equals("FromHOME")){
            FromHOME(request,response);
            request.setAttribute( "message", message );
        }
        else if (act.equals("login")){
            jspClient = "/JSP_Client/loginClient.jsp";
            request.setAttribute( "message", message );
        }
       else if (act.equals("GoTOCreerClient")){
            jspClient = "/JSP_Client/creerClient.jsp";
            request.setAttribute( "message", message );
        }
        else if (act.equals("FromCreerClient")){
            creerClient(request,response);
            request.setAttribute( "message", message );
        }
        else if (act.equals("voirPanier")){
            voirPanier(request,response);
            request.setAttribute( "message", message );
        }
        else if (act.equals("validerPanier")){
            validerPanier(request,response);
            request.setAttribute( "message", message );
        }
        else if (act.equals("logout")){
            LogOut(request,response);
            request.setAttribute( "message", message );
        }
                
       else if (act.equals("magasinSelect")){
            GOHOME(request, response);
            request.setAttribute( "message", message );
        }
        
      }
    }
    
 ////////////////////////////////////////////////////////////////:   
    protected void LogOut(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
    session.invalidate();
    jspClient="/JSP_Pages/Accueil.jsp";
  
}
    
    ////////////////////////////////////////////////////////////////////////////////
    
    protected void seConnecter(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
   HttpSession sess=request.getSession(true);
   mesParam = new ArrayList<Parametre>();
    try{
              String login   = request.getParameter( "login" );
              String mdp     = request.getParameter( "mdp" );
              requete = Requete.getClients+ " and c.login=:login and c.mdp=:mdp";
              Parametre p = new Parametre("login", "String", login);
              mesParam.add(p);
              String enCmdp = Aide.encrypterMdp(mdp);
              p = new Parametre("mdp", "String", enCmdp);
              mesParam.add(p);
              List<Client> listeClients = clientSession.getClients(requete, mesParam);
              if (listeClients != null && listeClients.size()== 1){
                  clientConnecte  = (Client)Aide.getObjectDeListe(listeClients.toArray());
                  session.setAttribute("ClientCo", clientConnecte);
                  requete = Requete.getMagasins;
                  List<Magasin> mags = administration.getMagasins(requete, null);
                  if (mags==null){
                      mags = new ArrayList<Magasin>();
                  }
                   
                  request.setAttribute( "mags", mags );
                  //message = "Bonjour "+clientConnecte.getPrenom()+" "+clientConnecte.getNom() ;
                   jspClient = "/JSP_Client/ChoixMag.jsp";  
              }        
    }catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/JSP_Pages/Page_Message.jsp";
}

}
    
    
       protected void creerClient(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
   HttpSession sess=request.getSession(true);
   mesParam = new ArrayList<Parametre>();
    try{
              String nom   = request.getParameter( "nom" );
              String prenom   = request.getParameter( "prenom" );
              String adresee   = request.getParameter( "adresse" );
              String email   = request.getParameter( "email" );
              String mdp     = request.getParameter( "mdp" );
              String naissance     = request.getParameter( "naissance" );
              String encryptedMdp = Aide.encrypterMdp(mdp);
              Date d = java.sql.Date.valueOf(naissance);
              clientConnecte = clientSession.creerClient(nom, prenom, adresee, email, prenom, email, encryptedMdp, date, true);
              session.setAttribute("ClientCo", clientConnecte);
              jspClient = "/JSP_Pages/Accueil.jsp";
              message = "Bonjour "+clientConnecte.getPrenom()+" "+clientConnecte.getNom() ;
                
    }catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/JSP_Pages/Page_Message.jsp";
}

}
    
//////////////////////////////////////////////////////////////////////////////////    
    
protected void GOHOME(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
   
    try{
        //Construire requete SQL
              String mag = request.getParameter( "magSelect" );
              monPanier = null;
              requete = Requete.getPromotions;
              List<Promotion> listeP = administration.getPromotions(requete, null);
              if (listeP == null){
              listeP = new ArrayList<Promotion>(); 
              }
              mesParam = new ArrayList<Parametre>();
              Integer magID = Integer.valueOf(mag);
              Parametre p = new Parametre("id", "int",magID);
              mesParam.add(p);
              requete = Requete.getMagasins+" and m.id=:id";
              List<Magasin> listm = administration.getMagasins(requete, mesParam);
              Magasin m = null;
              if (listm!=null){
                m = (Magasin)Aide.getObjectDeListe(listm.toArray());
              }
              requete = Requete.getCategories;
              List<Categorie> listc = administration.getCategories(requete, null);
              if (listc == null){
              listc = new ArrayList<Categorie>(); 
              }
           
        
             request.setAttribute( "magasin", m );
             request.setAttribute( "promotions", listeP );
             request.setAttribute( "cats", listc );
             session.setAttribute("Panier", monPanier);
             session.setAttribute("ClientCo", clientConnecte);
              jspClient = "/JSP_Client/Home.jsp";
}catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/JSP_Pages/Page_Message.jsp";
}

} 


////////////////////////////////////////////////////////////////////////////////

protected void FromHOME(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
   
    try{
        //Construire requete SQL 
            monPanier = (CommandeClientEnLigne)session.getAttribute("Panier");
            
             String artMag = request.getParameter( "produitSel" );
             Integer id = Integer.valueOf(artMag);
             requete = Requete.getArticleMagasin+" and a.id=:id";
             mesParam = new ArrayList<Parametre>();
             Parametre p = new Parametre("id", "int", id);
             mesParam.add(p);
             List<ArticleMagasin> listeArtMag = administration.getArticleMagasin(requete, mesParam);
             ArticleMagasin art = null;
             if (listeArtMag!=null){
                 art = (ArticleMagasin)Aide.getObjectDeListe(listeArtMag.toArray());
                 if (monPanier == null ){
                        monPanier = clientSession.creerCommandeEnligne(date, Etat_Commande.EN_TRAITEMENT, clientConnecte);
                 }else if (monPanier!=null){
                        if (monPanier.getId()==null)
                            monPanier = clientSession.creerCommandeEnligne(date, Etat_Commande.EN_TRAITEMENT, clientConnecte);
                 }
                 mesParam = new ArrayList<Parametre>();
                 requete = Requete.getPromotions+ " and p.article = :article and b.date_debut < :date AND b.date_fin > :date";
                 p = new Parametre("article", "Article", art.getArticle());
                 mesParam.add(p);
                 p = new Parametre("date", "Date", date);
                 mesParam.add(p);
                 boolean ajoute = true;
                 if (monPanier.getLigneCommandeEnLignes()!=null){
                    for (ligneCommandeEnLigne lig:monPanier.getLigneCommandeEnLignes() ){
                        if (lig.getArticleMagasin().getId()==art.getId())
                            ajoute = false;
                    } 
                 }
                 if (ajoute){
                    ligneCommandeEnLigne ligne = null;
                    List<Promotion> listeP = administration.getPromotions(requete, mesParam);
                    if (listeP != null){
                        Promotion pro = (Promotion)Aide.getObjectDeListe(listeP.toArray());
                             ligne = clientSession.creerLigneCommandeEnligne(monPanier, art,1,pro.getPrix_prmotion(),true);
                    }else {
                             ligne = clientSession.creerLigneCommandeEnligne(monPanier, art,1,art.getPrix_vente_actuel(), false);

                    }
                    if (monPanier != null){
                        if (monPanier.getLigneCommandeEnLignes()!=null)
                        {
                            monPanier.getLigneCommandeEnLignes().add(ligne);
                        }else{  
                            monPanier.setLigneCommandeEnLignes(new ArrayList<ligneCommandeEnLigne>());
                            monPanier.getLigneCommandeEnLignes().add(ligne);
                        }
                    }
                 }
                 requete = Requete.getCategories;
                 List<Categorie> listc = administration.getCategories(requete, null);
                 if (listc == null){
                    listc = new ArrayList<Categorie>(); 
                 }
                 requete = Requete.getPromotions;
                List<Promotion> listePromo = administration.getPromotions(requete, null);
                 if (listePromo == null){
                    listePromo = new ArrayList<Promotion>(); 
                 }
                 request.setAttribute( "magasin", art.getMagasin() );
                 request.setAttribute( "promotions", listePromo );
                 request.setAttribute( "cats", listc );
                 session.setAttribute("Panier", monPanier);
                 session.setAttribute("ClientCo", clientConnecte);
                 jspClient = "/JSP_Client/Home.jsp";
             }else {
                 message = "Article du magasin n'existe pas";
                 jspClient = "/JSP_Pages/Page_Message.jsp";
             }
             
             
}catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/JSP_Pages/Page_Message.jsp";
}

} 

////////////////////////////////////////////////////////////////////////////////
protected void voirPanier(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
   
    try{
        //Construire requete SQL
             
             monPanier = (CommandeClientEnLigne)session.getAttribute("Panier");
             if (monPanier!=null){
                 if (monPanier.getLigneCommandeEnLignes()!=null){
                      List<String> dates = new ArrayList<String>();
                      request.setAttribute( "dates", dates );
                      session.setAttribute("Panier", monPanier);
                      session.setAttribute("ClientCo", clientConnecte);
                      jspClient = "/JSP_Client/MonPanier.jsp";
                 
                 }else {
                      message = "Vous n'avez aucune produit dans votre panier";
                      jspClient = "/JSP_Pages/Page_Message.jsp";
                 }
             
             }else {
                  message = "Vous n'avez aucune produit dans votre panier";
                  jspClient = "/JSP_Pages/Page_Message.jsp";
             } 
             
}catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/JSP_Pages/Page_Message.jsp";
}

} 
////////////////////////////////////////////////////////////////////////////////



protected void validerPanier(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
   
    try{
        //Construire requete SQL        
             //monPanier = (CommandeClientEnLigne)session.getAttribute("Panier");
             String res   = request.getParameter("vals");
             String date   = request.getParameter("datepicker2");
             
             ParserLigneCommandeVersLignesLivraison(res); 
             if (monPanier!=null){
                if(!date.isEmpty()){
                    Date dd = java.sql.Date.valueOf(date);
                    clientSession.creerLivraisonClient(null, dd, monPanier);
                
                }
                session.setAttribute("Panier", monPanier);
                session.setAttribute("ClientCo", clientConnecte);
                 
             }else GOHOME(request, response);

             
}catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/JSP_Pages/Page_Message.jsp";
}

}

////////////////////////////////////////////////////////////


public  void ParserLigneCommandeVersLignesLivraison(String input){
         
         mesParam = new ArrayList<Parametre>();
         try{
             boolean supprimerCommande = true;
            String [] temp  = input.split(",");
            int count = 0;
            ligneCommandeEnLigne ligne = null;
            int quantite = 0;
            for (int i=0;i<temp.length;i++){
                if ((i)%2==0 || i==0){
                    count = 1;   
                }
                if (count==1){
                       Integer LigneID = Integer.parseInt(temp[i]); 
                       
                       mesParam = new ArrayList<Parametre>();
                       Parametre p = new Parametre("id", "int", LigneID);
                       mesParam.add(p);
                       requete = Requete.getLigneCommandeEnLigne+" and l.id=:id";
                       List<ligneCommandeEnLigne> listeLigns = clientSession.getLigneCommandeEnligne(requete, mesParam);
                       
                       if (listeLigns !=null){
                           ligne = (ligneCommandeEnLigne)Aide.getObjectDeListe(listeLigns.toArray());
                      
                       }else message = "un article n'existe pas";
                }
                else if (count==2){
                    quantite = Integer.parseInt(temp[i]); 
                    if (quantite==0){
                        supprimerCommande = false;
                        clientSession.supprimerLigneCommandeEnLigne(ligne);
                        
                    }else clientSession.modifierLigneCommandeEnLigne(ligne, quantite); 
                   
                }
                 count++;    
            }
            if (supprimerCommande){
                clientSession.supprimerCommandeEnLigne(monPanier);
                monPanier = null;
            }
         }catch(Exception exe){message = exe.getMessage();
            jspClient = "/JSP_Pages/Page_Message.jsp";
         }
        
 }


/////////////////////////////////////////////////////////////////////////////////

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
