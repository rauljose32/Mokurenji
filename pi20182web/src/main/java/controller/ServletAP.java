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
import model.ap.Dhcpd;
import model.ap.HostApd;
import model.dao.DhcpdDAO;
import model.dao.HostApdDAO;
import model.dao.XmlDAO;

/**
 *
 * @author raul
 */
@WebServlet(name = "ServletAP", urlPatterns = {"/servletAP"})
public class ServletAP extends HttpServlet {

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

        String page = "";

        if (request.getParameter("acao").equals("irAP")) {

            HostApdDAO dao = new HostApdDAO();
            List<HostApd> lista = dao.buscarHostapds();
            if (lista != null) {
                request.setAttribute("apds", lista);
            }

            page = "WEB-INF/apHostapd.jsp";

        } else if (request.getParameter("acao").equals("apHostapdInterno")) {

            HostApdDAO dao = new HostApdDAO();
            List<HostApd> lista = dao.buscarHostapds();
            if (lista != null) {
                request.setAttribute("apds", lista);
            }
            page = "WEB-INF/apHostapd.jsp";

        } else if (request.getParameter("acao").equals("apDhcpdInterno")) {

            DhcpdDAO dao = new DhcpdDAO();
            List<Dhcpd> lista = dao.buscarDhcpds();
            if (lista != null) {
                request.setAttribute("dhcpds", lista);
            }
            page = "WEB-INF/apDhcpd.jsp";

        } else if (request.getParameter("acao").equals("addHostAp")) {

            HostApd h = new HostApd();
            h.setNomeInterface(request.getParameter("nomeInterface"));
            h.setNomeRedeWifi(request.getParameter("nomeRede"));
            h.setCanal(Integer.parseInt(request.getParameter("canal")));

            HostApdDAO dao = new HostApdDAO();
            dao.inserir(h);
            
            XmlDAO xmlDao = new XmlDAO();
            xmlDao.xml("hostapd");

            List<HostApd> lista = dao.buscarHostapds();
            if (lista != null) {
                request.setAttribute("apds", lista);
            }
            page = "WEB-INF/apHostapd.jsp";

        } else if (request.getParameter("acao").equals("addDhcpd")) {

            Dhcpd d = new Dhcpd();
            d.setEnderecoSubrede(request.getParameter("enderecoRede"));
            d.setMascaraSubrede(request.getParameter("mascaraRede"));
            d.setRangeInicio(request.getParameter("rangeInicio"));
            d.setRangeFinal(request.getParameter("rangeFinal"));
            d.setGateway(request.getParameter("ipGateway"));
            d.setBroadcast(request.getParameter("ipBroadcast"));

            DhcpdDAO dao = new DhcpdDAO();
            dao.inserir(d);
            
            XmlDAO xmlDao = new XmlDAO();
            xmlDao.xml("dhcpd");
            
            List<Dhcpd> lista = dao.buscarDhcpds();
            if (lista != null) {
                request.setAttribute("dhcpds", lista);
            }
            page = "WEB-INF/apDhcpd.jsp";

        } else if (request.getParameter("acao").equals("delApd")) {

            HostApdDAO dao = new HostApdDAO();

            int idApd = Integer.parseInt(request.getParameter("idApd"));

            HostApd ha = dao.buscarHostapds(idApd);
            
            dao.update(ha);
            
            XmlDAO xmlDao = new XmlDAO();
            xmlDao.xml("hostapd");

            dao.deletar(ha);
            
            List<HostApd> lista = dao.buscarHostapds();
            if (lista != null) {
                request.setAttribute("apds", lista);
            }
            page = "WEB-INF/apHostapd.jsp";

        } else if (request.getParameter("acao").equals("delDhcpd")) {

            DhcpdDAO dao = new DhcpdDAO();

            int idDhcpd = Integer.parseInt(request.getParameter("idDhcpd"));

            Dhcpd d = dao.buscarDhcpds(idDhcpd);
            
            dao.update(d);
            
            XmlDAO xmlDao = new XmlDAO();
            xmlDao.xml("dhcpd");
            
            dao.deletar(d);
            
            List<Dhcpd> lista = dao.buscarDhcpds();
            if (lista != null) {
                request.setAttribute("dhcpds", lista);
            }
            page = "WEB-INF/apDhcpd.jsp";

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
