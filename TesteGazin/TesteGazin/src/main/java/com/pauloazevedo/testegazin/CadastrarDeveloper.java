package com.pauloazevedo.testegazin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author paulo
 */
public class CadastrarDeveloper extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String id = (String) request.getParameter("idDeveloper");

            if (id != null) {
                
                DeveloperApi devApi=  new DeveloperApi(
                        request.getParameter("nome"),
                        request.getParameter("sexo").charAt(0),
                        request.getParameter("hobby"),
                        request.getParameter("data_nascimento")                       
                );

                try {
                    JSONObject retornoJ = new JSONObject(devApi);
                    String retorno = Util.consultaApiPut(retornoJ.toString(), Util.caminhoAPI() + "/developers/" + id);

                    request.getSession().setAttribute("acertoEspecifico", "acerto");
                    request.getSession().setAttribute("mensagem", "Alterado com sucesso!");
                    response.sendRedirect("./");

                } catch (Exception ex) {
                    request.getSession().setAttribute("erroEspecifico", "erro");
                    request.getSession().setAttribute("mensagem", ex.toString());
                    response.sendRedirect("./");
                }
            } else {
               DeveloperApi devApi=  new DeveloperApi(
                        request.getParameter("nome"),
                        request.getParameter("sexo").charAt(0),
                        request.getParameter("hobby"),
                        request.getParameter("data_nascimento")                       
                );

                try {
                    JSONObject retornoJ = new JSONObject(devApi);
                    String retorno = Util.consultaApiPost(retornoJ.toString(), Util.caminhoAPI() + "/developers");

                    request.getSession().setAttribute("acertoEspecifico", "acerto");
                    request.getSession().setAttribute("mensagem", "Alterado com sucesso!");
                    response.sendRedirect("./");

                } catch (Exception ex) {
                    request.getSession().setAttribute("erroEspecifico", "erro");
                    request.getSession().setAttribute("mensagem", ex.toString());
                    response.sendRedirect("./");
                }
            }

        } catch (Exception ex) {
            request.getSession().setAttribute("erroEspecifico", "erro");
            request.getSession().setAttribute("mensagem", ex.toString());
            response.sendRedirect("./");
        } finally {
            out.close();
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
    
    public class DeveloperApi {
        private String nome;
        private char sexo;
        private String hobby;
        private String dataNascimento;

        public DeveloperApi() {
        }

        public DeveloperApi(String nome, char sexo, String hobby, String dataNascimento) {
            this.nome = nome;
            this.sexo = sexo;
            this.hobby = hobby;
            this.dataNascimento = dataNascimento;
        }
        
        

        public String getNome() {
            return nome;
        }

        public char getSexo() {
            return sexo;
        }

        public String getHobby() {
            return hobby;
        }

        public String getDataNascimento() {
            return dataNascimento;
        }
        
        

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setSexo(char sexo) {
            this.sexo = sexo;
        }

        public void setHobby(String hobby) {
            this.hobby = hobby;
        }

        public void setDataNascimento(String dataNascimento) {
            this.dataNascimento = dataNascimento;
        }
        
        
    }
}
