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
import model.classes.Professor;
import model.dao.ProfessorDao;

@WebServlet(name = "ProfServlet", urlPatterns = {"/ProfServlet"})
public class ProfServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = null;
        String acao = request.getParameter("logica");
        ProfessorDao dao = new ProfessorDao();

        if (acao.equals("adicionaProf")) {
            try {
                out = response.getWriter();

                String siape = request.getParameter("siape");
                String nome = request.getParameter("nome");
                String senha = request.getParameter("senha");

                Professor prof = new Professor();
                prof.setSiape(Integer.parseInt(siape));
                prof.setNome(nome);
                prof.setSenha(senha);

                dao.adiciona(prof);

                // ServletContext ctx = getServletContext();
                // ctx.setAttribute("msg", "Professor Cadastrado com sucesso!");
                response.sendRedirect("adicionaProf.jsp");
                // request.getRequestDispatcher("adicionaProf.jsp").forward(request, response);

            } finally {
                if (out != null) {
                    out.close();
                }
            }
        } else if (acao.equals("removeProf")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Professor prof = new Professor();
            prof.setSiape(id);

            dao.remove(prof);

            //ServletContext ctx = getServletContext();
            //  ctx.setAttribute("msg", "Sala Removida com sucesso!");
            List<Professor> profs = dao.getLista();
            request.setAttribute("profs", profs);
            request.getRequestDispatcher("listaProf.jsp").forward(request, response);

        } else if (acao.equals("listaProf")) {

            List<Professor> profs = dao.getLista();

            request.setAttribute("profs", profs);
            request.getRequestDispatcher("listaProf.jsp").forward(request, response);

        } else if (acao.equals("idAlteraProf")) {
            int id = Integer.parseInt(request.getParameter("id"));

            List<Professor> profs = dao.getLista();
            request.setAttribute("profs", profs);
            request.setAttribute("id", id);

            request.getRequestDispatcher("editaProf.jsp").forward(request, response);
            // response.sendRedirect("listaSala.jsp");

        } else if (acao.equals("alteraProf")) {

            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String senha = request.getParameter("senha");

            Professor prof = new Professor();

            prof.setNome(nome);
            prof.setSenha(senha);
            prof.setSiape(id);

            dao.altera(prof);

            List<Professor> profs = dao.getLista();
            request.setAttribute("profs", profs);
            request.getRequestDispatcher("listaProf.jsp").forward(request, response);
            // response.sendRedirect("listaProfessor.jsp");

        } else if (acao.equals("logaProf")) {
            int siape = Integer.parseInt(request.getParameter("siape"));
           
            List<Professor> profs = dao.getLista();

            
           int id = 0;
            for (Professor prof : profs) {
                if(prof.getSiape()==siape){
                    if(prof.getSiape()==siape){
                        id = siape;
                    }else{
                       id = -1;
                    }
                }   
            } 
            for (Professor prof : profs) {
                if(prof.getSiape()==siape){
                    if((prof.getNome().equals(request.getParameter("nome"))) && (prof.getSenha().equals(request.getParameter("senha")))){
                        getServletContext().setAttribute("msgl", ""); 
                        request.getRequestDispatcher("perfil.jsp").forward(request, response); 
                           //response.sendRedirect("header.jsp");
                    }else{
                        getServletContext().setAttribute("msgl", "Algum Campo esta Incorreto!!! Tente Novamente!"); 
                        request.getRequestDispatcher("index.jsp").forward(request, response); 
                    }
                }   else if((id!=siape) && (prof.getSiape()!=siape)){
                  getServletContext().setAttribute("msgl", "Algum Campo esta Incorreto!!! Tente Novamente!");
                    request.getRequestDispatcher("index.jsp").forward(request, response); 
               }
            }
                
                    
            
            

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
