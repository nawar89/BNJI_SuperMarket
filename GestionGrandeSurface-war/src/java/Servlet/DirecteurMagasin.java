/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import BeanSession.AdministrationLocal;
import BeanSession.DirecteurMagasinLocal;
import EntityBean.Employe;
import Structure.Parametre;
import Structure.Requete;
import java.io.IOException;
import java.io.PrintWriter;
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
        if (act.equals("doActionConnexion")){
            seConnecter(request,response);
            //request.setAttribute( "message", message );
        }
        else if (act.equals("FromDirectionNational")){
            //DirectionNational(request,response); 
            //jspClient = "/JSP_Pages/Page_Message.jsp";
            //request.setAttribute( "message", message );
            
        } else if (act.equals("GoToCartegorie")){
            //GoTOCategorie(request,response); 
            //request.setAttribute( "message", message );
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
                           
              if ("DirMag".equals(listeEmp.get(0).getRole().getNom()))
                      {
                          jspClient = "/JSP_Isa/MenuDirecteurMagasin.jsp";
                          sess.setAttribute("employeCo", listeEmp.get(0));
                      }
                  }              
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
