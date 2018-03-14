/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import BeanSession.AdministrationLocal;
import BeanSession.DirecteurMagasinLocal;
import EntityBean.Categorie;
import EntityBean.Employe;
import EntityBean.Magasin;
import EntityBean.Role;
import Structure.Aide;
import Structure.Parametre;
import Structure.Requete;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
            
        } else if (act.equals("")){

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
                             jspClient = "/JSP_Page/MenuDirectionNational.jsp";
                             sess.setAttribute("employeCo", emp);
                             message = "Bonjour "+emp.getPrenom()+" "+emp.getNom() ;
                             break;
                         case ChefRayon:
                             jspClient = "/JSP_Page/MenuDirectionNational.jsp";
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
