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
import model.classes.Sala;
import model.dao.SalaDao;

@WebServlet(name = "SalaServlet", urlPatterns = {"/SalaServlet"})
public class SalaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = null;
        String acao = request.getParameter("logica");
        SalaDao dao = new SalaDao();

        if (acao.equals("adicionaSala")) {
            try {
                out = response.getWriter();

                String nome = request.getParameter("nome");
                String localizacao = request.getParameter("localizacao");
                String capacidade = request.getParameter("capacidade");
                String tipo = request.getParameter("tipo");

                Sala sala = new Sala();
                sala.setNome(nome);
                sala.setLocalizacao(localizacao);
                sala.setCapacidade((Integer.parseInt(capacidade)));
                sala.setTipo(tipo);

                dao.adiciona(sala);

                ServletContext ctx = getServletContext();
                ctx.setAttribute("msg", "Sala Cadastrada com sucesso!");

                //HttpSession session = request.getSession();
                //session.setAttribute("msg", "Sala cadastrada com sucessso");
                //request.getSession().setAttribute("msg", "Salas Cadastrada com sucesso!");
                //getServletContext().getRequestDispatcher("/adicionaSala.jsp").forward(request, response);
                //chama a página
                response.sendRedirect("adicionaSala.jsp");
                // request.getRequestDispatcher("adicionaSala.jsp").forward(request, response);

            } finally {
                if (out != null) {
                    out.close();
                }
            }
        }else if(acao.equals("removeSala")){
              int id = Integer.parseInt(request.getParameter("id"));
       Sala sala = new Sala();
       sala.setIdSala(id);
       
       dao.remove(sala);
       
       ServletContext ctx = getServletContext();
            ctx.setAttribute("msg", "Sala Removida com sucesso!");
            
            
            List<Sala> salas = dao.getLista();
             request.setAttribute("salas", salas);
            request.getRequestDispatcher("listaSala.jsp").forward(request, response);
        
        
        
        } else if (acao.equals("listaSala")) {

            List<Sala> salas = dao.getLista();
            
            request.setAttribute("salas", salas);
            request.getRequestDispatcher("listaSala.jsp").forward(request, response);

       
        
        
        
        }  else if (acao.equals("idAlteraSala")) {
            int id = Integer.parseInt(request.getParameter("id"));

            List<Sala> salas = dao.getLista();
            request.setAttribute("editar", salas);
            request.setAttribute("id", id);

            request.getRequestDispatcher("editaSala.jsp").forward(request, response);
            // response.sendRedirect("listaSala.jsp");

           
            
            
        } else if (acao.equals("alteraSala")) {
            
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String localizacao = request.getParameter("localizacao");
            int capacidade = Integer.parseInt(request.getParameter("capacidade"));
            String tipo = request.getParameter("tipo");

            Sala sala = new Sala();
            
            sala.setNome(nome);
            sala.setLocalizacao(localizacao);
            sala.setCapacidade(capacidade);
            sala.setTipo(tipo);
            sala.setIdSala(id);
            
            dao.altera(sala);

            List<Sala> salas = dao.getLista();
            request.setAttribute("salas", salas);
            request.getRequestDispatcher("listaSala.jsp").forward(request, response);
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
