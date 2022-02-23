package com.upper.servlets.users;

import com.upper.database.UserDBManager;
import com.upper.entity.Client;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

@WebServlet(name = "ClientRegisterServlet", value = "/clientRegister")
public class ClientRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/clientRegister.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String phonenumber = request.getParameter("phoneNumber");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("rePassword");
//        Date startDate = Date.valueOf(request.getParameter("startDate"));

        String redirect = "/clientRegister?passworderror";
        if(password.equals(rePassword)) {
            redirect = "/clientRegister?emailerror";
            Client client = UserDBManager.getClient(email);
            if (client == null) {
                Client newClient = new Client(null, fName, lName, phonenumber, gender, address, email, password);
                if (UserDBManager.addClient(newClient)) {
                    request.getSession().setAttribute("CURRENT_CLIENT", client);
                    redirect = "/?success";
                    System.out.println(newClient);
                }
            }

        }

        response.sendRedirect(redirect);

    }

}
