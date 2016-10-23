/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.classes.Equipamento;
import model.dao.EquipamentoDao;

@WebServlet(name = "EquipServlet", urlPatterns = {"/EquipServlet"})
public class EquipServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = null;
        String acao = request.getParameter("logica");
        EquipamentoDao dao = new EquipamentoDao();

        if (acao.equals("adicionaEquipamento")) {
            try {
                out = response.getWriter();

                String nome = request.getParameter("nome");
                String marca = request.getParameter("marca");
                String tipo = request.getParameter("tipo");
                String utilidade = request.getParameter("utilidade");

                Equipamento equip = new Equipamento();
                equip.setNomeEquipamento(nome);
                equip.setMarca(marca);
                equip.setTipo(tipo);
                equip.setUtilidade(utilidade);

                dao.adiciona(equip);

                ServletContext ctx = getServletContext();
                ctx.setAttribute("msg", "Equipamento Cadastrada com sucesso!");

                
                response.sendRedirect("adicionaEquipamento.jsp");
                // request.getRequestDispatcher("adicionaEquipamento.jsp").forward(request, response);

            } finally {
                if (out != null) {
                    out.close();
                }
            }
        } else if (acao.equals("removeEquipamento")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Equipamento equip = new Equipamento();
            equip.setIdEquipamento(id);

            dao.remove(equip);

           // ServletContext ctx = getServletContext();
           // ctx.setAttribute("msg", "Equipamento Removida com sucesso!");

            List<Equipamento> equips = dao.getLista();
            request.setAttribute("equips", equips);
            request.getRequestDispatcher("listaEquipamento.jsp").forward(request, response);

        } else if (acao.equals("listaEquipamento")) {

            List<Equipamento> equips = dao.getLista();

            request.setAttribute("equips", equips);
            request.getRequestDispatcher("listaEquipamento.jsp").forward(request, response);

        } else if (acao.equals("idAlteraEquipamento")) {
            int id = Integer.parseInt(request.getParameter("id"));

            List<Equipamento> equips = dao.getLista();
            request.setAttribute("equips", equips);
            request.setAttribute("id", id);

            request.getRequestDispatcher("editaEquipamento.jsp").forward(request, response);
            // response.sendRedirect("listaSala.jsp");

        } else if (acao.equals("alteraEquipamento")) {

            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String marca = request.getParameter("marca");
            String tipo = request.getParameter("tipo");
            String utilidade = request.getParameter("utilidade");

            Equipamento equip = new Equipamento();

            equip.setNomeEquipamento(nome);
            equip.setMarca(marca);
            equip.setTipo(tipo);
            equip.setUtilidade(utilidade);
            equip.setIdEquipamento(id);

            dao.altera(equip);

            List<Equipamento> equips = dao.getLista();
            request.setAttribute("equips", equips);
            request.getRequestDispatcher("listaEquipamento.jsp").forward(request, response);

// response.sendRedirect("listaSala.jsp");
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
