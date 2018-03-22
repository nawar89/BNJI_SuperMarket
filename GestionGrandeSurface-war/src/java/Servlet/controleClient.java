/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import BeanSession.AdministrationLocal;
import BeanSession.ClientSessionLocal;
import EntityBean.Categorie;
import EntityBean.Client;
import EntityBean.Employe;
import EntityBean.Magasin;
import EntityBean.Promotion;
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

/**
 *
 * @author Nawar
 */
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
        if (clientConnecte ==null && !act.equals("loginClient") && !act.equals("home")){
            
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
       
        
        
      }
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
              p = new Parametre("mdp", "String", mdp);
              mesParam.add(p);
              List<Client> listeClients = clientSession.getClients(requete, mesParam);
              if (listeClients != null && listeClients.size()== 1){
                  Client cl = (Client)Aide.getObjectDeListe(listeClients.toArray());
                  jspClient = "/JSP_Client/AccueilClient.jsp";
                  sess.setAttribute("ClientCo", cl);
                  message = "Bonjour "+cl.getPrenom()+" "+cl.getNom() ;
                     
              }        
    }catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/JSP_Pages/Page_Message.jsp";
}

}
    
    
    
protected void GOHOME(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException
{
   
    try{
        //Construire requete SQL        
              requete = Requete.getPromotions;
              List<Promotion> listeP = administration.getPromotions(requete, null);
              if (listeP == null){
              listeP = new ArrayList<Promotion>(); 
              }
              requete = Requete.getMagasins;
              List<Magasin> listm = administration.getMagasins(requete, null);
              Magasin m = null;
              m =listm.get(0);
              requete = Requete.getCategories;
              List<Categorie> listc = administration.getCategories(requete, null);
              if (listc == null){
              listc = new ArrayList<Categorie>(); 
              }
           
        
              request.setAttribute( "magasin", m );
             request.setAttribute( "promotions", listeP );
             request.setAttribute( "cats", listc );
             request.setAttribute( "Panier", null );
             request.setAttribute( "ClientCo", null );
              jspClient = "/JSP_Client/Home.jsp";
}catch(Exception exe){
    message = exe.getMessage();
    jspClient = "/JSP_Pages/Page_Message.jsp";
}

} 

///////////////////////

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
