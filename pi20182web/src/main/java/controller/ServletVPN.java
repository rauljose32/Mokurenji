/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.VpnDAO;
import model.dao.XmlDAO;
import model.vpn.Vpn;

/**
 *
 * @author mathe
 */
@WebServlet(name = "ServletVPN", urlPatterns = {"/ServletVPN"})
public class ServletVPN extends HttpServlet {

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
        
        String page = "home.jsp";

        if (request.getParameter("acao").equals("irVPN")) {

           VpnDAO dao = new VpnDAO();
           List<Vpn> a = dao.buscarVpns();
           if (a != null) {
           request.setAttribute("vpns", a);
            }
            page = "WEB-INF/vpn.jsp";

            
            } else if (request.getParameter("acao").equals("addVPN")) {

            Vpn vpn = new Vpn();
            vpn.setIpPontaA(request.getParameter("ippontaa"));
            vpn.setIpPontaB(request.getParameter("ippontab"));
            vpn.setIpTunel(request.getParameter("ipreal"));
            vpn.setPorta(Integer.parseInt(request.getParameter("portadotunel")));
            
            VpnDAO dao = new VpnDAO();
            dao.inserir(vpn);
            
            XmlDAO xmlDao = new XmlDAO();
            xmlDao.xml("vpn");
            
            List<Vpn> a = dao.buscarVpns();
             if (a != null) {
                request.setAttribute("vpns", a);
             }
             page = "WEB-INF/vpn.jsp";
            
        }else if (request.getParameter("acao").equals("delVPN")){
            VpnDAO dao = new VpnDAO();
            
            Vpn vpn = dao.buscarPrimeiroRegistro();
            
            dao.update(vpn);
            
            XmlDAO xmlDao = new XmlDAO();
            xmlDao.xml("vpn");
            
            dao.delete();
            
            List<Vpn> a = dao.buscarVpns();
            if (a != null){
                request.setAttribute("vpns", a);
            }
            page = "WEB-INF/vpn.jsp";
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
