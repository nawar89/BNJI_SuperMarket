/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import BeanSession.AdministrationLocal;
import EntityBean.Employe;
import EntityBean.Role;
import Structure.Aide;
import Structure.Parametre;
import Structure.Requete;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
                 jspClient="/JSP_Pages/MenuAdmin.jsp";
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
     
        String act=request.getParameter("action");
        if (act.equals("GoToDirectionNational")){
            DoActPageDirectionNational(request,response);
            jspClient = "/JSP_Pages/DirectionNational.jsp";
        }
        else if (act.equals("FromDirectionNational")){
            DirectionNational(request,response); 
            jspClient = "/JSP_Pages/Page_Message.jsp";
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
                administration.creerEmployee(nom, prenom, adresse,tel, email,login,mdp,role);
               //Aide.envoyerEmail(email);  il faut envoyer l'email 
               message = "Employe est créé";
                    
            }
     }else message = "Role Direction National n'existe pas";
    request.setAttribute( "message", message );
}catch(Exception exe){message = exe.getMessage();}

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
              request.setAttribute( "message", message );
}catch(Exception exe){message = exe.getMessage();}

}  


   
    ////////////////////////////////////////////////////////////////////////////////////////////////////

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
