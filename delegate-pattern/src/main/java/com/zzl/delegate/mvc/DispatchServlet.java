package com.zzl.delegate.mvc;

import com.zzl.delegate.mvc.Controller.OrderController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  做转发
 */
public class DispatchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri = req.getRequestURI();

        String mid = req.getParameter("mid");

        if ("findOrder".equals(uri)) {
            new OrderController().findOrder();
        }

    }
}
