package com.example.templatingwithforwardexample;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TemplateServlet", value = "/template")
public class TemplateServlet extends HttpServlet {

    public static final String ATTR_TITLE = "title";
    public static final String ATTR_CONTENT = "content";
    public static final String ATTR_ADDITIONAL_SCRIPT = "additionalScript";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String title = (String) request.getAttribute(ATTR_TITLE);
        String content = (String) request.getAttribute(ATTR_CONTENT);
        String additionalScriptPath = (String) request.getAttribute(ATTR_ADDITIONAL_SCRIPT);

        out.println("<html><head><title>" + title + "</title></head>");
        out.println("<body><div class=\"container\">");
        out.println("<header class=\"site-header\"><h1>[template:] Site Logo</h1></header>");
        out.println("<div class\"content\">" + content + "</div>");
        out.println("<script src=\"main.js\"></script>");
        if (additionalScriptPath != null) {
            out.println("<script src=\"" + additionalScriptPath + "\"></script>");
        }
        out.println("</div></body>"); // closing the container div and the body element
        out.println("</html>");  // closing the html element

        out.close();
    }
}
