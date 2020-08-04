package com.pauloazevedo.testegazin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author paulo
 */
public class ListarDevelopersApi extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            PrintWriter out = response.getWriter();
            response.setHeader("Content-Type", "application/json");
            response.setCharacterEncoding("UTF-8");
            String paginaAtual = (String) request.getParameter("paginaAtual");
            String descricao = (String) request.getParameter("descricao");
            JSONArray arrayObj = new JSONArray();
            String consulta = "";
            if (descricao == null || descricao.equals("")) {
                consulta = Util.consultaApiGet(null, Util.caminhoAPI() + "/developers?page=" + paginaAtual);
            } else {
                consulta = Util.consultaApiGet(null, Util.caminhoAPI() + "/developers?descricao="+ descricao + "&page=" + paginaAtual);
            }
            JSONObject retornoJ = new JSONObject(consulta);
            Integer pageNumber = retornoJ.getJSONObject("pageable").getInt("pageNumber");
            Integer totalPages = retornoJ.getInt("totalPages");
            retornoJ.put("paginaAtual", pageNumber);
            retornoJ.put("descricao", descricao);
            retornoJ.put("anterior", pageNumber == 0 ? pageNumber : pageNumber - 1);
            retornoJ.put("proxima", pageNumber == totalPages - 1 ? pageNumber : pageNumber + 1);
            retornoJ.put("totalElements", retornoJ.getInt("totalElements"));
            arrayObj.put(retornoJ);
            out.println(arrayObj.toString());
            out.close();
        } catch (Exception ex) {
            System.out.println(ex);
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
