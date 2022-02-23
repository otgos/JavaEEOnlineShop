package com.upper.servlets.users;


import com.upper.database.UserDBManager;
import com.upper.entity.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ClientAuthServlet", value = "/auth")
public class ClientAuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println(password);
        String redirect = "/login?emailerror";

        Client client = UserDBManager.getClient(email);

        System.out.println(client);

        if(client!=null){
            redirect = "/login?passworderror";
            if(client.getPassword().equals(password)){
                request.getSession().setAttribute("CURRENT_CLIENT", client);
                redirect = "/users/homeClient?success";
            }
        }

        response.sendRedirect(redirect);
    }
}
