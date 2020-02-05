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
import model.dao.DefaultDAO;
import model.dao.HostDAO;
import model.dao.NatEntradaDAO;
import model.dao.RedeDAO;
import model.dao.XmlDAO;
import model.rota.Default;
import model.rota.Host;
import model.rota.Rede;

/**
 *
 * @author Fagno
 */
@WebServlet(name = "ServletRota", urlPatterns = {"/servletRota"})
public class ServletRota extends HttpServlet {

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

        if (request.getParameter("acao").equals("irRota")) {

            DefaultDAO dao = new DefaultDAO();
            List<Default> lista = dao.buscarRedes();
            if (lista != null) {
                request.setAttribute("rotasDefault", lista);
            }
            page = "WEB-INF/rotas_rota_default.jsp";

        } else if (request.getParameter("acao").equals("rotaDefault")) {

            DefaultDAO dao = new DefaultDAO();
            List<Default> lista = dao.buscarRedes();
            if (lista != null) {
                request.setAttribute("rotasDefault", lista);
            }
            page = "WEB-INF/rotas_rota_default.jsp";

        } else if (request.getParameter("acao").equals("addRotaDefault")) {

            Default rotaDefault = new Default();
            rotaDefault.setGateway(request.getParameter("ipGateway"));

            DefaultDAO dao = new DefaultDAO();
            dao.inserir(rotaDefault);
            
            XmlDAO xmlDao = new XmlDAO();
            xmlDao.xml("rotadefault");
            
            List<Default> lista = dao.buscarRedes();
            if (lista != null) {
                request.setAttribute("rotasDefault", lista);
            }
            page = "WEB-INF/rotas_rota_default.jsp";
        } else if (request.getParameter("acao").equals("delRotaDefault")) {

            DefaultDAO dao = new DefaultDAO();

            int idrotaDefault = Integer.parseInt(request.getParameter("idrotaDefault"));

            Default d = dao.buscarRedes(idrotaDefault);
            
            dao.update(d);
            
            XmlDAO xmlDao = new XmlDAO();
            xmlDao.xml("rotadefault");
            
            dao.deletar(d);

            List<Default> lista = dao.buscarRedes();
            if (lista != null) {
                request.setAttribute("rotasDefault", lista);
            }
            page = "WEB-INF/rotas_rota_default.jsp";

        } else if (request.getParameter("acao").equals("rotaHost")) {

            HostDAO dao = new HostDAO();
            List<Host> lista = dao.buscarRedes();
            if (lista != null) {
                request.setAttribute("rotasHost", lista);
            }
            page = "WEB-INF/rotas_rota_host.jsp";

        } else if (request.getParameter("acao").equals("addRotaHost")) {

            Host rotaHost = new Host();
            rotaHost.setHostDestino(request.getParameter("ipHost"));
            rotaHost.setGateway(request.getParameter("ipGateway"));

            HostDAO dao = new HostDAO();
            dao.inserir(rotaHost);
            
            XmlDAO xmlDao = new XmlDAO();
            xmlDao.xml("rotahost");

            List<Host> lista = dao.buscarRedes();
            if (lista != null) {
                request.setAttribute("rotasHost", lista);
            }
            page = "WEB-INF/rotas_rota_host.jsp";
        } else if (request.getParameter("acao").equals("delRotaHost")) {

            HostDAO dao = new HostDAO();

            int idrotaHost = Integer.parseInt(request.getParameter("idrotaHost"));

            Host h = dao.buscarRedes(idrotaHost);
            
            dao.update(h);
            
            XmlDAO xmlDao = new XmlDAO();
            xmlDao.xml("rotahost");
            
            dao.deletar(h);
            
            List<Host> lista = dao.buscarRedes();
            if (lista != null) {
                request.setAttribute("rotasHost", lista);
            }
            page = "WEB-INF/rotas_rota_host.jsp";

        }else if (request.getParameter("acao").equals("rotaRede")) {

            RedeDAO dao = new RedeDAO();
            List<Rede> lista = dao.buscarRedes();
            if (lista != null) {
                request.setAttribute("rotasRede", lista);
            }
            page = "WEB-INF/rotas_rota_rede.jsp";

        } else if (request.getParameter("acao").equals("addRotaRede")) {

            Rede rotaRede = new Rede();
            rotaRede.setRedeDestino(request.getParameter("ipRede"));
            rotaRede.setMascara(request.getParameter("ipMascara"));
            rotaRede.setGateway(request.getParameter("ipGateway"));

            RedeDAO dao = new RedeDAO();
            dao.inserir(rotaRede);
            
            XmlDAO xmlDao = new XmlDAO();
            xmlDao.xml("rotarede");

            List<Rede> lista = dao.buscarRedes();
            if (lista != null) {
                request.setAttribute("rotasRede", lista);
            }
            page = "WEB-INF/rotas_rota_rede.jsp";
        } else if (request.getParameter("acao").equals("delRotaRede")) {

            RedeDAO dao = new RedeDAO();

            int idrotaRede = Integer.parseInt(request.getParameter("idrotaRede"));

            Rede r = dao.buscarRedes(idrotaRede);
            
            dao.update(r);
            
            XmlDAO xmlDao = new XmlDAO();
            xmlDao.xml("rotarede");
            
           dao.deletar(r);
            
            List<Rede> lista = dao.buscarRedes();
            if (lista != null) {
                request.setAttribute("rotasRede", lista);
            }
            page = "WEB-INF/rotas_rota_rede.jsp";

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
