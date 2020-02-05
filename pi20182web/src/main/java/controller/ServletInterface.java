/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.InterfaceDAO;
import model.dao.XmlDAO;
import model.interfaces.Interface;

/**
 *
 * @author thanyla
 */
@WebServlet(name = "ServletInterface", urlPatterns = {"/servletInterface"})
public class ServletInterface extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String page="";
        if (request.getParameter("acao").equals("irInterface")) {

            InterfaceDAO dao = new InterfaceDAO();
            List<Interface> lista = dao.buscarInterfaces();
            if (lista != null) {
                request.setAttribute("interfaces", lista);
            }
            
            
            page = "WEB-INF/interface.jsp";

        }
        
        else if (request.getParameter("acao").equals("addInterface")) {

            Interface i = new Interface();
            i.setNome(request.getParameter("nomeInterface"));
            i.setIp(request.getParameter("ip"));
            i.setMascara(request.getParameter("mascara"));
            InterfaceDAO dao = new InterfaceDAO();
            dao.inserir(i);
            
            XmlDAO xmlDao = new XmlDAO();
            xmlDao.xml("interface");
            
            List<Interface> a = dao.buscarInterfaces();
            if (a != null) {
                request.setAttribute("interfaces", a);
            }
            page = "WEB-INF/interface.jsp";

        } else if (request.getParameter("acao").equals("delInterface")) {
            
            InterfaceDAO dao = new InterfaceDAO();
            int idInterface = Integer.parseInt(request.getParameter("idInterface"));
            Interface i = dao.buscarInterfaces(idInterface);
            
            dao.update(i);
            
            XmlDAO xmlDao = new XmlDAO();
            xmlDao.xml("interface");
            
            dao.deletar(i);
            
            List<Interface> a = dao.buscarInterfaces();
            if (a != null) {
                request.setAttribute("interfaces", a);
            }
            page = "WEB-INF/interface.jsp";

        }
        
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
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
