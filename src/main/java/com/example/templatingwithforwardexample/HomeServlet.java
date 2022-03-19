package com.example.templatingwithforwardexample;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "homeServlet", value = "/home")
public class HomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String title = "[home:] home";
        String content = "<span><h3>[home:] Welcome to Templating With Forward code example!</h3>" +
                "<p>[home:] This example demonstrates how HTML templating can be achieved using the forward method." +
                "</p></span>";

        request.setAttribute(TemplateServlet.ATTR_TITLE, title);
        request.setAttribute(TemplateServlet.ATTR_CONTENT, content);
        request.getRequestDispatcher("/template").forward(request, response);
    }
}