package com.upper.servlets.users;

import com.upper.entity.Client;
import com.upper.entity.Items;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "ClientProfileServlet", value = "/clientprofile")
public class ClientProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Client currentClient = (Client) request.getSession().getAttribute("CURRENT_CLIENT");
        HttpSession cardSession = request.getSession();
        ArrayList<Items> cardItems = (ArrayList<Items>) cardSession.getAttribute("cardList");

        System.out.println("Shopping list items: "+cardItems);
        if(currentClient!=null){
            request.getRequestDispatcher("/clientprofile.jsp").forward(request, response);
        }else{
            response.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
