/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Petra
 */
@WebServlet(HelloIbaServlet.URL_MAPPING + "/*")
public class HelloIbaServlet extends HttpServlet {

    public static final String URL_MAPPING = "/servlet";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int x = 1;
        if (req.getParameter("x") != null) {
            try {
                x = Integer.parseInt(req.getParameter("x"));
            } catch (NumberFormatException ex) {
                x = 1;
            }
        }
        req.setAttribute("x", x);
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }

}
