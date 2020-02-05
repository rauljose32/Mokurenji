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
import model.dao.NatEntradaDAO;
import model.dao.NatSaidaDAO;
import model.dao.XmlDAO;
import model.nat.NatEntrada;
import model.nat.NatSaida;

/**
 *
 * @author raul
 */
@WebServlet(name = "ServletNat", urlPatterns = {"/servletNat"})
public class ServletNat extends HttpServlet {

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

        if (request.getParameter("acao").equals("irNat")) {

            NatEntradaDAO dao = new NatEntradaDAO();
            List<NatEntrada> a = dao.buscarNatsEntrada();
            if (a != null) {
                request.setAttribute("natsEntrada", a);
            }
            page = "WEB-INF/natEntrada.jsp";

        } else if (request.getParameter("acao").equals("natEntradaInterno")) {

            NatEntradaDAO dao = new NatEntradaDAO();
            List<NatEntrada> a = dao.buscarNatsEntrada();
            if (a != null) {
                request.setAttribute("natsEntrada", a);
            }
            page = "WEB-INF/natEntrada.jsp";

        } else if (request.getParameter("acao").equals("natSaidaInterno")) {

            NatSaidaDAO dao = new NatSaidaDAO();
            List<NatSaida> a = dao.buscarNatsSaida();
            if (a != null) {
                request.setAttribute("natsSaida", a);
            }
            page = "WEB-INF/natSaida.jsp";

        } else if (request.getParameter("acao").equals("addNatEntrada")) {

            NatEntrada natEntrada = new NatEntrada();
            natEntrada.setIpOrigem(request.getParameter("ipOrigem"));
            natEntrada.setPortaOrigem(Integer.parseInt(request.getParameter("portaOrigem")));
            natEntrada.setIpDestino(request.getParameter("ipDestino"));
            natEntrada.setPortaDestino(Integer.parseInt(request.getParameter("portaDestino")));

            NatEntradaDAO dao = new NatEntradaDAO();
            dao.inserir(natEntrada);

            XmlDAO xmlDao = new XmlDAO();
            xmlDao.xml("natentrada");

            List<NatEntrada> a = dao.buscarNatsEntrada();
            if (a != null) {
                request.setAttribute("natsEntrada", a);
            }

            page = "WEB-INF/natEntrada.jsp";

        } else if (request.getParameter("acao").equals("addNatSaida")) {

            NatSaida natSaida = new NatSaida();
            natSaida.setNomeInterface(request.getParameter("nomeInterface"));

            NatSaidaDAO dao = new NatSaidaDAO();
            dao.inserir(natSaida);

            XmlDAO xmlDao = new XmlDAO();
            xmlDao.xml("natsaida");

            List<NatSaida> a = dao.buscarNatsSaida();
            if (a != null) {
                request.setAttribute("natsSaida", a);
            }

            page = "WEB-INF/natSaida.jsp";

        } else if (request.getParameter("acao").equals("delNatEntrada")) {

            NatEntradaDAO dao = new NatEntradaDAO();

            int idNatEnt = Integer.parseInt(request.getParameter("idNatEnt"));
            NatEntrada nat = dao.buscarNatsEntrada(idNatEnt);
            
            dao.update(nat);
            
            XmlDAO xmlDao = new XmlDAO();
            xmlDao.xml("natentrada");
            
            dao.deletar(nat);

            List<NatEntrada> a = dao.buscarNatsEntrada();
            if (a != null) {
                request.setAttribute("natsEntrada", a);
            }

            page = "WEB-INF/natEntrada.jsp";

        } else if (request.getParameter("acao").equals("delNatSaida")) {

            NatSaidaDAO dao = new NatSaidaDAO();

            int idNatSai = Integer.parseInt(request.getParameter("idNatSai"));

            NatSaida nat = dao.buscarNatsSaida(idNatSai);

            dao.update(nat);

            XmlDAO xmlDao = new XmlDAO();
            xmlDao.xml("natsaida");
            
            dao.deletar(nat);

            List<NatSaida> a = dao.buscarNatsSaida();
            if (a != null) {
                request.setAttribute("natsSaida", a);
            }

            page = "WEB-INF/natSaida.jsp";
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
